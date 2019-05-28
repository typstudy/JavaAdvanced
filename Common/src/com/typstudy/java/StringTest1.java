package com.typstudy.java;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author typ
 * @date 2019/5/19 21:19
 * @Description: com.typstudy.java
 * 涉及到String类与其他结构之间的转换
 */
public class StringTest1 {
    @Test
    public void test1(){
        String str="123456";
        int num = Integer.parseInt(str);
        String str1 = String.valueOf(123456);
        System.out.println(str.equals(str1));
        String str2=num+"";
        System.out.println(str == str2);
    }
    /**
     String 与 char[]之间的转换

     String --> char[]:调用String的toCharArray()
     char[] --> String:调用String的构造器
     */
    @Test
    public void test2(){
        String str="abcd123456yu";
        char[] chars = str.toCharArray();
        for(int i=0;i<chars.length;i++){
            System.out.println(chars[i]);
        }
        char[] ch={'h','e','l','l','o'};
        String str1= new String(ch);
        System.out.println(str1);
    }
    /**
     String 与 byte[]之间的转换
     编码：String --> byte[]:调用String的getBytes()
     解码：byte[] --> String:调用String的构造器

     编码：字符串 -->字节  (看得懂 --->看不懂的二进制数据)
     解码：编码的逆过程，字节 --> 字符串 （看不懂的二进制数据 ---> 看得懂）

     说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码。
     */
    @Test
    public void test3() throws Exception {
        String str="abc123456中国";
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));
        byte[] gbks = str.getBytes("GBK");
        System.out.println(Arrays.toString(gbks));
        System.out.println("-----------------------------------------");
        String s = new String(bytes);
        System.out.println(s);
        String s1 = new String(gbks);
        System.out.println(s1);
        String gbk = new String(gbks, "gbk");
        System.out.println(gbk);
    }
}
