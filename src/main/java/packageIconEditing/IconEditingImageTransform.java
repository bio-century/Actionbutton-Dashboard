////////////////////////////////////////////////////////////////////////////////////////////////////
//  (00)                                IconEditingImageTransform                                 //
////////////////////////////////////////////////////////////////////////////////////////////////////
// Access: Main -> BuildDashboard -> IconEditingImageTransform


////////////////////////////////////////////////////////////////////////////////////////////////////
//  (01)                                      Package Import                                      //
////////////////////////////////////////////////////////////////////////////////////////////////////
package packageIconEditing;

import java.awt.Image;
import javax.swing.*;

public class IconEditingImageTransform {


////////////////////////////////////////////////////////////////////////////////////////////////////
//  (02)                           Image-Transform for Icons and Logos                            //
////////////////////////////////////////////////////////////////////////////////////////////////////
    public static ImageIcon ImageTransform(int WIDTH, int HEIGHT, String DIR_IMAGE2TRANFORM) {

        ImageIcon MyImageToBeTransformed = new ImageIcon(DIR_IMAGE2TRANFORM);
        Image myImage = MyImageToBeTransformed.getImage();
        Image myTransformedImage = myImage.getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_SMOOTH);
        MyImageToBeTransformed = new ImageIcon(myTransformedImage);
        return MyImageToBeTransformed;
    }
}