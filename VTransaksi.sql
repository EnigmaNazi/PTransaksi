
CREATE
    /*[ALGORITHM = {UNDEFINED | MERGE | TEMPTABLE}]
    [DEFINER = { user | CURRENT_USER }]
    [SQL SECURITY { DEFINER | INVOKER }]*/
    VIEW `transaksi`.`VTransaksi` 
    AS
(SELECT
transaksi.`Kode_Transaksi`,
transaksi.`ID_Penjual`,
penjual.`Nama_Penjual`,
transaksi.`ID_Pembeli`,
pembeli.`Nama_Pembeli`,
transaksi.`Kode_Laptop`,
laptop.`Merek`,
transaksi.`Harga`,
transaksi.`Tanggal_Transaksi`,
transaksi.`Stok`
FROM
transaksi.`transaksi`
INNER JOIN  transaksi.`pembeli`
ON (transaksi.`ID_Pembeli` = pembeli.`ID_Pembeli`)
INNER JOIN transaksi.`penjual`
ON (transaksi.`ID_Penjual` = penjual.`ID_Penjual`)
INNER JOIN transaksi.`laptop`
ON (transaksi.`Kode_Laptop` = laptop.`Kode_Laptop`));
