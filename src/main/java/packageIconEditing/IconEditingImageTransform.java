package packageIconEditing;

import java.awt.Image;
import javax.swing.*;

public class IconEditingImageTransform {
    public static ImageIcon ImageTransform(int w, int h, String path) {

        ImageIcon MyImageToBeTransformed = new ImageIcon(path);
        Image myImage = MyImageToBeTransformed.getImage();
        Image myTransformedImage = myImage.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
        MyImageToBeTransformed = new ImageIcon(myTransformedImage);
        return MyImageToBeTransformed;
    }
}