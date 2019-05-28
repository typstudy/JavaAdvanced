package com.typstudy.java;

import org.junit.Test;

import java.io.*;

/**
 * @author typ
 * @date 2019/5/24 21:20
 * @Description: com.typstudy.java
 *
 * 处理流之一：缓冲流的使用
 *
 * 1.缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2.作用：提供流的读取、写入的速度
 *   提高读写速度的原因：内部提供了一个缓冲区
 *
 * 3. 处理流，就是“套接”在已有的流的基础上。
 */
@SuppressWarnings("all")
public class BufferedTest {
    /**
     * 改进复制视频
     */
    @Test
    public void test1(){
        File srcPath = new File("F:\\Java\\video\\43-旅游线路详情_分析.mp4");
        File destPath = new File("F:\\Java\\video\\43-旅游线路详情_分析2.mp4");
        long start = System.currentTimeMillis();
        copyFile(srcPath,destPath);
        long end = System.currentTimeMillis();
        System.out.println("复制耗费时间："+(end-start));
    }
    public void copyFile(File srcPath, File destPath){
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        try {
            bis = new BufferedInputStream(new FileInputStream(srcPath));
            bos = new BufferedOutputStream( new FileOutputStream(destPath));
            int len;
            byte[] bytes=new byte[1024];
            while ((len=bis.read(bytes))!=-1){
                bos.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test2(){
        BufferedWriter writer = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("dbcp.txt"));
            writer = new BufferedWriter(new FileWriter("dbcp1.txt"));
            //方式1
            /*int len;
            char[] chars=new char[1024];
            while ((len=reader.read(chars))!=-1){
                writer.write(chars,0,len);
            }*/
            //方式二
            String str;
            while ((str=reader.readLine())!=null){
                writer.write(str);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
