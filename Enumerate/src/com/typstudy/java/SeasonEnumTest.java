package com.typstudy.java;

/**
 * @author typ
 * @date 2019/5/21 20:17
 * @Description: com.typstudy.java
 *
 *  使用enum关键字定义枚举类
 *  说明：定义的枚举类默认继承于java.lang.Enum类
 */
public class SeasonEnumTest {
    public static void main(String[] args) {
        Seasons summer=Seasons.SUMMER;
        System.out.println(summer);
        System.out.println("---------------------------------------------");
        Seasons[] seasons = Seasons.values();
        for (Seasons season : seasons) {
            System.out.println(season);
        }
        System.out.println("---------------------------------------------");
        Thread.State[] values = Thread.State.values();
        for (Thread.State value : values) {
            System.out.println(value);
        }
        System.out.println("---------------------------------------------");
        Seasons spring = Seasons.valueOf("SPRING");
        System.out.println(spring);
    }
}
enum Seasons{
    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "冰天雪地");
    //1.声明Season对象的属性:private final修饰

    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器,并给对象属性赋值

    private Seasons(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

}