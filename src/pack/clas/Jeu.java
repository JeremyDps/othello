package pack.clas;

import static java.lang.Integer.parseInt;

public class Jeu {
    public static boolean checkCoupValide(Case tab [][], String numeroJoueur, int n) {
        String memeNumero = numeroJoueur;
        String numeroAdverse = 3 - parseInt(numeroJoueur) + "";
        boolean res = false;
        int coupsPossibles = 0;

        for(int k = 0; k < n; k++) {
            for(int l = 0; l < n; l++) {
                int x = k;
                int y = l;

                if(tab[x][y].valeur_Case.equals("1") | tab[x][y].valeur_Case.equals("2")) {
                    continue;
                }

                //recherche de coups dans la diagonale nord-est
                boolean nordEst = false;
                if(x != 1 && x != 0 && y != 6 && y != 7) {
                    if(tab[x - 1][y - 1].valeur_Case.equals(numeroAdverse)) {
                        int numTimes = 0;
                        if(x + y <= 7) {
                            numTimes = x - 1;
                        } else {
                            numTimes = 6 - y;
                        }

                        int tempx = x - 2;
                        int tempy = y + 2;
                        for(int i = 0; i < numTimes; i++) {
                            if(tab[tempx][tempy].valeur_Case.equals(memeNumero)) {
                                nordEst = true;
                                break;
                            } else if (tab[tempx][tempy].valeur_Case.equals("_") | tab[tempx][tempy].valeur_Case.equals("=")) {
                                break;
                            }
                            tempx--;
                            tempy++;
                        }
                    }
                }
            }
        }
        return false;
    }
}


