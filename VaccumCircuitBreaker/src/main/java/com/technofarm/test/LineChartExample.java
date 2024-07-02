package com.technofarm.test;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class LineChartExample extends javax.swing.JFrame {

    private XYSeries series;
    private double[] dataArray;
    private JFreeChart chart;
    static JPanel panel = null;
    public LineChartExample() {
         panel = new JPanel(new BorderLayout());
        add(panel);
    }
    public void showChart(String applicationTitle, String chartTitle, int Xinterval, double[] dataArray){
        this.dataArray = dataArray;
        this.series = createSeries(dataArray);
        this.chart = ChartFactory.createXYLineChart(
                chartTitle, "Index", "Value", new XYSeriesCollection(series));

        XYPlot plot = (XYPlot) chart.getPlot();
        
  
        ChartPanel chartPanel = new ChartPanel(chart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(1000, 600);
            }
        };

       
        panel.add(chartPanel, BorderLayout.CENTER);
  
       
    }

    private XYSeries createSeries(double[] dataArray) {
        XYSeries series = new XYSeries("Data");
        for (int i = 0; i < dataArray.length; i++) {
            series.add(i, dataArray[i]);
        }
        return series;
    }

    private void generatePdfReport(String fileName) throws Exception {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
        document.open();

        // Add title
        document.add(new Paragraph("Chart Report"));
        document.add(new Paragraph("\n"));

        // Add table
        PdfPTable table = new PdfPTable(2); // 2 columns
        table.setWidthPercentage(100);
        PdfPCell cell1 = new PdfPCell(new Paragraph("Index"));
        PdfPCell cell2 = new PdfPCell(new Paragraph("Value"));
        table.addCell(cell1);
        table.addCell(cell2);

        for (int i = 0; i < 10; i++) {
            table.addCell(String.valueOf(i));
            double value = dataArray[i];
            String formattedValue = String.format("%.1f", value);
            table.addCell(formattedValue);
        }

        document.add(table);

        // Add chart image with higher resolution
        document.add(new Paragraph("\n"));
        int width = 1000; // Increase width
        int height = 600; // Increase height
        java.awt.image.BufferedImage bufferedImage = chart.createBufferedImage(width, height);
        com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance(writer, bufferedImage, 1.0f);

        // Adjust image size
        image.scaleToFit(500, 300); // Scale image to desired size
        image.setAlignment(Element.ALIGN_CENTER);
        document.add(image);

        document.close();
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            double[] dataArray = {1,2,3,4,5,6,7,8,9,1,1,1,1,1};
            LineChartExample chart = new LineChartExample();
                   
            chart.pack();
            chart.setLocationRelativeTo(null);
            chart.setVisible(true);
            
             chart.showChart("Data Visualization", "Test Report", 5, dataArray);
        });
    }
}
