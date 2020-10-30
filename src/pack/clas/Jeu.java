package pack.clas;

import static java.lang.Integer.parseInt;

public class Jeu {
    public static String[] checkCoupValide(Case[][] tab, String numeroJoueur, int n) {
        String memeNumero = numeroJoueur;
        String numeroAdverse = 3 - parseInt(numeroJoueur) + "";
        String[] res = new String[2];
        int nbrCoupsValides = 0;

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
                    if(tab[x - 1][y + 1].valeur_Case.equals(numeroAdverse)) {
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

                //diagonale sud-ouest
                boolean sudOuest = false;
                if (x != 6 && x != 7 && y != 0 && y != 1) {
                    if(tab[x + 1][y - 1].valeur_Case.equals(numeroAdverse)) {
                        int numtimes = 0;
                        if (x + y <= 7) {
                            numtimes = y - 1;
                        } else {
                            numtimes = 6 - x;
                        }
                        int tempx = x + 2;
                        int tempy = y - 2;

                        for (int i = 0; i < numtimes; i++) {
                            if(tab[tempx][tempy].valeur_Case.equals(numeroJoueur)) {
                                sudOuest = true;
                                break;
                            } else if (tab[tempx][tempy].valeur_Case.equals("_") | tab[tempx][tempy].valeur_Case.equals("=")) {
                                break;
                            }
                            tempx++;
                            tempy--;
                        }
                    }
                }

                //diagonale nord-ouest
                boolean nordOuest = false;
                if(x != 0 && x != 1 && y != 0 && y != 1) {
                    if(tab[x - 1][y - 1].valeur_Case.equals(numeroAdverse)) {
                        int numtimes = 0;
                        if (x <= y) {
                            numtimes = x - 1;
                        } else {
                            numtimes = y - 1;
                        }
                        int tempx = x - 2;
                        int tempy = y - 2;
                        for (int i = 0; i < numtimes; i++) {
                            if(tab[tempx][tempy].valeur_Case.equals(numeroJoueur)) {
                                nordOuest = false;
                                break;
                            }else if(tab[tempx][tempy].valeur_Case.equals("_") | tab[tempx][tempy].valeur_Case.equals("=")) {
                                break;
                            }
                            tempx--;
                            tempy--;
                        }
                    }
                }

                //diagonale sud-est
                boolean sudEst = false;
                if(x != 6 && x != 7 && y != 6 && y != 7) {
                    if(tab[x + 1][y + 1].valeur_Case.equals(numeroAdverse)) {
                        int numtimes = 0;
                        if(x <= y) {
                            numtimes = 6 - y;
                        } else {
                            numtimes = 6 - x;
                        }
                        int tempx = x + 2;
                        int tempy = y + 2;

                        for(int i = 0; i < numtimes; i++) {
                            if(tab[tempx][tempy].valeur_Case.equals(numeroJoueur)) {
                                sudEst = true;
                                break;
                            }else if(tab[tempx][tempy].valeur_Case.equals("_") | tab[tempx][tempy].valeur_Case.equals("=")) {
                                break;
                            }
                            tempx++;
                            tempy++;
                        }
                    }
                }

                //recherche horizontale
                //est
                boolean est = false;
                if((y != 6 && y != 7) && tab[x][y + 1].valeur_Case.equals(numeroAdverse)) {
                    for(int i = y + 2; i <= 7; i++) {
                        if(tab[x][i].valeur_Case.equals(memeNumero)) {
                            est = true;
                            break;
                        } else if(tab[x][i].valeur_Case.equals("_") | tab[x][i].valeur_Case.equals("=")) {
                            break;
                        }
                    }
                }

                //ouest
                boolean ouest =false;
                if((y != 0 && y != 1) && tab[x][y - 1].valeur_Case.equals(numeroAdverse)){
                    for(int i = y - 2; i >= 0; i--){
                        if(tab[x][i].valeur_Case.equals(memeNumero)){
                            ouest = true;
                            break;
                        }else if(tab[x][i].valeur_Case.equals("_") | tab[x][i].valeur_Case.equals("=")){
                            break;
                        }
                    }
                }

                //recherche verticale
                //sud
                boolean sud =false;
                if((x != 6 && x != 7) && tab[x+1][y].valeur_Case.equals(numeroAdverse)){
                    for(int i = x + 2; i <= 7; i++){
                        if(tab[i][y].valeur_Case.equals(memeNumero)){
                            sud = true;
                        }else if(tab[i][x].valeur_Case.equals("_") | tab[i][x].valeur_Case.equals("=")){
                            break;
                        }
                    }
                }

                //nord
                boolean nord =false;
                if((x != 0 && x != 1) && tab[x-1][y].valeur_Case.equals(numeroAdverse)){
                    for(int i = x - 2; i >= 0; i--){
                        if(tab[i][y].valeur_Case.equals(memeNumero)){
                            nord = true;
                            break;
                        }else if(tab[i][y].valeur_Case.equals("_") | tab[i][y].valeur_Case.equals("=")){
                            break;
                        }
                    }
                }

                if(nord | sud | est | ouest | nordEst | nordOuest | sudEst | sudOuest) {
                    tab[x][y].valeur_Case = "$";
                    if(tab[x][y].valeur_Case == "$") {
                        System.out.println("coup valide pour x = " + x + " et y = " + y);
                    }
                    if(nord) {
                        System.out.println("nord");
                    }
                    if(sud) {
                        System.out.println("sud");
                    }
                    if(est) {
                        System.out.println("est");
                    }
                    if(ouest) {
                        System.out.println("ouest");
                    }
                    if(nordEst) {
                        System.out.println("nord est");
                    }
                    if(nordOuest) {
                        System.out.println("nord ouest");
                    }
                    if(sudEst) {
                        System.out.println("sud est");
                    }
                    if (sudOuest) {
                        System.out.println("sud ouest");
                    }
                    nbrCoupsValides++;
                    res[0] = "true";
                    res[1] = String.valueOf(nbrCoupsValides);
                }
            }
        }
        return res;
    }
}


