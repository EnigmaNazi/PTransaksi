/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlInterface;

import Model.MSpekLaptop;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yantiWulandari
 */
public interface InterfaceSpekLaptop {
    MSpekLaptop cari(MSpekLaptop o) throws SQLException;
    List<MSpekLaptop> tampil() throws SQLException;
}
