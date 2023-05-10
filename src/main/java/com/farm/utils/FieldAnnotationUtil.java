package com.farm.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;


/**
 *  在实体类的字段上添加注解
 * @author sutton
 * @date 2023/5/10
 */
public class FieldAnnotationUtil {

    /**
     * 在实体类的字段上添加注解
     * @param entity 实体类对象
     * @param fieldName 字段名
     * @param annotationClass 要添加的注解的类型
     */
    public static void addAnnotation(Object entity, String fieldName, Class<? extends Annotation> annotationClass) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<?> clazz = entity.getClass();
        Field field = clazz.getDeclaredField(fieldName);
        Annotation annotation = field.getAnnotation(annotationClass);
        if (annotation == null) {
            field.setAccessible(true);
            Annotation[] annotations = field.getAnnotations();
            Annotation[] newAnnotations = new Annotation[annotations.length + 1];
            System.arraycopy(annotations, 0, newAnnotations, 0, annotations.length);
            newAnnotations[newAnnotations.length - 1] = annotationClass.newInstance();
            field.set(entity, newAnnotations);
        }
    }

    /**
     * 在实体类上添加注解
     * @param entity 实体类对象
     * @param annotationClass 要添加的注解的类型
     */
    public static void addAnnotation(Object entity, Class<? extends Annotation> annotationClass) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<?> clazz = entity.getClass();
        Annotation annotation = clazz.getAnnotation(annotationClass);
        if (annotation == null) {
            Field field = Class.class.getDeclaredField("annotations");
            field.setAccessible(true);
            Annotation[] annotations = (Annotation[]) field.get(clazz);
            Annotation[] newAnnotations = new Annotation[annotations.length + 1];
            System.arraycopy(annotations, 0, newAnnotations, 0, annotations.length);
            newAnnotations[newAnnotations.length - 1] = annotationClass.newInstance();
            field.set(clazz, newAnnotations);
        }
    }
}