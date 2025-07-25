package org.gfs.glowcore.util;

import org.gfs.glowcore.graphics.render.Render;
import org.gfs.glowcore.graphics.scene.Scene;
import org.gfs.glowcore.graphics.window.windowUtils;

/**
 * Интерфейс для реализации логики приложения/игры
 */
public interface IAppLogic {
    
    /**
     * Инициализация логики приложения
     * @param window  Главное окно приложения
     * @param scene   Игровая сцена
     * @param render  Рендерер
     */
    void init(windowUtils windowHandle, Scene scene, Render render);
    
    /**
     * Обработка пользовательского ввода
     * @param window          Окно приложения
     * @param scene           Текущая сцена
     * @param diffTimeMillis  Время с предыдущего кадра (мс)
     */
    default void input(windowUtils window, Scene scene, long diffTimeMillis) {}
    
    /**
     * Обновление состояния игры
     * @param window          Окно приложения
     * @param scene           Текущая сцена
     * @param diffTimeMillis  Дельта времени (мс)
     */
    void update(windowUtils windowHandle, Scene scene, long diffTimeMillis);
    
    /**
     * Очистка ресурсов
     */
    void cleanup();
}