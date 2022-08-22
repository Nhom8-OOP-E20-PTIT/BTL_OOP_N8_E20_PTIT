

package thithpqg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DiaPhuong {
    private String madp,tenqh,tinh;

    public String getMadp() {
        return madp;
    }

    public void setMadp(String madp) {
        this.madp = madp;
    }

    public String getTenqh() {
        return tenqh;
    }

    public void setTenqh(String tenqh) {
        this.tenqh = tenqh;
    }

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    public DiaPhuong() {
    }

    public DiaPhuong(String madp, String tenqh, String tinh) {
        this.madp = madp;
        this.tenqh = tenqh;
        this.tinh = tinh;
    }
    public DiaPhuong(String madp) {
        this.madp = madp;
    }

    @Override
    public String toString() {
        return  madp+" - "+tenqh;
    }
    
    public static Vector<DiaPhuong> getAllDP() throws ClassNotFoundException, SQLException{
    Vector<DiaPhuong> mdp=new Vector<DiaPhuong>();
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     String dbURL = "jdbc:sqlserver://localhost:1533;databaseName=Thi_THPTQG;user=sa;password=1234";
      Connection conn=null;
      try {   
    conn = DriverManager.getConnection(dbURL);// ket noi csdl qua duong dan
    PreparedStatement s= conn.prepareStatement("Select *from DIAPHUONG");// tao moi cau lenh de thu thi
    ResultSet rs=s.executeQuery();
    while(rs.next()){
       String iddp=rs.getString(1);
       String tenqh =rs.getString(2);
       String tinh=rs.getString(3);
       mdp.add(new DiaPhuong(iddp,tenqh,tinh));
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
    return mdp;
    
    }
}
