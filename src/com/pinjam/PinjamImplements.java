package com.pinjam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import koneksi.DBConnection;

public class PinjamImplements implements PinjamInterface{
    Connection con;
    
    @Override
    public void createPinjam(Pinjam emp) {
       con =DBConnection.createDBConnetion();
       String query="insert into tb_pinjam values(?,?,?,?,?,?,?,'1','Belum Kembali')";
       String query2 = "UPDATE tb_anggota set status='Pinjam' WHERE id_anggota='"+ emp.getId_anggota() +"'";
       try{
           PreparedStatement pstm=con.prepareStatement(query);
           PreparedStatement pstm2=con.prepareStatement(query2);
           pstm.setString(1, emp.getKode_pinjam());
           pstm.setString(2, emp.getId_anggota());
           pstm.setString(3, emp.getNama());
           pstm.setString(4, emp.getKode_buku());
           pstm.setString(5, emp.getJudul());
           pstm.setTimestamp(6, new Timestamp(emp.getTgl_pinjam().getTime()));
           pstm.setTimestamp(7, new Timestamp(emp.getTgl_hrskembali().getTime()));
           
           pstm2.executeUpdate();
          int cnt= pstm.executeUpdate();
          if(cnt!=0)
              System.out.println("Pinjam Inserted Successfully !!!");


       }catch (Exception ex){
           ex.printStackTrace();
       }

    }

    @Override
    public void showAllPinjam() {
        con=DBConnection.createDBConnetion();
        String query="select * from tb_pinjam";
        System.out.println("Pinjam Details :");
        System.out.println("---------------------------------------------");

        System.out.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n","Kode Pinjam","ID Anggota","Nama","Kode Buku","Judul","Tanggal Pinjam","Tanggal Kembali","Jumlah","Keterangan");
        System.out.println("---------------------------------------------");

        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%s\t%s\t%s\t%s\t%s\t%tc\t%tc\t%d\t%s\n",
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getDate(6),
                        result.getDate(7),
                        result.getInt(8),
                        result.getString(9));
                System.out.println("------------------------------------------------------------------------------------------");

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void showPinjamBasedOnID(String id) {
        
        con=DBConnection.createDBConnetion();
        String query="select * from tb_pinjam where kode_pinjam=?";
        System.out.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n","Kode Pinjam","ID Anggota","Nama","Kode Buku","Judul","Tanggal Pinjam","Tanggal Kembali","Jumlah","Keterangan");
        System.out.println("---------------------------------------------");
        try{
           PreparedStatement stmt=con.prepareStatement(query);
           stmt.setString(1, id);
           ResultSet result= stmt.executeQuery();
            while (result.next()){
                System.out.format("%s\t%s\t%s\t%s\t%s\t%tc\t%tc\t%d\t%s\n",
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getDate(6),
                        result.getDate(7),
                        result.getInt(8),
                        result.getString(9));

            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

   @Override
    public void updatePinjam(String id, String name) {
        con=DBConnection.createDBConnetion();
        String query="update tb_pinjam set kode_buku=? where kode_pinjam=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,id);
            pstm.setString(2,name);
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Pinjam Details updated successfully !!");

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    //@Override
    public void deletePinjam(String id) {
        con=DBConnection.createDBConnetion();
        String query="delete from tb_pinjam where kode_pinjam=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,id);
           int cnt= pstm.executeUpdate();
           if(cnt!=0)
               System.out.println("Pinjam Deleted Successfully!!! "+id);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}