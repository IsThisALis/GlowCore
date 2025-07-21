package org.gfs.glowcore.core.util.math;




public class math {
    
    
    public float x;
    public float y;
    public float z;
    public float w;

    
    public float timeDelta() {
        float deltaTime = 0.0f;
        float lastFrame = 0.0f;
        float currentFrame = glfwGetTime();
        deltaTime = currentFrame-lastFrame;
        lastFrame = currentFrame;
        
        return deltaTime;
    }
    
    public int sqrt(int toSqrt) {
        return toSqrt*toSqrt;
    }
    
}