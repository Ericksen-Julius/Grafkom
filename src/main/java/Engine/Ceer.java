package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;

public class Ceer extends Circle2 {

    float rz;
    public float centerZ;

    List<Integer> index;

    int ibo;
    int bentuk;
    int left;

    public Ceer(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float rx, float ry, float centerX, float centerY, float centerZ,float rz,int bentuk,int left) {
        super(shaderModuleDataList, vertices, color, rx, ry, centerX, centerY);
        this.centerZ = centerZ;
        this.rz = rz;
        this.bentuk = bentuk;
        this.left = left;
//        createBox();
        if(bentuk == 1){
            createEllipsoid(rx, ry, rz, centerX, centerY, centerZ);
        } else if (bentuk ==2) {
            createBox();
        }else if(bentuk == 3){
            createHalfEllipsoid();
        }else if(bentuk == 4 ){
            createCeer();
        }else if(bentuk ==5){
            createHalfEllipsoid2();
        }else if(bentuk ==6){
            createSlantedEllipsoid(left);
        }else if(bentuk == 7){
            createTrapezoid();
        }
//        createCeer();
//        createHyperboloid1();
//        createHyperboloid2();
//        createEllipticCone();
//        createEllipticParaboloid();
//        createHyperboloidParaboloid();
        setupVAOVBO();
    }

    public void createTrapezoid() {
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();

        // titik 1 bawah kiri belakang
        temp.x = centerX - rx / 2;
        temp.y = centerY - ry / 2;
        temp.z = centerZ - rz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // titik 2 bawah kanan belakang
        temp.x = centerX + rx / 2;
        temp.y = centerY - ry / 2;
        temp.z = centerZ - rz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // titik 3 atas kanan belakang
        temp.x = centerX + 3*rx / 8;
        temp.y = centerY + ry / 2;
        temp.z = centerZ - rz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // titik 4 atas kiri belakang
        temp.x = centerX - 3*rx / 8;
        temp.y = centerY + ry / 2;
        temp.z = centerZ - rz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // titik 5 bawah kiri depan
        temp.x = centerX - rx / 4;
        temp.y = centerY - ry / 2;
        temp.z = centerZ + rz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // titik 6 bawah kanan depan
        temp.x = centerX + rx / 4;
        temp.y = centerY - ry / 2;
        temp.z = centerZ + rz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // titik 7 atas kanan depan
        temp.x = centerX + rx / 8;
        temp.y = centerY + ry / 2;
        temp.z = centerZ + rz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // titik 8 atas kiri depan
        temp.x = centerX - rx / 8;
        temp.y = centerY + ry / 2;
        temp.z = centerZ + rz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // kotak belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(0));

        // kotak depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(4));

        // trapesium samping kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));

        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(7));

        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));

        //kotak atas
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(4));

        //kotak bawah
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(0));

        //kotak samping kiri atas
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(4));

        //kotak samping kiri bawah
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(1));

        //kotak samping kanan atas
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(3));

        //kotak samping kanan bawah
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(0));
    }

    public void createSlantedEllipsoid(int left){
        vertices.clear();
        float theta = 0f;
        if (left == 1){
            theta = -(float)Math.PI/4; // angle of rotation around z-axis
        }else{
            theta = (float)Math.PI/4; // angle of rotation around z-axis
        }
        ArrayList<Vector3f> temp = new ArrayList<>();
        float phi = (float)Math.PI/8; // angle of rotation around x-axis

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = rx * (float)(Math.cos(v) * Math.cos(u + theta));
                float y = ry * (float)(Math.cos(v - phi) * Math.sin(u));
                float z = rz * (float)(Math.sin(v - phi));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }
    public void draw() {
        drawSetup();
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_POLYGON, 0, vertices.size());
        for(Object child: childObject) {
            child.draw();
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
        for(Object object : childObject){
            object.drawwithCamera(camera,projection);
        }
    }

    public void createHalfEllipsoid(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= 0; v+=Math.PI/60){
            for(double u = -Math.PI; u<= 0; u+=Math.PI/60){
                float x = rx * (float)(Math.cos(v) * Math.cos(u));
                float y = ry * (float)(Math.cos(v) * Math.sin(u));
                float z = rz * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }

    public void createHalfEllipsoid2(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= 0; v+=Math.PI/60){
            for(double u = -Math.PI; u<= 0; u+=Math.PI/60){
                float x = rx * (float)(Math.cos(v) * Math.cos(u));
                float y = -ry * (float)(Math.cos(v) * Math.sin(u));
                float z = rz * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }

    public float getCenterZ() {
        return centerZ;
    }

    public void createBox() {
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> temoVertices = new ArrayList<>();

        //titik 1 kiri atas belakang
        temp.x = centerX - rx / 2;
        temp.y = centerY + ry / 2;
        temp.z = centerZ - rz / 2;
        temoVertices.add(temp);
        temp = new Vector3f();

        //titik 2 kiri bawah belakang
        temp.x = centerX - rx / 2;
        temp.y = centerY - ry / 2;
        temp.z = centerZ - rz / 2;
        temoVertices.add(temp);
        temp = new Vector3f();

        //titik 3 kanan bawah belakang
        temp.x = centerX + rx / 2;
        temp.y = centerY - ry / 2;
        temp.z = centerZ - rz / 2;
        temoVertices.add(temp);
        temp = new Vector3f();

        //titik 4 kanan atas belakang
        temp.x = centerX + rx / 2;
        temp.y = centerY + ry / 2;
        temp.z = centerZ - rz / 2;
        temoVertices.add(temp);
        temp = new Vector3f();

        //titik 5 kiri atas depan
        temp.x = centerX - rx / 2;
        temp.y = centerY + ry / 2;
        temp.z = centerZ + rz / 2;
        temoVertices.add(temp);
        temp = new Vector3f();

        //titik 6 kiri bawah depan
        temp.x = centerX - rx / 2;
        temp.y = centerY - ry / 2;
        temp.z = centerZ + rz / 2;
        temoVertices.add(temp);
        temp = new Vector3f();

        //titik 7 kanan bawah depan
        temp.x = centerX + rx / 2;
        temp.y = centerY - ry / 2;
        temp.z = centerZ + rz / 2;
        temoVertices.add(temp);
        temp = new Vector3f();

        //titik 8 kanan atas depan
        temp.x = centerX + rx / 2;
        temp.y = centerY + ry / 2;
        temp.z = centerZ + rz / 2;
        temoVertices.add(temp);
        temp = new Vector3f();

        //kotak belakang
        vertices.add(temoVertices.get(0));
        vertices.add(temoVertices.get(1));
        vertices.add(temoVertices.get(2));

        vertices.add(temoVertices.get(2));
        vertices.add(temoVertices.get(3));
        vertices.add(temoVertices.get(0));

        //kotak depan
        vertices.add(temoVertices.get(4));
        vertices.add(temoVertices.get(5));
        vertices.add(temoVertices.get(6));

        vertices.add(temoVertices.get(6));
        vertices.add(temoVertices.get(7));
        vertices.add(temoVertices.get(4));

        //kotak samping kiri
        vertices.add(temoVertices.get(0));
        vertices.add(temoVertices.get(1));
        vertices.add(temoVertices.get(4));

        vertices.add(temoVertices.get(1));
        vertices.add(temoVertices.get(5));
        vertices.add(temoVertices.get(4));

        //kotak samping kanan
        vertices.add(temoVertices.get(7));
        vertices.add(temoVertices.get(6));
        vertices.add(temoVertices.get(2));

        vertices.add(temoVertices.get(2));
        vertices.add(temoVertices.get(3));
        vertices.add(temoVertices.get(7));

        //kotak atas
        vertices.add(temoVertices.get(4));
        vertices.add(temoVertices.get(7));
        vertices.add(temoVertices.get(3));

        vertices.add(temoVertices.get(3));
        vertices.add(temoVertices.get(0));
        vertices.add(temoVertices.get(4));

        //kotak bawah
        vertices.add(temoVertices.get(5));
        vertices.add(temoVertices.get(6));
        vertices.add(temoVertices.get(2));

        vertices.add(temoVertices.get(2));
        vertices.add(temoVertices.get(1));
        vertices.add(temoVertices.get(5));
    }

    public void createCeer() {
        ArrayList<Vector3f> temp = new ArrayList<>();
        int stackCount = 18, sectorCount = 36;
        float x, y, z, xy, nx, ny, nz;
        float sectorStep = (float) (2 * Math.PI) / sectorCount; //sector count
        float stackStep = (float) Math.PI / stackCount; // stack count
        float sectorAngle, stackAngle;

        for (int i = 0; i <= stackCount; i++) {
            stackAngle = (float) Math.PI / 2 - i * stackStep;
            xy = (float) (0.5f * Math.cos(stackAngle));
            z = (float) (0.5f * Math.sin(stackAngle));
            for (int j = 0; j < sectorCount; j++) {
                sectorAngle = j * sectorStep;
                x = (float) (xy * Math.cos(sectorAngle));
                y = (float) (xy * Math.sin(sectorAngle));
                temp.add(new Vector3f(x, y, z));
            }
        }

        vertices = temp;

        int k1, k2;
        ArrayList<Integer> temp_indices = new ArrayList<>();
        for (int i = 0; i < stackCount; i++) {
            k1 = i * (sectorCount + 1);
            k2 = k1 + sectorCount + 1;

            for (int j = 0; j < sectorCount; ++j, ++k1, ++k2) {
                if (i != 0) {
                    temp_indices.add(k1);
                    temp_indices.add(k2);
                    temp_indices.add(k1 + 1);
                }
                if (i != (18 - 1)) {
                    temp_indices.add(k1 + 1);
                    temp_indices.add(k2);
                    temp_indices.add(k2 + 1);
                }
            }
        }
        this.index = temp_indices;
        this.ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, this.ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Utils.listoInt(index), GL_STATIC_DRAW);
    }

    public void createEllipsoid(float rx, float ry, float rz, float centerX, float centerY, float centerZ) {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 60) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 60) {
                float x = centerX + rx * (float) (Math.cos(v) * Math.cos(u));
                float y = centerY + ry * (float) (Math.cos(v) * Math.sin(u));
                float z = centerZ + rz * (float) (Math.sin(v));
                temp.add(new Vector3f(x, y, z));
            }
        }
        vertices = temp;
    }

    public void createHyperboloid1() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 60) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 60) {
                float x = 0.1f * (float) ((1/Math.cos(v)) * Math.cos(u));
                float z = 0.1f * (float) ((1/Math.cos(v)) * Math.sin(u));
                float y = 0.1f * (float) (Math.tan(v));
                temp.add(new Vector3f(x, y, z));
            }
        }
        vertices = temp;
    }

    public void createHyperboloid2() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 16) {
            for (double u = -Math.PI/2; u <= Math.PI/2; u += Math.PI / 16) {
                float x = 0.1f * (float) (Math.tan(v) * Math.cos(u));
                float z = 0.1f * (float) (Math.tan(v) * Math.sin(u));
                float y = 0.1f * (float) (1/Math.cos(v));
                temp.add(new Vector3f(x, y, z));
            }
        }
        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 36) {
            for (double u = Math.PI/2; u <= 3*Math.PI/2; u += Math.PI / 36) {
                float x = 0.1f * (float) (Math.tan(v) * Math.cos(u));
                float z = 0.1f * (float) (Math.tan(v) * Math.sin(u));
                float y = -0.1f * (float) (1/Math.cos(v));
                temp.add(new Vector3f(x, y, z));
            }
        }
        vertices = temp;
    }

    public void createEllipticCone() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 16) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 16) {
                float x = 0.f * (float) (v * Math.cos(u));
                float z = 0.1f * (float) (v * Math.sin(u));
                float y = 0.1f * (float) v;
                temp.add(new Vector3f(x, y, z));
            }
        }
        vertices = temp;
    }

    public void createEllipticParaboloid() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = 0; v <= 3; v += Math.PI / 16) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 16) {
                float x = 0.5f * (float) (v * Math.cos(u));
                float z = 0.5f * (float) (v * Math.sin(u));
                float y = (float) (v * v);
                temp.add(new Vector3f(x, y, z));
            }
        }
        vertices = temp;
    }

    public void createHyperboloidParaboloid() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = 0; v <= 3; v += Math.PI / 36) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 36) {
                float x = 0.1f * (float) (v * Math.tan(u));
                float z = 0.1f * (float) (v * (1/Math.cos(u)));
                float y = (float) (v * v);
                temp.add(new Vector3f(x, y, z));
            }
        }
        vertices = temp;
    }

}