package game;

import modelo.Inimigo01;

public class FaseConcreta2 extends Fase{

    public Component labirinto2;

    public Component montaLab(){
        Component labirinto2 = new SalaAdvinha(new Abismo(), new SalaAdvinha(new SalaAdvinha(new Abismo(),
                new SalaAutomatica(new Abismo(), new Saida(),"3", new Inimigo01("Cobra", 250,250)),"4", new Inimigo01("Onça", 250,250)),
                new Saida(),"2", new Inimigo01("Leão", 250,250)), "1", new Inimigo01("Cobra", 250,250));

        return labirinto2;
    }

}
