package com.wy.integration.utils.support;


import com.wy.integration.core.MySysUser;
import com.wy.integration.exception.ErrCode.CMMErrorCode;
import com.wy.integration.exception.ResponseException;

import java.lang.reflect.Field;
import java.util.Date;

public class DaoSupports {
    public DaoSupports() {

    }

    public static Integer addOrgId(Object obj) {//添加机构主键
        try {
        if (MySysUser.getUser() == null) {

                Class c = obj.getClass();
                // 获取删除标记
                Field f = c.getDeclaredField("orgId");
                if(f==null) return 0;
                // 取消语言访问检查
                f.setAccessible(true);


                // 设置删除标记
                f.set(obj, "0");

        }else{
            Class c = obj.getClass();
            // 获取删除标记
            Field f = c.getDeclaredField("orgId");
            if(f==null) return 0;
            // 取消语言访问检查
            f.setAccessible(true);


            // 设置删除标记
            f.set(obj, MySysUser.orgId());
        }

        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.getMessage();
        }
        return 1;
    }
    //判断id是否为空
    private  static void existIdIsNull(Object obj){
        try {
        Class c = obj.getClass();
        // 获取Id
        Field f = c.getDeclaredField("id");

        // 取消语言访问检查
        f.setAccessible(true);
        Object val = f.get(obj);
        if(val==null||val.equals(""))  throw new ResponseException(CMMErrorCode.ENTITY_IS_NULL);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException  | IllegalAccessException e) {
            e.getMessage();
        }
    }

    //新增初始化
    public static void addProperty(Object obj) {
        try {
            setIdProperty(obj);
            createdBy(obj);
            createdTime(obj);
            adddeletedFlag(obj);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.getMessage();
        }
    }

    //验证实体是否为空
    public static void entityIsNotNoll(Object obj){
        if(obj==null) throw new ResponseException(CMMErrorCode.ENTITY_IS_NULL);
        existIdIsNull(obj);
    }
    //更新初始化
    public static void updateProperty(Object obj) {
        entityIsNotNoll(obj);
        try {
            updateTime(obj);
            updateBy(obj);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.getMessage();
        }
    }



    //逻辑删除初始化
    public static void deleteProperty(Object obj) {
        entityIsNotNoll(obj);
        try {
        Class c = obj.getClass();
        // 获取删除标记
        Field f = c.getDeclaredField("delFlag");

        // 取消语言访问检查
        f.setAccessible(true);


        // 设置删除标记
        f.set(obj, 1);
    } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
        e.getMessage();
    }
    }

    private static void createdTime(Object obj) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

        //获取创建时间
        Class c = obj.getClass();
        // 获取Id
        Field f = c.getDeclaredField("createDate");

        // 取消语言访问检查
        f.setAccessible(true);

        Date date = new Date();
        // 给更新时间赋值
        f.set(obj, date);
    }

    //创建者;
    private static void createdBy(Object obj) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        try {
            if (MySysUser.getUser() == null) {

                Class c = obj.getClass();
                // 获取删除标记
                Field f = c.getDeclaredField("createBy");
                // 取消语言访问检查
                f.setAccessible(true);


                // 设置删除标记
                f.set(obj, "0");

            }else{
                Class c = obj.getClass();
                // 获取删除标记
                Field f = c.getDeclaredField("createBy");
                // 取消语言访问检查
                f.setAccessible(true);


                // 设置删除标记
                f.set(obj, MySysUser.id());
            }

        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.getMessage();
        }
    }

    //创建者;
    private static void updateBy(Object obj) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        try {
            if (MySysUser.getUser() == null) {

                Class c = obj.getClass();
                // 获取删除标记
                Field f = c.getDeclaredField("updateBy");
                // 取消语言访问检查
                f.setAccessible(true);


                // 设置删除标记
                f.set(obj, "0");

            }else{
                Class c = obj.getClass();
                // 获取删除标记
                Field f = c.getDeclaredField("updateBy");
                // 取消语言访问检查
                f.setAccessible(true);


                // 设置删除标记
                f.set(obj, MySysUser.id());
            }

        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.getMessage();
        }
    }

    private static void updateTime(Object obj) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

        //获取创建时间
        Class c = obj.getClass();
        // 获取Id
        Field f = c.getDeclaredField("updateDate");

        // 取消语言访问检查
        f.setAccessible(true);

        Date date = new Date();
        // 给创建时间赋值
        f.set(obj, date);
    }

    private static void adddeletedFlag(Object obj) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

        Class c = obj.getClass();
        // 获取删除标记
        Field f = c.getDeclaredField("delFlag");

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

    //根据id,查找逻辑删除
    public static void findById(Object obj,String value) {
        try {
            findSetId(obj,value);
            adddeletedFlag(obj);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.getMessage();
        }

    }


    // 查找逻辑删除 给id赋值
    private static void findSetId(Object obj,String value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

        Class c = obj.getClass();
        // 获取Id
        Field f = c.getDeclaredField("id");

        // 取消语言访问检查
        f.setAccessible(true);

        // 给Id赋值
        f.set(obj, value);
    }

}