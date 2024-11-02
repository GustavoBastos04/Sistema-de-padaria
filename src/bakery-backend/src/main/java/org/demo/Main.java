package org.demo;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        String dbName = "padaria", dbUser = "postgres", dbPassword = "";


        DBConnection db = new DBConnection();

        Connection conn = db.connect_to_db(dbName, dbUser, dbPassword);
    }
}