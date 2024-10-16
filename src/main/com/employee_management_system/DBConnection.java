package main.com.employee_management_system;

import java.io.InputStream;
import java.sql.*;
import java.io.FileInputStream;
import java.util.Properties;
public class DBConnection {
    Connection c;
    Statement s;
    public DBConnection(){
        try{
            Properties properties = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("resources/config.properties");
            properties.load(inputStream);

            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(url,username,password);
            s =c.createStatement();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
