/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pinjam;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Dina
 */
public class Pinjam {
    private String kode_pinjam;
    private String id_anggota;
    private String nama;
    private String kode_buku;
    private String judul;
    private Date tgl_pinjam;
    private Date tgl_hrskembali;
    private int jumlah;
    private String kt;
    private final int LAMA_PINJAM = 7;

    public Pinjam(){
        tgl_pinjam = Calendar.getInstance().getTime();
        Calendar cal = Calendar.getInstance();
        cal.setTime(tgl_pinjam);
        cal.add(Calendar.DATE, LAMA_PINJAM);
        tgl_hrskembali = cal.getTime();

    }
    public Pinjam(String kode_pinjam, String id_anggota, String nama, String kode_buku, String judul, Date tgl_pinjam, Date tgl_hrskembali, int jumlah, String kt) {
        this.kode_pinjam = kode_pinjam;
        this.id_anggota = id_anggota;
        this.nama = nama;
        this.kode_buku = kode_buku;
        this.judul = judul;
        this.tgl_pinjam = tgl_pinjam;
        this.tgl_hrskembali = tgl_hrskembali;
        this.jumlah = jumlah;
        this.kt = kt;
    }

    public String getKode_pinjam() {
        return kode_pinjam;
    }

    public void setKode_pinjam(String kode_pinjam) {
        this.kode_pinjam = kode_pinjam;
    }

    public String getId_anggota() {
        return id_anggota;
    }

    public void setId_anggota(String id_anggota) {
        this.id_anggota = id_anggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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

    public Date getTgl_pinjam() {
        return tgl_pinjam;
    }

    public void setTgl_pinjam(Date tgl_pinjam) {
        this.tgl_pinjam = tgl_pinjam;
    }

    public Date getTgl_hrskembali() {
        return tgl_hrskembali;
    }

    public void setTgl_hrskembali(Date tgl_hrskembali) {
        this.tgl_hrskembali = tgl_hrskembali;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getKt() {
        return kt;
    }

    public void setKt(String kt) {
        this.kt = kt;
    }

    

    @Override
    public String toString() {
        return "Pinjam{" +
                "kode_pinjam=" + kode_pinjam +
                ", ID anggota='" + id_anggota + '\'' +
                ", nama=" + nama +
                ", kode_buku=" + kode_buku +
                ", judul=" + judul +
                ", tgl_pinjam=" + tgl_pinjam +
                ", tgl_hrskembali=" + tgl_hrskembali +
                ", jumlah=" + jumlah+
                ", keterangan=" + kt +
                '}';
    }
} 

