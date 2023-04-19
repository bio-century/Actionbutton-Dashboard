////////////////////////////////////////////////////////////////////////////////////////////////////
//  (00)                                 SpreadsheetReadCellData                                  //
////////////////////////////////////////////////////////////////////////////////////////////////////
// Access: Main -> BuildDashboard -> IconEditingImageTransform


////////////////////////////////////////////////////////////////////////////////////////////////////
//  (01)                                      Package Import                                      //
////////////////////////////////////////////////////////////////////////////////////////////////////
package packageSpreadsheet;

import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;

// sources:
// https://stackoverflow.com/questions/2194284/how-to-get-the-last-column-index-reading-excel-file
// https://poi.apache.org/apidocs/dev/org/apache/poi/hssf/usermodel/HSSFRow.html#getLastCellNum--
// https://www.youtube.com/watch?v=816wduoH9eY
// https://coderanch.com/t/657887/java/Pausing-loop-wait-response-actionListener

public class SpreadsheetReadCellData {
//    public String ReadSpreadsheet(String SPREADSHEET_NAME, int vRow, int vColumn, int vsheet, int wbook) {


////////////////////////////////////////////////////////////////////////////////////////////////////
//  (02)                     Read-In a Single Cell of a Spreadsheet-Workbook                      //
////////////////////////////////////////////////////////////////////////////////////////////////////
    public String ReadSpreadsheet(String SPREADSHEET_NAME, int vRow, int vColumn, String vsheet) {
        String value = null;
        Workbook wb = null;
        try {
            FileInputStream fis = new FileInputStream(SPREADSHEET_NAME);
            wb = new XSSFWorkbook(fis);
            //        spreadsheet = workbook.getSheet("sheet1");

//            wb.getAllNames();//    getSheet(vsheet).exists()

//            Sheet sheet2 = wb.createSheet("test");
            // https://stackoverflow.com/questions/43645607/java-check-workbook-contains-a-specific-spreadsheet-or-not-using-apache-poi
            // Check if the workbook is empty or not
//        if (wb.getSheet(vsheet) == null) {
            // Create new sheet to the workbook if empty
//            sheet2 = wb.createSheet("test");
//        }


            int numberOfSheets = wb.getNumberOfSheets();
            System.out.println("Total Number of Sheets: " + numberOfSheets);
            String sheetNames;//    getSheetNames();
            int testavailable = 0;

            for (int i = 0 ; i < numberOfSheets; i ++ ) {
                sheetNames = wb.getSheetName(i);

                if (sheetNames.indexOf("test") ==0) {
                    testavailable = 1;
                }
                System.out.println("tA " + sheetNames);
                System.out.println("tA " + testavailable);
            }
            Sheet sheet = wb.getSheet(vsheet);//   getSheet(vsheet);

            System.out.println("tA " + testavailable);
            if (testavailable == 0) {
                OutputStream fileOut = new FileOutputStream(SPREADSHEET_NAME);

                Sheet sheet2 = wb.createSheet("test");
                wb.write(fileOut);
            }


            Row row = sheet.getRow(vRow);
            if (row != null) {
                Cell cell = row.getCell(vColumn);
                if (cell == null) {
                    value = "";
                } else {
                    value = cell.getStringCellValue();
                }
            } else {
                value = "";
            }
//
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return value;
    }
}
