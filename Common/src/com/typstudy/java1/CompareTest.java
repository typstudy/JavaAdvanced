package com.typstudy.java1;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author typ
 * @date 2019/5/21 17:27
 * @Description: com.typstudy.java1
 *
 * 一、说明：Java中的对象，正常情况下，只能进行比较：==  或  != 。不能使用 > 或 < 的
 *          但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小。
 *          如何实现？使用两个接口中的任何一个：Comparable 或 Comparator
 *
 * 二、Comparable接口与Comparator的使用的对比：
 *    Comparable接口的方式一旦一定，保证Comparable接口实现类的对象在任何位置都可以比较大小。
 *    Comparator接口属于临时性的比较。
 */
public class CompareTest {
    /**
     Comparable接口的使用举例：  自然排序
     1.像String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对象大小的方式。
     2.像String、包装类重写compareTo()方法以后，进行了从小到大的排列
     3. 重写compareTo(obj)的规则：
     如果当前对象this大于形参对象obj，则返回正整数，
     如果当前对象this小于形参对象obj，则返回负整数，
     如果当前对象this等于形参对象obj，则返回零。
     4. 对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)方法。
     在compareTo(obj)方法中指明如何排序
     */
    @Test
    public void test1(){
        Goods[] goods = new Goods[5 ];
        goods[0]=new Goods("hb",12.0);
        goods[1]=new Goods("h",52.5);
        goods[2]=new Goods("a",22.5);
        goods[3]=new Goods("hello",82.5);
        goods[4]=new Goods("he",82.5);
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));

    }
    @Test
    public void test2(){
        Goods[] goods = new Goods[5 ];
        goods[0]=new Goods("hb",12.0);
        goods[1]=new Goods("h",52.5);
        goods[2]=new Goods("a",22.5);
        goods[3]=new Goods("hello",82.5);
        goods[4]=new Goods("he",82.5);
        Arrays.sort(goods, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                if(o1 instanceof Goods&& o2 instanceof Goods) {
                    Goods goods1 = (Goods) o1;
                    Goods goods2 = (Goods) o2;
                    if (goods1.getName().equals(goods2.getName())) {
                        return -Double.compare(goods1.getPrice(),
                                goods2.getPrice());
                    }else{
                        return goods1.getName().compareTo(goods2.getName());
                    }
                }
                throw new RuntimeException("输入的数据类型不一致！");
            }
        });
        System.out.println(Arrays.toString(goods));
    }
}
