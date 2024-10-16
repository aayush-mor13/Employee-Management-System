package main.com.employee_management_system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField tname, tsname, tsalary, taddress, tphone, temail, taadhar, tdesig;
    JLabel tempid;
    JDateChooser dcdob;
    JComboBox tedu;
    JButton add = new JButton("Add Details");
    JButton back = new JButton("Back");
    Random ran = new Random();
    int number = ran.nextInt(999);
    AddEmployee(){

        setLayout(null);
        setSize(900,700);
        setLocation(300,50);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(300,30,500,50);
        heading.setFont(new Font("san_serif",Font.BOLD,30));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("serif",Font.PLAIN,20));
        add(name);
        tname = new JTextField();
        tname.setBounds(200,150,150,30);
        add(tname);

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
        dcdob = new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);

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
        String courses[] = {"BBA","BCA","BA","BCOM","BTECH","MBA","MTECH","MCA","MA","MSC","PHD","Other"};
        tedu = new JComboBox(courses);//takes an array of string
        tedu.setBounds(650,300,150,30);
        tedu.setBackground(Color.WHITE);
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
        taadhar = new JTextField();
        taadhar.setBounds(650,350,150,30);
        add(taadhar);

        JLabel empid = new JLabel("Employee Id");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("serif",Font.PLAIN,20));
        add(empid);
        tempid = new JLabel(""+number);
        tempid.setFont(new Font("serif",Font.PLAIN,20));
        tempid.setBounds(200,400,150,30);
        add(tempid);

        add.setFont(new Font("serif",Font.PLAIN,20));
        add.setBounds(200,500,150,30);
        add.addActionListener(this);
        add(add);

        back.setFont(new Font("serif",Font.PLAIN,20));
        back.setBounds(500,500,150,30);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Home();
        }
        else if(e.getSource() == add){

            String name = tname.getText();
            String surname = tsname.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String mob = tphone.getText();
            String email = temail.getText();
            String highedu = (String)tedu.getSelectedItem();
            String designation = tdesig.getText();
            String aadhar = taadhar.getText();
            String empId = tempid.getText();

            if (name.isEmpty() || surname.isEmpty() || dob.isEmpty() || salary.isEmpty() || address.isEmpty() ||
                    mob.isEmpty() || email.isEmpty() || highedu == null || designation.isEmpty() || aadhar.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields must be filled out", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try{
                DBConnection c = new DBConnection();
                String query = "INSERT INTO employee VALUES('"+name+"','"+surname+"','"+dob+"','"+salary+"','"+address+"','"+mob+"','"+email+"','"+highedu+"','"+designation+"','"+aadhar+"','"+empId+"')";
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
