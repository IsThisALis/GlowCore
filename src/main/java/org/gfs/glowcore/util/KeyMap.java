package org.gfs.glowcore.util;

import java.util.HashMap;
import org.lwjgl.glfw.*;

public class KeyMap {
    
    HashMap<String, Integer> keyMap = new HashMap<>();
    
    public void keyMapCreate() {
        
        keyMap.put("GLFW_KEY_SPACE", 32);
        keyMap.put("GLFW_KEY_APOSTROPHE", 39);
        keyMap.put("GLFW_KEY_COMMA", 44);
        keyMap.put("GLFW_KEY_MINUS", 45);
        keyMap.put("GLFW_KEY_PERIOD", 46);
        keyMap.put("GLFW_KEY_SLASH", 47);
        keyMap.put("GLFW_KEY_0", 48);
        keyMap.put("GLFW_KEY_1", 49);
        keyMap.put("GLFW_KEY_2", 50);
        keyMap.put("GLFW_KEY_3", 51);
        keyMap.put("GLFW_KEY_4", 52);
        keyMap.put("GLFW_KEY_5", 53);
        keyMap.put("GLFW_KEY_6", 54);
        keyMap.put("GLFW_KEY_7", 55);
        keyMap.put("GLFW_KEY_8", 56);
        keyMap.put("GLFW_KEY_9", 57);
        keyMap.put("GLFW_KEY_SEMICOLON", 59);
        keyMap.put("GLFW_KEY_EQUAL", 61);
        keyMap.put("GLFW_KEY_A", 65);
        keyMap.put("GLFW_KEY_B", 66);
        keyMap.put("GLFW_KEY_C", 67);
        keyMap.put("GLFW_KEY_D", 68);
        keyMap.put("GLFW_KEY_E", 69);
        keyMap.put("GLFW_KEY_F", 70);
        keyMap.put("GLFW_KEY_G", 71);
        keyMap.put("GLFW_KEY_H", 72);
        keyMap.put("GLFW_KEY_I", 73);
        keyMap.put("GLFW_KEY_J", 74);
        keyMap.put("GLFW_KEY_K", 75);
        keyMap.put("GLFW_KEY_L", 76);
        keyMap.put("GLFW_KEY_M", 77);
        keyMap.put("GLFW_KEY_N", 78);
        keyMap.put("GLFW_KEY_O", 79);
        keyMap.put("GLFW_KEY_P", 80);
        keyMap.put("GLFW_KEY_Q", 81);
        keyMap.put("GLFW_KEY_R", 82);
        keyMap.put("GLFW_KEY_S", 83);
        keyMap.put("GLFW_KEY_T", 84);
        keyMap.put("GLFW_KEY_U", 85);
        keyMap.put("GLFW_KEY_V", 86);
        keyMap.put("GLFW_KEY_W", 87);
        keyMap.put("GLFW_KEY_X", 88);
        keyMap.put("GLFW_KEY_Y", 89);
        keyMap.put("GLFW_KEY_Z", 90);
        keyMap.put("GLFW_KEY_LEFT_BRACKET", 91);
        keyMap.put("GLFW_KEY_BACKSLASH", 92);
        keyMap.put("GLFW_KEY_RIGHT_BRACKET", 93);
        keyMap.put("GLFW_KEY_GRAVE_ACCENT", 96);
        keyMap.put("GLFW_KEY_WORLD_1", 161);
        keyMap.put("GLFW_KEY_WORLD_2", 162);
        keyMap.put("GLFW_KEY_ESCAPE", 256);
        keyMap.put("GLFW_KEY_ENTER", 257);
        keyMap.put("GLFW_KEY_TAB", 258);
        keyMap.put("GLFW_KEY_BACKSPACE", 259);
        keyMap.put("GLFW_KEY_INSERT", 260);
        keyMap.put("GLFW_KEY_DELETE", 261);
        keyMap.put("GLFW_KEY_RIGHT", 262);
        keyMap.put("GLFW_KEY_LEFT", 263);
        keyMap.put("GLFW_KEY_DOWN", 264);
        keyMap.put("GLFW_KEY_UP", 265);
        keyMap.put("GLFW_KEY_PAGE_UP", 266);
        keyMap.put("GLFW_KEY_PAGE_DOWN", 267);
        keyMap.put("GLFW_KEY_HOME", 268);
        keyMap.put("GLFW_KEY_END", 269);
        keyMap.put("GLFW_KEY_CAPS_LOCK", 280);
        keyMap.put("GLFW_KEY_SCROLL_LOCK", 281);
        keyMap.put("GLFW_KEY_NUM_LOCK", 282);
        keyMap.put("GLFW_KEY_PRINT_SCREEN", 283);
        keyMap.put("GLFW_KEY_PAUSE", 284);
        keyMap.put("GLFW_KEY_F1", 290);
        keyMap.put("GLFW_KEY_F2", 291);
        keyMap.put("GLFW_KEY_F3", 292);
        keyMap.put("GLFW_KEY_F4", 293);
        keyMap.put("GLFW_KEY_F5", 294);
        keyMap.put("GLFW_KEY_F6", 295);
        keyMap.put("GLFW_KEY_F7", 296);
        keyMap.put("GLFW_KEY_F8", 297);
        keyMap.put("GLFW_KEY_F9", 298);
        keyMap.put("GLFW_KEY_F10", 299);
        keyMap.put("GLFW_KEY_F11", 300);
        keyMap.put("GLFW_KEY_F12", 301);
        keyMap.put("GLFW_KEY_F13", 302);
        keyMap.put("GLFW_KEY_F14", 303);
        keyMap.put("GLFW_KEY_F15", 304);
        keyMap.put("GLFW_KEY_F16", 305);
        keyMap.put("GLFW_KEY_F17", 306);
        keyMap.put("GLFW_KEY_F18", 307);
        keyMap.put("GLFW_KEY_F19", 308);
        keyMap.put("GLFW_KEY_F20", 309);
        keyMap.put("GLFW_KEY_F21", 310);
        keyMap.put("GLFW_KEY_F22", 311);
        keyMap.put("GLFW_KEY_F23", 312);
        keyMap.put("GLFW_KEY_F24", 313);
        keyMap.put("GLFW_KEY_F25", 314);
        keyMap.put("GLFW_KEY_KP_0", 320);
        keyMap.put("GLFW_KEY_KP_1", 321);
        keyMap.put("GLFW_KEY_KP_2", 322);
        keyMap.put("GLFW_KEY_KP_3", 323);
        keyMap.put("GLFW_KEY_KP_4", 324);
        keyMap.put("GLFW_KEY_KP_5", 325);
        keyMap.put("GLFW_KEY_KP_6", 326);
        keyMap.put("GLFW_KEY_KP_7", 327);
        keyMap.put("GLFW_KEY_KP_8", 328);
        keyMap.put("GLFW_KEY_KP_9", 329);
        keyMap.put("GLFW_KEY_KP_DECIMAL", 330);
        keyMap.put("GLFW_KEY_KP_DIVIDE", 331);
        keyMap.put("GLFW_KEY_KP_MULTIPLY", 332);
        keyMap.put("GLFW_KEY_KP_SUBTRACT", 333);
        keyMap.put("GLFW_KEY_KP_ADD", 334);
        keyMap.put("GLFW_KEY_KP_ENTER", 335);
        keyMap.put("GLFW_KEY_KP_EQUAL", 336);
        keyMap.put("GLFW_KEY_LEFT_SHIFT", 340);
        keyMap.put("GLFW_KEY_LEFT_CONTROL", 341);
        keyMap.put("GLFW_KEY_LEFT_ALT", 342);
        keyMap.put("GLFW_KEY_LEFT_SUPER", 343);
        keyMap.put("GLFW_KEY_RIGHT_SHIFT", 344);
        keyMap.put("GLFW_KEY_RIGHT_CONTROL", 345);
        keyMap.put("GLFW_KEY_RIGHT_ALT", 346);
        keyMap.put("GLFW_KEY_RIGHT_SUPER", 347);
        keyMap.put("GLFW_KEY_MENU", 348);
        
    }
    
    public int getValue(String key) {
        return keyMap.get(key);
    }
    
    public boolean keyContain(String key) {
        return keyMap.containsKey(key);
    }
    
    public int mapSize() {
        return keyMap.size();
    }
    
}