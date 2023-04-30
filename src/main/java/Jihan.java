import Engine.Object;
import Engine.*;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Jihan {
    private Window window =
            new Window(800, 800, "Uji");

    private ArrayList<Object> objects = new ArrayList<>();
    private ArrayList<Rectangle> objectsRectangle = new ArrayList<>();

    private ArrayList<Circle2> objectsCircle = new ArrayList<>();

    private ArrayList<Circle2> objectsStar = new ArrayList<>();

    private ArrayList<Object> objectsPointsControl = new ArrayList<>();

    private ArrayList<Rectangle> objectMulti = new ArrayList<>();

    private ArrayList<Sphere> objectsYulius = new ArrayList<>();

    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(), window.getHeight());

    public void init() {
        window.init();
        GL.createCapabilities();

        //Kepala
        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.961f,0.631f,0.475f,1.0f), 0.115f,0.11f, 0.0f, 0.0f, 0.0f, 0.11f, 1
        ));

        objectsYulius.get(0).translateObject(0.0f, 0.6f, 0.0f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.961f,0.631f,0.475f,1.0f), 0.135f,0.11f, 0.0f, 0.0f, 0.0f, 0.11f, 1
        ));

        objectsYulius.get(1).translateObject(0.0f, 0.515f, 0.0f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.961f,0.631f,0.475f,1.0f), 0.1f,0.15f, 0.0f, 0.0f, 0.0f, 0.1085f, 1
        ));

        objectsYulius.get(2).translateObject(0.0f, 0.56f, 0.0f);

        //Mata Kiri
        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f,0.0f,0.0f,1.0f), 0.015f,0.025f, 0.0f, 0.0f, 0.0f, 0.0f, 1
        ));

        objectsYulius.get(3).translateObject(-0.044f,0.6f,-0.106f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.996f,0.996f,1.0f,1.0f), 0.005f,0.008f, 0.0f, 0.0f, 0.0f, 0.0f, 1
        ));

        objectsYulius.get(4).translateObject(-0.044f,0.6f,-0.107f);

        //Mata Kanan
        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f,0.0f,0.0f,1.0f), 0.015f,0.025f, 0.0f, 0.0f, 0.0f, 0.0f, 1
        ));

        objectsYulius.get(5).translateObject(0.044f,0.6f,-0.106f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.996f,0.996f,1.0f,1.0f), 0.005f,0.008f, 0.0f, 0.0f, 0.0f, 0.0f, 1
        ));

        objectsYulius.get(6).translateObject(0.044f,0.6f,-0.107f);

        //Hidung
        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f,0.0f,0.0f,1.0f), 0.04f,0.03f, 0.0f, 0.0f, 0.0f, 0.0f, 1
        ));

        objectsYulius.get(7).translateObject(0.0f,0.54f,-0.11f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.961f,0.631f,0.475f,1.0f), 0.036f,0.026f, 0.0f, 0.0f, 0.005f, 0.03f, 1
        ));

        objectsYulius.get(8).translateObject(0.0f,0.54f,-0.111f);

        //Mulut
        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.675f,0.439f,0.463f,1.0f), 0.08f,0.03f, 0.0f, 0.0f, 0.0f, 0.048f, 1
        ));

        objectsYulius.get(9).translateObject(0.0f,0.458f,-0.05f);

        //Telinga Kanan
        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.961f,0.631f,0.475f,1.0f), 0.03f,0.04f, 0.0f, 0.0f, 0.0f, 0.02f, 1
        ));

        objectsYulius.get(10).translateObject(0.125f,0.59f,0.02f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.816f,0.529f,0.412f,1.0f), 0.006f,0.01f, 0.0f, 0.0f, 0.0f, 0.0f, 1
        ));

        objectsYulius.get(11).translateObject(0.127f,0.59f,-0.02f);

        //Telinga Kiri

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.961f,0.631f,0.475f,1.0f), 0.03f,0.04f, 0.0f, 0.0f, 0.0f, 0.02f, 1
        ));

        objectsYulius.get(12).translateObject(-0.125f,0.59f,0.02f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.816f,0.529f,0.412f,1.0f), 0.006f,0.01f, 0.0f, 0.0f, 0.0f, 0.0f, 1
        ));

        objectsYulius.get(13).translateObject(-0.127f,0.59f,-0.02f);

        //Rambut
        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f,0.0f,0.0f,1.0f), 0.1f,0.045f, 0.0f, 0.0f, 0.0f, 0.105f, 6
        ));

        objectsYulius.get(14).translateObject(0.0f,0.69f,0.0f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f,0.0f,0.0f,1.0f), -0.1f,0.045f, 0.0f, 0.0f, 0.0f, -0.105f, 6
        ));

        objectsYulius.get(15).translateObject(0.0f,0.69f,0.0f);

        //Badan
        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.98f,0.776f,0.4f,1.0f), 0.27f,0.27f, 0.0f, 0.0f, 0.0f, 0.2f, 1
        ));

        objectsYulius.get(16).translateObject(0.0f, 0.18f, 0.06f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.867f,0.502f,0.498f,1.0f), 0.271f,0.09f, 0.0f, 0.0f, 0.0f, 0.21f, 6
        ));

        objectsYulius.get(17).translateObject(0.0f, 0.18f, 0.06f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.867f,0.502f,0.498f,1.0f), -0.271f,0.09f, 0.0f, 0.0f, 0.0f, -0.21f, 6
        ));

        objectsYulius.get(18).translateObject(0.0f, 0.18f, 0.06f);

        //Tangan Kanan
        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.98f,0.776f,0.4f,1.0f), 0.18f,0.065f, 0.0f, 0.0f, 0.0f, 0.05f, 1
        ));

        objectsYulius.get(19).rotateObject((float) Math.toRadians(0.3f), 0.0f, 0.0f, -100f);
        objectsYulius.get(19).translateObject(0.25f,0.33f,0.05f);

        //Tangan Kiri
        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.98f,0.776f,0.4f,1.0f), -0.18f,0.065f, 0.0f, 0.0f, 0.0f, 0.05f, 1
        ));

        objectsYulius.get(20).rotateObject((float) Math.toRadians(0.3f), 0.0f, 0.0f, 100f);
        objectsYulius.get(20).translateObject(-0.25f,0.33f,0.05f);

        //Telapak kiri
        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.961f,0.631f,0.475f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 5
        ));

        objectsYulius.get(21).scaleObject(0.0138f,0.004f,0.009f);
        objectsYulius.get(21).rotateObject((float) Math.toRadians(0.3f), 0.0f, 0.0f, -450f);
        objectsYulius.get(21).translateObject(-0.47f,0.223f,0.05f);

        //Telapak kanan
        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.961f,0.631f,0.475f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 5
        ));

        objectsYulius.get(22).scaleObject(0.0138f,0.004f,0.009f);
        objectsYulius.get(22).rotateObject((float) Math.toRadians(0.3f), 0.0f, 0.0f, 450f);
        objectsYulius.get(22).translateObject(0.47f,0.223f,0.05f);


        //Celana
        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.545f,0.325f,0.302f,1.0f), 0.42f,0.11f, 0.0f, 0.0f, 0.0f, 0.324f, 2
        ));

        objectsYulius.get(23).translateObject(0.0f,-0.035f,0.06f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.545f,0.325f,0.302f,1.0f), -0.42f,0.11f, 0.0f, 0.0f, 0.0f, -0.324f, 2
        ));

        objectsYulius.get(24).translateObject(0.0f,-0.035f,0.06f);

        //kaki kanan
        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.545f,0.325f,0.302f,1.0f), 0.1f,0.21f, 0.0f, 0.0f, 0.0f, 0.1f, 2
        ));
        objectsYulius.get(25).translateObject(0.1f,-0.13f,0.06f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.259f,0.4f,0.467f,1.0f), 0.065f,0.025f, 0.0f, 0.0f, 0.0f, 0.089f, 1
        ));

        objectsYulius.get(26).translateObject(0.1f,-0.25f,0.04f);

        //kaki kiri
        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.545f,0.325f,0.302f,1.0f), 0.1f,0.21f, 0.0f, 0.0f, 0.0f, 0.1f, 2
        ));
        objectsYulius.get(27).translateObject(-0.1f,-0.13f,0.06f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.259f,0.4f,0.467f,1.0f), 0.065f,0.025f, 0.0f, 0.0f, 0.0f, 0.089f, 1
        ));

        objectsYulius.get(28).translateObject(-0.1f,-0.25f,0.04f);

        for (int i = 0; i < objectsYulius.size(); i++) {
            objectsYulius.get(i).translateObject(0.0f, -0.5f, 0.0f);
        }
    }

    int checkRotate5 = 0;
    int checkRotate16 = 0;

    int checkRotate17 = 0;
    boolean arah = true;

    boolean arah2 = true;

    boolean arah3 = true;
    public void input() {
        if(window.isKeyPressed(GLFW_KEY_R)) {
            for (int i = 0; i < objectsYulius.size(); i++) {
                objectsYulius.get(i).rotateObject((float) Math.toRadians(0.8f), 0.0f, 0.8f,0.0f);
            }
        }

        if(window.isKeyPressed(GLFW_KEY_Q)) {
            for (int i = 0; i < objectsYulius.size(); i++) {
                objectsYulius.get(i).rotateObject((float) Math.toRadians(0.8f), 0.0f, -0.8f,0.0f);
            }
        }

        if(window.isKeyPressed((GLFW_KEY_E))) {
            for (int i = 0; i < objectsYulius.size(); i++) {
                objectsYulius.get(i).rotateObject((float) Math.toRadians(0.8f), 0.8f, 0.0f,0.0f);
            }
        }

        if(window.isKeyPressed((GLFW_KEY_Z))) {
            for (int i = 0; i < objectsYulius.size(); i++) {
                objectsYulius.get(i).rotateObject((float) Math.toRadians(0.8f), 0.0f, 0.0f,0.8f);
            }
        }

        if(window.isKeyPressed(GLFW_KEY_A)) {
            Vector3f center = objectsYulius.get(23).updateCenterPoint();
            if(checkRotate5 < 60 && arah) {
                for(int i = 0; i <= 28; i++) {
                    objectsYulius.get(i).translateObject(center.x * -1, center.y * -1, center.z * -1);
                    if (i == 25 || i == 26) {
                        objectsYulius.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    }
                    else if (i == 27 || i == 28) {
                        objectsYulius.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    }
                    else {
                        objectsYulius.get(i).translateObject(0.0f,0.0005f,0.0f);
                    }

                    objectsYulius.get(i).translateObject(center.x * 1, center.y * 1, center.z * 1);
                }

                checkRotate5++;
            }
            if(checkRotate5 > 0 && !arah) {
                for(int i = 0; i <= 28; i++) {
                    objectsYulius.get(i).translateObject(center.x * -1, center.y * -1, center.z * -1);
                    if (i == 25 || i == 26) {
                        objectsYulius.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    }
                    else if (i == 27 || i == 28) {
                        objectsYulius.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    }
                    else {
                        objectsYulius.get(i).translateObject(0.0f,-0.0005f,0.0f);
                    }
                    objectsYulius.get(i).translateObject(center.x * 1, center.y * 1, center.z * 1);
                }
                checkRotate5--;
            }
            if(checkRotate5 >= 60) {
                checkRotate5 = 60;
                arah = false;
            }
            if(checkRotate5 <= 0) {
                checkRotate5 = 0;
                arah = true;
            }

            for (Object objects: objectsYulius){
                if(center.x <= -0.9){
                    break;
                }
                objects.translateObject(-0.001f,0.0f,0.0f);
            }
            for(Circle2 objects: objectsCircle){
                if(center.x <= -0.9){
                    break;
                }
                objects.translateObject(-0.001f,0.0f,0.0f);
            }
        }

        if(window.isKeyPressed(GLFW_KEY_D)) {
            Vector3f center = objectsYulius.get(23).updateCenterPoint();
            if(checkRotate5 < 60 && arah) {
                for(int i = 0; i <= 28; i++) {
                    objectsYulius.get(i).translateObject(center.x * -1, center.y * -1, center.z * -1);
                    if (i == 25 || i == 26) {
                        objectsYulius.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    }
                    else if (i == 27 || i == 28) {
                        objectsYulius.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    }
                    else {
                        objectsYulius.get(i).translateObject(0.0f,0.0005f,0.0f);
                    }

                    objectsYulius.get(i).translateObject(center.x * 1, center.y * 1, center.z * 1);
                }

                checkRotate5++;
            }
            if(checkRotate5 > 0 && !arah) {
                for(int i = 0; i <= 28; i++) {
                    objectsYulius.get(i).translateObject(center.x * -1, center.y * -1, center.z * -1);
                    if (i == 25 || i == 26) {
                        objectsYulius.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    }
                    else if (i == 27 || i == 28) {
                        objectsYulius.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    }
                    else {
                        objectsYulius.get(i).translateObject(0.0f,-0.0005f,0.0f);
                    }
                    objectsYulius.get(i).translateObject(center.x * 1, center.y * 1, center.z * 1);
                }
                checkRotate5--;
            }
            if(checkRotate5 >= 60) {
                checkRotate5 = 60;
                arah = false;
            }
            if(checkRotate5 <= 0) {
                checkRotate5 = 0;
                arah = true;
            }

            for (Object objects: objectsYulius){
                if(center.x <= -0.9){
                    break;
                }
                objects.translateObject(0.001f,0.0f,0.0f);
            }
            for(Circle2 objects: objectsCircle){
                if(center.x <= -0.9){
                    break;
                }
                objects.translateObject(0.001f,0.0f,0.0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_W)) {
            Vector3f tempCenterPoint = objectsYulius.get(23).updateCenterPoint();
            if (checkRotate17 < 100 && arah2){
                for (int x = 25;x<=28;x++) {
                    if(x == 25){
                        Vector3f temp = objectsYulius.get(x).updateCenterPoint();
                        Vector3f temp2 = objectsYulius.get(26).updateCenterPoint();
                        objectsYulius.get(x).translateObject(temp.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                        objectsYulius.get(26).translateObject(temp2.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                        objectsYulius.get(x).rotateObject((float) Math.toRadians(.5f), -1.0f, 0.0f, 0.0f);
                        objectsYulius.get(26).rotateObject((float) Math.toRadians(.5f), -1.0f, 0.0f, 0.0f);
                        objectsYulius.get(x).translateObject(temp.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                        objectsYulius.get(26).translateObject(temp2.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                    }if(x == 27){
                        Vector3f temp = objectsYulius.get(x).updateCenterPoint();
                        Vector3f temp2 = objectsYulius.get(28).updateCenterPoint();
                        objectsYulius.get(x).translateObject(temp.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                        objectsYulius.get(28).translateObject(temp2.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                        objectsYulius.get(x).rotateObject((float) Math.toRadians(.5f), 1.0f, 0.0f, 0.0f);
                        objectsYulius.get(28).rotateObject((float) Math.toRadians(.5f), 1.0f, 0.0f, 0.0f);
                        objectsYulius.get(x).translateObject(temp.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                        objectsYulius.get(28).translateObject(temp2.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                    }
                }
                checkRotate17++;
            }
            if (checkRotate17 > -100 && !arah2){
                for (int x = 25;x<=28;x++) {
                    if(x == 25){
                        Vector3f temp = objectsYulius.get(x).updateCenterPoint();
                        Vector3f temp2 = objectsYulius.get(26).updateCenterPoint();
                        objectsYulius.get(x).translateObject(temp.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                        objectsYulius.get(26).translateObject(temp2.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                        objectsYulius.get(x).rotateObject((float) Math.toRadians(.5f), 1.0f, 0.0f, 0.0f);
                        objectsYulius.get(26).rotateObject((float) Math.toRadians(.5f), 1.0f, 0.0f, 0.0f);
                        objectsYulius.get(x).translateObject(temp.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                        objectsYulius.get(26).translateObject(temp2.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                    }if(x == 27){
                        Vector3f temp = objectsYulius.get(x).updateCenterPoint();
                        Vector3f temp2 = objectsYulius.get(28).updateCenterPoint();
                        objectsYulius.get(x).translateObject(temp.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                        objectsYulius.get(28).translateObject(temp2.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                        objectsYulius.get(x).rotateObject((float) Math.toRadians(.5f), -1.0f, 0.0f, 0.0f);
                        objectsYulius.get(28).rotateObject((float) Math.toRadians(.5f), -1.0f, 0.0f, 0.0f);
                        objectsYulius.get(x).translateObject(temp.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                        objectsYulius.get(28).translateObject(temp2.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                    }
                }
                checkRotate17--;
            }


            for (Sphere object : objectsYulius){
                object.scaleObject(1.001f, 1.001f, 1.001f);
            }

            for (Circle2 object : objectsCircle){
                object.scaleObject(1.001f, 1.001f, 1.001f);
            }
            if(checkRotate17 >= 100){
                checkRotate17 = 100;
                arah2 = false;
            }
            if(checkRotate17 <= -100){
                checkRotate17 = -100;
                arah2 = true;
            }
        }


        if (window.isKeyPressed(GLFW_KEY_S)) {
            Vector3f tempCenterPoint = objectsYulius.get(23).updateCenterPoint();
            if (checkRotate17 < 100 && arah2){
                for (int x = 25;x<=28;x++) {
                    if(x == 25){
                        Vector3f temp = objectsYulius.get(x).updateCenterPoint();
                        Vector3f temp2 = objectsYulius.get(26).updateCenterPoint();
                        objectsYulius.get(x).translateObject(temp.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                        objectsYulius.get(26).translateObject(temp2.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                        objectsYulius.get(x).rotateObject((float) Math.toRadians(.5f), -1.0f, 0.0f, 0.0f);
                        objectsYulius.get(26).rotateObject((float) Math.toRadians(.5f), -1.0f, 0.0f, 0.0f);
                        objectsYulius.get(x).translateObject(temp.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                        objectsYulius.get(26).translateObject(temp2.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);}
                    if(x == 27){
                        Vector3f temp = objectsYulius.get(x).updateCenterPoint();
                        Vector3f temp2 = objectsYulius.get(28).updateCenterPoint();
                        objectsYulius.get(x).translateObject(temp.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                        objectsYulius.get(28).translateObject(temp2.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                        objectsYulius.get(x).rotateObject((float) Math.toRadians(.5f), 1.0f, 0.0f, 0.0f);
                        objectsYulius.get(28).rotateObject((float) Math.toRadians(.5f), 1.0f, 0.0f, 0.0f);
                        objectsYulius.get(x).translateObject(temp.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                        objectsYulius.get(28).translateObject(temp2.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                    }
                }
                checkRotate17++;
            }
            if (checkRotate17 > -100 && !arah2){
                for (int x = 25;x<=28;x++) {
                    if(x == 25){
                        Vector3f temp = objectsYulius.get(x).updateCenterPoint();
                        Vector3f temp2 = objectsYulius.get(26).updateCenterPoint();
                        objectsYulius.get(x).translateObject(temp.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                        objectsYulius.get(26).translateObject(temp2.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                        objectsYulius.get(x).rotateObject((float) Math.toRadians(.5f), 1.0f, 0.0f, 0.0f);
                        objectsYulius.get(26).rotateObject((float) Math.toRadians(.5f), 1.0f, 0.0f, 0.0f);
                        objectsYulius.get(x).translateObject(temp.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                        objectsYulius.get(26).translateObject(temp2.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                    }
                    if(x == 27){
                        Vector3f temp = objectsYulius.get(x).updateCenterPoint();
                        Vector3f temp2 = objectsYulius.get(28).updateCenterPoint();
                        objectsYulius.get(x).translateObject(temp.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                        objectsYulius.get(28).translateObject(temp2.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                        objectsYulius.get(x).rotateObject((float) Math.toRadians(.5f), -1.0f, 0.0f, 0.0f);
                        objectsYulius.get(28).rotateObject((float) Math.toRadians(.5f), -1.0f, 0.0f, 0.0f);
                        objectsYulius.get(x).translateObject(temp.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                        objectsYulius.get(28).translateObject(temp2.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                    }
                }
                checkRotate17--;
            }


            for (Sphere object : objectsYulius){
                object.scaleObject(0.999f, 0.999f, 0.999f);
            }

            for (Circle2 object : objectsCircle){
                object.scaleObject(0.999f, 0.999f, 0.999f);
            }
            if(checkRotate17 >= 100){
                checkRotate17 = 100;
                arah2 = false;
            }
            if(checkRotate17 <= -100){
                checkRotate17 = -100;
                arah2 = true;
            }
        }

        if(window.isKeyPressed(GLFW_KEY_C)) {
            Vector3f center = objectsYulius.get(16).updateCenterPoint();
            if(checkRotate16 < 120 && arah) {
                for(int i = 19; i <= 20; i++) {
                    objectsYulius.get(i).translateObject(center.x * -1, center.y * -1, center.z * -1);
                    if (i == 19) {
                        objectsYulius.get(i).rotateObject((float)Math.toRadians(0.8f), 1.0f, 1.0f, 0.0f);
                        objectsYulius.get(22).translateObject(center.x * -1, center.y * -1, center.z * -1);
                        objectsYulius.get(22).rotateObject((float)Math.toRadians(0.8f), 1.0f, 1.0f, 0.0f);
                        objectsYulius.get(22).translateObject(center.x * 1, center.y * 1, center.z * 1);
                    }
                    if (i == 20) {
                        objectsYulius.get(i).rotateObject((float)Math.toRadians(0.8f), -1.0f, 1.0f, 0.0f);
                        objectsYulius.get(21).translateObject(center.x * -1, center.y * -1, center.z * -1);
                        objectsYulius.get(21).rotateObject((float)Math.toRadians(0.8f), 1.0f, -1.0f, 0.0f);
                        objectsYulius.get(21).translateObject(center.x * 1, center.y * 1, center.z * 1);
                    }
                    objectsYulius.get(i).translateObject(center.x * 1, center.y * 1, center.z * 1);
                }

                checkRotate16++;
            }
            if(checkRotate16 > 0 && !arah) {
                for(int i = 19; i <= 20; i++) {
                    objectsYulius.get(i).translateObject(center.x * -1, center.y * -1, center.z * -1);
                    if (i == 19) {
                        objectsYulius.get(i).rotateObject((float)Math.toRadians(0.8f), -1.0f, -1.0f, 0.0f);
                        objectsYulius.get(22).translateObject(center.x * -1, center.y * -1, center.z * -1);
                        objectsYulius.get(22).rotateObject((float)Math.toRadians(0.8f), -1.0f, -1.0f, 0.0f);
                        objectsYulius.get(22).translateObject(center.x * 1, center.y * 1, center.z * 1);
                    }
                    if (i == 20) {
                        objectsYulius.get(i).rotateObject((float)Math.toRadians(0.8f), 1.0f, -1.0f, 0.0f);
                        objectsYulius.get(21).translateObject(center.x * -1, center.y * -1, center.z * -1);
                        objectsYulius.get(21).rotateObject((float)Math.toRadians(0.8f), -1.0f, 1.0f, 0.0f);
                        objectsYulius.get(21).translateObject(center.x * 1, center.y * 1, center.z * 1);
                    }
                    objectsYulius.get(i).translateObject(center.x * 1, center.y * 1, center.z * 1);
                }
                checkRotate16--;
            }
            if(checkRotate16 >= 120) {
                checkRotate16 = 120;
                arah = false;
            }
            if(checkRotate16 <= 0) {
                checkRotate16 = 0;
                arah = true;
            }

        }

        if (window.isKeyPressed(GLFW_KEY_J)) {
            Vector3f center = objectsYulius.get(23).updateCenterPoint();
            if(checkRotate5 < 60 && arah) {
                for(int i = 0; i <= 28; i++) {
                    objectsYulius.get(i).translateObject(center.x * -1, center.y * -1, center.z * -1);
                    if (i == 19 || i == 22 || i == 25 || i == 26) {
                        objectsYulius.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    }
                    else if (i == 20 || i == 21 || i == 27 || i == 28) {
                        objectsYulius.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    }
                    else {
                        objectsYulius.get(i).translateObject(0.0f,0.0005f,0.0f);
                    }

                    objectsYulius.get(i).translateObject(center.x * 1, center.y * 1, center.z * 1);
                }

                checkRotate5++;
            }
            if(checkRotate5 > 0 && !arah) {
                for(int i = 0; i <= 28; i++) {
                    objectsYulius.get(i).translateObject(center.x * -1, center.y * -1, center.z * -1);
                    if (i == 19 || i == 22 || i == 25 || i == 26) {
                        objectsYulius.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    }
                    else if (i == 20 || i == 21 || i == 27 || i == 28) {
                        objectsYulius.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    }
                    else {
                        objectsYulius.get(i).translateObject(0.0f,-0.0005f,0.0f);
                    }
                    objectsYulius.get(i).translateObject(center.x * 1, center.y * 1, center.z * 1);
                }
                checkRotate5--;
            }
            if(checkRotate5 >= 60) {
                checkRotate5 = 60;
                arah = false;
            }
            if(checkRotate5 <= 0) {
                checkRotate5 = 0;
                arah = true;
            }

        }

        if(window.isKeyPressed(GLFW_KEY_L)) {
            objectsCircle.add(new Circle2(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene3.vert"
                                            , GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.frag"
                                            , GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(

                    ),
                    new Vector4f(0.0f,0.0f,0.0f,1.0f),
                    0.3f, 0.3f, 0.0f, -0.7f
            ));

            Vector3f kanan = objectsYulius.get(22).updateCenterPoint();
            Vector3f kiri = objectsYulius.get(21).updateCenterPoint();
            Vector3f celana = objectsYulius.get(23).updateCenterPoint();
            float[] titik = new float[]{kiri.x,kiri.y,celana.x,celana.y - 0.8f,kanan.x,kanan.y};
            objectsCircle.get(0).curve(titik);

            for(Object object: objectsCircle) {
                Vector3f center = objectsYulius.get(16).updateCenterPoint();
                object.translateObject(center.x * -1, (center.y+0.16f) * -1, (center.z-0.07f) * -1);
                object.rotateObject((float)Math.toRadians(0.8f), 1.0f, 0.0f, 0.0f);
                object.translateObject(center.x * 1, (center.y+0.16f)  * 1, (center.z-0.07f) * 1);
            }

            for(int i = 19; i <= 20; i++) {
                Vector3f center = objectsYulius.get(i).updateCenterPoint();
                objectsYulius.get(i).translateObject(center.x * -1, center.y * -1, center.z * -1);
                if (i == 19) {
                    objectsYulius.get(i).rotateObject((float)Math.toRadians(0.8f), 1.0f, 0.0f, 0.0f);
                    objectsYulius.get(22).translateObject(center.x * -1, center.y * -1, center.z * -1);
                    objectsYulius.get(22).rotateObject((float)Math.toRadians(0.8f), 1.0f, 0.0f, 0.0f);
                    objectsYulius.get(22).translateObject(center.x * 1, center.y * 1, center.z * 1);
                }
                if (i==20) {
                    objectsYulius.get(i).rotateObject((float)Math.toRadians(0.8f), -1.0f, 0.0f, 0.0f);
                    objectsYulius.get(21).translateObject(center.x * -1, center.y * -1, center.z * -1);
                    objectsYulius.get(21).rotateObject((float)Math.toRadians(0.8f), 1.0f, 0.0f, 0.0f);
                    objectsYulius.get(21).translateObject(center.x * 1, center.y * 1, center.z * 1);
                }
                objectsYulius.get(i).translateObject(center.x * 1, center.y * 1, center.z * 1);
            }
        }

        if(window.isKeyPressed(GLFW_KEY_P)) {
            if(objectsCircle.size() > 1) {
                objectsCircle.remove(0);
            }
        }
    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(15f,192/255f,203/255f,0.0f);
            GL.createCapabilities();
            glEnable(GL_DEPTH_TEST);
            input();
//            camera.setPosition(0,0,0.5f);
//            camera.setRotation((float)Math.toRadians(0.0f), (float)Math.toRadians(30.0f));

//            for(Object2d object2d: objects) {
//                object2d.drawWithVerticesColor();
//            }

//            for(Object2d object2d: objects) {
//                object2d.draw();
//            }

            for(Object objects: objectsYulius) {
                objects.draw();
            }

            for(Object object: objectsCircle) {
                object.drawLine();
            }
//
//
//            for(Object2d object: objectsStar) {
//                object.draw();
//            }

//            for(Object2d object: objectsPointsControl) {
//                object.drawLine();
//            }
//
//            for(Object2d object: objectMulti) {
//                object.draw();
//            }
//
//            ArrayList<Object2d> objectsBezier = calcBezierCurve(objectMulti);
//
//            for(Object2d object: objectsBezier) {
//                object.drawLine();
//            }

            glDisableVertexAttribArray(0);

            glfwPollEvents();
        }
    }

//    private static int combination(int n, int k) {
//        int result = 1;
//        for (int i = 1; i <= k; i++) {
//            result *= n - i + 1;
//            result /= i;
//        }
//        return result;
//    }

//    public static ArrayList<Object> calcBezierCurve(ArrayList <multiRect> list){
//        int n = list.size() - 1;
//        ArrayList<Object> objectsBezier = new ArrayList<>();
//        objectsBezier.add(new Object(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene3.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f,1.0f,1.0f,1.0f)
//        ));
//
//        for (float i = 0; i <= 1; i += 0.01f) {
//            float x = 0;
//            float y = 0;
//            for (int j = 0; j <= n; j++) {
//                double factor = combination(n, j) * Math.pow(1 - i, n - j) * Math.pow(i, j);
//                x += factor * list.get(j).getCenterX();
//                y += factor * list.get(j).getCenterY();
//            }
//            objectsBezier.get(0).addVertices((new Vector3f(x, y, 0)));
//        }
//        return objectsBezier;
//    }

    public void run() {
        init();
        loop();

        // Terminate GLFW and
        // free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public static void main(String[] args) {
        new Jihan().run();
    }
}
