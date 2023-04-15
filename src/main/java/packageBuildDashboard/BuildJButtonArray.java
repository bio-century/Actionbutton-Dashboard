//package packageBuildDashboard;
//
//import packageSpreadsheet.SpreadsheetReadCellData;
//
//import javax.swing.*;
//import javax.swing.border.Border;
//import javax.swing.border.LineBorder;
//import java.awt.*;
//
//public class BuildJButtonArray {
//    public BuildJButtonArray(String w, String h, String USER_DIR_SPREADSHEETS, String SPREADSHEET_NAME, String FONTNAME, int NUMBER_OF_ROWS,
//                                      int NUMBER_OF_COLUMNS, int[] SpreadSheetDimensions,
//                                      int IMAGE_LOGO_WIDTH,
//                                      int IMAGE_LOGO_HEIGHT,
//                                      String USER_DIR_IMAGES,
//                                      String IMAGE_LOGO,
//                                      int WIDTH,
//                                      int HEIGHT,
//                                      String FRAME_TITLE,
//                                      String USER_DIR_ICONS) {
////                                  myColorJButtonsBackground,
////                                  Color myColorJTabbedPaneFrame,
////                                  myColorJButtonsBackground
//
//
//        String[][] myFieldnamesAll;
//        myFieldnamesAll = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
//
//
//        JButton[] myButtons = new JButton[(NUMBER_OF_ROWS + 1) * NUMBER_OF_COLUMNS];
//        JLabel[] myLabels = new JLabel[(NUMBER_OF_ROWS + 1) * NUMBER_OF_COLUMNS];
//        JLabel[] myLabelsBlanks = new JLabel[(NUMBER_OF_ROWS + 1) * NUMBER_OF_COLUMNS];
//
//        String[][] myCategoriesAll = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
//        String[][] myUrlAll = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
//        String[][] myColorAll = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
//
//
//        SpreadsheetReadCellData rc = new SpreadsheetReadCellData();
//        Integer[] ColRowCounts = new Integer[NUMBER_OF_COLUMNS];
//        for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
//            ColRowCounts[j] = 0;
//        }
//
//        int ii = 0;
//        int jj = 0;
//        int kk = 0;
//
//        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
//            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
//                ColRowCounts[j] = 0;
//                myFieldnamesAll[i][j] = rc.ReadSpreadsheet(USER_DIR_SPREADSHEETS, SPREADSHEET_NAME, i, j, 0, 1);
//                myCategoriesAll[i][j] = rc.ReadSpreadsheet(USER_DIR_SPREADSHEETS, SPREADSHEET_NAME, i, j, 1, 1);
//                myUrlAll[i][j] = rc.ReadSpreadsheet(USER_DIR_SPREADSHEETS, SPREADSHEET_NAME, i, j, 2, 1);
//                myColorAll[i][j] = rc.ReadSpreadsheet(USER_DIR_SPREADSHEETS, SPREADSHEET_NAME, i, j, 3, 1);
//                if (myFieldnamesAll[i][j] == "") {
//                } else {
//                    ColRowCounts[j] = ColRowCounts[j] + 1;
//                }
//
//                if (j < NUMBER_OF_COLUMNS && i == 0) {
//                    String colorallfg;
//                    colorallfg = rc.ReadSpreadsheet(USER_DIR_SPREADSHEETS, SPREADSHEET_NAME, 1, j, 3, 1);
//                    String[] mySpreadSheetColorRGB = colorallfg.split(",");
//
//                    int mySpreadSheetColorR;
//                    int mySpreadSheetColorG;
//                    int mySpreadSheetColorB;
//
//                    mySpreadSheetColorR = Integer.parseInt(mySpreadSheetColorRGB[0]);
//                    mySpreadSheetColorG = Integer.parseInt(mySpreadSheetColorRGB[1]);
//                    mySpreadSheetColorB = Integer.parseInt(mySpreadSheetColorRGB[2]);
//
//                    myLabels[ii] = new JLabel("", JLabel.CENTER);
//                    myLabels[ii].setFont(new Font(FONTNAME, Font.BOLD, 18));
//                    myLabels[ii].setText(myFieldnamesAll[i][j]);
//                    myLabels[ii].setForeground(new Color(mySpreadSheetColorR, mySpreadSheetColorG, mySpreadSheetColorB));
//                    ii++;
//                } else if (myFieldnamesAll[i][j] == "") {
//                    myLabelsBlanks[jj] = new JLabel("");
//                    myLabelsBlanks[jj].setHorizontalAlignment(JLabel.CENTER);
//                    myLabelsBlanks[jj].setVerticalAlignment(JLabel.CENTER);
//                    jj++;
//                } else {
//                    myButtons[kk] = new JButton();
////                    myButtons[kk].setBackground(myColorJButtonsBackground);
//                    myButtons[kk].setHorizontalAlignment(SwingConstants.LEFT);
//                    String[] values = myColorAll[i][j].split(",");
//                    int values_int1;
//                    int values_int2;
//                    int values_int3;
//                    values_int1 = Integer.parseInt(values[0]);
//                    values_int2 = Integer.parseInt(values[1]);
//                    values_int3 = Integer.parseInt(values[2]);
//                    myButtons[kk].setForeground(new Color(values_int1, values_int2, values_int3));
//                    myButtons[kk].setFont(new Font(FONTNAME, Font.PLAIN, 14));
//                    myButtons[kk].setText("   " + myFieldnamesAll[i][j]);
//                    Border border = new LineBorder(new Color(values_int1, values_int2, values_int3), 1);
//                    myButtons[kk].setBorder(border);
//
//
//                    int finalLl = kk;
//                    myButtons[kk].addMouseListener(new java.awt.event.MouseAdapter() {
////                        public void mouseEntered(java.awt.event.MouseEvent evt) {
////                            myButtons[finalLl].setBackground(myColorJTabbedPaneFrame);
////                        }
////
////                        public void mouseExited(java.awt.event.MouseEvent evt) {
////                            myButtons[finalLl].setBackground(myColorJButtonsBackground);
////                        }
//                    });
//                    kk++;
//                }
//            }
//        }
//    }
//
//
//}
//
