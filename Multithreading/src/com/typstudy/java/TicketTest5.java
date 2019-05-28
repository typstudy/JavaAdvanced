package com.typstudy.java;

/**
 * @author typ
 * @date 2019/5/17 21:49
 * @Description: com.typstudy.java
 * 使用同步方法解决实现Thread方法的线程安全问题
 */
public class TicketTest5 {
    public static void main(String[] args) {
        Window5 w1 = new Window5();
        Window5 w2 = new Window5();
        Window5 w3 = new Window5();
        w1.setName("窗口one：");
        w2.setName("窗口two：");
        w3.setName("窗口three：");
        w1.start();
        w2.start();
        w3.start();
    }
}

class Window5 extends Thread{
    private static int ticket=100;
    @Override
    public void run() {
        show();
    }
    private static synchronized void show(){
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