package Engine;

import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;

public class Spehere extends Circle{

    public float centerZ;
    public float radiusZ;
    public float radiusX;
    public float radiusY;
    List <Integer> index;
    int ibo;


    public float currAngle;
    public Spehere(List<ShaderModuleData> shaderModuleDataList, Vector4f color,float r,float xR,float yR,float centerZ,float radiusZ) {
        super(shaderModuleDataList, color, xR,yR,r);
        this.centerZ = centerZ;
        this.radiusZ = radiusZ;
        createEllipsoid();
        setupVAOVBO();
    }
    public Spehere(List<ShaderModuleData> shaderModuleDataList, Vector4f color,float radiusX,float radiusY,float xR,float yR,float centerZ,float radiusZ) {
        super(shaderModuleDataList, color, xR,yR);
        this.centerZ = centerZ;
        this.radiusZ = radiusZ;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        createBox();
//        createSpehere();
//        createSpehere2();
//        createEllipsoid();
//        hyperboloid1();
//        hyperboloid2();
//        ellipticCone();
//        ellipticParaboloid();
//        hyperboloidParaboloid();
        setupVAOVBO();
    }
    public Spehere(List<ShaderModuleData> shaderModuleDataList, Vector4f color,float radiusX,float radiusY,float xR,float yR,float centerZ,float radiusZ,int choose) {
        super(shaderModuleDataList, color, xR,yR);
        this.centerZ = centerZ;
        this.radiusZ = radiusZ;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        if(choose == 1){
            createBox();
        } else if (choose == 2) {
            createEllipsoid();
        } else if (choose == 3) {
            createSpehere2();
        } else if (choose == 4) {
            hyperboloid1();
        } else if (choose == 5) {
            hyperboloid2();
        } else if (choose == 6) {
            ellipticCone();
        } else if (choose == 7) {
            ellipticParaboloid();
        } else if (choose == 8) {
            hyperboloidParaboloid();
        } else if (choose == 9) {
            createBadan();
        } else if (choose == 10) {
            createEarAi(110);
        } else if (choose == 11) {
            createEarAi(70);
        } else if (choose == 12) {
            create3DRoundedRectangle();
        } else if (choose == 13) {
            createCircle();
        } else if (choose == 14) {
            createTriangle();
        } else if (choose == 15) {
            createSlantedEllipsoid(1);
        } else if (choose == 16) {
            createSlantedEllipsoid(2);
        }else if (choose == 17){
            createHalfEllipsoid();
        } else if (choose == 18) {
            createCylinder();
        } else if (choose == 19) {
            createHalfEllipsoid2();

        }
//        createSpehere();
//        createSpehere();
//        createSpehere2();
//        createEllipsoid();
//        hyperboloid1();
//        hyperboloid2();
//        ellipticCone();
//        ellipticParaboloid();
//        hyperboloidParaboloid();
        setupVAOVBO();
    }
    public Spehere(List<ShaderModuleData> shaderModuleDataList,List<Vector3f> vertices, Vector4f color,float radiusX,float radiusY,float xR,float yR,float centerZ,float radiusZ,int choose) {
        super(shaderModuleDataList, color, xR,yR);
        this.centerZ = centerZ;
        this.radiusZ = radiusZ;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        if(choose == 1){
            createBox();
        } else if (choose == 2) {
            createEllipsoid();
        } else if (choose == 3) {
            createSpehere();
        } else if (choose == 4) {
            hyperboloid1();
        } else if (choose == 5) {
            hyperboloid2();
        } else if (choose == 6) {
            ellipticCone();
        } else if (choose == 7) {
            ellipticParaboloid();
        } else if (choose == 8) {
            hyperboloidParaboloid();
        } else if (choose == 9) {
            createBadan();
        } else if (choose == 10) {
            createEarAi(110);
        } else if (choose == 11) {
            createEarAi(70);
        } else if (choose == 12) {
            create3DRoundedRectangle();
        } else if (choose == 13) {
            createCircle();
        } else if (choose == 14) {
            createTriangle();
        } else if (choose == 15) {
            createSlantedEllipsoid(1);
        } else if (choose == 16) {
            createSlantedEllipsoid(2);
        }else if (choose == 17){
            createHalfEllipsoid();
        } else if (choose == 18) {
            createCylinder();
        } else if (choose == 19) {
            createHalfEllipsoid2();
        }
//        createSpehere();
//        createSpehere();
//        createSpehere2();
//        createEllipsoid();
//        hyperboloid1();
//        hyperboloid2();
//        ellipticCone();
//        ellipticParaboloid();
//        hyperboloidParaboloid();
        setupVAOVBO();
    }

    public void createBox(){
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();

        //titik 1 kiri atas belakang
        temp.x = this.xr - radiusX / 2;
        temp.y = this.yr + radiusY / 2;
        temp.z = this.centerZ - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 2 kiri bawah belakang
        temp.x = this.xr - radiusX / 2;
        temp.y = this.yr - radiusY / 2;
        temp.z = this.centerZ - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 3 kanan bawah belakang
        temp.x = this.xr + radiusX / 2;
        temp.y = this.yr - radiusY / 2;
        temp.z = this.centerZ - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 4 kanan atas belakang
        temp.x = this.xr + radiusX / 2;
        temp.y = this.yr + radiusY / 2;
        temp.z = this.centerZ - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 5 kiri atas depan
        temp.x = this.xr - radiusX / 2;
        temp.y = this.yr + radiusY / 2;
        temp.z = this.centerZ + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 6 kiri bawah depan
        temp.x = this.xr - radiusX / 2;
        temp.y = this.yr - radiusY / 2;
        temp.z = this.centerZ + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 7 kanan bawah depan
        temp.x = this.xr + radiusX / 2;
        temp.y = this.yr - radiusY / 2;
        temp.z = this.centerZ + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //titik 8 kanan atas depan
        temp.x = this.xr + radiusX / 2;
        temp.y = this.yr + radiusY / 2;
        temp.z = this.centerZ + radiusZ / 2;
        tempVertices.add(temp);

        //kotak belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(0));
        //kotak depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(4));
        //kotak kiri
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        //kotak kanan
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(7));
        //kotak atas
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        //kotak bawah
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));

    }





    public void createSilinder(){
        vertices.clear();
        for(float i = 0;i<360;i+=1){
            double rad = Math.toRadians(i);
            Float x = (float) (Math.cos(rad)*radiusX);
            Float y = (float) (Math.sin(rad)*radiusY);
            vertices.add(new Vector3f(x,y,centerZ));

            float z = radiusZ;
            vertices.add(new Vector3f(x,y,z));
        }
    }
    public void createCircle(){
        double x,y;
        for(double i = 0;i<2*Math.PI;i+=Math.PI/360){
            x = radiusX * Math.cos(i);
            y = radiusY * Math.sin(i);
            this.vertices.add(new Vector3f((float)x,(float)y,0.0f));
        }
    }


    public void createSpehere(){
        ArrayList<Vector3f> temp = new ArrayList<>();
        int stackCount = 18, sectorCount = 36;
        float x,y,z,xy,nx,ny,nz;
        float sectorStep = (float)(2* Math.PI )/ sectorCount; //sector count
        float stackStep = (float)Math.PI / stackCount; // stack count
        float sectorAngle, stackAngle;

        for(int i=0;i<=stackCount;i++){
            stackAngle = (float)Math.PI/2 - i * stackStep;
            xy = (float) (this.radiusX * Math.cos(stackAngle));
            z = (float) (this.radiusZ * Math.sin(stackAngle));
            for(int j=0;j<sectorCount;j++){
                sectorAngle = j * sectorStep;
                x = (float) (xy * Math.cos(sectorAngle));
                y = (float) (xy * Math.sin(sectorAngle));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
        int k1, k2;
        ArrayList<Integer> temp_indices = new ArrayList<>();
        for(int i=0;i<stackCount;i++){
            k1 = i * (sectorCount + 1);
            k2 = k1 + sectorCount + 1;

            for(int j=0;j<sectorCount;++j, ++k1, ++k2){
                if(i != 0){
                    temp_indices.add(k1);
                    temp_indices.add(k2);
                    temp_indices.add(k1+1);
                }
                if(i!=(18-1)){
                    temp_indices.add(k1+1);
                    temp_indices.add(k2);
                    temp_indices.add(k2+1);
                }
            }
        }
        this.index = temp_indices;
        this.ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,this.ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,Utils.listoInt(index),GL_STATIC_DRAW);

    }
    public void createCylinder() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double theta = 0; theta <= Math.PI * 2; theta += Math.PI / 180) {
            for (double v = 0; v <= 1; v += 1 / 16.0) {
                float x = radiusX * (float) Math.cos(theta);
                float y = radiusY * (float) v;
                float z = radiusZ * (float) Math.sin(theta);
                temp.add(new Vector3f(x, y - (radiusY / 2.0f), z));
            }
        }
        vertices = temp;
    }
    public void updatePosition(){
        this.xr = (float) (this.xr * Math.cos(this.xr+0.01) - this.yr * Math.sin(this.yr+0.01));
        this.yr = (float) (this.xr * Math.sin(this.xr+0.01) + this.yr * Math.cos(this.yr+0.01));
        setupVAOVBO();
    }

    public void createSpehere2(){
        vertices.clear();
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
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Utils.listoInt(index), GL_STATIC_DRAW);
    }



    public void createEllipsoid(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/360){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/360){
                float x = radiusX * (float)(Math.cos(v) * Math.cos(u));
                float y = radiusY * (float)(Math.cos(v) * Math.sin(u));
                float z = radiusZ * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
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
                float x = radiusX * (float)(Math.cos(v) * Math.cos(u + theta));
                float y = radiusY * (float)(Math.cos(v - phi) * Math.sin(u));
                float z = radiusZ * (float)(Math.sin(v - phi));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }

    public void createEar(){
        double x,y;
        for(double i = 90;i<360;i+=120){
            double blah = Math.toRadians(i);
            x = this.radiusX * Math.cos(blah);
            y = this.radiusY * Math.sin(blah);
            this.vertices.add(new Vector3f((float)x,(float)y,radiusZ));
        }
    }
    public void createEarAi(double side) {
        float height = 0.5f;
        int numSegments = 10;

        // Create the 2D ear shape in the XY plane
        List<Vector2f> earShape = new ArrayList<Vector2f>();
        for (double i = side; i < 360; i += 120) {
            double angle = Math.toRadians(i);
            double x = radiusX * Math.cos(angle);
            double y = radiusY * Math.sin(angle);
            earShape.add(new Vector2f((float) x, (float) y));
        }

        // Extrude the ear shape along the Z-axis to create a 3D object
        for (int i = 0; i < numSegments; i++) {
            float z = (float) i * height / numSegments;
            for (int j = 0; j < earShape.size(); j++) {
                Vector2f v1 = earShape.get(j);
                Vector2f v2 = earShape.get((j + 1) % earShape.size());
                this.vertices.add(new Vector3f(v1.x, v1.y, z));
                this.vertices.add(new Vector3f(v2.x, v2.y, z));
                this.vertices.add(new Vector3f(v2.x, v2.y, z + height / numSegments));
                this.vertices.add(new Vector3f(v1.x, v1.y, z + height / numSegments));
            }
        }
    }

    public void createBadan(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/8.5){
                float x = radiusX * (float)(Math.cos(v) * Math.cos(u));
                float y = radiusY * (float)(Math.cos(v) * Math.sin(u));
                float z = radiusZ * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;

    }


    public void hyperboloid1(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/36){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/36){
                float x = radiusX * (float)((1/Math.cos(v)) * Math.cos(u));
                float z = radiusY * (float)((1/Math.cos(v)) * Math.sin(u));
                float y = radiusZ * (float)(Math.tan(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }


    public void ellipticCone(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/36){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/36){
                float x = (float) (radiusX * v * (float)(Math.cos(u)));
                float z = (float) (radiusY * v *  (float)(Math.sin(u)));
                float y = (float) (radiusZ * v);
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }
    public void ellipticParaboloid(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= 3; v+=Math.PI/36){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/36){
                float x = (float) (radiusX * v * (float)(Math.cos(u)));
                float z = (float) (radiusY * v *  (float)(Math.sin(u)));
                float y = (float) ((float) v*v);
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }
    public void hyperboloidParaboloid(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= 3; v+=Math.PI/36){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/36){
                float x = (float) (radiusX * v * (float)(Math.tan(u)));
                float z = (float) (radiusY * v *  (float)(1/Math.cos(u)));
                float y = (float) ((float) v*v);
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }
    public void create3DRoundedRectangle() {
        float width = radiusX;
        float height = radiusY;
        float depth = 1.0f;
        float radius = 0.03f;
        int numSegments = 16;

        this.vertices.clear();
        double x, y;
        float halfWidth = width / 2.0f - radius;
        float halfHeight = height / 2.0f - radius;
        float halfDepth = depth / 2.0f;
        for (double i = 45; i < 360; i += 90) {
            double angle = Math.toRadians(i);
            float xDir = (float)Math.cos(angle);
            float yDir = (float)Math.sin(angle);
            float xCenter = xr + xDir * halfWidth;
            float yCenter = yr + yDir * halfHeight;
            for (double j = i; j < i + 90; j += 90.0 / 16) {
                double cornerAngle = Math.toRadians(j);
                x = xCenter + radius * (float)Math.cos(cornerAngle);
                y = yCenter + radius * (float)Math.sin(cornerAngle);
                this.vertices.add(new Vector3f((float)x,(float)y, centerZ + halfDepth));
                this.vertices.add(new Vector3f((float)x,(float)y, centerZ - halfDepth));
            }
        }
        // Generate side faces
        for (int i = 0; i < this.vertices.size(); i += numSegments * 2) {
            int j = (i + numSegments * 2) % this.vertices.size();
            Vector3f v1 = this.vertices.get(i);
            Vector3f v2 = this.vertices.get(i+1);
            Vector3f v3 = this.vertices.get(j);
            Vector3f v4 = this.vertices.get(j+1);
            this.vertices.add(v1);
            this.vertices.add(v2);
            this.vertices.add(v3);
            this.vertices.add(v4);
            // Generate two triangles for each quad
            this.vertices.add(v1);
            this.vertices.add(v2);
            this.vertices.add(v4);
            this.vertices.add(v1);
            this.vertices.add(v3);
            this.vertices.add(v4);
        }
    }

    public void hyperboloid2(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI/2; u<= Math.PI/2; u+=Math.PI/60){
                float x = radiusX * (float)(Math.tan(v) * Math.cos(u));
                float z = radiusY * (float)(Math.tan(v) * Math.sin(u));
                float y = radiusZ * (float)(1/Math.cos(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = Math.PI/2; u<= 3*(Math.PI/2); u+=Math.PI/60){
                float x = radiusX * (float)((Math.tan(v)) * Math.cos(u));
                float z = radiusY * (float)((Math.tan(v)) * Math.sin(u));
                float y = -radiusZ * (float)(1/Math.cos(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }

    public void createTriangle(){
        double baseWidth = 1.5;
        double height = 2.0;
        double x,y;
        double angleRadians = Math.toRadians(60);
        double halfBase = baseWidth / 2.0;

        x = 0.0;
        y = height / 2.0;
        this.vertices.add(new Vector3f((float)x,(float)y,0.0f));

        x = -halfBase * Math.cos(angleRadians);
        y = -halfBase * Math.sin(angleRadians);
        this.vertices.add(new Vector3f((float)x,(float)y,0.0f));

        x = halfBase * Math.cos(angleRadians);
        y = -halfBase * Math.sin(angleRadians);
        this.vertices.add(new Vector3f((float)x,(float)y,0.0f));
    }
    public void createHalfEllipsoid2(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= 0; v+=Math.PI/60){
            for(double u = -Math.PI; u<= 0; u+=Math.PI/60){
                float x = radiusX * (float)(Math.cos(v) * Math.cos(u));
                float y = -radiusY * (float)(Math.cos(v) * Math.sin(u));
                float z = radiusZ * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }





//    @Override
//    public void draw() {
//        drawSetup();
//        glLineWidth(0);//Ketebalan garis
//        glPointSize(1);//Besar kecil vertex
//        glDrawArrays(GL_LINE_STRIP,0,
//                vertices.size());
//
//    }
    public void drawRect(){
        drawSetup();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,this.ibo);
        glDrawElements(GL_LINE_STRIP,index.size(),GL_UNSIGNED_INT,0);
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

    public float getCenterZ() {
        return centerZ;
    }

    public float getRadiusZ() {
        return radiusZ;
    }

    public float getRadiusX() {
        return radiusX;
    }

    public float getRadiusY() {
        return radiusY;
    }

    public List<Integer> getIndex() {
        return index;
    }

    public int getIbo() {
        return ibo;
    }

    public float getCurrAngle() {
        return currAngle;
    }
}
