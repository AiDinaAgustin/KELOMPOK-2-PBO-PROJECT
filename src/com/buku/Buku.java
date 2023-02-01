/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku;

import java.util.Calendar;

/**
 *
 * @author Dina
 */
public class Buku {
    private String kode_buku;
    private String judul;
    private String penerbit;
    private int tahun_terbit;
    private String kategori;
    private int jumlah;

    public Buku(){

    }
    public Buku(String kode_buku, String judul, String penerbit, int tahun_terbit, String kategori, int jumlah) {
        this.kode_buku = kode_buku;
        this.judul = judul;
        this.penerbit = penerbit;
        this.tahun_terbit = tahun_terbit;
        this.kategori = kategori;
        this.jumlah = jumlah;
    }

    public String getKode_buku() {
        return kode_buku;
    }

    public void setKode_buku(String kode_buku) {
        this.kode_buku = kode_buku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public int getTahun_terbit() {
        return tahun_terbit;
    }

    public void setTahun_terbit(int tahun_terbit) {
        this.tahun_terbit = tahun_terbit;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    @Override
    public String toString() {
        return "Buku{" +
                "kode_buku=" + kode_buku +
                ", judul='" + judul + '\'' +
                ", penerbit=" + penerbit +
                ", tahun_terbit=" + tahun_terbit +
                ", kategori=" + kategori +
                ", jumlah=" + jumlah+
                '}';
    }
} 

