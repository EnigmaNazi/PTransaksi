/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlInterface;

import Model.MLaptop;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Reymadhan Hans
 */
public interface InterfaceLaptop {
    MLaptop simpan(MLaptop o) throws SQLException;
    void ubah(MLaptop o) throws SQLException;
    void hapus(String LaptopKode) throws SQLException;
    List<MLaptop> tampil() throws SQLException;
}
    
    
