package org.gfs.glowcore.core.util.math;

import static org.lwjgl.glfw.GLFW.glfwGetTime;


public class math {
    
    
    public float x;
    public float y;
    public float z;
    public float w;


    
    public float timeDelta() {
        float deltaTime = 0.0f;
        float lastFrame = 0.0f;
        float currentFrame = (float) glfwGetTime();
        deltaTime = currentFrame-lastFrame;
        lastFrame = currentFrame;
        
        return deltaTime;
    }
    
    public int sqrt(int toSqrt) {
        return toSqrt*toSqrt;
    }
    
}