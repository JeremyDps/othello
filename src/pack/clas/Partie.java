package pack.clas;

import java.util.Scanner;
import static java.lang.Integer.parseInt;


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

		//System.out.println(g.getClass().getName());

		int numeroJoueur = parseInt(j1.getNumero());
		System.out.println("C'est au tour du joueur " + numeroJoueur + " de jouer");

		//Cette boucle s'arretera quand le jeu sera terminé, CAD quand il n'y aura plus de cases libres
		while(true) {
			int scoreTotal = j1.getScore() + j2.getScore();
			System.out.println("score total = " + scoreTotal);
			if(scoreTotal >= 6) {
				break;
			}

			//avant de jouer, on vérifie si le joueur peut jouer au moins un coup
			Case [][] grilleRechercheCoup = g.grille;
			String[] coupPossible = jeu.checkCoupValide(grilleRechercheCoup, String.valueOf(numeroJoueur), n);

			//si le joueur a au moins 1 coup possible
			if(coupPossible[0] == "true") {
				System.out.println("il y a " + coupPossible[1] + " coups possible");
				g.afficherMatriceRechercheCoup(grilleRechercheCoup, n);

				String[] coordonneesCoup = jeu.selectCoordonnees();

				boolean checkCoordonnees = jeu.checkCoordonnees(grilleRechercheCoup, parseInt(coordonneesCoup[0]), parseInt(coordonneesCoup[1]));
				if(checkCoordonnees) {
					jeu.changerNumeros(g.grille, parseInt(coordonneesCoup[0]), parseInt(coordonneesCoup[1]), String.valueOf(numeroJoueur));
					g.afficherMatrice(n);
					int[] tableauDesScores = jeu.calculDesScores(g.grille, numeroJoueur, n);

					if(numeroJoueur == 1) {
						j1.setScore(tableauDesScores[0]);
						j2.setScore(tableauDesScores[1]);
						System.out.println("Le joueur " + numeroJoueur + " a désormais " + j1.getScore() + " points et le joueur " + (3 - numeroJoueur) + " a " + j2.getScore() + " points");
					} else {
						j2.setScore(tableauDesScores[0]);
						j1.setScore(tableauDesScores[1]);
						System.out.println("Le joueur " + numeroJoueur + " a désormais " + j2.getScore() + " points et le joueur " + (3 - numeroJoueur) + " a " + j1.getScore() + " points");
					}

					numeroJoueur = 3 - numeroJoueur;
					System.out.println("C'est au tour de joueur " + numeroJoueur + " de jouer");
				} else {
					System.out.println("coup pas possible");
				}
			}
		}

		jeu.definirVainqueur(g.grille, numeroJoueur, n);

	}
}
