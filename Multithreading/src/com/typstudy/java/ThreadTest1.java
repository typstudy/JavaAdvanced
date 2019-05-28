package com.typstudy.java;

/**
 * @author typ
 * @date 2019/5/17 17:10
 * @Description: com.typstudy.java
 * 多线程实现方式之一：继承Thread类
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}

class MyThread extends Thread {
    public MyThread() {
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
