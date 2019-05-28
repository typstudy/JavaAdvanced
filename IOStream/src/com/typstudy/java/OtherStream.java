package com.typstudy.java;

import org.junit.Test;

import java.io.*;

/**
 * @author typ
 * @date 2019/5/25 17:17
 * @Description: com.typstudy.java
 * 其他流的使用
 * 1.标准的输入、输出流
 * 2.打印流
 * 3.数据流
 */
public class OtherStream {
    /**
     1.标准的输入、输出流
     1.1
     System.in:标准的输入流，默认从键盘输入
     System.out:标准的输出流，默认从控制台输出
     1.2
     System类的setIn(InputStream is) / setOut(PrintStream ps)方式重新指定输入和输出的流。

     1.3练习：
     从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，
     直至当输入“e”或者“exit”时，退出程序。

     方法一：使用Scanner实现，调用next()返回一个字符串
     方法二：使用System.in实现。System.in  --->  转换流 ---> BufferedReader的readLine()

     */
    public static void main(String[] args) {
        System.out.println("请输入信息(输入e或exit退出)：");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String str=null;
            while ((str=reader.readLine())!=null){
                if ("e".equalsIgnoreCase(str)||"exit".equalsIgnoreCase(str)){
                    System.out.println("程序安全退出");
                    break;
                }
                String upperCase = str.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    /**
     2. 打印流：PrintStream 和PrintWriter
     2.1 提供了一系列重载的print() 和 println()
     2.2 练习：

     */
    @Test
    public void test1(){
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream("date.txt");
            ps = new PrintStream(fos, true);
            if (ps!=null){
                System.setOut(ps);
            }
            for (int i = 0; i < 255; i++) {
                System.out.print((char) i);
                if(i%50==0){
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ps!=null){
                ps.close();
            }
        }
    }
    /**
     3. 数据流
     3.1 DataInputStream 和 DataOutputStream
     3.2 作用：用于读取或写出基本数据类型的变量或字符串

     练习：将内存中的字符串、基本数据类型的变量写出到文件中。

     注意：处理异常的话，仍然应该使用try-catch-finally.
     */
    @Test
    public void test3() {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(
                    "dataTest.dat"));
            dos.writeUTF("中国");
            dos.writeInt(30);
            dos.writeBoolean(true);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos!=null){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test4(){
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream(
                    "dataTest.dat"));
            String readUTF = dis.readUTF();
            int readInt = dis.readInt();
            boolean readBoolean = dis.readBoolean();
            System.out.println(readUTF);
            System.out.println(readInt);
            System.out.println(readBoolean);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dis!=null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
