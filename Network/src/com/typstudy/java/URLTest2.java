package com.typstudy.java;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author typ
 * @date 2019/5/27 17:19
 * @Description: com.typstudy.java
 */
public class URLTest2 {
   @Test
    public void test(){
       HttpURLConnection urlConnection = null;
       InputStream is = null;
       BufferedOutputStream bos = null;
       try {
           URL url = new URL("https://consumer.huawei.com/content/dam/huawei-cbg-site/greate-china/cn/mkt/pdp/phones/mate-x/img/2x/kv-img/Huawei-Mate-X10.jpg");
           urlConnection = (HttpURLConnection) url.openConnection();
           urlConnection.connect();
           is = urlConnection.getInputStream();
           bos = new BufferedOutputStream(new FileOutputStream("Mate-X.jpg"));
           byte[] bytes=new byte[1024];
           int len;
           while ((len=is.read(bytes))!=-1){
               bos.write(bytes,0,len);
           }
           System.out.println("下载完成");
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           if (bos!=null) {
               try {
                   bos.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if (is!=null) {
               try {
                   is.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if (urlConnection!=null) {
               urlConnection.disconnect();
           }
       }

   }
}
