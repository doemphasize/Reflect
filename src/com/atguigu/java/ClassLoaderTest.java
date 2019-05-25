package com.atguigu.java;

import org.junit.Test;

/**
 * Create by ming
 * 2019/5/25
 **/
public class ClassLoaderTest {
    @Test
    public  void test1(){
        //获取的是系统类加载器
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //获取扩展类加载器
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        //实际上是有的，但是不能调用，系统的，引导类加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
    }
}
