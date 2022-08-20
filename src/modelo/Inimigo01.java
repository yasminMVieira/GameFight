package modelo;

import atack.Forte;
import atack.Fraco;
import jump.Medio;
import run.Rapido;

public class Inimigo01 extends Inimigo {

    public Inimigo01 ini;
    public Inimigo01(String nome, int x, int y) {
        super(100, nome, x, y);
        setP(new Medio());
        setC(new Rapido());
        this.ini = this;
        setA(new Fraco());
    }


}
