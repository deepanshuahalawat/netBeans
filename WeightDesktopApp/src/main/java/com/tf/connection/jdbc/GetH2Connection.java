/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tf.connection.jdbc;

import com.tf.util.WeightConstants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class GetH2Connection {
    
    public static Connection getH2Connection(){
        try {
            String jdbcURL = WeightConstants.H2DBConnection;
            String username = "tf";
            String password = "java";
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to H2 embedded database.");
            return connection;
        } catch (SQLException ex) {
            System.out.println("Error while getting connection" );
            ex.printStackTrace();
        }
        return null;
    }
}
