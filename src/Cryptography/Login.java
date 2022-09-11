package Cryptography;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener{

    Container container = getContentPane();
    JLabel home = new JLabel("CRYPTOGRAPHY TOOL KIT",JLabel.CENTER);
    JButton homebutton = new JButton("HOME");
    JLabel about = new JLabel("LOGIN",JLabel.CENTER);
    JLabel idlabel = new JLabel("USER ID");
    JTextField idtext = new JTextField();
    JLabel passlabel = new JLabel("PASSWORD");
    JPasswordField passtext = new JPasswordField();
    JCheckBox showpasscheckbox = new JCheckBox("SHOW PASSWORD");
    JButton loginbutton = new JButton("LOGIN");
    JButton resetbutton = new JButton("RESET");
    JLabel already = new JLabel(   "NOT A USER? PLEASE SIGNUP!",JLabel.CENTER);
    JButton signupbutton = new JButton("SIGNUP");
    JLabel copyright= new JLabel("COPYRIGHT \u00a9 2022",JLabel.CENTER);

    Login(){
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }
    public void setLayoutManager(){
        container.setLayout(null);
    }
    public void setLocationAndSize() {
        home.setBounds(100, 20, 300, 30);
        homebutton.setBounds(200,70,100,30);
        about.setBounds(100, 120, 300, 30);
        idlabel.setBounds(25, 220, 400, 30);
        idtext.setBounds(25, 260, 450, 35);
        passlabel.setBounds(25, 310, 400, 30);
        passtext.setBounds(25, 340, 450, 35);
        showpasscheckbox.setBounds(25, 390, 450, 35);
        loginbutton.setBounds(50,440,150,30);
        resetbutton.setBounds(300, 440, 150, 30);
        already.setBounds(25, 490, 475, 60);
        signupbutton.setBounds(175, 540, 150, 30);
        copyright.setBounds(150, 720, 240, 30);

        home.setOpaque(true);
        home.setBackground(Color.BLACK);
        home.setForeground(Color.WHITE);

        about.setOpaque(true);
        about.setBackground(Color.BLACK);
        about.setForeground(Color.WHITE);

        copyright.setOpaque(true);
        copyright.setBackground(Color.BLACK);
        copyright.setForeground(Color.WHITE);

        home.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        homebutton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        loginbutton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        about.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        idlabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        idtext.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        passlabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        passtext.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        showpasscheckbox.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        signupbutton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        resetbutton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        already.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        copyright.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
    }

    public void addComponentsToContainer(){
        container.add(home);
        container.add(homebutton);
        container.add(loginbutton);
        container.add(about);
        container.add(idlabel);
        container.add(idtext);
        container.add(passlabel);
        container.add(passtext);
        container.add(showpasscheckbox);
        container.add(signupbutton);
        container.add(resetbutton);
        container.add(already);
        container.add(copyright);
    }
    public void addActionEvent(){
        homebutton.addActionListener(this);
        loginbutton.addActionListener(this);
        showpasscheckbox.addActionListener(this);
        signupbutton.addActionListener(this);
        resetbutton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == homebutton){
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
        if(e.getSource() == signupbutton) {
            dispose();
            Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int width = (int) ScreenSize.getWidth();
            int height = (int) ScreenSize.getHeight();
            Signup frame = new Signup();
            frame.setTitle("SIGNUP");
            frame.setVisible(true);
            frame.setBounds(width / 3, 0, width / 3, height);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setResizable(false);
        }
        if(e.getSource() == showpasscheckbox){
            if(showpasscheckbox.isSelected()){
                passtext.setEchoChar((char)0);
            }else{
                passtext.setEchoChar('\u2022');
            }
        }
        if(e.getSource() == loginbutton){
            String userid= idtext.getText();
            String userpass=passtext.getText();
            if( !(userpass.equals(""))  && !(userid.equals(""))  ){
                try {
                    boolean res = JDBC.check(idtext.getText(), passtext.getPassword());
                    if (res) {
                        dispose();
                        Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
                        int width = (int) ScreenSize.getWidth();
                        int height = (int) ScreenSize.getHeight();
                        CRYPTOPLAY frame = new CRYPTOPLAY();
                        frame.setTitle("PLAY");
                        frame.setVisible(true);
                        frame.setBounds(0,0,width,height);
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frame.setResizable(true);
                    } else {
                        System.out.println("ERROR");
                        JOptionPane.showMessageDialog(this,"WRONG CREDENTIALS","OOPS...",JOptionPane.INFORMATION_MESSAGE);
                        resetbutton.doClick(500);
                    }
                }
                catch (Exception ioe){
                    JOptionPane.showMessageDialog(this,"USER LOGIN FAILED","SORRY",JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("USER LOGIN FAILED");
                    resetbutton.doClick(500);
                }
            }
            else{
                if(userpass.equals("")){
                    passlabel.setText("PASSWORD * CANT BE EMPTY");
                    passlabel.setForeground(Color.RED);
                }
                else{
                    passlabel.setText("PASSWORD ");
                    passlabel.setForeground(Color.BLACK);
                }
                if(userid.equals("")){
                    idlabel.setText("USER ID * CANT BE EMPTY");
                    idlabel.setForeground(Color.RED);
                }
                else{
                    idlabel.setText("USER ID ");
                    idlabel.setForeground(Color.BLACK);
                }
            }
        }
        if(e.getSource() == resetbutton){
            idlabel.setText("USER ID");
            idlabel.setForeground(Color.BLACK);
            idtext.setText("");
            passlabel.setText("PASSWORD");
            passlabel.setForeground(Color.BLACK);
            passtext.setText("");
            passtext.setEchoChar('\u2022');
            showpasscheckbox.setSelected(false);
        }
    }


}
