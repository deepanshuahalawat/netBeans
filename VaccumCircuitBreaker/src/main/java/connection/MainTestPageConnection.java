package connection;

import com.technofarm.vcb.frame.MainTestPage;
import java.awt.Color;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.io.FileUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Raja
 */
public class MainTestPageConnection {

    MainTestPage mainTestPage;
    OutputStream os;
    InputStream in;
    int min[], max[];
    Scanner sc;

    public MainTestPageConnection(MainTestPage mainTestPage) {
        this.mainTestPage = mainTestPage;
    }

    public void start(char ch) {
        os = mainTestPage.portObj.getOutputStream();
        try {
            os.write(ch);
            receive();
        } catch (Exception e) {
            mainTestPage.jLabel47.setText("Error in sending data to contactor, Please check connection !");
            e.printStackTrace();
        }
    }

    public void receive() {
        loadMinMax();
        in = mainTestPage.portObj.getInputStream();
        sc = new Scanner(in);

        try {
            int data = in.read();
            while (data != 'S') {
                data = in.read();
            }
            //Matching for TART
            String test = "START";
            for (int i = 0; i < test.length(); i++) {
                mainTestPage.jLabel47.setText(data + "");
                if (test.charAt(i) != data) {
                    mainTestPage.jLabel47.setText("Error in syn character please check your wire and start the test again !");
                    System.out.println("Error in receiving start ");
                    return;
                }
                data = in.read();
            }
            sc.useDelimiter("Z");
            float f_val = 0;
            List<String> values = new ArrayList<>();
            List<String> tableValues = new ArrayList<>();
            long timeStamp = System.currentTimeMillis();
            for (int i = 0; i < 7;) {
                if (sc.hasNext()) {
                    values.add(sc.next());
                    i++;
                }
                if (System.currentTimeMillis() - timeStamp > 3000) {
                    break;
                }
            }
            for (int i = 0; i < 20;) {
                if (sc.hasNext()) {
                    tableValues.add(sc.next());
                    i++;
                }
                if (System.currentTimeMillis() - timeStamp > 3000) {
                    break;
                }
            }
            setValuesOnGUI(values, tableValues);
        } catch (Exception e) {
            mainTestPage.jLabel47.setText("Error in receiving data, Please check connection !" + e);
            System.out.println("Error in receiving data " + e);
        }
        try{
            mainTestPage.jButtonStart.setVisible(true);
            mainTestPage.jButtonDownload.setVisible(true);
            mainTestPage.jLabel47.setText("Data download done !");
            sc.close();
            in.close();
            
        }catch(Exception e){}
        
    }
    
    

    public void setValuesOnGUI(List<String> values, List<String> tableValues) {

        //adding first 7 values
        for (int i = 0; i < 7 && i < values.size(); i++) {
            String value = values.get(i);
            try {
                mainTestPage.inputArray[i].setText(value);
                if (value != null && i < 4) {//check min max only for first 4 rows
                    int val = Integer.parseInt(value);
                    if (val >= min[i] && val <= max[i]) {
                        mainTestPage.inputArray[i].setBackground(Color.green);
                    } else {
                        mainTestPage.inputArray[i].setBackground(Color.pink);
                    }
                }
            } catch (Exception e) {
                mainTestPage.jLabel47.setText(e.getMessage());
            }
        }
        DefaultTableModel tableModel = (DefaultTableModel) mainTestPage.jTable1.getModel();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 10; j++) {
                if (i * 10 + j < tableValues.size()) {
                    String value = tableValues.get(i*10 + j);
                        tableModel.setValueAt(value, i, j);
                }
            }
        }
    }

    public void loadMinMax() {
        try {
            String path = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
            File file = new File("C:\\ProgramData\\Industrial Engineering\\VCB_MTP\\StandardValues.txt");
            List<String> lines = FileUtils.readLines(file);
            min = new int[10];
            max = new int[10];
            String line[];
            for (int i = 0; i < 4; i++) {
                line = lines.get(i).split("\t");
                min[i] = Integer.parseInt(line[0]);
                max[i] = Integer.parseInt(line[1]);
            }
            
        } catch (Exception e) {
            System.out.println("Eror in reading std val at min maxx " + e);
        }
    }
}
