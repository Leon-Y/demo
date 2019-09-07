package com.example.socket;

import com.mysql.cj.x.protobuf.MysqlxExpect;
import org.apache.catalina.Server;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @Author: Xiao
 * @Date: 2019/8/30 :8:48
 * @Description:
 */
public class SocketInput implements Runnable{
    @Override
    public void run() {
        try (ServerSocketChannel open = ServerSocketChannel.open();){
            open.bind(new InetSocketAddress(8555));
            while (true){
                open.accept();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
}
class SocketOutPut implements Runnable{
    @Override
    public void run() {
        try {
            Socket socket = new Socket("127.0.0.1", 8555);
            System.setOut(new PrintStream(new BufferedOutputStream(socket.getOutputStream())));
            new Scanner(System.in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class ServerSocketTest{
    public static void main(String[] args) {
        try (ServerSocketChannel open = ServerSocketChannel.open();){
            open.bind(new InetSocketAddress(8555));
            while (true){
                SocketChannel accept = open.accept();
                System.out.println("客户端连接");
                ByteBuffer allocate = ByteBuffer.allocate(48);
                while (accept.read(allocate)>0){
                    System.out.println(allocate.asCharBuffer());
                };
                accept.write(allocate);
                allocate.flip();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
}
class SocketTest{
    public static void main(String[] args) {

        try(SocketChannel open = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8555));) {
            while (true){
                ByteBuffer wrap = ByteBuffer.wrap("123456789".getBytes());
                while (open.write(wrap)>0){
                    wrap.flip();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}