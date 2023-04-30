package Engine;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;
import static org.lwjgl.opengl.GL30.glBindVertexArray;

public class ObjectAris extends ShaderProgram{
    List<Vector3f> vertices;

    int vao;

    int vbo;

    Vector4f color;

    List <Vector3f> verticesColor;

    UniformsMap uniformsMap;

    int vboColor;

    Matrix4f model;

    List<Object> childObject;

    public Vector3f updateCenterPoint() {
        Vector3f centerTemp = new Vector3f();
        model.transformPosition(0.0f,0.0f,0.0f,centerTemp);
        return centerTemp;
    }

    public ObjectAris(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
        this.color = color;
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        uniformsMap.createUniform("model");
        uniformsMap.createUniform("view");
        uniformsMap.createUniform("projection");
        model = new Matrix4f();
        childObject = new ArrayList<>();
    }

    public ObjectAris(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.verticesColor = verticesColor;
        setupVAOVBOWithVerticesColor();
    }

    public void setupVAOVBO() {
        this.vao = glGenVertexArrays();
        glBindVertexArray(vao);

        this.vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);
    }

    public void setupVAOVBOWithVerticesColor() {
        this.vao = glGenVertexArrays();
        glBindVertexArray(vao);

        this.vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);

        this.vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(verticesColor), GL_STATIC_DRAW);
    }

    public void drawSetup() {
        bind();
        uniformsMap.setUniform("uni_color", color);
        uniformsMap.setUniform("model", model);
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
    }

    public void drawSetup(Camera camera, Projection projection) {
        bind();
        uniformsMap.setUniform("uni_color", color);
        uniformsMap.setUniform("model", model);
        uniformsMap.setUniform("view", camera.getViewMatrix());
        uniformsMap.setUniform("projection", projection.getProjMatrix());
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
    }

    public void drawSetupWithVerticesColor() {
        bind();

        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);

        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glVertexAttribPointer(1, 3, GL_FLOAT, false, 0, 0);
    }

    public void draw() {
        drawSetup();
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_TRIANGLE_FAN, 0, vertices.size());
        for(Object child: childObject) {
            child.draw();
        }
    }

    public void draw(Camera camera, Projection projection) {
        drawSetup(camera,projection);
        // Draw the vertices
        // Optional
        glLineWidth(1);//Ketebalan garis
        glPointSize(0);//Besar kecil vertex
        //wajib
        //GL_LINES
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLE_FAN
        //GL_POINT
        glDrawArrays(GL_POLYGON,0,
                vertices.size());
    }

    public void drawWithVerticesColor() {
        drawSetupWithVerticesColor();
        glLineWidth(10);
        glPointSize(10);
        glDrawArrays(GL_TRIANGLE_FAN, 0, vertices.size());
    }

    public void drawLine() {
        drawSetup();
        glLineWidth(15);
        glPointSize(0);
        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
    }

    public void addVertices(Vector3f newVector) {
        vertices.add(newVector);
        setupVAOVBO();
    }

    public void update(int index, Vector3f newVector) {
        vertices.set(index, newVector);
        setupVAOVBO();
    }

    public void translateObject(float offsetX, float offsetY, float offsetZ) {
        model = new Matrix4f().translate(offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
        for(Object child: childObject) {
            child.translateObject(offsetX, offsetY, offsetZ);
        }
    }

    public void rotateObject(float degree, float offsetX, float offsetY, float offsetZ) {
        model = new Matrix4f().rotate(degree, offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
        for(Object child: childObject) {
            child.rotateObject(degree, offsetX, offsetY, offsetZ);
        }
    }

    public void scaleObject(float x, float y, float z) {
        model = new Matrix4f().scale(x, y, z).mul(new Matrix4f(model));
        for(Object child: childObject) {
            child.scaleObject(x, y, z);
        }
    }

    public List<Object> getChildObject() {
        return childObject;
    }

    public void setChildObject(List<Object> childObject) {
        this.childObject = childObject;
    }
}