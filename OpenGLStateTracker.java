package br.com.fastfps.util;

import java.lang.reflect.Method;

public final class OpenGLStateTracker {

    private static boolean blendEnabled = false;
    private static boolean texture2DEnabled = true;

    private static Method glEnableMethod;
    private static Method glDisableMethod;
    private static int GL_BLEND_VAL = 3042;
    private static int GL_TEXTURE_2D_VAL = 3553;

    static {
        try {
            Class<?> glClass = Class.forName("org.lwjgl.opengl.GL11");
            glEnableMethod = glClass.getMethod("glEnable", int.class);
            glDisableMethod = glClass.getMethod("glDisable", int.class);
            GL_BLEND_VAL = glClass.getField("GL_BLEND").getInt(null);
            GL_TEXTURE_2D_VAL = glClass.getField("GL_TEXTURE_2D").getInt(null);
        } catch (Throwable ignored) {
        }
    }

    private OpenGLStateTracker() {
        throw new UnsupportedOperationException();
    }

    public static void setBlend(boolean enable) {
        if (blendEnabled != enable) {
            blendEnabled = enable;
            invokeGl(enable ? glEnableMethod : glDisableMethod, GL_BLEND_VAL);
        }
    }

    public static void setTexture2D(boolean enable) {
        if (texture2DEnabled != enable) {
            texture2DEnabled = enable;
            invokeGl(enable ? glEnableMethod : glDisableMethod, GL_TEXTURE_2D_VAL);
        }
    }

    private static void invokeGl(Method method, int target) {
        if (method != null) {
            try {
                method.invoke(null, target);
            } catch (Throwable ignored) {
            }
        }
    }

    public static void syncState(boolean blendState, boolean textureState) {
        blendEnabled = blendState;
        texture2DEnabled = textureState;
    }

    public static boolean isBlendEnabled() {
        return blendEnabled;
    }

    public static boolean isTexture2DEnabled() {
        return texture2DEnabled;
    }
}