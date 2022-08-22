

package thithpqg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class THPT extends DiaPhuong {
    private String mathpt,tentruong;

    @Override
    public String toString() {
        return   mathpt+" - "+ tentruong;
    }

    public THPT(String mathpt, String tentruong, String madp) {
        super(madp);
        this.mathpt = mathpt;
        this.tentruong = tentruong;
    }

    public String getMathpt() {
        return mathpt;
    }

    public void setMathpt(String mathpt) {
        this.mathpt = mathpt;
    }

    public String getTentruong() {
        return tentruong;
    }

    public void setTentruong(String tentruong) {
        this.tentruong = tentruong;
    }
    //************************************************************
    public static Vector<THPT> getAll(String maTinh) throws ClassNotFoundException{
         Vector<THPT> mtruong=new Vector<THPT>();
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     String dbURL = "jdbc:sqlserver://localhost:1533;databaseName=Thi_THPTQG;user=sa;password=1234";
      Connection conn=null;
      try {   
    conn = DriverManager.getConnection(dbURL);// ket noi csdl qua duong dan
    PreparedStatement s= conn.prepareStatement("Select *from THPT where madp=?");// tao moi cau lenh de thu thi
   s.setString(1, maTinh);
    ResultSet rs=s.executeQuery();
    while(rs.next()){
       String mthpt=rs.getString(1);
       String tentruong =rs.getString(2);
       String madp=rs.getString(3);
       mtruong.add(new THPT(mthpt,tentruong,madp));
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
    return mtruong;
    
    }
//************************************************************   
}
