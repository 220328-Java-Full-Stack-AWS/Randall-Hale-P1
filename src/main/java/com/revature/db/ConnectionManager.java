package com.revature.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

    private static Connection connection;

    //Making the constructor private, so it can't be invoked
    private ConnectionManager() {
    }

    public static Connection getConnection(){
        if(connection == null) {connection = connect();}
        return connection;
    }

    //establish connection method
    private static Connection connect(){

        try {

            //New method grabbing the properties from the JAR classpath
            Properties props = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream input = loader.getResourceAsStream("application.properties");
            props.load(input);


            String connectionString = "jdbc:postgresql://" +
                    props.getProperty("hostname") + ":" +
                    props.getProperty("port") + "/" +
                    props.getProperty("dbname");

            String username = props.getProperty("username");
            String password = props.getProperty("password");

            connection = DriverManager.getConnection(connectionString, username, password);
        } catch (IOException | SQLException e) {e.printStackTrace();}

        return connection;
    }
}
