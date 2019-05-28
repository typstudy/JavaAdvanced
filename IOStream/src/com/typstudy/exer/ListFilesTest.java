package com.typstudy.exer;

import org.junit.Test;

import java.io.File;

/**
 * @author typ
 * @date 2019/5/24 16:43
 * @Description: com.typstudy.exer
 *
 * 遍历指定目录所有文件名称，包括子文件目录中的文件。
 * 	拓展1：并计算指定目录占用空间的大小
 * 	拓展2：删除指定文件目录及其下的所有文件
 */
public class ListFilesTest {
    @Test
    public void test1(){
        File file = new File("E:\\IDEA\\JavaAdvanced");
        //findFiles(file);
        //listAllSubFiles(file);
        long directorySize = getDirectorySize(file);
        System.out.println(directorySize);
    }
    public static void findFiles(File file){
        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file1.isDirectory()){
                findFiles(file1);
            }else{
                System.out.println(file1);
            }
        }
    }
    public void listAllSubFiles(File file) {
        if (file.isFile()) {
            System.out.println(file);
        } else {
            File[] all = file.listFiles();
            // 如果all[i]是文件，直接打印
            // 如果all[i]是目录，接着再获取它的下一级
            for (File f : all) {
                // 递归调用：自己调用自己就叫递归
                listAllSubFiles(f);
            }
        }
    }
    public long getDirectorySize(File file) {
        // file是文件，那么直接返回file.length()
        // file是目录，把它的下一级的所有大小加起来就是它的总大小
        long size = 0;
        if (file.isFile()) {
            size += file.length();
        } else {
            // 获取file的下一级
            File[] all = file.listFiles();
            // 累加all[i]的大小
            for (File f : all) {
                // f的大小;
                size += getDirectorySize(f);
            }
        }
        return size;
    }
    @Test
    public void test2(){
        File file = new File("E:\\IDEA\\JavaAdvanced");
        int count = Count(file);
        System.out.println(count);
    }
    public static int Count(File file){
        int count=0;
        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file1.isFile()){
                count++;
                System.out.println(file1.getName());
            }else{
                Count(file1);
                count++;
            }
        }
        return count;
    }
}
