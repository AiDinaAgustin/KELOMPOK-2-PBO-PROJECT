package com.buku;

import com.main.Main;
import java.util.Scanner;

public class MainBuku {
    
    public void main(){
        Main utama = new Main();
        String kode_buku;
        String judul;
        BukuDaoIntrf dao=new BukuDaoImpl();
        System.out.println("-----------Data Buku-----------");

        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("1. Add Buku\n" +
                    "2. Show All Buku\n" +
                    "3. Show Buku based on id \n" +
                    "4. Update the Buku\n" +
                    "5. Delete the Buku\n" +
                    "6. Kembali ke Menu Utama\n" +
                    "7. Exit Aplikasi");

            System.out.print("Enter Choice: ");
            int ch=sc.nextInt();
            switch (ch){
                case 1:
                    Buku emp=new Buku();
                    System.out.print("Enter Kode buku : ");
                    kode_buku=sc.next();
                    System.out.print("Enter Judul : ");
                    judul=sc.next();
                    System.out.print("Enter Penerbit :");
                    String penerbit = sc.next();
                    System.out.print("Enter Tahun terbit :");
                    int tahun_terbit = sc.nextInt();
                    System.out.print("Enter Kategori :");
                    String kategori = sc.next();
                    System.out.print("Enter Jumlah :");
                    int jumlah = sc.nextInt();
                    emp.setKode_buku(kode_buku);
                    emp.setJudul(judul);
                    emp.setPenerbit(penerbit);
                    emp.setTahun_terbit(tahun_terbit);
                    emp.setKategori(kategori);
                    emp.setJumlah(jumlah);
                    dao.createBuku(emp);
                    break;
                case 2:
                    dao.showAllBuku();
                    break;
                case 3:
                    System.out.print("Enter kode buku to show the details : ");
                    String kode=sc.next();
                    dao.showBukuBasedOnID(kode);
                    break;
                case 4:
                    System.out.print("Enter kode_buku to update the detail : ");
                    String kode2=sc.next();
                    System.out.print("Enter the new judul : ");
                    judul=sc.next();
                    dao.updateBuku(kode2,judul);
                    break;
                case 5:
                    System.out.print("Enter the id to delete : ");
                    kode_buku=sc.next();
                    dao.deleteBuku(kode_buku);
                    break;
                case 6:
                    utama.menu();
                    break;
                case 7:
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