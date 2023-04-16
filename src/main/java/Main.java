import com.formdev.flatlaf.FlatDarkLaf;
import packageBuildDashboard.BuildDashboard;
import packageIconEditing.IconEditingImageTransform;

import java.awt.*;
import java.io.*;
import java.util.Properties;
import javax.swing.*;
import static javax.swing.UIManager.*;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


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

        try {
            setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        try {

//            UIManager.put( "control" , Color.green );
//            UIManager.put( "nimbusAlertYellow" , Color.green );
//            UIManager.put( "nimbusBase" , Color.green );
//            UIManager.put( "nimbusDisabledText" , Color.green );
//            UIManager.put( "nimbusFocus" , Color.green );
//            UIManager.put( "nimbusGreen" , Color.green );
//            UIManager.put( "nimbusInfoBlue" , Color.green );
//            UIManager.put( "nimbusRed",Color.green );
//            UIManager.put( "nimbusSelectionBackground",
//                    Color.green );
//
//            UIManager.put( "background" ,Color.green );
//            UIManager.put( "controlDkShadow" , Color.green );
//            UIManager.put( "controlShadow", Color.green );
//            UIManager.put( "desktop", Color.green );
//            UIManager.put( "menu", Color.green );
//            UIManager.put( "nimbusBorder", Color.green );
//            UIManager.put( "nimbusSelection", Color.green );
//            UIManager.put( "textBackground", Color.green );
//            UIManager.put( "textHighlight", Color.green );
//            UIManager.put( "textInactiveText", Color.green );
//
//            // panel
//            UIManager.put( "Panel.background", Color.green );
//            UIManager.put( "Panel.disabled", Color.green );
//            UIManager.put( "Panel.font", Color.green );
//            UIManager.put( "Panel.opaque", true );
//
//            // button
//            UIManager.put( "Button.background",Color.green );
//            UIManager.put( "Button.disabled", Color.green );
//            UIManager.put( "Button.disabledText", Color.green );
////            UIManager.put( "Button.font", UIConstants.DEFAULT_FONT );
//
//            // menu
//            UIManager.put( "Menu.background", Color.green );
//            UIManager.put( "Menu.disabled",Color.green );
//            UIManager.put( "Menu.disabledText", Color.green );
////            UIManager.put( "Menu.font", UIConstants.MENU_FONT );
//            UIManager.put( "Menu.foreground", Color.green );
//            UIManager.put( "Menu[Disabled].textForeground",
//                    Color.green );
//            UIManager.put( "Menu[Enabled].textForeground", Color.green );
//            UIManager.put( "MenuBar.background", Color.green );
//            UIManager.put( "MenuBar.disabled", Color.green );
////            UIManager.put( "MenuBar.font", UIConstants.MENU_FONT );
//            UIManager.put( "MenuBar:Menu[Disabled].textForeground",
//                    Color.green );
//            UIManager.put( "MenuBar:Menu[Enabled].textForeground",
//                    Color.green );
//            UIManager.put( "MenuItem.background", Color.green );
//            UIManager.put( "MenuItem.disabled", Color.green );
//            UIManager.put( "MenuItem.disabledText", Color.green );
////            UIManager.put( "MenuItem.font", UIConstants.MENU_FONT );
//            UIManager.put( "MenuItem.foreground", Color.green );
//            UIManager.put( "MenuItem[Disabled].textForeground",
//                    Color.green );
//            UIManager.put( "MenuItem[Enabled].textForeground",
//                    Color.green );
//
//            // tree
//            UIManager.put( "Tree.background", Color.green );



            // Read In Configuration File
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

            String MY_COLOR_LOGO_BACKGROUND = prop.getProperty("MY_COLOR_LOGO_BACKGROUND");
            String MY_COLOR_LOGO_BACKGROUND_TRIMMED = MY_COLOR_LOGO_BACKGROUND.replaceAll(" ","");
            String[] MY_COLOR_LOGO_BACKGROUND_ALL = MY_COLOR_LOGO_BACKGROUND_TRIMMED.split(",");

            String MY_COLOR_JBUTTON_BACKGROUND = prop.getProperty("MY_COLOR_JBUTTON_BACKGROUND");
            String MY_COLOR_JBUTTON_BACKGROUND_TRIMMED = MY_COLOR_JBUTTON_BACKGROUND.replaceAll(" ","");
            String[] MY_COLOR_JBUTTON_BACKGROUND_ALL = MY_COLOR_JBUTTON_BACKGROUND_TRIMMED.split(",");

            String MY_COLOR_JBUTTON_MOUSE_OVER = prop.getProperty("MY_COLOR_JBUTTON_MOUSE_OVER");
            String MY_COLOR_JBUTTON_MOUSE_OVER_TRIMMED = MY_COLOR_JBUTTON_MOUSE_OVER.replaceAll(" ","");
            String[] MY_COLOR_JBUTTON_MOUSE_OVER_ALL = MY_COLOR_JBUTTON_MOUSE_OVER_TRIMMED.split(",");

            String MY_COLOR_JBUTTON_MOUSE_PRESSED = prop.getProperty("MY_COLOR_JBUTTON_MOUSE_PRESSED");
            String MY_COLOR_JBUTTON_MOUSE_PRESSED_TRIMMED = MY_COLOR_JBUTTON_MOUSE_PRESSED.replaceAll(" ","");
            String[] MY_COLOR_JBUTTON_MOUSE_PRESSED_ALL = MY_COLOR_JBUTTON_MOUSE_PRESSED_TRIMMED.split(",");

            String MY_COLOR_JBUTTON_MOUSE_EXCITED = prop.getProperty("MY_COLOR_JBUTTON_MOUSE_EXCITED");
            String MY_COLOR_JBUTTON_MOUSE_EXCITED_TRIMMED = MY_COLOR_JBUTTON_MOUSE_EXCITED.replaceAll(" ","");
            String[] MY_COLOR_JBUTTON_MOUSE_EXCITED_ALL = MY_COLOR_JBUTTON_MOUSE_EXCITED_TRIMMED.split(",");

            String MY_COLOR_JBUTTON_ARRAY_BACKGROUND = prop.getProperty("MY_COLOR_JBUTTON_ARRAY_BACKGROUND");
            String MY_COLOR_JBUTTON_ARRAY_BACKGROUND_TRIMMED = MY_COLOR_JBUTTON_ARRAY_BACKGROUND.replaceAll(" ","");
            String[] MY_COLOR_JBUTTON_ARRAY_BACKGROUND_ALL = MY_COLOR_JBUTTON_ARRAY_BACKGROUND_TRIMMED.split(",");

            String MY_COLOR_JTAB_BACKGROUND = prop.getProperty("MY_COLOR_JTAB_BACKGROUND");
            String MY_COLOR_JTAB_BACKGROUND_TRIMMED = MY_COLOR_JTAB_BACKGROUND.replaceAll(" ","");
            String[] MY_COLOR_JTAB_BACKGROUND_ALL = MY_COLOR_JTAB_BACKGROUND_TRIMMED.split(",");

            String MY_FRAME_BACKGROUND = prop.getProperty("MY_FRAME_BACKGROUND");
            String MY_FRAME_BACKGROUND_TRIMMED = MY_FRAME_BACKGROUND.replaceAll(" ","");
            String[] MY_FRAME_BACKGROUND_ALL = MY_FRAME_BACKGROUND_TRIMMED.split(",");



            // Tab Icons
            String TAB_ICON_NAME = prop.getProperty("TAB_ICON_NAME");
            String TAB_ICON_NAME_TRIMMED = TAB_ICON_NAME.replaceAll(" ","");
            String[] TAB_ICON_NAME_ALL = TAB_ICON_NAME_TRIMMED.split(",");


            // Company Logo Specifications
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
            System.out.println("MY_COLOR_LOGO_BACKGROUND: " + MY_COLOR_LOGO_BACKGROUND);
            System.out.println("MY_COLOR_JBUTTON_BACKGROUND: " + MY_COLOR_JBUTTON_BACKGROUND);
            System.out.println("MY_COLOR_JBUTTON_ARRAY_BACKGROUND: " + MY_COLOR_JBUTTON_ARRAY_BACKGROUND);


            // Tab Icons Specifications
            System.out.println("Tab Icons Specifications:");
            System.out.println("TAB_ICON_NAME: " + TAB_ICON_NAME);
            System.out.println("\n");


            // Company Logo Specifications
            System.out.println("Company Logo Specifications:");
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

//            myTabbedPane.setBackground(new Color(100, 10, 52));

            BuildDashboard[] BD = new BuildDashboard[aa];
            JPanel[] JPanel = new JPanel[aa];

            JTabbedPane myTabbedPane = new JTabbedPane();
//            JTabbedPane[] myTabbedPane = new JTabbedPane[aa];

            System.out.println("aa is currently: " + String.valueOf(aa));

            ImageIcon[] TAB_ICON = new ImageIcon[aa];

            for (int i = 0; i < aa; i++) {

                BD[i] = new BuildDashboard(NUMBER_OF_COLUMNS * NUMBER_OF_COLUMNS_WINDOW_EXPANSION_FACTOR,
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
                        SPREADSHEET_ALL[i],
                        MY_COLOR_LOGO_BACKGROUND_ALL,
                        MY_COLOR_JBUTTON_BACKGROUND_ALL,
                        MY_COLOR_JBUTTON_MOUSE_OVER_ALL,
                        MY_COLOR_JBUTTON_MOUSE_PRESSED_ALL,
                        MY_COLOR_JBUTTON_MOUSE_EXCITED_ALL,
                        MY_COLOR_JBUTTON_ARRAY_BACKGROUND_ALL,
                        MY_COLOR_JTAB_BACKGROUND_ALL
                        );

//                UIManager.put("ToggleButton.contentMargins", Color.green);
//                UIManager.put("TabbedPane.extendTabsToBase", Color.green);
//                UIManager.put("TabbedPane.foreground", Color.green);
//                UIManager.put("TabbedPane.highlight", Color.green);
//                UIManager.put("TabbedPane.isTabRollover", Color.green);
//                UIManager.put("TabbedPane.shadow", Color.green);
//                UIManager.put("TabbedPane.tabOverlap", Color.green);
//                UIManager.put("InternalFrame.background", Color.green);
//                UIManager.put("InternalFrame.foreground", Color.green);
//                UIManager.put("InternalFrameTitlePane.background", Color.green);
//                UIManager.put("InternalFrameTitlePane.contentMargins", Color.green);
//                UIManager.put("InternalFrameTitlePane.disabled", Color.green);
//                UIManager.put("InternalFrameTitlePane.foreground", Color.green);
//                UIManager.put("", Color.green);
//                UIManager.put("", Color.green);
//                UIManager.put("", Color.green);

                UIManager.put("SplitPane.border", Color.blue);
                JPanel[i] = BD[i].myPanelCat;
                JPanel[i].setSize(300,300);
                TAB_ICON[i] = IconEditingImageTransform.ImageTransform(30, 30, USER_DIR_ICONS + TAB_ICON_NAME_ALL[i]);
                UIManager.put("TabbedPane.selected", new Color(176,135,200));

                System.out.println(String.valueOf(i));


                int finalLl = i;
//                JPanel[i].addMouseListener(new java.awt.event.MouseAdapter() {
//                                    public void mouseEntered(java.awt.event.MouseEvent evt) {
//                                        JPanel[finalLl].setBackground(Color.green);
//                }
//                public void mousePressed(java.awt.event.MouseEvent evt) {
//                    JPanel[i].setBackground(new Color(
//                                    Integer.parseInt(MY_COLOR_JBUTTON_MOUSE_PRESSED_ALL[0]),
//                                    Integer.parseInt(MY_COLOR_JBUTTON_MOUSE_PRESSED_ALL[1]),
//                                    Integer.parseInt(MY_COLOR_JBUTTON_MOUSE_PRESSED_ALL[2])
//                            )
//                    );
//                }
//                    public void mouseExited(java.awt.event.MouseEvent evt) {
//                        JPanel[finalLl].setBackground(Color.green
//                        );
//                    }
//                });


                myTabbedPane.addTab(" " + CATEGORY_NAMES[i] + " ", TAB_ICON[i], JPanel[i]);
                myTabbedPane.setBackground(new Color(
                        Integer.parseInt(MY_COLOR_JTAB_BACKGROUND_ALL[0]),
                        Integer.parseInt(MY_COLOR_JTAB_BACKGROUND_ALL[1]),
                        Integer.parseInt(MY_COLOR_JTAB_BACKGROUND_ALL[2])
                ));


//                myTabbedPane[i].addTab(" " + CATEGORY_NAMES[i] + " ", TAB_ICON[i], JPanel[i]);
//                myTabbedPane[i].setBackground(new Color(
//                        Integer.parseInt(MY_COLOR_JTAB_BACKGROUND_ALL[0]),
//                        Integer.parseInt(MY_COLOR_JTAB_BACKGROUND_ALL[1]),
//                        Integer.parseInt(MY_COLOR_JTAB_BACKGROUND_ALL[2])
//                ));





//                myTabbedPane[i].setSize(300,300);
            }



//            myTabbedPane.setBackground(Color.green);




            JFrame myFrame;

            int WIDTH = NUMBER_OF_COLUMNS * NUMBER_OF_COLUMNS_WINDOW_EXPANSION_FACTOR + 400;
            int HEIGHT = NUMBER_OF_ROWS * NUMBER_OF_ROWS_WINDOW_EXPANSION_FACTOR + 50;

            myFrame = new JFrame();
//            myFrame.getContentPane().setBackground(new Color(
//                    Integer.parseInt(MY_FRAME_BACKGROUND_ALL[0]),
//                    Integer.parseInt(MY_FRAME_BACKGROUND_ALL[1]),
//                    Integer.parseInt(MY_FRAME_BACKGROUND_ALL[2])
//            ));
//
//            myFrame.getContentPane().setForeground(new Color(
//                    Integer.parseInt(MY_FRAME_BACKGROUND_ALL[0]),
//                    Integer.parseInt(MY_FRAME_BACKGROUND_ALL[1]),
//                    Integer.parseInt(MY_FRAME_BACKGROUND_ALL[2])
//            ));

            myFrame.setSize(WIDTH, HEIGHT);
            myFrame.setTitle(FRAME_TITLE);
            myFrame.setResizable(false);

            JMenuBar menubar;
            menubar = new JMenuBar();
            menubar.setOpaque(true);
//            menubar.setBackground(Color.green);
            menubar.setBackground(Color.green);
            menubar.setForeground(Color.green);
            myFrame.add(myTabbedPane, BorderLayout.CENTER);

//            myFrame.add(myTabbedPane[0], BorderLayout.CENTER);
//            myFrame.add(myTabbedPane[1], BorderLayout.CENTER);
//            myFrame.add(myTabbedPane[2], BorderLayout.CENTER);


            myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myFrame.setJMenuBar(menubar);
            myFrame.setVisible(true);

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: FileNotFoundException");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("ERROR: IOException");
            e.printStackTrace();
        }
    }
}