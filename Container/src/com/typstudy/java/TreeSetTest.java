package com.typstudy.java;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author typ
 * @date 2019/5/22 20:59
 * @Description: com.typstudy.java
 *
 *     1.向TreeSet中添加的数据，要求是相同类的对象。
 *     2.两种排序方式：自然排序（实现Comparable接口） 和 定制排序（Comparator）
 *
 *
 *     3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0.不再是equals().
 *     4.定制排序中，比较两个对象是否相同的标准为：compare()返回0.不再是equals().
 *
 */
public class TreeSetTest {
    /**
     * 必须添加相同数据类型数据
     */
    @Test
    public void test1(){
        TreeSet set = new TreeSet();
        set.add(123);
        set.add(456);
        set.add("hello");
        set.add(new Person());
        System.out.println(set);
    }

    /**
     * TreeSet默认自然排序 由低到高
     */
    @Test
    public void test2(){
        TreeSet set = new TreeSet();
        set.add(123);
        set.add(456);
        set.add(-963);
        set.add(56);
        set.add(256);
        System.out.println(set);
        TreeSet set1 = new TreeSet();
        set1.add("hello");
        set1.add("hellos");
        set1.add("java");
        set1.add("web");
        set1.add("spring");
        System.out.println(set1);
    }

    /**
     * 实现Comparable接口
     */
    @Test
    public void test3(){
        TreeSet set = new TreeSet();
        set.add(new Person("Tom",20));
        set.add(new Person("Tom",28));
        set.add(new Person("Jack",18));
        set.add(new Person("Tim",30));
        set.add(new Person("Jen",25));
        set.add(new Person("LI",36));
        set.add(new Person("Ml",29));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * 通过Comparator接口，重写compare
     */
    @Test
    public void test4(){
        Comparator com=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User&& o2 instanceof User){
                    User u1=(User)o1;
                    User u2=(User)o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }else {
                    throw new RuntimeException("输入类型错误");
                }
            }
        };
        TreeSet set = new TreeSet(com);
        set.add(new User("Tom",20));
        set.add(new User("Tom",28));
        set.add(new User("Jack",18));
        set.add(new User("Tim",30));
        set.add(new User("Jen",25));
        set.add(new User("LI",36));
        set.add(new User("Ml",29));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
