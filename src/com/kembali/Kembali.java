/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kembali;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dina
 */
public class Kembali {
    private String kode_kembali;
    private String kode_pinjam;
    private String id_anggota;
    private String kode_buku;
    private Date tgl_pinjam;
    private Date tgl_kembali;
    private int denda;
    private String keterangan;
    private int jumlah;
    private String kt;

    public Kembali(){
            /*int bayar_denda = 500;
            String total;
            DateFormat tgl = new SimpleDateFormat("yyyy-MM-dd");
            Date tanggal1 = tgl_pinjam;
            Date tanggal2 = tgl_kembali;
            long dnd = Math.abs(tanggal1.getTime()-tanggal2.getTime());
            long telat = (TimeUnit.MILLISECONDS.toDays(dnd));
//            denda_telat.setText(String.valueOf(telat));
            
//            if(telat <0){
//                denda_telat.setText(String.valueOf(telat*0));
//            }else{
//                denda_telat.setText(String.valueOf(telat*bayar_denda));
//            }
                    */
            
    }
    public Kembali(String kode_kembali, String kode_pinjam, String id_anggota, String kode_buku, Date tgl_kembali, int denda, String keterangan, int jumlah) {
        this.kode_kembali = kode_kembali;
        this.kode_pinjam = kode_pinjam;
        this.id_anggota = id_anggota;
        this.kode_buku = kode_buku;
        this.tgl_kembali = tgl_kembali;
        this.denda = denda;
        this.keterangan = keterangan;
        this.jumlah = jumlah;
        
    }

    public String getKode_kembali() {
        return kode_kembali;
    }

    public void setKode_kembali(String kode_kembali) {
        this.kode_kembali = kode_kembali;
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

    public String getKode_buku() {
        return kode_buku;
    }

    public void setKode_buku(String kode_buku) {
        this.kode_buku = kode_buku;
    }

    public Date getTgl_kembali() {
        return tgl_kembali;
    }

    public void setTgl_kembali(Date tgl_kembali) {
        this.tgl_kembali = tgl_kembali;
    }

    public int getDenda() {
        return denda;
    }

    public void setDenda(int denda) {
        this.denda = denda;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Date getTgl_pinjam() {
        return tgl_pinjam;
    }

    public void setTgl_pinjam(Date tgl_pinjam) {
        this.tgl_pinjam = tgl_pinjam;
    }

    
    
    
    @Override
    public String toString() {
        return "Kembali{" + "kode_kembali=" + kode_kembali + ", kode_pinjam=" + kode_pinjam + ", id_anggota=" + id_anggota + ", kode_buku=" + kode_buku + ", tgl_kembali=" + tgl_kembali + ", denda=" + denda + ", keterangan=" + keterangan + ", jumlah=" + jumlah + '}';
    }

    private void keterangan(String telat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void denda(long l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
