package com.typstudy.java;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author typ
 * @date 2019/5/25 21:59
 * @Description: com.typstudy.java
 *
 *实现TCP的网络编程
 * 例子1：客户端发送信息给服务端，服务端将数据显示在控制台上
 */
public class TCPTest {
    /**
     * 客户端
     */
    @Test
    public void client() {
        Socket socket= null;
        OutputStream os = null;
        try {
            InetAddress host = InetAddress.getByName("169.254.44.106");
            socket = new Socket(host,8969);
            os = socket.getOutputStream();
            os.write("hello java 中国加油".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os!=null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket!=null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    /**
     *服务端
     */
    @Test
    public void server(){
        ServerSocket socket = null;
        Socket accept = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            socket = new ServerSocket(8969);
            accept = socket.accept();
            is = accept.getInputStream();
            //可能会出现乱码
            /*byte[] bytes=new byte[5];
            int len;
            while ((len=is.read(bytes))!=-1){
                String str=new String(bytes,0,len);
                System.out.print(str);
            }*/
            //读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] bytes=new byte[5];
            int len;
            while ((len=is.read(bytes))!=-1){
                baos.write(bytes,0,len);
            }
            System.out.println(baos.toString());
            System.out.println("收到了来自于：" + accept.getInetAddress().getHostAddress() + "的数据");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos!=null) {
                try {
                    baos.close();
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
            if (accept!=null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket!=null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
