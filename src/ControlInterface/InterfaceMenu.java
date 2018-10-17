/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlInterface;

import Model.MMenu;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yantiWulandari
 */
public interface InterfaceMenu {
    MMenu cari(MMenu o) throws SQLException;
    void cari(String TransaksiKode) throws SQLException;
    List<MMenu> tampil() throws SQLException;
}
