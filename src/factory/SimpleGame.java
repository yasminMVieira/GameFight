package factory;

import modelo.*;
import game.*;

public class SimpleGame extends Game {
    private static SimpleGame game = null;
    private  SimpleGame(){}

    public static SimpleGame getInstance(){
        if  (game == null)
            game = new SimpleGame();
        return game;
    }

    @Override
    public Personagem createPersonagem(int tipo) {
        Personagem p = null;

        if (tipo == 1) {
            p = new Personagem01("Arqueiro", 350,350);
            p.getA().setArma("Arco e flecha");
        } else if (tipo == 2) {
            p = new Personagem02("Feitiçeiro",350,350);
            p.getA().setArma("Feitiço selvagem");
        } else if (tipo == 3) {
            p = new Personagem03("Mago",350,350);
            p.getA().setArma("Magia sombria");
        }

        return p;
    }


}
