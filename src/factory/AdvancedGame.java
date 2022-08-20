package factory;

import atack.*;
import atack.*;
import modelo.*;
import game.*;


public class AdvancedGame extends Game {
    private static AdvancedGame game = null;

    private  AdvancedGame(){}

    public static AdvancedGame getInstance(){
        if  (game == null)
            game = new AdvancedGame();
        return game;
    }

    @Override
    public Personagem createPersonagem(int tipo) {
        Personagem p = null;

        if (tipo == 1) {
            p = new Personagem01("Robô",350,350);
            p.setA(new Poder1(new Forte()));
            p.getA().setArma("Raio paralisante");
        } else if (tipo == 2) {
            p = new Personagem02("Vyper",350,350);
            p.setA(new Poder2(new MedioA()));
            p.getA().setArma("Granada veneno");
        } else if (tipo == 3) {
            p = new Personagem03("Jett",350,350);
            p.setA(new Poder3(new Fraco()));
            p.getA().setArma("Facas teleguiadas");
        }

        return p;
    }

}
