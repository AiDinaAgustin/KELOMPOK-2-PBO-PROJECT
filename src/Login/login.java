/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import com.main.Main;
import java.sql.Connection;
import java.util.Scanner;
import koneksi.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Dina
 */
public class login {
    String id_operator;
    String password;
    static Connection con;
    static ResultSet rs;
    static PreparedStatement ps;
    
    public void login(){
        Main utama = new Main();
        Connection con = DBConnection.createDBConnetion();
        do {            
          Scanner sc = new Scanner(System.in);
        System.out.println("------------------Silahkan Login------------------");
        System.out.print("Masukan ID Operator : ");
        id_operator = sc.next();
        System.out.print("Masukan Password : ");
        password = sc.next();
        
        try {
            String query="SELECT * FROM tb_petugas WHERE id_operator=? AND password=?";
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1, id_operator);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            if(rs.next()){
                System.out.println("\t------Login Berhasil------\n");
                utama.menu();  
            }else{
                System.out.println("ID atau Password salah silahkan login kembali");
            }
        } catch (Exception e) {
        }  
        } while (true);
        
        
    }
    public static void main(String[] args) {
        login Login = new login();
        Login.login();
    }
}
