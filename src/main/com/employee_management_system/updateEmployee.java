package main.com.employee_management_system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class updateEmployee extends JFrame implements ActionListener {

    JTextField tsname, tsalary, taddress, tphone, temail, tedu, taadhar, tdesig;
    JLabel tempid, lblname, lbldob, lblaadhar;
    JButton update = new JButton("Update Details");
    JButton back = new JButton("Back");

    String empId;
    updateEmployee(String empId){

        this.empId=empId;
        setLayout(null);
        setSize(900,700);
        setLocation(300,50);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(250,30,500,50);
        heading.setFont(new Font("san_serif",Font.BOLD,30));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("serif",Font.PLAIN,20));
        add(name);
        lblname = new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);

        JLabel sname = new JLabel("Surname");
        sname.setBounds(500,150,150,30);
        sname.setFont(new Font("serif",Font.PLAIN,20));
        add(sname);
        tsname = new JTextField();
        tsname.setBounds(650,150,150,30);
        add(tsname);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("serif",Font.PLAIN,20));
        add(dob);
        lbldob = new JLabel();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(500,200,150,30);
        salary.setFont(new Font("serif",Font.PLAIN,20));
        add(salary);
        tsalary = new JTextField();
        tsalary.setBounds(650,200,150,30);
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("serif",Font.PLAIN,20));
        add(address);
        taddress = new JTextField();
        taddress.setBounds(200,250,150,30);
        add(taddress);

        JLabel phone = new JLabel("Mobile No.");
        phone.setBounds(500,250,150,30);
        phone.setFont(new Font("serif",Font.PLAIN,20));
        add(phone);
        tphone = new JTextField();
        tphone.setBounds(650,250,150,30);
        add(tphone);

        JLabel email = new JLabel("Email Id");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("serif",Font.PLAIN,20));
        add(email);
        temail = new JTextField();
        temail.setBounds(200,300,150,30);
        add(temail);

        JLabel edu = new JLabel("Highest Education");
        edu.setBounds(500,300,150,30);
        edu.setFont(new Font("serif",Font.PLAIN,20));
        add(edu);

        tedu = new JTextField();
        tedu.setBounds(650,300,150,30);
        add(tedu);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("serif",Font.PLAIN,20));
        add(designation);
        tdesig = new JTextField();
        tdesig.setBounds(200,350,150,30);
        add(tdesig);

        JLabel aadhar = new JLabel("Aadhar No.");
        aadhar.setBounds(500,350,150,30);
        aadhar.setFont(new Font("serif",Font.PLAIN,20));
        add(aadhar);
        lblaadhar = new JLabel();
        lblaadhar.setBounds(650,350,150,30);
        add(lblaadhar);

        JLabel empid = new JLabel("Employee Id");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("serif",Font.PLAIN,20));
        add(empid);
        tempid = new JLabel();
        tempid.setFont(new Font("serif",Font.PLAIN,20));
        tempid.setBounds(200,400,150,30);
        add(tempid);

        try{
            DBConnection c = new DBConnection();
            String query = "Select * From employee Where empId = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                tsname.setText(rs.getString("sname"));
                lbldob.setText(rs.getString("dob"));
                tsalary.setText(rs.getString("salary"));
                taddress.setText(rs.getString("address"));
                tphone.setText(rs.getString("mob"));
                temail.setText(rs.getString("email"));
                tedu.setText(rs.getString("highestedu"));
                tdesig.setText(rs.getString("designation"));
                lblaadhar.setText(rs.getString("aadhar"));
                tempid.setText(rs.getString("empId"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        update.setFont(new Font("serif",Font.PLAIN,20));
        update.setBounds(200,500,200,30);
        update.addActionListener(this);
        add(update);

        back.setFont(new Font("serif",Font.PLAIN,20));
        back.setBounds(500,500,200,30);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public static void main(String[] args){
        new updateEmployee("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Home();
        }
        else if(e.getSource() == update){

            String surname = tsname.getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String mob = tphone.getText();
            String email = temail.getText();
            String highedu = tedu.getText();
            String designation = tdesig.getText();
            String empId = tempid.getText();

            if (surname.isEmpty() || salary.isEmpty() || address.isEmpty() ||
                    mob.isEmpty() || email.isEmpty() || highedu == null || designation.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields must be filled out", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try{
                DBConnection c = new DBConnection();
                String query = "Update employee Set sname = '"+surname+"', salary = '"+salary+"', address = '"+address+"', mob = '"+mob+"', email = '"+email+"', highestedu = '"+highedu+"', designation = '"+designation+"' Where empId = '"+empId+"' ";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"The details are successfully updated");
                setVisible(false);
                new Home();
            }
            catch (Exception ae){
                ae.getStackTrace();
            }
        }
    }
}
