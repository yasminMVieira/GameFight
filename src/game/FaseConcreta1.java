package game;
import modelo.*;

public class FaseConcreta1 extends Fase{

    public Component montaLab(){
        Component labirinto = new SalaAdvinha(new game.Abismo(), new SalaAdvinha(new SalaAdvinha(new Abismo(),
               new SalaAutomatica(new Abismo(), new Saida(),"Sala Automatica 3", new Inimigo01("Cobra", 250,250)),"Sala Advinha 4", new Inimigo01("Onça", 250,250)),
                new Saida(),"Sala Advinha 2", new Inimigo01("Barata", 250,250)), "Sala Advinha 1", new Inimigo01("Cobra", 250,250));


        return labirinto;
    }

}
