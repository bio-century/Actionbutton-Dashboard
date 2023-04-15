import com.formdev.flatlaf.FlatDarkLaf;
import org.apache.commons.io.FileUtils;
import packageBuildDashboard.BuildDashboard;
import packageIconEditing.IconEditingImageTransform;
//import packageSpreadsheet.SpreadsheetReturnDimensions;


import java.awt.*;
import java.io.*;
import java.util.Properties;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;

import static javax.swing.UIManager.*;






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
// https://stackoverflow.com/questions/4871051/how-to-get-the-current-working-directory-in-java
// https://stackoverflow.com/questions/13438871/log4j2-configuring
// https://mkyong.com/java/apache-poi-reading-and-writing-excel-file-in-java/
// https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml/3.9
// https://www.javatpoint.com/how-to-read-excel-file-in-java
// https://stackoverflow.com/questions/2194284/how-to-get-the-last-column-index-reading-excel-file
// https://poi.apache.org/apidocs/dev/org/apache/poi/hssf/usermodel/HSSFRow.html#getLastCellNum--
public class Main {
    static String USER_DIR = System.getProperty("user.dir");
    public static String USER_DIR_SPREADSHEETS = USER_DIR + "\\src\\main\\resources\\spreadsheetFiles";
    public static String SPREADSHEET_NAME = "\\BUTTON_AUTOSTART.xlsx";

    public static void main(String[] args) throws IOException {
//        int[] SpreadSheetDimensions = SpreadsheetReturnDimensions.SpreadsheetReturnDimensions(USER_DIR_SPREADSHEETS,SPREADSHEET_NAME);
//        System.out.println("ROWnumber:" + String.valueOf(SpreadSheetDimensions[0]));
//        System.out.println("COLnumber:" + String.valueOf(SpreadSheetDimensions[1]));

        try {
            setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        try {
            String PATH_CONFIG_FILE = USER_DIR + "\\src\\main\\resources\\config.properties";
            FileInputStream propsInput = new FileInputStream(PATH_CONFIG_FILE);
            Properties prop = new Properties();
            prop.load(propsInput);


            // File Paths
            String USER_DIR_JAVA = USER_DIR + prop.getProperty("USER_DIR_JAVA");
            String USER_DIR_SPREADSHEETS = USER_DIR + prop.getProperty("USER_DIR_SPREADSHEETS");
            String USER_DIR_ICONS = USER_DIR + prop.getProperty("USER_DIR_ICONS");
            String USER_DIR_IMAGES = USER_DIR + prop.getProperty("USER_DIR_IMAGES");

            // Frame Title
            String FRAME_TITLE = prop.getProperty("FRAME_TITLE");

            // Spreadsheet specifications
            final int NUMBER_OF_ROWS = Integer.parseInt(prop.getProperty("NUMBER_OF_ROWS"));
            final int NUMBER_OF_COLUMNS = Integer.parseInt(prop.getProperty("NUMBER_OF_COLUMNS"));

            // Layout Specifigations
            String FONTNAME = prop.getProperty("FONTNAME");
            int NUMBER_OF_ROWS_WINDOW_EXPANSION_FACTOR = Integer.parseInt(prop.getProperty("NUMBER_OF_ROWS_WINDOW_EXPANSION_FACTOR"));
            int NUMBER_OF_COLUMNS_WINDOW_EXPANSION_FACTOR = Integer.parseInt(prop.getProperty("NUMBER_OF_COLUMNS_WINDOW_EXPANSION_FACTOR"));

            // Company logo specifications
            String IMAGE_LOGO = prop.getProperty("IMAGE_LOGO");
            int IMAGE_LOGO_WIDTH = Integer.parseInt(prop.getProperty("IMAGE_LOGO_WIDTH"));
            int IMAGE_LOGO_HEIGHT = Integer.parseInt(prop.getProperty("IMAGE_LOGO_HEIGHT"));

            System.out.println("\n");
            System.out.println("/////////////////////////////////////////////////////\n" +
                    "// CONFIG FILE DEFINING THE ACTIONBUTTON-DASHBOARD //\n" +
                    "/////////////////////////////////////////////////////");

            // File Paths
            System.out.println("File Paths:");
            System.out.println("USER_DIR_JAVA: " + USER_DIR_JAVA);
            System.out.println("USER_DIR_SPREADSHEETS: " + USER_DIR_SPREADSHEETS);
            System.out.println("USER_DIR_ICONS: " + USER_DIR_ICONS);
            System.out.println("USER_DIR_IMAGES: " + USER_DIR_IMAGES);
            System.out.println("SPREADSHEET_NAME: " + SPREADSHEET_NAME);

            // Frame Title
            System.out.println("FRAME_TITLE: " + FRAME_TITLE);

            // Spreadsheet Specifications
            System.out.println("Spreadsheet Specifications:");
            System.out.println("SPREADSHEET_NAME: " + SPREADSHEET_NAME);

            // Layout Specifications
            System.out.println("Layout Specifications:");
            System.out.println("FONTNAME: " + FONTNAME);
            System.out.println("NUMBER_OF_ROWS_WINDOW_EXPANSION_FACTOR: " + NUMBER_OF_ROWS_WINDOW_EXPANSION_FACTOR);
            System.out.println("NUMBER_OF_COLUMNS_WINDOW_EXPANSION_FACTOR: " + NUMBER_OF_COLUMNS_WINDOW_EXPANSION_FACTOR);

            // LCompany logo specifications
            System.out.println("Company logo specifications:");
            System.out.println("IMAGE_LOGO: " + IMAGE_LOGO);
            System.out.println("IMAGE_LOGO_WIDTH: " + IMAGE_LOGO_WIDTH);
            System.out.println("IMAGE_LOGO_HEIGHT: " + IMAGE_LOGO_HEIGHT);
            System.out.println("\n");


            final int FILE_NUMBER = new File(USER_DIR_SPREADSHEETS).listFiles().length;
            String datastring[] = new String[FILE_NUMBER];

            System.out.println("Files in Spreadsheet-Folder:");
            File folder = new File(USER_DIR_SPREADSHEETS);

            String CATEGORY_NAMES[] = new String[FILE_NUMBER];
            String SPREADSHEET_ALL[] = new String[FILE_NUMBER];

            int aa = 0;
            for (File file : folder.listFiles()) {
                datastring[aa] = file.getName();
                int FILE_NAME_LENGTH = datastring[aa].length();
//                System.out.println(datastring[aa].substring(0, FILE_NAME_LENGTH-0));
                CATEGORY_NAMES[aa] = datastring[aa].substring(0, FILE_NAME_LENGTH - 5);
                SPREADSHEET_ALL[aa] = USER_DIR_SPREADSHEETS + "\\" + datastring[aa].substring(0, FILE_NAME_LENGTH-0);
                System.out.println(SPREADSHEET_ALL[aa]);
                aa++;
            }


//            BuildDashboard BD = new BuildDashboard(NUMBER_OF_COLUMNS * NUMBER_OF_COLUMNS_WINDOW_EXPANSION_FACTOR,
//                    NUMBER_OF_ROWS * NUMBER_OF_ROWS_WINDOW_EXPANSION_FACTOR,
//                    USER_DIR_SPREADSHEETS,
//                    SPREADSHEET_NAME,
//                    FONTNAME,
//                    NUMBER_OF_ROWS,
//                    NUMBER_OF_COLUMNS,
//                    new int[]{NUMBER_OF_ROWS, NUMBER_OF_COLUMNS},
//                    IMAGE_LOGO_WIDTH,
//                    IMAGE_LOGO_HEIGHT,
//                    USER_DIR_IMAGES,
//                    IMAGE_LOGO,
//                    NUMBER_OF_COLUMNS * NUMBER_OF_COLUMNS_WINDOW_EXPANSION_FACTOR + 400,
//                    NUMBER_OF_ROWS * NUMBER_OF_ROWS_WINDOW_EXPANSION_FACTOR + 50,
//                    FRAME_TITLE,
//                    USER_DIR_ICONS);
//            JPanel jPanel = BD.myPanelCat3[1];
//
//            BuildDashboard BD2 = new BuildDashboard(NUMBER_OF_COLUMNS * NUMBER_OF_COLUMNS_WINDOW_EXPANSION_FACTOR,
//                    NUMBER_OF_ROWS * NUMBER_OF_ROWS_WINDOW_EXPANSION_FACTOR,
//                    USER_DIR_SPREADSHEETS,
//                    SPREADSHEET_NAME,
//                    FONTNAME,
//                    NUMBER_OF_ROWS,
//                    NUMBER_OF_COLUMNS,
//                    new int[]{NUMBER_OF_ROWS, NUMBER_OF_COLUMNS},
//                    IMAGE_LOGO_WIDTH,
//                    IMAGE_LOGO_HEIGHT,
//                    USER_DIR_IMAGES,
//                    IMAGE_LOGO,
//                    NUMBER_OF_COLUMNS * NUMBER_OF_COLUMNS_WINDOW_EXPANSION_FACTOR + 400,
//                    NUMBER_OF_ROWS * NUMBER_OF_ROWS_WINDOW_EXPANSION_FACTOR + 50,
//                    FRAME_TITLE,
//                    USER_DIR_ICONS);
//            JPanel jPanel2 = BD2.myPanelCat3[1];

//            BD.BuildDashboard(NUMBER_OF_COLUMNS * NUMBER_OF_COLUMNS_WINDOW_EXPANSION_FACTOR,
//                    NUMBER_OF_ROWS * NUMBER_OF_ROWS_WINDOW_EXPANSION_FACTOR,
//                    USER_DIR_SPREADSHEETS,
//                    SPREADSHEET_NAME,
//                    FONTNAME,
//                    NUMBER_OF_ROWS,
//                    NUMBER_OF_COLUMNS,
//                    new int[]{NUMBER_OF_ROWS, NUMBER_OF_COLUMNS},
//                    IMAGE_LOGO_WIDTH,
//                    IMAGE_LOGO_HEIGHT,
//                    USER_DIR_IMAGES,
//                    IMAGE_LOGO,
//                    NUMBER_OF_COLUMNS * NUMBER_OF_COLUMNS_WINDOW_EXPANSION_FACTOR + 400,
//                    NUMBER_OF_ROWS * NUMBER_OF_ROWS_WINDOW_EXPANSION_FACTOR+50,
//                    FRAME_TITLE,
//                    USER_DIR_ICONS);
            JTabbedPane tabpane1 = new JTabbedPane();
            tabpane1.setBackground(new Color(76, 15, 200));

//            tabpane1.addTab("  " + "three" + " ", jPanel);
//            tabpane1.addTab("  " + "two" + " ", jPanel2);

            BuildDashboard[] BD3 = new BuildDashboard[aa];
            JPanel[] jPanel3 = new JPanel[aa];

            System.out.println("aa is currently: " + String.valueOf(aa));

            for (int i = 0; i < aa; i++) {

                BD3[i] = new BuildDashboard(NUMBER_OF_COLUMNS * NUMBER_OF_COLUMNS_WINDOW_EXPANSION_FACTOR,
                        NUMBER_OF_ROWS * NUMBER_OF_ROWS_WINDOW_EXPANSION_FACTOR,
                        USER_DIR_SPREADSHEETS,
                        SPREADSHEET_NAME,
                        FONTNAME,
                        NUMBER_OF_ROWS,
                        NUMBER_OF_COLUMNS,
                        new int[]{NUMBER_OF_ROWS, NUMBER_OF_COLUMNS},
                        IMAGE_LOGO_WIDTH,
                        IMAGE_LOGO_HEIGHT,
                        USER_DIR_IMAGES,
                        IMAGE_LOGO,
                        NUMBER_OF_COLUMNS * NUMBER_OF_COLUMNS_WINDOW_EXPANSION_FACTOR + 400,
                        NUMBER_OF_ROWS * NUMBER_OF_ROWS_WINDOW_EXPANSION_FACTOR + 50,
                        FRAME_TITLE,
                        USER_DIR_ICONS,
                        SPREADSHEET_ALL[i]);
                jPanel3[i] = BD3[i].myPanelCat3[1];

                System.out.println("i is currently: " + String.valueOf(i));
                tabpane1.addTab("  " + "three" + " ", jPanel3[i]);
            }


//            BD.myFrame

//            return BD;

            JFrame myFrame;
            Color myColorJFrameBackground = new Color(0, 10, 52);

            int WIDTH = NUMBER_OF_COLUMNS * NUMBER_OF_COLUMNS_WINDOW_EXPANSION_FACTOR + 400;
            int HEIGHT = NUMBER_OF_ROWS * NUMBER_OF_ROWS_WINDOW_EXPANSION_FACTOR + 50;


            myFrame = new JFrame();
            myFrame.getContentPane().setBackground(myColorJFrameBackground);

            myFrame.setSize(WIDTH, HEIGHT);
            myFrame.setTitle(FRAME_TITLE);
            myFrame.setResizable(false);


            JMenuBar menubar;
            menubar = new JMenuBar();
            menubar.setOpaque(true);
            menubar.setBackground(Color.green);
            myFrame.add(tabpane1, BorderLayout.CENTER);

            myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myFrame.setJMenuBar(menubar);
            myFrame.setVisible(true);


// insert myframe here...
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: FileNotFoundException");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("ERROR: IOException");
            e.printStackTrace();
        }
    }
}