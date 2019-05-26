package com.atguigu.java;

import org.junit.Test;

import java.util.Random;

/**
 * Create by ming
 * 2019/5/26
 **/
public class Dynamic  {
    @Test
    public void test1() throws Exception{
        //调用无参的构造器
        Class clazz=Person.class;
        Object o = clazz.newInstance();
        System.out.println(o);
    }
    @Test
    public void test2(){
        for (int i=0;i<100;i++){
        String path="";
        int num = new Random().nextInt(3);
        switch (num){
            case 0:
                path="java.util.Date";
                break;
            case 1:
                path="java.lang.Object";
                break;
            case 2:
                path="com.atguigu.java.Person";
                break;
        }
        try {
            Object obj=getInstance(path);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}

    public Object getInstance(String classpath) throws Exception{
        Class aClass = Class.forName(classpath);
        Object o = aClass.newInstance();
        return o;

    }
}
