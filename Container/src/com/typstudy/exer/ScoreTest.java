package com.typstudy.exer;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author typ
 * @date 2019/5/23 21:01
 * @Description: com.typstudy.exer
 */
public class ScoreTest {
    /**
     * 请把学生名与考试分数录入到Set中，并按分数显示前三名成绩学员的名字.怎么用Set实现?
     */
    public static void main(String[] args) {
        Comparator<Student> comparator=new Comparator<Student>() {
            //使用泛型
            @Override
            public int compare(Student o1, Student o2) {
                Integer s1=o1.getScore();
                Integer s2 = o2.getScore();
                return -s1.compareTo(s2);
            }
            //未使用泛型
           /** @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Student&& o2 instanceof Student){
                    Student s1=(Student)o1;
                    Student s2=(Student)o2;
                    return -Integer.compare(s1.getScore(),s2.getScore());
                }else {
                    throw new RuntimeException("输入类型错误");
                }
            }*/
        };
        Scanner scanner = new Scanner(System.in);
        TreeSet<Student> set = new TreeSet(comparator);
        System.out.println("请输入学生的姓名和成绩，当输入为负数时结束输入");
        for (int i=1;;i++) {
            int score=0;
            System.out.println("请输入第" + i + "位学生的姓名：");
            String name = scanner.next();
            System.out.println("请输入第" + i + "位学生的成绩：(输入负数，结束录入)");
            try {
                score=scanner.nextInt();
            } catch (Exception e) {
                System.out.println("您输入的分数有误");
            }
            if (score < 0) {
                break;
            } else {
                set.add(new Student(name, score));
            }
        }
        System.out.println("您输入的成绩生成成绩单结果：");
        System.out.println(set);
        for (Student student : set) {
            System.out.println(student.getName()+"=="+student.getScore());
        }
        System.out.println("前三名学生的姓名为：");
        int count=0;
        for (Student student : set) {
            if(count==3){
                break;
            }else{
                System.out.println(student.getName()+"=="+student.getScore());
                count++;
            }
        }
    }
}
