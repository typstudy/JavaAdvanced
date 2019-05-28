package com.typstudy.java;

/**
 * @author typ
 * @date 2019/5/17 22:10
 * @Description: com.typstudy.java
 * <p>
 * 使用同步方法解决实现Runnable接口的线程安全问题
 * <p>
 * <p>
 * 关于同步方法的总结：
 * 1. 同步方法仍然涉及到同步监视器，只是不需要我们显式的声明。
 * 2. 非静态的同步方法，同步监视器是：this
 * 静态的同步方法，同步监视器是：当前类本身
 */
public class TicketTest4 {
    public static void main(String[] args) {
        Window4 window = new Window4();
        Thread w1 = new Thread(window);
        Thread w2 = new Thread(window);
        Thread w3 = new Thread(window);
        w1.setName("窗口one：");
        w2.setName("窗口two：");
        w3.setName("窗口three：");
        w1.start();
        w2.start();
        w3.start();
    }
}

class Window4 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        show();
    }

    private synchronized void show() {
        while (true) {
            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +
                        "售出车票，ticket号为：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}