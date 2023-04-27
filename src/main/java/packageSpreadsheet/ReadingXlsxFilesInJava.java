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

// sources:
// https://www.youtube.com/watch?v=mS0GOFx7KEQ
// (How to Read Excel File in Java by Programming Guru)

public class ReadingXlsxFilesInJava {

////////////////////////////////////////////////////////////////////////////////////////////////////
//  (02)                                     Build Dashboard                                      //
////////////////////////////////////////////////////////////////////////////////////////////////////
    public int[] ReadingXlsxFilesInJava(String SPREADSHEET_ALL) throws IOException {
        Workbook wb = null;
        FileInputStream fins = new FileInputStream(SPREADSHEET_ALL);
        wb = new XSSFWorkbook(fins);
        Sheet sheet = wb.getSheetAt(0);
        FormulaEvaluator formulaEval = wb.getCreationHelper().createFormulaEvaluator();
        int ii = 0; // columns
        int jj = 0; // rows
        List<Integer> iiFinal = new ArrayList<Integer>();
        List<Integer> jjFinal = new ArrayList<Integer>();
        int kk=0;
        for (Row row : sheet) {
            ii = 0;
            jj = jj + 1;
            for (Cell cell : row) {
                switch (formulaEval.evaluateInCell(cell).getCellType()) {
                    case STRING:
                        ii = ii + 1;
                        kk = kk + 1;
                        iiFinal.add(ii); // columns
                        jjFinal.add(jj); // rows
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
        int[] myResults = new int[2];
        myResults[0] = iiFinalMAX; // columns
        myResults[1] = jjFinalMAX; // rows
        return myResults;

    }


}
