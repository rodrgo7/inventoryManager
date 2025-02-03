package com.oliveiradev.InventoryManager.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConn {
    public static Connection getconnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/inventorydb";
            String user = "root";
            String password = "sua_senha";

            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver do MySql não foi encontrado");
            e.printStackTrace();
        }
        return null;
    }
}
