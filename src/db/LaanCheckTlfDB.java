package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LaanCheckTlfDB {
	Datakobling DB = new Datakobling();

	public boolean TlfCheck(String tlfGetText) {
		try {

			Statement stmt = DB.connection.createStatement();
			String sql = "Select * from kunde where telefonnummer='" + tlfGetText + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return true;

			}

		} catch (Exception e) {
			System.out.println("Got exception from  TlfCheck in LaanCheckTlfDB ");
			System.out.print(e);

		}
		return false;

	}

	public String getCPR(String tlfGetText) {
		String cprnr = null;
		try {
			Statement stmt = DB.connection.createStatement();
			String query = "SELECT * from kunde WHERE telefonnummer='" + tlfGetText + "'";
//				+ " JOIN biler ON laanetilbud.bilid = biler.bilid"
//				+ " JOIN bilsaelger ON laanetilbud.bilsaelgerid = bilsaelger.bilsaelgerid"

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {

				cprnr = rs.getString("cpr_nummer");
			}
		} catch (SQLException e) {
			System.out.println("Error running SQL statement");
			System.out.println(e.getMessage());
		}
		return cprnr;
	}
}