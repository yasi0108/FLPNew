package logic;

import java.util.List;

import db.LaaneTilbudDB;
import entity.LaaneTilbud;

public class getLaan {
    LaaneTilbudDB db = new LaaneTilbudDB();

    public List<LaaneTilbud> getLaanAll() {
        return db.getLaan();
}

    public List<LaaneTilbud> getLTBDato() {
		return db.getLaanDato();
    	
    }

}