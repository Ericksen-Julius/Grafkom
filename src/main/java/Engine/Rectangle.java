package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL15.*;

public class Rectangle extends Object2d{

    List<Integer> index;

    float xR, yR;

    int ibo;

    public Rectangle (List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Integer> index){
        super(shaderModuleDataList,vertices,color);
        this.index = index;
        this.ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,this.ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,Utils.listoInt(index),GL_STATIC_DRAW);
    }
    public Rectangle (List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Integer> index,float xR, float yR){
        super(shaderModuleDataList,vertices,color);
        this.index = index;
        this.ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,this.ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,Utils.listoInt(index),GL_STATIC_DRAW);
        this.yR = yR;
        this.xR = xR;
        createRectangle();
    }


    public void createRectangle(){
        double x,y;
        for(double i = 45;i<360;i+=90){
            double blah = Math.toRadians(i);
            x = .1f * Math.cos(blah) + this.xR;
            y = .1f * Math.sin(blah) + this.yR;
            this.vertices.add(new Vector3f((float)x,(float)y,0.0f));
        }
        setupVAOVBO();
    }

    public void draw(){
        drawSetup();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,this.ibo);
        glDrawElements(GL_TRIANGLES,index.size(),GL_UNSIGNED_INT,0);
    }
}
