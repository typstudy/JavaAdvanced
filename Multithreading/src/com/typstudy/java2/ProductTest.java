package com.typstudy.java2;

/**
 * @author typ
 * @date 2019/5/18 21:35
 * @Description: com.typstudy.java2
 *
 * 线程通信的应用：经典例题：生产者/消费者问题
 *
 * 生产者(Producer)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，店员
 * 会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品
 * 了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 *
 * 分析：
 * 1. 是否是多线程问题？是，生产者线程，消费者线程
 * 2. 是否有共享数据？是，店员（或产品）
 * 3. 如何解决线程的安全问题？同步机制,有三种方法
 * 4. 是否涉及线程的通信？是
 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Thread producer = new Thread(new Producer(clerk));
        Thread customer = new Thread(new Customer(clerk));
        producer.setName("生产者");
        customer.setName("消费者");
        producer.start();
        customer.start();

    }
}
class Clerk{
    private int product=0;
    public synchronized void addProduct(){
        if (product>=20){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            product++;
            System.out.println(Thread.currentThread().getName() + ":开始生产第" + product + "个产品");
            notifyAll();
        }
    }
    public synchronized void getProduct(){
        if(this.product<=0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println(Thread.currentThread().getName() + ":开始消费第" + product+ "个产品");
            product--;

            notifyAll();
        }
    }
}
class Producer implements Runnable{
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("开始生产产品");
        while (true){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addProduct();
        }
    }
}
class Customer implements Runnable{
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("消费者开始消费商品");
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.getProduct();
        }
    }
}