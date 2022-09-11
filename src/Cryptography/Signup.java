package Cryptography;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup extends JFrame implements ActionListener{

    Container container = getContentPane();
    JLabel home = new JLabel("CRYPTOGRAPHY TOOL KIT",JLabel.CENTER);
    JButton homebutton = new JButton("HOME");
    JButton loginbutton = new JButton("LOGIN");
    JLabel about = new JLabel("SIGNUP",JLabel.CENTER);
    JLabel namelabel = new JLabel("NAME");
    JTextField nametext = new JTextField();
    JLabel maillabel = new JLabel("EMAIL");
    JTextField mailtext = new JTextField();
    JLabel passlabel = new JLabel("PASSWORD");
    JPasswordField passtext = new JPasswordField();
    JLabel retypepasslabel = new JLabel("RETYPE PASSWORD");
    JPasswordField retypepasstext = new JPasswordField();
    JCheckBox showpasscheckbox = new JCheckBox("SHOW PASSWORD");
    JButton signupbutton = new JButton("SIGNUP");
    JButton resetbutton = new JButton("RESET");
    JLabel already = new JLabel(   "ALREADY A USER? PLEASE LOGIN!",JLabel.CENTER);
    JLabel copyright= new JLabel("COPYRIGHT \u00a9 2022",JLabel.CENTER);

    Signup(){
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
        namelabel.setBounds(25, 160, 300, 30);
        nametext.setBounds(25, 200, 450, 35);
        maillabel.setBounds(25, 250, 300, 30);
        mailtext.setBounds(25, 290, 450, 35);
        passlabel.setBounds(25, 340, 300, 30);
        passtext.setBounds(25, 380, 450, 35);
        retypepasslabel.setBounds(25, 430, 300, 30);
        retypepasstext.setBounds(25, 470, 450, 35);
        showpasscheckbox.setBounds(25, 520, 450, 35);
        signupbutton.setBounds(50, 570, 150, 30);
        resetbutton.setBounds(300, 570, 150, 30);
        already.setBounds(25, 620, 475, 60);
        loginbutton.setBounds(190,670,125,30);
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
        namelabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        nametext.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        maillabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        mailtext.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        passlabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        passtext.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        retypepasslabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        retypepasstext.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        showpasscheckbox.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        signupbutton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        resetbutton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        already.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        copyright.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
    }

    public void addComponentsToContainer(){
        container.add(home);
        container.add(homebutton);
        container.add( loginbutton);
        container.add( about);
        container.add(  namelabel);
        container.add(nametext);
        container.add(maillabel);
        container.add(mailtext);
        container.add(passlabel);
        container.add(passtext);
        container.add(retypepasslabel);
        container.add(retypepasstext);
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
        if(e.getSource() == loginbutton) {
            dispose();
            Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int width = (int) ScreenSize.getWidth();
            int height = (int) ScreenSize.getHeight();
            Login frame = new Login();
            frame.setTitle("LOGIN");
            frame.setVisible(true);
            frame.setBounds(width / 3, 0, width / 3, height);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setResizable(false);
        }
        if(e.getSource() == showpasscheckbox){
            if(showpasscheckbox.isSelected()){
                passtext.setEchoChar((char)0);
                retypepasstext.setEchoChar((char)0);
            }else{
                passtext.setEchoChar('\u2022');
                retypepasstext.setEchoChar('\u2022');
            }
        }
        if(e.getSource() == signupbutton){
            String username=nametext.getText();
            String usermail=mailtext.getText();
            String userpass=passtext.getText();
            String userretypepass=retypepasstext.getText();

            boolean validpass = isValidPassword(userpass);
            boolean validmail = isValidEmail(usermail);
            if(validpass && validmail && (userpass.equals(userretypepass)) && !(userpass.equals(""))  && !(usermail.equals("")) && !(username.equals("")) ){
                try {
                    long res = JDBC.insert(nametext.getText(), mailtext.getText(), passtext.getPassword());
                    if (res != 0) {
                        JTextArea user = new JTextArea("PLEASE NOTE DOWN USER ID, EMAIL \nAND PASSWORD FOR FUTURE PURPOSE" +
                                "\n\nWOAH ! USER CREATION SUCCEEDED ! \n\nUSER ID :  " + String.valueOf(res) +
                                "\nEMAIL ID : " + mailtext.getText());
                        user.setEditable(false);
                        user.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
                        Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
                        user.setBorder(BorderFactory.createCompoundBorder(border,
                                BorderFactory.createEmptyBorder(25, 25, 25, 25)));
                        JOptionPane.showMessageDialog(this, user, "CONGRATULATIONS", JOptionPane.PLAIN_MESSAGE);
                        System.out.println("User creation success");
                        loginbutton.doClick();
                    } else {
                        System.out.println("ERROR");
                    }
                }
                catch (Exception ioe){
                    JOptionPane.showMessageDialog(this,"USER CREATION FAILED","SORRY",JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("User creation failed");
                }


            }
            else{
                if(!validpass){
                    JOptionPane.showMessageDialog(this,"CHECK IF FOLOWING CONSTRAINTS ARE SATISFIED :\n" +
                            "\u2605AT LEAST 8 CHARACTERS AND AT MOST 20 CHARACTERS.\n" +
                            "\u2605AT LEAST ONE DIGIT.\n" +
                            "\u2605AT LEAST ONE UPPER CASE ALPHABET.\n" +
                            "\u2605AT LEAST ONE LOWER CASE ALPHABET.\n" +
                            "\u2605AT LEAST ONE SPECIAL CHARACTER WHICH INCLUDES !@#$%&*()-+=^.\n" +
                            "\u2605DOESN’T CONTAIN ANY WHITE SPACE.","INVALID PASSWORD",JOptionPane.WARNING_MESSAGE);
                }
                if( !(userpass.equals(userretypepass)) ){
                    JOptionPane.showMessageDialog(this,"PASSWORD DO NOT MATCH","INPUT MISMATCH",JOptionPane.WARNING_MESSAGE);
                }
                if(userpass.equals("") || userretypepass.equals("")){
                    JOptionPane.showMessageDialog(this,"PASSWORD CANT BE EMPTY","EMPTY PASSWORD",JOptionPane.WARNING_MESSAGE);
                }
                if(username.equals("")){
                    namelabel.setText("NAME  * CANT BE EMPTY");
                    namelabel.setForeground(Color.RED);
                }
                else{
                    namelabel.setText("NAME ");
                    namelabel.setForeground(Color.BLACK);
                }
                if(usermail.equals("")){
                    maillabel.setText("EMAIL * CANT BE EMPTY");
                    maillabel.setForeground(Color.RED);
                }
                else if(!validmail){
                    maillabel.setText("EMAIL   * INVALID");
                    maillabel.setForeground(Color.RED);
                }
                else{
                    maillabel.setText("EMAIL ");
                    maillabel.setForeground(Color.BLACK);
                }

            }
        }
        if(e.getSource() == resetbutton){
            namelabel.setText("NAME");
            namelabel.setForeground(Color.BLACK);
            nametext.setText("");
            maillabel.setText("EMAIL");
            maillabel.setForeground(Color.BLACK);
            mailtext .setText("");
            passlabel.setText("PASSWORD");
            passtext.setText("");
            retypepasslabel.setText("RETYPE PASSWORD");
            retypepasstext.setText("");
            showpasscheckbox.setSelected(false);
        }
    }

    public boolean isValidPassword(String password){
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(password);

        return m.matches();
    }

    public boolean isValidEmail(String email){
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                +  "A-Z]{2,7}$";

        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(email);

        return m.matches();
    }
}
