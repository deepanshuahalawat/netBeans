
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.io.*;  
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HP
 */
public class HttpGetForEspCam {

    HttpGetForEspCam ht;
     File photo;
     public static BufferedReader in=null;
    public HttpGetForEspCam() {
        ht = this;
        try {
            socketSend();
            //directImageSave();
            //getMethod();
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }

    public static void main(String args[]) {
        new HttpGetForEspCam();
    }

    void socketSend() {
        try {
            Socket s = new Socket("192.168.43.225", 81);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            InputStream is = s.getInputStream();
            
            dout.writeBytes("GET /stream HTTP/1.1\r\n" +
            "Host: 192.168.43.225:81\r\n" +
            "User-Agent: insomnia/2021.2.2\r\n" +
            "Accept: */*\r\n\r\n");
            
            System.out.print("GET /stream HTTP/1.1\r\n" +
            "Host: 192.168.43.225:81\r\n" +
            "User-Agent: insomnia/2021.2.2\r\n" +
            "Accept: */*\r\n\r\n");
            dout.flush();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader in = new BufferedReader(isr);
            String inputLine;
            //photo=new File( "photo.jpg");
            //FileOutputStream fos=new FileOutputStream(photo.getPath());
            //long timeOut = System.currentTimeMillis();
            //int length=0;
            while ((inputLine = in.readLine()) != null){ 
                System.out.println(inputLine);
                
            }
            
         
        } catch (Exception e) {
            System.out.println(e);
        }
    
    }
void  getMethod() throws Exception {
        URL yahoo = new URL("http://192.168.43.225/capture");
        URLConnection yc = yahoo.openConnection();
        System.out.println("Content length:"+yc.getHeaderField("Content-Length"));
        InputStream is = new BufferedInputStream(yc.getInputStream());
        
        //BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        OutputStream out = new BufferedOutputStream(new FileOutputStream("D:/image2.jpg"));
        int i=0;
        while ((i = is.read()) != -1){ 
            out.write(i);
        }
        out.close();
        is.close();
    }
    void directImageSave(){
        try{
            //InputStream in = new URL("http://192.168.43.225/capture").openStream();
            //Files.copy(in, Paths.get("D:/image.jpg"));
            URL url = new URL("http://192.168.43.225/capture");
            InputStream in = new BufferedInputStream(url.openStream());
            OutputStream out = new BufferedOutputStream(new FileOutputStream("D:/image.jpg"));
            for ( int i; (i = in.read()) != -1; ) {
               
                out.write(i);
            }
            in.close();
            out.close();
        }catch(Exception e){
            
        }
    }
}
