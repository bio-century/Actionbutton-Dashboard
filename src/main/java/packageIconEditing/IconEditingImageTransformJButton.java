package packageIconEditing;////////////////////////////////////////////////////////////////////////////////////////////////////
//  (00)                                IconEditingImageTransform                                 //
////////////////////////////////////////////////////////////////////////////////////////////////////
// Access: Main -> BuildDashboard -> IconEditingImageTransform


////////////////////////////////////////////////////////////////////////////////////////////////////
//  (01)                                      Package Import                                      //
////////////////////////////////////////////////////////////////////////////////////////////////////
//package packageIconEditing;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;


// source:
// http://www.java2s.com/Tutorials/Java/Graphics_How_to/Draw/Paint_2_images_side_by_side.htm
// http://www.java2s.com/Code/Java/2D-Graphics-GUI/MakeimageTransparency.htm


////////////////////////////////////////////////////////////////////////////////////////////////////
//  (02)                           Image-Transform for Icons and Logos                            //
////////////////////////////////////////////////////////////////////////////////////////////////////
//    public static void ImageTransformJButton(int w, int h, String path, String iconname, ImageIcon imageIcon) throws IOException {
//
//// load source images
//        BufferedImage image = ImageIO.read(new File(path + iconname));
//        BufferedImage overlay = ImageIO.read(new File(path + iconname));
//
//// create the new image, canvas size is the max. of both image sizes
//        BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
//
//// paint both images, preserving the alpha channels
//        Graphics g = combined.getGraphics();
//
//
//
//        ImageIcon MyImageToBeTransformed = new ImageIcon(path + iconname);
//        Image myImage = MyImageToBeTransformed.getImage();
//        Image myTransformedImage = myImage.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
//
//        g.drawImage(myTransformedImage, 0, 0, null);
//        g.drawImage(myTransformedImage, 30, 30, null);
//
//        g.dispose();
//
//// Save as new image
//        ImageIO.write(combined, "PNG", new File(path + iconname + "combined.png"));
//
//
//
//        Image tmpPic = createImage(60,30);
//        Graphics g = tmpPic .getGraphics();
//        g.drawImage(myTransformedImage,0,0,this);
//        g.drawImage(myTransformedImage,30,0,this);
//        Image Pic = tmpPic;
//    }
//
//    private static Image createImage(int i, int i1) {
//    }
public class IconEditingImageTransformJButton {
//    public static Object MyPanel(int w, int h, String path, String iconname, ImageIcon imageIcon) throws Exception {
//
//
//
//        BufferedImage bi = ImageIO.read(new File("./hdd.png"));
//        BufferedImage bi2 = ImageIO.read(new File("./hdd.png"));
////        Image left = createImage(size, Color.YELLOW);
//
//        Image merged = merge(bi2, bi);
//
//        return merged;
//    }

//    public static Image createImage(int size, Color color) {
//            BufferedImage image = new BufferedImage(size, size,
//            BufferedImage.TYPE_INT_RGB);
//            Graphics2D g = image.createGraphics();
//            g.setColor(color);
//            g.fillRect(0, 0, size, size);
//            g.dispose();
//            return image;
//            }

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