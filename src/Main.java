/*
Copyright (c) 2018 Petikov Software Development 
Created by Petikov Vladimir on 19.08.18 15:21
-----------------------------------
Project    : ex180818

*/


import ru.example.krox.ConnectDataBase;
import ru.example.krox.ListConstValue;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:sqlite:" + ListConstValue.dbName;

        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection(url);
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM journal");
            while (rs.next()) {
                String str = rs.getString(2);
                System.out.println(str);
            }
            rs.close();
            stmt.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            con.close();
        }
    }



}
