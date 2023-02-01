package com.petugas;


import com.main.Main;
import java.util.Scanner;

public class MainPetugas {
    
    public void main(){
        Main utama = new Main();
        String name;
        String id;
        PetugasInterface dao=new PetugasImplements();
        System.out.println("-----------Data Petugas-----------");

        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("1. Add Petugas\n" +
                    "2. Show All Petugas\n" +
                    "3. Show Petugas based on ID \n" +
                    "4. Update the Petugas\n" +
                    "5. Delete the Petugas\n" +
                    "6. Kembali ke Menu Utama\n" +
                    "7. Exit Aplikasi");

            System.out.print("Enter Choice: ");
            int ch=sc.nextInt();
            switch (ch){
                case 1:
                    Petugas emp=new Petugas();
                    System.out.print("Masukan ID Operator : ");
                    id=sc.next();
                    System.out.print("Masukan Nama Petugas : ");
                    name=sc.next();
                    System.out.print("Masukan Password :");
                    String password = sc.next();
                    System.out.print("Masukan Jenis Kelamin :");
                    String jk = sc.next();
                    System.out.print("Masukan No. telp :");
                    String telp = sc.next();
                    System.out.print("Masukan Alamat :");
                    String alamat = sc.next();
                    emp.setId_operator(id);
                    emp.setNama(name);
                    emp.setPassword(password);
                    emp.setJk(jk);
                    emp.setTelp(telp);
                    emp.setAlamat(alamat);
                    dao.createPetugas(emp);
                    break;
                case 2:
                    dao.showAllPetugas();
                    break;
                case 3:
                    System.out.print("Masukan ID Operator untuk menampilkan detail : ");
                    String empid=sc.next();
                    dao.showPetugasBasedOnID(empid);
                    break;
                case 4:
                    System.out.print("Masukan ID Operator untuk mengupdate detail : ");
                    String empid1=sc.next();
                    System.out.print("Masukan nama : ");
                    name=sc.next();
                    dao.updatePetugas(empid1,name);
                    break;
                case 5:
                    System.out.println("Masukan ID petugas yang akan dihapus : ");
                    id=sc.next();
                    dao.deletePetugas(id);
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
}