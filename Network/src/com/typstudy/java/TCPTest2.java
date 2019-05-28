package com.typstudy.java;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author typ
 * @date 2019/5/26 17:34
 * @Description: com.typstudy.java
 *
 * 例题2：客户端发送文件给服务端，服务端将文件保存在本地。
 */
public class TCPTest2 {
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        try {
            socket = new Socket(InetAddress.getByName("169.254.44.106"), 8969);
            os = socket.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream("01.jpg"));
            byte[] bytes=new byte[1024];
            int len;
            while ((len=bis.read(bytes))!=-1){
                os.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis!=null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        try {
            serverSocket = new ServerSocket(8969);
            socket = serverSocket.accept();
            is = socket.getInputStream();
            bos = new BufferedOutputStream(new FileOutputStream("011.jpg"));
            byte[] bytes=new byte[1024];
            int len;
            while ((len=is.read(bytes))!=-1){
                bos.write(bytes,0,len);
            }
            System.out.println(bytes.toString());
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
            if (socket!=null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket!=null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
