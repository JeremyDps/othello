package graphi.pack;

import pack.clas.Grille;
import pack.clas.Joueur;
import pack.clas.Pion;

public class Plateau {
	
	Grille g;
	Joueur joueur;
	public Plateau(int n) {
		super();
		this.g =new Grille(n);
		this.joueur =null;
	}
	//afficher lle plateau de jeux
		protected void afficherligne(int n)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print("+-");
				
			};
			System.out.print("\n");
		}
		protected void afficherligneVertical(int n)
		{
			System.out.print("|");
		}
	protected void afficherGrille(int n)
	{
		System.out.println("Bienvenue sur le jeu Othello\n");
		System.out.println("****************************\n");
		for(int i=0;i<n;i++)
		{	
			afficherligne(n);
			for(int j=0;j<n;j++)
			{
				afficherligneVertical(n);
				//System.out.print(this.g.getGrille());
				//System.out.print("|");
			}
			afficherligneVertical(n);
			System.out.print("\n");
		}
		 afficherligne(n);
		
	}

}
