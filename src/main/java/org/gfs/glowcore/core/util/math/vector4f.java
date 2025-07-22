package org.gfs.glowcore.core.util.math;

public final class Vector4f extends math {
    
    // Кэшированные часто используемые векторы
    public static final Vector4f ZERO = new Vector4f(0f, 0f, 0f, 0f);
    public static final Vector4f UNIT_X = new Vector4f(1f, 0f, 0f, 0f);
    public static final Vector4f UNIT_Y = new Vector4f(0f, 1f, 0f, 0f);
    public static final Vector4f UNIT_Z = new Vector4f(0f, 0f, 1f, 0f);
    public static final Vector4f UNIT_W = new Vector4f(0f, 0f, 0f, 1f);
    public static final Vector4f ONE = new Vector4f(1f, 1f, 1f, 1f);

    // Конструктор по умолчанию - нулевой вектор
    public Vector4f() {
        this(0f, 0f, 0f, 0f);
    }

    // Основной конструктор
    public Vector4f(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    // Операции с возвращением нового вектора (иммутабельные)
    public Vector4f add(Vector4f other) {
        return new Vector4f(
            x + other.x,
            y + other.y,
            z + other.z,
            w + other.w
        );
    }

    public Vector4f subtract(Vector4f other) {
        return new Vector4f(
            x - other.x,
            y - other.y,
            z - other.z,
            w - other.w
        );
    }

    public Vector4f multiply(float scalar) {
        return new Vector4f(
            x * scalar,
            y * scalar,
            z * scalar,
            w * scalar
        );
    }

    public Vector4f divide(float scalar) {
        final float inv = 1.0f / scalar;
        return multiply(inv);
    }

    // Операции с модификацией текущего вектора (мутабельные)
    public Vector4f addLocal(Vector4f other) {
        return set(
            x + other.x,
            y + other.y,
            z + other.z,
            w + other.w
        );
    }

    public Vector4f subtractLocal(Vector4f other) {
        return set(
            x - other.x,
            y - other.y,
            z - other.z,
            w - other.w
        );
    }

    public Vector4f multiplyLocal(float scalar) {
        return set(
            x * scalar,
            y * scalar,
            z * scalar,
            w * scalar
        );
    }

    public Vector4f divideLocal(float scalar) {
        final float inv = 1.0f / scalar;
        return multiplyLocal(inv);
    }

    // Векторные операции
    public float dot(Vector4f other) {
        return x * other.x 
             + y * other.y 
             + z * other.z 
             + w * other.w;
    }

    public float lengthSquared() {
        return dot(this);
    }

    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    public Vector4f normalize() {
        final float len = length();
        return (len > 1e-8f) ? multiply(1.0f / len) : new Vector4f();
    }

    public Vector4f normalizeLocal() {
        final float len = length();
        return (len > 1e-8f) ? multiplyLocal(1.0f / len) : set(0f, 0f, 0f, 0f);
    }

    // Утилитарные методы
    public Vector4f lerp(Vector4f target, float alpha) {
        return new Vector4f(
            x + (target.x - x) * alpha,
            y + (target.y - y) * alpha,
            z + (target.z - z) * alpha,
            w + (target.w - w) * alpha
        );
    }

    public float distanceSquared(Vector4f other) {
        final float dx = x - other.x;
        final float dy = y - other.y;
        final float dz = z - other.z;
        final float dw = w - other.w;
        return dx * dx + dy * dy + dz * dz + dw * dw;
    }

    public float distance(Vector4f other) {
        return (float) Math.sqrt(distanceSquared(other));
    }

    // Методы для установки значений (создают новый объект)
    public Vector4f set(float x, float y, float z, float w) {
        return new Vector4f(x, y, z, w);
    }

    public Vector4f set(Vector4f other) {
        return new Vector4f(other.x, other.y, other.z, other.w);
    }

    // Переопределенные методы Object
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector4f vector4f = (Vector4f) o;
        return Float.compare(vector4f.x, x) == 0 &&
               Float.compare(vector4f.y, y) == 0 &&
               Float.compare(vector4f.z, z) == 0 &&
               Float.compare(vector4f.w, w) == 0;
    }

    @Override
    public int hashCode() {
        int result = Float.floatToIntBits(x);
        result = 31 * result + Float.floatToIntBits(y);
        result = 31 * result + Float.floatToIntBits(z);
        result = 31 * result + Float.floatToIntBits(w);
        return result;
    }

    @Override
    public String toString() {
        return String.format("[%.3f, %.3f, %.3f, %.3f]", x, y, z, w);
    }

    // Конвертация в массив float (полезно для OpenGL)
    public float[] toArray() {
        return new float[]{x, y, z, w};
    }
}