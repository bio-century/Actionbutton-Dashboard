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
    public String ReadSpreadsheet(String SPREADSHEET_NAME, int vRow, int vColumn, int vsheet, int wbook) {
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

        Sheet sheet = wb.getSheetAt(vsheet);
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
