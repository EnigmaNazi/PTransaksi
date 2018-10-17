DELIMITER $$

CREATE
    /*[DEFINER = { user | CURRENT_USER }]*/
    PROCEDURE `transaksi`.`UbahTransaksi`()
    /*LANGUAGE SQL
    | [NOT] DETERMINISTIC
    | { CONTAINS SQL | NO SQL | READS SQL DATA | MODIFIES SQL DATA }
    | SQL SECURITY { DEFINER | INVOKER }
    | COMMENT 'string'*/
    BEGIN
UPDATE vtransaksi SET Nama_Pembeli = nama, Kode_Laptop = kodel, Merek = merekl, Harga = harga WHERE Kode_Transaksi = kodet;
    END$$

DELIMITER ;