package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

public class Cat extends Circle {

    public float centerZ;
    public float radiusZ;
    public float radiusX;
    public float radiusY;
    List<Integer> index;
    int ibo;

    public float currAngle;

    public Cat(List<ShaderModuleData> shaderModuleDataList, Vector4f color, float r, float xR, float yR, float centerZ, float radiusZ) {
        super(shaderModuleDataList, color, xR, yR, r);
        this.centerZ = centerZ;
        this.radiusZ = radiusZ;
        createBody();
        createHead();
        createEar1();
        createEar2();
        createLeg1();
//        createLeg2();
//        createLeg3();
//        createLeg4();
        setupVAOVBO();
    }

    public void createBody() {
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();

        // Body
        temp.x = this.xr - radiusX / 2;
        temp.y = this.yr + radiusY / 2;
        temp.z = this.centerZ - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        temp.x = this.xr - radiusX / 2;
        temp.y = this.yr - radiusY / 2;
        temp.z = this.centerZ - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        temp.x = this.xr + radiusX / 2;
        temp.y = this.yr - radiusY / 2;
        temp.z = this.centerZ - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        temp.x = this.xr + radiusX / 2;
        temp.y = this.yr + radiusY / 2;
        temp.z = this.centerZ - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        temp.x = this.xr - radiusX / 2;
        temp.y = this.yr + radiusY / 2;
        temp.z = this.centerZ + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        temp.x = this.xr - radiusX / 2;
        temp.y = this.yr - radiusY / 2;
        temp.z = this.centerZ + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        temp.x = this.xr + radiusX / 2;
        temp.y = this.yr - radiusY / 2;
        temp.z = this.centerZ + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        temp.x = this.xr + radiusX / 2;
        temp.y = this.yr + radiusY / 2;
        temp.z = this.centerZ + radiusZ / 2;
        tempVertices.add(temp);

        // Body (back)
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        // Body (front)
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(4));

        // Body (right)
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));

        // Body (left)
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(0));

        // Body (top)
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(0));

        // Body (bottom)
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(1));

        // Add index data
        index = new ArrayList<>();
        for (int i = 0; i < 36; i++) {
            index.add(i);
        }
    }

    public void createHead() {
        Vector3f temp = new Vector3f();

        // Head
        temp.x = this.xr + radiusX / 4;
        temp.y = this.yr + radiusY / 4;
        temp.z = this.centerZ + radiusZ / 2;
        vertices.add(temp);
        temp = new Vector3f();
        temp.x = this.xr + radiusX / 4;
        temp.y = this.yr - radiusY / 4;
        temp.z = this.centerZ + radiusZ / 2;
        vertices.add(temp);
        temp = new Vector3f();
        temp.x = this.xr - radiusX / 4;
        temp.y = this.yr - radiusY / 4;
        temp.z = this.centerZ + radiusZ / 2;
        vertices.add(temp);
        temp = new Vector3f();
        temp.x = this.xr - radiusX / 4;
        temp.y = this.yr + radiusY / 4;
        temp.z = this.centerZ + radiusZ / 2;
        vertices.add(temp);

        // Head (back)
        vertices.add(vertices.get(8));
        vertices.add(vertices.get(9));
        vertices.add(vertices.get(10));
        vertices.add(vertices.get(10));
        vertices.add(vertices.get(11));
        vertices.add(vertices.get(8));

        // Head (front)
        vertices.add(vertices.get(12));
        vertices.add(vertices.get(13));
        vertices.add(vertices.get(14));
        vertices.add(vertices.get(14));
        vertices.add(vertices.get(15));
        vertices.add(vertices.get(12));

        // Head (right)
        vertices.add(vertices.get(11));
        vertices.add(vertices.get(10));
        vertices.add(vertices.get(14));
        vertices.add(vertices.get(14));
        vertices.add(vertices.get(15));
        vertices.add(vertices.get(11));

        // Head (left)
        vertices.add(vertices.get(8));
        vertices.add(vertices.get(9));
        vertices.add(vertices.get(13));
        vertices.add(vertices.get(13));
        vertices.add(vertices.get(12));
        vertices.add(vertices.get(8));

        // Head (top)
        vertices.add(vertices.get(8));
        vertices.add(vertices.get(11));
        vertices.add(vertices.get(15));
        vertices.add(vertices.get(15));
        vertices.add(vertices.get(12));
        vertices.add(vertices.get(8));

        // Head (bottom)
        vertices.add(vertices.get(9));
        vertices.add(vertices.get(10));
    }
    public void createEar1() {
        Vector3f temp = new Vector3f();

        // Ear 1
        temp.x = this.xr + radiusX / 2;
        temp.y = this.yr + radiusY / 4;
        temp.z = this.centerZ + radiusZ / 2;
        vertices.add(temp);
        temp = new Vector3f();
        temp.x = this.xr + radiusX / 2;
        temp.y = this.yr - radiusY / 4;
        temp.z = this.centerZ + radiusZ / 2;
        vertices.add(temp);
        temp = new Vector3f();
        temp.x = this.xr + radiusX / 2 + radiusX / 4;
        temp.y = this.yr;
        temp.z = this.centerZ + radiusZ / 2;
        vertices.add(temp);

        // Add index data
        index.add(vertices.size() - 3);
        index.add(vertices.size() - 2);
        index.add(vertices.size() - 1);
    }
    public void createEar2() {
        Vector3f temp = new Vector3f();

        // Ear 2
        temp.x = this.xr + radiusX / 2;
        temp.y = this.yr + radiusY / 4;
        temp.z = this.centerZ - radiusZ / 4;
        vertices.add(temp);
        temp = new Vector3f();
        temp.x = this.xr + radiusX / 2;
        temp.y = this.yr;
        temp.z = this.centerZ - radiusZ / 4;
        vertices.add(temp);
        temp = new Vector3f();
        temp.x = this.xr + radiusX / 2 + radiusX / 4;
        temp.y = this.yr;
        temp.z = this.centerZ - radiusZ / 4;
        vertices.add(temp);
        temp = new Vector3f();
        temp.x = this.xr + radiusX / 2;
        temp.y = this.yr + radiusY / 4;
        temp.z = this.centerZ + radiusZ / 4;
        vertices.add(temp);
        temp = new Vector3f();
        temp.x = this.xr + radiusX / 2;
        temp.y = this.yr;
        temp.z = this.centerZ + radiusZ / 4;
        vertices.add(temp);
        temp = new Vector3f();
        temp.x = this.xr + radiusX / 2 + radiusX / 4;
        temp.y = this.yr;
        temp.z = this.centerZ + radiusZ / 4;
        vertices.add(temp);

        // Add index data
        index.add(vertices.size() - 6);
        index.add(vertices.size() - 5);
        index.add(vertices.size() - 4);
        index.add(vertices.size() - 4);
        index.add(vertices.size() - 5);
        index.add(vertices.size() - 3);
        index.add(vertices.size() - 5);
        index.add(vertices.size() - 2);
        index.add(vertices.size() - 3);
        index.add(vertices.size() - 3);
        index.add(vertices.size() - 2);
        index.add(vertices.size() - 1);
    }
    public void createLeg1() {
        // Upper leg
        Vector3f temp = new Vector3f();
        temp.x = this.xr + radiusX / 2;
        temp.y = this.yr + radiusY / 4;
        temp.z = this.centerZ - radiusZ / 4;
        vertices.add(temp);

        temp = new Vector3f();
        temp.x = this.xr + radiusX / 2;
        temp.y = this.yr + radiusY / 4;
        temp.z = this.centerZ - radiusZ / 2;
        vertices.add(temp);

        temp = new Vector3f();
        temp.x = this.xr + radiusX / 2;
        temp.y = this.yr - radiusY / 4;
        temp.z = this.centerZ - radiusZ / 2;
        vertices.add(temp);

        temp = new Vector3f();
        temp.x = this.xr + radiusX / 2;
        temp.y = this.yr - radiusY / 4;
        temp.z = this.centerZ - radiusZ / 4;
        vertices.add(temp);

        // Lower leg
        temp = new Vector3f();
        temp.x = this.xr + radiusX / 2;
        temp.y = this.yr + radiusY / 4;
        temp.z = this.centerZ - radiusZ / 4 - (radiusZ / 4);
        vertices.add(temp);

        temp = new Vector3f();
        temp.x = this.xr + radiusX / 2;
        temp.y = this.yr + radiusY / 4;
        temp.z = this.centerZ - radiusZ / 2 - (radiusZ / 4);
        vertices.add(temp);

        temp = new Vector3f();
        temp.x = this.xr + radiusX / 2;
        temp.y = this.yr - radiusY / 4;
        temp.z = this.centerZ - radiusZ / 2 - (radiusZ / 4);
        vertices.add(temp);

        temp = new Vector3f();
        temp.x = this.xr + radiusX / 2;
        temp.y = this.yr - radiusY / 4;
        temp.z = this.centerZ - radiusZ / 4 - (radiusZ / 4);
        vertices.add(temp);

        // Add index data
        index.add(vertices.size() - 16);
        index.add(vertices.size() - 15);
        index.add(vertices.size() - 14);
        index.add(vertices.size() - 14);
        index.add(vertices.size() - 13);
        index.add(vertices.size() - 16);

        index.add(vertices.size() - 12);
        index.add(vertices.size() - 11);
        index.add(vertices.size() - 10);
        index.add(vertices.size() - 10);
        index.add(vertices.size() - 9);
        index.add(vertices.size() - 12);

        index.add(vertices.size() - 16);
        index.add(vertices.size() - 15);
        index.add(vertices.size() - 11);
        index.add(vertices.size() - 11);
        index.add(vertices.size() - 12);
        index.add(vertices.size() - 16);

        index.add(vertices.size() - 14);
        index.add(vertices.size() - 13);
        index.add(vertices.size() - 9);
        index.add(vertices.size() - 9);
        index.add(vertices.size() - 10);
        index.add(vertices.size() - 14);
    }
}



