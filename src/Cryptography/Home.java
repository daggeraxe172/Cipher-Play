package Cryptography;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Home extends JFrame implements ActionListener{

    Container container = getContentPane();
    JCheckBox sound = new JCheckBox("PLAY MUSIC");
    JLabel home = new JLabel("CRYPTOGRAPHY TOOL KIT",JLabel.CENTER);
    JButton exitbutton = new JButton("EXIT");
    JButton aboutbutton = new JButton("<html>" + "ABOUT THE \n DEVELOPER".replaceAll("\\n", "<br>") + "</html>");
    JButton loginbutton = new JButton("LOGIN");
    JButton signupbutton = new JButton("SIGNUP");
    JEditorPane editorPane = new JEditorPane();
    JScrollPane scrollableTextArea = new JScrollPane(editorPane);
    JLabel copyright= new JLabel("COPYRIGHT \u00a9 2022",JLabel.CENTER);


    Home(){
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }
    public void setLayoutManager(){
        container.setLayout(null);
    }
    public void setLocationAndSize(){
        sound.setBounds(50,20,300,30);
        home.setBounds(600,20,300,30);
        exitbutton.setBounds(200,60,225,90);
        aboutbutton.setBounds(500,60,225,90);
        loginbutton.setBounds(800,60,225,90);
        signupbutton.setBounds(1100,60,225,90);
        scrollableTextArea.setBounds(50,175,1425,550);
        copyright.setBounds(650,750,240,30);

        sound.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        home.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        exitbutton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        aboutbutton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        loginbutton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        signupbutton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        copyright.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));

        sound.setForeground(Color.MAGENTA);
        new Music().setstream(0);

        home.setOpaque(true);
        home.setBackground(Color.BLACK);
        home.setForeground(Color.WHITE);


        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLUE, 5),BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        try {
            File file = new File("F:\\NewA\\CryptoLearn\\src\\Cryptography\\Doc\\doc1.htm");//copy absolute path
            editorPane.setPage(file.toURI().toURL());
        } catch (IOException e) {
            editorPane.setContentType("text/html");
            editorPane.setText("<html>Page not found.</html>");
        }
        editorPane.setEditable(false);


        copyright.setOpaque(true);
        copyright.setBackground(Color.BLACK);
        copyright.setForeground(Color.WHITE);


    }
    public void addComponentsToContainer(){
        container.add(sound);
        container.add(home);
        container.add(exitbutton);
        container.add(loginbutton);
        container.add(signupbutton);
        container.add(aboutbutton);
        container.add(scrollableTextArea);
        container.add(copyright);
    }
    public void addActionEvent(){
        sound.addActionListener(this);
        exitbutton.addActionListener(this);
        loginbutton.addActionListener(this);
        signupbutton.addActionListener(this);
        aboutbutton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        //add background music
        if(e.getSource() == sound){
            if(sound.isSelected() ){
                new Music().setstream(1);

            }
            else{
                new Music().setstream(0);
            }
        }

        if(e.getSource() == loginbutton){
            dispose();
            Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int width = (int) ScreenSize.getWidth();
            int height = (int) ScreenSize.getHeight();
            Login frame = new Login();
            frame.setTitle("LOGIN");
            frame.setVisible(true);
            frame.setBounds(width/3,0,width/3,height);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setResizable(false);

        }
        if(e.getSource() == signupbutton){
            dispose();
            Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int width = (int) ScreenSize.getWidth();
            int height = (int) ScreenSize.getHeight();
            Signup frame = new Signup();
            frame.setTitle("SIGNUP");
            frame.setVisible(true);
            frame.setBounds(width/3,0,width/3,height);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setResizable(false);

        }
        if(e.getSource() == aboutbutton){
            dispose();
            Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int width = (int) ScreenSize.getWidth();
            int height = (int) ScreenSize.getHeight();
            About frame = new About();
            frame.setTitle("ABOUT");
            frame.setVisible(true);
            frame.setBounds(width/3,0,width/3,height);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setResizable(false);
        }
        if(e.getSource() == exitbutton){
            java.net.URL url = ClassLoader.getSystemResource("Cryptography/Icon/1.jpg");
            ImageIcon icon1 = new ImageIcon(url);
            int option = JOptionPane.showConfirmDialog(this,"Do You Really Want To Quit?","Thank you. Have A Nice Day", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,icon1);
            if(option == JOptionPane.YES_OPTION){
                dispose();
            }
            System.out.println("Thank you. Have A Nice Day");
        }
    }
}


