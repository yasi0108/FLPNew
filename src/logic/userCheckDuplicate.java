package logic;

import db.DuplicateCheckDB;

public class userCheckDuplicate {

	private DuplicateCheckDB DB = new DuplicateCheckDB();

	public boolean UserCheckDuplicate(String CreateUsername) {

		if (DB.brugerCheckDuplicate(CreateUsername) == true) {
			return true;
		}
		
		return false;

	}
}
