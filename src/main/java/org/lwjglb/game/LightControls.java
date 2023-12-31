package org.lwjglb.game;

import imgui.*;
import imgui.flag.ImGuiCond;
import org.joml.*;
import org.lwjglb.engine.*;
import org.lwjglb.engine.scene.Scene;
import org.lwjglb.engine.scene.lights.*;

public class LightControls implements IGuiInstance {

    private float[] ambientColor;
    private float[] ambientFactor;
    private float[] dirConeX;
    private float[] dirConeY;
    private float[] dirConeZ;
    private float[] dirLightColor;
    private float[] dirLightIntensity;
    private float[] dirLightX;
    private float[] dirLightY;
    private float[] dirLightZ;
    private float[] pointLightColor;
    private float[] pointLightIntensity;
    private float[] pointLightX;
    private float[] pointLightY;
    private float[] pointLightZ;
    private float[] spotLightColor;
    private float[] spotLightCuttoff;
    private float[] spotLightIntensity;
    private float[] spotLightX;
    private float[] spotLightY;
    private float[] spotLightZ;
    SceneLights sceneLights;
    public LightControls(Scene scene) {
        setSceneLights(scene.getSceneLights());
        AmbientLight ambientLight = new AmbientLight(0.78f, new Vector3f(0.101f,0.082f,0.027f));
        sceneLights.setAmbientLight(ambientLight);

//        Vector3f color = ambientLight.getColor();
//        ambientFactor = new float[]{0.28f};
//        ambientColor = new float[]{0.101f,0.082f,0.027f};
//
//        PointLight pointLight = getSceneLights().getPointLights().get(0);
//        color = pointLight.getColor();
//        Vector3f pos = pointLight.getPosition();
//        pointLightColor = new float[]{color.x, color.y, color.z};
//        pointLightX = new float[]{pos.x};
//        pointLightY = new float[]{pos.y};
//        pointLightZ = new float[]{pos.z};
//        pointLightIntensity = new float[]{pointLight.getIntensity()};
//
//        SpotLight spotLight = getSceneLights().getSpotLights().get(0);
//        pointLight = spotLight.getPointLight();
//        color = pointLight.getColor();
//        pos = pointLight.getPosition();
//        spotLightColor = new float[]{color.x, color.y, color.z};
//        spotLightX = new float[]{pos.x};
//        spotLightY = new float[]{pos.y};
//        spotLightZ = new float[]{pos.z};
//        spotLightIntensity = new float[]{pointLight.getIntensity()};
//        spotLightCuttoff = new float[]{spotLight.getCutOffAngle()};
//        Vector3f coneDir = spotLight.getConeDirection();
//        dirConeX = new float[]{coneDir.x};
//        dirConeY = new float[]{coneDir.y};
//        dirConeZ = new float[]{coneDir.z};

        //add langsung
        //Room 1
        sceneLights.addPointLights(new Vector3f(1.0f,1.0f,1.0f), new Vector3f(-1.5f, 20.0f, -1.1f), 5.0f);
        //Chair+Doll Room 1
        sceneLights.addPointLights(new Vector3f(1.0f,0.0f,0.0f), new Vector3f(0.0f, 7.0f, -1.0f), 20.0f);
        //DoorFrame Room 1
//        sceneLights.addPointLights(new Vector3f(1.0f,0.0f,0.0f), new Vector3f(14.0f, 25.0f, -25.0f), 100.0f);

        //Hallway 1
        sceneLights.addPointLights(new Vector3f(1.0f,1.0f,1.0f), new Vector3f(14.0f, 16.0f, -60.0f), 10.0f);
        sceneLights.addPointLights(new Vector3f(1.0f,1.0f,1.0f), new Vector3f(14.0f, 16.0f, -100.0f), 10.0f);
        sceneLights.addPointLights(new Vector3f(1.0f,1.0f,1.0f), new Vector3f(14.0f, 16.0f, -140.0f), 10.0f);
        sceneLights.addPointLights(new Vector3f(1.0f,1.0f,1.0f), new Vector3f(14.0f, 16.0f, -180.0f), 10.0f);
        sceneLights.addPointLights(new Vector3f(1.0f,1.0f,1.0f), new Vector3f(14.0f, 16.0f, -220.0f), 10.0f);
        sceneLights.addPointLights(new Vector3f(1.0f,1.0f,1.0f), new Vector3f(14.0f, 16.0f, -260.0f), 10.0f);

        //Hallway 2
        sceneLights.addPointLights(new Vector3f(1.0f,1.0f,1.0f), new Vector3f(-32.0f, 16.0f, -180.0f), 10.0f);
        sceneLights.addPointLights(new Vector3f(1.0f,1.0f,1.0f), new Vector3f(-72.0f, 16.0f, -180.0f), 10.0f);
        sceneLights.addPointLights(new Vector3f(1.0f,1.0f,1.0f), new Vector3f(-112.0f, 16.0f, -180.0f), 10.0f);
        sceneLights.addPointLights(new Vector3f(1.0f,1.0f,1.0f), new Vector3f(-152.5f, 16.0f, -180.0f), 10.0f);

        //Doll Room Door frame
        sceneLights.addPointLights(new Vector3f(1.0f,0.0f,0.0f), new Vector3f(-303.0f, 16.0f, -180.0f), 100.0f);

        //Doll Room
        sceneLights.addPointLights(new Vector3f(1.0f,1.0f,1.0f), new Vector3f(-370.0f, 16.0f, -180.0f), 6.0f);

        //Room 2
        sceneLights.addPointLights(new Vector3f(1.0f,1.0f,1.0f), new Vector3f(-152.5f, 16.0f, -95.0f), 75.0f);

        //Hallway 3
        sceneLights.addPointLights(new Vector3f(1.0f,1.0f,1.0f), new Vector3f(-152.5f, 16.0f, -500.0f), 10.0f);

        //pointlights ini bikin temp pointlight dulu buat nentuin warna, posisi dkk baru ntar temp ini masukkin spotlights... var temp di reuse ae
        //Spotlight 1 (End of Hallway 1)
        PointLight temp = new PointLight(new Vector3f(1.0f,0.0f,0.0f), new Vector3f(12.5f, 0.0f, -338.0f), 250.0f);
        sceneLights.addSpotLights(temp, new Vector3f(0.0f, 1.0f, 0.0f), 0.0f);

        //Doll Room Light
//        PointLight temp2 = new PointLight(new Vector3f(1.0f,0.0f,0.0f), new Vector3f(-325.0f, 5.0f, -220.0f), 1000.0f);
//        sceneLights.addSpotLights(temp2, new Vector3f(1.0f, 1.0f, 0.0f), 0.0f);

        //Table lamp
//        PointLight temp2 = new PointLight(new Vector3f(1.0f,0.0f,0.0f), new Vector3f(-122.5f, 7.0f, -95.0f), 1000.0f);
//        sceneLights.addSpotLights(temp2, new Vector3f(1.0f, -1.0f, 0.0f), 135.0f);

        //Spotlight 2
//        PointLight temp2 = new PointLight(new Vector3f(0.0f,0.0f,1.0f), new Vector3f(4.8f, 0.7f, -338.0f), 1000.0f);
//        sceneLights.addSpotLights(temp2, new Vector3f(1.0f, 1.0f, 0.0f), 0.0f);

        //Spotlight 1
        temp = new PointLight(new Vector3f(1.0f,0.0f,0.0f), new Vector3f(12.5f, 0.0f, -338.0f), 250.0f);
        getSceneLights().addSpotLights(temp, new Vector3f(0.0f, 1.0f, 0.0f), 0.0f);

        //Spotlight 2
//        PointLight temp2 = new PointLight(new Vector3f(0.0f,0.0f,1.0f), new Vector3f(4.8f, 0.7f, -338.0f), 1000.0f);
//        sceneLights.addSpotLights(temp2, new Vector3f(1.0f, 1.0f, 0.0f), 0.0f);

        DirLight dirLight = new DirLight(new Vector3f(0.353f, 0.345f, 0.408f), new Vector3f(0.0f,0.0f,0.0f), 0.54f);
        sceneLights.setDirLight(dirLight);

//        color = dirLight.getColor();
//        pos = dirLight.getDirection();
//        dirLightColor = new float[]{0.3529f, 0.345f, 0.407f};
//        dirLightX = new float[]{pos.x};
//        dirLightY = new float[]{pos.y};
//        dirLightZ = new float[]{pos.z};
//        dirLightIntensity = new float[]{0.24f};
    }

    @Override
    public void drawGui() {
        ImGui.newFrame();
        ImGui.setNextWindowPos(0, 0, ImGuiCond.Always);
        ImGui.setNextWindowSize(450, 400);

        ImGui.begin("Lights controls");
        if (ImGui.collapsingHeader("Ambient Light")) {
            ImGui.sliderFloat("Ambient factor", ambientFactor, 0.0f, 1.0f, "%.2f");
            ImGui.colorEdit3("Ambient color", ambientColor);
        }

        if (ImGui.collapsingHeader("Point Light")) {
            ImGui.sliderFloat("Point Light - x", pointLightX, -10.0f, 10.0f, "%.2f");
            ImGui.sliderFloat("Point Light - y", pointLightY, -10.0f, 10.0f, "%.2f");
            ImGui.sliderFloat("Point Light - z", pointLightZ, -10.0f, 10.0f, "%.2f");
            ImGui.colorEdit3("Point Light color", pointLightColor);
            ImGui.sliderFloat("Point Light Intensity", pointLightIntensity, 0.0f, 10.0f, "%.2f");
        }

        if (ImGui.collapsingHeader("Spot Light")) {
            ImGui.sliderFloat("Spot Light - x", spotLightX, -10.0f, 10.0f, "%.2f");
            ImGui.sliderFloat("Spot Light - y", spotLightY, -10.0f, 10.0f, "%.2f");
            ImGui.sliderFloat("Spot Light - z", spotLightZ, -10.0f, 10.0f, "%.2f");
            ImGui.colorEdit3("Spot Light color", spotLightColor);
            ImGui.sliderFloat("Spot Light Intensity", spotLightIntensity, 0.0f, 1.0f, "%.2f");
            ImGui.separator();
            ImGui.sliderFloat("Spot Light cutoff", spotLightCuttoff, 0.0f, 360.0f, "%2.f");
            ImGui.sliderFloat("Dir cone - x", dirConeX, -1.0f, 1.0f, "%.2f");
            ImGui.sliderFloat("Dir cone - y", dirConeY, -1.0f, 1.0f, "%.2f");
            ImGui.sliderFloat("Dir cone - z", dirConeZ, -1.0f, 1.0f, "%.2f");
        }

        if (ImGui.collapsingHeader("Dir Light")) {
            ImGui.sliderFloat("Dir Light - x", dirLightX, -1.0f, 1.0f, "%.2f");
            ImGui.sliderFloat("Dir Light - y", dirLightY, -1.0f, 1.0f, "%.2f");
            ImGui.sliderFloat("Dir Light - z", dirLightZ, -1.0f, 1.0f, "%.2f");
            ImGui.colorEdit3("Dir Light color", dirLightColor);
            ImGui.sliderFloat("Dir Light Intensity", dirLightIntensity, 0.0f, 1.0f, "%.2f");
        }

        ImGui.end();
        ImGui.endFrame();
        ImGui.render();
    }

    @Override
    public boolean handleGuiInput(Scene scene, Window window) {
        ImGuiIO imGuiIO = ImGui.getIO();
        MouseInput mouseInput = window.getMouseInput();
        Vector2f mousePos = mouseInput.getCurrentPos();
        imGuiIO.setMousePos(mousePos.x, mousePos.y);
        imGuiIO.setMouseDown(0, mouseInput.isLeftButtonPressed());
        imGuiIO.setMouseDown(1, mouseInput.isRightButtonPressed());

        boolean consumed = imGuiIO.getWantCaptureMouse() || imGuiIO.getWantCaptureKeyboard();
        if (consumed) {
            SceneLights sceneLights = scene.getSceneLights();
            AmbientLight ambientLight = sceneLights.getAmbientLight();
            ambientLight.setIntensity(ambientFactor[0]);
            ambientLight.setColor(ambientColor[0], ambientColor[1], ambientColor[2]);

            PointLight pointLight = sceneLights.getPointLights().get(0);
            pointLight.setPosition(pointLightX[0], pointLightY[0], pointLightZ[0]);
            pointLight.setColor(pointLightColor[0], pointLightColor[1], pointLightColor[2]);
            pointLight.setIntensity(pointLightIntensity[0]);

            SpotLight spotLight = sceneLights.getSpotLights().get(0);
            pointLight = spotLight.getPointLight();
            pointLight.setPosition(spotLightX[0], spotLightY[0], spotLightZ[0]);
            pointLight.setColor(spotLightColor[0], spotLightColor[1], spotLightColor[2]);
            pointLight.setIntensity(spotLightIntensity[0]);
            spotLight.setCutOffAngle(spotLightColor[0]);
            spotLight.setConeDirection(dirConeX[0], dirConeY[0], dirConeZ[0]);

            DirLight dirLight = sceneLights.getDirLight();
            dirLight.setPosition(dirLightX[0], dirLightY[0], dirLightZ[0]);
            dirLight.setColor(dirLightColor[0], dirLightColor[1], dirLightColor[2]);
            dirLight.setIntensity(dirLightIntensity[0]);
        }
        return consumed;
    }

    public SceneLights getSceneLights() {
        return sceneLights;
    }

    public void setSceneLights(SceneLights sceneLights) {
        this.sceneLights = sceneLights;
    }
}