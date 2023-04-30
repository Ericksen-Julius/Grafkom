import Engine.*;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {
    private Window window =
            new Window
                    (800,800,"Hello World");
    private ArrayList<Object2d> objects
            = new ArrayList<>();

    private ArrayList<Object2d> objectsRectangle
            = new ArrayList<>();

    private ArrayList<Object2d> objectsPointControl = new ArrayList<>();
    private ArrayList<Circle> objectsPointControl2 = new ArrayList<>();

    private ArrayList<Spehere> speheres = new ArrayList<>();

    private ArrayList<Float> titikAwal = new ArrayList<>();

    private ArrayList<Cat> cat = new ArrayList<>();

    private Circle objectsCircle;

    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(),window.getHeight());
    // Define camera vectors


    public void init(){
        window.init();
        GL.createCapabilities();
        camera.setPosition(0,0,0.5f);
        camera.setRotation((float) Math.toRadians(0.0f),(float) Math.toRadians(30.0f));

//        objectsCircle.add(new Circle(
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
//                        List.of(
//                                new Vector3f(0.0f,0.0f,0.0f),
//                                new Vector3f(0.5f,0.0f,0.0f),
//                                new Vector3f(0.0f,0.5f,0.0f),
//                                new Vector3f(0.5f,0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.0f,1.0f,1.0f,1.0f),
//                5
//
//        ));


//        objects.add(new Object2d(
//                        Arrays.asList(
//                                //shaderFile lokasi menyesuaikan objectnya
//                                new ShaderProgram.ShaderModuleData
//                                        ("resources/shaders/scene2.vert"
//                                                , GL_VERTEX_SHADER),
//                                new ShaderProgram.ShaderModuleData
//                                        ("resources/shaders/scene2.frag"
//                                                , GL_FRAGMENT_SHADER)
//                        ),
//                        new ArrayList<>(
//                                List.of(
//                                        new Vector3f(0.0f,0.5f,0.0f),
//                                        new Vector3f(-0.5f,-0.5f,0.0f),
//                                        new Vector3f(0.5f,-0.5f,0.0f)
//                                )
//                        ),
//                        new Vector4f(0.0f,0.0f,1.0f,1.0f)
//                ));

        //code
        objects.add(new Object2d(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene2.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene2.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.0f,0.5f,0.0f),
                                new Vector3f(-0.5f,-0.5f,0.0f),
                                new Vector3f(0.5f,-0.5f,0.0f)
                        )
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(1.0f,0.0f,0.0f),
                                new Vector3f(0.0f,1.0f,0.0f),
                                new Vector3f(0.0f,0.0f,1.0f)
                        )
                )
        ));
        speheres.add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(1.0f, 165/255f, 0.0f, 1.0f),
                0.5f, 0.5f, 0.0f, 0.0f, 0.0f, 0.5f

        ));
//
//        speheres.add(new Spehere(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ), new Vector4f(220/255f,220/255f,220/255f,1.0f),
//                0.5f,0.5f,0.0f,0.0f,0.0f,0.5f
//
//        ));
//        speheres.add(new Spehere(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ), new Vector4f(249/255f,215/255f,28/255f,1.0f),
//                0.5f,0.5f,0.0f,0.0f,0.0f,0.5f
//
//        ));
//
//        speheres.add(new Spehere(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ), new Vector4f(0.0f,1.0f,1.0f,1.0f),
//                0.5f,0.5f,0.0f,0.0f,0.0f,0.5f
//
//        ));
//        speheres.add(new Spehere(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ), new Vector4f(220/255f,220/255f,220/255f,1.0f),
//                0.5f,0.5f,0.0f,0.0f,0.0f,0.5f
//
//        ));
//        speheres.add(new Spehere(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ), new Vector4f(1.0f,0f,0f,1.0f),
//                0.5f,0.5f,0.0f,0.0f,0.0f,0.5f
//
//        ));


//
//
//        objectsRectangle.add(new Rectangle(
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
//                        List.of(
//                                new Vector3f(0.0f,0.0f,0.0f),
//                                new Vector3f(0.5f,0.0f,0.0f),
//                                new Vector3f(0.0f,0.5f,0.0f),
//                                new Vector3f(0.5f,0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.0f,1.0f,1.0f,1.0f),
//                Arrays.asList(0,1,2,1,2,3)
//
//        ));
//        objectsPointControl.add(new Object2d(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f,1.0f,1.0f,1.0f)
//
//        ));
//        for(int x = 1; x < speheres.size() ; x++){
//            if(x!=4){
//                speheres.get(x).scaleObject(0.1f,0.1f,0.1f);
//            }else{
//                speheres.get(x).scaleObject(0.05f,0.05f,0.05f);
//            }
//            speheres.get(x).xr = (float)(0.15 + (x*0.15));
//            speheres.get(x).translateObject((float)(0.15 + (x*0.15)),0.0f,0.0f);
//        }

        speheres.get(0).scaleObject(0.3f,0.3f,0.3f);

        speheres.get(0).getChildObject().add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(1.0f,0f,0f,1.0f),
                0.1f,0.1f,0.0f,0.0f,0.0f,0.5f
        ));
        speheres.get(0).getChildObject().add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(1.0f,0f,0f,1.0f),
                0.1f,0.1f,0.0f,0.0f,0.0f,0.5f
        ));
        speheres.get(0).getChildObject().add(new Spehere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ), new Vector4f(1.0f,0f,0f,1.0f),
                0.1f,0.1f,0.0f,0.0f,0.0f,0.5f
        ));

        speheres.get(0).getChildObject().get(0).translateObject(0.5f,0.0f,0.0f);
        speheres.get(0).getChildObject().get(1).translateObject(0.65f,0.0f,0.0f);
        speheres.get(0).getChildObject().get(2).translateObject(0.75f,0.0f,0.0f);
        speheres.get(0).getChildObject().get(0).scaleObject(0.5f,0.5f,0.45f);
        speheres.get(0).getChildObject().get(1).scaleObject(0.6f,0.6f,0.45f);
        speheres.get(0).getChildObject().get(2).scaleObject(0.7f,0.7f,0.5f);


    }

    public void input(){
        if(window.isKeyPressed(GLFW_KEY_W)){
            System.out.println("W");
        }
        if(window.getMouseInput().isLeftButtonPressed()){
            Vector2f pos = window.getMouseInput().getCurrentPos();

            pos.x = (pos.x - (window.getWidth())/2.0f) / (window.getWidth()/2.0f);

            pos.y = (pos.y - (window.getHeight())/2.0f) / (-window.getHeight()/2.0f);

            if((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))){
                System.out.println("x : " +pos.x +" y : " + pos.y);
                objectsPointControl.get(0).addVertices(new Vector3f(pos.x,pos.y,0));
            }
        }
    }
    public void inputSurya(ArrayList<Spehere> speheres){
        if(window.isKeyPressed(GLFW_KEY_G)){
            for(Object2d child: speheres.get(0).getChildObject()){
                Vector3f tempCenterPoint = child.updateCenterPoint();
                child.translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                child.rotateObject((float) Math.toRadians(0.5f),0.0f,1.0f,0.0f);
                child.translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);
            }

                Vector3f tempCenterPoint = speheres.get(0).getChildObject().get(2).updateCenterPoint();
                speheres.get(0).getChildObject().get(1).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                speheres.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(0.7f),0.0f,0.0f,1.0f);
                speheres.get(0).getChildObject().get(1).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);
                Vector3f centerPoints = speheres.get(0).updateCenterPoint();
//                speheres.get(0).translateObject(
//                        centerPoints.x*-1,
//                        centerPoints.y*-1,
//                        centerPoints.z*-1
//                );
//                speheres.get(0).rotateObject((float) Math.toRadians(0.5), 0f, 1f, 0.0f);
//                speheres.get(0).translateObject(
//                        centerPoints.x*1,
//                        centerPoints.y*1,
//                        centerPoints.z*1
//                );

//            for(int x = 0; x < speheres.size() ; x++){
//                if(x!=0 && x!= 4){
//                    Vector3f centerPoint = speheres.get(x).updateCenterPoint();
//                    speheres.get(x).translateObject(
//                            centerPoint.x*-1,
//                            centerPoint.y*-1,
//                            centerPoint.z*-1
//                    );
//                    speheres.get(x).rotateObject((float) Math.toRadians(0.5), 0f, 1f, 0.0f);
//
////                    speheres.get(x).xr = speheres.get(x).radiusX * (float)(Math.cos(Math.toRadians(speheres.get(x).currAngle)));
////                    speheres.get(x).yr = speheres.get(x).radiusY * (float)(Math.sin(Math.toRadians(speheres.get(x).currAngle)));
////                    if (speheres.get(x).currAngle + 1 < 360)
////                        speheres.get(x).currAngle++;
////                    else
////                        speheres.get(x).currAngle = 0;
//                    speheres.get(x).translateObject(
//                            centerPoint.x*1,
//                            centerPoint.y*1,
//                            centerPoint.z*1
//                    );
//                }
//            }
        }
        if(window.isKeyPressed(GLFW_KEY_F)){
            for(int x = 1; x < speheres.size() ; x++){
                speheres.get(x).rotateObject((float)(Math.toRadians(0.5)),0.0f,0.0f,1.0f);
                speheres.get(x).xr = (float) (speheres.get(x).xr * Math.cos(Math.toRadians(0.5)) - speheres.get(x).yr * Math.sin(Math.toRadians(0.5)));
                speheres.get(x).yr = (float) (speheres.get(x).xr * Math.sin(Math.toRadians(0.5)) + speheres.get(x).yr * Math.cos(Math.toRadians(0.5)));
            }
            for(Object2d child: speheres.get(0).getChildObject()){
                child.rotateObject((float)Math.toRadians(0.5),0.0f,0.0f,1.0f);
            }
        }
        if(window.isKeyPressed(GLFW_KEY_E)){
            speheres.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);

            for (Object2d child : speheres.get(0).getChildObject()) {
                Vector3f tempCenterPoint = child.updateCenterPoint();
                child.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                child.rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
                child.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
            }

            for (Object2d child : speheres.get(0).getChildObject().get(1).getChildObject()) {
                Vector3f tempCenterPoint = speheres.get(0).getChildObject().get(1).updateCenterPoint();
                child.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                child.rotateObject(0.05f, 0.0f, 0.0f, 1.0f);
                child.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
            }
        }

//        if(window.isKeyPressed(GLFW_KEY_H)){
//            float x = speheres.get(3).xr;
//            float y = speheres.get(3).yr;
//            float z =  speheres.get(3).centerZ;
//            speheres.get(4).translateObject(-x,-y,-z);
//            speheres.get(4).rotateObject((float)(Math.toRadians(0.5)),0.0f,0.0f,1.0f);
//            speheres.get(4).translateObject(x,y,z);
//        }
    }
    public void buatKotak(){
        if(window.getMouseInput().isLeftButtonPressed()){
            Vector2f pos = window.getMouseInput().getCurrentPos();

            pos.x = (pos.x - (window.getWidth())/2.0f) / (window.getWidth()/2.0f);

            pos.y = (pos.y - (window.getHeight())/2.0f) / (-window.getHeight()/2.0f);

            if((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))){
                int tes = cekDrag(objectsPointControl2,pos.x,pos.y);
                if(tes != -1){
                    objectsPointControl.get(0).update(tes, (new Vector3f(pos.x,pos.y,0)));
                    objectsPointControl2.get(tes).change(pos.x,pos.y);
                }

                if(!(cekCollision(objectsPointControl2,pos.x,pos.y))){
                    objectsPointControl.get(0).addVertices(new Vector3f(pos.x,pos.y,0));
                    objectsPointControl2.add(new Circle(
                            Arrays.asList(
                                    //shaderFile lokasi menyesuaikan objectnya
                                    new ShaderProgram.ShaderModuleData
                                            ("resources/shaders/scene.vert"
                                                    , GL_VERTEX_SHADER),
                                    new ShaderProgram.ShaderModuleData
                                            ("resources/shaders/scene.frag"
                                                    , GL_FRAGMENT_SHADER)
                            ),
                            new Vector4f(0.0f,1.0f,1.0f,1.0f),pos.x,pos.y
                    ));
                }


//                objectsPointControl.get(0).addVertices(new Vector3f(pos.x,pos.y,0));
            }


        }
    }
    public void loop(){
        while(window.isOpen()){
            window.update();
            glClearColor(0.0f,0.0f,0.0f,0.0f);
            GL.createCapabilities();

            for (Object2d object: speheres){
                object.draw();
            }
//            buatKotak();
//            for(Object2d object: speheres){
//                object.draw();
//            }
            inputSurya(speheres);


            //code
//            for (Object2d object: objects){
//                object.draw();
//            }
//            for (Object2d object: objectsPointControl){
//                object.draw();
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

    public static ArrayList<Object2d> calcBezierCurve(ArrayList <Circle> list){
        int n = list.size() - 1;
        ArrayList<Object2d> objectsBezier = new ArrayList<>();
        objectsBezier.add(new Object2d(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene3.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,1.0f,1.0f,1.0f)
        ));

        for (float i = 0; i <= 1; i += 0.01f) {
            float x = 0;
            float y = 0;
            for (int j = 0; j <= n; j++) {
                double factor = combination(n, j) * Math.pow(1 - i, n - j) * Math.pow(i, j);
                x += factor * list.get(j).xr;
                y += factor * list.get(j).yr;
            }
            objectsBezier.get(0).addVertices((new Vector3f(x, y, 0)));
        }
        return objectsBezier;
    }
    public static void main(String[] args) {
        new Main().run();

    }
}