/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlImplement;

import Connection.KoneksiDatabase;
import ControlInterface.InterfaceLaptop;
import Model.MLaptop;
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
public class ImplementLaptop implements InterfaceLaptop{

    @Override
    public MLaptop simpan(MLaptop o) throws SQLException {
        PreparedStatement st = (PreparedStatement)
        KoneksiDatabase.sambung().prepareStatement("call SimpanLaptop(?,?)");
        st.setString(1, o.getLaptopKode());
        st.setString(2, o.getMerek());
        st.executeUpdate();
        return o;
    }

    @Override
    public void ubah(MLaptop o) throws SQLException {
        PreparedStatement st = (PreparedStatement)
        KoneksiDatabase.sambung().prepareStatement("call UbahLaptop(?,?)");
        st.setString(1, o.getLaptopKode());
        st.setString(2, o.getMerek());
        st.executeUpdate();
    }

    @Override
    public void hapus(String LaptopKode) throws SQLException {
        PreparedStatement st = (PreparedStatement)
        KoneksiDatabase.sambung().prepareStatement("call HapusLaptop(?)");
        st.setString(1, LaptopKode);
        st.executeUpdate();
    }

    @Override
    public List<MLaptop> tampil() throws SQLException {
        Statement stm = (Statement) KoneksiDatabase.sambung().createStatement();
        ResultSet rst = stm.executeQuery("call TampilLaptop()");
        List<MLaptop> listlaptop = new ArrayList<>();
        while (rst.next()){
            MLaptop laptop = new MLaptop();
            laptop.setLaptopKode(rst.getString("Kode_Laptop"));
            laptop.setMerek(rst.getString("Merek"));
            listlaptop.add(laptop);
        }
        return listlaptop;
    }
    
}
