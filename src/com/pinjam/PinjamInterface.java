package com.pinjam;


public interface PinjamInterface {

    //create employee
    public void createPinjam(Pinjam emp);
    //show all employee
    public void showAllPinjam();
    //show employee based on id
    public void showPinjamBasedOnID(String id);
    //update employee
    public void updatePinjam(String id,String name);
    //delete employee
    public void deletePinjam(String id);
}