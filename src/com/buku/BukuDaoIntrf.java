package com.buku;

public interface BukuDaoIntrf {

    //create employee
    public void createBuku(Buku emp);
    //show all employee
    public void showAllBuku();
    //show employee based on id
    public void showBukuBasedOnID(String kode);
    //update employee
    public void updateBuku(String kode_buku,String judul);
    //delete employee
    public void deleteBuku(String kode_buku);
}