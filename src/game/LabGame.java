package game;

import modelo.Personagem;

public class LabGame implements Runnable
{
    private Component labirinto;
    private Personagem p;


    public LabGame(Component labirinto, Personagem p){
        this.labirinto = labirinto;
        this.p = p;

    }


    public void run(){
        labirinto.selecionarCaminho(p);
    }

}

