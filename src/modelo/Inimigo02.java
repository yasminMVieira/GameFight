package modelo;

import atack.Forte;
import atack.MedioA;
import jump.Alto;
import run.Devagar;

public class Inimigo02 extends Inimigo {

    public Inimigo02 ini;

    public Inimigo02(String nome, int x, int y) {
        super(70, nome, x, y);
        setP(new Alto());
        setC(new Devagar());
        this.ini = this;
        setA(new MedioA());
    }
}
