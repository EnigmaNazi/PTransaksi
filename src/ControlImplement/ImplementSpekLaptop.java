/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlImplement;

import Connection.KoneksiDatabase;
import ControlInterface.InterfaceSpekLaptop;
import Model.MSpekLaptop;
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
public class ImplementSpekLaptop implements InterfaceSpekLaptop{

    @Override
    public MSpekLaptop cari(MSpekLaptop o) throws SQLException {
       PreparedStatement st = (PreparedStatement)
        KoneksiDatabase.sambung().prepareStatement("call CariLaptop(?,?,?,?,?,?,?)");
        st.setString(1, o.getLaptopKode());
        st.executeUpdate();
        return o;
    }

    @Override
    public List<MSpekLaptop> tampil() throws SQLException {
        Statement stm = (Statement) KoneksiDatabase.sambung().createStatement();
        ResultSet rst = stm.executeQuery("call TampilSpekLaptop()");
        List<MSpekLaptop> listspek_laptop = new ArrayList<>();
        while (rst.next()){
            MSpekLaptop spek_laptop = new MSpekLaptop();
            spek_laptop.setLaptopKode(rst.getString("Kode_Laptop"));
            spek_laptop.setMerek(rst.getString("Merek"));
            spek_laptop.setRAM(rst.getString("RAM"));
            spek_laptop.setHardisk(rst.getString("Hardisk"));
            spek_laptop.setProcessor(rst.getString("Processor"));
            spek_laptop.setOS(rst.getString("Sistem_Operasi"));
            spek_laptop.setGPU(rst.getString("GPU"));
            listspek_laptop.add(spek_laptop);
        }
        return listspek_laptop;
    }
}
