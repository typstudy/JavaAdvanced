package com.typstudy.java1;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author typ
 * @date 2019/5/21 19:52
 * @Description: com.typstudy.java1
 *
 * 其他常用类的使用
 * 1.System
 * 2.Math
 * 3.BigInteger 和 BigDecimal
 */
public class OtherClassTest {
    @Test
    public void test1(){
        String javaVersion = System.getProperty("java.version");
        System.out.println(javaVersion);
        String osName = System.getProperty("os.name");
        System.out.println(osName);
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));
    }
    @Test
    public void test2(){
        System.out.println(Math.sqrt(4));
        System.out.println(Math.abs(-6));
        System.out.println(Math.pow(2,3));
        System.out.println(Math.PI);
        System.out.println(Math.acos(Math.PI/3));

        BigInteger bi = new BigInteger("1243324112234324324325235245346567657653");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2, 25, BigDecimal.ROUND_HALF_UP));
    }
}
