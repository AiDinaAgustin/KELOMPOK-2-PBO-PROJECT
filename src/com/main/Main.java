/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import com.anggota.MainAnggota;
import com.buku.MainBuku;
import com.kembali.MainKembali;
import com.petugas.MainPetugas;
import com.pinjam.MainPinjam;
import java.util.Scanner;

/**
 *
 * @author Dina
 */
public class Main {
    
    public void menu(){
        Scanner sc = new Scanner(System.in);
        MainPetugas petugas =  new MainPetugas();
        
        MainAnggota anggota = new MainAnggota();
        
        MainBuku buku = new MainBuku();
        
        MainPinjam pinjam = new MainPinjam();
        
        MainKembali kembali = new MainKembali();
        
        System.out.println("--------------Selamat Datang Di SIP-----------------------\n");
        do {            
            System.out.println("1. Data Buku\n" + 
                    "2. Data Anggota\n" + 
                    "3. Data Petugas\n" + 
                    "4. Peminjaman Buku\n" + 
                    "5. Pengembalian Buku\n" +
                    "6. Exit");
            System.out.print("Masukan Pilihan Menu : ");
            int pilih = sc.nextInt();
            switch (pilih){
                case 1:
                    buku.main();
                    break;
                case 2:
                    anggota.main();
                    break;
                case 3:
                    petugas.main();
                    break;
                case 4:
                    pinjam.main();
                    break;
                case 5:
                    kembali.main();
                    break;

                case 6:
                    System.out.println("Terima kasih sudah memakai aplikasi!");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice !");
                    break;
            }
        } while (true);
    }
    public static void main(String[] args) {
        Main menu = new Main();
        //Memanggil method main
        menu.menu();
        
    } 
}
