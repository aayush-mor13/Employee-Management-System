package main.com.employee_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {

    JButton add = new JButton("Add Employee");
    JButton view = new JButton("View Employee");
    JButton update = new JButton("Update Employee");
    JButton remove = new JButton("Remove Employee");
    Home(){
        setLayout(null);
        setSize(1170,650);
        setLocation(200,100);

        ImageIcon i1 = new ImageIcon(getClass().getClassLoader().getResource("resources/icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(585,325,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(292,90,585,325);
        add(image);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(250,10,1200,70);
        heading.setFont(new Font("serif",Font.BOLD,50));
        add(heading);

        add.setBounds(380,430,170,40);
        add.setFont(new Font("serif",Font.BOLD,15));
        update.setBounds(380,490,170,40);
        update.setFont(new Font("serif",Font.BOLD,15));
        view.setBounds(640,430,170,40);
        view.setFont(new Font("serif",Font.BOLD,15));
        remove.setBounds(640,490,170,40);
        remove.setFont(new Font("serif",Font.BOLD,15));

        add.addActionListener(this);
        remove.addActionListener(this);
        update.addActionListener(this);
        view.addActionListener(this);
        add(add);
        add(update);
        add(view);
        add(remove);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Home();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == add){
            setVisible(false);
            new AddEmployee();
        }
        else if(e.getSource() == update){
            setVisible(false);
            new viewEmployee();
        }
        else if(e.getSource() == view){
            setVisible(false);
            new viewEmployee();
        }else if(e.getSource() == remove){
            new removeEmployee();
        }
    }
}
