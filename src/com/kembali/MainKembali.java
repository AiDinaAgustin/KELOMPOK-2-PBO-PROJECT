package com.kembali;


import com.main.Main;
import com.pinjam.PinjamImplements;

import java.util.Scanner;

public class MainKembali {
    
    public void main(){
        Main utama = new Main();
        PinjamImplements pinjam = new PinjamImplements();
        String kode_kembali;
        String kode_pinjam;
        KembaliDaoIntrf dao=new KembaliDaoImpl();
        Kembali emp=new Kembali();
        System.out.println("-----------Data Pengembalian Buku-----------");

        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("1. Kembalikan Buku\n" +
                    "2. Show All Kembali\n" +
                    "3. Show Kembali based on id \n" +
                    "4. Perpanjang\n" +
                    "5. Hilang\n" +
                    "6. Delete the Kembali\n" +
                    "7. Kembali ke Menu Utama\n" +
                    "8. Exit Aplikasi");

            System.out.print("Enter Choice: ");
            int ch=sc.nextInt();
            switch (ch){
                case 1:
                    System.out.println("\t\t Data peminjaman");
                    pinjam.showAllPinjam();
                    
                    System.out.print("Enter Kode kembali : ");
                    kode_kembali=sc.next();
                    System.out.print("Enter Kode pinjam : ");
                    kode_pinjam=sc.next();
                    System.out.print("Enter ID anggota :");
                    String id_anggota = sc.next();
                    System.out.print("Enter Kode Buku : ");
                    String kode_buku=sc.next();
                    
                    
                    
                    emp.setKode_kembali(kode_kembali);
                    emp.setKode_pinjam(kode_pinjam);
                    emp.setId_anggota(id_anggota);
                    emp.setKode_buku(kode_buku);
                    
                    dao.createKembali(emp);
                    break;
                case 2:
                    dao.showAllKembali();
                    break;
                case 3:
                    System.out.print("Enter kode kembali to show the details : ");
                    String kode=sc.next();
                    dao.showKembaliBasedOnID(kode);
                    break;
                case 4 :
                    System.out.println("Masukan kode pinjam yang ingin diperpanjang : ");
                    kode_pinjam = sc.next();
                    dao.perpanjang(emp, kode_pinjam);
                    break;
                case 5:
                    System.out.print("Enter Kode kembali : ");
                    kode_kembali=sc.next();
                    System.out.print("Enter Kode pinjam : ");
                    kode_pinjam=sc.next();
                    System.out.print("Enter ID anggota :");
                    id_anggota = sc.next();
                    System.out.print("Enter Kode Buku : ");
                    kode_buku=sc.next();
                    
                    emp.setKode_kembali(kode_kembali);
                    emp.setKode_pinjam(kode_pinjam);
                    emp.setId_anggota(id_anggota);
                    emp.setKode_buku(kode_buku);
                    
                    dao.hilangKembali(emp);
                    break;
                case 6:
                    System.out.print("Enter the id to delete : ");
                    kode_kembali=sc.next();
                    dao.deleteKembali(kode_kembali);
                    break;
                case 7:
                    utama.menu();
                    break;
                case 8:
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