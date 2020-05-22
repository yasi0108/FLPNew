package db;

import java.sql.Statement;

public class OpretLoginDB {

	public void opretLogin(String getTextFornavn, String getTextEfternavn, String getTextBrugernavn, String getTextPassword) {
		Datakobling DB = new Datakobling();
		try {
			Statement statement = DB.connection.createStatement();

//			statement.executeUpdate("INSERT INTO bilsaelger " + "VALUES ('" + medarbejderNavn + "', '" + CreateUsername
//					+ "', '" + CreatePassword + "')");
			
			statement.executeUpdate("INSERT INTO bilsaelger (saelgerfornavn, saelgerefternavn, saelgerbrugernavn, saelgerpassword) VALUES('" + getTextFornavn + "', '" + getTextEfternavn + "', '" + getTextBrugernavn 
						+ "', '" + getTextPassword + "')");

			DB.connection.close();

		} catch (Exception e) {
			System.out.println("Got exception in OpretLoginDB");
			System.out.println(e.getMessage());
		}
	}
}
