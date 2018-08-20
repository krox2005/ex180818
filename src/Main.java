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

       /* Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection(ListConstValue.url);
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM journal");
            while (rs.next()) {
                String str = rs.getString(2);
                System.out.println(str);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
        }*/
        InsertValues();
    }

    public static void InsertValues() throws ClassNotFoundException, SQLException
    {

        String sql = "INSERT INTO journal (name_journal) VALUES (?)";

        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection(ListConstValue.url);
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            for (String s1:ListConstValue.ListJournal2)
            {
                stmt.setString(1, s1);
                stmt.executeUpdate();
            }
            System.out.println("Записи добавлены в базу данных");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            con.close();
        }




    }

}
