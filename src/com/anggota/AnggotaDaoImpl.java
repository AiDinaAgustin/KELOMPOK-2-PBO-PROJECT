package com.anggota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import koneksi.DBConnection;

public class AnggotaDaoImpl implements AnggotaDaoIntrf{
    Connection con;

    @Override
    public void createAnggota(Anggota emp) {
       con =DBConnection.createDBConnetion();
       String query="insert into tb_anggota values(?,?,?,?,?,?,'TidakPinjam')";
       try{
           PreparedStatement pstm=con.prepareStatement(query);
           pstm.setString(1,emp.getId());
           pstm.setString(2,emp.getName());
           pstm.setString(3,emp.getPassword());
           pstm.setString(4,emp.getJk());
           pstm.setString(5,emp.getTelp());
           pstm.setString(6,emp.getAlamat());
           //pstm.setString(7,emp.getStatus());
          int cnt= pstm.executeUpdate();
          if(cnt!=0)
              System.out.println("Anggota Inserted Successfully !!!");


       }catch (Exception ex){
           ex.printStackTrace();
       }

    }

    @Override
    public void showAllAnggota() {
        con=DBConnection.createDBConnetion();
        String query="select * from tb_anggota";
        System.out.println("Anggota Details :");
        System.out.println("---------------------------------------------");

        System.out.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\n","ID","Nama","password","JK","Telp","Alamat","Status");
        System.out.println("---------------------------------------------");

        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\n",
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7));
                System.out.println("------------------------------------------------------------------------------------------");

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void showAnggotaBasedOnID(String id) {
        con=DBConnection.createDBConnetion();
        String query="select * from tb_anggota where id_anggota=?";
        try{
           PreparedStatement stmt=con.prepareStatement(query);
           stmt.setString(1, id);
           ResultSet result= stmt.executeQuery();
            while (result.next()){
                System.out.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\n",
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7));

            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

   @Override
    public void updateAnggota(String id, String name) {
        con=DBConnection.createDBConnetion();
        String query="update tb_anggota set nama=? where id_anggota=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setString(2,id);
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Anggota Details updated successfully !!");

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    //@Override
    public void deleteAnggota(String id) {
        con=DBConnection.createDBConnetion();
        String query="delete from tb_anggota where id_anggota=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,id);
           int cnt= pstm.executeUpdate();
           if(cnt!=0)
               System.out.println("Anggota Deleted Successfully!!! "+id);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}