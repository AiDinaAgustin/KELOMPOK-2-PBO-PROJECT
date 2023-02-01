package com.anggota;

public class Anggota {
    private String id_anggota;
    private String nama;
    private String password;
    private String jk;
    private String telp;
    private String alamat;
    private String status;

    public Anggota(){

    }
    public Anggota(String id_anggota, String nama, String password, String jk, String telp, String alamat, String status) {
        this.id_anggota = id_anggota;
        this.nama = nama;
        this.password = password;
        this.jk = jk;
        this.telp = telp;
        this.alamat = alamat;
        this.status = status;
    }

    public String getId() {
        return id_anggota;
    }

    public void setId(String id_anggota) {
        this.id_anggota = id_anggota;
    }

    public String getName() {
        return nama;
    }

    public void setName(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    @Override
    public String toString() {
        return "Anggota{" +
                "id_anggota=" + id_anggota +
                ", nama='" + nama + '\'' +
                ", password=" + password +
                ", jk=" + jk +
                ", telp=" + telp +
                ", alamat=" + alamat+
                ", status=" + status+
                '}';
    }

    double getSalary() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}