package org.lwjglb.game;

import org.joml.*;
import org.lwjglb.engine.*;
import org.lwjglb.engine.graph.*;
import org.lwjglb.engine.scene.*;
import org.lwjglb.engine.scene.lights.*;

import java.lang.Math;

import static org.lwjgl.glfw.GLFW.*;

public class Main implements IAppLogic {

    private static final float MOUSE_SENSITIVITY = 0.1f;
    private static final float MOVEMENT_SPEED = 0.05f;
    private LightControls lightControls;

    Camera camera;

    public static void main(String[] args) {
        Main main = new Main();
        Engine gameEng = new Engine("horror", new Window.WindowOptions(), main);
        gameEng.start();
    }

    @Override
    public void cleanup() {
        // Nothing to be done yet
    }

    @Override
    public void init(Window window, Scene scene, Render render) {
        Model ruangMod1 = ModelLoader.loadModel("ruangMod1", "resources/models/cube/akhir1.obj",
                scene.getTextureCache());
        scene.addModel(ruangMod1);

        Entity ruangEnt1 = new Entity("ruangEnt1", ruangMod1.getId());
        ruangEnt1.setPosition(0f, 0f, 0f);
        ruangEnt1.setScale(10.0f);
        ruangEnt1.updateModelMatrix();
        scene.addEntity(ruangEnt1);

        Model ruangMod2 = ModelLoader.loadModel("ruangMod2", "resources/models/cube/akhir2.obj",
                scene.getTextureCache());
        scene.addModel(ruangMod2);

        Entity ruangEnt2 = new Entity("ruanggEnt2", ruangMod2.getId());
        ruangEnt2.setPosition(0f, 0f, 0f);
        ruangEnt2.setScale(10.0f);
        ruangEnt2.updateModelMatrix();
        scene.addEntity(ruangEnt2);

        Model ruangMod3 = ModelLoader.loadModel("ruangMod3", "resources/models/cube/akhir3.obj",
                scene.getTextureCache());
        scene.addModel(ruangMod3);

        Entity ruangEnt3 = new Entity("ruanggEnt3", ruangMod3.getId());
        ruangEnt3.setPosition(0f, 0f, 0f);
        ruangEnt3.setScale(10.0f);
        ruangEnt3.updateModelMatrix();
        scene.addEntity(ruangEnt3);

        Model kursiMod = ModelLoader.loadModel("kursiMod", "resources/models/cube/kursi.obj",
                scene.getTextureCache());
        scene.addModel(kursiMod);

        Entity kursiEnt = new Entity("kursiEnt", kursiMod.getId());
        kursiEnt.setPosition(0f, 0f, 0f);
        kursiEnt.setScale(10.0f);
        kursiEnt.updateModelMatrix();
        scene.addEntity(kursiEnt);

        Entity kursiEnt2 = new Entity("kursiEnt2", kursiMod.getId());
        kursiEnt2.setRotation(0.0f,1.0f,0.0f,180);
        kursiEnt2.setPosition(-25.377f, 0.0f, 21.285f);
        kursiEnt2.setScale(10.0f);
        kursiEnt2.updateModelMatrix();
        scene.addEntity(kursiEnt2);

        Model bayiMod = ModelLoader.loadModel("bayiMod", "resources/models/cube/bayi3.obj",
                scene.getTextureCache());
        scene.addModel(bayiMod);

        Entity bayiEnt = new Entity("bayiEnt", bayiMod.getId());
        bayiEnt.setPosition(-395f, 6.0f, -220f);
        bayiEnt.setScale(9.0f);
        bayiEnt.updateModelMatrix();
        scene.addEntity(bayiEnt);

        Entity bayiEnt2 = new Entity("bayiEnt", bayiMod.getId());
        bayiEnt2.setPosition(-392f, 6.0f, -162f);
        bayiEnt2.setRotation(0.0f,1.0f,0.0f,180);
        bayiEnt2.setScale(9.0f);
        bayiEnt2.updateModelMatrix();
        scene.addEntity(bayiEnt2);

        Entity bayiEnt3 = new Entity("bayiEnt", bayiMod.getId());
        bayiEnt3.setPosition(-384f, 6.0f, -152f);
        bayiEnt3.setRotation(0.0f,1.0f,0.0f,270);
        bayiEnt3.setScale(9.0f);
        bayiEnt3.updateModelMatrix();
        scene.addEntity(bayiEnt3);


        SceneLights sceneLights = new SceneLights();
        sceneLights.getAmbientLight().setIntensity(0.3f);
        scene.setSceneLights(sceneLights);
        sceneLights.getPointLights().add(new PointLight(new Vector3f(1, 1, 1),
                new Vector3f(0, 0, -1.4f), 1.0f));

        Vector3f coneDir = new Vector3f(0, 0, -1);
        sceneLights.getSpotLights().add(new SpotLight(new PointLight(new Vector3f(1, 1, 1),
                new Vector3f(0, 0, -1.4f), 0.0f), coneDir, 140.0f));

        lightControls = new LightControls(scene);
        scene.setGuiInstance(lightControls);

        camera = scene.getCamera();
        camera.moveBackwards(15.0f);
        camera.moveUp(11.0f);
    }

    @Override
    public void input(Window window, Scene scene, long diffTimeMillis, boolean inputConsumed) {
        if (inputConsumed) {
            return;
        }
        float move = diffTimeMillis * MOVEMENT_SPEED;
        camera = scene.getCamera();
        if (window.isKeyPressed(GLFW_KEY_W)) {
            camera.moveForward(move);
        } else if (window.isKeyPressed(GLFW_KEY_S)) {
            camera.moveBackwards(move);
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            camera.moveLeft(move);
        } else if (window.isKeyPressed(GLFW_KEY_D)) {
            camera.moveRight(move);
        }
        if (window.isKeyPressed(GLFW_KEY_UP)) {
            camera.moveUp(move);
        } else if (window.isKeyPressed(GLFW_KEY_DOWN)) {
            camera.moveDown(move);
        }

        MouseInput mouseInput = window.getMouseInput();
        if (mouseInput.isRightButtonPressed()) {
            Vector2f displVec = mouseInput.getDisplVec();
//            camera.addRotation((float) Math.toRadians(-displVec.x * MOUSE_SENSITIVITY),
//                    (float) Math.toRadians(-displVec.y * MOUSE_SENSITIVITY));
            camera.addRotation((float) Math.toRadians(0),
                    (float) Math.toRadians(-displVec.y * MOUSE_SENSITIVITY));
            System.out.println((float) camera.getPosition().x + ", " + (float) camera.getPosition().z);
        }


    }

    @Override
    public void update(Window window, Scene scene, long diffTimeMillis) {
        // Nothing to be done here

    }
}