package Cryptography;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class About extends JFrame implements ActionListener{

    Container container = getContentPane();
    JLabel home = new JLabel("CRYPTOGRAPHY TOOL KIT",JLabel.CENTER);
    JButton backbutton = new JButton("BACK");
    JLabel about = new JLabel("ABOUT THE DEVELOPER",JLabel.CENTER);
    JEditorPane editorPane = new JEditorPane();
    JScrollPane scrollableTextArea = new JScrollPane(editorPane);
    JLabel copyright= new JLabel("COPYRIGHT \u00a9 2022",JLabel.CENTER);

    About(){
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }
    public void setLayoutManager(){
        container.setLayout(null);
    }
    public void setLocationAndSize(){
        home.setBounds(100,20,300,30);
        backbutton.setBounds(200,70,100,30);
        about.setBounds(100,120,300,30);
        scrollableTextArea.setBounds(20,225,450,200);
        copyright.setBounds(150,720,240,30);

        home.setOpaque(true);
        home.setBackground(Color.BLACK);
        home.setForeground(Color.WHITE);
        home.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));

        backbutton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));

        about.setOpaque(true);
        about.setBackground(Color.BLACK);
        about.setForeground(Color.WHITE);
        about.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));

        scrollableTextArea.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.RED, 5),BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        try {
            File file = new File("F:\\NewA\\CryptoLearn\\src\\Cryptography\\Doc\\doc2.html"); //copy absolute path
            editorPane.setPage(file.toURI().toURL());
        } catch (IOException e) {
            editorPane.setContentType("text/html");
            editorPane.setText("<html>Page not found.</html>");
        }
        editorPane.setEditable(false);

        copyright.setOpaque(true);
        copyright.setBackground(Color.BLACK);
        copyright.setForeground(Color.WHITE);
        copyright.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
    }
    public void addComponentsToContainer(){
        container.add(home);
        container.add(backbutton);
        container.add(about);
        container.add(scrollableTextArea);
        container.add(copyright);
    }
    public void addActionEvent(){
        backbutton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backbutton){
            dispose();
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
}
