package com.buku;

import koneksi.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BukuDaoImpl implements BukuDaoIntrf{
    Connection con;
    
    @Override
    public void createBuku(Buku emp) {
       con =DBConnection.createDBConnetion();
       String query="insert into tb_buku values(?,?,?,?,?,?)";
       String query2 ="SELECT * FROM tbl_buku WHERE kode_buku = '" + emp.getKode_buku() + "'";
       try{
           PreparedStatement pstm=con.prepareStatement(query);
           //PreparedStatement pstm2=con.prepareStatement(query);
           pstm.setString(1,emp.getKode_buku());
           pstm.setString(2,emp.getJudul());
           pstm.setString(3,emp.getPenerbit());
           pstm.setInt(4,emp.getTahun_terbit());
           pstm.setString(5,emp.getKategori());
           pstm.setInt(6,emp.getJumlah());
           //ResultSet rs = pstm2.executeQuery();
           int cnt= pstm.executeUpdate();
           
          if(cnt!=0){
              System.out.println("Buku Inserted Successfully !!!");
          }else{
              System.out.println("Tambahkan data yang benar");
          }

       }catch (Exception ex){
           
           ex.printStackTrace();
       }

    }

    @Override
    public void showAllBuku() {
        con=DBConnection.createDBConnetion();
        String query="select * from tb_buku";
        System.out.println("Buku Details :");
        System.out.println("---------------------------------------------");

        System.out.format("%s\t%s\t%s\t%s\t%s\t%s\n","Kode Buku","Judul Buku","Penerbit","Tahun Terbit","Kategori","Jumlah Buku");
        System.out.println("---------------------------------------------");

        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%s\t%s\t%s\t%d\t%s\t%d\n",
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(5),
                        result.getInt(6));
                System.out.println("------------------------------------------------------------------------------------------");

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void showBukuBasedOnID(String kode) {
        
        con=DBConnection.createDBConnetion();
        String query="select * from tb_buku where kode_buku=?";
        try{
           PreparedStatement stmt=con.prepareStatement(query);
           stmt.setString(1, kode);
           ResultSet result= stmt.executeQuery();
            while (result.next()){
                System.out.format("%s\t%s\t%s\t%d\t%s\t%d\n",
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(5),
                        result.getInt(6));

            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

   @Override
    public void updateBuku(String kode_buku, String judul) {
        con=DBConnection.createDBConnetion();
        String query="update tb_buku set judul=? where kode_buku=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,judul);
            pstm.setString(2,kode_buku);
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Buku Details updated successfully !!");

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    //@Override
    public void deleteBuku(String kode_buku) {
        con=DBConnection.createDBConnetion();
        String query="delete from tb_buku where kode_buku=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,kode_buku);
           int cnt= pstm.executeUpdate();
           if(cnt!=0)
               System.out.println("Buku Deleted Successfully!!! "+kode_buku);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}