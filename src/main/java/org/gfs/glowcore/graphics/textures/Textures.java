package org.gfs.glowcore.graphics.textures;

import org.lwjgl.system.MemoryStack;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.GL_CLAMP_TO_BORDER;
import static org.lwjgl.stb.STBImage.*;
import static org.lwjgl.opengl.GL30.glGenerateMipmap;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class Textures {
    
    public String path;
    private int id;
    private int width;
    private int height;
    
    public Textures() {
        id = glGenTextures();
    }
    
    public void bind() {
        glBindTexture(GL_TEXTURE_2D, id);
    }
    
    public void unbind() {
        glBindTexture(GL_TEXTURE_2D, 0);
    }
    
    public void delete() {
        glDeleteTextures(id);
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public String getPath() {
        return path;
    }
    
    public void setParameter(int name, int value) {
        glTexParameteri(GL_TEXTURE_2D, name, value);
    }
    
    public void setHeight(int height) {
        if (height > 0) {
            this.height = height;
        }
    }
    
    public void setWidth(int width) {
        if (width > 0) {
            this.width = width;
        }
    }
    
    public void uploadData(int internalFormat, int width, int height, int format, ByteBuffer data) {
        glTexImage2D(GL_TEXTURE_2D, 0, internalFormat, width, height, 0, format, GL_UNSIGNED_BYTE, data);
    }
    
    public void generateMipmaps() {
        glGenerateMipmap(GL_TEXTURE_2D);
    }
    
    public static Textures createTexture(int width, int height, ByteBuffer data) {
        Textures texture = new Textures();
        texture.setWidth(width);
        texture.setHeight(height);

        texture.bind();

        texture.setParameter(GL_TEXTURE_WRAP_S, GL_CLAMP_TO_BORDER);
        texture.setParameter(GL_TEXTURE_WRAP_T, GL_CLAMP_TO_BORDER);
        texture.setParameter(GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        texture.setParameter(GL_TEXTURE_MAG_FILTER, GL_NEAREST);

        texture.uploadData(GL_RGBA8, width, height, GL_RGBA, data);
        texture.generateMipmaps();
        texture.unbind();

        stbi_image_free(data);
        return texture;
    }
    
    public static Textures loadTexture(String path) {
        ByteBuffer image;
        int width, height;
        try (MemoryStack stack = MemoryStack.stackPush()) {
            IntBuffer w = stack.mallocInt(1);
            IntBuffer h = stack.mallocInt(1);
            IntBuffer comp = stack.mallocInt(1);

            stbi_set_flip_vertically_on_load(true);
            image = stbi_load(path, w, h, comp, 4);
            if (image == null) {
                throw new RuntimeException("Failed to load texture: " + path + 
                                          "\nReason: " + stbi_failure_reason());
            }
            width = w.get();
            height = h.get();
        }
        return createTexture(width, height, image);
    }
}