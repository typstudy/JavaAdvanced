package com.typstudy.java;

/**
 * @author typ
 * @date 2019/5/17 17:21
 * @Description: com.typstudy.java
 * 多线程实现方式之一：实现Runnable
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        thread.start();
    }
}
class MyThread2 implements Runnable{
    public MyThread2() {
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
