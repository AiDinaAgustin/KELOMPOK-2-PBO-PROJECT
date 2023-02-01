package com.petugas;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import koneksi.DBConnection;

public class PetugasImplements implements PetugasInterface{
    Connection con;

    @Override
    public void createPetugas(Petugas emp) {
       con =DBConnection.createDBConnetion();
       String query="insert into tb_petugas values(?,?,?,?,?,?)";
       try{
           PreparedStatement pstm=con.prepareStatement(query);
           pstm.setString(1,emp.getId_operator());
           pstm.setString(2,emp.getNama());
           pstm.setString(3,emp.getPassword());
           pstm.setString(4,emp.getJk());
           pstm.setString(5,emp.getTelp());
           pstm.setString(6,emp.getAlamat());
          int cnt= pstm.executeUpdate();
          if(cnt!=0)
              System.out.println("Berhasil memasukan Petugas!");
       }catch (Exception ex){
           ex.printStackTrace();
       }

    }

    @Override
    public void showAllPetugas() {
        con=DBConnection.createDBConnetion();
        String query="select * from tb_petugas";
        System.out.println("Menampilkan Detail Petugas : ");
        System.out.println("---------------------------------------------");

        System.out.format("%s\t%s\t%s\t%s\t%s\t%s\t\n","ID Operator","Nama","Password","JK","Telp","Alamat");
        System.out.println("---------------------------------------------");

        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%s\t%s\t%s\t%s\t%s\t%s\t\n",
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6));
                System.out.println("------------------------------------------------------------------------------------------");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void showPetugasBasedOnID(String id) {
        con=DBConnection.createDBConnetion();
        String query="select * from tb_petugas where id_operator=?";
        try{
           PreparedStatement stmt=con.prepareStatement(query);
           stmt.setString(1, id);
           ResultSet result= stmt.executeQuery();
           while (result.next()){
                System.out.format("%s\t%s\t%s\t%s\t%s\t%s\t\n",
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6));
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

   @Override
    public void updatePetugas(String id, String name) {
        con=DBConnection.createDBConnetion();
        String query="update tb_petugas set nama=? where id_operator=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setString(2,id);
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Berhasil mengupdate Petugas!");

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    //@Override
    public void deletePetugas(String id) {
        con=DBConnection.createDBConnetion();
        String query="delete from tb_petugas where id_operator=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,id);
           int cnt= pstm.executeUpdate();
           if(cnt!=0)
               System.out.println("Petugas berhasil dihapus! "+id);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}