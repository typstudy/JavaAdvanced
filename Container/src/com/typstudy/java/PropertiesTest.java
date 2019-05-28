package com.typstudy.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author typ
 * @date 2019/5/23 19:42
 * @Description: com.typstudy.java
 * Properties
 */
public class PropertiesTest {
    @Test
    public void test1() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("jdbc.properties"));
            String user = prop.getProperty("user");
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
