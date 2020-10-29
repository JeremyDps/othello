package pack.clas;

public class Pion {
	
	String valeur_pion;//valeur du pion indiquera la couleur du pion
	//Case place_pion;//case qui contient le pion
	Joueur joueur;
	public Pion(String v) {
		
		// TODO Auto-generated constructor stub
		this.valeur_pion=v;
		joueur=null;
		//this.place_pion=null;
	}
	public String getValeur_pion() {
		return valeur_pion;
	}
	
	
}
