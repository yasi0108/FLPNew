package db;

import java.sql.ResultSet;
import java.sql.Statement;

public class LoginCheckDB {
	Datakobling DB = new Datakobling();
	public boolean LoginCheck(String username, String password) {
		try {
			
			Statement stmt = DB.connection.createStatement();
			String sql = "Select * from bilsaelger where saelgerbrugernavn='" + username + "' and saelgerpassword='" + password
					+ "'";

			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("Got exception from LoginCheck in Datakobling ");
			System.out.print(e);

		}
		return false;

	}

	public boolean adminLoginCheck(String username, String password) {

		try {
			
			Statement stmt = DB.connection.createStatement();
			String sql = "Select * from administrator where adminbrugernavn='" + username + "' and adminpassword='"
					+ password + "'";

			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return true;
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println("Got exception from adminLoginCheck() in Datakobling");
			System.out.print(e);
		}
		return false;
		
	}
}
