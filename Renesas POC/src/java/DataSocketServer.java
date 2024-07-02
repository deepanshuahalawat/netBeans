
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class DataSocketServer {

    ServerSocket server;
    Socket socket = null;
    int port = 1567;
    public DataSocketServer() {
        startServer();
    }
    
    public static void main(String str[]){
        new DataSocketServer();
    }
    public void startServer(){
        try{
            while(true){
                server = new ServerSocket(port);
                System.out.println("Server started");
                System.out.println("waiting for client");
                socket = server.accept();
                System.out.println("Client connected");
                new EchoThread(socket).start();
            }
        }catch(Exception e){
            System.out.println("Error:"+e);
        }
    }
}
class EchoThread extends Thread {
    protected Socket socket;

    public EchoThread(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {
        InputStream inp = null;
        BufferedReader brinp = null;
        DataOutputStream out = null;
        try {
            inp = socket.getInputStream();
            brinp = new BufferedReader(new InputStreamReader(inp));
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            return;
        }
        String line;
        while (true) {
            try {
                line = brinp.readLine();
                if ((line == null) || line.equalsIgnoreCase("QUIT")) {
                    socket.close();
                    return;
                } else {
                    out.writeBytes(line + "\n\r");
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
