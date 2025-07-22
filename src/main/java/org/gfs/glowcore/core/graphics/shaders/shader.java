package org.gfs.glowcore.core.graphics.shaders;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.lwjgl.opengl.GL20.*;

public class shader {
    
    private int id;
    
    public shader() {
        // Пустой конструктор
    }
    
    public shader(int type) {
        id = glCreateShader(type);
    }
    
    public void source(CharSequence source) {
        glShaderSource(id, source);
    }
    
    public void compile() {
        glCompileShader(id);
        checkStatus();
    }
    
    private void checkStatus() {
        int status = glGetShaderi(id, GL_COMPILE_STATUS);
        if (status != GL_TRUE) {
            throw new RuntimeException(glGetShaderInfoLog(id));
        }
    }
    
    public void delete() {
        glDeleteShader(id);
    }
    
    public int getID() {
        return id;
    }
    
    public static shader createShader(String typeStr, CharSequence source) {
        int type;
        if (typeStr.equals("vertex")) {
            type = GL_VERTEX_SHADER;
        } else if (typeStr.equals("fragment")) {
            type = GL_FRAGMENT_SHADER;
        } else {
            throw new IllegalArgumentException("Unknown shader type: " + typeStr);
        }
        
        shader shader = new shader(type);
        shader.source(source);
        shader.compile();
        return shader;
    }
    
    public static shader loadShader(String type, String path) {
        StringBuilder builder = new StringBuilder();
        try (InputStream in = new FileInputStream(path);
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
        } catch (IOException ex) {
            throw new RuntimeException("Failed to load shader: " + path, ex);
        }
        return createShader(type, builder.toString());
    }
}