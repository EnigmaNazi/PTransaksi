/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlImplement;

import Connection.KoneksiDatabase;
import ControlInterface.InterfaceMenu;
import Model.MMenu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yantiWulandari
 */
public class ImplementMenu implements InterfaceMenu {
    
    
    @Override
    public MMenu cari(MMenu o) throws SQLException {
        PreparedStatement st = (PreparedStatement)
        KoneksiDatabase.sambung().prepareStatement("call CariVtransaksi(?,?,?,?,?,?,?,?,?,?)");
        st.setString(1, o.getTransaksiKode());
        st.executeQuery();
        return o;
    }

    @Override
    public List<MMenu> tampil() throws SQLException {
        Statement stm = (Statement) KoneksiDatabase.sambung().createStatement();
        ResultSet rst = stm.executeQuery("call TampilVtransaksi()");
        List<MMenu> listvtransaksi = new ArrayList<>();
        while (rst.next()){
            MMenu vtransaksi = new MMenu();
            vtransaksi.setTransaksiKode(rst.getString("Kode_Transaksi"));
            vtransaksi.setPenjualID(rst.getString("ID_Penjual"));
            vtransaksi.setPenjualNama(rst.getString("Nama_Penjual"));
            vtransaksi.setPembeliID(rst.getString("ID_Pembeli"));
            vtransaksi.setPembeliNama(rst.getString("Nama_Pembeli"));
            vtransaksi.setLaptopKode(rst.getString("Kode_Laptop"));
            vtransaksi.setMerek(rst.getString("Merek"));
            vtransaksi.setHarga(rst.getString("Harga"));
            vtransaksi.setTransaksiTgl(rst.getString("Tanggal_Transaksi"));
            vtransaksi.setStok(rst.getString("Stok"));
            listvtransaksi.add(vtransaksi);
        }
        return listvtransaksi;
    }

    @Override
    public void cari(String TransaksiKode) throws SQLException {
        PreparedStatement st = (PreparedStatement)
        KoneksiDatabase.sambung().prepareStatement("call CariVtransaksi(?,?,?,?,?,?,?,?,?,?)");
        st.setString(1, TransaksiKode);
        st.executeQuery();
    }
}
    
