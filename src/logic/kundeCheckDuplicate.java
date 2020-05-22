package logic;

import db.DuplicateCheckDB;

public class kundeCheckDuplicate {

    private DuplicateCheckDB duplicateDB = new DuplicateCheckDB();

    public boolean KundeCheckDuplicate(String cpr, String tlf) {

        if (duplicateDB.kundeCheckDuplicate(cpr, tlf) == true) {
            return true;
        }

        return false;

    }

}