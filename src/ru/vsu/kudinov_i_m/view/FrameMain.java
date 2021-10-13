package ru.vsu.kudinov_i_m.view;

import javax.swing.*;

public class FrameMain extends JFrame
{
    public FrameMain()
    {
        setTitle("Poker App");
        setSize(1500, 1100);
        add(new MainPanel());
        ImageIcon icon = new ImageIcon("src\\ru\\vsu\\kudinov_i_m\\resources\\appImage.jpg");
        setIconImage(icon.getImage());
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
