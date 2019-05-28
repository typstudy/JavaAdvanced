package com.typstudy.exer;

import org.junit.Test;

import java.io.File;

/**
 * @author typ
 * @date 2019/5/24 16:34
 * @Description: com.typstudy.exer
 *
 * 判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
 */
public class FindJpgTest {
    @Test
    public void test1(){
        File file = new File("E:\\downloads\\images");
        String[] list = file.list();
        for (String files : list) {
            if(files.endsWith(".jpg")){
                System.out.println(files);
            }

        }
    }
    @Test
    public void test2(){
        File file = new File("E:\\downloads\\images");
        File[] listFiles = file.listFiles();
        for (File files : listFiles) {
            if(files.getName().endsWith(".jpg")){
                System.out.println(files);
            }

        }
    }
}
