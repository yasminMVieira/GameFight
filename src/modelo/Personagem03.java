package modelo;

import jump.Baixo;
import modelo.Personagem;
import run.Rapido;

public class Personagem03 extends Personagem {

    public Personagem03(String nome, int x, int y) {
        super(100, nome, x, y);
        setP(new Baixo());
        setC(new Rapido());
    }

}
