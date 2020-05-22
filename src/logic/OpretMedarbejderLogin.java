package logic;

import db.OpretLoginDB;

public class OpretMedarbejderLogin {
	private OpretLoginDB loginDB = new OpretLoginDB();

	public void opretBruger(String getTextFornavn, String getTextEfternavn, String getTextBrugernavn, String getTextPassword) {
		loginDB.opretLogin(getTextFornavn, getTextEfternavn, getTextBrugernavn, getTextPassword);
	}
}
