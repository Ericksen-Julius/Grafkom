package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class Lines extends Object2d{

    float x,y;

    public Lines(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList, vertices, color);
    }
    public Lines(List<ShaderModuleData> shaderModuleDataList, Vector4f color) {
        super(shaderModuleDataList, color);
        this.vertices = new ArrayList<>();
    }

    public void createLine(float x, float y){
        this.vertices.add(new Vector3f(x,y,0f));
        setupVAOVBO();
    }

    @Override
    public void draw() {
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
    public void drawLoop() {
        drawSetup();
        // Draw the vertices
        // Optional
        glLineWidth(1);//Ketebalan garis
        glPointSize(1);//Besar kecil vertex
        //wajib
        //GL_LINES
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLE_FAN
        //GL_POINT
        glDrawArrays(GL_LINE_LOOP,0,
                vertices.size());
    }
}
