package factory;

import modelo.*;

public class SimplePersonagemFactory {
    public Personagem createPersonagem(int tipo) {
        Personagem p = null;
        Inimigo i = null;

        if (tipo == 1) {
            p = new Personagem01("medieval", 0, 0);

        } else if (tipo == 2) {
            p = new Personagem02("medieval", 0, 0);

        } else if (tipo == 3) {
            p = new Personagem03("medieval", 0, 0);

        } else if (tipo == 4) {
            i = new Inimigo01("medieval", 5, 5);

        } else {
            i = new Inimigo02("medieval", 5, 5);

        }
        p.getA().setArma("arco e flecha");
        return p;
    }

}
