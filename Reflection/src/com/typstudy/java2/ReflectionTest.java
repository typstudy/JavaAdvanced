package com.typstudy.java2;

import com.typstudy.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author typ
 * @date 2019/5/27 21:31
 * @Description: com.typstudy.java2
 */
public class ReflectionTest {
    @Test
    public void test1(){
        Class<Person> clazz = Person.class;
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("anInterface = " + anInterface);
        }
    }
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;
        //获取属性结构
        //getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }
        System.out.println("-------------------------------------");
        //getDeclaredFields():获取当前运行时类中声明的所有属性。（不包含父类中声明的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField = " + declaredField);
        }
    }
    /**
     * 权限修饰符  数据类型 变量名
     */
    @Test
    public void test3(){
        Class<Person> personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //1.权限修饰符
            int modifiers = declaredField.getModifiers();
            System.out.println("modifiers = " + modifiers);
            //2.数据类型
            Class<?> type = declaredField.getType();
            System.out.println("type = " + type);
            //3.变量名
            String name = declaredField.getName();
            System.out.println("name = " + name);
        }
    }
    @Test
    public void test4(){
        Class<Person> personClass = Person.class;
        //getMethods():获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }
        System.out.println(
                "----------------------------------------------------------");
        //getDeclaredMethods():获取当前运行时类中声明的所有方法。（不包含父类中声明的方法）
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod = " + declaredMethod);
        }
    }
    /**
     @Xxxx
     权限修饰符  返回值类型  方法名(参数类型1 形参名1,...) throws XxxException{}
     */
    @Test
    public void test5(){
        Class<Person> clazz = Person.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            //1.获取方法声明的注解
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
            //2.权限修饰符
            int modifiers = method.getModifiers();
            System.out.print(Modifier.toString(modifiers)+ "\t");
            //3.返回值类型
            String name = method.getReturnType().getName();
            System.out.print(name+ "\t");
            //4.方法名
            String methodName = method.getName();
            System.out.print(methodName);
            System.out.print("(");
            //5.形参列表
            Class<?>[] types = method.getParameterTypes();
            if (!(types==null&types.length==0)){
                for (int i = 0; i < types.length; i++) {
                    if(i==types.length-1){
                        System.out.print(types[i].getName()+" args_"+i);
                        break;
                    }
                    System.out.print(types[i].getName()+" args_"+i);
                }
            }
            System.out.print(")");
            //6.抛出的异常
            Class[] exceptionTypes = method.getExceptionTypes();
            if(exceptionTypes.length > 0){
                System.out.print("throws ");
                for(int i = 0;i < exceptionTypes.length;i++){
                    if(i == exceptionTypes.length - 1){
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }

                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }


            System.out.println();
        }

    }
}
