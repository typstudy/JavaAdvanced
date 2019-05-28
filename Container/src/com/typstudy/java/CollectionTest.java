package com.typstudy.java;

import org.junit.Test;

import java.util.*;

/**
 * @author typ
 * @date 2019/5/21 21:03
 * @Description: PACKAGE_NAME
 * 一、集合框架的概述
 *
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
 *  说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt,.jpg,.avi，数据库中）
 *
 * 2.1 数组在存储多个数据方面的特点：
 *      > 一旦初始化以后，其长度就确定了。
 *      > 数组一旦定义好，其元素的类型也就确定了。我们也就只能操作指定类型的数据了。
 *       比如：String[] arr;int[] arr1;Object[] arr2;
 * 2.2 数组在存储多个数据方面的缺点：
 *      > 一旦初始化以后，其长度就不可修改。
 *      > 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高。
 *      > 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
 *      > 数组存储数据的特点：有序、可重复。对于无序、不可重复的需求，不能满足。
 *
 * 二、集合框架
 *      |----Collection接口：单列集合，用来存储一个一个的对象
 *          |----List接口：存储有序的、可重复的数据。  -->“动态”数组
 *              |----ArrayList、LinkedList、Vector
 *
 *          |----Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
 *              |----HashSet、LinkedHashSet、TreeSet
 *
 *      |----Map接口：双列集合，用来存储一对(key - value)一对的数据   -->高中函数：y = f(x)
 *              |----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 *
 * 三、Collection接口中的方法的使用
 */
@SuppressWarnings("all")
public class CollectionTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add("hello");
        coll.add(2);
        coll.add(new Date());
        System.out.println(coll.size());
        System.out.println(coll);

        Collection coll1 = new ArrayList();
        coll1.add("abc");
        coll1.add(1.2);
        coll1.addAll(coll);
        System.out.println(coll1.size());
        System.out.println(coll1);
        coll.clear();
        System.out.println(coll);
        System.out.println(coll.isEmpty());
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add("hello");
        coll.add(2);
        coll.add(new Date());
        coll.add(new Person("li4", 20));
        coll.add(true);
        System.out.println(coll.contains(true));
        System.out.println(coll.contains(new Person("li4", 20)));
        Collection coll1 = Arrays.asList("hello", true);
        System.out.println(coll.containsAll(coll1));
        System.out.println(coll);
        System.out.println(coll.remove(2));
        System.out.println(coll);
        System.out.println(coll.removeAll(coll1));
        System.out.println(coll);
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //5.retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前集合
//        Collection coll1 = Arrays.asList(123,456,789);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        /**
         * 6.equals(Object obj):要想返回true，需要当前集合和形参集合的元素都相同。
         * */
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new Person("Jerry", 20));
        coll1.add(new String("Tom"));
        coll1.add(false);

        System.out.println(coll.equals(coll1));
    }

    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);
        //hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());
        //集合 --->数组：toArray()
        Object[] array = coll.toArray();
        for (Object o : array) {
            System.out.println(o);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        //拓展：数组 --->集合:调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"abc", "hello", "java"});
        System.out.println(list);
        System.out.println(list.size());
        System.out.println("*************************************");
        List<int[]> ints = Arrays.asList(new int[]{12, 25, 56});
        System.out.println(ints);
        System.out.println(ints.size());
        List<Integer> integers = Arrays.asList(new Integer[]{12, 85, 63});
        System.out.println(integers);
        System.out.println(integers.size());
    }

    @Test
    public void test5() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);
        Iterator iterator = coll.iterator();
        /*while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
        System.out.println("-------------------------------");
        while (iterator.hasNext()) {
            Object o = iterator.next();
            if (o.equals(123)) {
                iterator.remove();
            }
            System.out.println(o);
        }
        System.out.println("**************************************");
        for (Object o : coll) {
            System.out.println(o);
        }

    }
    @Test
    public void test6() {
        String[] str = new String[5];
        for (String s : str) {
            s="hello";
            System.out.println(s);
        }
        for (int i=0;i<str.length;i++){
            System.out.println(str[i]);
        }
    }
}