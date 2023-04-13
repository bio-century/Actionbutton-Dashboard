# Actionbutton-Dashboard

# Abstract
Sick and tired of endless navigation through directories and bookmark inventories? The Actionbutton-Dashboard-project
sets up a configurable array of JButtons which can open local apps, folders and websites. <br>
![Screenshot_Actionbutton-Dashboard](./README_Images/Screenshot_Actionbutton-Dashboard_slim.png) <br>
All buttons can be defined individually according to your needs by using simple spreadsheet configuration tables. 
After you are done with defining button names, paths and colors, just double-click on the jar file (fatjar) and the JButton-window will open. <br>
![Screenshot_Actionbutton-Dashboard](./README_Images/Screenshot_Spreadsheet.png) <br>
An optional field for logos will give companies the opportunity to introduce their corporate identity design.

# Table of Content
- [Import](#import)
- [Getting Started](#gettingstarted)
- [Folder structure](#folderstructure)
- [Example](#example)
- [Authors](#authors)
- [Contributors & Credits](#contributors&credits)
- [License](#license)
- [Acknowledgments & Sources](#acknowledgments&sources)
- [Contact](#contact)

## <a id='import'></a> Import

## <a id='gettingstarted'></a> Getting Started
For those of you who just want to use the dashboard after some minor adjustments please draw your attention to (1) 
the BUTTON_AUTOSTART.xlsx-spreadsheet file () and (2) the Actionbutton-Dashboard-jar-with-dependencies.jar. First, 
please open and modify the spreadsheet as follows:

| tab          | explanation                                                                        |
|--------------|------------------------------------------------------------------------------------|
| fieldnames   | words that are imprinted onto the button                                           |
| category     |                                                                                    |
| URL          | link, that the button is going to open. It can be a file path, a file or a website |
| color        | color in RGB-code that defines the color of the button (text and button frame)     |

Note: The buttons have to be defined from top to bottom. Blank calls will cause, that everything below will be ignored 

When you are done, please save the spreadsheet and double-click on the jar

```java -jar my-project-name-jar-with-dependencies.jar```



## <a id='folderstructure'></a> Folder structure
```
|   Copy_Resources_Linux.sh
|   Copy_Resources_Windows.bat
|   pom.xml
|   README.md
|
+---.idea +++                                                    (COLLAPSED)
+---META-INF +++                                                 (COLLAPSED)
+---README_Images +++                                            (COLLAPSED)
|
+---src
|   |   config.properties                                        <--- (3) Configuration file defining paths amd spreadsheet sizes
|   |
|   \---main
|       +---java
|       |   |   packageBuildDashboard.BuildDashboard.java
|       |   |   Main.java                                        <--- (4) Main 
|       |   |
|       |   +---packageIconEditing +++                           (COLLAPSED)
|       |   +---packageJButtons +++                              (COLLAPSED)
|       |   \---packageSpreadsheet +++                           (COLLAPSED)
|       |
|       \---resources
|           +---icons +++                                        (COLLAPSED)
|           +---images +++                                       (COLLAPSED)
|           |
|           \---spreadsheetFiles
|                   BUTTON_AUTOSTART.xlsx
|
\---target
    |   Actionbutton-Dashboard-jar-with-dependencies.jar         <--- (2) Executable JAR, will be updated when modifying the Spreadsheet
    |   Actionbutton-Dashboard.jar
    |
    +---archive-tmp +++                                          (COLLAPSED)
    +---classes +++                                              (COLLAPSED)
    +---generated-sources +++                                    (COLLAPSED)
    +---maven-archiver +++                                       (COLLAPSED)
    +---maven-status +++                                         (COLLAPSED)
    \---src
        |   config.properties
        |
        \---main
            +---java +++                                         (COLLAPSED)
            |
            \---resources
                +---icons +++                                    (COLLAPSED)
                +---images +++                                   (COLLAPSED)
                |
                \---spreadsheetFiles
                        BUTTON_AUTOSTART.xlsx                     <--- (1) Spreadsheet to be modified

    
    
```
[//]: # (tree /a /f)

## <a id='example'></a> Example
## <a id='PlannedUpdates'></a> Planned Updates
## <a id='authors'></a> Authors
## <a id='contributors&credits'></a> Contributors & Credits
## <a id='license'></a> License
## <a id='acknowledgments&sources'></a> Acknowledgments & Sources
## <a id='contact'></a> Contact
## <a id='import'></a> Import
