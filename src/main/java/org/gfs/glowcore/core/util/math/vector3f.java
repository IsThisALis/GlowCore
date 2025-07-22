package org.gfs.glowcore.core.util.math;

public class Vector3f extends math {
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
    
    public float lengthSquared3f() {
        return x*x + y*y + z*z;
    }
    
    /*
    public Vector3f normalize() {
        float length = length();
        return divide(length);
    }
    */
    
    public Vector3f add(Vector3f other) {
        float newX = this.x + other.x;
        float newY = this.y + other.y;
        float newZ = this.z + other.z;
        return new Vector3f(newX, newY, newZ);
    }
}