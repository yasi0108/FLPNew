package logic;


import java.util.List;
import db.KundeinfoDB;
import entity.Kunde;


public class getKunde {
	KundeinfoDB db = new KundeinfoDB();
	public List<Kunde> getKundeAll() {
		//System.out.println("getKundeAll returnerer (fra logic) : " + db.getKunde());
		
		return db.getKunde();
	}
	
	
/*
	public List<Kunde> getKundeAll() {
		return db.getAllKunde();

	}
	
	public List<Kunde> getKunde(String whereClause) {
		return db.getKunde(whereClause);

	}
	*/
}