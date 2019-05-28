package com.typstudy.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author typ
 * @date 2019/5/27 17:40
 * @Description: com.typstudy.java
 *
 * 类加载器
 */
public class ClassLoaderTest {
    @Test
    public void test1(){
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        ClassLoader parent1 = parent.getParent();
        System.out.println("parent1 = " + parent1);
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println("classLoader1 = " + classLoader1);
    }
    @Test
    public void test2() throws IOException {
        Properties prop = new Properties();
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream resource = classLoader.getResourceAsStream("jdbc.properties");
        prop.load(resource);
        System.out.println(prop.getProperty("name"));
    }
}
