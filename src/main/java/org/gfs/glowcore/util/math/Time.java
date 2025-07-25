package org.gfs.glowcore.util.math;

import static org.lwjgl.glfw.GLFW.glfwGetTime;


public class Time {
    
    public float timeDelta() {
        float deltaTime = 0.0f;
        float lastFrame = 0.0f;
        float currentFrame = (float) glfwGetTime();
        deltaTime = currentFrame-lastFrame;
        lastFrame = currentFrame;
        
        return deltaTime;
    }
}