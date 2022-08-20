package escudos;

import atack.Ataque;
import modelo.Personagem;

public class Escudo1 extends Escudo{

    @Override
    public void processaEscudo(Ataque a, Personagem p) {
        int escudo = 1;
        int danoFinal;

        System.out.println("Dano do ataque: " + a.getDano());

        a.setDano(a.getDano()-escudo);
        if (a.getDano() < 0){
            a.setDano(0);
            p.setE(null);
        }
        danoFinal = a.getDano();

        if (getSucessor() != null){
            getSucessor().processaEscudo(a, p);
        }
        else {
            p.sofrerDano(danoFinal);
        }
    }


}
