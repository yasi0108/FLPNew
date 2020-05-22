package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import db.Datakobling;
import entity.Kunde;
 


public class KundeinfoDB {


    public List<Kunde> getKunde () {
        ArrayList<Kunde> list = new ArrayList<Kunde>();
        Datakobling DB = new Datakobling(); 
        try {
            Statement stmt = DB.connection.createStatement();
            String query = "SELECT * FROM kunde";

 // String query skal opdateres - skal have where clause på den
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int telefonnummer = rs.getInt("telefonnummer");
                String kundefornavn = rs.getString("kundefornavn");
              //  String kundeefternavn = rs.getString("kundeefternavn");
                long cpr_nummer = rs.getLong("cpr_nummer");
                String mail = rs.getString("mail");
                int postnummer = rs.getInt("postnummer");
                String bynavn = rs.getString("bynavn");
                String vejnavn = rs.getString("vejnavn");
                int husnummer = rs.getInt("husnr");
                String kreditVurdering = rs.getString("kreditVurdering");
                // char kreditVurdering = rs.getCharacterStream("kreditVurdering");
//                Kunde kunde = new Kunde();
//               kunde.setKundenavn(rs.getString("kundenavn"));
//               kunde.setTelefonnummer(rs.getString("telefonnummer"));
//               kunde.setEmail(rs.getString("email"));
//               kunde.setCpr_nummer(rs.getString("cpr_nummer"));
//               kunde.setKreditvaerdighed(rs.getString("addresse"));
//


                Kunde kundeInsert = new Kunde(telefonnummer, kundefornavn, cpr_nummer, mail, postnummer, bynavn, vejnavn, husnummer, kreditVurdering);

        //       System.out.println(kunde);
                list.add(kundeInsert);

            }
        } catch (SQLException e) {
            System.out.println("Error running SQL statement");
            System.out.println(e.getMessage());
        }
        return list;
} 
}






