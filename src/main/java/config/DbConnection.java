package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
  
  static Connection con = null;
  
  //method
  public static Connection getConnection() {
    
    
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      
   con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/jwd68", "root", "2292004");
//      System.out.println(con);
      
    } 
    catch (ClassNotFoundException e) {
      System.out.println("Driver error: " + e.getMessage());
      
      
    } 
    catch (SQLException e) {
      System.out.println("Connection error: " + e.getMessage());
      
    }

    return con;
  
  

}}
