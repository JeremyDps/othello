package pack.clas;

import java.util.ArrayList;
import java.util.Arrays;

public class Grille {
	int n;//taille de la grille
	Case [][]grille;
	ArrayList<Pion> pions;
	ArrayList<Case>CasenonVides;
	ArrayList<Case>CasesVides;
	public Grille(int n) {
		grille = new Case[n][n];
		this.CasenonVides= new ArrayList<Case>();
		this.CasesVides=new ArrayList<Case>();
		this.pions=new ArrayList<Pion>();
		this.n = n;
	}
	void initialiser_Grille(int n)
	{
		int i,j;
		Case ma_case;
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				ma_case =	new Case("_",i, j);
				grille[i][j]=ma_case;
				
			}
		}
		placer_4_premierpion();
	}
	void afficherCase()
	{
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				System.out.println(grille[i][j]);
			}
	}
//placre les 4 premiers pions
	Case[][] placer_4_premierpion()
	{
		Pion p1,p2,p3,p4;
		p1=new Pion("1");
		p2=new Pion("2");
		p3=new Pion("2");
		p4=new Pion("1");
	
		grille[n/2-1][n/2-1].placer_un_pion(p1);
		grille[n/2-1][n/2].placer_un_pion(p2);
		grille[n/2][n/2-1].placer_un_pion(p3);
		grille[n/2][n/2].placer_un_pion(p4);
		return grille;
	}
	//afficher lle plateau de jeux

	void afficherIndex(int n) {
		System.out.print("/ ");
		for (int i = 0; i < n - 1; i++) {
			System.out.print(i + ",");
		}
		System.out.print(n - 1 + "\n");
	}

		protected void afficherMatrice(int n)
		{
			System.out.println("Bienvenue sur le jeu Othello\n");
			System.out.println("****************************\n");

			afficherIndex(n);

			for(int i=0;i<n;i++)
			{
				System.out.print(i);
				for(int j=0;j<n;j++)
				{
					System.out.print("|");
					if(grille[i][j].valeur_Case == "$") {
						grille[i][j].valeur_Case = "_";
					}
					System.out.print(grille[i][j].valeur_Case);
				}
				System.out.print("|");
				System.out.print("\n");
			}

		}

	void afficherMatriceRechercheCoup(Case[][] tab, int n) {
		afficherIndex(n);

		for(int i=0;i<n;i++)
		{
			System.out.print(i);
			for(int j=0;j<n;j++)
			{
				System.out.print("|");
				System.out.print(tab[i][j].valeur_Case);
			}
			System.out.print("|");
			System.out.print("\n");
		}
	}
		
}
