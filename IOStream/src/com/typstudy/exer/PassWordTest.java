package com.typstudy.exer;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author typ
 * @date 2019/5/24 21:45
 * @Description: com.typstudy.exer
 */
public class PassWordTest {
    /**
     * 图片加密
     */
    @Test
    public void test1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("01.jpg");
            fos = new FileOutputStream("01pass.jpg");
            int len;
            byte[] bytes = new byte[20];
            while ((len = fis.read(bytes)) != -1) {
                for (int i = 0; i < len; i++) {
                    bytes[i] = (byte) (bytes[i] ^ 5);
                }
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 图片解密
     */
    @Test
    public void test2() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("01pass.jpg");
            fos = new FileOutputStream("03.jpg");
            int len;
            byte[] bytes = new byte[20];
            while ((len = fis.read(bytes)) != -1) {
                for (int i = 0; i < len; i++) {
                    bytes[i] = (byte) (bytes[i] ^ 5);
                }
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
/**
 * 练习3:获取文本上字符出现的次数,把数据写入文件
 *
 * 思路：
 * 1.遍历文本每一个字符
 * 2.字符出现的次数存在Map中
 *
 * Map<Character,Integer> map = new HashMap<Character,Integer>();
 * map.put('a',18);
 * map.put('你',2);
 *
 * 3.把map中的数据写入文件
 * */
    @Test
    public void test3() {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader("dbcp.txt"));
            writer = new BufferedWriter(new FileWriter("wordCount.txt"));
            HashMap<Character, Integer> map = new HashMap<>(1);
            int len=0;
            while ((len=reader.read())!=-1){
                char c=(char)len;
                if(map.get(c)==null){
                    map.put(c,1);
                }else{
                    map.put(c,map.get(c)+1);
                }
            }
            Set<Map.Entry<Character, Integer>> set = map.entrySet();
            for (Map.Entry<Character, Integer> entry : set) {
                switch (entry.getKey()){
                    case ' ':
                        writer.write("空格=" + entry.getValue());
                        break;
                    //\t表示tab 键字符
                    case '\t':
                        writer.write("tab键=" + entry.getValue());
                        break;
                    case '\r':
                        writer.write("回车=" + entry.getValue());
                        break;
                    case '\n':
                        writer.write("换行=" + entry.getValue());
                        break;
                    default:
                        writer.write(entry.getKey() + "=" + entry.getValue());
                        break;
                }
                writer.newLine();
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
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
