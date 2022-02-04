package com.company.Url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {
    public static void main(String[] args) throws IOException {
        try {
            URL url=new URL("https://twitter.com/home");
            URLConnection conn=url.openConnection();
            BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line=null;
            while ((line=reader.readLine())!=null){
                System.out.println(line);
            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
