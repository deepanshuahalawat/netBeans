package connection;


import com.technofarm.vcb.frame.Analyzer;
import com.technofarm.vcb.frame.FirstFrame;
import java.awt.Color;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Scanner;
import javax.swing.filechooser.FileSystemView;
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
public class AnalyserConnection {

    Analyzer analyzer;
    OutputStream os;
    InputStream in;
    int min[], max[];
    Scanner sc;
    AnalyserConnection(Analyzer ff) {
        this.analyzer = ff;
    }

    public void start() {
        os = analyzer.portObj.getOutputStream();
        try {
            os.write('B');
            receive();
        } catch (Exception e) {
            analyzer.jLabel47.setText("Error in sending data to contactor, Please check connection !");
            e.printStackTrace();
        }
    }

    public void receive() {
        loadMinMax();
        in = analyzer.portObj.getInputStream();
        sc = new Scanner(in);

        try {
            int data = in.read();
            while (data != 'S') {
                data = in.read();
            }
            //Matching for TART
            String test = "START";
            for (int i = 0; i < test.length(); i++) {
                analyzer.jLabel47.setText(data + "");
                if (test.charAt(i) != data) {
                    analyzer.jLabel47.setText("Error in syn character please check your wire and start the test again !");
                    System.out.println("Error in receiving start ");
                    return;
                }
                data = in.read();
            }
            sc.useDelimiter("Z");
            float f_val = 0;
            /*
            for (int i = 0; i < analyzer.labelArray.length - 1; i++) {
                int val = Integer.parseInt(sc.next());
                
                if (val >= min[i] && val <= max[i]) {
                    analyzer.labelArray[i].setBackground(Color.green);
                } else {
                    analyzer.labelArray[i].setBackground(Color.pink);
                }

                if (i == 1) {
                    f_val = (float) val / 10;
                    if (val <= 10) {
                        analyzer.labelArray[i].setText("FAULT");
                        analyzer.labelArray[i].setBackground(Color.red);
                    } else if (val >= 600) {
                        analyzer.labelArray[i].setText("OPEN");
                        analyzer.labelArray[i].setBackground(Color.red);
                    } else {
                        analyzer.labelArray[i].setText(f_val + "");
                        analyzer.labelArray[i].setBackground(Color.green);
                    }
                } else {
                    analyzer.labelArray[i].setText(val + "");
                }
            }
            analyzer.labelArray[analyzer.labelArray.length - 1].setText(sc.next());
            */
        } catch (Exception e) {
            analyzer.jLabel47.setText("Error in receiving data, Please check connection !" + e);
            System.out.println("Error in receiving data " + e);
        }
    }

    public void loadMinMax() {
        try {
            String path = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
            File file = new File("C:\\ProgramData\\Industrial Engineering\\ProjectEpc\\StandardValues.txt");
            List<String> lines = FileUtils.readLines(file);
            min = new int[14];
            max = new int[14];
            String line[];
            //jLabel 1
            line = lines.get(0).split("\t");
            min[0] = Integer.parseInt(line[0]);
            max[0] = Integer.parseInt(line[1]);

            line = lines.get(1).split("\t");
            min[1] = Integer.parseInt(line[0]);
            max[1] = Integer.parseInt(line[1]);

            line = lines.get(2).split("\t");
            min[2] = Integer.parseInt(line[0]);
            max[2] = Integer.parseInt(line[1]);

            line = lines.get(3).split("\t");
            min[3] = Integer.parseInt(line[0]);
            max[3] = Integer.parseInt(line[1]);

            line = lines.get(5).split("\t");
            min[4] = Integer.parseInt(line[0]);
            max[4] = Integer.parseInt(line[1]);

            line = lines.get(5).split("\t");
            min[5] = Integer.parseInt(line[0]);
            max[5] = Integer.parseInt(line[1]);

            line = lines.get(6).split("\t");
            min[6] = Integer.parseInt(line[0]);
            max[6] = Integer.parseInt(line[1]);

            line = lines.get(6).split("\t");
            min[7] = Integer.parseInt(line[0]);
            max[7] = Integer.parseInt(line[1]);

            line = lines.get(6).split("\t");
            min[8] = Integer.parseInt(line[0]);
            max[8] = Integer.parseInt(line[1]);

            line = lines.get(6).split("\t");
            min[9] = Integer.parseInt(line[0]);
            max[9] = Integer.parseInt(line[1]);

            line = lines.get(6).split("\t");
            min[10] = Integer.parseInt(line[0]);
            max[10] = Integer.parseInt(line[1]);

            line = lines.get(6).split("\t");
            min[11] = Integer.parseInt(line[0]);
            max[11] = Integer.parseInt(line[1]);

            line = lines.get(4).split("\t");
            min[12] = Integer.parseInt(line[0]);
            max[12] = Integer.parseInt(line[1]);

            line = lines.get(4).split("\t");
            min[13] = Integer.parseInt(line[0]);
            max[13] = Integer.parseInt(line[1]);

        } catch (Exception e) {
            System.out.println("Error in reading min max value " + e);
        }
    }
}
