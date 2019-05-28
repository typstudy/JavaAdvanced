package com.typstudy.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author typ
 * @date 2019/5/20 11:33
 * @Description: com.typstudy.java
 */
public class DateTimeTest {
    @Test
    public void test1(){
        long timeMillis = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
        //称为时间戳
        System.out.println(timeMillis);
    }
    /**
     java.util.Date类
     |---java.sql.Date类

     1.两个构造器的使用
     >构造器一：Date()：创建一个对应当前时间的Date对象
     >构造器二：创建指定毫秒数的Date对象
     2.两个方法的使用
     >toString():显示当前的年、月、日、时、分、秒
     >getTime():获取当前Date对象对应的毫秒数。（时间戳）

     3. java.sql.Date对应着数据库中的日期类型的变量
     >如何实例化
     >如何将java.util.Date对象转换为java.sql.Date对象
     */
    @Test
    public void test2(){
        Date date = new Date();
        //Mon May 20 11:37:22 CST 2019
        System.out.println(date);
        //1558323442502
        System.out.println(date.getTime());
        Date date1 = new Date(1558323442502L);
        //Mon May 20 11:37:22 CST 2019
        System.out.println(date1.toString());
        java.sql.Date date2=new java.sql.Date(12345488678945L);
        System.out.println(date2);
        Date date3=new java.sql.Date(1556894566723L);
        java.sql.Date date4= (java.sql.Date) date3;
        System.out.println(date4);
        Date date5 = new Date();
        java.sql.Date date6=new java.sql.Date(date5.getTime());
        System.out.println(date6);
    }
    /**
     SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

     1.两个操作：
     1.1 格式化：日期 --->字符串
     1.2 解析：格式化的逆过程，字符串 ---> 日期

     2.SimpleDateFormat的实例化

     */
    @Test
    public void test3(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat();
        String date1 = format.format(date);
        System.out.println(date1);
        System.out.println("-----------------------------------");
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy年MM月dd日 EEE HH:mm:ss");
        String format2 = format1.format(date);
        System.out.println(format2);
        try {
            Date parse = format1.parse("2018年6月18日 星期二 12:45:23");
            String s = parse.toString();
            System.out.println(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    /**
     Calendar日历类(抽象类）的使用
     */
    @Test
    public void test4(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
        int days = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);
        //set()
        //calendar可变性
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类---> Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);


    }
}
