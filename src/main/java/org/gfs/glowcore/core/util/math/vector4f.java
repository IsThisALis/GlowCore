package org.gfs.glowcore.core.util.math;

import org.gfs.glowcore.core.util.math.math;


public class vector4f extends math {
    
    
    
    public float Vector4f() {
        float x = 0f;
        float y = 0f;
        float z = 0f;
        float w = 0f;
    }
    
    
    public void Vector4f(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
    
    
    public float lengthSquared4f() {
        return x*x + y*y + z*z + w*w;
    }
    
    
    public Vector4f normalize() {
        float length = length();
        return divide(length);
    }
    
    
    public float Vector4f add(Vector4f other) {
        float x = this.x + other.x;
        float y = this.y + other.y;
        float z = this.z + other.z;
        float w = this.w + other.w;
        return new Vector4f(x, y, z, w);
    }
    
    
    
}