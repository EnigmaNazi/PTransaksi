/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlInterface;

import Model.MTransaksi;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ReyHans
 */
public interface InterfaceTransaksi {
    MTransaksi simpan(MTransaksi o) throws SQLException;
    void ubah(MTransaksi o) throws SQLException;
    void hapus(String TransaksiKode) throws SQLException;
    List<MTransaksi> tampil() throws SQLException;
}
