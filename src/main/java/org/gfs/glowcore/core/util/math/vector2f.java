package org.gfs.glowcore.core.util.math;

public class Vector2f extends math {
    public Vector2f() {
        this.x = 0f;
        this.y = 0f;
    }
    
    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public float lengthSquared2f() {
        return x * x + y * y;
    }
    
    /*
    public Vector2f normalize() {
        float length = length();
        return divide(length);
    }
    */
    
    public Vector2f add(Vector2f other) {
        float newX = this.x + other.x;
        float newY = this.y + other.y;
        return new Vector2f(newX, newY);
    }
}