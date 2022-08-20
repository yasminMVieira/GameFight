package modelo;

import jump.Alto;
import modelo.Personagem;
import run.Rapido;

public class Personagem02 extends Personagem {

    public Personagem02(String nome, int x, int y) {
        super(100, nome, x, y);
        setP(new Alto());
        setC(new Rapido());
    }

}
