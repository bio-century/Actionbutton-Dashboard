package packageBuildDashboard;

import packageIconEditing.IconEditingImageTransform;
//import packageJButtons.JButtonArray;
import packageJButtons.JButtonsSetUpActionListener;
import packageSpreadsheet.SpreadsheetReadCellData;
//import packageSpreadsheet.SpreadsheetReturnDimensions;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.*;

import javax.swing.border.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.UIManager;

// sources:
// https://www.youtube.com/watch?v=816wduoH9eY
// https://coderanch.com/t/657887/java/Pausing-loop-wait-response-actionListener
// https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
// https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
// https://stackoverflow.com/questions/57075145/what-element-controls-the-color-of-the-thin-strip-between-jpanel-and-jtabbedpane
//https://stackoverflow.com/questions/15694107/how-to-layout-multiple-panels-on-a-jframe-java

public class BuildDashboard {

    private JFrame myFrame;

    static Color myColorJButtonsBackground = new Color(0, 10, 52);
    static Color myColorJFrameBackground = new Color(0, 10, 52);
    public static Color myColorJTabbedPane = myColorJButtonsBackground;
    public static Color myColorJTabbedPaneFrame = new Color(76,15,200);


    public void DashboardBuild(int w, int h, String USER_DIR_SPREADSHEETS, String SPREADSHEET_NAME, String FONTNAME, int NUMBER_OF_ROWS,
                               int NUMBER_OF_COLUMNS, int[] SpreadSheetDimensions,
                               int IMAGE_LOGO_WIDTH,
                               int IMAGE_LOGO_HEIGHT,
                               String USER_DIR_IMAGES,
                               String IMAGE_LOGO,
                               int WIDTH,
                               int HEIGHT,
                               String FRAME_TITLE,
                               String USER_DIR_ICONS) {
        String[][] myFieldnamesAll;
        myFieldnamesAll = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];


        JButton[] myButtons = new JButton[(NUMBER_OF_ROWS + 1) * NUMBER_OF_COLUMNS];
        JLabel[] myLabels = new JLabel[(NUMBER_OF_ROWS + 1) * NUMBER_OF_COLUMNS];
        JLabel[] myLabelsBlanks = new JLabel[(NUMBER_OF_ROWS + 1) * NUMBER_OF_COLUMNS];

        String[][] myCategoriesAll = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        String[][] myUrlAll = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        String[][] myColorAll = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];


        SpreadsheetReadCellData rc = new SpreadsheetReadCellData();
        Integer[] ColRowCounts = new Integer[NUMBER_OF_COLUMNS];
        for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
            ColRowCounts[j] = 0;
        }

        int ii = 0;
        int jj = 0;
        int kk = 0;

        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                ColRowCounts[j] = 0;
                myFieldnamesAll[i][j] = rc.ReadSpreadsheet(USER_DIR_SPREADSHEETS, SPREADSHEET_NAME, i, j, 0, 1);
                myCategoriesAll[i][j] = rc.ReadSpreadsheet(USER_DIR_SPREADSHEETS, SPREADSHEET_NAME, i, j, 1, 1);
                myUrlAll[i][j] = rc.ReadSpreadsheet(USER_DIR_SPREADSHEETS, SPREADSHEET_NAME, i, j, 2, 1);
                myColorAll[i][j] = rc.ReadSpreadsheet(USER_DIR_SPREADSHEETS, SPREADSHEET_NAME, i, j, 3, 1);
                if (myFieldnamesAll[i][j] == "") {
                } else {
                    ColRowCounts[j] = ColRowCounts[j] + 1;
                }

                if (j < NUMBER_OF_COLUMNS && i == 0) {
                    String colorallfg;
                    colorallfg = rc.ReadSpreadsheet(USER_DIR_SPREADSHEETS, SPREADSHEET_NAME, 1, j, 3, 1);
                    String[] mySpreadSheetColorRGB = colorallfg.split(",");

                    int mySpreadSheetColorR;
                    int mySpreadSheetColorG;
                    int mySpreadSheetColorB;

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
                    myButtons[kk].setBackground(myColorJButtonsBackground);
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
                    Border border = new LineBorder(new Color(values_int1, values_int2, values_int3), 1);
                    myButtons[kk].setBorder(border);


                    int finalLl = kk;
                    myButtons[kk].addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseEntered(java.awt.event.MouseEvent evt) {
                            myButtons[finalLl].setBackground(myColorJTabbedPaneFrame);
                        }

                        public void mouseExited(java.awt.event.MouseEvent evt) {
                            myButtons[finalLl].setBackground(myColorJButtonsBackground);
                        }
                    });
                    kk++;
                }
            }
        }






        myFrame = new JFrame();
        myFrame.getContentPane().setBackground(myColorJFrameBackground);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        JPanel myPanelCat2 = new JPanel();

        JPanel myPanelJButtonArray = new JPanel();
        myPanelJButtonArray.setLayout(new GridLayout(SpreadSheetDimensions[0], SpreadSheetDimensions[1], 7, 2));
        myPanelCat2.setLayout(new GridLayout(1, SpreadSheetDimensions[1], 7, 2));
        myPanelJButtonArray.setPreferredSize(new Dimension(640, 480));

        JPanel myPanelJButtonArray2 = new JPanel();
        myPanelJButtonArray2.setLayout(new GridLayout(SpreadSheetDimensions[0], SpreadSheetDimensions[1], 7, 2));
        myPanelCat2.setLayout(new GridLayout(1, SpreadSheetDimensions[1], 7, 2));
        myPanelJButtonArray2.setPreferredSize(new Dimension(640, 480));

        ii = 0;
        jj = 0;
        kk = 0;
        for (int i = 0; i < SpreadSheetDimensions[0]; i++) {
            for (int j = 0; j < SpreadSheetDimensions[1]; j++) {
                if (j < 10 && i == 0) {
                    myPanelJButtonArray.add(myLabels[ii]);
                    myPanelJButtonArray2.add(myLabels[ii]);
                    ii++;
                } else if (myFieldnamesAll[i][j] == "") {
                    myPanelJButtonArray.add(myLabelsBlanks[jj]);
                    myPanelJButtonArray2.add(myLabelsBlanks[jj]);
                    jj++;
                } else {
                    myButtons[kk].addActionListener(
                            JButtonsSetUpActionListener.setUpActionListener(i,
                                    myButtons[kk],
                                    myFieldnamesAll[i][j],
                                    myUrlAll[i][j]));
                    myPanelJButtonArray.add(myButtons[kk]);
                    myPanelJButtonArray2.add(myButtons[kk]);
                    kk++;
                }
            }
        }

        myFrame.setSize(WIDTH, HEIGHT);
        myFrame.setTitle(FRAME_TITLE);
        myFrame.setResizable(false);



        myPanelJButtonArray.setBackground(myColorJTabbedPane);

        JTabbedPane tabpane = new JTabbedPane(JTabbedPane.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);
        tabpane.setBackground(new Color(76,15, 200));
        UIManager.put("TabbedPane.contentBorderInsets", new InsetsUIResource(1, 0,0, 0));
        UIManager.put("TabbedPane.contentAreaColor", new ColorUIResource(myColorJTabbedPaneFrame));
        SwingUtilities.updateComponentTreeUI(tabpane);

        JPanel myPanelCat1 = new JPanel();
        myPanelCat1.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        ImageIcon myImageLogo = IconEditingImageTransform.ImageTransform(IMAGE_LOGO_WIDTH, IMAGE_LOGO_HEIGHT, USER_DIR_IMAGES + IMAGE_LOGO);

        JPanel myPanelNavigation = new JPanel(new BorderLayout());
        JLabel iconLabel = new JLabel(myImageLogo);
        iconLabel.setVerticalAlignment(JLabel.NORTH);
        myPanelNavigation.setBackground(myColorJTabbedPane);
        myPanelNavigation.add(iconLabel, BorderLayout.SOUTH);

        c.fill = GridBagConstraints.VERTICAL;
        c.gridwidth = 1;
        c.weightx = .01;
        c.weighty = .01;
        c.gridx = 0;
        c.gridy = 0;
        myPanelCat1.add(myPanelJButtonArray, c);




        String arr1 = new String();
        String arr2 = new String();
        String arr3 = new String();
        arr1="hdd.png";
        arr2="Tab1";
        arr3="category 1";

//        for (int l = 0; l < 1; l++) {
        JLabel myJLabel1 = new JLabel(arr2);
        myJLabel1.setHorizontalTextPosition(JLabel.TRAILING);
        ImageIcon myIconCat = IconEditingImageTransform.ImageTransform(30, 30, USER_DIR_ICONS + arr1);
        myJLabel1.setIcon(myIconCat);
        Font myFontTabTitle = new Font(FONTNAME, Font.PLAIN, 22);
        tabpane.setFont(myFontTabTitle);

        UIManager.put("TabbedPane.selected", new Color(76,135,200));

        JMenuBar menubar;
        menubar = new JMenuBar();
        menubar.setOpaque(true);
        menubar.setBackground(Color.green);


        JPanel[] myPanelCat3 = new JPanel[3];
        myPanelCat3[0]=myPanelCat1;
        myPanelCat3[1]=myPanelCat1;
        myPanelCat3[2]=myPanelCat1;


        myPanelCat3[0].add(myPanelJButtonArray, c);
        myPanelCat3[1].add(myPanelJButtonArray2, c);
        myPanelCat3[2].add(myPanelJButtonArray, c);



        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 1;


        myPanelCat3[0].add(myPanelNavigation, c);
        myPanelCat3[0].setBackground(myColorJTabbedPane);
        myPanelCat3[1].add(myPanelNavigation, c);
        myPanelCat3[1].setBackground(myColorJTabbedPane);
        myPanelCat3[2].add(myPanelNavigation, c);
        myPanelCat3[2].setBackground(myColorJTabbedPane);

        myPanelCat3[0].add(myPanelNavigation, c);
        myPanelCat3[0].setBackground(myColorJTabbedPane);



        String[] arr4 = new String[3];
        String[] arr5 = new String[3];
        String[] arr6 = new String[3];
        arr4[0]="hdd.png";
        arr4[1]="globe.png";
        arr4[2]="house.png";
        arr5[0]="Tab1";
        arr5[1]="Tab2";
        arr5[2]="Tab2";
        arr6[0]="category 1";
        arr6[1]="category 2";
        arr6[2]="category 3";


        ImageIcon myIconCat2 = IconEditingImageTransform.ImageTransform(30, 30, USER_DIR_ICONS + arr4[0]);
        myJLabel1.setIcon(myIconCat);
        ImageIcon myIconCat3 = IconEditingImageTransform.ImageTransform(30, 30, USER_DIR_ICONS + arr4[1]);
        myJLabel1.setIcon(myIconCat);
        ImageIcon myIconCat4 = IconEditingImageTransform.ImageTransform(30, 30, USER_DIR_ICONS + arr4[2]);
        myJLabel1.setIcon(myIconCat);


        JTabbedPane tabpane1 = new JTabbedPane();
        tabpane1.setBackground(new Color(76,15, 200));


        JPanel panel1, panel2, panel3, panel4, panel5;
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();


        JButton myButtonstwo = new JButton("blah");
        panel1.add(myButtonstwo);

        tabpane1.addTab("  " + "one" + " ", myIconCat2, myPanelCat3[0]);
        tabpane1.addTab("  " + "two" + " ", myIconCat2, panel1);
        tabpane1.addTab("  " + "three" + " ", myIconCat4, myPanelCat3[1]);
        tabpane1.addTab("  " + "four" + " ", myIconCat3, myPanelCat3[1]);



//        tabpane1.addTab("  " + "kljlkj" + " ", myIconCat2, myPanelCat3[0]);
//        tabpane1.addTab("  " +  "zutuz" + " ", myIconCat3, myPanelCat3[1]);

        myFrame.add(tabpane1, BorderLayout.CENTER);
//        myFrame.add(tabpane1, BorderLayout.CENTER);
//        myFrame.add(tabpane1, BorderLayout.CENTER);
//        myFrame.add(tabpane2, BorderLayout.CENTER);
//        myFrame.add(tabpane3, BorderLayout.CENTER);

//        myFrame.add(myPanelCat1, BorderLayout.CENTER);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setJMenuBar(menubar);
        myFrame.setVisible(true);
    }
}