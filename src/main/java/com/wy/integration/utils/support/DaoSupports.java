package com.wy.integration.utils.support;


import java.lang.reflect.Field;
import java.util.Date;

public class DaoSupports {
    public DaoSupports() {

    }

    public static void Property(Object obj) {
        try {
            setIdProperty(obj);
            createdTime(obj);
            deletedFlag(obj);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.getMessage();
        }
    }


    private static void createdTime(Object obj) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

        //获取创建时间
        Class c = obj.getClass();
        // 获取Id
        Field f = c.getDeclaredField("createdTime");

        // 取消语言访问检查
        f.setAccessible(true);

        Date date = new Date();
        // 给创建时间赋值
        f.set(obj, date);
    }

    private static void deletedFlag(Object obj) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

        Class c = obj.getClass();
        // 获取删除标记
        Field f = c.getDeclaredField("deletedFlag");

        // 取消语言访问检查
        f.setAccessible(true);


        // 是否删除 默认0 不删除
        f.set(obj, 0);
    }


    // 该方法的参数列表是一个类的 类名、成员变量、给变量的赋值  利用反射 设置
    private static void setIdProperty(Object obj) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

        Class c = obj.getClass();
        // 获取Id
        Field f = c.getDeclaredField("id");

        // 取消语言访问检查
        f.setAccessible(true);

        String id = IDUtils.UUID();
        // 给Id赋值
        f.set(obj, id);
    }
}