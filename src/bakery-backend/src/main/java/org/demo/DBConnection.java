package org.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public Connection connect_to_db(String dbname, String user, String password){
        Connection conn = null;

        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname, user, password);

            if (conn!=null){
                System.out.println("Connection Established");
            }
            else {
                System.out.println("Connection Failed");
            }
        } catch (SQLException | ClassNotFoundException e){
            System.out.println(e);
        }
        return conn;
    }
}
