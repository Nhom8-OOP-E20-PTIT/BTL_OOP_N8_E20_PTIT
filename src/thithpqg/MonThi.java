package thithpqg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MonThi 
{
    private String maMon;
    private String tenMon;
    private int heSo;
    private java.sql.Date ngaythi;
    private java.sql.Time giothi;
   
//****************************************
    public String getMaMon() {return maMon;}

    public void setMaMon(String maMon) {this.maMon = maMon;}

    public String getTenMon() {return tenMon;}

    public void setTenMon(String tenMon) {this.tenMon = tenMon;}

    public int getHeSo() {return heSo;}

    public void setHeSo(int heSo) {this.heSo = heSo;}

    public java.sql.Date getNgaythi() {return ngaythi;}

    public void setNgaythi(java.sql.Date ngaythi) {this.ngaythi = ngaythi;}

    public Time getGiothi() {return giothi;}

    public void setGiothi(Time giothi) {this.giothi = giothi;}
    
    //****************************************
    public MonThi(String maMon) {this.maMon = maMon;}

    public MonThi() {
    }

//****************************************
    public MonThi(String maMon, String tenMon, int heSo,String ngay,String Gio) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.heSo = heSo;
         SimpleDateFormat ngayt=new SimpleDateFormat("dd/MM/yy");
        try {
            Date d=new Date(ngayt.parse(ngay).getTime());     
        this.ngaythi = new java.sql.Date(d.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SimpleDateFormat tg=new SimpleDateFormat("hh:mm:ss");
        try {
            Time d=new Time(tg.parse(Gio).getTime());     
        this.giothi = new java.sql.Time(d.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    //****************************************
    public void themmoiMonThi() throws ClassNotFoundException{
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     String dbURL = "jdbc:sqlserver://localhost:1533;databaseName=Thi_THPTQG;user=sa;password=1234";
      Connection conn=null;
      try {   
    conn = DriverManager.getConnection(dbURL);// ket noi csdl qua duong dan
    PreparedStatement s= conn.prepareStatement("INSERT INTO MONTHI values(?,?,?,?,?)");// tao moi cau lenh de thu thi
    s.setString(1,this.maMon);
     s.setString(2, this.tenMon);
     s.setInt(3,this.heSo);
      s.setDate(4, (java.sql.Date)this.ngaythi);
      s.setTime(5, giothi);
      int rs=s.executeUpdate();conn.close();// thu thi cau lenh
   // ResultSet rs=s.executeQuery("select *from nhanvien ");// thuc thi lenh sql
      if(rs!=1){
          throw new  RuntimeException("Không thể tương tác với database!");}
   } catch (SQLException ex) {
     System.err.println("Cannot connect database, " + ex);
   }finally{
          try {
              conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
          }
  }
    }

    @Override
    public String toString() {
        return  tenMon + heSo  + ngaythi + giothi;
    }


    
  //****************************************
    public static  ArrayList<MonThi> returnMonthiS() throws ClassNotFoundException{
          ArrayList<MonThi> result=new ArrayList();
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     String dbURL = "jdbc:sqlserver://localhost:1533;databaseName=Thi_THPTQG;user=sa;password=1234";
      Connection conn=null;
      try {   
    conn = DriverManager.getConnection(dbURL);// ket noi csdl qua duong dan
          Statement s=conn.createStatement();    
          ResultSet rs=  s.executeQuery("Select *from MONTHI");
          while(rs.next()){
              
  result.add(new MonThi(rs.getString(1),
          rs.getString(2),rs.getInt(3),
          Students.chuyenkieu_Date_to_String(rs.getString(4)),
          rs.getString(5)));
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
     //****************************************
    public static void main(String[] args) throws ClassNotFoundException {
        /*            MonThi a=new MonThi("TOAN", "TOÁN", 1,"22/07/2016","9:00:00");
        MonThi c=new MonThi("DIA", "Địa Lý", 1,"23/07/2016","14:00:00");
        MonThi b=new MonThi("VAN", "Ngữ Văn", 1,"24/07/2016","14:00:00");
        MonThi d=new MonThi("ANH", "Ngoại Ngữ", 1,"25/07/2016","14:00:00");
        a.themmoiMonThi();
        //  c.themmoiMonThi();
        //  b.themmoiMonThi();
        //  d.themmoiMonThi();*/
   
    }

}
