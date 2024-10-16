package main.com.employee_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField uname = new JTextField();
    JTextField pword = new JTextField();
    Login(){
        setLayout(null);
        setSize(650,400);
        setLocation(450,200);

        JLabel username = new JLabel("Username");

        JLabel password = new JLabel("Password");

        JButton loginbtn = new JButton("LOGIN");
        username.setBounds(50,80,80,30);
        uname.setBounds(130,80,240,30);
        password.setBounds(50,150,80,30);
        pword.setBounds(130,150,240,30);
        loginbtn.setBounds(130,220,240,30);
        loginbtn.setFont(new Font("serif",Font.BOLD,20));
        loginbtn.addActionListener(this);

        add(username);
        add(uname);
        add(password);
        add(pword);
        add(loginbtn);

        ImageIcon i1 = new ImageIcon(getClass().getClassLoader().getResource("resources/icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(180,180,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(420,80,180,170);
        add(image);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String username = uname.getText();
            String password = pword.getText();

            DBConnection c = new DBConnection();
            String query = "Select * From login where username = '"+username+"' and password ='"+password+"'";
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Home();
            }
            else{
                JOptionPane.showMessageDialog(null,"Invalid Username or Password","Error",JOptionPane.ERROR_MESSAGE);
                setVisible(false);
                new Splash();
            }
        }
        catch (Exception a){
            a.printStackTrace();
        }
    }
}
