import Engine.*;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Project {
    private Window window =
            new Window
                    (800,800,"Hello World");
    private ArrayList<Object2d> objects
            = new ArrayList<>();

    private ArrayList<Object2d> objectsRectangle
            = new ArrayList<>();

    private Circle objectsCircle;
    private Circle objectsCircle2;

    private Circle smoke1;
    private Circle smoke2;
    private Circle smoke3;

    private ArrayList<Object2d> objectsPointControl = new ArrayList<>();
    private ArrayList<Circle> objectsPointControl2 = new ArrayList<>();

    private ArrayList<Spehere> speheres = new ArrayList<>();
    private ArrayList<Spehere> baling = new ArrayList<>();
    private ArrayList<Spehere> background = new ArrayList<>();
    private ArrayList<Spehere> rumah = new ArrayList<>();

    private ArrayList<Float> titikAwal = new ArrayList<>();
    int checkRotate = 0;
    public boolean arahGerak = true;// true = kanan, false = kiri

    int checkRotate1 = 0;
    public boolean arahGerak1 = true;// true = kanan, false = kiri

    int checkRotate2= 0;
    public boolean arahGerak2 = true;// true = kanan, false = kiri

    int checkRotate3 = 0;
    public boolean arahGerak3 = true;// true = kanan, false = kiri

    int checkRotate4 = 0;
    public boolean arahGerak4 = true;// true = kanan, false = kiri



    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(),window.getHeight());
    // Define camera vectors


    public void init(){
        window.init();
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);

        camera.setPosition(0,0,-3.0f);
        camera.setRotation((float) Math.toRadians(0f),(float) Math.toRadians(180.0f));

        background.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(150/255f, 75/255f, 0f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        background.get(0).scaleObject(0.2f,1.0f,0.1f);
        background.get(0).translateObject(-1f,-0.3f,0.5f);
        background.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(75/255f, 135/255f, 59/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        background.get(1).scaleObject(0.15f,0.15f,0.1f);
        background.get(1).translateObject(-1f,0.315f,0.5f);
        background.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(75/255f, 135/255f, 59/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        background.get(2).scaleObject(0.15f,0.15f,0.1f);
        background.get(2).translateObject(-1.1f,0.25f,0.5f);
        background.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(75/255f, 135/255f, 59/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        background.get(3).scaleObject(0.15f,0.15f,0.1f);
        background.get(3).translateObject(-0.9f,0.25f,0.5f);
        background.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(150/255f, 75/255f, 0f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        background.get(4).scaleObject(0.2f,1.0f,0.1f);
        background.get(4).translateObject(1f,-0.3f,0.5f);
        background.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(75/255f, 135/255f, 59/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        background.get(5).scaleObject(0.15f,0.15f,0.1f);
        background.get(5).translateObject(1f,0.315f,0.5f);
        background.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(75/255f, 135/255f, 59/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        background.get(6).scaleObject(0.15f,0.15f,0.1f);
        background.get(6).translateObject(1.1f,0.25f,0.5f);
        background.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(75/255f, 135/255f, 59/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        background.get(7).scaleObject(0.15f,0.15f,0.1f);
        background.get(7).translateObject(0.9f,0.25f,0.5f);

        //kotak atas
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(207/255f, 206/255f, 200/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        rumah.get(0).scaleObject(1f,1f,1.0f);
        rumah.get(0).translateObject(0.0f,0.6f,1.5f);
        //atap atas kiri
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(152/255f, 122/255f, 126/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        rumah.get(1).scaleObject(0.6f,0.05f,1.0f);
        rumah.get(1).translateObject(0.25f,1.15f,1.5f);
        Vector3f tempss = rumah.get(1).updateCenterPoint();
        rumah.get(1).translateObject(tempss.x * -1, tempss.y * -1, tempss.z * -1);
        rumah.get(1).rotateObject((float)Math.toRadians(5f),0.0f,0.0f,-3.0f);
        rumah.get(1).translateObject(tempss.x * 1, tempss.y * 1, tempss.z * 1);
        //atap atas kanan
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(152/255f, 122/255f, 126/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        rumah.get(2).scaleObject(0.6f,0.05f,1.0f);
        rumah.get(2).translateObject(-0.25f,1.15f,1.5f);
        tempss = rumah.get(2).updateCenterPoint();
        rumah.get(2).translateObject(tempss.x * -1, tempss.y * -1, tempss.z * -1);
        rumah.get(2).rotateObject((float)Math.toRadians(5f),0.0f,0.0f,3.0f);
        rumah.get(2).translateObject(tempss.x * 1, tempss.y * 1, tempss.z * 1);
        //payung atas
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(183/255f, 148/255f, 121/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        rumah.get(3).scaleObject(0.6f,0.02f,0.1f);
        rumah.get(3).translateObject(0.0f,1f,0.95f);
        tempss = rumah.get(3).updateCenterPoint();
        rumah.get(3).translateObject(tempss.x * -1, tempss.y * -1, tempss.z * -1);
        rumah.get(3).rotateObject((float)Math.toRadians(5f),-10.0f,0.0f,0.0f);
        rumah.get(3).translateObject(tempss.x * 1, tempss.y * 1, tempss.z * 1);
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(187/255f, 180/255f, 144/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        rumah.get(4).scaleObject(0.3f,0.4f,0.1f);
        rumah.get(4).translateObject(0.25f,0.74f,0.95f);
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(92/255f, 98/255f, 114/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        rumah.get(5).scaleObject(0.5f,0.4f,0.1f);
        rumah.get(5).translateObject(-0.15f,0.74f,0.95f);
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(177/255f, 192/255f, 199/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        rumah.get(6).scaleObject(0.2f,0.15f,0.01f);
        rumah.get(6).translateObject(-0.02f,0.84f,0.9f);
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(177/255f, 192/255f, 199/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        rumah.get(7).scaleObject(0.2f,0.15f,0.01f);
        rumah.get(7).translateObject(-0.26f,0.84f,0.9f);
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(177/255f, 192/255f, 199/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        rumah.get(8).scaleObject(0.2f,0.15f,0.01f);
        rumah.get(8).translateObject(-0.02f,0.65f,0.9f);
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(177/255f, 192/255f, 199/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        rumah.get(9).scaleObject(0.2f,0.15f,0.01f);
        rumah.get(9).translateObject(-0.26f,0.65f,0.9f);
        //kotak bawah
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(207/255f, 206/255f, 200/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        rumah.get(10).scaleObject(1.5f,1f,2.0f);
        rumah.get(10).translateObject(-0.25f,-0.4f,1f);
        //atap bawah kiri
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(152/255f, 122/255f, 126/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        rumah.get(11).scaleObject(1f,0.05f,0.9f);
        rumah.get(11).translateObject(0.05f,0.15f,0.4f);
        tempss = rumah.get(11).updateCenterPoint();
        rumah.get(11).translateObject(tempss.x * -1, tempss.y * -1, tempss.z * -1);
        rumah.get(11).rotateObject((float)Math.toRadians(5f),0.0f,0.0f,-3.0f);
        rumah.get(11).translateObject(tempss.x * 1, tempss.y * 1, tempss.z * 1);
        //atap bawah kanan
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(152/255f, 122/255f, 126/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        rumah.get(12).scaleObject(1f,0.05f,0.9f);
        rumah.get(12).translateObject(-0.55f,0.15f,0.4f);
        tempss = rumah.get(12).updateCenterPoint();
        rumah.get(12).translateObject(tempss.x * -1, tempss.y * -1, tempss.z * -1);
        rumah.get(12).rotateObject((float)Math.toRadians(5f),0.0f,0.0f,3.0f);
        rumah.get(12).translateObject(tempss.x * 1, tempss.y * 1, tempss.z * 1);
        //payung bawah kiri
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(183/255f, 148/255f, 121/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        rumah.get(13).scaleObject(0.5f,0.02f,0.05f);
        rumah.get(13).translateObject(0.12f,-0.05f,-0.05f);
        tempss = rumah.get(13).updateCenterPoint();
        rumah.get(13).translateObject(tempss.x * -1, tempss.y * -1, tempss.z * -1);
        rumah.get(13).rotateObject((float)Math.toRadians(5f),-10.0f,0.0f,0.0f);
        rumah.get(13).translateObject(tempss.x * 1, tempss.y * 1, tempss.z * 1);
        //payung bawah kanan
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(183/255f, 148/255f, 121/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        rumah.get(14).scaleObject(0.3f,0.02f,0.05f);
        rumah.get(14).translateObject(-0.65f,-0.05f,-0.05f);
        tempss = rumah.get(14).updateCenterPoint();
        rumah.get(14).translateObject(tempss.x * -1, tempss.y * -1, tempss.z * -1);
        rumah.get(14).rotateObject((float)Math.toRadians(5f),-10.0f,0.0f,0.0f);
        rumah.get(14).translateObject(tempss.x * 1, tempss.y * 1, tempss.z * 1);
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(187/255f, 180/255f, 144/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        rumah.get(15).scaleObject(0.2f,0.4f,0.1f);
        rumah.get(15).translateObject(0.33f,-0.3f,-0.05f);
        //jendela bawah dasar
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(92/255f, 98/255f, 114/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        rumah.get(16).scaleObject(0.4f,0.4f,0.1f);
        rumah.get(16).translateObject(0f,-0.3f,-0.05f);
        //jendela depan kiri atas
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(177/255f, 192/255f, 199/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        rumah.get(17).scaleObject(0.15f,0.15f,0.01f);
        rumah.get(17).translateObject(0.1f,-0.2f,-0.1f);
        //jendela depan kanan atas
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(177/255f, 192/255f, 199/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        rumah.get(18).scaleObject(0.15f,0.15f,0.01f);
        rumah.get(18).translateObject(-0.1f,-0.2f,-0.1f);
        //jendela depan kiri bawah
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(177/255f, 192/255f, 199/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        rumah.get(19).scaleObject(0.15f,0.15f,0.01f);
        rumah.get(19).translateObject(0.1f,-0.4f,-0.1f);
        //jendela depan kanan bawah
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(177/255f, 192/255f, 199/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        rumah.get(20).scaleObject(0.15f,0.15f,0.01f);
        rumah.get(20).translateObject(-0.1f,-0.4f,-0.1f);
        //pintu merah
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(199/255f, 150/255f, 139/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        rumah.get(21).scaleObject(0.4f,0.6f,0.1f);
        rumah.get(21).translateObject(-0.65f,-0.4f,-0.05f);
        //jendela putih pintu
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(153/255f, 153/255f, 173/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        rumah.get(22).scaleObject(0.15f,0.2f,0.01f);
        rumah.get(22).translateObject(-0.65f,-0.25f,-0.1f);
        //gagang pintu
        rumah.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(146/255f, 129/255f, 134/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        rumah.get(23).scaleObject(0.02f,0.02f,0.02f);
        rumah.get(23).translateObject(-0.8f,-0.4f,-0.11f);




        //Erick
        //badan
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(81/255f, 161/255f, 196/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        speheres.get(0).scaleObject(0.55f,0.218f,0.3f);
        speheres.get(0).translateObject(0.0f,-0.15f,0.05f);
//        badan
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(81/255f, 161/255f, 196/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        speheres.get(1).scaleObject(0.29f,0.218f,0.3f);
        speheres.get(1).translateObject(0.0f,0.02f,0.0f);
        //badan
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(81/255f, 161/255f, 196/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        speheres.get(2).scaleObject(0.29f,0.218f,0.3f);
        speheres.get(2).translateObject(0.0f,-0.32f,0f);
//        //kepala
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(81/255f, 161/255f, 196/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        speheres.get(3).scaleObject(0.3f,0.3f,0.2f);
        speheres.get(3).translateObject(0.0f,0.447f,0f);
        //kalung
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(1.0f, 0.0f, 0.0f, 0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        speheres.get(4).scaleObject(0.29f,0.03f,0.3f);
        speheres.get(4).translateObject(0.0f,0.2f,0f);
        //lengan kiri
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(81/255f, 161/255f, 196/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,15
        ));
        speheres.get(5).scaleObject(0.15f,0.25f,0.2f);
        speheres.get(5).translateObject(-0.3f,-0.08f,0.0f);
        //lengan kanan
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(81/255f, 161/255f, 196/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,16
        ));
        speheres.get(6).scaleObject(0.15f,0.25f,0.2f);
        speheres.get(6).translateObject(0.3f,-0.08f,0.0f);
//        //kaki kiri putih
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        speheres.get(7).scaleObject(0.23f,0.06f,0.2f);
        speheres.get(7).translateObject(-0.18f,-0.52f,-0.0f);
        //kaki kanan putih
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        speheres.get(8).scaleObject(0.23f,0.06f,0.2f);
        speheres.get(8).translateObject(0.18f,-0.52f,-0.0f);
//        speheres.add(new Spehere(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ), new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
//                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
//        ));
//        speheres.get(9).scaleObject(0.25f,0.21f,0.1f);
//        speheres.get(9).translateObject(0.0f,0.41f,-0.2f);
        //bagian muka putih 1
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        speheres.get(9).scaleObject(0.24f,0.2f,0.1f);
        speheres.get(9).translateObject(0.0f,0.41f,-0.15f);
        //mata hitam kiri
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(0f, 0f, 0f, 0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        speheres.get(10).scaleObject(0.07f,0.075f,0.05f);
        speheres.get(10).translateObject(-0.07f,0.6f,-0.21f);
        //mata hitam kanan
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(0f, 0f, 0f, 0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        speheres.get(11).scaleObject(0.07f,0.075f,0.05f);
        speheres.get(11).translateObject(0.07f,0.6f,-0.21f);
        //mata putih kiri
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(1.00f, 1.0f, 1.0f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        speheres.get(12).scaleObject(0.064f,0.069f,0.06f);
        speheres.get(12).translateObject(-0.07f,0.6f,-0.22f);

        //mata putih kanan
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(1.00f, 1.0f, 1.0f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        speheres.get(13).scaleObject(0.064f,0.069f,0.06f);
        speheres.get(13).translateObject(0.07f,0.6f,-0.22f);
        //pupil kiri
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(0f, 0f, 0f, 0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        speheres.get(14).scaleObject(0.01f,0.01f,0.01f);
        speheres.get(14).translateObject(-0.05f,0.56f,-0.265f);
        //pupil kanan
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(0f, 0f, 0f, 0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        speheres.get(15).scaleObject(0.01f,0.01f,0.01f);
        speheres.get(15).translateObject(0.05f,0.56f,-0.265f);
        //hidung merah
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(1.0f, 0f, 0f, 0.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        speheres.get(16).scaleObject(0.044f,0.044f,0.03f);
        speheres.get(16).translateObject(0.0f,0.51f,-0.25f);
        //hidung putih
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        speheres.get(17).scaleObject(0.01f,0.01f,0.0f);
        speheres.get(17).translateObject(-0.01f,0.5f,-0.28f);
        //mulut hitam kiri
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,16
        ));
        speheres.get(18).scaleObject(0.09f,0.05f,0.03f);
        speheres.get(18).translateObject(-0.07f,0.32f,-0.21f);
        //mulut hitam kanan
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,15
        ));
        speheres.get(19).scaleObject(0.09f,0.05f,0.03f);
        speheres.get(19).translateObject(0.07f,0.32f,-0.21f);
        //mulut putih kiri
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,16
        ));
        speheres.get(20).scaleObject(0.09f,0.05f,0.03f);
        speheres.get(20).translateObject(-0.07f,0.33f,-0.22f);
        //mulut putih kanan
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,15
        ));
        speheres.get(21).scaleObject(0.09f,0.05f,0.03f);
        speheres.get(21).translateObject(0.07f,0.33f,-0.22f);
        //tangan kiri
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        speheres.get(22).scaleObject(0.07f,0.07f,0.1f);
        speheres.get(22).translateObject(-0.38f,-0.34f,0.0f);
        //tangan kanan putih
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        speheres.get(23).scaleObject(0.07f,0.07f,0.1f);
        speheres.get(23).translateObject(0.38f,-0.34f,-0.0f);
        //badan putih
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        speheres.get(24).scaleObject(0.25f,0.25f,0.1f);
        speheres.get(24).translateObject(0.0f,-0.15f,-0.26f);
        //lonceng
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(218/255f, 165/255f, 32/255f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        speheres.get(25).scaleObject(0.05f,0.05f,0.02f);
        speheres.get(25).translateObject(0.0f,0.15f,-0.3f);
        //lonceng hitam
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(0f, 0f, 0f, 0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        speheres.get(26).scaleObject(0.01f,0.01f,0f);
        speheres.get(26).translateObject(-0.01f,0.13f,-0.32f);
        //bola hijau
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(0f, 128/255f, 0f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        speheres.get(27).scaleObject(0.06f,0.06f,0.02f);
        speheres.get(27).translateObject(0.0f,-0.15f,-0.1f);
        //kantong hitam
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(0f, 0f, 0f, 0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,17
        ));
        speheres.get(28).scaleObject(0.2f,0.2f,0.05f);
        speheres.get(28).translateObject(0.0f,-0.075f,-0.34f);
        //kantong putih
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,17
        ));
        speheres.get(29).scaleObject(0.19f,0.19f,0.05f);
        speheres.get(29).translateObject(0.0f,-0.08f,-0.35f);
        //kumis lurus
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(0f, 0f, 0f, 0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        speheres.get(30).scaleObject(0.005f,0.17f,0.01f);
        speheres.get(30).translateObject(0.0f,0.375f,-0.26f);
        //kumis kiri tengah
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(0f, 0f, 0f, 0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        speheres.get(31).scaleObject(0.15f,0.005f,0.01f);
        speheres.get(31).translateObject(-0.1f,0.42f,-0.25f);
        //kumis kiri tengah
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(0f, 0f, 0f, 0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        speheres.get(32).scaleObject(0.15f,0.005f,0.01f);
        speheres.get(32).translateObject(0.1f,0.42f,-0.25f);
        //kumis kiri atas
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(0f, 0f, 0f, 0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        speheres.get(33).scaleObject(0.15f,0.005f,0.01f);
        speheres.get(33).translateObject(-0.1f,0.46f,-0.25f);
        Vector3f temp = speheres.get(33).updateCenterPoint();
        speheres.get(33).translateObject(temp.x * -1, temp.y * -1,temp.z * -1);
        speheres.get(33).rotateObject((float)Math.toRadians(5f),0.0f,0.0f,-1.0f);
        speheres.get(33).translateObject(temp.x * 1, temp.y * 1,temp.z * 1);
        //kumis kanan atas
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(0f, 0f, 0f, 0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        speheres.get(34).scaleObject(0.15f,0.005f,0.01f);
        speheres.get(34).translateObject(0.1f,0.46f,-0.25f);
        temp = speheres.get(34).updateCenterPoint();
        speheres.get(34).translateObject(temp.x * -1, temp.y * -1,temp.z * -1);
        speheres.get(34).rotateObject((float)Math.toRadians(5f),0.0f,0.0f,1.0f);
        speheres.get(34).translateObject(temp.x * 1, temp.y * 1,temp.z * 1);

        //kumis kiri bawah
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(0f, 0f, 0f, 0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        speheres.get(35).scaleObject(0.15f,0.005f,0.01f);
        speheres.get(35).translateObject(-0.1f,0.38f,-0.25f);
        temp = speheres.get(35).updateCenterPoint();
        speheres.get(35).translateObject(temp.x * -1, temp.y * -1,temp.z * -1);
        speheres.get(35).rotateObject((float)Math.toRadians(5f),0.0f,0.0f,1.0f);
        speheres.get(35).translateObject(temp.x * 1, temp.y * 1,temp.z * 1);
        //kumis kanan bawah
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(0f, 0f, 0f, 0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
        ));
        speheres.get(36).scaleObject(0.15f,0.005f,0.01f);
        speheres.get(36).translateObject(0.1f,0.38f,-0.25f);
        temp = speheres.get(36).updateCenterPoint();
        speheres.get(36).translateObject(temp.x * -1, temp.y * -1,temp.z * -1);
        speheres.get(36).rotateObject((float)Math.toRadians(5f),0.0f,0.0f,-1.0f);
        speheres.get(36).translateObject(temp.x * 1, temp.y * 1,temp.z * 1);
        //silinder baling-baling
        baling.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(1.0f, 1.0f, 224/255f, 0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,18
        ));
        baling.get(0).scaleObject(0.01f,0.1f,0.01f);
        baling.get(0).translateObject(0.0f,0.765f,0.f);
        //baling"
        baling.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(1.0f, 1.0f, 224/255f, 0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,17
        ));
        baling.get(1).scaleObject(0.1f,0.025f,0.01f);
        baling.get(1).translateObject(0.0f,0.82f,0f);
        for(Spehere objects: speheres){
            objects.translateObject(0.0f,0.0f,-0.2f);
        }
        for(Spehere objects: baling){
            objects.translateObject(0.0f,0.0f,-0.2f);
        }
        for(Spehere objects: rumah){
            objects.scaleObject(1.5f,1.5f,1.0f);
        }


    }

    public void inputSurya(ArrayList<Spehere> speheres,ArrayList<Spehere> baling){
        //Lonceng muter
        if(window.isKeyPressed(GLFW_KEY_G)){
            Vector3f temp = speheres.get(4).updateCenterPoint();
            for (int x = 25; x<=26;x++){
                speheres.get(x).translateObject(temp.x * -1, (temp.y-0.03f)*-1, temp.z *-1);
                speheres.get(x).rotateObject((float) Math.toRadians(1f), 0.0f, 0.0f, -1.0f);
                speheres.get(x).translateObject(temp.x * 1, (temp.y-0.03f)*1, temp.z *1);
            }
        }
        //pupil muter
        if(window.isKeyPressed(GLFW_KEY_F)){
            for (int x = 14;x<=15;x++) {
                Vector3f tempCenterPoint = speheres.get(x-2).updateCenterPoint();
                speheres.get(x).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                if(x==14){
                    speheres.get(x).rotateObject((float) Math.toRadians(.5f), 0.0f, 0.0f, 1.0f);
                }else{
                    speheres.get(x).rotateObject((float) Math.toRadians(.5f), 0.0f, 0.0f, -1.0f);
                }
                speheres.get(x).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
            }

        }
        //muter biasa
        if(window.isKeyPressed(GLFW_KEY_E)){
            for (Spehere object : speheres){
                Vector3f temp = speheres.get(0).updateCenterPoint();
                object.translateObject(temp.x * -1, temp.y * -1,temp.z * -1);
                object.rotateObject((float) Math.toRadians(.5f), 0.0f, 1.0f, 0.0f);
                object.translateObject(temp.x * 1, temp.y * 1,temp.z * 1);
            }
            for (Spehere object : baling){
                Vector3f temp = speheres.get(0).updateCenterPoint();
                object.translateObject(temp.x * -1, temp.y * -1,temp.z * -1);
                object.rotateObject((float) Math.toRadians(.5f), 0.0f, 1.0f, 0.0f);
                object.translateObject(temp.x * 1, temp.y * 1,temp.z * 1);
            }
            for (Spehere object : rumah){
                object.rotateObject((float) Math.toRadians(.5f), 0.0f, 1.0f, 0.0f);
            }

        }
        //kantong ajaib
        if(window.isKeyPressed(GLFW_KEY_H)){
//            speheres.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            Vector3f tempcenterPoint = speheres.get(28).updateCenterPoint();
            speheres.get(27).translateObject(tempcenterPoint.x * -1, tempcenterPoint.y * -1, tempcenterPoint.z * -1);
            speheres.get(27).rotateObject((float)Math.toRadians(.5f),0f,0f,1.0f);
            speheres.get(27).translateObject(tempcenterPoint.x * 1, tempcenterPoint.y * 1, tempcenterPoint.z * 1);
        }

        //Gerak
        if(window.isKeyPressed(GLFW_KEY_A)){
            Vector3f tempCenter = speheres.get(4).updateCenterPoint();
//            for (int y = 7;y<=10;y++){
//                speheres.get(y).translateObject(tempCenter.x * -1, tempCenter.y * -1, tempCenter.z * -1);
//                if(y == 7 || y == 9){
//                    speheres.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
//                }else{
//                    speheres.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
//                }
//                speheres.get(y).translateObject(tempCenter.x * 1, tempCenter.y * 1, tempCenter.z * 1);
//            }
//            if(abs(kakiKanan.x - kakiKiri.x) <= 0.622){
            if(checkRotate < 55 && arahGerak){
                for (int y = 7;y<=8;y++){
                    speheres.get(y).translateObject(tempCenter.x * -1, tempCenter.y * -1, tempCenter.z * -1);
                    if(y == 7){
                        speheres.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    }else{
                        speheres.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    }
                    speheres.get(y).translateObject(tempCenter.x * 1, tempCenter.y * 1, tempCenter.z * 1);
                }
                checkRotate++;
            }
            if(checkRotate > -20 && !arahGerak){
                for (int y = 7;y<=8;y++) {
                    speheres.get(y).translateObject(tempCenter.x * -1, tempCenter.y * -1, tempCenter.z * -1);
                    if (y == 7) {
                        speheres.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    } else {
                        speheres.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    }
                    speheres.get(y).translateObject(tempCenter.x * 1, tempCenter.y * 1, tempCenter.z * 1);
                }
                checkRotate --;
            }
            if(checkRotate >= 55){
                checkRotate = 55;
                arahGerak = false;
            }
            if(checkRotate <= -20){
                checkRotate = -20;
                arahGerak = true;
            }

//            }else if(abs(kakiKanan.x - kakiKiri.x) >= 0.36) {
//                System.out.println("uyl");
//            }
            for (Spehere objects: speheres){
                Vector3f tempCenterPoint = speheres.get(22).updateCenterPoint();
                if(tempCenterPoint.x <= -0.9){
                    break;
                }
                tempCenterPoint = speheres.get(23).updateCenterPoint();
                if(tempCenterPoint.x <= -0.9){
                    break;
                }
                objects.translateObject(-0.001f,0.0f,0.0f);
            }
            for(Circle objects: objectsPointControl2){
                Vector3f tempCenterPoint = speheres.get(22).updateCenterPoint();
                if(tempCenterPoint.x <= -0.9){
                    break;
                }
                tempCenterPoint = speheres.get(23).updateCenterPoint();
                if(tempCenterPoint.x <= -0.9){
                    break;
                }
                objects.translateObject(-0.001f,0.0f,0.0f);
            }
            for(Object2d objects: baling){
                Vector3f tempCenterPoint = speheres.get(22).updateCenterPoint();
                if(tempCenterPoint.x <= -0.9){
                    break;
                }
                tempCenterPoint = speheres.get(23).updateCenterPoint();
                if(tempCenterPoint.x <= -0.9){
                    break;
                }
                objects.translateObject(-0.001f,0.0f,0.0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_S)) {
            Vector3f tempCenterPoint = speheres.get(34).updateCenterPoint();
            if (checkRotate3 < 60 && arahGerak3){
                for (int x = 7;x<=8;x++) {
                    Vector3f temp = speheres.get(x).updateCenterPoint();
                    speheres.get(x).translateObject(temp.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                    if(x == 7){
                        speheres.get(x).rotateObject((float) Math.toRadians(.5f), 1.0f, 0.0f, 0.0f);
                    }else{
                        speheres.get(x).rotateObject((float) Math.toRadians(.5f), -1.0f, 0.0f, 0.0f);
                    }
                    speheres.get(x).translateObject(temp.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                }
                checkRotate3++;
            }
            if (checkRotate3 > -60 && !arahGerak3){
                for (int x = 7;x<=8;x++) {
                    Vector3f temp = speheres.get(x).updateCenterPoint();
                    speheres.get(x).translateObject(temp.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                    if(x == 7){
                        speheres.get(x).rotateObject((float) Math.toRadians(.5f), -1.0f, 0.0f, 0.0f);
                    }else{
                        speheres.get(x).rotateObject((float) Math.toRadians(.5f), 1.0f, 0.0f, 0.0f);
                    }
                    speheres.get(x).translateObject(temp.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                }
                checkRotate3--;
            }

            for (Spehere object : speheres){
                object.scaleObject(0.999f, 0.999f, 0.999f);
            }
            for (Spehere object : baling){
                object.scaleObject(0.999f, 0.999f, 0.999f);
            }
            for (Circle object : objectsPointControl2){
                object.scaleObject(0.999f, 0.999f, 0.999f);
            }
            if(checkRotate3 >= 60){
                checkRotate3 = 60;
                arahGerak3 = false;
            }
            if(checkRotate3 <= -60){
                checkRotate3 = -60;
                arahGerak3 = true;
            }
        }
        if (window.isKeyPressed(GLFW_KEY_D)) {
            Vector3f tempCenter = speheres.get(4).updateCenterPoint();
            if(checkRotate1 < 55 && arahGerak1){
                for (int y = 7;y<=8;y++){
                    speheres.get(y).translateObject(tempCenter.x * -1, tempCenter.y * -1, tempCenter.z * -1);
                    if(y == 7){
                        speheres.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    }else{
                        speheres.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    }
                    speheres.get(y).translateObject(tempCenter.x * 1, tempCenter.y * 1, tempCenter.z * 1);
                }
                checkRotate1++;
            }
            if(checkRotate1 > -20 && !arahGerak1){
                for (int y = 7;y<=8;y++) {
                    speheres.get(y).translateObject(tempCenter.x * -1, tempCenter.y * -1, tempCenter.z * -1);
                    if (y == 7) {
                        speheres.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    } else {
                        speheres.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    }
                    speheres.get(y).translateObject(tempCenter.x * 1, tempCenter.y * 1, tempCenter.z * 1);
                }
                checkRotate1 --;
            }
            if(checkRotate1 >= 55){
                checkRotate1 = 55;
                arahGerak1 = false;
            }
            if(checkRotate1 <= -20){
                checkRotate1 = -20;
                arahGerak1 = true;
            }
            for (Spehere objects: speheres){
                Vector3f tempCenterPoint = speheres.get(22).updateCenterPoint();
                if(tempCenterPoint.x >= 0.9){
                    break;
                }
                tempCenterPoint = speheres.get(23).updateCenterPoint();
                if(tempCenterPoint.x >= 0.9){
                    break;
                }
                objects.translateObject(0.001f,0f,0.0f);
            }
            for (Circle objects: objectsPointControl2){
                Vector3f tempCenterPoint = speheres.get(22).updateCenterPoint();
                if(tempCenterPoint.x >= 0.9){
                    break;
                }
                tempCenterPoint = speheres.get(23).updateCenterPoint();
                if(tempCenterPoint.x >= 0.9){
                    break;
                }
                objects.translateObject(0.001f,0f,0.0f);
            }
            for (Spehere objects: baling){
                Vector3f tempCenterPoint = speheres.get(22).updateCenterPoint();
                if(tempCenterPoint.x >= 0.9){
                    break;
                }
                tempCenterPoint = speheres.get(23).updateCenterPoint();
                if(tempCenterPoint.x >= 0.9){
                    break;
                }
                objects.translateObject(0.001f,0f,0.0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_W)) {
            Vector3f tempCenterPoint = speheres.get(34).updateCenterPoint();
            if (checkRotate2 < 60 && arahGerak2){
                for (int x = 7;x<=8;x++) {
                    Vector3f temp = speheres.get(x).updateCenterPoint();
                    speheres.get(x).translateObject(temp.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                    if(x == 7){
                        speheres.get(x).rotateObject((float) Math.toRadians(.5f), -1.0f, 0.0f, 0.0f);
                    }else{
                        speheres.get(x).rotateObject((float) Math.toRadians(.5f), 1.0f, 0.0f, 0.0f);
                    }
                    speheres.get(x).translateObject(temp.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                }
                checkRotate2++;
            }
            if (checkRotate2 > -60 && !arahGerak2){
                for (int x = 7;x<=8;x++) {
                    Vector3f temp = speheres.get(x).updateCenterPoint();
                    speheres.get(x).translateObject(temp.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                    if(x == 7){
                        speheres.get(x).rotateObject((float) Math.toRadians(.5f), 1.0f, 0.0f, 0.0f);
                    }else{
                        speheres.get(x).rotateObject((float) Math.toRadians(.5f), -1.0f, 0.0f, 0.0f);
                    }
                    speheres.get(x).translateObject(temp.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                }
                checkRotate2--;
            }


            for (Spehere object : speheres){
                object.scaleObject(1.001f, 1.001f, 1.001f);
            }
            for (Spehere object : baling){
                object.scaleObject(1.001f, 1.001f, 1.001f);
            }
            for (Circle object : objectsPointControl2){
                object.scaleObject(1.001f, 1.001f, 1.001f);
            }
            if(checkRotate2 >= 60){
                checkRotate2 = 60;
                arahGerak2 = false;
            }
            if(checkRotate2 <= -60){
                checkRotate2 = -60;
                arahGerak2 = true;
            }
        }
//        if (window.isKeyPressed(GLFW_KEY_V)) {
//            if (speheres.size() < 45){
//                Vector3f temp = speheres.get(27).updateCenterPoint();
//                speheres.add(new Spehere(
//                        Arrays.asList(
//                                //shaderFile lokasi menyesuaikan objectnya
//                                new ShaderProgram.ShaderModuleData
//                                        ("resources/shaders/scene.vert"
//                                                , GL_VERTEX_SHADER),
//                                new ShaderProgram.ShaderModuleData
//                                        ("resources/shaders/scene.frag"
//                                                , GL_FRAGMENT_SHADER)
//                        ), new Vector4f(1.0f, 0f, 0f, 0f),
//                        1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
//                ));
//                speheres.get(44).scaleObject(0.05f,0.4f,0.05f);
//                speheres.get(44).translateObject(temp.x,temp.y + 0.2f,temp.z);
//                Vector3f test = speheres.get(44).updateCenterPoint();
//                speheres.add(new Spehere(
//                        Arrays.asList(
//                                //shaderFile lokasi menyesuaikan objectnya
//                                new ShaderProgram.ShaderModuleData
//                                        ("resources/shaders/scene.vert"
//                                                , GL_VERTEX_SHADER),
//                                new ShaderProgram.ShaderModuleData
//                                        ("resources/shaders/scene.frag"
//                                                , GL_FRAGMENT_SHADER)
//                        ), new Vector4f(212/255f, 175/255f, 55/255f, 0f),
//                        1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,17
//                ));
//                speheres.get(45).scaleObject(0.03f,0.05f,0.05f);
//                speheres.get(45).translateObject(test.x,test.y + 0.2f,test.z);
//            }
//        }
//        if (window.isKeyPressed(GLFW_KEY_T)) {
//            if (speheres.size() == 46){
//                Vector3f temp = speheres.get(45).updateCenterPoint();
//                speheres.add(new Spehere(
//                        Arrays.asList(
//                                //shaderFile lokasi menyesuaikan objectnya
//                                new ShaderProgram.ShaderModuleData
//                                        ("resources/shaders/scene.vert"
//                                                , GL_VERTEX_SHADER),
//                                new ShaderProgram.ShaderModuleData
//                                        ("resources/shaders/scene.frag"
//                                                , GL_FRAGMENT_SHADER)
//                        ), new Vector4f(254/255f, 230/255f, 168/255f, 0f),
//                        1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
//                ));
//                speheres.get(46).scaleObject(0.03f,0.01f,0.05f);
//                speheres.get(46).translateObject(temp.x,temp.y,temp.z);
//                speheres.add(new Spehere(
//                        Arrays.asList(
//                                //shaderFile lokasi menyesuaikan objectnya
//                                new ShaderProgram.ShaderModuleData
//                                        ("resources/shaders/scene.vert"
//                                                , GL_VERTEX_SHADER),
//                                new ShaderProgram.ShaderModuleData
//                                        ("resources/shaders/scene.frag"
//                                                , GL_FRAGMENT_SHADER)
//                        ), new Vector4f(254/255f, 230/255f, 168/255f, 0.5f),
//                        1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,19
//                ));
//                speheres.get(47).scaleObject(0.1f,0.2f,0.05f);
//                speheres.get(47).translateObject(temp.x,temp.y+0.01f,temp.z);
//            }
//        }
        if (window.isKeyPressed(GLFW_KEY_Q)) {
            for (Object2d object: speheres){
                object.translateObject(0.0f,0.0f, -1.5f);
                object.rotateObject((float) Math.toRadians(0.5f),0.0f,1.0f,0.0f);
                object.translateObject(0.0f,0.0f, 1.5f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_0)) {
            camera.addRotation(0f, (float) Math.toRadians(1f));
        }
//        if (window.isKeyPressed(GLFW_KEY_Y)) {
//            if (speheres.size() >= 48){
//                speheres.remove(47);
//                speheres.remove(46);
//            }
//        }

        if (window.isKeyPressed(GLFW_KEY_B)) {
            Vector3f tempCenterPoint = speheres.get(22).updateCenterPoint();
            Vector3f temps = speheres.get(4).updateCenterPoint();
            if (checkRotate4 < 60 && arahGerak4){
                for (int x = 22;x<=23;x++) {
                    speheres.get(x).translateObject(temps.x * -1, (temps.y) * -1, temps.z * -1);
                    if(x == 22){
                        speheres.get(x).rotateObject((float) Math.toRadians(.5f), 0.0f, -1.0f, 0.0f);
                    }else{
                        speheres.get(x).rotateObject((float) Math.toRadians(.5f), 0f, 1.0f, 0.0f);
                    }
                    speheres.get(x).translateObject(temps.x * 1, temps.y * 1, temps.z * 1);
                }
                for (int x = 5;x<=6;x++) {
                    speheres.get(x).translateObject(temps.x * -1, (temps.y) * -1, temps.z * -1);
                    if(x == 5){
                        speheres.get(x).rotateObject((float) Math.toRadians(.5f), 0f, -1.0f, 0.0f);
                    }else{
                        speheres.get(x).rotateObject((float) Math.toRadians(.5f), 0f, 1.0f, 0.0f);
                    }
                    speheres.get(x).translateObject(temps.x * 1, temps.y * 1, temps.z * 1);
                }
                for (int x = 7;x<=8;x++) {
                    Vector3f temp = speheres.get(x).updateCenterPoint();
                    speheres.get(x).translateObject(temp.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                    if(x == 7){
                        speheres.get(x).rotateObject((float) Math.toRadians(.5f), 0.0f, -1.0f, 0.0f);
                    }else{
                        speheres.get(x).rotateObject((float) Math.toRadians(.5f), 0f, 1.0f, 0.0f);
                    }
                    speheres.get(x).translateObject(temp.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                }
                checkRotate4++;
            }
            if (checkRotate4 > -60 && !arahGerak4){
                for (int x = 22;x<=23;x++) {
                    speheres.get(x).translateObject(temps.x * -1, (temps.y) * -1, temps.z * -1);
                    if(x == 22){
                        speheres.get(x).rotateObject((float) Math.toRadians(.5f), 0f, 1.0f, 0.0f);
                    }else{
                        speheres.get(x).rotateObject((float) Math.toRadians(.5f), 0f, -1.0f, 0.0f);
                    }
                    speheres.get(x).translateObject(temps.x * 1, temps.y * 1, temps.z * 1);
                }
                for (int x = 5;x<=6;x++) {
                    speheres.get(x).translateObject(temps.x * -1, (temps.y) * -1, temps.z * -1);
                    if(x == 5){
                        speheres.get(x).rotateObject((float) Math.toRadians(.5f), 0f, 1.0f, 0.0f);
                    }else{
                        speheres.get(x).rotateObject((float) Math.toRadians(.5f), 0f, -1.0f, 0.0f);
                    }
                    speheres.get(x).translateObject(temps.x * 1, temps.y * 1, temps.z * 1);
                }
                for (int x = 7;x<=8;x++) {
                    Vector3f temp = speheres.get(x).updateCenterPoint();
                    speheres.get(x).translateObject(temp.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                    if(x == 7){
                        speheres.get(x).rotateObject((float) Math.toRadians(.5f), 0.0f, 1.0f, 0.0f);
                    }else{
                        speheres.get(x).rotateObject((float) Math.toRadians(.5f), 0.0f, -1.0f, 0.0f);
                    }
                    speheres.get(x).translateObject(temp.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                }
                checkRotate4--;
            }

            if(checkRotate4 >= 60){
                checkRotate4 = 60;
                arahGerak4 = false;
            }
            if(checkRotate4 <= -60){
                checkRotate4 = -60;
                arahGerak4 = true;
            }
        }
        if (window.isKeyPressed(GLFW_KEY_Z)) {
            Vector3f tanganKiri = speheres.get(22).updateCenterPoint();
            Vector3f tanganKanan = speheres.get(23).updateCenterPoint();
            Vector3f kepala = speheres.get(3).updateCenterPoint();
            Vector3f kaki = speheres.get(7).updateCenterPoint();
            Vector3f balingtemp = baling.get(1).updateCenterPoint();
            baling.get(1).translateObject(balingtemp.x * -1,balingtemp.y * -1,balingtemp.z * -1);
            baling.get(1).rotateObject(0.2f,0.0f,1.0f,0.0f);
            baling.get(1).translateObject(balingtemp.x * 1,balingtemp.y * 1,balingtemp.z * 1);


            if(tanganKiri.x <= -0.9 && !(kepala.y >= 0.6)){
                for (Spehere objects: speheres){
                    objects.translateObject(0.0f,0.001f,0.0f);
                }
                for (Circle objects: objectsPointControl2){
                    objects.translateObject(0.0f,0.001f,0.0f);
                }
                for (Object2d objects: baling){
                    objects.translateObject(0.0f,0.001f,0.0f);
                }
            }  else if (kepala.y >= 0.6 && !(tanganKanan.x >= 0.9)) {
                for (Spehere objects: speheres){
                    objects.translateObject(0.001f,0f,0.0f);
                }
                for (Circle objects: objectsPointControl2){
                    objects.translateObject(0.001f,0f,0.0f);
                }
                for (Object2d objects: baling){
                    objects.translateObject(0.001f,0f,0.0f);
                }
            } else if (tanganKanan.x >= 0.9 && !(kaki.y <= -0.9)) {
                for (Spehere objects: speheres){
                    objects.translateObject(0f,-0.001f,0.0f);
                }
                for (Circle objects: objectsPointControl2){
                    objects.translateObject(0f,-0.001f,0.0f);
                }
                for (Object2d objects: baling){
                    objects.translateObject(0f,-0.001f,0.0f);
                }
            } else if (kaki.y <= -0.9 && !(tanganKiri.x <= -0.9)) {
                for (Spehere objects: speheres){
                    objects.translateObject(-0.001f,0.0f,0.0f);
                }
                for(Circle objects: objectsPointControl2){
                    objects.translateObject(-0.001f,0.0f,0.0f);
                }
                for(Object2d objects: baling){
                    objects.translateObject(-0.001f,0.0f,0.0f);
                }
            }else{
                for (Spehere objects: speheres){
                    objects.translateObject(-0.001f,0.0f,0.0f);
                }
                for(Circle objects: objectsPointControl2){
                    objects.translateObject(-0.001f,0.0f,0.0f);
                }
                for(Object2d objects: baling){
                    objects.translateObject(-0.001f,0.0f,0.0f);
                }
            }
        }
    }

    public void loop(){
        while(window.isOpen()){
            window.update();
            glClearColor(15f,192/255f,203/255f,0.0f);
            GL.createCapabilities();
            glEnable(GL_DEPTH_TEST);

            for (Object2d object: speheres){
                object.drawwithCamera(camera,projection);
            }
//            buatKotak();

//            for (Object2d object: background){
//                object.drawwithCamera(camera,projection);
//            }
            for (Object2d object: rumah){
                object.drawwithCamera(camera,projection);
            }
//            for (Object2d object: speheres){
//                object.drawwithCamera(camera,projection);
//            }
            for (Object2d object: baling){
                object.drawwithCamera(camera,projection);
            }
            inputSurya(speheres,baling);


            //code
//            for (Object2d object: objects){
//                object.drawwithCamera(camera,projection);
//            }
//            for (Object2d object: objectsPointControl){
//                object.drawwithCamera(camera,projection);
//            }
//
//            ArrayList<Object2d> objectsBer = calcBezierCurve(objectsPointControl2);
//
//            for(Object2d objects : objectsBer){
//                objects.drawLine();
//            }





            // Restore state
            glDisableVertexAttribArray(0);

            // Poll for window events.
            // The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }
    public void run() {

        init();
        loop();

        // Terminate GLFW and
        // free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public boolean cekCollision(ArrayList<Circle> list,float x, float y){
        for (Circle object: list ){
            float jarak = (float)Math.sqrt(Math.pow(x-object.xr,2)+ Math.pow(y-object.yr,2));
            if(jarak <= 0.2f){
                return true;
            }
        }
        return false;
    }
    public int cekDrag(ArrayList<Circle> list,float x, float y){
        int index = 0;
        for (Circle object: list ){
            float jarak = (float)Math.sqrt(Math.pow(x-object.xr,2)+ Math.pow(y-object.yr,2));
            if(jarak <= 0.1f){
                return index;
            }
            index++;
        }
        return -1;
    }
    private static int combination(int n, int k) {
        int result = 1;
        for (int i = 1; i <= k; i++) {
            result *= n - i + 1;
            result /= i;
        }
        return result;
    }


    public static void main(String[] args) {
        new Project().run();

    }
}