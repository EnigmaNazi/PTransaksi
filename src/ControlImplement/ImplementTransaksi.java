/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlImplement;

import Connection.KoneksiDatabase;
import ControlInterface.InterfaceTransaksi;
import Model.MTransaksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ReyHans
 */
public class ImplementTransaksi implements InterfaceTransaksi{

    @Override
    public MTransaksi simpan(MTransaksi o) throws SQLException {
        PreparedStatement st = (PreparedStatement)
        KoneksiDatabase.sambung().prepareStatement("call SimpanTransaksi(?,?,?,?,?,?,?)");
        st.setString(1, o.getTransaksiKode());
        st.setString(2, o.getPenjualID());
        st.setString(3, o.getPembeliID());
        st.setString(4, o.getLaptopKode());
        st.setString(5, o.getHarga());
        st.setString(6, o.getTransaksiTgl());
        st.setString(7, o.getStok());
        st.executeUpdate();
        return o;
    }

    @Override
    public void ubah(MTransaksi o) throws SQLException {
        PreparedStatement st = (PreparedStatement)
        KoneksiDatabase.sambung().prepareStatement("call UbahTransaksi(?,?,?,?,?,?,?)");
        st.setString(1, o.getTransaksiKode());
        st.setString(2, o.getPenjualID());
        st.setString(3, o.getPembeliID());
        st.setString(4, o.getLaptopKode());
        st.setString(5, o.getHarga());
        st.setString(6, o.getTransaksiTgl());
        st.setString(7, o.getStok());
        st.executeUpdate();
    }

    @Override
    public void hapus(String TransaksiKode) throws SQLException {
        PreparedStatement st = (PreparedStatement)
        KoneksiDatabase.sambung().prepareStatement("call HapusTransaksi(?)");
        st.setString(1, TransaksiKode);
        st.executeUpdate();
    }

    @Override
    public List<MTransaksi> tampil() throws SQLException {
        Statement stm = (Statement) KoneksiDatabase.sambung().createStatement();
        ResultSet rst = stm.executeQuery("call TampilTransaksi()");
        List<MTransaksi> listtransaksi = new ArrayList<>();
        while (rst.next()){
            MTransaksi transaksi = new MTransaksi();
            transaksi.setTransaksiKode(rst.getString("Kode_Transaksi"));
            transaksi.setPenjualID(rst.getString("ID_Penjual"));
            transaksi.setPembeliID(rst.getString("ID_Pembeli"));
            transaksi.setLaptopKode(rst.getString("Kode_Laptop"));
            transaksi.setHarga(rst.getString("Harga"));
            transaksi.setTransaksiTgl(rst.getString("Tanggal_Transaksi"));
            transaksi.setStok(rst.getString("Stok"));
            listtransaksi.add(transaksi);
        }
        return listtransaksi;
    }
    
}
