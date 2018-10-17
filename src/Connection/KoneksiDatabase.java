/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Reymadhan Hans
 */
public class KoneksiDatabase {
    private static Connection con;
    public static Connection sambung() throws SQLException{
        if (con == null){
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:" + "3306/transaksi","root","123");
        }
        return con;
    }
    
}
