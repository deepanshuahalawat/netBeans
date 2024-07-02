/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class GetHWVariable extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        PrintWriter pw=null;
        try{
            pw= response.getWriter();
        String para = request.getParameter("name");
        if(para != null)
        switch(para){
            case "test":
                pw.println("2");
                break;
            case "abort":
                pw.println("0");
                break;
        }
        }catch(Exception e){
            pw.print("error");
            System.out.println("Error "+e);
        }
    }

}
