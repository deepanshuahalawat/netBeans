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
public class StartSocketServer extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.println("Starting server...");
        System.out.println("Waiting for client");
        MyServer ms = new MyServer();
        ms.startServer();
        System.out.println("client connected");
        pw.println("Client connected !");
        this.getServletConfig().getServletContext().setAttribute("myServer", ms);
    }

    
}
