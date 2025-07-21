package org.gfs.rwmodloader.engine.graphics.render;




public class ElementBufferObject {
    
    
    int indices[] = {
        0, 1, 3,
        1, 2, 3
    }
    
    
    public genEBO() {
        glGenBuffers(1, &EBO);
    }
    
    
    glBindBuffers(GL_ELEMENT_ARRAY_BUFFER, EBO);
    glBufferData(GL_ELEMENT_ARRAY_BUFFER, sizeof(indices), indices, GL_STATIC_DRAW);
}