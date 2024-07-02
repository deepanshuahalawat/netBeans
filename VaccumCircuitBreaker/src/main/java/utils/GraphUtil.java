/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

/**
 *
 * @author HP
 */
public class GraphUtil {
    public static JFreeChart createGraphOnPanel(JPanel panel,String title){
        double arr[] = {1.0,2,3,4,5,6,7,8,9,12,13,14};
        XYSeries series = createSeries(arr);
        JFreeChart chart = ChartFactory.createXYLineChart(
                title, "T(ms)", "mm", new XYSeriesCollection(series));
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.getRangeAxis().setRange(1,20);
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        xAxis.setTickUnit(new NumberAxis().getTickUnit());
        xAxis.setTickUnit(new org.jfree.chart.axis.NumberTickUnit(10));
        xAxis.setAutoRangeIncludesZero(true);
        ChartPanel chartPanel = new ChartPanel(chart){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(1000, 600);
            }
        };
        panel.add(chartPanel, BorderLayout.CENTER);
        
        return chart;
    }
    public static XYSeries createSeries(double[] dataArray) {
        XYSeries series = new XYSeries("Data");
        for (int i = 0; i < dataArray.length; i++) {
            series.add(i, dataArray[i]);
        }
        return series;
    }
    
}
