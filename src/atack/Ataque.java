package atack;

public abstract class Ataque {
    private int dano;
    private String arma;


    public int getDano() {
        return this.dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public abstract void atacar();
}
