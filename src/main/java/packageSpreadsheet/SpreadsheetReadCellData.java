package packageSpreadsheet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// sources:
// https://stackoverflow.com/questions/2194284/how-to-get-the-last-column-index-reading-excel-file
// https://poi.apache.org/apidocs/dev/org/apache/poi/hssf/usermodel/HSSFRow.html#getLastCellNum--
// https://www.youtube.com/watch?v=816wduoH9eY
// https://coderanch.com/t/657887/java/Pausing-loop-wait-response-actionListener

public class SpreadsheetReadCellData {
//    public String ReadSpreadsheet(String SPREADSHEET_NAME, int vRow, int vColumn, int vsheet, int wbook) {
    public String ReadSpreadsheet(String SPREADSHEET_NAME, int vRow, int vColumn, String vsheet) {
        String value = null;
        Workbook wb = null;
        try {
            FileInputStream fis = new FileInputStream(SPREADSHEET_NAME);
            wb = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }





//        spreadsheet = workbook.getSheet("sheet1");
        Sheet sheet = wb.getSheet(vsheet);//   getSheet(vsheet);

        // https://stackoverflow.com/questions/43645607/java-check-workbook-contains-a-specific-spreadsheet-or-not-using-apache-poi
        // Check if the workbook is empty or not
        if (wb.getSheet(vsheet) == null) {
            // Create new sheet to the workbook if empty
            sheet = wb.createSheet(vsheet);
        }

        Row row = sheet.getRow(vRow);
        Cell cell = row.getCell(vColumn);
        if (cell == null) {
            value = "";
        } else {
            value = cell.getStringCellValue();
        }


        return value;
    }
}
