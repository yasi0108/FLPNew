package logic;

import db.OpretLaanDB;

public class opretLaan {
    OpretLaanDB oprLaanDB = new OpretLaanDB();
    public void CreateLaan(String tlfGetText, String udbetalingGetText, String laanleangdeGetText, double rente) {
        oprLaanDB.createLaan(tlfGetText, udbetalingGetText, laanleangdeGetText, rente);
    }


}