package org.gfs.glowcore.core.util.math;

import org.gfs.glowcore.core.util.math.math;


public class vector2f extends math {


    public Vector2f() {
        this.x = 0f;
        this.y = 0f;
    }
    
    
    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    
    public float lengthSquared1f() {
        return x * x + y * y;
    }
    
    
    public Vector2f normalize() {
        float length = length();
        return divide(length);
    }
    
    
    public Vector2f add(Vector2f other) {
        float x = this.x + other.x;
        float y = this.y + other.y;
        return new Vector2f(x, y);
    }
    
  }  