package com.atguigu.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.util.Properties;

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
@Test
    public void test2() throws Exception{
        Properties p = new Properties();
        FileInputStream inputStream = new FileInputStream("day01reflect\\jdbc.properties");
        p.load(inputStream);

        String user=p.getProperty("user");
        String password=p.getProperty("password");
        System.out.println("用户:"+user+"密码："+password);
    }
}
