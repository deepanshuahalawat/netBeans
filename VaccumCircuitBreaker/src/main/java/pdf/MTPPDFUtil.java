/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.TabStop;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import com.technofarm.vcb.frame.MainTestPage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ui.HorizontalAlignment;

/**
 *
 * @author HP
 */
public class MTPPDFUtil {

    private static double[] dataArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 13, 14};

    static MainTestPage mainTestPage;

    public MTPPDFUtil(MainTestPage mainTestPage) {
        this.mainTestPage = mainTestPage;
    }

    public static void main(String args[]) {
        try {
            generatePdfReport("SamplePDF.pdf");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void generatePdfReport(String fileName){
        try{
        Document document = new Document();
        String path = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
        File f = new File(path+"//IndustrialEngineering//MainTestPage");
        if(!f.exists()){
            f.mkdirs();
        }
        f = new File(f,fileName);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(f));
        document.open();

        // Add title
        addTitle(document);
        addHeaderTable(document);
        addFields(document);
        addMiddleTable(document);
        addOverhauledSignature(document);
        document.close();
        }catch(Exception e){
            mainTestPage.jLabel47.setText(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    private static void addMiddleTable(Document document) throws DocumentException {
        PdfPTable table = new PdfPTable(10); // 2 columns
        table.setWidthPercentage(100);
        Font font = FontFactory.getFont(FontFactory.TIMES_BOLD, 14);
        Phrase phrse = new Phrase("Main cont.", font);
        Paragraph para = new Paragraph(phrse);
        PdfPCell cell = new PdfPCell(para);
        table.addCell(cell);
        for (int i = 1; i < 10; i++) {
            phrse = new Phrase("Aux " + i, font);
            para = new Paragraph(phrse);
            cell = new PdfPCell(para);
            table.addCell(cell);
        }

        DefaultTableModel tableModel = (DefaultTableModel) mainTestPage.jTable1.getModel();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 10; j++) {
                String line = (String) tableModel.getValueAt(i, j);
                table.addCell(line);
            }
        }
        document.add(table);
        document.add(Chunk.NEWLINE);
    }

    private static void addOverhauledSignature(Document document) throws DocumentException {
        PdfPTable table = new PdfPTable(2); // 2 columns
        table.setWidthPercentage(100);
        String line = "Overhauled by :" + mainTestPage.jTextFieldoverhauledBy.getText();
        PdfPCell cell = new PdfPCell(new Paragraph(line));
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);
        line = "Name and Signature :" + mainTestPage.jTextFieldNameAndSign.getText();
        Paragraph para = new Paragraph(line);
        para.setAlignment(Element.ALIGN_RIGHT);
        cell = new PdfPCell(para);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(cell);

        document.add(table);
    }

    private static void addHeaderTable(Document document) throws DocumentException {
        // Add table
        PdfPTable table = new PdfPTable(3); // 2 columns
        table.setWidthPercentage(100);
        String line = "VCB Sr No :" + mainTestPage.jTextFieldVcbNo.getText();
        table.addCell(line);
        line = "VCB Make :" + mainTestPage.jTextFieldMake.getText();
        table.addCell(line);
        line = "VCB Type :" + mainTestPage.jTextFieldVcbType.getText();
        table.addCell(line);
        line = "Removed From :" + mainTestPage.jTextFieldremoveFrom.getText();
        table.addCell(line);
        line = "Provided In :" + mainTestPage.jTextFieldProvidedIn.getText();
        table.addCell(line);
        line = "Date " + mainTestPage.jTextFieldDate.getText() + " " + mainTestPage.jTextFieldTime.getText();
        table.addCell(line);
        document.add(table);
        document.add(Chunk.NEWLINE);
    }

    private static void addFields(Document document) throws DocumentException {
        String line = "Coil Resistance :" + mainTestPage.jTextFieldCoilResistance.getText();
        addLine(document, line, 14);
        line = "Pickup Volts :" + mainTestPage.jTextFieldPickUpVolt.getText();
        addLine(document, line, 14);
        line = "Dropout Volts :" + mainTestPage.jTextFieldDropOutVolt.getText();
        addLine(document, line, 14);
        line = "Coil Current(A) :" + mainTestPage.jTextFieldCoilCurrent.getText();
        addLine(document, line, 14);
        line = "Endurance test cycle :" + mainTestPage.jTextFieldEnduranceTestCycle.getText();
        addLine(document, line, 14);
        line = "Endurance Test OnTime :" + mainTestPage.jTextFieldEndTestOnTime.getText() + ",  Off Time :" + mainTestPage.jTextFieldEndTestOffTime.getText();
        addLine(document, line, 14);
        line = "Main Contact Pressure :" + mainTestPage.jTextFieldContactPressure.getText();
        addLine(document, line, 14);
        line = "Air leakage :" + mainTestPage.jCheckBoxLeaked.isSelected();
        addLine(document, line, 14);
        line = "Condition base Item replace :" + mainTestPage.jTextFieldiTemReplace.getText();
        addLine(document, line, 14);
        document.add(Chunk.NEWLINE);

    }

    private static void addLine(Document document, String line, int fontSize) throws DocumentException {
        Font font = FontFactory.getFont(FontFactory.TIMES, fontSize);
        Phrase phrse = new Phrase(line, font);
        Paragraph para = new Paragraph(phrse);
        document.add(para);
    }

    private static void addTitle(Document document) throws DocumentException {
        String headingText = "VCB Main Test Report";
        Font font = FontFactory.getFont(FontFactory.TIMES_BOLD, 24);
        Phrase phrse = new Phrase(headingText, font);
        Paragraph heading = new Paragraph(phrse);

        heading.setAlignment(Element.ALIGN_CENTER);
        document.add(heading);
        document.add(Chunk.NEWLINE);
    }
}
