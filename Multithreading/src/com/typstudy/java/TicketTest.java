package com.typstudy.java;

/**
 * @author typ
 * @date 2019/5/17 21:01
 * @Description: com.typstudy.java
 * 模拟火车站售票程序，开启三个窗口售票。
 */
public class TicketTest {
    public static void main(String[] args) {
        Window window = new Window();
        //创建窗口
        Thread w1 = new Thread(window);
        Thread w2= new Thread(window);
        Thread w3 = new Thread(window);
        w1.setName("窗口one：");
        w2.setName("窗口two：");
        w3.setName("窗口three：");
        w1.start();
        w2.start();
        w3.start();

    }
}

/**
 * 窗口
 */
class Window implements Runnable{
    private int ticket=100;
    @Override
    public void run() {
        while (true){
            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+
                        "售出车票，ticket号为："+ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}