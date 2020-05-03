package com.sailfish.component.util;

import java.lang.reflect.Field;

/**
 * @author sailfish
 * @create 2020-05-03-12:01 上午
 */
public class ReflectUtil {

    public static Field getDeclaredField(Object object, String fieldName) {
        Field field = null;
        Class clazz = object.getClass();

        while(clazz != Object.class) {
            try {
                field = clazz.getDeclaredField(fieldName);
                return field;
            } catch (Exception var5) {
                clazz = clazz.getSuperclass();
            }
        }

        return null;
    }
}
