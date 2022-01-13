package HomeWork1;

import java.sql.*;
import javax.management.Query;
import javax.swing.JOptionPane;

public class Selection {
private static String url="jdbc:mysql://localhost:3306/cci";
private static String user="root";
private static String password="";
private static String driver="com.mysql.jdbc.Driver";
 
 Connection connMethod() throws ClassNotFoundException, SQLException{
   Class.forName(driver);
   Connection con=null;
  
   try{
        con=DriverManager.getConnection(url,user,password); 
       
   }catch(SQLException e){
       
     JOptionPane.showMessageDialog(null, "Error :" +e); 
   }
 
  
   try{ 
      Statement  stmt = con.createStatement();
     
       ResultSet res=stmt.executeQuery("select * from dept_tb1");
       
        while(res.next()){
            
           System.out.println(res.getString(1)+" \t"+res.getString(2)+" \t "+res.getString(3)+" \t"+res.getString(4)+" \t"+res.getString(5)+" \t"+res.getString(6));
           
            
       }
     
   }catch(Exception e){
   JOptionPane.showMessageDialog(null, "Error :" +e); 
       
   }
   
      
   
   
   
   
   return con;



    }
}
