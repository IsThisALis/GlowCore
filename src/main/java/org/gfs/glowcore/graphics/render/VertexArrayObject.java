package org.gfs.glowcore.graphics.render;

import static org.lwjgl.opengl.GL30.*;


public class VertexArrayObject {
    
    
    private final int id;
    public int VAO;
    
    
    public VertexArrayObject() {
        id = glGenVertexArrays();
        VAO = getID();
    }
    
    
    public void bind() {
        glBindVertexArray(id);
    }
    
    
    public void delete() {
        glDeleteVertexArrays(id);
    }
    
    
    public int getID() {
        return id;
    }
    
    
    
}