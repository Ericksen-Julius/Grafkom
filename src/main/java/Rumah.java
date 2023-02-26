import Engine.*;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Rumah {
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

    private ArrayList<Lines> stars2 = new ArrayList<>();
    public void init(){
        window.init();
        GL.createCapabilities();


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
                                new Vector3f(-1.0f,-0.4f,0.0f),
                                new Vector3f(1.0f,-0.4f,0.0f),
                                new Vector3f(-1.0f,1.0f,0.0f),
                                new Vector3f(1.0f,1.0f,0.0f)
                        )
                ),
                new Vector4f(0.0f,0.0f,1.0f,1.0f),
                Arrays.asList(0,1,2,1,2,3)

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
                                new Vector3f(-1.0f,-0.4f,0.0f),
                                new Vector3f(1.0f,-0.4f,0.0f),
                                new Vector3f(-1.0f,-1.0f,0.0f),
                                new Vector3f(1.0f,-1.0f,0.0f)
                        )
                ),
                new Vector4f(0.0f,1.0f,0.0f,1.0f),
                Arrays.asList(0,1,2,1,2,3)

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
                                new Vector3f(-0.7f,0.0f,0.0f),
                                new Vector3f(0.7f,0.0f,0.0f),
                                new Vector3f(-0.7f,-0.45f,0.0f),
                                new Vector3f(0.7f,-0.45f,0.0f)
                        )
                ),
                new Vector4f(1.0f,0.64705882352f,0.0f,1.0f),
                Arrays.asList(0,1,2,1,2,3)

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
                                new Vector3f(-0.8f,0.0f,0.0f),
                                new Vector3f(0.8f,0.0f,0.0f),
                                new Vector3f(-0.6f,0.3f,0.0f),
                                new Vector3f(0.6f,0.3f,0.0f)
                        )
                ),
                new Vector4f(1.0f,0.0f,0.0f,1.0f),
                Arrays.asList(0,1,2,1,2,3)

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
                                new Vector3f(-0.7f,0.0f,0.0f),
                                new Vector3f(-0.7f,0.1f,0.0f),
                                new Vector3f(-0.4f,0.0f,0.0f),
                                new Vector3f(-0.59f,0.25f,0.0f)
                        )
                ),
                new Vector4f(1.0f,0.64705882352f,0.0f,1.0f),
                Arrays.asList(0,1,2,1,2,3)

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
                                new Vector3f(0.3f,0.4f,0.0f),
                                new Vector3f(0.4f,0.4f,0.0f),
                                new Vector3f(0.3f,0.2f,0.0f),
                                new Vector3f(0.4f,0.2f,0.0f)
                        )
                ),
                new Vector4f(1.0f,0.64705882352f,0.0f,1.0f),
                Arrays.asList(0,1,2,1,2,3)

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
                                new Vector3f(0.27f,0.4f,0.0f),
                                new Vector3f(0.43f,0.4f,0.0f),
                                new Vector3f(0.27f,0.45f,0.0f),
                                new Vector3f(0.43f,0.45f,0.0f)
                        )
                ),
                new Vector4f(1.0f,0.34117647058f,0.2f,1.0f),
                Arrays.asList(0,1,2,1,2,3)

        ));
        objectsCircle = new Circle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new Vector4f(0.97647058823f,215/255f,28/255f,1.0f),.13f
        );
        objectsCircle.createCircle(-0.65f,0.7f);

        objectsCircle2 = new Circle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new Vector4f(0.0f,0.0f,1.0f,1.0f),.13f
        );
        objectsCircle2.createCircle(-0.585f,0.7f);

        smoke1 = new Circle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new Vector4f(105/225f,105/225f,105/225f,1.0f),.13f
        );
        smoke1.createOval(0.35f,0.52f,.08f, .05f);
        smoke2 = new Circle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new Vector4f(105/225f,105/225f,105/225f,1.0f),.13f
        );
        smoke2.createOval(0.43f,0.57f,.11f, .05f);
        smoke3 = new Circle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new Vector4f(105/225f,105/225f,105/225f,1.0f),.13f
        );
        smoke3.createOval(0.54f,0.62f,.17f, .05f);

        stars2.add(new Lines(
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
                                new Vector3f(-0.15f,0.65f,0.0f),
                                new Vector3f(-0.04f,0.675f,0.0f),
                                new Vector3f(-0.125f,0.59f,0.0f),
                                new Vector3f(-0.10f,0.71f,0.0f),
                                new Vector3f(-0.06f,0.605f,0.0f)
                        )
                ),
                new Vector4f(245/255f,245/255f,245/255f,1.0f)

        ));
        stars2.add(new Lines(
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
                                new Vector3f(0.80f,0.85f,0.0f),
                                new Vector3f(0.91f,0.875f,0.0f),
                                new Vector3f(0.825f,0.79f,0.0f),
                                new Vector3f(0.85f,0.91f,0.0f),
                                new Vector3f(0.89f,0.805f,0.0f)
                        )
                ),
                new Vector4f(245/255f,245/255f,245/255f,1.0f)

        ));
        stars2.add(new Lines(
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
                                new Vector3f(0.0f,0.90f,0.0f),
                                new Vector3f(0.06f,0.9125f,0.0f),
                                new Vector3f(0.01f,0.87f,0.0f),
                                new Vector3f(0.03f,0.93f,0.0f),
                                new Vector3f(0.05f,0.8725f,0.0f)
                        )
                ),
                new Vector4f(245/255f,245/255f,245/255f,1.0f)

        ));



    }
    public void loop(){
        while(window.isOpen()){
            window.update();
            glClearColor(0.0f,0.0f,0.0f,0.0f);
            GL.createCapabilities();


            //code
//            for(Object2d object: objects){
//                object.drawWithVerticesColor();
//            }
//
            for (Object2d object: objectsRectangle){
                object.draw();
            }

            for (Object2d object: objects){
                object.draw();
            }

            objectsCircle.draw();
            objectsCircle2.draw();
            smoke1.draw();
            smoke2.draw();
            smoke3.draw();

            for(Lines object : stars2){
                object.drawLoop();
            }




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
        new Rumah().run();
    }
}