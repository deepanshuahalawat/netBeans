/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class ShowEsp32Image extends HttpServlet {

    MyServer ms;
    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        
    }

    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        //response.setContentType("image/jpeg");  
        response.setContentType("multipart/x-mixed-replace;boundary=123456789000000000000987654321");
        ServletOutputStream out;
        out = response.getOutputStream();
        MyServer ms = (MyServer)this.getServletConfig().getServletContext().getAttribute("myServer");
        while (ms != null) {
            BufferedInputStream bin = new BufferedInputStream(ms.getStream());
            BufferedOutputStream bout = new BufferedOutputStream(out);
            int ch = 0;
            while ((ch = bin.read()) != -1) {
                bout.write(ch);
                System.out.print((char)ch+" "+ch);
            }
        }
        //bin.close();
        //fin.close();
        //bout.close();
        out.close();
    }
    /*@Override
    public void service(HttpServletRequest request, HttpServletResponse response)throws IOException {
        PrintWriter pw;
        System.out.println("Called Post function");
        StringBuilder sb = new StringBuilder(1000);
        try{
            BufferedInputStream bin = new BufferedInputStream(request.getInputStream());
            pw = response.getWriter();
            int ch = 0;
            while ((ch = bin.read()) != -1) {
                  System.out.print((char)ch+" "+ch);
                //sb.append((char)ch);
                //if((char)ch == '\n'){
                //    System.out.println(sb);
                //    sb = new StringBuilder(1000);
                //}
            }
            pw.println("Server ok");
        }catch(Exception e){
            System.out.println("Error at server:"+e);
        }
    }
    */
    InputStream directImageSave() {
        try {
            //InputStream in = new URL("http://192.168.43.225/capture").openStream();
            //Files.copy(in, Paths.get("D:/image.jpg"));
            URL url = new URL("http://192.168.43.225/capture");
            InputStream in = new BufferedInputStream(url.openStream());
            return in;
        } catch (Exception e) {

        }
        return null;
    }
}
