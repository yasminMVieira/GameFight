package factory;

import atack.*;
import modelo.*;

public class AdvancedFactory {
    public Personagem createPersonagem(int tipo) {
        Personagem p = null;
        Inimigo i = null;

        if (tipo == 1) {
            p = new Personagem01("futurista", 0, 0);
            p.setA(new Poder1(new Forte()));
        } else if (tipo == 2) {
            p = new Personagem02("futurista", 0, 0);
            p.setA(new Poder2(new MedioA()));
        } else if (tipo == 3) {
            p = new Personagem03("futurista", 0, 0);
            p.setA(new Poder3(new Fraco()));
        } else if (tipo == 4) {
            i = new Inimigo01("futurista", 5, 5);
            i.setA(new Poder2(new Forte()));
        } else {
            i = new Inimigo02("futurista", 5, 5);
            i.setA(new Poder1(new Fraco()));
        }
        p.getA().setArma("raio paralisante");
        return p;
    }

}
