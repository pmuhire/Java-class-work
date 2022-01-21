package com.company;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args)throws IOException {
        try {
            Socket socket = new Socket("Localhost", 8000);
            OutputStream clientRequest = socket.getOutputStream();
            DataOutputStream request = new DataOutputStream(clientRequest);
            request.writeUTF("Hello from client");
            InputStream serverResponse = socket.getInputStream();
            DataInputStream response = new DataInputStream(serverResponse);
            System.out.println(response.readUTF());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
