package logic;

import db.DuplicateCheckDB;

public class laanCheckDuplicate {

    private DuplicateCheckDB laan = new DuplicateCheckDB();

    public boolean LaanCheckDuplicate(String cpr, String tlf) {

    	if (laan.kundeCheckDuplicate(cpr, tlf) == true) {
    		return true;
    	}


        return false;

    }


}