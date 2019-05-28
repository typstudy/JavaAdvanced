package com.typstudy.java;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author typ
 * @date 2019/5/18 20:19
 * @Description: com.typstudy.java
 * <p>
 * 解决线程安全问题的方式三：Lock锁  --- JDK5.0新增
 * <p>
 * 1. 面试题：synchronized 与 Lock的异同？
 * 相同：二者都可以解决线程安全问题
 * 不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 * Lock需要手动的启动同步（lock()），同时结束同步也需要手动的实现（unlock()）
 * <p>
 * 2.优先使用顺序：
 * Lock  同步代码块（已经进入了方法体，分配了相应资源）  同步方法（在方法体之外）
 */
public class LockTest {
    public static void main(String[] args) {
        MyLock myLock = new MyLock();
        Thread l1 = new Thread(myLock);
        Thread l2 = new Thread(myLock);
        Thread l3 = new Thread(myLock);
        l1.setName("线程1：");
        l2.setName("线程2：");
        l3.setName("线程3：");
        l1.start();
        l2.start();
        l3.start();
    }
}

class MyLock implements Runnable {
    private int ticket = 1000;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() +
                            "售出车票，ticket号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }
}
