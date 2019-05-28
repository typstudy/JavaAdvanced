package com.typstudy.java;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author typ
 * @date 2019/5/26 20:24
 * @Description: com.typstudy.java
 *
 * 例题3：从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。
 */
public class TCPTest3 {
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            socket = new Socket(InetAddress.getByName("169.254.44.106"), 8999);
            os = socket.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream("01.jpg"));
            byte[] bytes=new byte[1024];
            int len;
            while ((len=bis.read(bytes))!=-1){
                os.write(bytes,0,len);
            }
            socket.shutdownOutput();
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] bytes1=new byte[1024];
            int len1;
            while ((len1=is.read(bytes1))!=-1){
                baos.write(bytes1,0,len1);
            }
            System.out.println(baos.toString());
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
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void server(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedOutputStream bos = null;
        try {
            serverSocket = new ServerSocket(8999);
            socket = serverSocket.accept();
            is = socket.getInputStream();
            bos = new BufferedOutputStream(new FileOutputStream("012.jpg"));
            byte[] bytes=new byte[1024];
            int len;
            while ((len=is.read(bytes))!=-1){
                bos.write(bytes,0,len);
            }
            System.out.println("传输完成");
            os = socket.getOutputStream();
            os.write("已经收到".getBytes());
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
