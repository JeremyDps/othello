package pack.clas;

public class Joueur {

    private String numero; // 1 ou 2
    private String type; // réel ou IA
    private int score;

    public Joueur(String numero, String type) {
        this.numero = numero;
        this.type = type;
        this.score = 2;
    }

    public int getScore() {
        return this.score;
    }

    public String getNumero() {
        return this.numero;
    }

    public String type() {
        return this.type;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
