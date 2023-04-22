////////////////////////////////////////////////////////////////////////////////////////////////////
//  (00)                                      BuildDashboard                                      //
////////////////////////////////////////////////////////////////////////////////////////////////////
// Access: Main -> BuildDashboard


////////////////////////////////////////////////////////////////////////////////////////////////////
//  (01)                                      Package Import                                      //
////////////////////////////////////////////////////////////////////////////////////////////////////
package packageBuildDashboard;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import packageIconEditing.IconEditingImageTransform;
import packageJButtons.JButtonsSetUpActionListener;
import packageSpreadsheet.SpreadsheetReadCellData;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.*;
import java.io.IOException;

import javax.swing.border.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Sources:
// https://www.youtube.com/watch?v=816wduoH9eY
// https://coderanch.com/t/657887/java/Pausing-loop-wait-response-actionListener
// https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
// https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
// https://stackoverflow.com/questions/57075145/what-element-controls-the-color-of-the-thin-strip-between-jpanel-and-jtabbedpane
// https://stackoverflow.com/questions/15694107/how-to-layout-multiple-panels-on-a-jframe-java
// https://www.tutorialspoint.com/how-can-we-detect-an-event-when-the-mouse-moves-over-any-component-in-java

public class BuildDashboard {

    public JPanel myPanelCat;


////////////////////////////////////////////////////////////////////////////////////////////////////
//  (02)                                     Build Dashboard                                      //
////////////////////////////////////////////////////////////////////////////////////////////////////
    public BuildDashboard(int w, int h, String USER_DIR_SPREADSHEETS, String SPREADSHEET_NAME, String FONTNAME, int NUMBER_OF_ROWS,
                          int NUMBER_OF_COLUMNS, int[] SpreadSheetDimensions,
                          int IMAGE_LOGO_WIDTH,
                          int IMAGE_LOGO_HEIGHT,
                          String USER_DIR_IMAGES,
                          String IMAGE_LOGO,
                          String SPREADSHEET_ALL,
                          String[] MY_COLOR_LOGO_BACKGROUND_ALL,
                          String[] MY_COLOR_JBUTTON_BACKGROUND_ALL,
                          String[] MY_COLOR_JBUTTON_MOUSE_OVER_ALL,
                          String[] MY_COLOR_JBUTTON_MOUSE_PRESSED_ALL,
                          String[] MY_COLOR_JBUTTON_MOUSE_EXCITED_ALL,
                          String[] MY_COLOR_JBUTTON_ARRAY_BACKGROUND_ALL,
                          String[] MY_COLOR_JTAB_BACKGROUND_ALL,
                          String MOUSEOVER_TEXT,
                          int NUMBER_OF_ROWS_MAX,
                          int NUMBER_OF_COLUMNS_MAX

    ) {

////////////////////////////////////////////////////////////////////////////////////////////////////
//////  (02.01)                       Read-In all Spreadsheet Cells                               //
////////////////////////////////////////////////////////////////////////////////////////////////////
        String[][] myFieldnamesAll;
        myFieldnamesAll = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];

        JButton[] myButtons = new JButton[(NUMBER_OF_ROWS + 1) * NUMBER_OF_COLUMNS];
        JLabel[] myLabels = new JLabel[(NUMBER_OF_ROWS + 1) * NUMBER_OF_COLUMNS];
        JLabel[] myLabelsBlanks = new JLabel[(NUMBER_OF_ROWS + 1) * NUMBER_OF_COLUMNS];
        JLabel[] myLabelstext = new JLabel[(NUMBER_OF_ROWS + 1) * NUMBER_OF_COLUMNS];



//        String[][] myCategoriesAll = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        String[][] myUrlAll = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        String[][] myColorAll = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        String[][] myMouserOverText = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];

        String[][] myTestAll = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];


        ImageIcon myImageLogo = IconEditingImageTransform.ImageTransform(IMAGE_LOGO_WIDTH, IMAGE_LOGO_HEIGHT, USER_DIR_IMAGES + IMAGE_LOGO);

        JPanel myPanelNavigation = new JPanel(new BorderLayout());
        JLabel iconLabel = new JLabel(myImageLogo);
        iconLabel.setVerticalAlignment(JLabel.NORTH);
        myPanelNavigation.setBackground(new Color(
                Integer.parseInt(MY_COLOR_LOGO_BACKGROUND_ALL[0]),
                Integer.parseInt(MY_COLOR_LOGO_BACKGROUND_ALL[1]),
                Integer.parseInt(MY_COLOR_LOGO_BACKGROUND_ALL[2])
        ));
        myPanelNavigation.add(new JLabel("", JLabel.CENTER), BorderLayout.CENTER);


        SpreadsheetReadCellData MySpreadsheet = new SpreadsheetReadCellData();
        Integer[] ColRowCounts = new Integer[NUMBER_OF_COLUMNS];
        for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
            ColRowCounts[j] = 0;
        }

        int ii = 0;
        int jj = 0;
        int kk = 0;
//        JLabel label = new JLabel("Move the mouse moves over this JLabel");
//        JLabel label23 = new JLabel("Move JLabel");

        try {
            Workbook workbook = new XSSFWorkbook(SPREADSHEET_ALL);
            Sheet sheet = workbook.getSheet("fieldnames");
            int rowCount = 0;

            rowCount = sheet.getLastRowNum();
            if (rowCount == 0) {
                rowCount = sheet.getPhysicalNumberOfRows();
            }
            System.out.println("physicalRows: " + rowCount);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                ColRowCounts[j] = 0;
                myFieldnamesAll[i][j] = MySpreadsheet.ReadSpreadsheet(SPREADSHEET_ALL, i, j, "fieldnames");
//                myCategoriesAll[i][j] = MySpreadsheet.ReadSpreadsheet(SPREADSHEET_ALL, i, j, "category");
                myUrlAll[i][j] = MySpreadsheet.ReadSpreadsheet(SPREADSHEET_ALL, i, j, "URL");
                myColorAll[i][j] = MySpreadsheet.ReadSpreadsheet(SPREADSHEET_ALL, i, j, "color");

                myTestAll[i][j] = MySpreadsheet.ReadSpreadsheet(SPREADSHEET_ALL, i, j, "comments");

                if (MOUSEOVER_TEXT == "no") {
                    myMouserOverText[i][j] = MySpreadsheet.ReadSpreadsheet(SPREADSHEET_ALL, i, j, "mouseover text");
                }

                if (myFieldnamesAll[i][j] == "") {
                } else {
                    ColRowCounts[j] = ColRowCounts[j] + 1;
                }

                if (j < NUMBER_OF_COLUMNS && i == 0) {
                    String colorallfg;
                    colorallfg = MySpreadsheet.ReadSpreadsheet(SPREADSHEET_ALL, 0, j, "color");
                    String[] mySpreadSheetColorRGB = colorallfg.split(",");
//                    String[] mySpreadSheetColorRGB = myColorAll[i][j].split(",");
                    int mySpreadSheetColorR;
                    int mySpreadSheetColorG;
                    int mySpreadSheetColorB;
//                    System.out.println(mySpreadSheetColorRGB[0]);
//                    System.out.println(mySpreadSheetColorRGB[1]);
//                    System.out.println(mySpreadSheetColorRGB[2]);
                    mySpreadSheetColorR = Integer.parseInt(mySpreadSheetColorRGB[0]);
                    mySpreadSheetColorG = Integer.parseInt(mySpreadSheetColorRGB[1]);
                    mySpreadSheetColorB = Integer.parseInt(mySpreadSheetColorRGB[2]);

                    myLabels[ii] = new JLabel("", JLabel.CENTER);
                    myLabels[ii].setFont(new Font(FONTNAME, Font.BOLD, 18));
                    myLabels[ii].setText(myFieldnamesAll[i][j]);
                    myLabels[ii].setForeground(new Color(mySpreadSheetColorR, mySpreadSheetColorG, mySpreadSheetColorB));
                    ii++;
                } else if (myFieldnamesAll[i][j] == "") {
                    myLabelsBlanks[jj] = new JLabel("");
                    myLabelsBlanks[jj].setHorizontalAlignment(JLabel.CENTER);
                    myLabelsBlanks[jj].setVerticalAlignment(JLabel.CENTER);
                    jj++;
                } else {
                    myButtons[kk] = new JButton();
                    myButtons[kk].setBackground(new Color(
                            Integer.parseInt(MY_COLOR_JBUTTON_BACKGROUND_ALL[0]),
                            Integer.parseInt(MY_COLOR_JBUTTON_BACKGROUND_ALL[1]),
                            Integer.parseInt(MY_COLOR_JBUTTON_BACKGROUND_ALL[2])
                    ));
                    myButtons[kk].setHorizontalAlignment(SwingConstants.LEFT);
                    String[] values = myColorAll[i][j].split(",");
                    int values_int1;
                    int values_int2;
                    int values_int3;

                    values_int1 = Integer.parseInt(values[0]);
                    values_int2 = Integer.parseInt(values[1]);
                    values_int3 = Integer.parseInt(values[2]);
                    myButtons[kk].setForeground(new Color(values_int1, values_int2, values_int3));
                    myButtons[kk].setFont(new Font(FONTNAME, Font.PLAIN, 14));
                    myButtons[kk].setText("   " + myFieldnamesAll[i][j]);
//                    myLabelstext[kk]  = new JLabel(myFieldnamesAll[i][j]);


                    Border border = new LineBorder(new Color(values_int1, values_int2, values_int3), 1);
                    myButtons[kk].setBorder(border);

                    if (String.valueOf(myTestAll[i][j]) != "") {
                        myButtons[kk].setToolTipText(String.valueOf(myTestAll[i][j]));
                    }

                    int finalLl = kk;

////////////////////////////////////////////////////////////////////////////////////////////////////
//////  (02.02)                   Define JButton-Colors on Mouse-Events                           //
////////////////////////////////////////////////////////////////////////////////////////////////////
                    int finalI = i;
                    int finalJ = j;
                    myButtons[kk].addMouseListener(new java.awt.event.MouseAdapter() {

                        public void mouseEntered(java.awt.event.MouseEvent evt) {
                            myButtons[finalLl].setBackground(new Color(
                                    Integer.parseInt(MY_COLOR_JBUTTON_MOUSE_OVER_ALL[0]),
                                    Integer.parseInt(MY_COLOR_JBUTTON_MOUSE_OVER_ALL[1]),
                                    Integer.parseInt(MY_COLOR_JBUTTON_MOUSE_OVER_ALL[2])
                                    ));
//                            myPanelNavigation.   setLayout(new JLabel(String.valueOf(myTestAll[finalI][finalJ]), JLabel.CENTER), BorderLayout.CENTER);
//                            myPanelNavigation.remove(1);
//                            myPanelNavigation.add(new JLabel(String.valueOf(myTestAll[finalI][finalJ]), JLabel.CENTER), BorderLayout.CENTER);
                        }
                        public void mousePressed(java.awt.event.MouseEvent evt) {
                            myButtons[finalLl].setBackground(new Color(
                                    Integer.parseInt(MY_COLOR_JBUTTON_MOUSE_PRESSED_ALL[0]),
                                    Integer.parseInt(MY_COLOR_JBUTTON_MOUSE_PRESSED_ALL[1]),
                                    Integer.parseInt(MY_COLOR_JBUTTON_MOUSE_PRESSED_ALL[2])
                                    )
                            );
                        }

                        public void mouseReleased(java.awt.event.MouseEvent evt) {
                            myButtons[finalLl].setBackground(new Color(
                                            Integer.parseInt(MY_COLOR_JBUTTON_MOUSE_PRESSED_ALL[0]),
                                            Integer.parseInt(MY_COLOR_JBUTTON_MOUSE_PRESSED_ALL[1]),
                                            Integer.parseInt(MY_COLOR_JBUTTON_MOUSE_PRESSED_ALL[2])
                                    )
                            );
                        }
                        public void mouseExited(java.awt.event.MouseEvent evt) {
                            myButtons[finalLl].setBackground(new Color(
                                            Integer.parseInt(MY_COLOR_JBUTTON_MOUSE_EXCITED_ALL[0]),
                                            Integer.parseInt(MY_COLOR_JBUTTON_MOUSE_EXCITED_ALL[1]),
                                            Integer.parseInt(MY_COLOR_JBUTTON_MOUSE_EXCITED_ALL[2])
                                    )
                            );
//                            myPanelNavigation.remove(1);
//                            myPanelNavigation.add(new JLabel("", JLabel.CENTER), BorderLayout.CENTER);
                        }

                    });
                    kk++;
                }
            }
        }

        this.myPanelCat = new JPanel();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        JPanel myPanelJButtonArray = new JPanel();
//        myPanelJButtonArray.setLayout(new GridLayout(SpreadSheetDimensions[0], SpreadSheetDimensions[1], 7, 2));
        myPanelJButtonArray.setLayout(new GridLayout(NUMBER_OF_ROWS_MAX, SpreadSheetDimensions[1], 7, 2));
//        SpreadSheetDimensions[0] //Rows
//        SpreadSheetDimensions[1] //Columns

////////////////////////////////////////////////////////////////////////////////////////////////////
//////  (02.03)                      Add Action-Listeners to JButtons                             //
////////////////////////////////////////////////////////////////////////////////////////////////////
        ii = 0;
        jj = 0;
        kk = 0;
        for (int i = 0; i < SpreadSheetDimensions[0]; i++) {
            for (int j = 0; j < SpreadSheetDimensions[1]; j++) {
                if (j < 10 && i == 0) {
                    myPanelJButtonArray.add(myLabels[ii]);
                    ii++;
                } else if (myFieldnamesAll[i][j] == "") {
                    myPanelJButtonArray.add(myLabelsBlanks[jj]);
                    jj++;
                } else {
                    myButtons[kk].addActionListener(
                            JButtonsSetUpActionListener.setUpActionListener(i,
                                    myButtons[kk],
                                    myFieldnamesAll[i][j],
                                    myUrlAll[i][j]));

                    myButtons[kk].setSize(new Dimension(30, 50));//   setPreferredSize(new Dimension(30, 30));
                    myPanelJButtonArray.add(myButtons[kk]);
                    kk++;
                }
            }
        }

        if (NUMBER_OF_ROWS < NUMBER_OF_ROWS_MAX) {
            for (int rr = NUMBER_OF_ROWS; rr < (NUMBER_OF_ROWS_MAX-NUMBER_OF_ROWS)*NUMBER_OF_COLUMNS; rr++) {
//                System.out.println("rr: "+rr);
                    myPanelJButtonArray.add(new JLabel(""));
            }
        }



////////////////////////////////////////////////////////////////////////////////////////////////////
//////  (02.04)                      Define Main Layout for TabPanel                              //
////////////////////////////////////////////////////////////////////////////////////////////////////
        myPanelJButtonArray.setSize(500,500);

        JPanel myPanelCat = new JPanel();
        myPanelCat.setLayout(new GridBagLayout());

        myPanelNavigation.add(iconLabel, BorderLayout.SOUTH);
        GridBagConstraints myGridBag = new GridBagConstraints();

        myGridBag.fill = GridBagConstraints.VERTICAL;
        myGridBag.gridwidth = 1;
        myGridBag.weightx = .01;
        myGridBag.weighty = .01;
        myGridBag.gridx = 0;
        myGridBag.gridy = 0;

        myPanelJButtonArray.setBackground(new Color(
                Integer.parseInt(MY_COLOR_JBUTTON_ARRAY_BACKGROUND_ALL[0]),
                Integer.parseInt(MY_COLOR_JBUTTON_ARRAY_BACKGROUND_ALL[1]),
                Integer.parseInt(MY_COLOR_JBUTTON_ARRAY_BACKGROUND_ALL[2])
        ));

        Font myFontTabTitle = new Font(FONTNAME, Font.PLAIN, 22);

        this.myPanelCat = myPanelCat;

        this.myPanelCat.add(myPanelJButtonArray, myGridBag);
        this.myPanelCat.setSize(500,500);

        myGridBag.fill = GridBagConstraints.VERTICAL;
        myGridBag.gridx = 0;
        myGridBag.gridy = 1;

        this.myPanelCat.add(myPanelNavigation, myGridBag);
        this.myPanelCat.setBackground(new Color(
                Integer.parseInt(MY_COLOR_JTAB_BACKGROUND_ALL[0]),
                Integer.parseInt(MY_COLOR_JTAB_BACKGROUND_ALL[1]),
                Integer.parseInt(MY_COLOR_JTAB_BACKGROUND_ALL[2])
        ));

    }
}