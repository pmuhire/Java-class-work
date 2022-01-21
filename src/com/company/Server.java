package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
     while (true){
         try {
             ServerSocket serverSocket =new ServerSocket(8000);
             serverSocket.setSoTimeout(100000);
             Socket server=serverSocket.accept();
             InputStream clientRequest=server.getInputStream();
             DataInputStream responseData=new  DataInputStream(clientRequest);
             System.out.println("The client sent : "+responseData.readUTF());
             OutputStream serverResponse=server.getOutputStream();
             DataOutputStream response=new DataOutputStream(serverResponse);
             response.writeUTF("your response released");
         }catch (Exception e){
             e.printStackTrace();
         }
     }
    }
}
