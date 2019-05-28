package com.typstudy.java;

/**
 * @author typ
 * @date 2019/5/17 17:31
 * @Description: com.typstudy.java
 */
public class ThreadTest3 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.setName("线程1：");
        test1.setPriority(Thread.MAX_PRIORITY );
        int priority = test1.getPriority();
        String name = test1.getName();
        System.out.println(name+priority);

        test1.start();
      /* new Test1().start();*/
       /* Test2 test2 = new Test2();
        Thread thread = new Thread(test2);
        thread.start();*/
       /*new Thread(new Test2()).start();*/
    }
}

/**
 * 输出1~100内的偶数
 */
class Test1 extends Thread{
    public Test1() {
    }

    @Override
    public void run() {
        for(int i=1;i<=100;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
}
/**
 * 输出1~100内的奇数
 */
class Test2 implements Runnable{
    public Test2() {
    }

    @Override
    public void run() {
        for(int i=1;i<=100;i++){
            if(i%2!=0){
                System.out.println(i);
            }
        }
    }
}
