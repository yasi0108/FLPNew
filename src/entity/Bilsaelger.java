package entity;



public class Bilsaelger {


    private String medarbejderfornavn;
    private String saelgerbrugernavn;
    private String saelgerpassword;
    private String medarbejderefternavn;
    private int maksgraense;


    public Bilsaelger(String medarbejderfornavn, String saelgerbrugernavn, String saelgerpassword, String medarbejderefternavn, int maksgraense) {


        this.medarbejderfornavn = medarbejderfornavn;
        this.saelgerbrugernavn = saelgerbrugernavn;
        this.saelgerpassword = saelgerpassword;
        this.medarbejderefternavn = medarbejderefternavn;
        this.maksgraense = maksgraense;


    }


    public String getmedarbejderfornavn() {
        return medarbejderfornavn;
    }


    public void setmedarbejderfornavn(String medarbejderfornavn) {
        this.medarbejderfornavn = medarbejderfornavn;
    }


    public String getmedarbejderefternavn() {
        return medarbejderefternavn;
    }


    public void setmedarbejderNavn(String medarbejderefternavn) {
        this.medarbejderefternavn = medarbejderefternavn;
    }


    public void setbrugernavn(String saelgerbrugernavn) {
        this.saelgerbrugernavn = saelgerbrugernavn;
    }


    public String getbrugernavn() {
        return saelgerbrugernavn;
    }


    public void setsaelgerpassword(String saelgerpassword) {
        this.saelgerpassword = saelgerpassword;
    }


    public String getsaelgerpassword() {
        return saelgerpassword;
    }


    public void setmaksgraense(int maksgraense) {
        this.maksgraense = maksgraense;
    }


    public int getmaksgraense() {
        return maksgraense;
    }



    @Override
    public String toString() {
        return medarbejderfornavn + ": " + medarbejderefternavn + ": "  + saelgerbrugernavn + ": " + saelgerpassword + ": " + maksgraense;


    }


}



















