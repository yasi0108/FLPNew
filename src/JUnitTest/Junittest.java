package JUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.jupiter.api.Test;
import db.Datakobling;


class Junittest {

    @Test
    void test() throws Exception {
        Datakobling db = new Datakobling();
    //    OpretLaanDB dd = new OpretLaanDB();


        String one = "hej";
        String two = "med";
        String three = "dig";
        String four = "Per";

          Statement statement = db.connection.createStatement();

          try{
              statement.executeUpdate("INSERT INTO laanetilbud " + "VALUES ('" + one + "', '" + two
                      + "', '" + three + "', '" + four + "')");
        //    dd.createLaan("1", "one", null, null, null, null, null, null, null);


            String sql = "Select * from laanetilbud";
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {

                one = rs.getString("bilnavn");
                two = rs.getString("bilpris");
                three = rs.getString("udbetalingspris");
                four = rs.getString("laanlaengde");
                assertEquals("hej", (one));
                assertEquals("med", (two));
                assertEquals("dig", (three));
                assertEquals("Per", (four));

                System.out.println(one);
                System.out.println(two);
                System.out.println(three);
                System.out.println(four);




            }




          } finally {

           db.connection.close();
          }


        }


    }
