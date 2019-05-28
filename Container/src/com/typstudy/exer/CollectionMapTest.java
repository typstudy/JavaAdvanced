package com.typstudy.exer;

import org.junit.Test;

import java.util.*;

/**
 * @author typ
 * @date 2019/5/23 20:20
 * @Description: com.typstudy.exer
 */
public class CollectionMapTest {
    /**
     *请从键盘随机输入10个整数,保存到List,并按倒序，由大到小的顺序显示出来
     */

    public static void main(String[] args) {
        Comparator comparator=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1=(Integer)o1;
                Integer i2=(Integer)o2;
                return -Integer.compare(i1,i2);
            }
        };
        System.out.println("请输入整数:");
        Scanner scanner = new Scanner(System.in);
        TreeSet set = new TreeSet(comparator);
        for (;set.size()<10;){
            int i = scanner.nextInt();
            set.add(i);
        }
        System.out.println(set);
    }

    @Test
    public void test(){

    }
}
