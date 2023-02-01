package com.pinjam;

import com.anggota.AnggotaDaoImpl;
import com.buku.BukuDaoImpl;
import com.main.Main;
import com.petugas.PetugasImplements;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;

public class MainPinjam {
    
    public void main(){
        Main utama = new Main();
        String name;
        String id;
        PinjamInterface dao=new PinjamImplements();
        PetugasImplements petugas = new PetugasImplements();
        BukuDaoImpl buku = new BukuDaoImpl();
        AnggotaDaoImpl anggota = new AnggotaDaoImpl();
        Pinjam pinjam=new Pinjam();
        System.out.println("-----------Data Peminjaman Buku-----------");

        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("1. Add Pinjam\n" +
                    "2. Show All Pinjam\n" +
                    "3. Show Pinjam based on ID \n" +
                    "4. Delete the Pinjam\n" +
                    "5. Kembali ke Menu Utama\n" +
                    "6. Exit Aplikasi");

            System.out.print("Enter Choice: ");
            int ch=sc.nextInt();
            switch (ch){
                case 1:
                    System.out.println("\t\t----------Data Anggota-----------");
                    anggota.showAllAnggota();
                    System.out.println();
                    
                    System.out.println("\t\t----------Data Buku-----------");
                    buku.showAllBuku();
                    System.out.println();
                    
                    Pinjam emp=new Pinjam();
                    System.out.print("Masukan Kode Pinjam : ");
                    String kd_pinjam = sc.next();
                    System.out.print("Masukan ID Anggota : ");
                    String id_anggota = sc.next();
                    System.out.print("Masukan Nama : ");
                    String nama = sc.next();
                    System.out.print("Masukan kode buku : ");
                    String kode_buku = sc.next();
                    System.out.print("Masukan judul : ");
                    String judul = sc.next();
                    
                    emp.setKode_pinjam(kd_pinjam);
                    emp.setId_anggota(id_anggota);
                    emp.setNama(nama);
                    emp.setKode_buku(kode_buku);
                    emp.setJudul(judul);
                    dao.createPinjam(emp);
                    break;
                case 2:
                    dao.showAllPinjam();
                    break;
                case 3:
                    System.out.print("Masukan Kode Pinjam untuk menampilkan detail : ");
                    String empid=sc.next();
                    dao.showPinjamBasedOnID(empid);
                    break;
                case 4:
                    System.out.print("Masukan Kode Pinjam yang akan dihapus : ");
                    id=sc.next();
                    dao.deletePinjam(id);
                    break;
                case 5:
                    utama.menu();
                    break;
                case 6:
                    System.out.println("Thank you for using our Application !!!");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice !");
                    break;
            }
        }while (true);
    }
    public static void main(String[] args) {
        
    }
}