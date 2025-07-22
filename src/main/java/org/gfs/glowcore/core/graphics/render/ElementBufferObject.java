package org.gfs.glowcore.core.graphics.render;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.system.MemoryUtil.*;

public class ElementBufferObject {
    private final int[] indices = {
        0, 1, 3,
        1, 2, 3
    };
    
    private int id; // ID буфера

    public void genEBO() {
        id = glGenBuffers();
        bind();
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices, GL_STATIC_DRAW);
        unbind();
    }
    
    public void bind() {
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, id);
    }
    
    public void unbind() {
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
    }
}