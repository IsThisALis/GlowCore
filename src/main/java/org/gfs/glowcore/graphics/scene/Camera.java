package org.gfs.glowcore.graphics.scene;

import org.gfs.glowcore.util.math.Time;
import org.gfs.glowcore.graphics.window.windowUtils

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import static org.lwjgl.glfw.GLFW.*;

public class Camera2D {
    
    private windowUtils window = new windowUtils();
    
    private int height = window.getHeight();
    private int width = window.getWidth();
    
    double speed;
    
    float x = 0;
    float y = 0;
    float z = 0;
    
    private Matrix4f projectionMatrix;
    private Matrix4f viewMatrix;
    private Vector3f position;
    private Vector3f rotation;
    
    
    private float zoomFactor = 1f;
    private float aspectRatio;
    
    
    private float projectionLeft;
    private float projectionRight;
    private float projectionBottom;
    private float projectionTop;
    
    const float nearPlane = -100.0f;
    const float farPlane = 100.0f;
    
    public Camera() {
        
    
    this.position = new Vector3f(0, 0, 3);
    
    this.speed = 1;
    
    
    }
    public void update() {
        
        aspectRatio = width/height;
        
        projectionTop = zoom;
        projectionBottom = -zoom;
        projectionRight = aspectRatio*zoom;
        projectionLeft = -aspectRatio*zoom;
        
        
        
        
    }
    
    

    public boolean keyCallback(int key, int expKey, int action, int expAction) {
        if(key == expKey && action == expAction) return true;
         else return false;
    }
    
}