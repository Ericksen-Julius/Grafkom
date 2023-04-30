package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class Circle extends Object2d{

    float r;

    public float xr;
    public float yr;




    public Circle (List<ShaderModuleData> shaderModuleDataList, Vector4f color, float r){
        super(shaderModuleDataList,color);
        this.r = r;
        this.vertices = new ArrayList<>();
    }
    public Circle (List<ShaderModuleData> shaderModuleDataList, Vector4f color,float xr,float yr){
        super(shaderModuleDataList,color);
        this.vertices = new ArrayList<>();
        this.yr = yr;
        this.xr = xr;
//        createRectangle(this.xr,this.yr);
    }
    public Circle (List<ShaderModuleData> shaderModuleDataList, Vector4f color,float xr,float yr,float r){
        super(shaderModuleDataList,color);
        this.r = r;
        this.vertices = new ArrayList<>();
        this.yr = yr;
        this.xr = xr;
    }
    public Circle (List<ShaderModuleData> shaderModuleDataList, Vector4f color){
        super(shaderModuleDataList,color);
        this.vertices = new ArrayList<>();
        this.color = color;
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
    public void createTriangle(float xR, float yR){
        double x,y;
        for(double i = 90;i<360;i+=120){
            double blah = Math.toRadians(i);
            x = .3f * Math.cos(blah) + xR;
            y = .3f * Math.sin(blah) + yR;
            this.vertices.add(new Vector3f((float)x,(float)y,0.0f));
        }
        setupVAOVBO();
    }
    public void createRectangle(float xR, float yR){
        this.vertices.clear();
        double x,y;
        for(double i = 45;i<360;i+=90){
            double blah = Math.toRadians(i);
            x = .1f * Math.cos(blah) + xR;
            y = .1f * Math.sin(blah) + yR;
            this.vertices.add(new Vector3f((float)x,(float)y,0.0f));
        }
        setupVAOVBO();
    }
    public void createRoundedRectangle(float xR, float yR, float radius) {
        this.vertices.clear();
        double x,y;
        float halfWidth = 0.1f - radius;
        float halfHeight = 0.1f - radius;
        for(double i = 45;i<360;i+=90){
            double angle = Math.toRadians(i);
            float xDir = (float)Math.cos(angle);
            float yDir = (float)Math.sin(angle);
            float xCenter = xR + xDir * halfWidth;
            float yCenter = yR + yDir * halfHeight;
            for (double j = i; j < i + 90; j += 90.0 / 1.5) {
                double cornerAngle = Math.toRadians(j);
                x = xCenter + radius * (float)Math.cos(cornerAngle);
                y = yCenter + radius * (float)Math.sin(cornerAngle);
                this.vertices.add(new Vector3f((float)x,(float)y,0.0f));
            }
        }
        setupVAOVBO();
    }

    public void change(float xR, float yR){
        this.xr = xR;
        this.yr = yR;
        createRectangle(this.xr,this.yr);
    }

    public void curve(float[] controlPoints) {
        int n = 20; // jumlah titik pada kurva
        ArrayList<Vector3f> vertices = new ArrayList<>();

        int numPoints = controlPoints.length / 2;

        if (numPoints < 3) {
            // jika jumlah titik kontrol kurang dari 3, maka tidak dapat dibuat kurva
            System.out.println("Jumlah titik kontrol minimal 3");
            return;
        }

        // loop through each pair of control points
        for (int i = 0; i < numPoints - 2; i++) {
            int index = i * 2;
            float x0 = controlPoints[index];
            float y0 = controlPoints[index + 1];
            float x1 = controlPoints[index + 2];
            float y1 = controlPoints[index + 3];
            float x2 = controlPoints[index + 4];
            float y2 = controlPoints[index + 5];

            for (int j = 0; j <= n; j++) {
                float t = (float) j / (float) n;
                float x = (1 - t) * (1 - t) * x0 + 2 * (1 - t) * t * x1 + t * t * x2;
                float y = (1 - t) * (1 - t) * y0 + 2 * (1 - t) * t * y1 + t * t * y2;
                vertices.add(new Vector3f(x, y, 0));
            }
        }

        this.vertices = vertices;
        setupVAOVBO();
    }






    public void createRectangle2(ArrayList<CekKotak>kotak,Lines lines){
        double x,y;
        int test = 1;
        for(CekKotak object : kotak){
//            if (this.xr + .1f <= object.xr + object.r && this.xr + .1f >= object.xr - object.r && this.xr + .1f <= object.yr + object.r && this.xr + .1f >= object.yr - object.r) {
//                System.out.println("error1");
//                return;
//            }
//            if (this.xr - .1f <= object.xr + object.r && this.xr - .1f >= object.xr - object.r && this.xr - .1f <= object.yr + object.r && this.xr - .1f >= object.yr - object.r) {
//                System.out.println("error2");
//                return;
//            }
//            if (this.yr + .1f <= object.xr + object.r && this.yr + .1f >= object.xr - object.r && this.yr + .1f <= object.yr + object.r && this.yr + .1f >= object.yr - object.r) {
//                System.out.println("error3");
//                return;
//            }
//            if (this.yr - .1f <= object.xr + object.r && this.yr - .1f >= object.xr - object.r && this.yr - .1f <= object.yr + object.r && this.yr - .1f >= object.yr - object.r) {
//                System.out.println("error4");
//                return;
//            }
        }

        for(double i = 45;i<360;i+=90){
            double blah = Math.toRadians(i);
            x = .1f * Math.cos(blah) + xr;
            y = .1f * Math.sin(blah) + yr;
            this.vertices.add(new Vector3f((float)x,(float)y,0.0f));
        }
        kotak.add(new CekKotak(this.xr,this.yr,.1f));
        lines.createLine(this.xr,this.yr);
        setupVAOVBO();
    }

    public void createStar(float xR, float yR){
        double x,y,t,d;
        for(double i = 0;i<360;i+=72){
            double blah = Math.toRadians(i);
            x = .3f * Math.cos(blah) + xR;
            y = .3f * Math.sin(blah) + yR;
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
        glDrawArrays(GL_POLYGON,0,
                vertices.size());
    }
    public void drawStar(){
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
        glDrawArrays(GL_LINE_STRIP,0,
                vertices.size());
    }
}