/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlInterface;

import Model.MPembeli;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Reymadhan Hans
 */
public interface InterfacePembeli {
    MPembeli simpan(MPembeli o) throws SQLException;
    void ubah(MPembeli o) throws SQLException;
    void hapus(String PembeliID) throws SQLException;
    List<MPembeli> tampil() throws SQLException;
}
    
    
