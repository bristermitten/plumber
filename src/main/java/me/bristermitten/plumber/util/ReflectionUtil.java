package me.bristermitten.plumber.util;

import java.lang.reflect.InvocationTargetException;

public class ReflectionUtil {

    public static Object invokeNoArgsStaticMethod(Class<?> clazz, String methodName) {
        try {
            return clazz.getDeclaredMethod(methodName).invoke(null);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }
}
