package main.com.employee_management_system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

public class removeEmployee extends JFrame implements ActionListener {

    Choice chempId;
    JButton delete, back;
    removeEmployee(){

        setLayout(null);
        setSize(800,600);
        setLocation(350,150);
        getContentPane().setBackground(Color.WHITE);

        JLabel empid = new JLabel("Employee Id");
        empid.setBounds(200,80,150,30);
        empid.setFont(new Font("serif",Font.BOLD,20));
        add(empid);

        chempId = new Choice();
        chempId.setBounds(400,80,150,30);
        add(chempId);

        try{
            DBConnection c = new DBConnection();

            String query = "Select * From employee";
            ResultSet rs = c.s.executeQuery(query);

            while(rs.next()){
                chempId.add(rs.getString("empId"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(200,150,150,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);
        JLabel tname = new JLabel();
        tname.setBounds(400,150,150,30);
        tname.setFont(new Font("serif",Font.PLAIN,15));
        add(tname);

        JLabel mob = new JLabel("Mobile");
        mob.setBounds(200,220,150,30);
        mob.setFont(new Font("serif",Font.BOLD,20));
        add(mob);
        JLabel tmob = new JLabel();
        tmob.setBounds(400,220,150,30);
        tmob.setFont(new Font("serif",Font.PLAIN,15));
        add(tmob);

        JLabel email = new JLabel("Email Id");
        email.setBounds(200,290,150,30);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);
        JLabel temail = new JLabel();
        temail.setBounds(400,290,200,30);
        temail.setFont(new Font("serif",Font.PLAIN,15));
        add(temail);

        chempId.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    DBConnection c = new DBConnection();
                    String query = "Select * From employee where empId = '" + chempId.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);

                    while (rs.next()) {
                        tname.setText(rs.getString("name"));
                        tmob.setText(rs.getString("mob"));
                        temail.setText(rs.getString("email"));
                    }
                }
                catch(Exception ae){
                    ae.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(200,400,150,30);
        delete.setFont(new Font("serif",Font.PLAIN,15));
        add(delete);
        delete.addActionListener(this);
        back = new JButton("Back");
        back.setBounds(400,400,150,30);
        back.setFont(new Font("serif",Font.PLAIN,15));
        add(back);
        back.addActionListener(this);

        setVisible(true);
    }

    public static void main(String[] args) {
        new removeEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==delete){
            try{
                DBConnection c = new DBConnection();
                String query = "Delete From employee Where empId = '"+chempId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Details deleted successfully");
                setVisible(false);
                new Home();
            }
            catch(Exception ae){
                ae.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Home();
        }
    }
}

