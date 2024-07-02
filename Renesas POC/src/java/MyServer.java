/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
import java.io.*;
import java.net.*;

public class MyServer {
    public static Socket s;
    public static ServerSocket ss;
    
    public static void main(String[] args) {
        startServer();
    }
    public static void startServer(){
        try{
            ss = new ServerSocket(6666);
            System.out.println("Waiting for connection !");
            s = ss.accept();//establishes connection
            System.out.println("Client connected");
        }catch(Exception e){
            System.out.println("Server start error:"+e);
        }
    }
    public static InputStream getStream(){
        try {
            
            BufferedInputStream bin = new BufferedInputStream(s.getInputStream());
            return bin;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
