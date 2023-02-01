package com.kembali;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import koneksi.DBConnection;

public class KembaliDaoImpl implements KembaliDaoIntrf{
    Connection con;
    
    @Override
    public void createKembali(Kembali emp) {
       Date date = new Date();
       java.sql.Date sqldate = new java.sql.Date(date.getTime());
       con =DBConnection.createDBConnetion();
       int bayar_denda = 500;
       long telat = 0;
       /*if(telat >7){
                emp.setKeterangan("Telat");
                emp.setDenda((int) ((telat-7)*bayar_denda));
            }else{
                emp.setKeterangan("Tidak telat");
                emp.setDenda((int) (telat*0));
            }*/
            
       String query="insert into tb_kembali values(?,?,?,?,?,'0','Tidak Telat','1')";
       String query2="Update tb_pinjam SET kt='Sudah Kembali' WHERE kode_pinjam='"+ emp.getKode_pinjam()+ "'";
       String query3="UPDATE tb_anggota set status='TidakPinjam' WHERE id_anggota='"+ emp.getId_anggota()+"'";
       //String query4="UPDATE tb_kembali SET denda = (DATEDIFF(CURDATE(), tanggal_kembali)*1000)\n" +
                    // "WHERE tanggal_kembali < CURDATE() AND denda IS NULL";
       try{
           
           PreparedStatement pstm=con.prepareStatement(query);
           PreparedStatement pstm2=con.prepareStatement(query2);
           PreparedStatement pstm3=con.prepareStatement(query3);
          // PreparedStatement pstm4=con.prepareStatement(query4);
           pstm.setString(1,emp.getKode_kembali());
           pstm.setString(2,emp.getKode_pinjam());
           pstm.setString(3,emp.getId_anggota());
           pstm.setString(4,emp.getKode_buku());
           pstm.setDate(5, sqldate);
           //pstm.setInt(6, emp.getDenda());
           //pstm.setString(7, emp.getKeterangan());
           
           
           
          
          pstm2.executeUpdate();
          pstm3.executeUpdate();
          //pstm4.executeUpdate();
          int cnt= pstm.executeUpdate();
          if(cnt!=0)
              System.out.println("Kembali Inserted Successfully !!!");


       }catch (Exception ex){
           ex.printStackTrace();
       }

    }

    @Override
    public void showAllKembali() {
        con=DBConnection.createDBConnetion();
        String query="select * from tb_kembali";
        System.out.println("Kembali Details :");
        System.out.println("---------------------------------------------");

        System.out.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n","Kode Kembali","Kode Pinjam","ID Anggota","Kode Buku","Tanggal Kembali","Jumlah","Keterangan","Jumlah");
        System.out.println("---------------------------------------------");

        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%s\t%s\t%s\t%s\t%s\t%d\t%s\t%d\n",
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getInt(6),
                        result.getString(7),
                        result.getInt(8));
                System.out.println("------------------------------------------------------------------------------------------");

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void showKembaliBasedOnID(String kode_kembali) {
        
        con=DBConnection.createDBConnetion();
        String query="select * from tb_kembali where kode_kembali=?";
        try{
           PreparedStatement stmt=con.prepareStatement(query);
           stmt.setString(1, kode_kembali);
           ResultSet result= stmt.executeQuery();
            while (result.next()){
                System.out.format("%s\t%s\t%s\t%s\t%s\t%d\t%s\t%d\n",
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getInt(6),
                        result.getString(7),
                        result.getInt(8));
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

   @Override
    public void updateKembali(String kode_kembali, String kode_buku) {
        con=DBConnection.createDBConnetion();
        String query="update tb_kembali set kode_kembali=? where kode_buku=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,kode_kembali);
            pstm.setString(2,kode_buku);
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Details updated successfully !!");

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    //@Override
    public void deleteKembali(String kode_kembali) {
        con=DBConnection.createDBConnetion();
        String query="delete from tb_kembali where kode_kembali=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,kode_kembali);
           int cnt= pstm.executeUpdate();
           if(cnt!=0)
               System.out.println("Deleted Successfully!!! "+kode_kembali);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
   public void denda(){
         
    }

    @Override
    public void hilangKembali(Kembali emp) {
      con=DBConnection.createDBConnetion();
      Date date = new Date();
      java.sql.Date sqldate = new java.sql.Date(date.getTime());
      int hilang = 20000;
      emp.setDenda(hilang);
        try {
       String query="insert into tb_kembali values(?,?,?,?,?,?,'Hilang','0')";
       String query2="Update tb_pinjam SET kt='Sudah Kembali' WHERE kode_pinjam='"+ emp.getKode_pinjam()+ "'";
       String query3="UPDATE tb_anggota set status='TidakPinjam' WHERE id_anggota='"+ emp.getId_anggota()+"'";
       
       PreparedStatement pstm=con.prepareStatement(query);
       PreparedStatement pstm2=con.prepareStatement(query2);
       PreparedStatement pstm3=con.prepareStatement(query3);
       
        pstm.setString(1,emp.getKode_kembali());
           pstm.setString(2,emp.getKode_pinjam());
           pstm.setString(3,emp.getId_anggota());
           pstm.setString(4,emp.getKode_buku());
           pstm.setDate(5, sqldate);
           pstm.setInt(6, emp.getDenda());
           
           
       pstm2.executeUpdate();
       pstm3.executeUpdate();
          //pstm4.executeUpdate();
       int cnt= pstm.executeUpdate();
       if(cnt!=0)
            System.out.println("Buku dinyatakan hilang dengan denda Rp. " + hilang);
        } catch (Exception e) {
        }
    }

    @Override
    public void perpanjang(Kembali emp, String kode_pinjam) {
        con=DBConnection.createDBConnetion();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, 7);
                String hrs_kembali;
                hrs_kembali = (df.format(cal.getTime()));
        
        try {
            int daysToAdd = 7;
            String query = "UPDATE tb_pinjam SET tgl_hrskembali = DATE_ADD(tgl_hrskembali, INTERVAL " + daysToAdd + " DAY) WHERE kode_pinjam = ?";
            String query2="Update tb_pinjam SET kt='Sudah Kembali' WHERE kode_pinjam='"+ emp.getKode_pinjam()+ "'";
            PreparedStatement pstm=con.prepareStatement(query);
            PreparedStatement pstm1=con.prepareStatement(query2);
            
           pstm.setString(1,kode_pinjam);
           
           int cnt= pstm.executeUpdate();
           pstm1.executeUpdate();
           if(cnt!=0){
               System.out.println("Berhasil di perpanjang"+kode_pinjam);
           }else{
               System.out.println("Masukan ID Pinjam Dengan Benar!!!!!");
           }
        } catch (Exception e) {
        }
    
    }
}