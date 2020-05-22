package logic;

import java.util.List;

import db.saelgerinfoDB;
import entity.Bilsaelger;

public class getBilsaelger {

    saelgerinfoDB db = new saelgerinfoDB();

    public List<Bilsaelger> getsaelgerinfo() {
        return db.getSealger();
}
}