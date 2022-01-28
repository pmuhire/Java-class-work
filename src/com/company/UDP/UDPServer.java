package com.company.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        while(true){
            try{
                DatagramSocket serverSocket=new DatagramSocket(7000);
                byte[] b=new byte[1024];
                DatagramPacket request=new DatagramPacket(b,b.length);
                serverSocket.receive(request);
                String requestString=new String(request.getData());
                System.out.println("Request from string: "+requestString);
//        SENDING RESPONSE
                byte[] buffer=new byte[512];
                InetAddress clientAddress=request.getAddress();
                int clientPort=request.getPort();
                String data="Message from sever";
                buffer=data.getBytes();
                DatagramPacket response=new DatagramPacket(buffer,buffer.length,clientAddress,clientPort);
                serverSocket.send(response);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
