package Cryptography;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] arg){

        Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) ScreenSize.getWidth();
        int height = (int) ScreenSize.getHeight();
        Home frame = new Home();
        frame.setTitle("HOME");
        frame.setVisible(true);
        frame.setBounds(0,0,width,height);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
    }
}
