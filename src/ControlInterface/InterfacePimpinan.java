/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlInterface;

import Model.MPimpinan;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yantiWulandari
 */
public interface InterfacePimpinan {
    MPimpinan simpan(MPimpinan o) throws SQLException;
    void ubah(MPimpinan o) throws SQLException;
    void hapus(String HP) throws SQLException;
    List<MPimpinan> tampil() throws SQLException;
}
