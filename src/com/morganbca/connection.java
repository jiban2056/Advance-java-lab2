package com.morganbca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class connection {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            // connect 
            String url = "jdbc:mysql://localhost:3306/BookApp";
            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "jiban");
            
            Connection conn = DriverManager.getConnection(url, info);
            if (conn != null) {
                System.out.println("Connected to the database..");
            }
            
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery();
            
            
            // for inserting data
            
//            String sql = "INSERT INTO book (isbn, name, author) VALUES(?,?,?)";
            
//            PreparedStatement pst = conn.prepareStatement(sql);
            
          
//          pst.setString(1,"00543208");
//          pst.setString(2,"Computer Networking");
//          pst.setString(3,"Bijay Niroula");
          
//          pst.executeUpdate();
          
//          System.out.println("row/s affected");
          
//          conn.close();
//          pst.close();
          
         
            //For DISPLAY THE RECORDS OF A TABLE USING RESULTSET
            
//            Statement st = conn.createStatement();
            
//            String sql = "SELECT * FROM book";
            
//            ResultSet rs = st.executeQuery(sql);
            
//            while (rs.next())
//            {
//            	int id = rs.getInt("id");
//            	String isbn = rs.getString("isbn");
//            	String name = rs.getString("name");
//            	String author = rs.getString("author");
//            	
//            	System.out.println(id + ", " + isbn + ", " + name + ", " + author);
//            }
            
            // UPDATE
            
//            String sql = "UPDATE book SET isbn=?, name=?, author=? WHERE id=?";
//            
//            PreparedStatement pst = conn.prepareStatement(sql);
//            
//            pst.setString(1, "0005470692");
//            pst.setString(2, "java");
//            pst.setString(3, "Sashwat Marasini");
//            pst.setInt(4, 2);
//            
//            int rowAffected = pst.executeUpdate();
//          
//            System.out.println(rowAffected + "row(s) affected");
            
            // DELETE
            
//            String sql = "DELETE FROM book WHERE name =?";
            
//            PreparedStatement pst = conn.prepareStatement(sql);
            
//            pst.setString(1, "java");
            
//            int rowAffected = pst.executeUpdate();
            
//            System.out.println(rowAffected + "row(s) affected");
            
            // DIFFERENT METHODS OF THE SCROLLABLE RESULTSET
            
//            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            
//            String sql = "SELECT * FROM  book";
//            
//            ResultSet rs = st.executeQuery(sql);
//            
//          Move cursor to first position
//            rs.first();
//            
//            Print data at first position
//            System.out.println(rs.getInt("id") + "\t" + rs.getString("isbn")
//            + "\t" + rs.getString("name") + "\t" + rs.getString("author"));
//            
//           Move cursor to last position
//            rs.last();
//            
//            Print data at last position
//            System.out.println(rs.getInt("id") + "\t" + rs.getString("isbn")
//            + "\t" + rs.getString("name") + "\t" + rs.getString("author"));
//            
//            Move cursor to previous position
//              rs.previous();
//            
//            Print data at previous position
//              System.out.println(rs.getInt("id") + "\t" + rs.getString("isbn")
//              + "\t" + rs.getString("name") + "\t" + rs.getString("author"));
//            
//            Move cursor to next position 
//            rs.next();
//            
//            Print data at next position
//            System.out.println(rs.getInt("id") + "\t" + rs.getString("isbn")
//            + "\t" + rs.getString("name") + "\t" + rs.getString("author"));
            
//            Move cursor to before first position
//            rs.beforeFirst();
//            
//            Print data at before first position
           
//            while (rs.next()) {
//            	 System.out.println(rs.getInt("id") + "\t" + rs.getString("isbn")
//                 + "\t" + rs.getString("name") + "\t" + rs.getString("author")); 
//            }
           
//            Move cursor to after last position
//            rs.afterLast();
            
//            Print data at after last position
//            while(rs.previous()) {
//            	 System.out.println(rs.getInt("id") + "\t" + rs.getString("isbn")
//                 + "\t" + rs.getString("name") + "\t" + rs.getString("author"));            	
//            }
            
            // DISPLAY THE RECORDS OF THE ROWSET
            
            Statement st = conn.createStatement();
//            
            String sql = "SELECT * FROM book";
//            
            ResultSet rs = st.executeQuery(sql);
//            
            CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
//            
            crs.populate(rs);
//            
         rs.close();
         st.close();
          conn.close();
//          
          while (crs.next()) {
        	  int id = crs.getInt("id");
        	  String isbn = crs.getString("isbn");
        	  String name = crs.getString("name");
        	  String author = crs.getString("author");
//        	  
        	  System.out.println(id + "\t" + isbn + "\t" + name + "\t" + author);
          }
//          
          crs.close();
//            
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}