package com.typstudy.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author typ
 * @date 2019/5/23 22:24
 * @Description: com.typstudy.java
 * 字节输入输出流
 */
public class FileInputOutputStreamTest {
    /**
     * 中文可能出现乱码
     */
    @Test
    public void test1() {
        FileInputStream fis=null;
        try {
            File file = new File("hello.txt");
           fis = new FileInputStream(file);
            int date;
            byte[] bytes=new byte[5];
            while ((date=fis.read(bytes))!=-1){
                String s = new String(bytes, 0, date);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 复制图片
     */
    @Test
    public void test2() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("01.jpg");
            fos = new FileOutputStream("02.jpg");
            int len;
            byte[] bytes=new byte[5];
            while ((len=fis.read(bytes))!=-1){
                fos.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
           if(fis!=null){
               try {
                   fis.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }
    }

    /**
     * 封装方法，复制
     */
    @Test
    public void test3(){
        File srcPath = new File("F:\\Java\\video\\43-旅游线路详情_分析.mp4");
        File destPath = new File("F:\\Java\\video\\43-旅游线路详情_分析1.mp4");
        long start = System.currentTimeMillis();
        copyFile(srcPath,destPath);
        long end = System.currentTimeMillis();
        System.out.println("复制耗费时间："+(end-start));
    }
    public void copyFile(File srcPath, File destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcPath);
            fos = new FileOutputStream(destPath);
            int len;
            byte[] bytes=new byte[1024];
            while ((len=fis.read(bytes))!=-1){
                fos.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
