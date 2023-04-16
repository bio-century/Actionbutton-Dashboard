package packageJButtons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class JButtonsSetUpActionListener {
    public static ActionListener setUpActionListener(final int i, final JButton buttons, final String fieldnamesall, final String URLall) {
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JButton src = (JButton) ae.getSource();


                if ((i > 0) && fieldnamesall != "") {
                    if (src == buttons) {
                        boolean isFound = URLall.contains("://");
                        boolean isFound2 = URLall.contains("www.");
                        if (isFound || isFound2) {
                            Desktop desktop = Desktop.getDesktop();
                            try {
                                URI uri = new URI(URLall);
                                desktop.browse(uri);
                            } catch (IOException ex) {
                                ex.printStackTrace();
                                System.out.println("IOException ex");
                            } catch (URISyntaxException ex) {
                                ex.printStackTrace();
                                System.out.println("URISyntaxException ex");
                            }
                        } else {
//                            System.out.println(fieldnamesall);
                            String tmp;
                            tmp = URLall.replace("\\", "\\\\");
//                            System.out.println(tmp);
//                            System.out.println(URLall);
                            Desktop desktop = null;
                            desktop = Desktop.getDesktop();
                            try {
                                desktop.open(new File(tmp));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
        };
        return buttonListener;
    }

}
