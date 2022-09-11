package Cryptography;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//ONLY GMAIL ACCOUNT USER CAN SEND
//Allow less secure apps: ON in the USER GMAIL ACCOUNT SECURITY

public class CRYPTOSEND extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel home = new JLabel("CRYPTOGRAPHY TOOL KIT", JLabel.CENTER);
    JButton backbutton = new JButton("BACK");
    JLabel feedback = new JLabel("FEEDBACK", JLabel.CENTER);
    JButton logoutbutton = new JButton("LOGOUT");
    JLabel copyright = new JLabel("COPYRIGHT \u00a9 2022", JLabel.CENTER);

    JLabel gmailid = new JLabel("GMAIL ID");
    JTextField gmailidtext = new JTextField("");
    JLabel gmailpass = new JLabel("GMAIL PASSWORD");
    JPasswordField gmailpasstext = new JPasswordField("");
    JCheckBox showpasscheckbox = new JCheckBox("<HTML><U>SHOW PASSWORD</U></HTML>");
    JLabel subject = new JLabel("SUBJECT");
    JTextField subjecttext = new JTextField("");
    JLabel message = new JLabel("MESSAGE");
    JTextArea messagetextarea = new JTextArea();
    JScrollPane messagepane = new JScrollPane(messagetextarea);
    JButton clearbutton = new JButton("CLEAR");
    JButton submitbutton = new JButton("SUBMIT");

    CRYPTOSEND() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }
    public void setLayoutManager(){
        container.setLayout(null);
    }
    public void setLocationAndSize(){
        home.setBounds(250,20,300,30);
        backbutton.setBounds(60,20,130,70);
        feedback.setBounds(250,60,300,30);
        logoutbutton.setBounds(610,20,130,70);
        copyright.setBounds(300,750,240,30);

        gmailid.setBounds(200, 150, 200, 30);
        gmailidtext.setBounds(200, 190, 400, 40);
        gmailpass.setBounds(200, 250, 200, 30);
        gmailpasstext.setBounds(200, 290, 400, 40);
        showpasscheckbox.setBounds(200, 350, 400, 40);
        subject.setBounds(75,450,100,30);
        subjecttext.setBounds(200, 450, 450, 40);
        message.setBounds(75, 500, 100, 30);
        messagepane.setBounds(200, 500, 450, 140);
        clearbutton.setBounds(175, 660, 150, 70);
        submitbutton.setBounds(475, 660, 150, 70);

        home.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        backbutton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        feedback.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        logoutbutton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        copyright.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        gmailid.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        gmailidtext.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        gmailpass.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        gmailpasstext.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        showpasscheckbox.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        subject.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        subjecttext.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        message.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        messagetextarea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        clearbutton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        submitbutton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));

        home.setOpaque(true);
        home.setBackground(Color.BLACK);
        home.setForeground(Color.WHITE);

        feedback.setOpaque(true);
        feedback.setBackground(Color.BLACK);
        feedback.setForeground(Color.WHITE);

        messagetextarea.setLineWrap(true);
        messagetextarea.setWrapStyleWord(true);

        copyright.setOpaque(true);
        copyright.setBackground(Color.BLACK);
        copyright.setForeground(Color.WHITE);

    }
    public void addComponentsToContainer() {
        container.add(home);
        container.add(backbutton);
        container.add(feedback);
        container.add(logoutbutton);
        container.add(copyright);

        container.add(gmailid);
        container.add(gmailidtext);
        container.add(gmailpass);
        container.add(gmailpasstext);
        container.add(showpasscheckbox);
        container.add(subject);
        container.add(subjecttext);
        container.add(message);
        container.add(messagepane);
        container.add(clearbutton);
        container.add(submitbutton);

    }
    public void addActionEvent(){
        backbutton.addActionListener(this);
        logoutbutton.addActionListener(this);
        showpasscheckbox.addActionListener(this);
        submitbutton.addActionListener(this);
        clearbutton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backbutton){
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
        }
        if(e.getSource() == logoutbutton){
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
        if(e.getSource() == showpasscheckbox){
            if(showpasscheckbox.isSelected()){
                gmailpasstext.setEchoChar((char)0);
                gmailpass.setText("<HTML><U>GMAIL PASSWORD</U></HTML>");
                showpasscheckbox.setText("SHOW PASSWORD");
            }else{
                gmailpasstext.setEchoChar('\u2022');
                gmailpass.setText("GMAIL PASSWORD");
                showpasscheckbox.setText("<HTML><U>SHOW PASSWORD</U></HTML>");
            }
        }
        if(e.getSource() == clearbutton){

            gmailidtext.setText("");
            gmailpass.setText("GMAIL PASSWORD");
            gmailpasstext.setText("");
            gmailpasstext.setEchoChar('\u2022');
            showpasscheckbox.setSelected(false);
            showpasscheckbox.setText("<HTML><U>SHOW PASSWORD</U></HTML>");
            subjecttext.setText("");
            messagetextarea.setText("");
        }
        if(e.getSource() == submitbutton){
            String usermail=gmailidtext.getText();
            String userpass=gmailpasstext.getText();
            String usersubject=subjecttext.getText();
            String usermessage=messagetextarea.getText();

            boolean validmail = isValidEmail(usermail);

            if(validmail && !(usermessage.equals("")) && !(usersubject.equals(""))&& !(userpass.equals(""))  && !(usermail.equals("")) ){
                try{
                    CRYPTOGMAIL.sendMail("liomkaty3549@gmail.com",usermail,userpass,usersubject,usermessage);
                    java.net.URL url = ClassLoader.getSystemResource("Cryptography/Icon/2.jpg");
                    ImageIcon icon2 = new ImageIcon(url);
                    JOptionPane.showMessageDialog(this,"THANK YOU FOR YOUR \nCONSTRUCTIVE FEEDBACK","ENJOY YOUR LIFE !!",JOptionPane.PLAIN_MESSAGE,icon2);
                    clearbutton.doClick(5000);
                }catch(Exception e2){
                    JOptionPane.showMessageDialog(this,"\u2605GIVE CORRECT GMAIL CREDENTIALS","GIVE CORRECT INFORMATION",JOptionPane.WARNING_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this,"\u2605FIELDS CANT BE EMPTY\n\u2605GIVE CORRECT GMAIL ID","GIVE CORRECT INFORMATION",JOptionPane.WARNING_MESSAGE);
            }
        }
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