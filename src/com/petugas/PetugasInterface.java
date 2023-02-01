package com.petugas;



public interface PetugasInterface {

    //create employee
    public void createPetugas(Petugas emp);
    //show all employee
    public void showAllPetugas();
    //show employee based on id
    public void showPetugasBasedOnID(String id);
    //update employee
    public void updatePetugas(String id,String name);
    //delete employee
    public void deletePetugas(String id);
}