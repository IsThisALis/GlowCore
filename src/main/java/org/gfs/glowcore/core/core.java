package org.gfs.glowcore.core;

import org.gfs.glowcore.graphics.render.Render;
import org.gfs.glowcore.graphics.scene.Scene;
import org.gfs.glowcore.graphics.window.windowUtils;
import org.gfs.glowcore.graphics.window.WindowOptions;
import org.gfs.glowcore.util.IAppLogic;

import static org.lwjgl.glfw.GLFW.*;

public class core {
    
    public static final int TARGET_UPS = 30;
    private IAppLogic appLogic;
    private windowUtils window;
    private Render render;
    private boolean running;
    private Scene scene;
    private int targetFps;
    private int targetUps;
    
    
    public boolean Engine(String windowTitle, WindowOptions opts, IAppLogic appLogic) {
        window = new windowUtils(windowTitle, opts, () -> {
            resize();
            return null;
        });
        targetFps = opts.fps;
        targetUps = opts.ups;
        this.appLogic = appLogic;
        render = new Render();
        scene = new Scene();
        appLogic.init(window, scene, render);
        running = true;
        return true;
    }

    private void cleanup() {
        appLogic.cleanup();
        render.cleanup();
        scene.cleanup();
        window.cleanup();
    }

    private void resize() {
        // Реализация метода resize
    }
    
    private void run() {
        long initialTime = System.currentTimeMillis();
        float timeU = 1000.0f / targetUps;
        float timeR = targetFps > 0 ? 1000.0f / targetFps : 0;
        float deltaUpdate = 0;
        float deltaFps = 0;

        long updateTime = initialTime;
        while (running && !window.windowShouldClose()) {
            glfwPollEvents();

            long now = System.currentTimeMillis();
            deltaUpdate += (now - initialTime) / timeU;
            deltaFps += (now - initialTime) / timeR;

            if (targetFps <= 0 || deltaFps >= 1) {
                appLogic.input(window, scene, now - initialTime);
            }

            if (deltaUpdate >= 1) {
                long diffTimeMillis = now - updateTime;
                appLogic.update(window, scene, diffTimeMillis);
                updateTime = now;
                deltaUpdate--;
            }

            if (targetFps <= 0 || deltaFps >= 1) {
                render.render(window, scene);
                deltaFps--;
                window.update();
            }
            initialTime = now;
        }

        cleanup();
    }
    
    public void start() {
        running = true;
        run();
    }

    public void stop() {
        running = false;
    }
}