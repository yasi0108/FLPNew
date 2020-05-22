package logic;




import com.ferrari.finances.dk.bank.InterestRate;
import com.ferrari.finances.dk.rki.CreditRator;
import com.ferrari.finances.dk.rki.Rating;


public class GetKV  {
	public enum kreditRating{A, B, C, D, error};
	LaanCheckTlf checkTlfNr = new LaanCheckTlf();
   // private double udlånsrente;
	   private double rente;
	   private double samletpris;
	   private Rating kv;
	   String A;
	   String B;
	   String C;
	   String D;

    
        public kreditRating getKreditvaerdighed(String cpr) {
        kv = CreditRator.i().rate(cpr);
      //  String kv = new String();
        CreditRator.i().rate(cpr);
        if (kv == Rating.A) {
            System.out.println("Tjekker kreditrating " + kv);
            return kreditRating.A;
        } else if(kv == Rating.B) {
            System.out.println("Tjekker kreditrating " +  kv);
            return kreditRating.B;
         //   rate+=rateA;
        } else if(kv == Rating.C) {
        	 System.out.println("Tjekker kreditrating " + kv);
        	return kreditRating.C;
        	
        }
        else if (kv == Rating.D) {
        	System.out.println("Brugeren er rating D");
        	return kreditRating.D;
        }
            
        else {
        System.out.println("Fejl i koden");
            return kreditRating.error;
        }
        }
        
        public double getRente(String cprnr) {
            rente = InterestRate.i().todaysRate();
            rente /=100;
            System.out.println("Base rente er: " + rente);
            kv = CreditRator.i().rate(cprnr);
          //  String kv = new String();
            CreditRator.i().rate(cprnr);
            if (kv == Rating.A) {
                rente+=1.01;
                System.out.println("Tjekker kreditrating " + kv + " og får rente: " + rente);
                
                
                return rente;
            } else if(kv == Rating.B) {

                rente+=1.02;
                System.out.println("Tjekker kreditrating " + kv + " og får rente: " + rente);
                return rente + samletpris;
             //   rate+=rateA;
            } else if(kv == Rating.C) {
            	rente+=1.03;
             	 System.out.println("Tjekker kreditrating " + kv + " og får rente: " + rente);
            	return rente + samletpris;
            	
            }
            else if (kv == Rating.D) {
            	
            	System.out.println("Brugeren er rating D");
            	return 0;
            }
                
            else {
            System.out.println("Fejl i koden");
                return -1;
            }
            }
        
        
        public double getSamletPris(String cprnr, String samletprisGetText) {
            rente = InterestRate.i().todaysRate();
            rente /=100;
            System.out.println("Base rente" + rente);
            kv = CreditRator.i().rate(cprnr);
             samletpris = Integer.parseInt(samletprisGetText);
          //  String kv = new String();
            CreditRator.i().rate(cprnr);
            if (kv == Rating.A) {
                rente+=1.01;
                System.out.println("Rente +0.01 giver: " + rente);
               samletpris = (rente*samletpris);
                System.out.println("Tjekker kreditrating " + kv + " og får samletpris: " + samletpris);
                
                
                return samletpris;
            } else if(kv == Rating.B) {
                rente+=1.02;
                System.out.println("Rente +0.02 giver: " + rente);
                samletpris = (rente*samletpris);
                System.out.println("Tjekker kreditrating " + kv + " og får samletpris: " + samletpris);
                return samletpris;
             //   rate+=rateA;
            } else if(kv == Rating.C) {
            	rente+=1.03;
                System.out.println("Rente +0.03 giver: " + rente);
           
            	samletpris = (rente*samletpris);
             	 System.out.println("Tjekker kreditrating " + kv + " og får samletpris: " + rente + samletpris);
             	 return samletpris;
            	
            }
            else if (kv == Rating.D) {
            	
            	System.out.println("Brugeren er rating D");
            	return 0;
            }
                
            else {
            System.out.println("Fejl i koden");
                return -1;
            }
            }
}

        
//    	public double getRente(String samletprisGetText, String tlfGetText) {
//    		 rente = InterestRate.i().todaysRate();
//
//    		 getFisse(tlfGetText);
//    		
//    		if	(getFisse(tlfGetText).equals("A")) {
//    			rente+=0.01;
//    			System.out.println("Rente før den bliver ganget: " + rente);
//    	        int getTextFornavn = Integer.parseInt(samletprisGetText);
//    	        rente = rente * getTextFornavn;
//    	        System.out.println("Rente * samletpris: " + rente);
//    	        
//    		}  else if	(getFisse(tlfGetText).equals("B")) {
//        			rente+=0.02;
//        			System.out.println("Rente før den bliver ganget: " + rente);
//        	        int getTextFornavn = Integer.parseInt(samletprisGetText);
//        	        rente = rente * getTextFornavn;
//        	        System.out.println("Rente * samletpris: " + rente);
//    		}  else if	(getFisse(tlfGetText).equals("C")) {
//    			rente+=0.03;
//    			System.out.println("Rente før den bliver ganget: " + rente);
//    	        int getTextFornavn = Integer.parseInt(samletprisGetText);
//    	        rente = rente * getTextFornavn;
//    	        System.out.println("Rente * samletpris: " + rente);
//    	        
//    		}  else if	(getFisse(tlfGetText).equals("D")) {
//    			System.out.println("FEJL: KV er D");
//    			
//
//    		}
//
//    		return rente;
//    	}
//    	public List getFisse(String tlfGetText) {
//    		if (checkTlfNr.CheckTlfDB(tlfGetText) == true) {
//    			return checkTlfNr.tlfDB.getKV(tlfGetText);
//    		}
//			return null;
//    		
//    	}
//}







