package main.com.employee_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class viewEmployee extends JFrame implements ActionListener {

    JTable table;
    Choice chempId;
    JButton searchbtn, print, update, back;

    viewEmployee(){
        setLayout(null);
        setSize(900,700);
        setLocation(300,50);
        getContentPane().setBackground(Color.WHITE);
        JLabel search = new JLabel("Search by Employee Id");
        search.setBounds(200,20,150,20);
        add(search);

        chempId = new Choice();
        chempId.setBounds(400,20,150,30);
        add(chempId);

        table = new JTable();

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
        try{
            DBConnection c = new DBConnection();

            String query = "Select * From employee";
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);

        searchbtn = new JButton("Search");
        searchbtn.setBounds(200,50,80,30);
        add(searchbtn);
        searchbtn.addActionListener(this);

        print = new JButton("Print");
        print.setBounds(300,50,80,30);
        add(print);
        print.addActionListener(this);

        update = new JButton("Update");
        update.setBounds(400,50,80,30);
        add(update);
        update.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(500,50,80,30);
        add(back);
        back.addActionListener(this);

        setVisible(true);
    }
    public static void main(String[] args) {
        new viewEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchbtn){
            String query = "Select * From employee Where empId = '"+chempId.getSelectedItem()+"'";
            try{
                DBConnection c = new DBConnection();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception ae){
                ae.printStackTrace();
            }
        }
        else if(e.getSource() == print){
            try{
                table.print();
            }
            catch (Exception pe){
                pe.printStackTrace();
            }
        }
        else if(e.getSource() == update){
            setVisible(false);
            new updateEmployee(chempId.getSelectedItem());
        }
        else{
            setVisible(false);
            new Home();
        }
    }
}
