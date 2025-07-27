package org.gfs.glowcore.graphics.scene;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.GL11;
import org.joml.*;

import static org.lwjgl.glfw.GLFW.*;

public class Camera {
    // Параметры камеры
    private double moveSpeed = 3.0;
    private double mouseSensitivity = 0.1;
    private float fov = 70.0f;
    
    // Система координат
    private Vector3f position;
    private Vector3f front;
    private Vector3f up;
    private Vector3f right;
    private Vector3f worldUp;
    
    // Углы Эйлера
    private float yaw = -90.0f;
    private float pitch = 0.0f;
    
    // Матрицы
    private Matrix4f viewMatrix = new Matrix4f();
    private Matrix4f projectionMatrix = new Matrix4f();
    
    // Состояние ввода
    private boolean firstMouse = true;
    private double lastX = 0;
    private double lastY = 0;

    public Camera() {
        this.position = new Vector3f(0, 0, 3);
        this.front = new Vector3f(0, 0, -1);
        this.worldUp = new Vector3f(0, 1, 0);
        this.right = new Vector3f();
        this.up = new Vector3f();
        updateCameraVectors();
    }

    public void updateCameraVectors() {
        // Расчет нового вектора направления
        Vector3f newFront = new Vector3f();
        newFront.x = (float) (Math.cos(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch)));
        newFront.y = (float) Math.sin(Math.toRadians(pitch));
        newFront.z = (float) (Math.sin(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch)));
        front.set(newFront.normalize());
        
        // Пересчет правого и верхнего векторов
        right.set(front.cross(worldUp, new Vector3f()).normalize());
        up.set(right.cross(front, new Vector3f()).normalize());
    }

    public void processKeyboard(float deltaTime) {
        float velocity = (float) (moveSpeed * deltaTime);
        
        if (GLFW.glfwGetKey(GLFW.glfwGetCurrentContext(), GLFW_KEY_W) == GLFW_PRESS)
            position.add(front.mul(velocity, new Vector3f()));
        if (GLFW.glfwGetKey(GLFW.glfwGetCurrentContext(), GLFW_KEY_S) == GLFW_PRESS)
            position.sub(front.mul(velocity, new Vector3f()));
        if (GLFW.glfwGetKey(GLFW.glfwGetCurrentContext(), GLFW_KEY_A) == GLFW_PRESS)
            position.sub(right.mul(velocity, new Vector3f()));
        if (GLFW.glfwGetKey(GLFW.glfwGetCurrentContext(), GLFW_KEY_D) == GLFW_PRESS)
            position.add(right.mul(velocity, new Vector3f()));
        if (GLFW.glfwGetKey(GLFW.glfwGetCurrentContext(), GLFW_KEY_SPACE) == GLFW_PRESS)
            position.add(worldUp.mul(velocity, new Vector3f()));
        if (GLFW.glfwGetKey(GLFW.glfwGetCurrentContext(), GLFW_KEY_LEFT_SHIFT) == GLFW_PRESS)
            position.sub(worldUp.mul(velocity, new Vector3f()));
    }

    public void processMouseMovement(double xpos, double ypos) {
        if (firstMouse) {
            lastX = xpos;
            lastY = ypos;
            firstMouse = false;
        }

        double xoffset = (xpos - lastX) * mouseSensitivity;
        double yoffset = (lastY - ypos) * mouseSensitivity; // Обратный порядок
        lastX = xpos;
        lastY = ypos;

        yaw += xoffset;
        pitch += yoffset;

        // Ограничение угла обзора
        if (pitch > 89.0f) pitch = 89.0f;
        if (pitch < -89.0f) pitch = -89.0f;

        updateCameraVectors();
    }

    public void updateViewMatrix() {
        viewMatrix.identity();
        Vector3f center = new Vector3f(position).add(front);
        viewMatrix.lookAt(position, center, up);
    }

    public void updateProjectionMatrix(float aspectRatio, float near, float far) {
        projectionMatrix.identity();
        projectionMatrix.perspective((float) Math.toRadians(fov), aspectRatio, near, far);
    }

    // Геттеры для матриц
    public Matrix4f getViewMatrix() {
        return viewMatrix;
    }

    public Matrix4f getProjectionMatrix() {
        return projectionMatrix;
    }

    // Геттеры/сеттеры параметров
    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position.set(position);
    }

    public void setFOV(float fov) {
        this.fov = fov;
    }

    public void setMoveSpeed(double speed) {
        this.moveSpeed = speed;
    }

    public void setMouseSensitivity(double sensitivity) {
        this.mouseSensitivity = sensitivity;
    }
}