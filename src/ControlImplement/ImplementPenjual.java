/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlImplement;

import Connection.KoneksiDatabase;
import ControlInterface.InterfacePenjual;
import Model.MPenjual;
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
public class ImplementPenjual implements InterfacePenjual {

    @Override
    public MPenjual simpan(MPenjual o) throws SQLException {
        PreparedStatement st = (PreparedStatement)
        KoneksiDatabase.sambung().prepareStatement("call SimpanPenjual(?,?)");
        st.setString(1, o.getPenjualID());
        st.setString(2, o.getPenjualNama());
        st.executeUpdate();
        return o;
    }

    @Override
    public void ubah(MPenjual o) throws SQLException {
        PreparedStatement st = (PreparedStatement)
        KoneksiDatabase.sambung().prepareStatement("call UbahPenjual(?,?)");
        st.setString(1, o.getPenjualID());
        st.setString(2, o.getPenjualNama());
        st.executeUpdate();
    }

    @Override
    public void hapus(String PenjualID) throws SQLException {
        PreparedStatement st = (PreparedStatement)
        KoneksiDatabase.sambung().prepareStatement("call HapusPenjual(?)");
        st.setString(1, PenjualID);
        st.executeUpdate();
    }

    @Override
    public List<MPenjual> tampil() throws SQLException {
        Statement stm = (Statement) KoneksiDatabase.sambung().createStatement();
        ResultSet rst = stm.executeQuery("call TampilPenjual()");
        List<MPenjual> listpenjual = new ArrayList<>();
        while (rst.next()){
            MPenjual penjual = new MPenjual();
            penjual.setPenjualID(rst.getString("ID_Penjual"));
            penjual.setPenjualNama(rst.getString("Nama_Penjual"));
            listpenjual.add(penjual);
        }
        return listpenjual;
    }
    
}
