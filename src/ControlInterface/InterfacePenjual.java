/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlInterface;

import Model.MPenjual;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yantiWulandari
 */
public interface InterfacePenjual {
    MPenjual simpan(MPenjual o) throws SQLException;
    void ubah(MPenjual o) throws SQLException;
    void hapus(String PenjualID) throws SQLException;
    List<MPenjual> tampil() throws SQLException;
    
}
