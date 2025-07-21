package org.gfs.glowcore.core.util;

import org.lwjglb.engine.graph.Render;
import org.lwjglb.engine.scene.Scene;

public interface logicInterface {
  
    public void cleanup();
    
    void init(Window window, Scene scene, Render render);

    void input(Window window, Scene scene, long diffTimeMillis);

    void update(Window window, Scene scene, long diffTimeMillis);
    
}