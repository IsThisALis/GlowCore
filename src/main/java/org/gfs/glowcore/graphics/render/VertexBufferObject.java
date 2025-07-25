package org.gfs.glowcore.graphics.render;

import static org.lwjgl.opengl.GL30.*;


public class VertexBufferObject {
    
    
    private final int id;
    float vertices[];
    
    public VertexBufferObject() {
        id = glGenBuffers();
//        VBO = getID();
    }
    
    
    public void bind() {
        glBindBuffer(GL_ARRAY_BUFFER, id);
    }
    
    
    public void delete() {
        glDeleteBuffers(id);
    }
    
    
    public int getID() {
        return id;
    }
    
    
//    glBufferData(GL_ARRAY_BUFFER, sizeof(vertices), vertices, GL_STATIC_DRAW);
    
    
    
}