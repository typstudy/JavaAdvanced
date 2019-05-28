package com.typstudy.exer;

/**
 * @author typ
 * @date 2019/5/19 20:20
 * @Description: com.typstudy.exer
 */
public class StringTest {
    String str=new String("good");
    char[] c={'t','e','s','t'};
    public void change(String str,char c[]){
        str="test ok";
        c[0]='b';
    }

    public static void main(String[] args) {
        StringTest stringTest = new StringTest();
        stringTest.change(stringTest.str,stringTest.c);
        System.out.println(stringTest.str);
        System.out.println(stringTest.c);
    }
}
