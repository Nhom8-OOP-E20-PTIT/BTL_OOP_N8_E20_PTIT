

package thithpqg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Students 
{
    private String scmnd,ho,ten,gioitinh,kv,matkhau,dt,mathpt;
    private java.sql.Date ngaysinh;
    public Date getNgaysinh() {return ngaysinh;}

    public String getTen() { return ten;}

    public String getHo() {return ho;}

    public void setHo(String ho) {this.ho = ho;}

    public String getScmnd() {return scmnd;}

    public String getGioitinh() {return gioitinh;}

    public void setGioitinh(String gioitinh) {this.gioitinh = gioitinh;}

    public String getKv() {return kv;}

    public void setKv(String kv) {this.kv = kv;}

    public String getMatkhau() {return matkhau;}

    public void setMatkhau(String matkhau) {this.matkhau = matkhau;}

    public String getDt() {return dt;}

    public void setDt(String dt) {this.dt = dt;}

    public String getMathpt() { return mathpt;}

    public void setMathpt(String mathpt) {this.mathpt = mathpt;}

    public void setScmnd(String scmnd) {this.scmnd = scmnd;}


    public  Students() {}
    
    public Students(String scmnd, String ho, String ten, String gioitinh, String kv, String matkhau, String dt, String ngaysinh,String mathpt) {
        this.scmnd = scmnd;
        this.ho = ho;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.kv = kv;
        this.matkhau = matkhau;
        this.dt = dt;
        this.mathpt=mathpt;
        this.ngaysinh=chuyenkieudate_sqldate(ngaysinh);
    }
 //########################################################################################
    public static  java.sql.Date chuyenkieudate_sqldate(String ngays){
        java.sql.Date p = null;
     SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yy");
        try {
            Date d=new Date(sd.parse(ngays).getTime());     
        p = new java.sql.Date(d.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
   //#
 //########################################################################################
    public Students (String cmnd,String mk) throws ClassNotFoundException{
     Connection conn=null;
      ResultSet rs=null;
      Students a=null;
      try {          
    conn = DriverManager.getConnection(load_driver("Thi_THPTQG"));
     PreparedStatement s= conn.prepareStatement("select *from THISINH where scmnd=? and matkhau=?");
     s.setString(1, cmnd);
     s.setString(2, mk);
  rs =s.executeQuery();// thuc thi lenh sql tra ve database
  if(rs.next()){  
//(String scmnd, String ho, String ten, String gioitinh, String kv, String matkhau, String dt, String ngaysinh,String mathpt)
             this.scmnd=rs.getString(1);
             this.ho=rs.getString(2);
             this.ten=rs.getString(3);
          this.ngaysinh=chuyenkieudate_sqldate(chuyenkieu_Date_to_String(rs.getString(4))); 
         this.gioitinh  =rs.getString(5);
        this.dt= rs.getString(6);
           this.kv=  rs.getString(7);
            this.mathpt=  rs.getString(8);
          this.matkhau=   rs.getString(9);      
     
}conn.close();
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
//########################################################################################
    public static  String load_driver(String name_database) throws ClassNotFoundException{  
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     String dbURL = "jdbc:sqlserver://localhost:1533;databaseName="+name_database+";user=sa;password=1234";
    return dbURL;
    }
//########################################################################################
    public boolean Connect_insertdatabase() throws ClassNotFoundException{
      Connection conn=null;
      boolean flag=true;
      try {   
    conn = DriverManager.getConnection( load_driver("Thi_THPTQG"));// ket noi csdl qua duong dan
    PreparedStatement s= conn.prepareStatement("INSERT INTO THISINH values(?,?,?,?,?,?,?,?,?)");// tao moi cau lenh de thu thi
     s.setString(1, scmnd);
     s.setString(2, ho);
     s.setString(3, ten);
     
      s.setDate(4, (java.sql.Date)ngaysinh);
      s.setString(5, gioitinh);
      s.setString(6, dt);
       s.setString(7, kv);
       s.setString(8, mathpt);
        s.setString(9, matkhau);
      int rs=s.executeUpdate();conn.close();// thu thi cau lenh
   // ResultSet rs=s.executeQuery("select *from nhanvien ");// thuc thi lenh sql
      if(rs!=1){
          flag=false;
          throw new  RuntimeException("Không thể tương tác với database!");}
   } catch (SQLException ex) {
        flag=false;
     System.err.println("Cannot connect database, " + ex);
   }finally{
          try {
              conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
          }
  }
      return flag;
    }
    
//########################################################################################
    public  Students Connect_selectdatabase(String macmnd) throws ClassNotFoundException, SQLException{
     Connection conn=null;
      ResultSet rs=null;
      Students a=null;
      try {          
    conn = DriverManager.getConnection(load_driver("Thi_THPTQG"));
     PreparedStatement s= conn.prepareStatement("select *from THISINH where scmnd=?");
     s.setString(1, macmnd);
  rs =s.executeQuery();// thuc thi lenh sql tra ve database
  if(rs.next()){  
//(String scmnd, String ho, String ten, String gioitinh, String kv, String matkhau, String dt, String ngaysinh,String mathpt)
      a=new Students(rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(5),
             rs.getString(7),rs.getString(9),rs.getString(6),
              chuyenkieu_Date_to_String(rs.getString(4)),rs.getString(8));
     
}conn.close();
      } catch (SQLException ex) {
     System.err.println("Cannot connect database, " + ex);
   }finally{
          try {     
              conn.close();
             
          } catch (SQLException ex) {
              Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
          }
       
  }
      return a;
    }
//########################################################################################
    public  Vector<Vector> XemLichThi() throws ClassNotFoundException{
        Vector LT=new Vector();
      Connection conn=null;
      try {   
    conn = DriverManager.getConnection(load_driver("Thi_THPTQG"));// ket noi csdl qua duong dan
         PreparedStatement s= conn.prepareStatement("Select tenmon,heso,ngaythi,giothi,phongthi from MONTHI,LICHCN,DKTHI\n" +
" where MONTHI.mamon=LICHCN.mamon and LICHCN.madk=DKTHI.madk\n" +
" and DKTHI.scmnd=?");// tao moi cau lenh de thu thi
         s.setString(1,scmnd);
        ResultSet rs=s.executeQuery();
          while(rs.next()){  
              Vector Luu=new Vector(5,5);
               Luu.add(rs.getString(1));
               Luu.add(rs.getInt(2));
               Luu.add( Students.chuyenkieu_Date_to_String(rs.getString(3)));
               Luu.add(rs.getString(4));
               Luu.add(rs.getString(5));
               LT.add(Luu);
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
    return LT; 
    }
//########################################################################################
    
     public  Vector<Vector> XemDiemThi() throws ClassNotFoundException{
        Vector DT=new Vector();
      Connection conn=null;
      try {   
    conn = DriverManager.getConnection(load_driver("Thi_THPTQG"));// ket noi csdl qua duong dan
         PreparedStatement s= conn.prepareStatement("Select tenmon,heso,ngaythi,phongthi,diem from MONTHI,LICHCN,DKTHI\n" +
" where MONTHI.mamon=LICHCN.mamon and LICHCN.madk=DKTHI.madk\n" +
" and DKTHI.scmnd=?");// tao moi cau lenh de thu thi
         s.setString(1,scmnd);
        ResultSet rs=s.executeQuery();
          while(rs.next()){  
              Vector Luu=new Vector(5,5);
               Luu.add(rs.getString(1));
               Luu.add(rs.getDouble(2));
               Luu.add( Students.chuyenkieu_Date_to_String(rs.getString(3)));
               Luu.add(rs.getString(4));
               if(rs.getString(5)==null){ Luu.add("Chưa có điểm");}else
               Luu.add(rs.getString(5));
               DT.add(Luu);
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
    return DT; 
    }
//########################################################################################
      public  ArrayList<MonThi> returnMonthidaDK() throws ClassNotFoundException{
          ArrayList<MonThi> result=new ArrayList();
      Connection conn=null;
      try {   
            conn = DriverManager.getConnection(load_driver("Thi_THPTQG"));// ket noi csdl qua duong dan
         PreparedStatement s= conn.prepareStatement("select MONTHI.mamon,tenmon,heso,ngaythi,giothi from MONTHI,DKTHI,LICHCN where DKTHI.madk=LICHCN.madk and MONTHI.mamon=LICHCN.mamon and scmnd=?");// tao moi cau lenh de thu thi
         s.setString(1,scmnd);
        ResultSet rs=s.executeQuery();
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
//########################################################################################
     public static boolean DangKymonthi(int madk,ArrayList<MonThi> mon) throws ClassNotFoundException, SQLException{
         Connection conn=null;
        boolean flag=true;
        try {
            conn = DriverManager.getConnection( load_driver("Thi_THPTQG"));// ket noi csdl qua duong dan
             conn.setAutoCommit(false);// Để tự quản lý việc commit trên chương trình.
            PreparedStatement s= conn.prepareStatement("INSERT INTO LICHCN(madk,mamon) values(?,?)");// tao moi cau lenh de thu thi
        for(MonThi m:mon){
         s.setInt(1,madk);
         s.setString(2,m.getMaMon());
         int rs=s.executeUpdate();
        
         if(rs!=1){flag=false;}
        }
        conn.commit();//nếu không có lỗi thì insert dữ liệu vào
     conn.close();
        } 
        catch (com.microsoft.sqlserver.jdbc.SQLServerException ex) {
             conn.rollback();//nếu lỗi thì trở về ban đầu không commit dữ liệu vào
            flag=false;
            System.out.println("Lỗi khi đăng kí");
        }
        catch (SQLException ex) {
            flag=false;
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        } finally{  
                 conn.close();  
          } 
     return flag;
     }
//########################################################################################
       public static boolean dangKymonthi(int madk,ArrayList mon) throws ClassNotFoundException, SQLException{
         Connection conn=null;
        boolean flag=true;
        try {
            conn = DriverManager.getConnection( load_driver("Thi_THPTQG"));// ket noi csdl qua duong dan
             conn.setAutoCommit(false);// Để tự quản lý việc commit trên chương trình.
            PreparedStatement s= conn.prepareStatement("INSERT INTO LICHCN(madk,mamon) values(?,?)");// tao moi cau lenh de thu thi
        for(int i=0;i<mon.size();i++){
         s.setInt(1,madk);
         s.setString(2,mon.get(i).toString());
         int rs=s.executeUpdate();
         if(rs!=1){flag=false;}
        }
        conn.commit();//nếu không có lỗi thì insert dữ liệu vào
     conn.close();
        } 
        catch (com.microsoft.sqlserver.jdbc.SQLServerException ex) {
             conn.rollback();//nếu lỗi thì trở về ban đầu không commit dữ liệu vào
            flag=false;
            System.out.println("Lỗi khi đăng kí");
        }
        catch (SQLException ex) {
            flag=false;
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        } finally{  
                 conn.close();  
          } 
     return flag;
     }
//########################################################################################
      public static boolean XoaMonThi(int madk,ArrayList<MonThi> mon) throws ClassNotFoundException, SQLException{
         Connection conn=null;
        boolean flag=true;
        try {
            conn = DriverManager.getConnection( load_driver("Thi_THPTQG"));// ket noi csdl qua duong dan
            PreparedStatement s= conn.prepareStatement("delete from LICHCN where madk=? and mamon=?");// tao moi cau lenh de thu thi
        for(MonThi m:mon){
         s.setInt(1,madk);
         s.setString(2,m.getMaMon());
         int rs=s.executeUpdate();
         if(rs!=1){flag=false;}
        }
     conn.close();
        } 
        catch (com.microsoft.sqlserver.jdbc.SQLServerException ex) {
            flag=false;
            System.out.println("Lỗi khi xóa");
        }
        catch (SQLException ex) {
            flag=false;
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        } finally{  
                 conn.close();  
          } 
     return flag;
     }
//########################################################################################
     public int DangKyCumThi(String macum,String scmnd) throws ClassNotFoundException{
        Connection conn=null;
        int madk=0;
      try {   
    conn = DriverManager.getConnection( load_driver("Thi_THPTQG"));// ket noi csdl qua duong dan
    PreparedStatement s= conn.prepareStatement("INSERT INTO DKTHI(scmnd,macum) values(?,?)");// tao moi cau lenh de thu thi
     s.setString(1,scmnd);
    s.setString(2,macum);
      int rs=s.executeUpdate();// thu thi cau lenh
   // ResultSet rs=s.executeQuery("select *from nhanvien ");// thuc thi lenh sql
      if(rs==1){
        Statement ss=conn.createStatement();
    ResultSet rss=ss.executeQuery("Select @@IDENTITY");// thuc thi lenh sql tra ve database
     if(rss.next()){  madk=rss.getInt(1);}
      }  conn.close();
   } catch (SQLException ex) {
     System.err.println("Cannot connect database, " + ex);
   }finally{
          try {
              conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
          }
  }
     return madk;
     }
     
//########################################################################################
    public static  Students Login(String scmnd,String mk) throws ClassNotFoundException, SQLException{
     Students a=new Students(scmnd, mk);
     if(a!=null) {   
           return a; 
     }else return null; 
   }
//########################################################################################
 public  boolean doimatkhau(String mkm) throws ClassNotFoundException, SQLException{
     boolean flag=false;
    Connection conn=null;
        int madk=0;
      try {   
    conn = DriverManager.getConnection( load_driver("Thi_THPTQG"));// ket noi csdl qua duong dan
    PreparedStatement s= conn.prepareStatement("update  THISINH set matkhau=? where scmnd=?");// tao moi cau lenh de thu thi
     s.setString(1,mkm);
    s.setString(2,scmnd);
      int rs=s.executeUpdate();// thu thi cau lenh
      if(rs==1){flag=true;}
       conn.close();
      }  
   catch (SQLException ex) {
     System.err.println("Cannot connect database, " + ex);
   }finally{
          try {
              conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
          }
  }
      return flag;
 } 
//########################################################################################
 public int xemmadk() throws ClassNotFoundException, SQLException{
     int madk=0;
      Connection conn=null;
     try{
     
     conn=DriverManager.getConnection(load_driver("Thi_THPTQG"));
     PreparedStatement s=conn.prepareStatement("select madk from DKTHI where scmnd=?");
     s.setString(1, scmnd);
     ResultSet rs=s.executeQuery();
     if(rs.next()){
     madk=rs.getInt(1);
     }
     conn.close();
     }catch(Exception e){
         System.out.println("su co");
     }finally{
       conn.close();
     }
    
 return madk;
 }
//########################################################################################
public boolean Capnhaphoso() throws SQLException{
    boolean flag=false;
    Connection conn=null;
     try{   
     conn=DriverManager.getConnection(load_driver("Thi_THPTQG"));
     PreparedStatement s=conn.prepareStatement("Update  THISINH set ten=?,holot=?,birthday=?,doituong=?,gioitinh=?,khuvuc=?,mathpt=?,matkhau=? where scmnd=?");
    s.setString(1, ten);
    s.setString(2, ho);
    s.setDate(3, ngaysinh);
    s.setString(4, dt);
    s.setString(5, gioitinh);
    s.setString(6, kv);
    s.setString(7, mathpt);
    s.setString(8, matkhau);
     s.setString(9, scmnd);
    int rs=s.executeUpdate();
    if(rs==1){flag=true;}
     conn.close();
     }catch(Exception e){
         System.out.println("su co");
     }finally{
       conn.close();
     }     
return flag;
}
//######################################################################################## 
 public String getMADP() throws SQLException{
     String madp="";
         Connection conn=null;
     try{   
     conn=DriverManager.getConnection(load_driver("Thi_THPTQG"));
     PreparedStatement s=conn.prepareStatement("Select madp from THPT where mathpt=?");
    s.setString(1,mathpt);
     ResultSet rs=s.executeQuery();
     if(rs.next()){
     madp=rs.getString(1);
     }
     conn.close();
     }catch(Exception e){
         System.out.println("su co");
     }finally{
       conn.close();
     }     
 return madp;
 }  
 
 public static  void mangdanhsach(){
 Connection conn=null;
        try {
            conn=DriverManager.getConnection(load_driver("Thi_THPTQG"));
            PreparedStatement s=conn.prepareStatement("select *from THISINH");
            ResultSet rs=s.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
            Statement st=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
           ResultSet rss=st.executeQuery( "select *from THISINH");
            rss.last();
            rss.moveToInsertRow();
            rss.updateString(1,"000000000");
            rss.updateString(2,"duong");
            rss.updateString(3,"thanh");
            rss.updateString(4,"1997-07-07");
            rss.updateString(5,"1");
            rss.updateString(6,"1");
            rss.updateString(7,"1");
            rss.updateString(8,"01-040");
            rss.updateString(9,"123");
            rss.insertRow();
               while(rss.next()){
                System.out.println(rss.getString(1));
            }
               rss.last();
               rss.updateString(9, "congthanh");
               rss.updateRow();
               
               rss.absolute(0);
                 rss.deleteRow();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }
        
 
 }
         public static  String chuyenkieu_Date_to_String(String date){
        String rs="";
    SimpleDateFormat sd=new SimpleDateFormat("yyy-MM-dd");
    SimpleDateFormat result= new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.println(sd.parse(date));
            rs =result.format(sd.parse(date));
        } catch (ParseException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }
           return rs;       
       
        
   }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
  
    Vector<Vector> d=new Students("206047186","123").XemDiemThi();
        for (Vector vector : d) {
            System.out.println(vector);
            
        }
     
    }
}

