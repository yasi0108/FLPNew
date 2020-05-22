package entity;

public class Kunde {

	private int telefonnummer;
	private String kundefornavn;
	// private String kundeefternavn;
	private long cpr_nummer;
	private String mail;
	private int postnummer;
	private String bynavn;
	private String vejnavn;
	private int husnummer;
	private String kreditVurdering;

	public Kunde() {
		// TODO Auto-generated constructor stub
	}
	
/*	public Kunde(int telefonnummer, String kreditVurdering) {
		this.telefonnummer = telefonnummer; 
		this.kreditVurdering = kreditVurdering;
	}
*/
	public Kunde(int telefonnummer, String kundefornavn/* String kundeefternavn */, long cpr_nummer, String mail,
			int postnummer, String bynavn, String vejnavn, int husnummer, String kreditVurdering)

	{

		this.telefonnummer = telefonnummer;
		this.kundefornavn = kundefornavn;
		// this.kundeefternavn = kundeefternavn;
		this.cpr_nummer = cpr_nummer;
		this.mail = mail;
		this.postnummer = postnummer;
		this.bynavn = bynavn;
		this.vejnavn = vejnavn;
		this.husnummer = husnummer;
		this.kreditVurdering = kreditVurdering;
	}

	public int getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(int telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public String getKundefornavn() {
		return kundefornavn;
	}

	public void setKundefornavn(String kundefornavn) {
		this.kundefornavn = kundefornavn;
	}

	/*
	 * public String getKundeefternavn() { return kundeefternavn; }
	 * 
	 * public void setKundeefternavn(String kundeefternavn) { this.kundeefternavn =
	 * kundeefternavn; }
	 */
	public long getCpr_nummer() {
		return cpr_nummer;
	}

	public void setCpr_nummer(long cpr_nummer) {
		this.cpr_nummer = cpr_nummer;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getPostnummer() {
		return postnummer;
	}

	public void setPostnummer(int postnummer) {
		this.postnummer = postnummer;
	}

	public String getBynavn() {
		return bynavn;
	}

	public void setBynavn(String bynavn) {
		this.bynavn = bynavn;
	}

	public String getVejnavn() {
		return vejnavn;
	}

	public void setVejnavn(String vejnavn) {
		this.vejnavn = vejnavn;
	}

	public int getHusnummer() {
		return husnummer;
	}

	public void setHusnummer(int husnummer) {
		this.husnummer = husnummer;
	}

	public String getKreditVurdering() {
		return kreditVurdering;
	}

	public void setKreditVurdering(String kreditVurdering) {
		this.kreditVurdering = kreditVurdering;
	}

	@Override
	public String toString() {
		return telefonnummer + kundefornavn /* kundeefternavn */ + cpr_nummer + mail + postnummer + bynavn + vejnavn
				+ husnummer + kreditVurdering;
	}

}
