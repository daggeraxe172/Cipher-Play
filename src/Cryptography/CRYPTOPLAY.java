package Cryptography;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

class CRYPTOPLAY extends JFrame implements ActionListener{
    Container container = getContentPane();
    JLabel home = new JLabel("CRYPTOGRAPHY TOOL KIT",JLabel.CENTER);
    JButton feedbackbutton = new JButton("FEEDBACK");
    JLabel tool = new JLabel("TOOLS",JLabel.CENTER);
    JButton logoutbutton = new JButton("LOGOUT");
    JLabel encrypt = new JLabel("ENCRYPTION",JLabel.CENTER);
    JLabel decrypt = new JLabel("DECRYPTION",JLabel.CENTER);
    JLabel copyright= new JLabel("COPYRIGHT \u00a9 2022",JLabel.CENTER);

    JToggleButton eb1 = new JToggleButton("CAESAR CIPHER");
    JToggleButton eb2 = new JToggleButton("MONOALPHABETIC CIPHER");
    JToggleButton eb3 = new JToggleButton("PLAYFAIR CIPHER");
    JToggleButton eb4 = new JToggleButton("RAIL FENCE CIPHER");
    JLabel el1 = new JLabel("ENTER MESSAGE -> CHOOSE CIPHER \u25b2 -> ENCRYPT \u25bc");
    JTextArea et1 = new JTextArea();
    JScrollPane eta1 = new JScrollPane(et1);
    JButton eb5 = new JButton("ENCRYPT");
    JLabel el2 = new JLabel("DISPLAYING ENCRYPTED MESSAGE");
    JTextArea et2 = new JTextArea();
    JScrollPane eta2 = new JScrollPane(et2);
    JButton eb6 = new JButton("CLEAR");


    JToggleButton db1 = new JToggleButton("CAESAR CIPHER");
    JToggleButton db2 = new JToggleButton("MONOALPHABETIC CIPHER");
    JToggleButton db3 = new JToggleButton("PLAYFAIR CIPHER");
    JToggleButton db4 = new JToggleButton("RAIL FENCE CIPHER");
    JLabel dl1 = new JLabel("ENTER MESSAGE -> CHOOSE CIPHER \u25b2 -> DECRYPT \u25bc");
    JTextArea dt1 = new JTextArea();
    JScrollPane dta1 = new JScrollPane(dt1);
    JButton db5 = new JButton("DECRYPT");
    JLabel dl2 = new JLabel("DISPLAYING DECRYPTED MESSAGE");
    JTextArea dt2 = new JTextArea();
    JScrollPane dta2 = new JScrollPane(dt2);
    JButton db6 = new JButton("CLEAR");

    CRYPTOPLAY(){
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }
    public void setLayoutManager(){
        container.setLayout(null);
    }
    public void setLocationAndSize() {
        home.setBounds(600,20,300,30);
        feedbackbutton.setBounds(100,20,150,70);
        tool.setBounds(600,60,300,30);
        logoutbutton.setBounds(1300,20,140,70);
        encrypt.setBounds(200,140,300,30);
        decrypt.setBounds(950,140,300,30);

        eb1.setBounds(50,200,300,70);
        eb2.setBounds(400,200,300,70);
        eb3.setBounds(50,300,300,70);
        eb4.setBounds(400,300,300,70);
        el1.setBounds(50,400,700,30);
        eta1.setBounds(50,440,500,100);
        eb5.setBounds(560,470,140,40);
        el2.setBounds(50,570,500,30);
        eta2.setBounds(50,610,500,100);
        eb6.setBounds(560,640,140,40);

        db1.setBounds(800,200,300,70);
        db2.setBounds(1150,200,300,70);
        db3.setBounds(800,300,300,70);
        db4.setBounds(1150,300,300,70);
        dl1.setBounds(800,400,700,30);
        dta1.setBounds(800,440,500,100);
        db5.setBounds(1310,470,140,40);
        dl2.setBounds(800,570,500,30);
        dta2.setBounds(800,610,500,100);
        db6.setBounds(1310,640,140,40);

        copyright.setBounds(650,750,240,30);

        home.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        feedbackbutton.setFont(new Font(Font.MONOSPACED, Font.BOLD,22));
        tool.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        logoutbutton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        encrypt.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        decrypt.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        eb1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        eb2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        eb3.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        eb4.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        el1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        et1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        eb5.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        el2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        et2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        eb6.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        db1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        db2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        db3.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        db4.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        dl1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        dt1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        db5.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        dl2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        dt2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        db6.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        copyright.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));

        et1.setLineWrap(true);
        et1.setWrapStyleWord(true);

        et2.setLineWrap(true);
        et2.setWrapStyleWord(true);
        et2.setEditable(false);

        dt1.setLineWrap(true);
        dt1.setWrapStyleWord(true);

        dt2.setLineWrap(true);
        dt2.setWrapStyleWord(true);
        dt2.setEditable(false);

        home.setOpaque(true);
        home.setBackground(Color.BLACK);
        home.setForeground(Color.WHITE);

        tool.setOpaque(true);
        tool.setBackground(Color.BLACK);
        tool.setForeground(Color.WHITE);

        encrypt.setOpaque(true);
        encrypt.setBackground(Color.BLACK);
        encrypt.setForeground(Color.YELLOW);

        decrypt.setOpaque(true);
        decrypt.setBackground(Color.BLACK);
        decrypt.setForeground(Color.YELLOW);

        copyright.setOpaque(true);
        copyright.setBackground(Color.BLACK);
        copyright.setForeground(Color.WHITE);
    }
    public void addComponentsToContainer(){
        container.add(home);
        container.add(feedbackbutton);
        container.add(tool);
        container.add(logoutbutton);
        container.add(encrypt);
        container.add(decrypt);
        container.add(eb1);
        container.add(eb2);
        container.add(eb3);
        container.add(eb4);
        container.add(el1);
        container.add(eta1);
        container.add(eb5);
        container.add(el2);
        container.add(eta2);
        container.add(eb6);
        container.add(db1);
        container.add(db2);
        container.add(db3);
        container.add(db4);
        container.add(dl1);
        container.add(dta1);
        container.add(db5);
        container.add(dl2);
        container.add(dta2);
        container.add(db6);
        container.add(copyright);
    }
    public void addActionEvent(){
        feedbackbutton.addActionListener(this);
        logoutbutton.addActionListener(this);

        eb1.addActionListener(this);
        eb2.addActionListener(this);
        eb3.addActionListener(this);
        eb4.addActionListener(this);
        eb5.addActionListener(this);
        eb6.addActionListener(this);

        db1.addActionListener(this);
        db2.addActionListener(this);
        db3.addActionListener(this);
        db4.addActionListener(this);
        db5.addActionListener(this);
        db6.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == feedbackbutton){
            dispose();
            Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int width = (int) ScreenSize.getWidth();
            int height = (int) ScreenSize.getHeight();
            CRYPTOSEND frame = new CRYPTOSEND();
            frame.setTitle("SEND FEEDBACK");
            frame.setVisible(true);
            frame.setBounds(width/4,0,width/2,height);
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
        if(e.getSource() == eb1){
            eb2.setSelected(false);
            eb3.setSelected(false);
            eb4.setSelected(false);
        }
        if(e.getSource() == eb2){
            eb1.setSelected(false);
            eb3.setSelected(false);
            eb4.setSelected(false);
        }
        if(e.getSource() == eb3){
            eb1.setSelected(false);
            eb2.setSelected(false);
            eb4.setSelected(false);
        }
        if(e.getSource() == eb4){
            eb1.setSelected(false);
            eb2.setSelected(false);
            eb3.setSelected(false);
        }
        if(e.getSource() == db1){
            db2.setSelected(false);
            db3.setSelected(false);
            db4.setSelected(false);
        }
        if(e.getSource() == db2){
            db1.setSelected(false);
            db3.setSelected(false);
            db4.setSelected(false);
        }
        if(e.getSource() == db3){
            db1.setSelected(false);
            db2.setSelected(false);
            db4.setSelected(false);
        }
        if(e.getSource() == db4){
            db1.setSelected(false);
            db2.setSelected(false);
            db3.setSelected(false);
        }

        if(e.getSource() == eb5){
            if(et1.getText().equals("") || (!eb1.isSelected() && !eb2.isSelected() && !eb3.isSelected() && !eb4.isSelected() )){
                el1.setForeground(new Color(171, 0, 232));
            }
            else{
                el1.setForeground(new Color(0, 0, 0));
                if(eb1.isSelected()){
                    String s1 = et1.getText();
                    String s2 = String.valueOf(CRYPTOPLAYTOOL.CaesarCipherEncryption(s1));
                    et2.setText(s2);
                }
                if(eb2.isSelected()){
                    String s1 = et1.getText().toLowerCase();
                    String s2 = CRYPTOPLAYTOOL.MonoAlphabeticCipherEncryption(s1);
                    et2.setText(s2);
                }
                if(eb3.isSelected()){
                    String s1 = et1.getText();
                    String s2 = PlayFairCipherEncryption.PlayFairCipherEncrypt(s1);
                    et2.setText(s2);
                }
                if(eb4.isSelected()){
                    String s1 = et1.getText();
                    String s2 = CRYPTOPLAYTOOL.RailFenceBasicEncryption(s1);
                    et2.setText(s2);
                }
            }
        }

        if(e.getSource() == db5){
            if(dt1.getText().equals("") || (!db1.isSelected() && !db2.isSelected() && !db3.isSelected() && !db4.isSelected() )){
                dl1.setForeground(new Color(171, 0, 232));
            }
            else{
                dl1.setForeground(new Color(0, 0, 0));
                if(db1.isSelected()){
                    String s1 = dt1.getText();
                    String s2 = String.valueOf(CRYPTOPLAYTOOL.CaesarCipherDecryption(s1));
                    dt2.setText(s2);
                }
                if(db2.isSelected()){
                    String s1 = dt1.getText().toUpperCase();
                    String s2 = CRYPTOPLAYTOOL.MonoAlphabeticCipherDecryption(s1);
                    dt2.setText(s2);
                }
                if(db3.isSelected()){
                    String s1 = dt1.getText();
                    String s2 = PlayFairCipherDecryption.PlayFairCipherDecrypt(s1);
                    dt2.setText(s2);
                }
                if(db4.isSelected()){
                    String s1 = dt1.getText();
                    String s2 = CRYPTOPLAYTOOL.RailFenceBasicDecryption(s1);
                    dt2.setText(s2);
                }
            }
        }

        if(e.getSource() == eb6){
            et1.setText("");
            et2.setText("");
            el1.setForeground(new Color(0, 0, 0));
        }
        if(e.getSource() == db6){
            dt1.setText("");
            dt2.setText("");
            dl1.setForeground(new Color(0, 0, 0));
        }

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(760, 150, 760, 750);
        g2.draw(lin);
    }
}


