package com.company.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;


public class UDPClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds=new DatagramSocket();
        String requestString="Client request";
        byte requestBytes[]=requestString.getBytes();
        InetAddress ip= InetAddress.getLocalHost();
        DatagramPacket dp=new DatagramPacket(requestBytes,requestBytes.length,ip,7000);
        ds.send(dp);
        byte[] buffer= new byte[1024];
        DatagramPacket response=new DatagramPacket(buffer,buffer.length);
        ds.receive(response);
        ds.close();
        String serverResponse=new String(response.getData());
        System.out.println("Server response: "+serverResponse);

    }
}
