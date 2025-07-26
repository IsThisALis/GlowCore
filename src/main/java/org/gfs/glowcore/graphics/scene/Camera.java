package org.gfs.glowcore.graphics.scene;

import org.gfs.glowcore.util.math.Time;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

import org.joml.*;

import static org.lwjgl.glfw.GLFW.*;

public class Camera {
    
    double speed;
    
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
    
    this.speed = 1;
    
    calcVecs();
    }
    
    
    
    public void calcVecs() {
        
    front = front.normalize();
    right = front.cross(worldUp).normalize();
    up = right.cross(front).normalize();
    
    }
    
    public boolean keyCallback(int key, int expKey, int action, int expAction) {
        if(key == expKey && action == expAction) return true;
         else return false;
    }
    
/*    public void keyCallBackY(int key, int action) {
        if (key == GLFW_KEY_W && action == GLFW_RELEASE) {
            position+=front*speed*deltaTime();
        }
        
        if(key == GLFW_KEY_S && action == GLFW_RELEASE) {
            
        }
    }
    
    public void keyCallBackX() {
        if(key == GLFW_KEY_A && action == GLFW_RELEASE) {
            position+=up*speed*deltaTime();
        }
        if(key == GLFW_KEY_D && action == GLFW_RELEASE) {
            
        }
    }*/
    
}