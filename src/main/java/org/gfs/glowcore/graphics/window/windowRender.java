/*

deprecated && on rework


package org.gfs.engine.graphics.window;

import org.lwjgl.glfw.GLFW.*;
import org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL30.*;

public class windowRender {
    public int windowInit {
        String name;
        
        
    
    
//    glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);

    

    
    glfwMakeContextCurrent(window);

    if (!gladLoadGLLoader((GLADloadproc)glfwGetProcAdress)) {
        
        System.out.println("ERROR: Failed to initialize GLAD");
        return -1;
    }
    
    glViewport(0, 0, 800, 600)
    return 0
    }
    
    
    
    glfwSetFramebufferSizeCallback(window, framebuffer_size_callback);
    
    
    public int windowLoop() {
    while(!glfwWindowShouldClose(window)) {
        
        processInput()
        
        glfwSwapBuffers(window);
        glfwPollEvents();
    }
     
    
    
    }
}*/