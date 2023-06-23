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
    private Entity rockEntity;
    private Entity treeEntity;
    private Entity ruangEnt1;
    private Entity ruangEnt2;
    private Entity ruangEnt3;
    private Entity dollEnt;
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
        Model treeModel = ModelLoader.loadModel("tree-model", "resources/models/cube/tree.obj",
                scene.getTextureCache());
        scene.addModel(treeModel);

        treeEntity = new Entity("tree-entity", treeModel.getId());
        treeEntity.setPosition(0, 0f, -2);
        treeEntity.updateModelMatrix();
        scene.addEntity(treeEntity);


        Model rockModel = ModelLoader.loadModel("rock-model", "resources/models/cube/Rock_9.obj",
                scene.getTextureCache());
        scene.addModel(rockModel);

        rockEntity = new Entity("rock-entity", rockModel.getId());
        rockEntity.setPosition(0, 0f, -2);
        rockEntity.setScale(4.0f);
        rockEntity.translateEntity(-2.0f, 0.0f, 0.0f);
        rockEntity.updateModelMatrix();
        scene.addEntity(rockEntity);

        Model ruangMod1 = ModelLoader.loadModel("ruangMod1", "resources/models/cube/awal1.obj",
                scene.getTextureCache());
        scene.addModel(ruangMod1);

        ruangEnt1 = new Entity("ruangEnt1", ruangMod1.getId());
        ruangEnt1.setPosition(0, 0f, -2);
        ruangEnt1.setScale(10.0f);
        ruangEnt1.updateModelMatrix();
        scene.addEntity(ruangEnt1);

        Model ruangMod2 = ModelLoader.loadModel("ruangMod2", "resources/models/cube/awal2.obj",
                scene.getTextureCache());
        scene.addModel(ruangMod2);

        ruangEnt2 = new Entity("ruanggEnt2", ruangMod2.getId());
        ruangEnt2.setPosition(0, 0f, -2);
        ruangEnt2.setScale(10.0f);
        ruangEnt2.updateModelMatrix();
        scene.addEntity(ruangEnt2);

//        Model ruangMod3 = ModelLoader.loadModel("ruangMod3", "resources/models/cube/grafkomm1.obj",
//                scene.getTextureCache());
//        scene.addModel(ruangMod3);
//
//        ruangEnt3 = new Entity("ruanggEnt3", ruangMod3.getId());
//        ruangEnt3.setPosition(0, 0f, -2);
//        ruangEnt3.setScale(10.0f);
//        ruangEnt3.updateModelMatrix();
//        scene.addEntity(ruangEnt3);


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
            System.out.println(camera.getPosition());
        }


    }

    @Override
    public void update(Window window, Scene scene, long diffTimeMillis) {
        // Nothing to be done here

    }
}