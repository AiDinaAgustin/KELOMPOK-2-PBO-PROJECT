package com.anggota;

import com.main.Main;
import java.util.Scanner;

public class MainAnggota {
    public void main(){
        Main utama = new Main();
        String name;
        String id;
        AnggotaDaoIntrf dao=new AnggotaDaoImpl();
        System.out.println("-----------Data Anggota-----------");

        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("1. Add Anggota\n" +
                    "2. Show All Anggota\n" +
                    "3. Show Anggota based on id \n" +
                    "4. Update the Anggota\n" +
                    "5. Delete the Anggota\n" +
                    "6. Kembali ke Menu Utama\n" +
                    "7. Exit Aplikasi");

            System.out.print("Enter Choice: ");
            int ch=sc.nextInt();
            switch (ch){
                case 1:
                    Anggota emp=new Anggota();
                    System.out.print("Enter ID : ");
                    id=sc.next();
                    System.out.print("Enter name : ");
                    name=sc.next();
                    System.out.print("Enter password :");
                    String password = sc.next();
                    System.out.print("Enter jk :");
                    String jk = sc.next();
                    System.out.print("Enter telp :");
                    String telp = sc.next();
                    System.out.print("Enter alamat :");
                    String alamat = sc.next();
                    //System.out.print("Enter status :");
                    //String status = sc.next();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setPassword(password);
                    emp.setJk(jk);
                    emp.setTelp(telp);
                    emp.setAlamat(alamat);
                    //emp.setStatus(status);
                    dao.createAnggota(emp);
                    break;
                case 2:
                    dao.showAllAnggota();
                    break;
                case 3:
                    System.out.print("Enter id to show the details : ");
                    String empid=sc.next();
                    dao.showAnggotaBasedOnID(empid);
                    break;
                case 4:
                    System.out.print("Enter id to update the details : ");
                    String empid1=sc.next();
                    System.out.print("Enter the new name : ");
                     name=sc.next();
                    dao.updateAnggota(empid1,name);
                    break;
                case 5:
                    System.out.print("Enter the id to delete : ");
                    id=sc.next();
                    dao.deleteAnggota(id);
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