package com.typstudy.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * @author typ
 * @date 2019/5/21 11:32
 * @Description: com.typstudy.java
 *
 * jdk 8中日期时间API的测试
 */
public class Jdk8DateTimeTest {
    /**
     LocalDate、LocalTime、LocalDateTime 的使用
     说明：
     1.LocalDateTime相较于LocalDate、LocalTime，使用频率要高
     2.类似于Calendar
     */
    @Test
    public void test1(){
        LocalDate localDate=LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        LocalDateTime dateTime = LocalDateTime.of(2020, 6, 8, 11, 25, 26);
        System.out.println(dateTime);

        System.out.println("------------------------------------------------------");
        System.out.println(localDateTime);
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());
        System.out.println("------------------------------------------------------");
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(8);
        System.out.println(localDateTime1);
        System.out.println(localDateTime);
    }
    /**
     Instant的使用
     类似于 java.util.Date类

     */
    @Test
    public void test2(){
        Instant instant=Instant.now();
        System.out.println(instant);
        Instant instant1 = Instant.ofEpochMilli(155897564132L);
        System.out.println(instant1);
        long milli = instant.toEpochMilli();
        System.out.println(milli);
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
    }
    /**
   DateTimeFormatter:格式化或解析日期、时间
   类似于SimpleDateFormat

    */
    @Test
    public void test3(){
        DateTimeFormatter formatter= DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime time = LocalDateTime.now();
        String format = formatter.format(time);
        System.out.println(time);
        System.out.println(format);
        TemporalAccessor parse = formatter.parse("2019-05-21T14:30:32.015");
        System.out.println(parse);
        System.out.println("-----------------------------------------------");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

        String format1 = dateTimeFormatter.format(time);
        System.out.println(format1);
        TemporalAccessor parse1 = dateTimeFormatter.parse("2019-05-21 02:36:13");
        System.out.println(parse1);
    }
}
