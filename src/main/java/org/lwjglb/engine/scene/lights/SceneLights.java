package org.lwjglb.engine.scene.lights;

import org.joml.Vector3f;

import java.util.*;

public class SceneLights {

    private AmbientLight ambientLight;
    private DirLight dirLight;
    private List<PointLight> pointLights;
    private List<SpotLight> spotLights;

    public SceneLights() {
        ambientLight = new AmbientLight();
        pointLights = new ArrayList<>();
        spotLights = new ArrayList<>();
        dirLight = new DirLight(new Vector3f(1, 1, 1), new Vector3f(0, 1, 0), 1.0f);
    }

    public AmbientLight getAmbientLight() {
        return ambientLight;
    }

    public DirLight getDirLight() {
        return dirLight;
    }

    public List<PointLight> getPointLights() {
        return pointLights;
    }
    public void addPointLights(Vector3f color, Vector3f position, float intensity){
        PointLight pointLight = new PointLight(color, position, intensity);
        pointLights.add(pointLight);
    }
    public void addSpotLights(PointLight pointLight, Vector3f coneDirection, float cutOffAngle){
        SpotLight spotLight = new SpotLight(pointLight, coneDirection, cutOffAngle);
        spotLights.add(spotLight);
    }

    public List<SpotLight> getSpotLights() {
        return spotLights;
    }

    public void setSpotLights(List<SpotLight> spotLights) {
        this.spotLights = spotLights;
    }
}