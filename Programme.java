package fr.vincent.morpion;

import java.util.Scanner;

public class Programme {

	public static void main(String[] args) {
		
		System.out.println("\n#####  La partie de morpion se joue à deux joueurs humains sur une grille de 3*3 ou 5*5  #####");		
		
		Scanner entier = new Scanner(System.in);
		System.out.println("\nDéfinissez la taille de la taille de la grille : 3 ou 5");
		int taille = entier.nextInt();
		
		if (taille<3 || taille>5 || taille==4) {
			System.out.println("La taille de la grille doit être soit 3 soit 5");
			main(args);
		}else {
		int [][]tableau = new int [taille+2] [taille+2];
		
		mesMethodes.afficherMonTableau(tableau);
		
		
		Scanner joueur1 = new Scanner(System.in);
		System.out.println("Quel joueur veut commencer ? 1 ou 2 ?");
		int premierJoueur = joueur1.nextInt();
		System.out.println("Le joueur N° " + premierJoueur + " commence");
		
		if (premierJoueur!=1 && premierJoueur!=2) {
			System.out.println("La partie se joue à 2 joueurs !");
			Programme.main(args);
		}
		
		int partieEnCours=0;
		while(partieEnCours==0) {		
		
			if (premierJoueur==1) {
		Scanner ligneJoueur1 = new Scanner(System.in);
		System.out.println("Le joueur N° 1 choisi un numéro de ligne");
		int ligneJ1= ligneJoueur1.nextInt();
		
		Scanner colonneJoueur1 = new Scanner(System.in);
		System.out.println("Le joueur N° 1 choisi un numéro de colonne");
		int colonneJ1= colonneJoueur1.nextInt();
		
		if (tableau[ligneJ1] [colonneJ1]==0) {
			tableau[ligneJ1][colonneJ1]=1;
			mesMethodes.verifFinale(tableau, ligneJ1, colonneJ1);
			premierJoueur=2;
			mesMethodes.afficherMonTableau(tableau);
			System.out.println(" ");
		}else {
			System.out.println("La case a déjà été jouée");
			premierJoueur=1;
			mesMethodes.afficherMonTableau(tableau);
		}
		}
			if (premierJoueur==2) {
		Scanner ligneJoueur2 = new Scanner(System.in);
		System.out.println("Le joueur N° 2 un numéro de ligne");
		int ligneJ2= ligneJoueur2.nextInt();
		
		Scanner colonneJoueur2 = new Scanner(System.in);
		System.out.println("Le joueur N° 2 choisi un numéro de colonne");
		int colonneJ2= colonneJoueur2.nextInt();
		
		if (tableau[ligneJ2][colonneJ2]==0) {
			tableau[ligneJ2][colonneJ2]=2;
			mesMethodes.verifFinale(tableau, ligneJ2, colonneJ2);
			premierJoueur=1;
			mesMethodes.afficherMonTableau(tableau);
			System.out.println(" ");
		}else {
			System.out.println("La case a déjà été jouée");
			premierJoueur=2;
			mesMethodes.afficherMonTableau(tableau);
		}
			}
		}
	}		
	}
	
	public static class mesMethodes{
		
		public static void afficherMonTableau(int[][]tableau) {
			
			for (int i=0;i<tableau.length;i++) {
				for(int j=0;j<tableau.length;j++) {
					tableau [0][j]=99;
					tableau [i][0]=99;
					tableau [tableau.length-1][j]=99;
					tableau [i][tableau.length-1]=99;
					
						if (tableau [i][j]==99) {
							System.out.print("#");
						}
						if (tableau [i][j]==0) {
							System.out.print(" ");
						}
						
						if (tableau [i][j]==1) {
							System.out.print("X");
						}
						if (tableau [i][j]==2) {
							System.out.print("O");
						}
				}
					
				System.out.println();	
	}
}
		
		
		public static int sensDeplacement (int [][] t, int i, int j, int deltai, int deltaj) {
			int symbol = t[i][j];
			int compteur = 0;
			while (i+deltaj>=0 && i+deltai<t.length && j+deltaj>=0 && 
					j+deltaj<t[0].length && t[i+deltai][j+deltaj]==symbol) {
				compteur=compteur+1;
				i=i+deltai;
				j=j+deltaj;
			}
			return compteur;
			}
		
		public static boolean testerLigne(int[][]t, int i, int j) {
			int versGauche = sensDeplacement(t, i, j, 0, -1);
			int versDroite = sensDeplacement(t, i, j, 0, 1);
			if (versGauche + versDroite==2) {
				return true;
			}else {
				return false;
			}
		}
		
		public static boolean testerColonne(int[][]t, int i, int j) {
			int versHaut = sensDeplacement(t, i, j, 1, 0);
			int versBas = sensDeplacement(t, i, j, -1, 0);
			if (versHaut + versBas==2) {
				return true;
			}else {
				return false;
			}
		}
		
		public static boolean testerDiagonale1(int[][]t, int i, int j) {
			int versGauche = sensDeplacement(t, i, j, -1, -1);
			int versDroite = sensDeplacement(t, i, j, 1, 1);
			if (versGauche + versDroite==2) {
				return true;
			}else {
				return false;
			}
		}
		
		
		public static boolean testerDiagonale2(int[][]t, int i, int j) {
			int versHaut = sensDeplacement(t, i, j, -1, -1);
			int versBas = sensDeplacement(t, i, j, 1, -1);
			if (versHaut + versBas==2) {
				return true;
			}else {
				return false;
			}
		}
		
		public static boolean verifFinale(int[][]t, int i, int j) {
			if(testerLigne(t, i, j)==true || testerColonne(t, i, j)==true || 
					testerDiagonale1(t, i, j)==true || testerDiagonale2(t, i, j)==true){
				System.out.println("!!!!! BRAVO vous avez gagné !!!!!");
				return true;
			}else {
				return false;
			}
			
		}
		
		}
}
	




	
	


