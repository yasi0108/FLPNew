package logic;

import db.LaanCheckTlfDB;

public class LaanCheckTlf {
	LaanCheckTlfDB tlfDB = new LaanCheckTlfDB();
	public boolean CheckTlfDB(String tlfGetText) {
		if (tlfDB.TlfCheck(tlfGetText) == true) {
			return true;
		}
	
		return false;
	
	}
	
    public String getCPRNR(String tlfGetText) {
    	return tlfDB.getCPR(tlfGetText);
    }
}
