/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlImplement;

import Connection.KoneksiDatabase;
import ControlInterface.InterfacePembeli;
import Model.MPembeli;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reymadhan Hans
 */
public class ImplementPembeli implements InterfacePembeli{

    @Override
    public MPembeli simpan(MPembeli o) throws SQLException {
        PreparedStatement st = (PreparedStatement)
        KoneksiDatabase.sambung().prepareStatement("call SimpanPembeli(?,?,?)");
        st.setString(1, o.getPembeliID());
        st.setString(2, o.getPembeliNama());
        st.setString(3, o.getNomorHP());
        st.executeUpdate();
        return o;
    }

    @Override
    public void ubah(MPembeli o) throws SQLException {
        PreparedStatement st = (PreparedStatement)
        KoneksiDatabase.sambung().prepareStatement("call UbahPembeli(?,?,?)");
        st.setString(1, o.getPembeliID());
        st.setString(2, o.getPembeliNama());
        st.setString(3, o.getNomorHP());
        st.executeUpdate();
    }

    @Override
    public void hapus(String PembeliID) throws SQLException {
        PreparedStatement st = (PreparedStatement)
        KoneksiDatabase.sambung().prepareStatement("call HapusPembeli(?)");
        st.setString(1, PembeliID);
        st.executeUpdate();
    }

    @Override
    public List<MPembeli> tampil() throws SQLException {
        Statement stm = (Statement) KoneksiDatabase.sambung().createStatement();
        ResultSet rst = stm.executeQuery("call TampilPembeli()");
        List<MPembeli> listpembeli = new ArrayList<>();
        while (rst.next()){
            MPembeli pembeli = new MPembeli();
            pembeli.setPembeliID(rst.getString("ID_Pembeli"));
            pembeli.setPembeliNama(rst.getString("Nama_Pembeli"));
            pembeli.setNomorHP(rst.getString("Nomor_HP"));
            listpembeli.add(pembeli);
        }
        return listpembeli;
    }
    
}
