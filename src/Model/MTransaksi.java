/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ReyHans
 */
public class MTransaksi {
    private String TransaksiKode, PenjualID, PembeliID, LaptopKode, Harga, TransaksiTgl, Stok;

    public String getTransaksiKode() {
        return TransaksiKode;
    }

    public void setTransaksiKode(String TransaksiKode) {
        this.TransaksiKode = TransaksiKode;
    }

    public String getPenjualID() {
        return PenjualID;
    }

    public void setPenjualID(String PenjualID) {
        this.PenjualID = PenjualID;
    }

    public String getPembeliID() {
        return PembeliID;
    }

    public void setPembeliID(String PembeliID) {
        this.PembeliID = PembeliID;
    }

    public String getLaptopKode() {
        return LaptopKode;
    }

    public void setLaptopKode(String LaptopKode) {
        this.LaptopKode = LaptopKode;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String Harga) {
        this.Harga = Harga;
    }

    public String getTransaksiTgl() {
        return TransaksiTgl;
    }

    public void setTransaksiTgl(String TransaksiTgl) {
        this.TransaksiTgl = TransaksiTgl;
    }

    public String getStok() {
        return Stok;
    }

    public void setStok(String Stok) {
        this.Stok = Stok;
    }
    
}
