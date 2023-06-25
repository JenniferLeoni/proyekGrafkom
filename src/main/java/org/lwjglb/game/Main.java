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
    private static final int NUM_CHUNKS = 50;
    private Entity[][] terrainEntities;
    int countAnimasi = 0;
    int countJalan = 0;
    int countLoop = 0;
    boolean animasiStart = false;
    Camera camera;
    Entity dollEnt2;
    Entity hantuEnt;

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
        // Terrrain
        String quadModelId = "quad-model";
        Model quadModel = ModelLoader.loadModel("quad-model", "resources/models/quad/quad.obj",
                scene.getTextureCache());
        scene.addModel(quadModel);

        int numRows = NUM_CHUNKS * 2 + 1;
        int numCols = numRows;
        terrainEntities = new Entity[numRows][numCols];
        for (int j = 0; j < numRows; j++) {
            for (int i = 0; i < numCols; i++) {
                Entity entity = new Entity("TERRAIN_" + j + "_" + i, quadModelId);
                terrainEntities[j][i] = entity;
                scene.addEntity(entity);
            }
        }

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

        Model hantuMod = ModelLoader.loadModel("hantuMod", "resources/models/cube/ghost19.obj",
                scene.getTextureCache());
        scene.addModel(hantuMod);

        hantuEnt = new Entity("hantuEnt", hantuMod.getId());
        hantuEnt.setRotation(0.0f, 1.0f, 0.0f, (float) Math.toRadians(180.0));
//        hantuEnt.setPosition(-152.8122f, 0.0f, -120.0f);
        hantuEnt.setPosition(-152.8122f, 70.0f, -120.0f);
        hantuEnt.setScale(3.0f);
        hantuEnt.updateModelMatrix();
        scene.addEntity(hantuEnt);

        Model dollMod = ModelLoader.loadModel("dollMod", "resources/models/cube/bonek5.obj",
                scene.getTextureCache());
        scene.addModel(dollMod);

        Entity dollEnt = new Entity("dollEnt", dollMod.getId());
        dollEnt.setRotation(0.0f, 1.0f, 0.0f, (float) Math.toRadians(180.0));
        dollEnt.setPosition(0.0f, 4.0f, -1.0f);
        dollEnt.setScale(2.0f);
        dollEnt.updateModelMatrix();
        scene.addEntity(dollEnt);

        dollEnt2 = new Entity("dollEnt", dollMod.getId());
        dollEnt2.setRotation(0.0f, 1.0f, 0.0f, (float) Math.toRadians(180.0));
//        dollEnt2.setPosition(-152.8122f, 4.0f, -120.0f);
        dollEnt2.setPosition(-152.8122f, 70.0f, -120.0f);
        dollEnt2.setScale(2.0f);
        dollEnt2.updateModelMatrix();
        scene.addEntity(dollEnt2);

        Entity dollEnt3 = new Entity("dollEnt", dollMod.getId());
//        dollEnt2.setRotation(0.0f, 1.0f, 0.0f, (float) Math.toRadians(180.0));
//        dollEnt2.setPosition(-152.8122f, 4.0f, -120.0f);
        dollEnt2.setPosition(14.421f, 0.0f, -335f);
        dollEnt2.setScale(2.0f);
        dollEnt2.updateModelMatrix();
        scene.addEntity(dollEnt2);

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


        SkyBox skyBox = new SkyBox("resources/models/skybox/skybox.obj", scene.getTextureCache());
        skyBox.getSkyBoxEntity().setScale(50);
        scene.setSkyBox(skyBox);

        camera = scene.getCamera();
        camera.moveBackwards(15.0f);
        camera.moveUp(11.0f);
        updateTerrain(scene);

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
            headBopsJalan();
        } else if (window.isKeyPressed(GLFW_KEY_S)) {
            camera.moveBackwards(move);
            headBopsJalan();
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            camera.moveLeft(move);
            headBopsJalan();
        } else if (window.isKeyPressed(GLFW_KEY_D)) {
            camera.moveRight(move);
            headBopsJalan();
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
        float jalan = 20 * 0.02f;
        float lari = 20 * 0.05f;

        if (window.isKeyPressed(GLFW_KEY_SPACE) || animasiStart){
            if (countAnimasi == 0){
                camera.setPosition(-17.5f,camera.getPosition().y, -20.25f);
                camera.setRotation((float) Math.toRadians(45), (float) Math.toRadians(180));
            }

            countAnimasi++;
            System.out.println(countAnimasi);

            if (countAnimasi < 40 && countLoop == 0){
                camera.addRotation(-0.023f, -0.023f);
            }
            if (countAnimasi > 55 && countAnimasi < 90){
                camera.addRotation(0.0f, -0.023f);
            }
            if (countAnimasi > 100 && countAnimasi < 180){
                camera.addRotation(0.0f, 0.023f);
            }
            if (countAnimasi > 180 && countAnimasi < 240){
                camera.addRotation(0.023f, 0.023f);
            }
            if (countAnimasi > 300 && countAnimasi < 360){
                camera.addRotation(-0.021f, -0.023f);
            }
            if (countAnimasi > 370 && countAnimasi < 450 && countLoop == 0){
                camera.moveForward(jalan);
                headBopsJalan();
            }
            if (countAnimasi > 450 && countAnimasi < 490 && countLoop == 0){
                camera.addRotation(0.023f, 0.0f);
            }
            if (countAnimasi > 500 && countAnimasi < 540 && countLoop == 0){
                camera.addRotation(-0.023f, 0.021f);
            }
            if (countAnimasi > 540 && countAnimasi < 660 && countLoop == 0){
                camera.addRotation(0.0f, -0.023f);
            }
            if (countAnimasi > 660 && countAnimasi < 730 && countLoop == 0){
                camera.moveForward(jalan);
                headBopsJalan();
            }
            if (countAnimasi > 730 && countAnimasi < 770 && countLoop == 0){
                camera.addRotation(0.0f, 0.02f);
            }
            if (countAnimasi > 780 && countAnimasi < 900 && countLoop == 0){
                camera.addRotation(0.0f, -0.02f);
            }
            if (countAnimasi > 910 && countAnimasi < 960 && countLoop == 0){
                camera.moveForward(jalan);
                headBopsJalan();
            }
            if (countAnimasi > 960 && countAnimasi < 1000 && countLoop == 0){
                camera.addRotation(0.0f, -0.02f);
            }
            if (countAnimasi > 1150 && countAnimasi < 1250 && countLoop == 0){
                camera.addRotation(0.0f, -0.02f);
            }
            if (countAnimasi > 1400 && countAnimasi < 1500 && countLoop == 0){
                camera.addRotation(0.0f, -0.02f);
            }
            if (countAnimasi > 1500 && countAnimasi < 1550 && countLoop == 0){
                if (camera.getPosition().x<14.30) {
                    camera.moveForward(jalan);
                    headBopsJalan();
                }
            }
            if (countAnimasi > 1550 && countAnimasi < 1700 && countLoop == 0){
                if (Math.toDegrees(camera.getRotation().y) >-360){
                    camera.addRotation(0.0f, -0.02f);
                }
            }
            if (countAnimasi == 1700 && countLoop == 0){
                camera.setRotation(0.0f, 0.0f);
            }
            if (countAnimasi > 1710 && countAnimasi < 2400 && countLoop == 0) {
                if (camera.getPosition().z > -280.0f) {
                    camera.moveForward(jalan);
                    headBopsJalan();
                }
            }
            if (countAnimasi > 2450 && countAnimasi < 2700 && countLoop == 0){
                if (Math.toDegrees(camera.getRotation().y) < 180){
                    camera.addRotation(0.0f, 0.03f);
                }
            }
            if (countAnimasi > 2630 && countAnimasi < 2900 && countLoop == 0) {
                if (camera.getPosition().z < -179.5f) {
                    camera.moveForward(jalan);
                    headBopsJalan();
                }
            }
            if (countAnimasi > 2900 && countAnimasi < 2983 && countLoop == 0){
                if (Math.toDegrees(camera.getRotation().y) < 270){
                    camera.addRotation(0.0f, 0.03f);
                }
            }
            if (countAnimasi == 2983 && countLoop == 0){
                camera.setRotation(0.0f,(float) Math.toRadians(270));
            }
            if (countAnimasi > 2983 && countAnimasi < 3800 && countLoop == 0) {
                if (camera.getPosition().x > -313.0f) {
                    camera.moveForward(jalan);
                    headBopsJalan();
                }
            }
            if (countAnimasi > 3850 && countAnimasi < 3995 && countLoop == 0) {
                if (Math.toDegrees(camera.getRotation().y) > 180){
                    camera.addRotation(0.0f, -0.01f);
                }
                camera.moveForward(jalan);
                headBopsJalan();
            }
            if (countAnimasi > 4020 && countAnimasi < 4200 && countLoop == 0) {
                camera.addRotation(0.0f, 0.02f);
            }
            if (countAnimasi > 4220 && countAnimasi < 4500 && countLoop == 0) {
                if (Math.toDegrees(camera.getRotation().y) < 450){
                    camera.addRotation(0.0f, 0.005f);
                }
                if (camera.getPosition().x < -325.0f || camera.getPosition().z > -179) {
                    camera.moveForward(jalan * 2.5f);
                    headBopsJalan();
                }
            }
            if (countAnimasi == 4500 && countLoop == 0) {
                camera.setRotation(0.0f, (float) Math.toRadians(90));
            }
            if (countAnimasi > 4500 && countAnimasi < 4720 && countLoop == 0) {
                if (camera.getPosition().x < -153.0f) {
                    camera.moveForward(jalan*2);
                    headBopsJalan();
                }
            }
            if (countAnimasi > 4720 && countAnimasi < 4780 && countLoop == 0) {
                if (Math.toDegrees(camera.getRotation().y) < 180) {
                    camera.addRotation(0.0f, 0.03f);
                }
            }
            if (countAnimasi == 4781 && countLoop == 0){
                camera.setPosition(-152.8122f, camera.getPosition().y, -179.6281f);
                camera.setRotation(new Vector2f(0.0f, (float) Math.toRadians(181f)));
            }
            if (countAnimasi > 4780 && countAnimasi < 4890 && countLoop == 0){
                camera.moveForward(jalan);
                headBopsJalan();
            }
            if (countAnimasi > 4890 && countAnimasi < 4938 && countLoop == 0){
                camera.addRotation(0.0f, -0.02f);
            }
            if (countAnimasi > 4938 && countAnimasi < 5030 && countLoop == 0){
                camera.moveForward(jalan);
                headBopsJalan();
            }
            if (countAnimasi > 5030 && countAnimasi < 5061 && countLoop == 0){
                camera.addRotation(0.0f, 0.02f);
            }
            if (countAnimasi > 5061 && countAnimasi < 5085 && countLoop == 0){
                camera.moveForward(jalan);
                headBopsJalan();
            }
            if (countAnimasi > 5085 && countAnimasi < 5120 && countLoop == 0){
                camera.addRotation(0.0f, 0.02f);
            }
            if (countAnimasi > 5120 && countAnimasi < 5170 && countLoop == 0){
                camera.moveForward(jalan);
                headBopsJalan();
            }
            if (countAnimasi > 5170 && countAnimasi < 5323 && countLoop == 0){
                camera.addRotation(0.0f, 0.02f);
            }
            if (countAnimasi > 5323 && countAnimasi < 5370 && countLoop == 0){
                camera.moveForward(jalan);
                headBopsJalan();
            }
            if (countAnimasi == 5370 && countLoop == 0){
                dollEnt2.setPosition(-152.8122f, 4.0f, -120.0f);
                dollEnt2.updateModelMatrix();
            }
            if (countAnimasi > 5370 && countAnimasi < 5455 && countLoop == 0){
                camera.addRotation(0.0f, -0.025f);
                camera.moveForward(jalan);
                headBopsJalan();
            }
            if (countAnimasi > 5470 && countAnimasi < 5520 && countLoop == 0){
                camera.addRotation(0.0f, 0.03f);
            }
            if (countAnimasi > 5520 && countAnimasi < 5562 && countLoop == 0){
                camera.addRotation(0.0f, 0.008f);
                camera.moveForward(jalan*2);
                headBopsJalan();
            }
            if (countAnimasi > 5562 && countAnimasi < 5715 && countLoop == 0){
                camera.addRotation(0.0f, -0.02f);
            }
            if (countAnimasi == 5735 && countLoop == 0){
                dollEnt2.setPosition(-152.8122f, 70.0f, -120.0f);
                dollEnt2.updateModelMatrix();
                hantuEnt.setPosition(-152.8122f, 0.0f, -120.0f);
                hantuEnt.updateModelMatrix();
            }
            if (countAnimasi > 5735 && countAnimasi < 5763 && countLoop == 0){
                hantuEnt.translateEntity(0.0f,0.0f,-1.2f);
                hantuEnt.updateModelMatrix();
            }
            if (countAnimasi > 5755 && countAnimasi < 5762 && countLoop == 0){
                if (Math.toDegrees(camera.getRotation().y) < 360.0f) {
                    camera.addRotation(0.0f, 0.5f);
                }
            }
            if (countAnimasi == 5762 && countLoop == 0){
                camera.setPosition(-153.90182f,camera.getPosition().y, -158.9697f);
                camera.setRotation(0.0f,(float) Math.toRadians(0));
            }
            if (countAnimasi > 5762 && countAnimasi < 6454 && countLoop == 0){
                camera.moveForward(lari);
                headBopsLari();
            }
            if (countAnimasi > 6070 && countAnimasi < 6123 && countLoop == 0){
                if (Math.toDegrees(camera.getDirection().y) < 90.0f) {
                    camera.addRotation(0.0f, 0.03f);
                }
            }
            if (countAnimasi > 6454 && countLoop == 0){
                camera.moveForward(jalan*0.7f);
                headBopsJalan();
            }
            if (countAnimasi > 6454 && countAnimasi < 6500 && countLoop == 0){
                camera.addRotation(0.0f, -0.02f);
            }
            if (countAnimasi > 6500 && countAnimasi < 6600 && countLoop == 0){
                camera.addRotation(0.0f, 0.02f);
            }

            if (countAnimasi == 6600 && countLoop == 0){
                countAnimasi = 0;
                countLoop = 1;
            }
            System.out.println(Math.toDegrees(camera.getRotation().x)+ " , " + Math.toDegrees(camera.getRotation().y));
        }



    }

    public void headBopsJalan(){
        if (countJalan <= 10){
            camera.moveUp(0.1f);
        }
        else {
            camera.moveDown(0.1f);
        }
        if (countJalan > 19){
            countJalan = 0;
        }
        countJalan++;
        System.out.println("countjalan:" + countJalan);
    }
    public void headBopsLari(){
        if (countJalan <= 10){
            camera.moveUp(0.3f);
        }
        else {
            camera.moveDown(0.3f);
        }
        if (countJalan > 19){
            countJalan = 0;
        }
        countJalan++;
        System.out.println("countjalan:" + countJalan);
    }
    @Override
    public void update(Window window, Scene scene, long diffTimeMillis) {
        // Nothing to be done here
        updateTerrain(scene);
    }

    public void updateTerrain(Scene scene) {
        int cellSize = 10;
        Camera camera = scene.getCamera();
        Vector3f cameraPos = camera.getPosition();
        int cellCol = (int) (cameraPos.x / cellSize);
        int cellRow = (int) (cameraPos.z / cellSize);

        int numRows = NUM_CHUNKS * 2 + 1;
        int numCols = numRows;
        int zOffset = -NUM_CHUNKS;
        float scale = cellSize / 2.0f;
        for (int j = 0; j < numRows; j++) {
            int xOffset = -NUM_CHUNKS;
            for (int i = 0; i < numCols; i++) {
                Entity entity = terrainEntities[j][i];
                entity.setScale(scale);
                entity.setPosition((cellCol + xOffset) * 2.0f, -0.01f, (cellRow + zOffset) * 2.0f);
                entity.getModelMatrix().identity().scale(scale).translate(entity.getPosition());
                xOffset++;
            }
            zOffset++;
        }
    }
}