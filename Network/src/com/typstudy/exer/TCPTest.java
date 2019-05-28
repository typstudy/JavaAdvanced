package com.typstudy.exer;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author typ
 * @date 2019/5/26 20:46
 * @Description: com.typstudy.exer
 *
 * 服务端读取图片并发送给客户端，客户端保存图片到本地
 *
 */
public class TCPTest {
    @Test
    public void Client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("169.254.44.106"), 8666);
        InputStream is = socket.getInputStream();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("013.jpg"));
        byte[] bytes=new byte[1024];
        int len;
        while ((len=is.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        bos.close();
        is.close();
        socket.close();
    }
    @Test
    public void Server() throws IOException{
        ServerSocket serverSocket = new ServerSocket(8666);
        Socket socket = serverSocket.accept();
        OutputStream os = socket.getOutputStream();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("01.jpg"));
        byte[] bytes=new byte[1024];
        int len;
        while ((len=bis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        bis.close();
        os.close();
        socket.close();
        serverSocket.close();
    }
}
