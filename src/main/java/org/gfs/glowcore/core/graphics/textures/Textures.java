package org.gfs.glowcore.core.graphics.textures;

import org.lwjgl.system.MemoryStack;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.GL_CLAMP_TO_BORDER;
import static org.lwjgl.stb.STBImage.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class Textures {
    
    
    public String path;
    private final int id;
    private int width;
    private int height;
    
    
    public Texture() {
        id = glGenTextures();
    }
    
    
    public void bind() {
        glBindTexture(GL_TEXTURE_2D, id);
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
    
    /**
     * @param data   Picture Data in RGBA format
     */
    
    public static Texture createTexture(int width, int height, ByteBuffer data) {
        Texture texture = new Texture();
        texture.setWidth(width);
        texture.setHeight(height);

        texture.bind();

        texture.setParameter(GL_TEXTURE_WRAP_S, GL_CLAMP_TO_BORDER);
        texture.setParameter(GL_TEXTURE_WRAP_T, GL_CLAMP_TO_BORDER);
        texture.setParameter(GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        texture.setParameter(GL_TEXTURE_MAG_FILTER, GL_NEAREST);

        texture.uploadData(GL_RGBA8, width, height, GL_RGBA, data);

        return texture;
    }
    
    
    public static Texture loadTexture(String path) {
        ByteBuffer image;
        int width, height;
        try (MemoryStack stack = MemoryStack.stackPush()) {
            /* Prepare image buffers */
            IntBuffer w = stack.mallocInt(1);
            IntBuffer h = stack.mallocInt(1);
            IntBuffer comp = stack.mallocInt(1);

            /* Load image */
            stbi_set_flip_vertically_on_load(true);
            image = stbi_load(path, w, h, comp, 4);
            if (image == null) {
                throw new RuntimeException("Failed to load a texture file!"
                                           + System.lineSeparator() + stbi_failure_reason());
            }

            /* Get width and height of image */
            width = w.get();
            height = h.get();
        }

        return createTexture(width, height, image);
    }
}