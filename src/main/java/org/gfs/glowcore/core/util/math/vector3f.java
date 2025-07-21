package org.gfs.glowcore.core.util.math;

import org.gfs.glowcore.core.util.math.math;


public class vector3f extends math {
    
    
    
    public Vector3f() {
        this.x = 0f;
        this.y = 0f;
        this.z = 0f;
    }
    
    
    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    
    public lengthSquared3f() {
        return x*x + y*y + z*z;
    }
    
    
    public Vector3f normalize() {
        float length = length();
        return divide(length);
    }
    
    
    public Vector3f add(Vector3f other) {
        float x = this.x + other.x;
        float y = this.y + other.y;
        float z = this.z + other.z;
        return new Vector3f(x, y, z);
    }
    
    
    
}