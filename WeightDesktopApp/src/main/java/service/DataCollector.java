/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.tf.frame.MainFrame;
import com.tf.util.WeightConstants;
import java.awt.Color;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;
import javax.swing.JLabel;

/**
 *
 * @author HP
 */
public class DataCollector implements Runnable{
    MainFrame mainFrame = null;
    private Socket server = null;
    private DatagramSocket udpSocket ;
    private DatagramPacket udpPacket;
    private PrintWriter writer = null;
    private Scanner scanner = null;
    public boolean keepListening = true;
    private Long timeStamp=0L;
    private byte[] buffer= new byte[200];
    String connectionString = WeightConstants.TCP_START+WeightConstants.CLIENT_TYPE+WeightConstants.MOBILE_CLIENT;
    float weight = 12.5f;
    
    public DataCollector(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }
    public void startListening(){
        try{
            Thread t= new Thread(this);
            t.start();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    @Override
    public void run(){
        try {
                showMessage("Connecting to scale...", Color.BLUE);
                InetAddress serverAddr = InetAddress.getByName(WeightConstants.SERVER_IP);
                server = new Socket(serverAddr,80);
                udpSocket =  new DatagramSocket(1212);
                udpSocket.setSoTimeout(500);
                writer = new PrintWriter(server.getOutputStream());
                scanner = new Scanner(server.getInputStream());
                scanner.useDelimiter("\n");
                writer.write(connectionString);
                writer.flush();
                showMessage("Scale connected",Color.BLUE);
                mainFrame.getConnectButton().setText("DISCONNECT");
                mainFrame.getTareButton().setVisible(true);
            while(keepListening){
                try {

                    
                    udpPacket = new DatagramPacket(buffer,buffer.length);
                    udpSocket.receive(udpPacket);
                    String data = new String(udpPacket.getData(), 0, udpPacket.getLength());
                    processData(data);
                    if(udpPacket.getLength() > 2){
                        Long timeDiff = System.currentTimeMillis() - timeStamp;
                        showTime(String.valueOf(timeDiff));
                        timeStamp = System.currentTimeMillis();
                    }
                }catch (SocketTimeoutException exp){
                    //System.out.println("Udp error");
                    //System.out.println(exp);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            server.close();
            udpSocket.close();
            showMessage("Disconnected from scale",Color.BLUE);
            System.out.println("Closing server connections");
        } catch (Exception e) {
            e.printStackTrace();
            showMessage("Error in connecting to scale",Color.RED);
            mainFrame.getConnectButton().setText("CONNECT");
        }
        
    }
    
    private void showMessage(String message,Color color){
        JLabel messageLabel = mainFrame.getMessageLable();
        messageLabel.setText(message);
        messageLabel.setForeground(color);
    }
    private void showWeight(String weight){
       JLabel weightLabel = mainFrame.getWeightLable();
       weightLabel.setText(weight);
    }
    private void showTime(String time){
       JLabel timeLabel = mainFrame.getTimeLable();
       timeLabel.setText(time+" ms");
    }
    public void tare(){
        new Thread(){
            @Override
            public void run() {
                writer.write(WeightConstants.TCP_START+WeightConstants.TCP_TARE);
                writer.flush();
                showMessage("Taring",Color.BLACK);
            }
        }.start();
    }
    private void processData(String data){
        if(data!=null && data.length() > 2){
            if(data.charAt(0) == WeightConstants.TCP_START.charAt(0)){
            char command = data.charAt(1);
            switch (command){
                case 'w':
                    String weightStr = data.substring(2);
                    showWeight(weightStr);
                    break;
            }
        }
        }
    }
}
