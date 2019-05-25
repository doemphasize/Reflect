package com.atguigu.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {
    //反射之前对Person的操作
    @Test
    public void test1(){
        //1.创建Person类的对象
        Person p1 = new Person("Tom",12);
        p1.age=10;
        System.out.println(p1.toString());


    }
    //有了反射之后
    @Test
    public void test2()throws Exception{
        Class clazz=Person.class;
        //参数一个是string类型，一个是int类型的
        Constructor cons = clazz.getConstructor(String.class, int.class);
        //执行完成之后就会造一个对象，person对象
        Object obj = cons.newInstance("tom", 12);
        //强转
        Person p=(Person)obj;
        System.out.println(p.toString());
        //通过反射，调用对象指定的属性，方法
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());
        //调用方法,空参的方法
        Method show = clazz.getDeclaredMethod("show");
        //对象p的show方法
        show.invoke(p);
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true );
        Object p1 = cons1.newInstance("jerry");
        System.out.println(p1);

        //调用私有的属性和方法
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"HanMeiMei");
        System.out.println(p1);
        //调私有方法
        Method shownation = clazz.getDeclaredMethod("shownation", String.class);
        shownation.setAccessible(true);
        //invoke默认返回object类型的,所以强转
        String nation=(String)shownation.invoke(p1,"中国");//相当于p1.shownation
        System.out.println(nation);


    }
    @Test
    public void test3()throws Exception{
        //调用运行时类的属性
        Class<Person> clazz =Person.class;
        System.out.println(clazz);

//方式二
        Person p1 = new Person();
        //获取是哪个类造的
        Class p2 = p1.getClass();
        System.out.println(p2);
//方式三
        //通过调用Class的静态方法
        Class p3 = Class.forName("com.atguigu.java.Person");
        System.out.println(p3);

        System.out.println(clazz == p2);
        System.out.println(clazz == p3);
//方式四
        //通过类加载器
        ClassLoader classLoaderTest = ReflectTest.class.getClassLoader();
        Class clazz4 = classLoaderTest.loadClass("com.atguigu.java.Person");
        System.out.println(clazz4);


    }
}
