package pack.clas;

public class Partie {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=8;

		Grille g=new Grille(n);
		Jeu jeu = new Jeu();
		Joueur j1 = new Joueur("1", "reel");
		Joueur j2 = new Joueur("2", "IA");

		g.initialiser_Grille(n);
		System.out.print(g.grille[n/2-1][n/2]);
		g.afficherMatrice(n);

		System.out.println(g.getClass().getName());
	
		Case [][] grilleRechercheCoup = g.grille;
		boolean coupPossible = jeu.checkCoupValide(grilleRechercheCoup, j1.numero, n);

	}

}