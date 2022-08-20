package modelo;

import jump.Medio;
import modelo.Personagem;
import run.MedioC;

public class Personagem01 extends Personagem {
    public Personagem01(String nome, int x, int y) {
        super(100, nome, x, y);
        setP(new Medio());
        setC(new MedioC());
    }

}
