/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlImplement;

import Connection.KoneksiDatabase;
import ControlInterface.InterfacePimpinan;
import Model.MPimpinan;
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
public class ImplementPimpinan implements InterfacePimpinan {

    @Override
    public MPimpinan simpan(MPimpinan o) throws SQLException {
        PreparedStatement st = (PreparedStatement)
        KoneksiDatabase.sambung().prepareStatement("call SimpanPimpinan(?,?,?,?,?)");
        st.setString(1, o.getNL());
        st.setString(2, o.getPimpinanNama());
        st.setString(3, o.getTanggal());
        st.setString(4, o.getPendapatan());
        st.setString(5, o.getPenjualID());
        st.executeUpdate();
        return o;
    }

    @Override
    public void ubah(MPimpinan o) throws SQLException {
        PreparedStatement st = (PreparedStatement)
        KoneksiDatabase.sambung().prepareStatement("call UbahPimpinan(?,?,?,?,?)");
        st.setString(1, o.getNL());
        st.setString(2, o.getPimpinanNama());
        st.setString(3, o.getTanggal());
        st.setString(4, o.getPendapatan());
        st.setString(5, o.getPenjualID());
        st.executeUpdate();
    }

    @Override
    public void hapus(String NL) throws SQLException {
        PreparedStatement st = (PreparedStatement)
        KoneksiDatabase.sambung().prepareStatement("call HapusPimpinan(?)");
        st.setString(1, NL);
        st.executeUpdate();
    }

    @Override
    public List<MPimpinan> tampil() throws SQLException {
        Statement stm = (Statement) KoneksiDatabase.sambung().createStatement();
        ResultSet rst = stm.executeQuery("call TampilPimpinan()");
        List<MPimpinan> listpimpinan = new ArrayList<>();
        while (rst.next()){
            MPimpinan pimpinan = new MPimpinan();
            pimpinan.setNL(rst.getString("Nomor_Laporan"));
            pimpinan.setPimpinanNama(rst.getString("Nama_Pimpinan"));
            pimpinan.setTanggal(rst.getString("Tanggal"));
            pimpinan.setPendapatan(rst.getString("Pendapatan_Perminggu"));
            pimpinan.setPenjualID(rst.getString("ID_Penjual"));
            listpimpinan.add(pimpinan);
        }
        return listpimpinan;
    }
    
}
