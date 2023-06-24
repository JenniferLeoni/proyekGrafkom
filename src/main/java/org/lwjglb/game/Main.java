package org.lwjglb.game;

import org.joml.*;
import org.lwjglb.engine.*;
import org.lwjglb.engine.graph.*;
import org.lwjglb.engine.scene.*;
import org.lwjglb.engine.scene.lights.*;

import java.lang.Math;
import java.util.ArrayList;

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

        Model dollMod = ModelLoader.loadModel("dollMod", "resources/models/cube/bonek5.obj",
                scene.getTextureCache());
        scene.addModel(dollMod);

        Entity dollEnt = new Entity("dollEnt", dollMod.getId());
        dollEnt.setRotation(0.0f, 1.0f, 0.0f, (float) Math.toRadians(180.0));
        dollEnt.setPosition(0.0f, 4.0f, -1.0f);
        dollEnt.setScale(2.0f);
        dollEnt.updateModelMatrix();
        scene.addEntity(dollEnt);

        Model bayiMod = ModelLoader.loadModel("bayiMod", "resources/models/cube/bayi3.obj",
                scene.getTextureCache());
        scene.addModel(bayiMod);

        Entity bayiEnt;
        float position = -411f;
        for (int i = 0; i < 14; i++){
            bayiEnt = new Entity("bayiEnt", bayiMod.getId());
            bayiEnt.setPosition(position, 6.0f, -226f);
            bayiEnt.setScale(9.0f);
            bayiEnt.updateModelMatrix();
            scene.addEntity(bayiEnt);
            position+=7f;
        }

        position = -411f;
        for (int i = 0; i < 14; i++){
            bayiEnt = new Entity("bayiEnt", bayiMod.getId());
            bayiEnt.setPosition(position, 6.0f, -135f);
            bayiEnt.setScale(9.0f);
            bayiEnt.setRotation(0.0f, 1.0f, 0.0f, (float) Math.toRadians(180.0));
            bayiEnt.updateModelMatrix();
            scene.addEntity(bayiEnt);
            position+=7f;
        }

        position = -142f;
        for (int i = 0; i < 12; i++){
            bayiEnt = new Entity("bayiEnt", bayiMod.getId());
            bayiEnt.setPosition(-411, 6.0f, position);
            bayiEnt.setScale(9.0f);
            bayiEnt.setRotation(0.0f, 1.0f, 0.0f, (float) Math.toRadians(90.0));
            bayiEnt.updateModelMatrix();
            scene.addEntity(bayiEnt);
            position-=7f;
        }

        double[][] posBayi = new double[][] {{-319.52173, -218.53868, 10.022025},
                {-374.37372, -147.41597, 130.06615},
                {-330.82614, -215.20836, 143.62811},
                {-361.89554, -137.70291, 308.8598},
                {-333.32178, -187.57312, 186.78056},
                {-320.00885, -153.64938, 228.91354},
                {-340.35028, -181.98924, 275.31006},
                {-384.75192, -188.0597, 315.56573},
                {-334.4144, -220.5446, 128.6587},
                {-324.11624, -157.25172, 24.602318},
                {-367.24734, -192.60466, 295.0082},
                {-360.3297, -173.76956, 173.78711},
                {-388.30264, -161.33026, 32.790382},
                {-324.2401, -138.49182, 137.1932},
                {-393.52356, -187.84875, 292.75354},
                {-352.69156, -208.51843, 57.00605},
                {-321.84177, -194.3218, 290.68164},
                {-341.83765, -207.67068, 312.5709},
                {-364.13525, -206.31032, 59.214893},
                {-374.94778, -215.09308, 219.55357}};

        for (int i = 0; i < 20; i++){
            bayiEnt = new Entity("bayiEnt", bayiMod.getId());
            bayiEnt.setPosition((float) posBayi[i][0], 6.0f, (float) posBayi[i][1]);
            bayiEnt.setScale(9.0f);
            bayiEnt.setRotation(0.0f, 1.0f, 0.0f, (float) Math.toRadians(posBayi[i][2]));
            bayiEnt.updateModelMatrix();
            scene.addEntity(bayiEnt);
        }




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
//        camera.setPosition(-304f,camera.getPosition().y, -180f);


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

//        lightControls.setSenter(camera.getPosition(), camera.getDirection());

        MouseInput mouseInput = window.getMouseInput();
        if (mouseInput.isRightButtonPressed()) {
            Vector2f displVec = mouseInput.getDisplVec();
//            camera.addRotation((float) Math.toRadians(-displVec.x * MOUSE_SENSITIVITY),
//                    (float) Math.toRadians(-displVec.y * MOUSE_SENSITIVITY));
            camera.addRotation((float) Math.toRadians(0),
                    (float) Math.toRadians(-displVec.y * MOUSE_SENSITIVITY));
            System.out.println((float) camera.getPosition().x + ", " + (float) camera.getPosition().z);
//            System.out.println("camdir " + (float) camera.getDirection().x + " " + (float) camera.getDirection().z);

        }


    }

    @Override
    public void update(Window window, Scene scene, long diffTimeMillis) {
        // Nothing to be done here

    }
}