package logic;
import db.OpretKundeDB;

public class opretKunde {

        OpretKundeDB oprKundeDB = new OpretKundeDB();
        public void CreateKunde(String fornavnGetText, String efternavnGetText, String tlfGetText,
                String postnrGetText, String byGetText, String vejGetText, String husnrGetText, String cprGetText, String mailGetText, 
                 Enum<?> kreditVurdering) {
            oprKundeDB.createKunde(fornavnGetText, efternavnGetText, tlfGetText, postnrGetText, byGetText, vejGetText, husnrGetText, cprGetText, mailGetText,
                     kreditVurdering);
        }


    }