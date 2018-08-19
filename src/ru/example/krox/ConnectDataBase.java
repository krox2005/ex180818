package ru.example.krox; 
 
/*
Copyright (c) 2018 Petikov Software Development 
Created by Petikov Vladimir on 19.08.18 16:02
-----------------------------------
Project    : ex180818
Package   : ru.example.krox 
*/
import java.sql.Connection;
//import java.sql.DatabaseMetaData;
import java.sql.DriverManager;



public class ConnectDataBase {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public ConnectDataBase()
    {
        try {
              String url = "jdbc:sqlite:"+ListConstValue.dbName;
              // System.out.println("Файл базы данных не найден!");
              Class.forName("org.sqlite.JDBC");
              Connection co = DriverManager.getConnection(url);
              this.connection = co;
               /* if (co != null) {
                    DatabaseMetaData meta = co.getMetaData();
                    System.out.println("Имя драйвера :  " + meta.getDriverName());
                    System.out.println("Создана новая база данных");
                    System.out.println("Я подключился к базе данных!!!");
                }*/
           // }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}
