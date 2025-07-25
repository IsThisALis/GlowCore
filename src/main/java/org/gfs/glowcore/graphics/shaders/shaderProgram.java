package org.gfs.glowcore.graphics.shaders;

import static org.lwjgl.opengl.GL20.*;

public class shaderProgram {
    
    private int id;
   
    
    private shader attachedShader;
    
    public shaderProgram() {
        id = glCreateProgram();
    }
    
    public void attachShader(shader shader) {
        glAttachShader(id, shader.getID());
        this.attachedShader = shader; // Сохраняем ссылку на прикрепленный шейдер
    }
    
    public void link() {
        glLinkProgram(id);
        checkStatus();
    }
    
    public void use() {
        glUseProgram(id);
    }
    
    public void delete() {
        glDeleteProgram(id);
    }
    
    public void terminateShaders() {
        
        if (attachedShader != null) {
            glDeleteShader(attachedShader.getID());
        }
    }
    
    public void terminateShaderProgram() {
        terminateShaders();
        delete();
    }
    
    public int getID() {
        return id;
    }
    
    public void checkStatus() {
        int status = glGetProgrami(id, GL_LINK_STATUS);
        if (status != GL_TRUE) {
            throw new RuntimeException(glGetProgramInfoLog(id));
        }
    }
}