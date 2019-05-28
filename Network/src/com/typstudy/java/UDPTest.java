package com.typstudy.java;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author typ
 * @date 2019/5/26 22:18
 * @Description: com.typstudy.java
 * UDP编程
 */
public class UDPTest {
    @Test
    public void sender() {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
            String str="hello world";
            byte[] bytes = str.getBytes();
            InetAddress host = InetAddress.getLocalHost();
            DatagramPacket dp = new DatagramPacket(bytes, 0, bytes.length,host,
                    9666);
            ds.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ds!=null) {
                ds.close();
            }
        }

    }
    @Test
    public void receiver()throws IOException{
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(9666);
            byte[] bytes=new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
            ds.receive(dp);
            String str=new String(dp.getData(),0,dp.getLength());
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ds!=null) {
                ds.close();
            }
        }
    }
}
