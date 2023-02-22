package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class Circle extends Object2d{

    float r;



    public Circle (List<ShaderModuleData> shaderModuleDataList, Vector4f color, float r){
        super(shaderModuleDataList,color);
        this.r = r;
        this.color = color;
        this.vertices = new ArrayList<>();
    }

    public void createCircle(float xR, float yR){
        double x,y;
        for(double i = 0;i<2*Math.PI;i+=Math.PI/360){
            x = r * Math.cos(i) + xR;
            y = r * Math.sin(i) + yR;
            this.vertices.add(new Vector3f((float)x,(float)y,0.0f));
        }
        setupVAOVBO();
    }
    public void createOval(float xR, float yR,float width,float height){
        double x,y;
        for(double i = 0;i<2*Math.PI;i+=Math.PI/360){
            x = width * Math.cos(i) + xR;
            y = height * Math.sin(i) + yR;
            this.vertices.add(new Vector3f((float)x,(float)y,0.0f));
        }
        setupVAOVBO();
    }
    public void draw(){
        drawSetup();
        // Draw the vertices
        // Optional
        glLineWidth(0);//Ketebalan garis
        glPointSize(1);//Besar kecil vertex
        //wajib
        //GL_LINES
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLE_FAN
        //GL_POINT
        glDrawArrays(GL_TRIANGLE_FAN,0,
                vertices.size());
    }
}
