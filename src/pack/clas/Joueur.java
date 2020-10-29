package pack.clas;

public class Joueur {

    public String numero; // 1 ou 2
    public String type; // réel ou IA
    public int score;

    public Joueur(String numero, String type) {
        this.numero = numero;
        this.type = type;
        this.score = 2;
    }

}
