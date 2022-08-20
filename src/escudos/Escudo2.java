package escudos;

import atack.Ataque;
import modelo.Personagem;

public class Escudo2 extends Escudo{

    @Override
    public void processaEscudo(Ataque a, Personagem p) {
        int escudo = 2;

        a.setDano(a.getDano()-escudo);

        if (a.getDano() < 0){
            a.setDano(0);
        }

        if (getSucessor() != null){
            getSucessor().processaEscudo(a, p);
        }
        else {
            p.sofrerDano(a.getDano());
        }
    }
}
