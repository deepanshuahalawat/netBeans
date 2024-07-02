package com.tf.util;


import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MR. VAISH
 */
public class ExcelUtilities {

    public static void createExcel(String path, String fileName, String headrow) throws Exception {

        File f=new File(path);
        File file = new File(f,fileName + ".xlsx");
        XSSFWorkbook myWorkBook = new XSSFWorkbook();
        XSSFSheet mySheet = myWorkBook.createSheet("Info Sheet");
        XSSFRow row = mySheet.createRow(0);
        String heading[] = headrow.split("\t");
        mySheet.createFreezePane(0, 1);
        CellStyle style = myWorkBook.createCellStyle(); //Create new style
        style.setWrapText(true); //Set wordwrap
           
        for (int i = 0; i < heading.length; i++) {
            mySheet.setColumnWidth(i, (256 * 15));
        //  mySheet.autoSizeColumn(i);
          
        }
        for (int i = 0; i < heading.length; i++) {
            
            Cell cell = row.createCell(i);
             cell.setCellStyle(style);
            cell.setCellValue(heading[i]);
        }
        FileOutputStream fos = new FileOutputStream(file);
        myWorkBook.write(fos);
        fos.flush();
        fos.close();
        System.out.println(
                "Writesheet.xlsx written successfully");
    }

    public static void addEntry(String path,String fileName, String dataString) throws Exception {
        File f=new File(path);
        File file = new File(f,fileName + ".xlsx");
        FileInputStream input_document = new FileInputStream(file);
        String data[]=dataString.split("\t");
        XSSFWorkbook my_xls_workbook = new XSSFWorkbook(input_document);
        XSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0);
        int rows = my_worksheet.getLastRowNum();
        XSSFRow row = my_worksheet.createRow(rows + 1);
        for (int i = 0; i < data.length; i++) {

            Cell cell = row.createCell(i);
            cell.setCellValue((String) data[i]);

        }
        input_document.close();
        FileOutputStream fos = new FileOutputStream(file);
        my_xls_workbook.write(fos);
        fos.flush();
        fos.close();

    }

    public static void openExcel(String path,String fileName) throws Exception {
        File f=new File(path);
        File file = new File(f,fileName + ".xlsx");
        Desktop dt = Desktop.getDesktop();
        dt.edit(file);
    }

  

    public static void filter(String path,String fileName) throws Exception {
        File f=new File(path);
        File file1=new File(f,fileName+".xlsx");
        File file2=new File(f,fileName+"_temp"+".xlsx");
        FileUtils.copyFile(file1, file2);
        FileInputStream input_document = new FileInputStream(file2);
        XSSFWorkbook my_xls_workbook = new XSSFWorkbook(input_document);
       /* XSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0);
        XSSFRow r1;
        if(option!=0)
        {
        for(Row r:my_worksheet)
        { 
            
           
            for(Cell c:r)
            {
                 if (c.getRowIndex()!=0 && c.getColumnIndex()==(option-1)  && !(c.getStringCellValue().equals(filterString)))
                 {
                
                     System.out.println("["+c.getRowIndex()+" "+c.getColumnIndex()+"]");
                     r1=(XSSFRow)c.getRow();
                     r1.getCTRow().setHidden(true);
                
                 } 
            }
           
        }
     }
       else if(option==4)
        {
          for(Row r:my_worksheet)
          {
            for(Cell c:r)
            {
                 if (c.getRowIndex()!=0 && c.getColumnIndex()==(option-1)  && !(c.getStringCellValue().contains(filterString))) 
                 {
                
                        System.out.println("["+c.getRowIndex()+c.getColumnIndex()+"]");
                         r1=(XSSFRow)c.getRow();
                        r1.getCTRow().setHidden(true);
                    
                 } 
            }
           
         }  
        }*/
            input_document.close();
            FileOutputStream fos = new FileOutputStream(file2);
            my_xls_workbook.write(fos);
            fos.flush();
            fos.close();
           // ExcelUtilities.openExcel("Record_temp");
            
        
} 
}
