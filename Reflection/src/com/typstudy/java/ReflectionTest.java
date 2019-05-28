package com.typstudy.java;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author typ
 * @date 2019/5/27 20:43
 * @Description: com.typstudy.java
 */
public class ReflectionTest {
    @Test
    public void test1() throws Exception {
            Class<User> clazz=User.class;
        Constructor<User> constructor = clazz.getConstructor(String.class, int.class);
        User user = constructor.newInstance("Tom", 22);
        System.out.println(user);
        Field age = clazz.getField("age");
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(user,"li4");
        age.set(user,20);
        System.out.println(user);

        System.out.println("------------------------------------");
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(user);
        Constructor<User> declaredConstructor = clazz.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        User user1 = declaredConstructor.newInstance("tim");
        System.out.println(user1);
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(user, "中国");

    }
    /**
     *
    疑问1：通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用那个？
    建议：直接new的方式。
    什么时候会使用：反射的方式。 反射的特征：动态性
    疑问2：反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术？
    不矛盾。

    关于java.lang.Class类的理解
    1.类的加载过程：
    程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。
    接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件
    加载到内存中。此过程就称为类的加载。加载到内存中的类，我们就称为运行时类，此
    运行时类，就作为Class的一个实例。

    2.换句话说，Class的实例就对应着一个运行时类。
    3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式
    来获取此运行时类。
     */
    //获取Class的实例的方式（前三种方式需要掌握）
    @Test
    public void test2() throws ClassNotFoundException {
        //1.
        Class<User> clazz1 = User.class;
        System.out.println("clazz1 = " + clazz1);
        //2.
        User user = new User();
        Class clazz2 = user.getClass();
        System.out.println("clazz2 = " + clazz2);
        //3.
        Class<?> clazz3 = Class.forName("com.typstudy.java.User");
        System.out.println(clazz3);
        //
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("com.typstudy.java.User");
        System.out.println(clazz4);
    }
    @Test
    public void test3(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }
    @Test
    public void test4() throws Exception {
        Class<User> userClass = User.class;
        User user = userClass.newInstance();
        System.out.println(user);
    }

}
