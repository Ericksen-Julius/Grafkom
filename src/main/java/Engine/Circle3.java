package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

public class Circle3 extends ObjectAris {

    float rx;

    float ry;

    public float centerX;

    public float centerY;

    public Circle3(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float rx, float ry, float centerX, float centerY) {
        super(shaderModuleDataList, vertices, color);
        this.rx = rx;
        this.ry = ry;
        this.centerX = centerX;
        this.centerY = centerY;
//        createCircle();
//        createRectangle();
//        createTriangle();
        setupVAOVBO();
    }

    public void createCircle() {
        vertices.clear();
        for (double i = 0; i < 360; i += 0.01f) {
            float x = (float) (centerX + rx * Math.cos(i));
            float y = (float) (centerY + ry * Math.sin(i));
            vertices.add(new Vector3f(x, y, 0.0f));
        }
    }

    public void createRectangle() {
        vertices.clear();
        for (double i = -45; i < 360; i += 90) {
            float x = (float) (centerX + rx * Math.cos(Math.toRadians(i)));
            float y = (float) (centerY + ry * Math.sin(Math.toRadians(i)));
            vertices.add(new Vector3f(x, y, 0.0f));
        }
    }

    public void createTriangle() {
        vertices.clear();
        for (double i = -90; i < 360; i += 120) {
            float x = (float) (centerX + rx * Math.cos(Math.toRadians(i)));
            float y = (float) (centerY + ry * Math.sin(Math.toRadians(i)));
            vertices.add(new Vector3f(x, y, 0.0f));
        }
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
}