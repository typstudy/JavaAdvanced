package com.typstudy.exer;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author typ
 * @date 2019/5/26 21:01
 * @Description: com.typstudy.exer
 *
 * 客户端给服务端发送文本，服务端会将文本转成大写然后返回给客户端
 */
public class TCPTest2 {
    @Test
    public void Client() {
        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        try {
            socket = new Socket(InetAddress.getByName("169.254.44.106"), 9666);
            os = socket.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream("hello.txt"));
            byte[] bytes=new byte[1024];
            int len;
            while ((len=bis.read(bytes))!=-1){
                os.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void Server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        try {
            serverSocket = new ServerSocket(9666);
            socket = serverSocket.accept();
            is = socket.getInputStream();
            bos = new BufferedOutputStream(new FileOutputStream("hello1.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(bos));
            String str=null;
            while ((str=br.readLine())!=null){
                str= str.toUpperCase();
                bw.write(str);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
