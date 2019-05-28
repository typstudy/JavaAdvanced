package com.typstudy.java;

import org.junit.Test;

import java.io.*;

/**
 * @author typ
 * @date 2019/5/23 22:33
 * @Description: com.typstudy.java
 * 字符输出输入流
 */
@SuppressWarnings("all")
public class ReaderWriterTest {
    @Test
    public void testReader() {
        FileReader reader = null;
        try {
            File file = new File("hello.txt");
            reader = new FileReader(file);
            char[] c=new char[5];
            int date;
            /*while ((date=reader.read())!=-1){
                System.out.print((char) date);
            }*/
            while ((date=reader.read(c))!=-1){
                String s = new String(c, 0, date);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    @Test
    public void testWriter(){
        FileWriter writer = null;
        try {
            File file=new File("hello1.txt");
            writer = new FileWriter(file);
            writer.write("hello world how are you\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void testReaderWriter() {
        FileWriter writer = null;
        FileReader reader = null;
        try {
            reader = new FileReader("hello.txt");
            writer = new FileWriter("hello1.txt",true);
            int len;
            char[] chars=new char[5];
            while ((len=reader.read(chars))!=-1){
                writer.write(chars,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
