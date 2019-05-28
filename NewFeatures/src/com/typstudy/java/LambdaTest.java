package com.typstudy.java;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author typ
 * @date 2019/5/27 22:36
 * @Description: com.typstudy.java
 */
public class LambdaTest {
    @Test
    public void test1(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱中国");
            }
        };
        runnable.run();
        System.out.println("---------------------------");
        Runnable runnable1=() ->  System.out.println("我爱大中国");
        runnable1.run();
    }
    @Test
    public void test2(){
        Comparator<Integer> comparator=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int compare = comparator.compare(21, 10);
        System.out.println("compare = " + compare);
        System.out.println("*****************************************");
        //Lambda
        //Comparator<Integer> comparator1= Comparator.comparingInt(o -> o);
        Comparator<Integer> comparator1= (o1,o2) -> Integer.compare(o1,o2);
        int compare1 = comparator1.compare(52, 23);
        System.out.println("compare1 = " + compare1);
        System.out.println("*****************************************");
        //方法引用
        Comparator<Integer> comparator2=Integer::compare;
        int compare2 = comparator2.compare(12, 32);
        System.out.println("compare2 = " + compare2);
    }
}
