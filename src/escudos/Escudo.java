package escudos;

import atack.Ataque;
import modelo.Personagem;


public abstract class Escudo {
    private Escudo sucessor;

    private String tipo;

    public void setSucessor(Escudo sucessor) {
        this.sucessor = sucessor;
    }

    public Escudo getSucessor() {
        return this.sucessor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public abstract void processaEscudo(Ataque a, Personagem p);

}