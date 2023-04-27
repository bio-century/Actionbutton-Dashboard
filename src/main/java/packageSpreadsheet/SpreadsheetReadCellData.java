////////////////////////////////////////////////////////////////////////////////////////////////////
//  (00)                                 SpreadsheetReadCellData                                  //
////////////////////////////////////////////////////////////////////////////////////////////////////
// Access: Main -> BuildDashboard -> IconEditingImageTransform


////////////////////////////////////////////////////////////////////////////////////////////////////
//  (01)                                      Package Import                                      //
////////////////////////////////////////////////////////////////////////////////////////////////////
package packageSpreadsheet;

import java.io.*;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// sources:
// https://stackoverflow.com/questions/2194284/how-to-get-the-last-column-index-reading-excel-file
// https://poi.apache.org/apidocs/dev/org/apache/poi/hssf/usermodel/HSSFRow.html#getLastCellNum--
// https://www.youtube.com/watch?v=816wduoH9eY
// https://coderanch.com/t/657887/java/Pausing-loop-wait-response-actionListener
// https://stackoverflow.com/questions/43645607/java-check-workbook-contains-a-specific-spreadsheet-or-not-using-apache-poi

public class SpreadsheetReadCellData {


////////////////////////////////////////////////////////////////////////////////////////////////////
//  (02)                     Read-In a Single Cell of a Spreadsheet-Workbook                      //
////////////////////////////////////////////////////////////////////////////////////////////////////
    public String ReadSpreadsheet(String SPREADSHEET_NAME, int vRow, int vColumn, String vsheet) {
        String value = null;
        Workbook wb = null;
        try {
            FileInputStream fis = new FileInputStream(SPREADSHEET_NAME);
            wb = new XSSFWorkbook(fis);

            int numberOfSheets = wb.getNumberOfSheets();
            String sheetNames;
            int myCommentsAvailable = 0;
            for (int ii = 0; ii < numberOfSheets; ii++ ) {
                sheetNames = wb.getSheetName(ii);

                if (sheetNames.indexOf("comments") ==0) {
                    myCommentsAvailable = 1;
                }
            }

            Sheet sheet = wb.getSheet(vsheet);
            if (myCommentsAvailable == 0) {
                OutputStream fileOut = new FileOutputStream(SPREADSHEET_NAME);
                wb.write(fileOut);
            }

            int myIconsAvailable = 0;
            for (int ii = 0; ii < numberOfSheets; ii++ ) {
                sheetNames = wb.getSheetName(ii);
                if (sheetNames.indexOf("icons") ==0) {
                    myIconsAvailable = 1;
                }
            }

            if (myIconsAvailable == 0) {
                OutputStream fileOut = new FileOutputStream(SPREADSHEET_NAME);
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

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return value;
    }
}
