/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class SaveTestResult extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("Get response from server");
    }
    public void init() throws ServletException {
        try{
            String filename = getServletContext().getInitParameter("testResultFileName");
            File file = new File(filename);
            file.createNewFile();
        }catch(Exception e){
            
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        PrintWriter pw = response.getWriter();
        String filename = getServletContext().getInitParameter("testResultFileName");
        FileWriter myWriter = new FileWriter(filename);
        BufferedReader br =request.getReader();
        String line=null;
        while((line = br.readLine()) != null){
            System.out.println(line);
            pw.println(line);
            myWriter.write(line);
            myWriter.append("\n");
        }
        myWriter.close();
        //File f= new File(filename);
        //pw.println("File Path: "+f.getAbsolutePath());
        //pw.println("Filename"+filename);
    }
    
}
