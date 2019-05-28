package com.typstudy.java;

import org.junit.Test;

/**
 * @author typ
 * @date 2019/5/19 19:52
 * @Description: com.typstudy.java
 */
public class StringTest {
    public static void main(String[] args) {
        String str1="abc";
        String str2="abc";
        //str2="abcd";
        System.out.println(str1==str2);
    }
    @Test
    public void test1(){
        String str1="JavaEE";
        String str2="JavaEE";
        String str3=new String("JavaEE");
        String str4=new String("JavaEE");
        System.out.println(str1==str2);
        System.out.println(str1 == str3);
        System.out.println(str2 == str4);
        System.out.println(str3 == str4);
    }
    /**
     结论：
     1.常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
     2.只要其中有一个是变量，结果就在堆中。
     3.如果拼接的结果调用intern()方法，返回值就在常量池中
     */
    @Test
    public void test2(){
        String str1="hello";
        String str2="hello";
        String str3="hello"+"hello";
        String str4=str1+"hello";
        String str5=str1+str2;
        String str6="hellohello";
        String str7=(str1+str2).intern();
        System.out.println(str3 == str6);
        System.out.println(str3 == str4);
        System.out.println(str3 == str5);
        System.out.println(str7 == str3);
    }
    @Test
    public void test3(){


    }
}
