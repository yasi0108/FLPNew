package entity;

public class LaaneTilbud {
	private int telefonnummer;
	private int kundeindbetaling;
	private int laanlaengde;
	private boolean overstigergraense;
	private int laanestatus;
	private int bilid;
	private int bilsaelgerid;
	private int tilbudsid;
	private String rentedato;

	public LaaneTilbud() {

	}
	
	public LaaneTilbud(String rentedato) {
		this.rentedato = rentedato;
	}
	
/*tilbudsid, telefonnummer, kundeindbetaling, laanlaengde,
				 bilid, bilsealgerid, rentedato)*/
	public LaaneTilbud(String rentedato, int tilbudsid) {
		this.rentedato = rentedato;
		this.tilbudsid = tilbudsid;
		
	}

	public LaaneTilbud(int tilbudsid, int telefonnummer, int kundeindbetaling, int laanlaengde,
			boolean overstigergraense, int laanestatus, int bilid, int bilsaelgerid, String rentedato) {
		this.tilbudsid = tilbudsid;
		this.telefonnummer = telefonnummer;
		this.bilid = bilid;
		this.bilsaelgerid = bilsaelgerid;
		this.rentedato = rentedato;
		this.kundeindbetaling = kundeindbetaling;
		this.laanlaengde = laanlaengde;
		this.overstigergraense = overstigergraense;
		this.laanestatus = laanestatus;

	}

	public int getTilbudsid() {
		return tilbudsid;
	}

	public void setTilbudsid(int tilbudsid) {
		this.tilbudsid = tilbudsid;
	}

	public int getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(int telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public int getIndbetaling() {
		return kundeindbetaling;
	}

	public void setIndbetaling(int kundeindbetaling) {
		this.kundeindbetaling = kundeindbetaling;
	}

	public int getLaanlaengde() {
		return laanlaengde;
	}

	public void setLaanlaengde(int laanlaengde) {
		this.laanlaengde = laanlaengde;
	}

	public Boolean getOverstigergraense() {
		return overstigergraense;
	}

	public void setOverstigergraense(boolean overstigergraense) {
		this.overstigergraense = overstigergraense;
	}

	public int getLaanestatus() {
		return laanestatus;
	}

	public void setLaanestatus(int laanestatus) {
		this.laanestatus = laanestatus;
	}

	public int getBilid() {
		return bilid;
	}

	public void setBilid(int bilid) {
		this.bilid = bilid;
	}

	public int getBilsaelgerid() {
		return bilsaelgerid;
	}

	public void setBilsaelgerid(int bilsaelgerid) {
		this.bilsaelgerid = bilsaelgerid;
	}

	public String getRentedato() {
		return rentedato;
	}

	public void setRentedato(String rentedato) {
		this.rentedato = rentedato;
	}

	public String getAllTilbud() {
		return telefonnummer + ": " + kundeindbetaling + ": " + laanlaengde + ": " + overstigergraense + ": "
				+ laanestatus + ": " + bilid + ": " + bilsaelgerid + ": " + rentedato;
	}
}

/*
 * private String bilnavn; private int bilpris; private int udbetalingspris;
 * private int laanlaengde;
 * 
 * public LaaneTilbud() {
 * 
 * } public LaaneTilbud(String bilnavn, int bilpris, int udbetalingspris, int
 * laanlaengde) { this.bilnavn = bilnavn; this.bilpris = bilpris;
 * this.udbetalingspris = udbetalingspris; this.laanlaengde = laanlaengde; }
 * 
 * 
 * public String getBilnavn() { return bilnavn; }
 * 
 * 
 * public void setBilnavn(String bilnavn) { this.bilnavn = bilnavn; }
 * 
 * 
 * public int getBilpris() { return bilpris; }
 * 
 * 
 * public void setBilpris(int bilpris) { this.bilpris = bilpris; }
 * 
 * 
 * public int getUdbetalingspris() { return udbetalingspris; }
 * 
 * 
 * public void setUdbetalingspris(int udbetalingspris) { this.udbetalingspris =
 * udbetalingspris; }
 * 
 * 
 * public int getLaanlaengde() { return laanlaengde; }
 * 
 * 
 * public void setLaanlaengde(int laanlaengde) { this.laanlaengde = laanlaengde;
 * }
 * 
 * 
 * public String getAllTilbud() { return bilnavn + ": " + bilpris + ": " +
 * udbetalingspris + ": " + laanlaengde; } }
 */