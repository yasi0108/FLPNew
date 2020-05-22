package entity;

 

public class Biler {

 

    private int bilId; 
    private String bilnavn;
    private int bilPris;
    private int inventar;
    
    public Biler(int bilId, String bilnavn, int bilPris, int inventar) {
        
        this.bilId = bilId;
        this.bilnavn = bilnavn;
        this.bilPris = bilPris;
        this.inventar = inventar;
    }
    
    
    public Biler() {
		// TODO Auto-generated constructor stub
	}


	public int getBilId() {
        return bilId;
    }
    public void setBilId(int bilId) {
        this.bilId = bilId;
    }
    public String getBilnavn() {
        return bilnavn;
    }
    public void setBilnavn(String bilnavn) {
        this.bilnavn = bilnavn;
    }
    public int getBilPris() {
        return bilPris;
    }
    public void setBilPris(int bilPris) {
        this.bilPris = bilPris;
    }
    public int getInventar() {
        return inventar;
    }
    public void setInventar(int inventar) {
        this.inventar = inventar;
    } 
}