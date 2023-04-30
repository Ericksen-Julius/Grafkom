import Engine.*;
import Engine.Object;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class test {
    private Window window =
            new Window
                    (1920,1080,"Hello World");
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
    private ArrayList<Ceer> objectsCeer = new ArrayList<>();
    private ArrayList<Circle2> YuliusCurve = new ArrayList<>();
    private ArrayList<Sphere> objectsYulius = new ArrayList<>();
    private ArrayList<SphereAris> objectsAris = new ArrayList<>();

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
    int checkRotate5 = 0;
    public boolean arah = true;// true = kanan, false = kiri

    int checkRotate6 = 0;
    int checkRotate7 = 0;
    public boolean arahGerak7 = true;// true = kanan, false = kiri
    public boolean arahGerak6 = true;// true = kanan, false = kiri
    int checkRotate8 = 0;
    public boolean arahGerak8 = true;// true = kanan, false = kiri
    int checkRotate9 = 0;
    public boolean arahGerak9 = true;// true = kanan, false = kiri

    int checkRotate13 = 0;
    public boolean arahGerak13 = true;// true = kanan, false = kiri

    int checkRotate14 = 0;
    public boolean arahGerak14 = true;// true = kanan, false = kiri
    int checkRotate15 = 0;
    public boolean arahGerak15 = true;// true = kanan, false = kiri



    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(),window.getHeight());
    // Define camera vectors


    public void init(){
        window.init();
        GL.createCapabilities();
//        glEnable(GL_DEPTH_TEST);

        camera.setPosition(0f,0.5f,-3.0f);
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
        //Yulius

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.98f,0.776f,0.4f,1.0f), 0.1f,0.1f, 0.0f, 0.0f, 0.0f, 0.1f, 1
        ));

        objectsYulius.get(0).scaleObject(2.5f,2.7f,2.0f);
        objectsYulius.get(0).translateObject(0.0f, 0.18f, -0.007f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.867f,0.502f,0.498f,1.0f), 0.1f,0.1f, 0.0f, 0.0f, 0.0f, 0.1f, 1
        ));

        objectsYulius.get(1).scaleObject(2.5f,0.5f,2.0f);
        objectsYulius.get(1).translateObject(0.0f, 0.18f, -0.007f);

        //head1
        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.961f,0.631f,0.475f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1
        ));

        objectsYulius.get(2).scaleObject(0.115f,0.1f,0.11f);
        objectsYulius.get(2).translateObject(0.0f, 0.6f, 0.0f);

        //head2
        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.961f,0.631f,0.475f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1
        ));

        objectsYulius.get(3).scaleObject(0.13f,0.13f,0.11f);
        objectsYulius.get(3).translateObject(0.0f,0.52f,0.0f);

        //mataitam1
        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f,0.0f,0.0f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1
        ));

        objectsYulius.get(4).scaleObject(0.015f,0.025f,0.0f);
        objectsYulius.get(4).translateObject(-0.05f,0.6f,0.1f);

        //mataitam2
        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f,0.0f,0.0f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1
        ));

        objectsYulius.get(5).scaleObject(0.015f,0.025f,0.0f);
        objectsYulius.get(5).translateObject(0.05f,0.6f,0.1f);

        //mataputih1
        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.996f,0.996f,1.0f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1
        ));

        objectsYulius.get(6).scaleObject(0.005f,0.008f,0.0f);
        objectsYulius.get(6).translateObject(0.05f,0.6f,0.1f);

        //mataputih2
        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.996f,0.996f,1.0f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1
        ));

        objectsYulius.get(7).scaleObject(0.005f,0.008f,0.0f);
        objectsYulius.get(7).translateObject(-0.05f,0.6f,0.1f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f,0.0f,0.0f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1
        ));

        objectsYulius.get(8).scaleObject(0.04f,0.03f,0.0f);
        objectsYulius.get(8).translateObject(0.0f,0.53f,0.11f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.961f,0.631f,0.475f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1
        ));

        objectsYulius.get(9).scaleObject(0.036f,0.026f,0.04f);
        objectsYulius.get(9).translateObject(0.0f,0.53f,0.11f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.675f,0.439f,0.463f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1
        ));

        objectsYulius.get(10).scaleObject(0.07f,0.03f,0.0f);
        objectsYulius.get(10).translateObject(0.0f,0.448f,0.09f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.961f,0.631f,0.475f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1
        ));
        objectsYulius.get(11).scaleObject(0.07f,0.03f,0.0f);
        objectsYulius.get(11).translateObject(0.0f,0.47f,0.08f);


        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.961f,0.631f,0.475f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1
        ));

        objectsYulius.get(12).scaleObject(0.03f,0.04f,0.02f);
        objectsYulius.get(12).translateObject(-0.125f,0.59f,0.02f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.961f,0.631f,0.475f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1
        ));

        objectsYulius.get(13).scaleObject(0.03f,0.04f,0.02f);
        objectsYulius.get(13).translateObject(0.125f,0.59f,0.02f);


        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.816f,0.529f,0.412f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1
        ));

        objectsYulius.get(14).scaleObject(0.005f,0.009f,0.0f);
        objectsYulius.get(14).translateObject(-0.125f,0.59f,0.02f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.816f,0.529f,0.412f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1
        ));

        objectsYulius.get(15).scaleObject(0.005f,0.009f,0.0f);
        objectsYulius.get(15).translateObject(0.125f,0.59f,0.02f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f,0.0f,0.0f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 2
        ));
        objectsYulius.get(16).scaleObject(0.2f,0.05f,0.17f);
        objectsYulius.get(16).translateObject(0.0f,0.675f,0.0f);


        //celana
        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.545f,0.325f,0.302f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 2
        ));
        objectsYulius.get(17).scaleObject(0.1f,0.21f,0.1f);
        objectsYulius.get(17).translateObject(0.1f,-0.11f,-0.007f);


        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.545f,0.325f,0.302f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 2
        ));

        objectsYulius.get(18).scaleObject(0.1f,0.21f,0.1f);
        objectsYulius.get(18).translateObject(-0.1f,-0.11f,-0.007f);


        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.545f,0.325f,0.302f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 2
        ));

        objectsYulius.get(19).scaleObject(0.37f,0.1f,0.26f);
        objectsYulius.get(19).translateObject(0.0f,-0.05f,-0.007f);


        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.259f,0.4f,0.467f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1
        ));

        objectsYulius.get(20).scaleObject(0.06f,0.025f,0.1f);
        objectsYulius.get(20).translateObject(-0.1f,-0.23f,0.01f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.259f,0.4f,0.467f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1
        ));

        objectsYulius.get(21).scaleObject(0.06f,0.025f,0.1f);
        objectsYulius.get(21).translateObject(0.1f,-0.23f,0.01f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.98f,0.776f,0.4f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 3
        ));

        objectsYulius.get(22).scaleObject(0.15f,0.1f,0.1f);
        objectsYulius.get(22).translateObject(-0.28f,0.31f,0.01f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.98f,0.776f,0.4f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 4
        ));

        objectsYulius.get(23).scaleObject(0.15f,0.1f,0.1f);
        objectsYulius.get(23).translateObject(0.28f,0.31f,0.01f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.961f,0.631f,0.475f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 5
        ));

        objectsYulius.get(24).scaleObject(0.028f,0.01f,0.1f);
        objectsYulius.get(24).rotateObject((float) Math.toRadians(0.3f), 0.0f, 0.0f, 210f);
        objectsYulius.get(24).translateObject(0.45f,0.175f,0.01f);

        objectsYulius.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.961f,0.631f,0.475f,1.0f), 1.0f,1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 5
        ));

        objectsYulius.get(25).scaleObject(0.028f,0.01f,0.1f);
        objectsYulius.get(25).rotateObject((float) Math.toRadians(0.3f), 0.0f, 0.0f, -210f);
        objectsYulius.get(25).translateObject(-0.45f,0.175f,0.01f);
        //Christoper
//muka
        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(248 / 255f, 209 / 255f, 154 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 2, 0
        ));
        objectsCeer.get(0).scaleObject(0.35f, 0.2f, 0.3f);
        objectsCeer.get(0).translateObject(0.0f, 0.4f, 0.0f);

        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(56 / 255f, 60 / 255f, 36 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 5, 0
        ));
        objectsCeer.get(1).scaleObject(0.175f, 0.1f, 0.3f);
        objectsCeer.get(1).translateObject(0.0f, 0.5f, 0.0f);

        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(248 / 255f, 209 / 255f, 154 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1, 0
        ));
        objectsCeer.get(2).scaleObject(0.18f, 0.12f, 0.3f);
        objectsCeer.get(2).translateObject(0.0f, 0.3f, 0.0f);

        //leher
        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(248 / 255f, 209 / 255f, 154 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 2, 0
        ));
        objectsCeer.get(3).scaleObject(0.13f, 0.05f, 0.2f);
        objectsCeer.get(3).translateObject(0.0f, 0.2f, 0.0f);

        //badan
        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(252 / 255f, 225 / 255f, 102 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 2, 0
        ));
        objectsCeer.get(4).scaleObject(0.3f, 0.4f, 0.4f);
        objectsCeer.get(4).translateObject(0.0f, -0.025f, 0.0f);

        //celana
        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(23 / 255f, 104 / 255f, 140 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 2, 0
        ));
        objectsCeer.get(5).scaleObject(0.07f, 0.15f, 0.3f);
        objectsCeer.get(5).translateObject(-0.07f, -0.3f, 0.0f);
        objectsCeer.get(5).rotateObject((float) Math.toRadians(0.8f), 0.0f, 20f, -5f);

        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(23 / 255f, 104 / 255f, 140 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 2, 0
        ));
        objectsCeer.get(6).scaleObject(0.07f, 0.15f, 0.3f);
        objectsCeer.get(6).translateObject(0.075f, -0.3f, 0.0f);
        objectsCeer.get(6).rotateObject((float) Math.toRadians(0.8f), 0.0f, -20f, 5f);

        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(23 / 255f, 104 / 255f, 140 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 3, 0
        ));
        objectsCeer.get(7).scaleObject(0.11f, 0.1f, 0.3f);
        objectsCeer.get(7).translateObject(0.0f, -0.225f, 0.0f);

        //mata
        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(255 / 255f, 255 / 255f, 255 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 4, 0
        ));
        objectsCeer.get(8).scaleObject(0.15f, 0.15f, 0.15f);
        objectsCeer.get(8).translateObject(-0.076f, 0.4f, 0.0f);

        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(255 / 255f, 255 / 255f, 255 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 4, 0
        ));
        objectsCeer.get(9).scaleObject(0.15f, 0.15f, 0.15f);
        objectsCeer.get(9).translateObject(0.076f, 0.4f, 0.0f);

        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0 / 255f, 0 / 255f, 0 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 4, 0
        ));
        objectsCeer.get(10).scaleObject(0.04f, 0.05f, 0.15f);
        objectsCeer.get(10).translateObject(0.05f, 0.4f, 0.0f);

        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0 / 255f, 0 / 255f, 0 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 4, 0
        ));
        objectsCeer.get(11).scaleObject(0.04f, 0.05f, 0.15f);
        objectsCeer.get(11).translateObject(-0.05f, 0.4f, 0.0f);

        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(255 / 255f, 255 / 255f, 255 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 4, 0
        ));
        objectsCeer.get(12).scaleObject(0.01f, 0.01f, 0.15f);
        objectsCeer.get(12).translateObject(-0.05f, 0.4f, 0.0f);

        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(255 / 255f, 255 / 255f, 255 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 4, 0
        ));
        objectsCeer.get(13).scaleObject(0.01f, 0.01f, 0.15f);
        objectsCeer.get(13).translateObject(0.05f, 0.4f, 0.0f);

        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(245 / 255f, 207 / 255f, 151 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1, 0
        ));
        objectsCeer.get(14).scaleObject(0.02f, 0.05f, 0.15f);
        objectsCeer.get(14).translateObject(-0.19f, 0.4f, 0.0f);

        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(245 / 255f, 207 / 255f, 151 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1, 0
        ));
        objectsCeer.get(15).scaleObject(0.02f, 0.05f, 0.15f);
        objectsCeer.get(15).translateObject(0.19f, 0.4f, 0.0f);

        //hidung
        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0 / 255f, 0 / 255f, 0 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 4, 0
        ));
        objectsCeer.get(16).scaleObject(0.05f, 0.04f, 0.2f);
        objectsCeer.get(16).translateObject(0.0f, 0.32f, 0.0f);

        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(248 / 255f, 209 / 255f, 154 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 4, 0
        ));
        objectsCeer.get(17).scaleObject(0.045f, 0.035f, 0.2f);
        objectsCeer.get(17).translateObject(0.0f, 0.32f, 0.0f);

        //mulut
        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0 / 255f, 0 / 255f, 0 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 3, 0
        ));
        objectsCeer.get(18).scaleObject(0.09f, 0.035f, 0.15f);
        objectsCeer.get(18).translateObject(0.0f, 0.27f, 0.0f);

        //lengan
        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile  menlokasiyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(252 / 255f, 225 / 255f, 102 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 6, 1
        ));
        objectsCeer.get(19).scaleObject(0.2f, 0.1f, 0.3f);
        objectsCeer.get(19).translateObject(-0.23f, 0.075f, 0.0f);

        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(252 / 255f, 225 / 255f, 102 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 6, 0
        ));
        objectsCeer.get(20).scaleObject(0.2f, 0.1f, 0.3f);
        objectsCeer.get(20).translateObject(0.23f, 0.075f, 0.0f);

        //tangan
        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(248 / 255f, 209 / 255f, 154 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 4, 0
        ));
        objectsCeer.get(21).scaleObject(0.1f, 0.12f, 0.3f);
        objectsCeer.get(21).translateObject(0.45f, 0.05f, 0.0f);
        objectsCeer.get(21).rotateObject((float) Math.toRadians(0.8f), 0.0f, 0.0f, -8f);

        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(248 / 255f, 209 / 255f, 154 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 4, 0
        ));
        objectsCeer.get(22).scaleObject(0.1f, 0.12f, 0.3f);
        objectsCeer.get(22).translateObject(-0.45f, 0.05f, 0.0f);
        objectsCeer.get(22).rotateObject((float) Math.toRadians(0.8f), 0.0f, 0.0f, 10f);


        //kaki
        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile  menlokasiyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(248 / 255f, 209 / 255f, 154 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 2, 0
        ));
        objectsCeer.get(23).scaleObject(0.12f, 0.27f, 0.2f);
        objectsCeer.get(23).translateObject(-0.065f, -0.53f, 0.0f);
        objectsCeer.get(23).rotateObject((float) Math.toRadians(0.8f), 0.0f, 0.0f, -5f);

        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile  menlokasiyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(248 / 255f, 209 / 255f, 154 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 2, 0
        ));
        objectsCeer.get(24).scaleObject(0.12f, 0.27f, 0.2f);
        objectsCeer.get(24).translateObject(0.065f, -0.53f, 0.0f);
        objectsCeer.get(24).rotateObject((float) Math.toRadians(0.8f), 0.0f, 0.0f, 5f);

        //kaos kaki
        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile  menlokasiyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(255 / 255f, 255 / 255f, 255 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 2, 0
        ));
        objectsCeer.get(25).scaleObject(0.12f, 0.12f, 0.2f);
        objectsCeer.get(25).translateObject(-0.065f, -0.7f, 0.0f);
        objectsCeer.get(25).rotateObject((float) Math.toRadians(0.8f), 0.0f, 0.0f, -5f);

        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile  menlokasiyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(255 / 255f, 255 / 255f, 255 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 2, 0
        ));
        objectsCeer.get(26).scaleObject(0.12f, 0.12f, 0.2f);
        objectsCeer.get(26).translateObject(0.065f, -0.7f, 0.0f);
        objectsCeer.get(26).rotateObject((float) Math.toRadians(0.8f), 0.0f, 0.0f, 5f);

        //sepatu
        //kiri
        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile  menlokasiyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(129 / 255f, 210 / 255f, 215 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1, 0
        ));
        objectsCeer.get(27).scaleObject(0.075f, 0.08f, 0.25f);
        objectsCeer.get(27).translateObject(-0.125f, -0.85f, 0.0f);

        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile  menlokasiyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(129 / 255f, 210 / 255f, 215 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1, 0
        ));

        objectsCeer.get(28).scaleObject(0.075f, 0.08f, 0.25f);
        objectsCeer.get(28).translateObject(0.125f, -0.85f, 0.0f);


        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile  menlokasiyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(129 / 255f, 210 / 255f, 215 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1, 0
        ));
        objectsCeer.get(29).scaleObject(0.1f, 0.08f, 0.1f);
        objectsCeer.get(29).translateObject(-0.125f, -0.85f, 0.0f);

        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile  menlokasiyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(129 / 255f, 210 / 255f, 215 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1, 0
        ));
        objectsCeer.get(30).scaleObject(0.1f, 0.08f, 0.15f);
        objectsCeer.get(30).translateObject(0.125f, -0.85f, 0.0f);

        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile  menlokasiyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(207 / 255f, 220 / 255f, 238 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1, 0
        ));

        objectsCeer.get(31).scaleObject(0.075f, 0.05f, 0.25f);
        objectsCeer.get(31).translateObject(-0.125f, -0.785f, 0.0f);

        //kanan


        objectsCeer.add(new Ceer(
                Arrays.asList(
                        //shaderFile  menlokasiyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(207 / 255f, 220 / 255f, 238 / 255f, 1.0f), 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1, 0
        ));
        objectsCeer.get(32).scaleObject(0.075f, 0.05f, 0.15f);
        objectsCeer.get(32).translateObject(0.125f, -0.785f, 0.0f);



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
                ), new Vector4f(1f, 1f, 1f, 1.0f),
                1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
        ));
        speheres.get(27).scaleObject(0.06f,0.06f,0.02f);
        speheres.get(27).translateObject(0.0f,-0.25f,-0.1f);
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
            objects.translateObject(0.0f,0.0f,0.8f);
        }
        for(Spehere objects: rumah){
            objects.scaleObject(2f,2f,1.0f);
        }

        //Aris
        objectsAris.add(new SphereAris(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.792f,0.459f,0.196f,1.0f), 0.25f,0.25f,0.2f,0.09f,0.45f,0.0f, 0,0,0,1
        ));


        objectsAris.add(new SphereAris(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1,1,1,0), 0.05f,0.05f,0.01f,0.03f,0.5f,0.0f,0,0,0,1
        ));

        objectsAris.add(new SphereAris(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0,0.447f,0.698f,0), 0.04f,0.04f,0.01f,0.03f,0.5f,0.0f,0,0,0,1
        ));

        objectsAris.add(new SphereAris(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1,1,1,0), 0.05f,0.05f,0.01f,0.17f,0.5f,0.0f,0,0,0,1
        ));

        objectsAris.add(new SphereAris(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0,0.447f,0.698f,0), 0.04f,0.04f,0.0f,0.17f,0.5f,0.0f,0,0,0,1
        ));

        objectsAris.add(new SphereAris(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1,1,1,0), 0.07f,0.01f,0.0f,0.18f,0.55f,0.0f,(float)Math.toRadians(0),(float)Math.toRadians(0),(float)Math.toRadians(20),1
        ));

        objectsAris.add(new SphereAris(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1,1,1,0), 0.07f,0.01f,0.0f,0.02f,0.55f,0.0f,(float)Math.toRadians(0),(float)Math.toRadians(0),(float)Math.toRadians(-20),1
        ));

        objectsAris.add(new SphereAris(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1,1,1,0), 0.09f,0.01f,0.0f,0.016f,0.63f,0.0f,(float)Math.toRadians(0),(float)Math.toRadians(0),(float)Math.toRadians(20),1
        ));

        objectsAris.add(new SphereAris(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1,1,1,0), 0.03f,0.01f,0.0f,0.085f,0.635f,0.0f,(float)Math.toRadians(0),(float)Math.toRadians(0),(float)Math.toRadians(90),1
        ));

        objectsAris.add(new SphereAris(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1,1,1,0), 0.07f,0.01f,0.0f,0.14f,0.635f,0.0f,(float)Math.toRadians(0),(float)Math.toRadians(0),(float)Math.toRadians(20),1
        ));

        objectsAris.add(new SphereAris(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.827f, 0.129f, 0.133f,0), 0.06f,0.01f,0.0f,-0.045f,0.4f,0.0f,(float)Math.toRadians(0),(float)Math.toRadians(0),(float)Math.toRadians(115),1
        ));

        objectsAris.add(new SphereAris(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.827f, 0.129f, 0.133f,0), 0.06f,0.01f,0.0f,0.02f,0.341f,0.0f,(float)Math.toRadians(0),(float)Math.toRadians(0),(float)Math.toRadians(-20),1
        ));


//        objectsAris.add(new Sphere(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                ),
//                new Vector4f(0.792f,0.459f,0.196f,1.0f), 0.3f,0.03f,0.2f,0.1f,0.3f,0.0f,0,0,0
//        ));


        objectsAris.add(new SphereAris(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.792f,0.459f,0.196f,1.0f), 0.07f,0.2f,0.2f,0.37f,0.14f,0.0f,(float)Math.toRadians(30),(float)Math.toRadians(10),(float)Math.toRadians(35),1
        ));


        objectsAris.add(new SphereAris(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.792f,0.459f,0.196f,1.0f), 0.4f,0.4f,0.2f,0.085f,0.05f,0.0f,(float)Math.toRadians(30),(float)Math.toRadians(10),(float)Math.toRadians(35),2
        ));

//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        // shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.1f, -0.15f, 0),
//                                new Vector3f(0.28f, -0.15f, 0),
//                                new Vector3f(-0.1f, 0.3f, 0),
//                                new Vector3f(0.28f, 0.3f, 0)
//                        )
//                ),
//                new Vector4f(0.792f,0.459f,0.196f,1.0f),
//                Arrays.asList(0, 1, 2, 1, 3, 2)
//        ));


        objectsAris.add(new SphereAris(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1,1,1,0), 0.03f,0.03f,0.0f,0.09f,0.15f,0.0f,0,0,0,1
        ));

        objectsAris.add(new SphereAris(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1,1,1,0), 0.03f,0.03f,0.0f,0.09f,0.06f,0.0f,0,0,0,1
        ));

        objectsAris.add(new SphereAris(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.792f,0.459f,0.196f,1.0f), 0.07f,0.2f,0.2f,-0.18f,0.14f,0.0f,(float)Math.toRadians(30),(float)Math.toRadians(175),(float)Math.toRadians(35),1
        ));


        objectsAris.add(new SphereAris(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.792f,0.459f,0.196f,1.0f), 0.07f,0.2f,0.2f,-0.027f,-0.25f,0.0f,(float)Math.toRadians(0),(float)Math.toRadians(20),(float)Math.toRadians(0),1
        ));

        objectsAris.add(new SphereAris(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.792f,0.459f,0.196f,1.0f), 0.07f,0.2f,0.2f,0.2f,-0.25f,0.0f,(float)Math.toRadians(0),(float)Math.toRadians(20),(float)Math.toRadians(0),1
        ));

        for (ObjectAris object: objectsAris){
            object.translateObject(-1.5f,-0.25f,0.0f);
            object.scaleObject(1.5f,1.5f,0f);
        }
        for (Object2d object: speheres){
            object.translateObject(1f,1f,0.0f);
        }
        for (Object2d object: baling){
            object.translateObject(1f,1f,0.0f);
        }
        for (Ceer object: objectsCeer){
            object.translateObject(0f,.3f,0.0f);
        }
        for (Object object: objectsYulius){
            object.translateObject(1f,-.5f,0.0f);
        }
        for (Object2d object: background){
            object.scaleObject(2f,2f,0.0f);
        }
        for (Sphere object: objectsYulius){
            object.scaleObject(1.5f,1.5f,0.0f);
        }
//        for(int x = 0; x<=3;x++){
//            background.get(x).translateObject(-0.8f,-.5f,0.0f);
//        }
        objectsPointControl2.add(new Circle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(1.0f, 0f, 0f, 1.0f),
                1.0f
        ));
        float [] points = new float[]{.725f,0.7f,.675f,0.9f,.375f,0.9f,.325f,0.7f};
        objectsPointControl2.get(0).curve(points);
        for(Object2d objects: objectsPointControl2){
            objects.translateObject(0.5f,1f,-0.2f);
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
            for (Circle object : objectsPointControl2){
                Vector3f temp = speheres.get(0).updateCenterPoint();
                object.translateObject(temp.x * -1, temp.y * -1,temp.z * -1);
                object.rotateObject((float) Math.toRadians(.5f), 0.0f, 1.0f, 0.0f);
                object.translateObject(temp.x * 1, temp.y * 1,temp.z * 1);
            }
//            for (Spehere object : rumah){
//                object.rotateObject((float) Math.toRadians(.5f), 0.0f, 1.0f, 0.0f);
//            }

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
                if(tempCenterPoint.x <= -1.3){
                    break;
                }
                tempCenterPoint = speheres.get(23).updateCenterPoint();
                if(tempCenterPoint.x <= -1.3){
                    break;
                }
                objects.translateObject(-0.002f,0.0f,0.0f);
            }
            for(Circle objects: objectsPointControl2){
                Vector3f tempCenterPoint = speheres.get(22).updateCenterPoint();
                if(tempCenterPoint.x <= -1.3){
                    break;
                }
                tempCenterPoint = speheres.get(23).updateCenterPoint();
                if(tempCenterPoint.x <= -1.3){
                    break;
                }
                objects.translateObject(-0.002f,0.0f,0.0f);
            }
            for(Object2d objects: baling){
                Vector3f tempCenterPoint = speheres.get(22).updateCenterPoint();
                if(tempCenterPoint.x <= -1.3){
                    break;
                }
                tempCenterPoint = speheres.get(23).updateCenterPoint();
                if(tempCenterPoint.x <= -1.3){
                    break;
                }
                objects.translateObject(-0.002f,0.0f,0.0f);
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
                if(tempCenterPoint.x >= 1.3){
                    break;
                }
                tempCenterPoint = speheres.get(23).updateCenterPoint();
                if(tempCenterPoint.x >= 1.3){
                    break;
                }
                objects.translateObject(0.002f,0f,0.0f);
            }
            for (Circle objects: objectsPointControl2){
                Vector3f tempCenterPoint = speheres.get(22).updateCenterPoint();
                if(tempCenterPoint.x >= 1.3){
                    break;
                }
                tempCenterPoint = speheres.get(23).updateCenterPoint();
                if(tempCenterPoint.x >= 1.3){
                    break;
                }
                objects.translateObject(0.002f,0f,0.0f);
            }
            for (Spehere objects: baling){
                Vector3f tempCenterPoint = speheres.get(22).updateCenterPoint();
                if(tempCenterPoint.x >= 1.3){
                    break;
                }
                tempCenterPoint = speheres.get(23).updateCenterPoint();
                if(tempCenterPoint.x >= 1.3){
                    break;
                }
                objects.translateObject(0.002f,0f,0.0f);
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
        if (window.isKeyPressed(GLFW_KEY_V)) {
            if (speheres.size() < 38){
                Vector3f temp = speheres.get(22).updateCenterPoint();
                speheres.add(new Spehere(
                        Arrays.asList(
                                //shaderFile lokasi menyesuaikan objectnya
                                new ShaderProgram.ShaderModuleData
                                        ("resources/shaders/scene.vert"
                                                , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData
                                        ("resources/shaders/scene.frag"
                                                , GL_FRAGMENT_SHADER)
                        ), new Vector4f(1.0f, 0f, 0f, 0f),
                        1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,1
                ));
                speheres.get(37).scaleObject(0.05f,0.4f,0.05f);
                speheres.get(37).translateObject(temp.x,temp.y + 0.2f,temp.z-0.2f);
                Vector3f test = speheres.get(37).updateCenterPoint();
                speheres.add(new Spehere(
                        Arrays.asList(
                                //shaderFile lokasi menyesuaikan objectnya
                                new ShaderProgram.ShaderModuleData
                                        ("resources/shaders/scene.vert"
                                                , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData
                                        ("resources/shaders/scene.frag"
                                                , GL_FRAGMENT_SHADER)
                        ), new Vector4f(212/255f, 175/255f, 55/255f, 0f),
                        1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,17
                ));
                speheres.get(38).scaleObject(0.03f,0.05f,0.05f);
                speheres.get(38).translateObject(test.x,test.y + 0.2f,test.z);
                temp = speheres.get(38).updateCenterPoint();
                speheres.add(new Spehere(
                        Arrays.asList(
                                //shaderFile lokasi menyesuaikan objectnya
                                new ShaderProgram.ShaderModuleData
                                        ("resources/shaders/scene.vert"
                                                , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData
                                        ("resources/shaders/scene.frag"
                                                , GL_FRAGMENT_SHADER)
                        ), new Vector4f(254/255f, 230/255f, 168/255f, 0f),
                        1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,2
                ));
                speheres.get(39).scaleObject(0.03f,0.01f,0.05f);
                speheres.get(39).translateObject(temp.x,temp.y,temp.z);
                speheres.add(new Spehere(
                        Arrays.asList(
                                //shaderFile lokasi menyesuaikan objectnya
                                new ShaderProgram.ShaderModuleData
                                        ("resources/shaders/scene.vert"
                                                , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData
                                        ("resources/shaders/scene.frag"
                                                , GL_FRAGMENT_SHADER)
                        ), new Vector4f(254/255f, 230/255f, 168/255f, 0.5f),
                        1.0f,1.0f,0.0f,0.0f,0.0f,1.0f,19
                ));
                speheres.get(40).scaleObject(0.1f,0.2f,0.05f);
                speheres.get(40).translateObject(temp.x,temp.y+0.01f,temp.z);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_1)) {
                Vector3f temp = speheres.get(38).updateCenterPoint();
                speheres.get(5).translateObject(temp.x * -1, (temp.y) * -1, temp.z * -1);
                speheres.get(5).rotateObject((float)Math.toRadians(.5f),1.0f,0f,0.0f);
                speheres.get(5).translateObject(temp.x * 1, (temp.y) * 1, temp.z * 1);
                for (int x = 22;x<=23;x+=2){
                    speheres.get(x).translateObject(temp.x * -1, (temp.y * -1), temp.z * -1);
                    speheres.get(x).rotateObject((float)Math.toRadians(.5f),1.0f,0f,0.0f);
                    speheres.get(x).translateObject(temp.x * 1, (temp.y) * 1, temp.z * 1);
                }
                for (int x = 37;x<=40;x++){
                    speheres.get(x).translateObject(temp.x * -1, temp.y * -1, temp.z * -1);
                    speheres.get(x).rotateObject((float)Math.toRadians(.5f),1.0f,0f,0.0f);
                    speheres.get(x).translateObject(temp.x * 1, temp.y * 1, temp.z * 1);
                }

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


            if(tanganKiri.x <= -1.3 && !(kepala.y >= 0.9)){
                for (Spehere objects: speheres){
                    objects.translateObject(0.0f,0.001f,0.0f);
                }
                for (Circle objects: objectsPointControl2){
                    objects.translateObject(0.0f,0.001f,0.0f);
                }
                for (Object2d objects: baling){
                    objects.translateObject(0.0f,0.001f,0.0f);
                }
            }  else if (kepala.y >= 0.9 && !(tanganKanan.x >= 1.3)) {
                for (Spehere objects: speheres){
                    objects.translateObject(0.001f,0f,0.0f);
                }
                for (Circle objects: objectsPointControl2){
                    objects.translateObject(0.001f,0f,0.0f);
                }
                for (Object2d objects: baling){
                    objects.translateObject(0.001f,0f,0.0f);
                }
            } else if (tanganKanan.x >= 1.3 && !(kaki.y <= -1.3)) {
                for (Spehere objects: speheres){
                    objects.translateObject(0f,-0.001f,0.0f);
                }
                for (Circle objects: objectsPointControl2){
                    objects.translateObject(0f,-0.001f,0.0f);
                }
                for (Object2d objects: baling){
                    objects.translateObject(0f,-0.001f,0.0f);
                }
            } else if (kaki.y <= -1.3 && !(tanganKiri.x <= -1.3)) {
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
    public void inputCeer(ArrayList<Ceer> objectsSphere) {
        if (window.isKeyPressed(GLFW_KEY_A)) {
            Vector3f tempCenter = objectsSphere.get(4).updateCenterPoint();
//            for (int y = 7;y<=10;y++){
//                objectsSphere.get(y).translateObject(tempCenter.x * -1, tempCenter.y * -1, tempCenter.z * -1);
//                if(y == 7 || y == 9){
//                    objectsSphere.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
//                }else{
//                    objectsSphere.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
//                }
//                objectsSphere.get(y).translateObject(tempCenter.x * 1, tempCenter.y * 1, tempCenter.z * 1);
//            }
//            if(abs(kakiKanan.x - kakiKiri.x) <= 0.622){
            if (checkRotate6 < 55 && arahGerak6) {
                for (int y = 23; y <= 32; y++) {
                    objectsSphere.get(y).translateObject(tempCenter.x * -1, tempCenter.y * -1, tempCenter.z * -1);
                    if (y % 2 == 1) {
                        objectsSphere.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    } else {
                        objectsSphere.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    }
                    objectsSphere.get(y).translateObject(tempCenter.x * 1, tempCenter.y * 1, tempCenter.z * 1);
                }
                checkRotate6++;
            }
            if (checkRotate6 > -20 && !arahGerak6) {
                for (int y = 23; y <= 32; y++) {
                    objectsSphere.get(y).translateObject(tempCenter.x * -1, tempCenter.y * -1, tempCenter.z * -1);
                    if (y % 2 == 1) {
                        objectsSphere.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    } else {
                        objectsSphere.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    }
                    objectsSphere.get(y).translateObject(tempCenter.x * 1, tempCenter.y * 1, tempCenter.z * 1);
                }
                checkRotate6--;
            }
            if (checkRotate6 >= 55) {
                checkRotate6 = 55;
                arahGerak6 = false;
            }
            if (checkRotate6 <= -20) {
                checkRotate6 = -20;
                arahGerak6 = true;
            }

//            }else if(abs(kakiKanan.x - kakiKiri.x) >= 0.36) {
//                System.out.println("uyl");
//            }
            for (Ceer objects : objectsSphere) {
                Vector3f tempCenterPoint = objectsSphere.get(28).updateCenterPoint();
                if (tempCenterPoint.x <= -0.9) {
                    break;
                }
                objects.translateObject(-0.002f, 0.0f, 0.0f);
            }
//            for(Circle objects: objectsPointControl2){
//                Vector3f tempCenterPoint = objectsSphere.get(28).updateCenterPoint();
//                if(tempCenterPoint.x <= -0.9){
//                    break;
//                }
//                objects.translateObject(-0.001f,0.0f,0.0f);
//            }
//            for(Object2d objects: baling){
//                Vector3f tempCenterPoint = objectsSphere.get(28).updateCenterPoint();
//                if(tempCenterPoint.x <= -0.9){
//                    break;
//                }
//                objects.translateObject(-0.001f,0.0f,0.0f);
//            }
        }
        if (window.isKeyPressed(GLFW_KEY_D)) {
            Vector3f tempCenter = objectsSphere.get(4).updateCenterPoint();
            if(checkRotate7 < 55 && arahGerak7){
                for (int y = 23;y<=32;y++){
                    objectsSphere.get(y).translateObject(tempCenter.x * -1, tempCenter.y * -1, tempCenter.z * -1);
                    if(y %2==1){
                        objectsSphere.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    }else{
                        objectsSphere.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    }
                    objectsSphere.get(y).translateObject(tempCenter.x * 1, tempCenter.y * 1, tempCenter.z * 1);
                }
                checkRotate7++;
            }
            if(checkRotate7 > -20 && !arahGerak7){
                for (int y = 23;y<=32;y++) {
                    objectsSphere.get(y).translateObject(tempCenter.x * -1, tempCenter.y * -1, tempCenter.z * -1);
                    if (y %2 == 1) {
                        objectsSphere.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    } else {
                        objectsSphere.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    }
                    objectsSphere.get(y).translateObject(tempCenter.x * 1, tempCenter.y * 1, tempCenter.z * 1);
                }
                checkRotate7 --;
            }
            if(checkRotate7 >= 55){
                checkRotate7 = 55;
                arahGerak7 = false;
            }
            if(checkRotate7 <= -20){
                checkRotate7 = -20;
                arahGerak7 = true;
            }
            for (Ceer objects: objectsSphere){
                Vector3f tempCenterPoint = objectsSphere.get(29).updateCenterPoint();
                if(tempCenterPoint.x >= 0.9){
                    break;
                }
                objects.translateObject(0.002f,0f,0.0f);
            }
//            for (Circle objects: objectsPointControl2){
//                Vector3f tempCenterPoint = objectsSphere.get(29).updateCenterPoint();
//                if(tempCenterPoint.x >= 0.9){
//                    break;
//                }
//                objects.translateObject(0.001f,0f,0.0f);
//            }
//            for (Sphere objects: baling){
//                Vector3f tempCenterPoint = objectsSphere.get(29).updateCenterPoint();
//                if(tempCenterPoint.x >= 0.9){
//                    break;
//                }
//                objects.translateObject(0.001f,0f,0.0f);
//            }
        }
        if (window.isKeyPressed(GLFW_KEY_S)) {
            Vector3f tempCenterPoint = objectsSphere.get(4).updateCenterPoint();
            if (checkRotate9 < 60 && arahGerak9) {
                for (int x = 23; x <= 32; x++) {
                    Vector3f temp = objectsSphere.get(x).updateCenterPoint();
                    objectsSphere.get(x).translateObject(temp.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                    if (x %2==1) {
                        objectsSphere.get(x).rotateObject((float) Math.toRadians(.5f), 1.0f, 0.0f, 0.0f);
                    } else {
                        objectsSphere.get(x).rotateObject((float) Math.toRadians(.5f), -1.0f, 0.0f, 0.0f);
                    }
                    objectsSphere.get(x).translateObject(temp.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                }
                checkRotate9++;
            }
            if (checkRotate9 > -60 && !arahGerak9) {
                for (int x = 23; x <= 32; x++) {
                    Vector3f temp = objectsSphere.get(x).updateCenterPoint();
                    objectsSphere.get(x).translateObject(temp.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                    if (x%2==1) {
                        objectsSphere.get(x).rotateObject((float) Math.toRadians(.5f), -1.0f, 0.0f, 0.0f);
                    } else {
                        objectsSphere.get(x).rotateObject((float) Math.toRadians(.5f), 1.0f, 0.0f, 0.0f);
                    }
                    objectsSphere.get(x).translateObject(temp.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                }
                checkRotate9--;
            }

            for (Ceer object : objectsSphere) {
                object.scaleObject(0.999f, 0.999f, 0.999f);
            }
//            for (Sphere object : baling){
//                object.scaleObject(0.999f, 0.999f, 0.999f);
//            }
//            for (Circle object : objectsPointControl2){
//                object.scaleObject(0.999f, 0.999f, 0.999f);
//            }
            if (checkRotate9 >= 60) {
                checkRotate9 = 60;
                arahGerak9 = false;
            }
            if (checkRotate9 <= -60) {
                checkRotate9 = -60;
                arahGerak9 = true;
            }
        }
        if (window.isKeyPressed(GLFW_KEY_W)) {
            Vector3f tempCenterPoint = objectsSphere.get(4).updateCenterPoint();
            if (checkRotate8 < 60 && arahGerak8) {
                for (int x = 23; x <= 32; x++) {
                    Vector3f temp = objectsSphere.get(x).updateCenterPoint();
                    objectsSphere.get(x).translateObject(temp.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                    if (x % 2 == 1) {
                        objectsSphere.get(x).rotateObject((float) Math.toRadians(.5f), -1.0f, 0.0f, 0.0f);
                    } else {
                        objectsSphere.get(x).rotateObject((float) Math.toRadians(.5f), 1.0f, 0.0f, 0.0f);
                    }
                    objectsSphere.get(x).translateObject(temp.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                }
                checkRotate8++;
            }
            if (checkRotate8 > -60 && !arahGerak8) {
                for (int x = 23; x <= 32; x++) {
                    Vector3f temp = objectsSphere.get(x).updateCenterPoint();
                    objectsSphere.get(x).translateObject(temp.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                    if (x % 2 == 1) {
                        objectsSphere.get(x).rotateObject((float) Math.toRadians(.5f), 1.0f, 0.0f, 0.0f);
                    } else {
                        objectsSphere.get(x).rotateObject((float) Math.toRadians(.5f), -1.0f, 0.0f, 0.0f);
                    }
                    objectsSphere.get(x).translateObject(temp.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                }
                checkRotate8--;
            }


            for (Ceer object : objectsSphere) {
                object.scaleObject(1.001f, 1.001f, 1.001f);
            }
//            for (Sphere object : baling){
//                object.scaleObject(1.001f, 1.001f, 1.001f);
//            }
//            for (Circle object : objectsPointControl2){
//                object.scaleObject(1.001f, 1.001f, 1.001f);
//            }
            if (checkRotate8 >= 60) {
                checkRotate8 = 60;
                arahGerak8 = false;
            }
            if (checkRotate8 <= -60) {
                checkRotate8 = -60;
                arahGerak8 = true;
            }
        }
    }
    public void input(ArrayList<SphereAris> objectsSphere) {
        if (window.isKeyPressed(GLFW_KEY_F)) {

            for (SphereAris objects : objectsSphere) {
                Vector3f temp = objects.updateCenterPoint();
                objects.translateObject(0.0f, 0.0f, 0.0f);
                objects.rotateObject((float) Math.toRadians(3f), 0.0f, 0.0f, 0.0f);
                objects.translateObject(0.0f, 0.0f, 0.0f);
            }

            for (SphereAris objects : objectsSphere) {
                objects.translateObject(0.0f, 0.0f, 0.0f);

            }
        }

        if (window.isKeyPressed(GLFW_KEY_G)) {

            for (SphereAris objects : objectsSphere) {
                Vector3f temp = objects.updateCenterPoint();
                objects.translateObject(0.0f, 0.0f, 0.0f);
                objects.rotateObject((float) Math.toRadians(1f), 0.0f, -2.0f, 0.0f);
                objects.translateObject(0.0f, 0.0f, 0.0f);
            }

            for (SphereAris objects : objectsSphere) {
                objects.translateObject(0.0f, 0.0f, 0.0f);

            }
        }

        if (window.isKeyPressed(GLFW_KEY_S)) {

            for (SphereAris objects : objectsSphere) {
                Vector3f temp = objects.updateCenterPoint();
                objects.translateObject(0.0f, 0.0f, 0.0f);
                objects.rotateObject((float) Math.toRadians(1f), 0.0f, 0.0f, 0.0f);
                objects.translateObject(0.0f, 0.0f, 0.0f);
            }

            for (SphereAris objects : objectsSphere) {
                objects.translateObject(0.0f, -0.01f, 0.0f);

            }
        }

        if (window.isKeyPressed(GLFW_KEY_W)) {

            for (SphereAris objects : objectsSphere) {
                Vector3f temp = objects.updateCenterPoint();
                objects.translateObject(0.0f, 0.0f, 0.0f);
                objects.rotateObject((float) Math.toRadians(1f), 0.0f, 0.0f, 0.0f);
                objects.translateObject(0.0f, 0.0f, 0.0f);
            }

            for (SphereAris objects : objectsSphere) {
                objects.translateObject(0.0f, 0.01f, 0.0f);

            }
        }

        if (window.isKeyPressed(GLFW_KEY_A)) {

            for (SphereAris objects : objectsSphere) {
                Vector3f temp = objects.updateCenterPoint();
                objects.translateObject(0.0f, 0.0f, 0.0f);
                objects.rotateObject((float) Math.toRadians(1f), 0.0f, 0.0f, 0.0f);
                objects.translateObject(0.0f, 0.0f, 0.0f);
            }

            for (SphereAris objects : objectsSphere) {
                objects.translateObject(-0.01f, 0.0f, 0.0f);

            }
        }

        if (window.isKeyPressed(GLFW_KEY_D)) {

            for (SphereAris objects : objectsSphere) {
                Vector3f temp = objects.updateCenterPoint();
                objects.translateObject(0.0f, 0.0f, 0.0f);
                objects.rotateObject((float) Math.toRadians(1f), 0.0f, 0.0f, 0.0f);
                objects.translateObject(0.0f, 0.0f, 0.0f);
            }

            for (SphereAris objects : objectsSphere) {
                objects.translateObject(0.01f, 0.0f, 0.0f);

            }
        }

        if (window.isKeyPressed(GLFW_KEY_H)) {

            for (SphereAris object : objectsSphere) {
                object.scaleObject(1.001f, 1.001f, 1.001f);
            }
//            for (Sphere object : baling){
//                object.scaleObject(1.001f, 1.001f, 1.001f);
//            }
//            for (Circle object : objectsPointControl2){
//                object.scaleObject(1.001f, 1.001f, 1.001f);
//            }
        }

        if (window.isKeyPressed(GLFW_KEY_L)) {
            Vector3f tempCenter = objectsSphere.get(12).updateCenterPoint();
            if (checkRotate13 < 55 && arahGerak13) {
                for (int y = 17; y <= 18; y++) {
                    objectsSphere.get(y).translateObject(tempCenter.x * -1, tempCenter.y * -1, tempCenter.z * -1);
                    if (y == 17) {
                        objectsSphere.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    } else {
                        objectsSphere.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    }
                    objectsSphere.get(y).translateObject(tempCenter.x * 1, tempCenter.y * 1, tempCenter.z * 1);
                }
                checkRotate13++;
            }
            if (checkRotate13 > -20 && !arahGerak13) {
                for (int y = 17; y <= 18; y++) {
                    objectsSphere.get(y).translateObject(tempCenter.x * -1, tempCenter.y * -1, tempCenter.z * -1);
                    if (y == 17) {
                        objectsSphere.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    } else {
                        objectsSphere.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    }
                    objectsSphere.get(y).translateObject(tempCenter.x * 1, tempCenter.y * 1, tempCenter.z * 1);
                }
                checkRotate13--;
            }
            if (checkRotate13 >= 55) {
                checkRotate13 = 55;
                arahGerak13 = false;
            }
            if (checkRotate13 <= -20) {
                checkRotate13 = -20;
                arahGerak13 = true;
            }
            for (SphereAris objects : objectsSphere) {
                Vector3f tempCenterPoint = objectsSphere.get(17).updateCenterPoint();
                if (tempCenterPoint.x >= 0.9) {
                    break;
                }
                objects.translateObject(0.001f, 0f, 0.0f);
            }
//            for (Circle objects: objectsPointControl2){
//                Vector3f tempCenterPoint = speheres.get(29).updateCenterPoint();
//                if(tempCenterPoint.x >= 0.9){
//                    break;
//                }
//                objects.translateObject(0.001f,0f,0.0f);
//            }
//            for (Spehere objects: baling){
//                Vector3f tempCenterPoint = speheres.get(29).updateCenterPoint();
//                if(tempCenterPoint.x >= 0.9){
//                    break;
//                }
//                objects.translateObject(0.001f,0f,0.0f);
//            }
        }

        if (window.isKeyPressed(GLFW_KEY_J)) {
            Vector3f tempCenter = objectsSphere.get(12).updateCenterPoint();
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
            if (checkRotate14 < 55 && arahGerak14) {
                for (int y = 17; y <= 18; y++) {
                    objectsSphere.get(y).translateObject(tempCenter.x * -1, tempCenter.y * -1, tempCenter.z * -1);
                    if (y == 17) {
                        objectsSphere.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    } else {
                        objectsSphere.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    }
                    objectsSphere.get(y).translateObject(tempCenter.x * 1, tempCenter.y * 1, tempCenter.z * 1);
                }
                checkRotate14++;
            }
            if (checkRotate14 > -20 && !arahGerak14) {
                for (int y = 17; y <= 18; y++) {
                    objectsSphere.get(y).translateObject(tempCenter.x * -1, tempCenter.y * -1, tempCenter.z * -1);
                    if (y == 17) {
                        objectsSphere.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    } else {
                        objectsSphere.get(y).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    }
                    objectsSphere.get(y).translateObject(tempCenter.x * 1, tempCenter.y * 1, tempCenter.z * 1);
                }
                checkRotate14--;
            }
            if (checkRotate14 >= 55) {
                checkRotate14 = 55;
                arahGerak14 = false;
            }
            if (checkRotate14 <= -20) {
                checkRotate14 = -20;
                arahGerak14 = true;
            }

//            }else if(abs(kakiKanan.x - kakiKiri.x) >= 0.36) {
//                System.out.println("uyl");
//            }
            for (SphereAris objects : objectsSphere) {
                Vector3f tempCenterPoint = objectsSphere.get(17).updateCenterPoint();
                if (tempCenterPoint.x <= -0.9) {
                    break;
                }
                objects.translateObject(-0.001f, 0.0f, 0.0f);
            }
//            for(Circle objects: objectsPointControl2){
//                Vector3f tempCenterPoint = speheres.get(28).updateCenterPoint();
//                if(tempCenterPoint.x <= -0.9){
//                    break;
//                }
//                objects.translateObject(-0.001f,0.0f,0.0f);
//            }
//            for(Object2d objects: baling){
//                Vector3f tempCenterPoint = speheres.get(28).updateCenterPoint();
//                if(tempCenterPoint.x <= -0.9){
//                    break;
//                }
//                objects.translateObject(-0.001f,0.0f,0.0f);
//            }
        }


        if (window.isKeyPressed(GLFW_KEY_K)) {
            Vector3f tempCenterPoint = objectsSphere.get(12).updateCenterPoint();
            if (checkRotate15 < 50 && arahGerak15) {
                for (int x = 17; x <= 18; x++) {
                    Vector3f temp = objectsSphere.get(x).updateCenterPoint();
                    objectsSphere.get(x).translateObject(temp.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                    if (x == 17) {
                        objectsSphere.get(x).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
                    } else {
                        objectsSphere.get(x).rotateObject((float) Math.toRadians(0.5f), -1.0f, 0.0f, 0.0f);
                    }
                    objectsSphere.get(x).translateObject(temp.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                }
                checkRotate15++;
            }
            if (checkRotate15 > -10 && !arahGerak15) {
                for (int x = 17; x <= 18; x++) {
                    Vector3f temp = objectsSphere.get(x).updateCenterPoint();
                    objectsSphere.get(x).translateObject(temp.x * -1, (tempCenterPoint.y) * -1, tempCenterPoint.z * -1);
                    if (x == 17) {
                        objectsSphere.get(x).rotateObject((float) Math.toRadians(0.5f), -1.0f, 0.0f, 0.0f);
                    } else {
                        objectsSphere.get(x).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
                    }
                    objectsSphere.get(x).translateObject(temp.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                }
                checkRotate15--;
            }

            for (SphereAris object : objectsSphere) {
                object.scaleObject(0.999f, 0.999f, 0.999f);
            }

            if (checkRotate15 >= 60) {
                checkRotate15 = 60;
                arahGerak15 = false;
            }
            if (checkRotate15 <= -10) {
                checkRotate15 = -10;
                arahGerak15 = true;
            }

        }


//            objectsSphere.get(12).translateObject(temp.x*-1,temp.y*-1,temp.z*-1);
//            objectsSphere.get(12).rotateObject((float) Math.toRadians(1f), 0.0f, 0.0f, 1.0f);
//            objectsSphere.get(12).translateObject(temp.x*1,temp.y*1,temp.z*1);

    }
    public void inputYul(ArrayList<Sphere>objectsSphere,ArrayList<Circle2> objectsCircle){
        if(window.isKeyPressed(GLFW_KEY_A)) {
            Vector3f center = objectsSphere.get(19).updateCenterPoint();
            if(checkRotate5 < 60 && arah) {
                for(int i = 0; i <= 25; i++) {
                    objectsSphere.get(i).translateObject(center.x * -1, center.y * -1, center.z * -1);
                    if (i == 17 || i == 21) {
                        objectsSphere.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    }
                    else if (i == 18 || i == 20) {
                        objectsSphere.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    }
                    else {
                        objectsSphere.get(i).translateObject(0.0f,0.0005f,0.0f);
                    }

                    objectsSphere.get(i).translateObject(center.x * 1, center.y * 1, center.z * 1);
                }

                checkRotate5++;
            }
            if(checkRotate5 > 0 && !arah) {
                for(int i = 0; i <= 25; i++) {
                    objectsSphere.get(i).translateObject(center.x * -1, center.y * -1, center.z * -1);
                    if (i == 17 || i == 21) {
                        objectsSphere.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    }
                    else if (i == 18 || i == 20) {
                        objectsSphere.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    }
                    else {
                        objectsSphere.get(i).translateObject(0.0f,-0.0005f,0.0f);
                    }
                    objectsSphere.get(i).translateObject(center.x * 1, center.y * 1, center.z * 1);
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

            for (Sphere objects: objectsSphere){
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
            Vector3f center = objectsSphere.get(19).updateCenterPoint();
            if(checkRotate5 < 60 && arah) {
                for(int i = 0; i <= 25; i++) {
                    objectsSphere.get(i).translateObject(center.x * -1, center.y * -1, center.z * -1);
                    if (i == 17 || i == 21) {
                        objectsSphere.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    }
                    else if (i == 18 || i == 20) {
                        objectsSphere.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    }
                    else {
                        objectsSphere.get(i).translateObject(0.0f,0.0005f,0.0f);
                    }

                    objectsSphere.get(i).translateObject(center.x * 1, center.y * 1, center.z * 1);
                }

                checkRotate5++;
            }
            if(checkRotate5 > 0 && !arah) {
                for(int i = 0; i <= 25; i++) {
                    objectsSphere.get(i).translateObject(center.x * -1, center.y * -1, center.z * -1);
                    if (i == 17 || i == 21) {
                        objectsSphere.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    }
                    else if (i == 18 || i == 20) {
                        objectsSphere.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    }
                    else {
                        objectsSphere.get(i).translateObject(0.0f,-0.0005f,0.0f);
                    }
                    objectsSphere.get(i).translateObject(center.x * 1, center.y * 1, center.z * 1);
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

            for (Sphere objects: objectsSphere){
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

        if (window.isKeyPressed(GLFW_KEY_J)) {
            Vector3f center = objectsSphere.get(19).updateCenterPoint();
            if(checkRotate5 < 60 && arah) {
                for(int i = 0; i <= 25; i++) {
                    objectsSphere.get(i).translateObject(center.x * -1, center.y * -1, center.z * -1);
                    if (i == 17 || i == 21 || i == 23 || i == 24) {
                        objectsSphere.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    }
                    else if (i == 18 || i == 20 || i == 22 || i == 25) {
                        objectsSphere.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    }
                    else {
                        objectsSphere.get(i).translateObject(0.0f,0.0005f,0.0f);
                    }

                    objectsSphere.get(i).translateObject(center.x * 1, center.y * 1, center.z * 1);
                }

                checkRotate5++;
            }
            if(checkRotate5 > 0 && !arah) {
                for(int i = 0; i <= 25; i++) {
                    objectsSphere.get(i).translateObject(center.x * -1, center.y * -1, center.z * -1);
                    if (i == 17 || i == 21 || i == 23 || i == 24) {
                        objectsSphere.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, -1.0f);
                    }
                    else if (i == 18 || i == 20 || i == 22 || i == 25) {
                        objectsSphere.get(i).rotateObject((float)Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                    }
                    else {
                        objectsSphere.get(i).translateObject(0.0f,-0.0005f,0.0f);
                    }
                    objectsSphere.get(i).translateObject(center.x * 1, center.y * 1, center.z * 1);
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

        if(window.isKeyPressed(GLFW_KEY_R)) {
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

            Vector3f kanan = objectsSphere.get(24).updateCenterPoint();
            Vector3f kiri = objectsSphere.get(25).updateCenterPoint();
            Vector3f celana = objectsSphere.get(19).updateCenterPoint();
            float[] titik = new float[]{kiri.x,kiri.y,celana.x,celana.y - 0.8f,kanan.x,kanan.y};
            objectsCircle.get(0).curve(titik);

            for(Circle2 object: objectsCircle) {
                Vector3f center = objectsSphere.get(0).updateCenterPoint();
                object.translateObject(center.x * -1, (center.y+0.16f) * -1, center.z * -1);
                object.rotateObject((float)Math.toRadians(0.8f), -1.0f, 0.0f, 0.0f);
                object.translateObject(center.x * 1, (center.y+0.16f)  * 1, center.z * 1);
            }

            for(int i = 22; i <= 23; i++) {
                Vector3f center = objectsSphere.get(i).updateCenterPoint();
                objectsSphere.get(i).translateObject(center.x * -1, center.y * -1, center.z * -1);
                if (i == 23) {
                    objectsSphere.get(i).rotateObject((float)Math.toRadians(0.8f), 1.0f, 0.0f, 0.0f);
                    objectsSphere.get(24).translateObject(center.x * -1, center.y * -1, center.z * -1);
                    objectsSphere.get(24).rotateObject((float)Math.toRadians(0.8f), 1.0f, 0.0f, 0.0f);
                    objectsSphere.get(24).translateObject(center.x * 1, center.y * 1, center.z * 1);
                }
                else {
                    objectsSphere.get(i).rotateObject((float)Math.toRadians(0.8f), -1.0f, 0.0f, 0.0f);
                    objectsSphere.get(25).translateObject(center.x * -1, center.y * -1, center.z * -1);
                    objectsSphere.get(25).rotateObject((float)Math.toRadians(0.8f), 1.0f, 0.0f, 0.0f);
                    objectsSphere.get(25).translateObject(center.x * 1, center.y * 1, center.z * 1);
                }
                objectsSphere.get(i).translateObject(center.x * 1, center.y * 1, center.z * 1);
            }
        }

        if(window.isKeyPressed(GLFW_KEY_P)) {
            if(objectsCircle.size() > 1) {
                objectsCircle.remove(0);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_W)) {
            for (int x = 17;x<=21;x++) {
                Vector3f tempCenterPoint = objectsSphere.get(19).updateCenterPoint();
                if(x == 18 || x == 21) {
                    objectsSphere.get(x).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                    objectsSphere.get(x).rotateObject((float) Math.toRadians(5f), -1.0f, 0.0f, 0.0f);
                    objectsSphere.get(x).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                }
                if (x == 17 || x == 20) {
                    objectsSphere.get(x).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                    objectsSphere.get(x).rotateObject((float) Math.toRadians(5f), 1.0f, 0.0f, 0.0f);
                    objectsSphere.get(x).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                }

            }
            for (Sphere object : objectsSphere){
                object.scaleObject(1.001f, 1.001f, 1.001f);
            }
            for (Circle2 object : objectsCircle){
                object.scaleObject(1.001f, 1.001f, 1.001f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_S)) {
            for (int x = 17;x<=21;x++) {
                Vector3f tempCenterPoint = objectsSphere.get(19).updateCenterPoint();
                if(x == 18 || x == 21) {
                    objectsSphere.get(x).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                    objectsSphere.get(x).rotateObject((float) Math.toRadians(5f), -1.0f, 0.0f, 0.0f);
                    objectsSphere.get(x).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                }
                if (x == 17 || x == 20) {
                    objectsSphere.get(x).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                    objectsSphere.get(x).rotateObject((float) Math.toRadians(5f), 1.0f, 0.0f, 0.0f);
                    objectsSphere.get(x).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                }

            }
            for (Sphere object : objectsSphere){
                object.scaleObject(0.999f, 0.999f, 0.999f);
            }
            for (Circle2 object : objectsCircle){
                object.scaleObject(0.999f, 0.999f, 0.999f);
            }
        }


        if(window.isKeyPressed(GLFW_KEY_C)) {
            for(int i = 22; i <= 23; i++) {

                Vector3f center = objectsSphere.get(i).updateCenterPoint();
                objectsSphere.get(i).translateObject(center.x * -1, center.y * -1, center.z * -1);
                if(i == 23) {
                    objectsSphere.get(i).rotateObject((float)Math.toRadians(0.8f), 1.0f, 1.0f, 0.0f);
                    objectsSphere.get(24).translateObject(center.x * -1, center.y * -1, center.z * -1);
                    objectsSphere.get(24).rotateObject((float)Math.toRadians(0.8f), 1.0f, 1.0f, 0.0f);
                    objectsSphere.get(24).translateObject(center.x * 1, center.y * 1, center.z * 1);
                }
                else {
                    objectsSphere.get(i).rotateObject((float)Math.toRadians(0.8f), -1.0f, 1.0f, 0.0f);
                    objectsSphere.get(25).translateObject(center.x * -1, center.y * -1, center.z * -1);
                    objectsSphere.get(25).rotateObject((float)Math.toRadians(0.8f), 1.0f, -1.0f, 0.0f);
                    objectsSphere.get(25).translateObject(center.x * 1, center.y * 1, center.z * 1);
                }
                objectsSphere.get(i).translateObject(center.x * 1, center.y * 1, center.z * 1);
            }
        }

        if(window.isKeyPressed(GLFW_KEY_V)) {
            for (Sphere sphere : objectsSphere) {
                sphere.rotateObject((float) Math.toRadians(1.0f), 0.1f, 0.0f, 0.0f);
            }
            for (Circle2 object : objectsCircle) {
                object.rotateObject((float) Math.toRadians(1.0f), 0.1f, 0.0f, 0.0f);
            }
        }

        if(window.isKeyPressed(GLFW_KEY_Y)) {
            for (int i = 0; i < objectsSphere.size(); i++) {
                objectsSphere.get(i).rotateObject((float) Math.toRadians(1.0f), 0.0f, 0.1f,0.0f);
            }
            for (Circle2 object : objectsCircle) {
                object.rotateObject((float) Math.toRadians(1.0f), 0.0f, 0.1f, 0.0f);
            }
        }

        if(window.isKeyPressed(GLFW_KEY_U)) {
            for (int i = 0; i < objectsSphere.size(); i++) {
                objectsSphere.get(i).rotateObject((float) Math.toRadians(1.0f), 0.0f, 0.0f,0.1f);
            }
            for (Circle2 object : objectsCircle) {
                object.rotateObject((float) Math.toRadians(1.0f), 0.0f, 0.0f, 0.1f);
            }
        }
    }

    public void loop(){
        while(window.isOpen()){
            window.update();
            glClearColor(15f,192/255f,203/255f,0.0f);
            GL.createCapabilities();
//            glEnable(GL_DEPTH_TEST);
            for (Object2d object: background){
                object.drawwithCamera(camera,projection);
            }
            for (Object2d object: rumah){
                object.drawwithCamera(camera,projection);
            }
            for (Object2d object: speheres){
                object.drawwithCamera(camera,projection);
            }
            for (Object2d object: objectsPointControl2){
                object.drawwithCameraLine(camera,projection);
            }
            for(Sphere objects: objectsYulius){
                objects.drawwithCamera(camera,projection);
            }

            for (Ceer object: objectsCeer){
                object.drawwithCamera(camera,projection);
            }
//            buatKotak();

//            for (Object2d object: speheres){
//                object.drawwithCamera(camera,projection);
//            }
            for (Object2d object: baling){
                object.drawwithCamera(camera,projection);
            }
            for (ObjectAris object: objectsAris){
                object.draw(camera,projection);
            }
            inputSurya(speheres,baling);
//            inputCeer(objectsCeer);
//            input(objectsAris);
//            inputYul(objectsYulius,YuliusCurve);


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
        new test().run();

    }
}