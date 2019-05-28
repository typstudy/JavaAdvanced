package com.typstudy.java2;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author typ
 * @date 2019/5/19 17:14
 * @Description: com.typstudy.java2
 *
 * 创建线程的方式四：使用线程池
 *
 * 好处：
 * 1.提高响应速度（减少了创建新线程的时间）
 * 2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * 3.便于线程管理
 *      corePoolSize：核心池的大小
 *      maximumPoolSize：最大线程数
 *      keepAliveTime：线程没有任务时最多保持多长时间后会终止
 *
 *
 */
public class ThreadPoolTest {
    public static void main(String[] args) {

        /*ExecutorService pool = Executors.newFixedThreadPool(10);*/

        ThreadPoolExecutor pool = new ThreadPoolExecutor(10,50,0L,
                TimeUnit.MICROSECONDS,new LinkedBlockingDeque<Runnable>());
        MyPool myPool = new MyPool();
        MyPool myPool1=new MyPool();
        pool.execute(myPool);
        pool.execute(myPool1);
        pool.shutdown();
    }
}
class MyPool implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<=100;i++){
            if (i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}