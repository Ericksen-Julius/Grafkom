package Engine;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;

public class SphereAris extends Circle3 {

    float rz;
    public float centerZ;
    float radiusX;
    float radiusY;
    float radiusZ;

    List<Integer> index;

    int ibo;

    public SphereAris(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float rx, float ry, float rz, float centerX, float centerY, float centerZ,  float angleX, float angleY, float angleZ,int choose) {
        super(shaderModuleDataList, vertices, color, rx, ry, centerX, centerY);
        this.centerZ = centerZ;
        this.rz = rz;
        if (choose == 1){
            createEllipsoid(rx, ry, rz, centerX, centerY, centerZ,angleX,angleY,angleZ);
        }else if(choose == 2){
            createBox();
        }else if(choose == 3){
            createHalfEllipsoid();
        }else if(choose == 4){
            createSphere();
        }else if(choose == 5){
            createHyperboloidParaboloid();
        }else if(choose == 6){
            createEllipticParaboloid();
        }

//        createBox();
//        createSphere();

//        createHyperboloid1();
//        createHyperboloid2();
//        createEllipticCone();
//        createEllipticParaboloid();
//        createHyperboloidParaboloid();
        setupVAOVBO();
    }

    public float getCenterZ() {
        return centerZ;
    }


    public void createHalfEllipsoid(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= 0; v+=Math.PI/60){
            for(double u = -Math.PI; u<= 0; u+=Math.PI/60){
                float x = radiusX * (float)(Math.cos(v) * Math.cos(u));
                float y = radiusY * (float)(Math.cos(v) * Math.sin(u));
                float z = radiusZ * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
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
    public void createEllipsoid(float rx, float ry, float rz, float centerX, float centerY, float centerZ, float angleX, float angleY, float angleZ) {
        ArrayList<Vector3f> temp = new ArrayList<>();
        Matrix4f rotationMatrix = new Matrix4f();
        rotationMatrix.rotateX(angleX);
        rotationMatrix.rotateY(angleY);
        rotationMatrix.rotateZ(angleZ);

        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 60) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 60) {
                float x = rx * (float) (Math.cos(v) * Math.cos(u));
                float y = ry * (float) (Math.cos(v) * Math.sin(u));
                float z = rz * (float) (Math.sin(v));

                Vector4f vec = new Vector4f(x, y, z, 1.0f);
                vec = vec.mul(rotationMatrix);
                vec.x += centerX;
                vec.y += centerY;
                vec.z += centerZ;
                temp.add(new Vector3f(vec.x, vec.y, vec.z));
            }
        }
        vertices = temp;
    }


    public void createSphere() {
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

//    public void createEllipsoid(float rx, float ry, float rz, float centerX, float centerY, float centerZ) {
//        ArrayList<Vector3f> temp = new ArrayList<>();
//
//        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 60) {
//            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 60) {
//                float x = centerX + rx * (float) (Math.cos(v) * Math.cos(u));
//                float y = centerY + ry * (float) (Math.cos(v) * Math.sin(u));
//                float z = centerZ + rz * (float) (Math.sin(v));
//                temp.add(new Vector3f(x, y, z));
//            }
//        }
//        vertices = temp;
//    }

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