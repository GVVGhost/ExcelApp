package excelApp.ghost.gvv;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Window extends JFrame
{
    public Window()
    {
        super("ExcelApp");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));

        jPanel.add(Box.createVerticalGlue());

        final JLabel jLabel = new JLabel("Вибрати файл");
        jLabel.setAlignmentX(CENTER_ALIGNMENT);
        jPanel.add(jLabel);

        jPanel.add(Box.createRigidArea(new Dimension(10, 10 )));

        JButton button = new JButton("Показати JFileChooser");
        button.setAlignmentX(CENTER_ALIGNMENT);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int ret = fileChooser.showDialog(null, "Відкрити файл");
                if(ret == JFileChooser.APPROVE_OPTION)
                {
                    File file = fileChooser.getSelectedFile();
                    jLabel.setText(file.getName());
                }
            }
        });

        jPanel.add(button);
        jPanel.add(Box.createVerticalGlue());
        getContentPane().add(jPanel);

        setPreferredSize(new Dimension(260, 220));
        pack();
        setVisible(true);
    }
}
