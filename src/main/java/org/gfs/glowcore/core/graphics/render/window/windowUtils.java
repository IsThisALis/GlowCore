package org.gfs.glowcore.core.graphics.render.window;

import org.lwjgl.Version;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

import org.tinylog.Logger;

import java.util.concurrent.Callable;
import java.nio.IntBuffer;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;
import static org.lwjgl.system.MemoryStack.stackPush;


public class windowUtils extends WindowOptions {
    
    
    String title;
    
    int width;
    int height;
    
    private long windowHandle;
    
    private Callable<Void> resizeFunc;
    
    
    
    public void cleanup() {
        
     glfwFreeCallbacks(windowHandle);
     glfwDestroyWindow(windowHandle);
     glfwTerminate();
     
     GLFWErrorCallback callback = glfwSetErrorCallback(null);
     
     if (callback != null) {
            callback.free();
        }
    }
    
    
    public void init(String title, int width, int height, WindowOptions opts, Callable<Void> resizeFunc) {
        this.resizeFunc = resizeFunc;
        
         GLFWErrorCallback.createPrint(System.err).set();
         
         glfwInit();
         
         if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
         }   
         
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2);
        
        if (opts.compatibleProfile) {
            glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_COMPAT_PROFILE);
        } else {
            glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
            glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);
        }
       
       if (opts.width > 0 && opts.height > 0) {
            this.width = opts.width;
            this.height = opts.height;
        } else {
            glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE);
            GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
            width = vidMode.width();
            height = vidMode.height();
        }
       
       windowHandle = glfwCreateWindow(width, height, title, NULL, NULL);
//        windowUtils windowHandle = windowHandle;
       
       
        if (windowHandle == NULL) {
           throw new RuntimeException("Failed to create windowHandle");
        }
        
        
        glfwSetFramebufferSizeCallback(windowHandle, (windowHandle, w, h) -> resized(w, h));
        
        glfwSetErrorCallback((int errorCode, long msgPtr) ->
                Logger.error("Error code [{}], msg [{}]", errorCode, MemoryUtil.memUTF8(msgPtr)));

        glfwSetKeyCallback(windowHandle, (window, key, scancode, action, mods) -> {
            keyCallBack(key, action);
        });
            
            
            
            glfwMakeContextCurrent(windowHandle);

        if (opts.fps > 0) {
            glfwSwapInterval(0);
        } else {
            glfwSwapInterval(1);
        }
            
            
            
        int[] arrWidth = new int[1];
        int[] arrHeight = new int[1];
        glfwGetFramebufferSize(windowHandle, arrWidth, arrHeight);
        width = arrWidth[0];
        height = arrHeight[0];
    winit();
    }
    
    
    public void keyCallBack(int key, int action) {
        if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
            glfwSetWindowShouldClose(windowHandle, true); // We will detect this in the rendering loop
        }
    }
    
    
    public int closeCheck() {
              if (glfwWindowShouldClose(windowHandle)==true)  {
                  cleanup(); 
              }
              return 0;
    }
      
      
    public void framebuffer_size_callback(windowUtils windowHandle, int width, int height) {
         glViewport(0, 0, width, height);
      }
      
      
    public void winit() {

        
        try (MemoryStack stack = stackPush()) {
            
            IntBuffer pWidth = stack.mallocInt(1); 
            IntBuffer pHeight = stack.mallocInt(1);
            
        glfwGetWindowSize(windowHandle, pWidth, pHeight);
            
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
            
            glfwSetWindowPos(windowHandle, (vidmode.width() - pWidth.get(0)) / 2, (vidmode.height() - pHeight.get(0)) / 2);
        }
        
        glfwMakeContextCurrent(windowHandle);
        // Enable v-sync
        glfwSwapInterval(1);
        glfwShowWindow(windowHandle);
        
        
        
    }
    
    
    public void loop() {
        GL.createCapabilities();

        // Set the clear color
        glClearColor(1.0f, 0.0f, 0.0f, 0.0f);

        while (!glfwWindowShouldClose(windowHandle)) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            glfwSwapBuffers(windowHandle);

            glfwPollEvents();
        }
    }
    
//  getters    
    
    public long getwindowHandle() {
        return windowHandle;
    }
    
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    
    public String getTitle() {
        return title;
    }
    
    
//  non-getters  
    
    public boolean isKeyPressed(int keyCode) {
        return glfwGetKey(windowHandle, keyCode) == GLFW_PRESS;
    }
    
    protected void resized(int width, int height) {
        this.width = width;
        this.height = height;
        try {
            resizeFunc.call();
        } catch (Exception excp) {
            Logger.error("Error calling resize callback", excp);
        }
    }
    
    
    public void update() {
        glfwSwapBuffers(windowHandle);
    }

    public boolean windowShouldClose() {
        return glfwWindowShouldClose(windowHandle);
    }
    
    
    
    
    
}