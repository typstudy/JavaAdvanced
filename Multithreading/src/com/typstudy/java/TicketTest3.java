package com.typstudy.java;

/**
 * @author typ
 * @date 2019/5/17 21:49
 * @Description: com.typstudy.java
 */
public class TicketTest3 {
    public static void main(String[] args) {
        Window3 w1 = new Window3();
        Window3 w2 = new Window3();
        Window3 w3 = new Window3();
        w1.setName("窗口one：");
        w2.setName("窗口two：");
        w3.setName("窗口three：");
        w1.start();
        w2.start();
        w3.start();
    }
}
class Window3 extends Thread{
    private static int ticket=100;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
           /* synchronized (Window3.class){*/
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
}