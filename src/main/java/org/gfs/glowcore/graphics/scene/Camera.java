package org.gfs.glowcore.graphics.scene;

import org.gfs.glowcore.util.math.Time;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

import org.joml.*;

import static org.lwjgl.glfw.GLFW.*;

public class Camera {
    
    float x = 0;
    float y = 0;
    float z = 0;
    
    private Vector3f position;
    private Vector3f front;
    private Vector3f up;
    private Vector3f right;
    private Vector3f worldUp;
    
    public Camera() {
        
    
    this.position = new Vector3f(0, 0, 3);
    this.front = new Vector3f(0, 0, -1);
    this.worldUp = new Vector3f(0, 1, 0);
    this.right = new Vector3f();
    this.up = new Vector3f();
    
    calcVecs();
    }
    
    
    
    public void calcVecs() {
        
    front = front.normalize();
    right = front.cross(worldUp).normalize();
    up = right.cross(front).normalize();
    
    }
    
    
    public void keyCallBack(int key, int action) {
        if (key == GLFW_KEY_W && action == GLFW_RELEASE) {
            x++;
        }
    }
    
    
}