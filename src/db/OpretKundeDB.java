package db;

import java.sql.Statement;

public class OpretKundeDB {

    private Datakobling DB = new Datakobling();

    public void createKunde(String fornavnGetText, String efternavnGetText, String tlfGetText, String postnrGetText, String byGetText,
            String vejGetText, String husnrGetText, String cprGetText, String mailGetText, Enum<?> kreditVurdering) {

        try {
            Statement statement = DB.connection.createStatement();

            /*//////////////////////////////////////////////////////////
             * mangler overstigergraense + laanestatus til første update
             *//////////////////////////////////////////////////////////

            statement.executeUpdate("insert into kunde (telefonnummer,kundefornavn,kundeefternavn,cpr_nummer,mail,postnummer,bynavn,vejnavn,husnr, kreditVurdering) VALUES ('"
                    + tlfGetText + "', '" + fornavnGetText + "', '" + efternavnGetText + "','" + cprGetText + "', '" + mailGetText + "', '" + postnrGetText + "', '" + byGetText + "', '" + vejGetText
                    + "', '" + husnrGetText + "', '" + kreditVurdering +"')");

        } catch (Exception e) {
            System.out.println("Got exception in OpretLaanDB");
            System.out.println(e.getMessage());
        }
    }
}