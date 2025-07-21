package org.gfs.glowcore.core.graphics.shaders;


import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.glBindFragDataLocation;


import java.nio.FloatBuffer;

import org.lwjgl.system.MemoryStack;

import org.gfs.engine.core.graphics.shaders.shaderV;
import org.gfs.engine.core.graphics.shaders.shaderF;

public class shaderProgram {
    
    private final int id;
   
    public int ShaderProgram;
    
         
    public ShaderProgram() {
        id = glCreateProgram();
        ShaderProgram = getID();
    }
    
    
    public void attachShaderV(Shader shader) {
        glAttachShader(id, shaderV.getIDV());
    }
    
    
    public void attachShaderF(Shader shader) {
        glAttachShader(id, shaderF.getIDF());
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
        glDeleteShader(shaderF.getIDF);
        glDeleteShader(shaderV.getIDV);
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