package main.com.employee_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {
    Splash(){

        setLayout(null);
        setSize(1170,650);
        setLocation(200,100);
        getContentPane().setBackground(Color.lightGray);
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(40,30,1200,60);
        heading.setFont(new Font("serif",Font.BOLD,60));
        heading.setForeground(Color.BLACK); // Color of Font
        add(heading);

        ImageIcon i1 = new ImageIcon(getClass().getClassLoader().getResource("resources/icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100,550,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(70,100,1000,500);
        add(image);

        JButton clickhere = new JButton("Click Here To Continue");
        clickhere.setBounds(250,400,500,70);
        clickhere.setFont(new Font("serif",Font.BOLD,30));
        clickhere.addActionListener(this);
        image.add(clickhere);

        setVisible(true); // by default, it is false

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Splash();
    }
}
