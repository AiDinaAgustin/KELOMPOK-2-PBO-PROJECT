package com.kembali;

public interface KembaliDaoIntrf {

    //create employee
    public void createKembali(Kembali emp);
    //show all employee
    public void showAllKembali();
    //hilang
    public void hilangKembali(Kembali emp);
    //perpanjang 
    public void perpanjang(Kembali emp, String kode_pinjam);
    //show employee based on id
    public void showKembaliBasedOnID(String kode_kembali);
    //update employee
    public void updateKembali(String kode_kembali,String kode_buku);
    //delete employee
    public void deleteKembali(String kode_kembali);
}