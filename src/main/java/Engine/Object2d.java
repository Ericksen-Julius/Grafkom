package Engine;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class Object2d extends ShaderProgram{

    List<Vector3f> vertices;

    int vao;
    int vbo;

    Vector4f color;

    List<Vector3f> verticesColor;

    UniformsMap uniformsMap;

    Matrix4f model;
    List<Object2d> childObject;

    int vboColor;

    public Vector3f updateCenterPoint(){
        Vector3f centerTemp = new Vector3f();
        model.transformPosition(0.0f,0.0f,0.0f,centerTemp);
        return centerTemp;
    }
    public Object2d(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices,Vector4f color){
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
    public Object2d(List<ShaderModuleData> shaderModuleDataList,Vector4f color){
        super(shaderModuleDataList);
        this.color = color;
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        uniformsMap.createUniform("model");
        uniformsMap.createUniform("view");
        uniformsMap.createUniform("projection");
        model = new Matrix4f();
        childObject = new ArrayList<>();

    }


    public Object2d(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices,List<Vector3f> verticesColor){
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.verticesColor = verticesColor;
        setupVAOVBOWithVerticesColor();

    }

    public void setupVAOVBO(){
        this.vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        this.vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(vertices),
                GL_STATIC_DRAW);

    }

    public void setupVAOVBOWithVerticesColor(){
        this.vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        this.vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(vertices),
                GL_STATIC_DRAW);

        this.vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER,vboColor);
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(verticesColor),
                GL_STATIC_DRAW);

    }


    public void drawSetupCamera(Camera camera, Projection projection){
        bind();
        uniformsMap.setUniform("uni_color",color);
        uniformsMap.setUniform("model",model);
        uniformsMap.setUniform("view",camera.getViewMatrix());
        uniformsMap.setUniform("projection",projection.getProjMatrix());
        //Bind vbo
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glVertexAttribPointer(0,3,GL_FLOAT,false,0,0);
    }
    public void drawSetup(){
        bind();
        uniformsMap.setUniform("uni_color",color);
        uniformsMap.setUniform("model",model);
        //Bind vbo
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glVertexAttribPointer(0,3,GL_FLOAT,false,0,0);
    }

    public void drawSetupWithVerticesColor(){
        bind();
//        uniformsMap.setUniform("uni_color",color);
        //Bind vbo
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glVertexAttribPointer(0,3,GL_FLOAT,false,0,0);

        //Bind vboColor
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER,vboColor);
        glVertexAttribPointer(1,3,GL_FLOAT,false,0,0);
    }

    public void draw(){
        drawSetup();
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
        for(Object2d object : this.childObject){
            object.draw();
        }
    }
    public void drawwithCamera(Camera camera, Projection projection){
        drawSetupCamera(camera,projection);
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
        for(Object2d object : childObject){
            object.drawwithCamera(camera,projection);
        }
    }
    public void drawwithCameraLine(Camera camera, Projection projection){
        drawSetupCamera(camera,projection);
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
        glDrawArrays(GL_LINE_STRIP,0,
                vertices.size());
        for(Object2d object : childObject){
            object.drawwithCamera(camera,projection);
        }
    }
    public void drawLine(){
        drawSetup();
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
        glDrawArrays(GL_LINE_STRIP,0,
                vertices.size());
    }

    public void addVertices(Vector3f newVector){
        vertices.add(newVector);
        setupVAOVBO();
    }
    public void translateObject(Float offsetX, Float offsetY, Float offsetZ) {
        model = new Matrix4f().translate(offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
        for(Object2d object2d : childObject){
            object2d.translateObject(offsetX, offsetY, offsetZ);
        }
    }
    public void rotateObject(Float degree,Float offsetX, Float offsetY, Float offsetZ) {
        model = new Matrix4f().rotate(degree,offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
        for(Object2d object2d : childObject){
            object2d.rotateObject(degree,offsetX, offsetY, offsetZ);
        }
    }
    public void scaleObject(Float x, Float y, Float z) {
        model = new Matrix4f().scale(x, y, z).mul(new Matrix4f(model));
        for(Object2d object2d : childObject){
            object2d.translateObject(x, y, z);
        }
    }

    public List<Object2d> getChildObject() {
        return childObject;
    }

    public void setChildObject(List<Object2d> childObject) {
        this.childObject = childObject;
    }

    public void drawWithVerticesColor(){
        drawSetupWithVerticesColor();
        // Draw the vertices
        // Optional
        glLineWidth(10);//Ketebalan garis
        glPointSize(10);//Besar kecil vertex
        //wajib
        //GL_LINES
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLE_FAN
        //GL_POINT
        glDrawArrays(GL_TRIANGLES,0,
                vertices.size());
    }
    public void update(int index, Vector3f newVector){
        vertices.set(index,newVector);
        setupVAOVBO();
    }
}
