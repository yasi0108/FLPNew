package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Biler;
import entity.LaaneTilbud;

public class LaaneTilbudDB {

	Datakobling DB = new Datakobling();

	public List<LaaneTilbud> getLaan() {
		ArrayList<LaaneTilbud> list = new ArrayList<LaaneTilbud>();
		try {
			Statement stmt = DB.connection.createStatement();
			String query = "SELECT laanetilbud.tilbudsid, kunde.telefonnummer, laanetilbud.bilid, laanetilbud.bilsaelgerid, laanetilbud.kundeindbetaling, laanetilbud.laanlaengde, laanetilbud.overstigergraense, laanetilbud.laanestatus, laanetilbud.rentedato, laanetilbud.rente"
					+ " FROM laanetilbud "
					+ " JOIN kunde ON laanetilbud.telefonnummer = kunde.telefonnummer"
//					+ " JOIN biler ON laanetilbud.bilid = biler.bilid"
//					+ " JOIN bilsaelger ON laanetilbud.bilsaelgerid = bilsaelger.bilsaelgerid"
					;
				
			

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int tilbudsid = rs.getInt("tilbudsid");
				int telefonnummer = rs.getInt("telefonnummer");
				int kundeindbetaling = rs.getInt("kundeindbetaling");
				int laanlaengde = rs.getInt("laanlaengde");
			//	boolean overstigergraense = rs.getBoolean("overstigergraense");
				//int laanestatus = rs.getInt("laanestatus");
				int bilid = rs.getInt("bilid");
				int bilsealgerid = rs.getInt("bilsaelgerid");
				String rentedato = rs.getString("rentedato");
				boolean overstigergraense = rs.getBoolean("overstigergraense");
				int laanestatus = rs.getInt("laanestatus");
				
				LaaneTilbud laan = new LaaneTilbud(tilbudsid, telefonnummer, kundeindbetaling, laanlaengde,
				overstigergraense, laanestatus, bilid, bilsealgerid, rentedato);

				list.add(laan);
			}
		} catch (SQLException e) {
			System.out.println("Error running SQL statement");
			System.out.println(e.getMessage());
		}
		return list;
	}

	public List<Biler> getAllBiler() {
		ArrayList<Biler> biler = new ArrayList<>();

		try {
			String sql = "SELECT * FROM Biler";
			// String sql2 = "SELECT bilid, bilnavn, bilpris FROM Biler";

			Statement statement = DB.connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);

			// iteration starter 'before first'
			while (resultSet.next()) {
				// hent data fra denne række
				int bilId = resultSet.getInt("bilid");
				String bilnavn = resultSet.getString("bilnavn");
				int bilPris = resultSet.getInt("bilpris");
				int inventar = resultSet.getInt("inventar");

				// brug data, e.g. => entitets/model object
				Biler biler1 = new Biler(bilId, bilnavn, bilPris, inventar);

				biler.add(biler1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return biler;
	}

	public List<LaaneTilbud> getLaanDato() {
		ArrayList<LaaneTilbud> list = new ArrayList<LaaneTilbud>();
		try {
			Statement stmt = DB.connection.createStatement();
			String query = "SELECT * FROM laanetilbud";

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {

				String rentedato = rs.getString("rentedato");

				LaaneTilbud laan = new LaaneTilbud(rentedato);

				list.add(laan);
			}
		} catch (SQLException e) {
			System.out.println("Error running SQL statement");
			System.out.println(e.getMessage());
		}
		return list;
	}
}
