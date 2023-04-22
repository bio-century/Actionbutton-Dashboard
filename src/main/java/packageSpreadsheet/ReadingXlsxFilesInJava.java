package packageSpreadsheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static java.lang.Math.*;
//https://www.youtube.com/watch?v=mS0GOFx7KEQ

//        How to Read Excel File in Java with Apache POI | Read Excel in Java | NetBeans IDE
//        Programming Guru


public class ReadingXlsxFilesInJava {

//    public JPanel myPanelCat;

////////////////////////////////////////////////////////////////////////////////////////////////////
//  (02)                                     Build Dashboard                                      //
////////////////////////////////////////////////////////////////////////////////////////////////////
    public int[] ReadingXlsxFilesInJava(String SPREADSHEET_ALL) throws IOException {
        Workbook wb = null;
        FileInputStream fins = new FileInputStream(SPREADSHEET_ALL);
        // wb = WorkbookFactory.create(fins);
        wb = new XSSFWorkbook(fins);
        Sheet sheet = wb.getSheetAt(0);
        FormulaEvaluator formulaEval = wb.getCreationHelper().createFormulaEvaluator();
        int ii = 0; // columns!!!
        int jj = 0; // rows
        List<Integer> iiFinal = new ArrayList<Integer>();
        List<Integer> jjFinal = new ArrayList<Integer>();
        int kk=0;
        for (Row row : sheet) {
            ii = 0;
            jj = jj + 1;
            for (Cell cell : row) {
                switch (formulaEval.evaluateInCell(cell).getCellType()) {
//                    case NUMERIC:
//                        System.out.println(cell.getNumericCellValue()+"\t\t");
//                        ii = ii + 1;
//                        break;
                    case STRING:
//                        System.out.println(cell.getStringCellValue() + "\t\t");
                        ii = ii + 1;
                        kk = kk + 1;
                        iiFinal.add(ii); // columns!!!
                        jjFinal.add(jj); // rows

//                        System.out.println("columns: " + ii);
//                        System.out.println("rows: " + jj);

                        break;
                }
            }
        }

        int iiFinalMAX = 0;
        int jjFinalMAX = 0;

        for (int i = 0; i < kk-1; i++) {
            iiFinalMAX = max(iiFinalMAX, iiFinal.get(i+1));
            jjFinalMAX = max(jjFinalMAX, jjFinal.get(i+1));
        }




        wb.close();
//        System.out.println("columnsFinal: " + iiFinal);
//        System.out.println("rowsFinal: " + jjFinal);
        int[] results = new int[2];
        results[0] = iiFinalMAX; // columns!!!
        results[1] = jjFinalMAX; // rows
        return results;

    }


}
