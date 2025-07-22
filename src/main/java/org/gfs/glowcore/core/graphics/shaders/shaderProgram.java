package org.gfs.glowcore.core.graphics.shaders;


import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.glBindFragDataLocation;


import java.nio.FloatBuffer;

import org.lwjgl.system.MemoryStack;

import org.gfs.glowcore.core.graphics.shaders.shader;

public class shaderProgram {
    
    private int id;
   
    public int ShaderProgram;
    
    private shader shader;
    
         
    public void ShaderProgram() {
        id = glCreateProgram();
        ShaderProgram = getID();
    }
    
    
    public void attachshader(shader shader) {
        glAttachShader(id, shader.getID());
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
        glDeleteShader(shader.getID);
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