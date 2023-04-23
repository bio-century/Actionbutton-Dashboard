package packageIconEditing;

import java.awt.*;
import java.awt.image.BufferedImage;

// source:
// http://www.java2s.com/Tutorials/Java/Graphics_How_to/Draw/Paint_2_images_side_by_side.htm
// http://www.java2s.com/Code/Java/2D-Graphics-GUI/MakeimageTransparency.htm

public class IconEditingImageTransformJButton {

    public static Image merge(Image left, Image right) {
            BufferedImage merged = new BufferedImage(left.getWidth(null)
            + right.getWidth(null), left.getHeight(null),
            java.awt.Transparency.TRANSLUCENT);
            Graphics2D g = (Graphics2D) merged.getGraphics();
            g.setColor(new Color(0, 0, 0, 0));
            g.drawImage(left, 0, 0, null);
            g.drawImage(right, left.getWidth(null), 0, null);
            return merged;
            }

}