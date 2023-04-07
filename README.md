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
```java -jar my-project-name-jar-with-dependencies.jar```

## <a id='folderstructure'></a> Folder structure
```
|   Copy_Resources_Linux.sh
|   Copy_Resources_Windows.bat
|   pom.xml
|   README.md
|
+---.idea +++
+---META-INF +++
+---README_Images
|       Screenshot_Actionbutton-Dashboard.png
|       Screenshot_Spreadsheet.png
|
+---src
|   |   config.properties
|   |
|   \---main
|       +---java
|       |   |   BuildDashboard.java
|       |   |   Main.java
|       |   |
|       |   +---packageIconEditing
|       |   |       IconEditingImageTransform.java
|       |   |
|       |   +---packageJButtons
|       |   |       JButtonsSetUpActionListener.java
|       |   |
|       |   \---packageSpreadsheet
|       |           SpreadsheetReadCellData.java
|       |
|       \---resources
|           +---icons +++
|           |
|           +---images +++
|           |
|           \---spreadsheetFiles
|                   BUTTON_AUTOSTART.xlsx
|
\---target
    |   Actionbutton-Dashboard-jar-with-dependencies.jar
    |   Actionbutton-Dashboard.jar
    |
    +---archive-tmp +++
    +---classes +++
    +---generated-sources +++
    +---maven-archiver +++
    +---maven-status +++
    \---src +++
```
[//]: # (tree /a /f)

## <a id='example'></a> Example
## <a id='authors'></a> Authors
## <a id='contributors&credits'></a> Contributors & Credits
## <a id='license'></a> License
## <a id='acknowledgments&sources'></a> Acknowledgments & Sources
## <a id='contact'></a> Contact