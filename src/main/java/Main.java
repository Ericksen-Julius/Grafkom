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

    ArrayList<CekKotak> kotak = new ArrayList<>();
    Lines objectsPointControl3 = (new Lines(
            Arrays.asList(
            //shaderFile lokasi menyesuaikan objectnya
            new ShaderProgram.ShaderModuleData
            ("resources/shaders/scene.vert"
            , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
            ),
            new Vector4f(0.0f,1.0f,1.0f,1.0f)
        ));
   private Circle objectsCircle;
    public void init(){
        window.init();
        GL.createCapabilities();

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



            objectsRectangle.add(new Rectangle(
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
                            List.of(
                                    new Vector3f(0.0f,0.0f,0.0f),
                                    new Vector3f(0.5f,0.0f,0.0f),
                                    new Vector3f(0.0f,0.5f,0.0f),
                                    new Vector3f(0.5f,0.5f,0.0f)
                            )
                    ),
                    new Vector4f(0.0f,1.0f,1.0f,1.0f),
                    Arrays.asList(0,1,2,1,2,3)

            ));
            objectsPointControl.add(new Object2d(
                    Arrays.asList(
                            //shaderFile lokasi menyesuaikan objectnya
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.vert"
                                            , GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.frag"
                                            , GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f,1.0f,1.0f,1.0f)

            ));


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
    public void buatKotak(){
        if(window.getMouseInput().isLeftButtonPressed()){
            Vector2f pos = window.getMouseInput().getCurrentPos();

            pos.x = (pos.x - (window.getWidth())/2.0f) / (window.getWidth()/2.0f);

            pos.y = (pos.y - (window.getHeight())/2.0f) / (-window.getHeight()/2.0f);

            if((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))){
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
                        new Vector4f(0.0f,1.0f,1.0f,1.0f),pos.x,pos.y,
                        kotak,objectsPointControl3
                ));


//                objectsPointControl.get(0).addVertices(new Vector3f(pos.x,pos.y,0));
            }


        }
    }
    public void loop(){
        while(window.isOpen()){
            window.update();
            glClearColor(0.0f,0.0f,0.0f,0.0f);
            GL.createCapabilities();
            buatKotak();


            //code
//            for(Object2d object: objects){
//                object.drawWithVerticesColor();
//            }
//
//            for (Object2d object: objectsRectangle){
//                object.draw();
//            }
            for (Object2d object: objectsPointControl2){
                object.draw();
            }
            objectsPointControl3.draw();


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
    public static void main(String[] args) {
        new Main().run();
    }
}