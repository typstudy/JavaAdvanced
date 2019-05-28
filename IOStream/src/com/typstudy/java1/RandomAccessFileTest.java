package com.typstudy.java1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author typ
 * @date 2019/5/25 21:14
 * @Description: com.typstudy.java1
 *
 * RandomAccessFile的使用
 * 1.RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 *
 * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建。
 *   如果写出到的文件存在，则会对原有文件内容进行覆盖。（默认情况下，从头覆盖）
 *
 * 4. 可以通过相关的操作，实现RandomAccessFile“插入”数据的效果
 */
public class RandomAccessFileTest {
    @Test
    public void test1() {

        java.io.RandomAccessFile raf1 = null;
        java.io.RandomAccessFile raf2 = null;
        try {
            //1.
            raf1 = new java.io.RandomAccessFile(new File("01.jpg"),"r");
            raf2 = new java.io.RandomAccessFile(new File("011.jpg"),"rw");
            //2.
            byte[] buffer = new byte[1024];
            int len;
            while((len = raf1.read(buffer)) != -1){
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.
            if(raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(raf2 != null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    @Test
    public void test() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("hello.txt","rw");
            raf.seek(5);
            raf.write("huaWei".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf!=null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
