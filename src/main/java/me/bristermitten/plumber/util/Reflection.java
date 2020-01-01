package me.bristermitten.plumber.util;

import java.lang.reflect.InvocationTargetException;

public class Reflection {

    /**
     * Invoke a static method upon a class that has no arguments
     * @param clazz the class holding the method
     * @param methodName the method name
     * @return the object returned by the method
     */
    public static Object invokeNoArgsStaticMethod(Class<?> clazz, String methodName) {
        try {
            return clazz.getDeclaredMethod(methodName).invoke(null);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }
}
