package org.gfs.glowcore.graphics.render;

import org.lwjgl.opengl.GL;

import org.gfs.glowcore.graphics.window.windowUtils;
import org.gfs.glowcore.graphics.scene.Scene;

import static org.lwjgl.opengl.GL11.*;

public class Render {
    
    
    
  public Render() {
        GL.createCapabilities();
    }

    public void cleanup() {
        // Nothing to be done here yet
    }

    public void render(windowUtils window, Scene scene) {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }  
    
}