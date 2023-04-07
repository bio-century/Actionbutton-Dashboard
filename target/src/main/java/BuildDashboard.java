import packageIconEditing.IconEditingImageTransform;
import packageJButtons.JButtonsSetUpActionListener;
import packageSpreadsheet.SpreadsheetReadCellData;
//import packageSpreadsheet.SpreadsheetReturnDimensions;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.*;

import java.io.IOException;

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

//    int[] SPREADSHEET_DIMESIONS = SpreadsheetReturnDimensions.SpreadsheetReturnDimensions(Main.USER_DIR_SPREADSHEETS, Main.SPREADSHEET_NAME);
    public int NUMBER_OF_ROWS = 6;
    public int NUMBER_OF_COLUMNS = 4;

    private JFrame myFrame;

    private JButton[] myButtons = new JButton[(NUMBER_OF_ROWS + 1) * NUMBER_OF_COLUMNS];
    private JLabel[] myLabels = new JLabel[(NUMBER_OF_ROWS + 1) * NUMBER_OF_COLUMNS];
    private JLabel[] myLabelsBlanks = new JLabel[(NUMBER_OF_ROWS + 1) * NUMBER_OF_COLUMNS];

    String[][] myFieldnamesAll;
    String[][] myCategoriesAll = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
    String[][] myUrlAll = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
    String[][] myColorAll = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];

    static Color myColorJButtonsBackground = new Color(0, 10, 52);
    static Color myColorJFrameBackground = new Color(0, 10, 52);
    public static Color myColorJTabbedPane = myColorJButtonsBackground;
    public static Color myColorJTabbedPaneFrame = new Color(76,15,200);

    public BuildDashboard(int w, int h, String USER_DIR_SPREADSHEETS, String SPREADSHEET_NAME, String FONTNAME,int NUMBER_OF_ROWS,
                          int NUMBER_OF_COLUMNS) throws IOException {
        myFieldnamesAll = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];

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

    }


    public void setUpGUI(int[] SpreadSheetDimensions,
                         int IMAGE_LOGO_WIDTH,
                         int IMAGE_LOGO_HEIGHT,
                         String USER_DIR_IMAGES,
                         String IMAGE_LOGO,
                         String USER_DIR_ICONS,
                         String FONTNAME,
                         int WIDTH,
                         int HEIGHT,
                         String FRAME_TITLE,
                         String CATEGORY_NAMES) {

        myFrame = new JFrame();
        myFrame.getContentPane().setBackground(myColorJFrameBackground);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        JPanel myPanelJButtonArray = new JPanel();
        JPanel myPanelCat2 = new JPanel();

        myPanelJButtonArray.setLayout(new GridLayout(SpreadSheetDimensions[0], SpreadSheetDimensions[1], 7, 2));
        myPanelCat2.setLayout(new GridLayout(1, SpreadSheetDimensions[1], 7, 2));
        myPanelJButtonArray.setPreferredSize(new Dimension(640, 480));

        myFrame.setSize(WIDTH, HEIGHT);
        myFrame.setTitle(FRAME_TITLE);
        myFrame.setResizable(false);

        int ii = 0;
        int jj = 0;
        int kk = 0;
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
                    myPanelJButtonArray.add(myButtons[kk]);
                    kk++;
                }
            }
        }

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

        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 1;
        myPanelCat1.add(myPanelNavigation, c);
        myPanelCat1.setBackground(myColorJTabbedPane);


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

        myFrame.add(myPanelCat1, BorderLayout.CENTER);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setJMenuBar(menubar);
        myFrame.setVisible(true);
    }
}