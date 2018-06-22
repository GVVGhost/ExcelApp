package excelApp.ghost.gvv;

import javax.swing.*;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);
                new Window();
            }
        });

        JavaApp javaApp = new JavaApp();
        javaApp.run();
    }
}
