package com.petugas;


public class Petugas {
    private String id_operator;
    private String nama;
    private String password;
    private String jk;
    private String telp;
    private String alamat;

    public Petugas(){

    }

    public Petugas(String id_operator, String nama, String password, String jk, String telp, String alamat) {
        this.id_operator = id_operator;
        this.nama = nama;
        this.password = password;
        this.jk = jk;
        this.telp = telp;
        this.alamat = alamat;
    }

    public void setId_operator(String id_operator) {
        this.id_operator = id_operator;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getId_operator() {
        return id_operator;
    }

    public String getNama() {
        return nama;
    }

    public String getPassword() {
        return password;
    }

    public String getJk() {
        return jk;
    }

    public String getTelp() {
        return telp;
    }

    public String getAlamat() {
        return alamat;
    }
    
    @Override
    public String toString() {
        return "Petugas{" +
                "id_operator=" + id_operator +
                ", nama='" + nama + '\'' +
                ", password=" + password +
                ", jk=" + jk +
                ", telp=" + telp +
                ", alamat=" + alamat+
                '}';
    }
}