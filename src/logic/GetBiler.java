package logic;


import java.util.ArrayList;
import java.util.List;

import db.LaaneTilbudDB;
import entity.Biler;


public class GetBiler {
     LaaneTilbudDB db = new LaaneTilbudDB();
          
     public List<Biler> getAllBilerInfo() {
            return db.getAllBiler();     
        }
}





