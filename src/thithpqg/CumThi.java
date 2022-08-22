

package thithpqg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CumThi extends DiaPhuong{
    private  String macum,tecum;

    public CumThi() {
    }

    public CumThi(String madp,String macum,String tencum) {
        super(madp);
        this.macum=macum;
        this.tecum=tencum;
    }

    public String getMacum() {
        return macum;
    }

    public void setMacum(String macum) {
        this.macum = macum;
    }

    public String getTecum() {
        return tecum;
    }

    public void setTecum(String tecum) {
        this.tecum = tecum;
    }
    //**********************************************************
    public static  ArrayList caccumthi() throws ClassNotFoundException{
        ArrayList result=new ArrayList();
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     String dbURL = "jdbc:sqlserver://localhost:1533;databaseName=Thi_THPTQG;user=sa;password=1234";
      Connection conn=null;
      try {   
    conn = DriverManager.getConnection(dbURL);// ket noi csdl qua duong dan
          Statement s=conn.createStatement();    
          ResultSet rs=  s.executeQuery("Select *from CUMTHI");
          while(rs.next()){
          result.add(rs.getString(1));
          }
           conn.close();
   } catch (SQLException ex) {
     System.err.println("Cannot connect database, " + ex);
   }finally{
          try {
              conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
          }
  }
    return result;
    }
   //**********************************************************
    public static void main(String[] args) throws ClassNotFoundException {
       
    }
}
