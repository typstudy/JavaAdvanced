package com.typstudy.java;

import org.junit.Test;

import java.io.*;

/**
 * @author typ
 * @date 2019/5/24 22:23
 * @Description: com.typstudy.java
 * <p>
 * 处理流之二：转换流的使用
 * 1.转换流：属于字符流
 * InputStreamReader：将一个字节的输入流转换为字符的输入流
 * OutputStreamWriter：将一个字符的输出流转换为字节的输出流
 * <p>
 * 2.作用：提供字节流与字符流之间的转换
 * <p>
 * 3. 解码：字节、字节数组  --->字符数组、字符串
 * 编码：字符数组、字符串 ---> 字节、字节数组
 * <p>
 * <p>
 * 4.字符集
 * ASCII：美国标准信息交换码。
 * 用一个字节的7位可以表示。
 * ISO8859-1：拉丁码表。欧洲码表
 * 用一个字节的8位表示。
 * GB2312：中国的中文编码表。最多两个字节编码所有字符
 * GBK：中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码
 * Unicode：国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的字符码。所有的文字都用两个字节来表示。
 * UTF-8：变长的编码方式，可用1-4个字节来表示一个字符。
 */
public class InputOutputStreamReaderWriter {
    @Test
    public void test1() {
        InputStreamReader isr = null;
        try {
            FileInputStream fis = new FileInputStream("dbcp.txt");
            isr = new InputStreamReader(fis, "utf-8");
            int len;
            char[] chars = new char[20];
            while ((len = isr.read(chars)) != -1) {
                String str = new String(chars, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            isr = new InputStreamReader(new FileInputStream("dbcp.txt"));
            osw = new OutputStreamWriter(new FileOutputStream("dbcp_gbk.txt")
                    ,"gbk");
            int len;
            char[] chars = new char[20];
            while ((len = isr.read(chars)) != -1) {
                osw.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
