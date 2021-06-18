package gestionReservation.beans;

public class Client {

	private int id;
	private String cin;
	private String nom;
	private String prenom;
	private String date_naissance;
	private String lieu_naissance;
	private String addresse;
	private String etat_civil;
	private String nationalite;
	
	public Client(int id,String cin, String nom, String prenom, String date_naissance, String lieu_naissance, String addresse, String etat_civil, String nationalite) {
		super();
		this.id=id;
		this.nom = cin;
		this.nom = nom;
		this.prenom =prenom;
		this.date_naissance = date_naissance;
		this.lieu_naissance = lieu_naissance;
		this.addresse = addresse;
		this.etat_civil = etat_civil;
		this.nationalite = nationalite;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}
	public String getLieu_naissance() {
		return lieu_naissance;
	}
	public void setLieu_naissance(String lieu_naissance) {
		this.lieu_naissance = lieu_naissance;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public String getEtat_civil() {
		return etat_civil;
	}
	public void setEtat_civil(String etat_civil) {
		this.etat_civil = etat_civil;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	
	
	
	

}
