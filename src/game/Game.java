package game;

import escudos.*;
import modelo.*;

import java.util.Random;

public abstract class Game {
    public abstract Personagem createPersonagem(int tipo);

    public void jogar() throws InterruptedException {


        Random n = new Random(1);
        float aux = n.nextFloat();

        Personagem p1 = criarTipoPersonagem(aux);
        System.out.println("Personagem " + p1.getNome() + ", cuja arma é: " + p1.getA().getArma());

        aux = n.nextFloat();
        Personagem p2 = criarTipoPersonagem(aux);
        System.out.println("Personagem " + p2.getNome() + ", cuja arma é: " + p2.getA().getArma());

        aux = n.nextFloat();
        Personagem p3 = criarTipoPersonagem(aux);
        System.out.println("Personagem " + p3.getNome() + ", cuja arma é: " + p3.getA().getArma());


        Fase f1 = new FaseConcreta1();


        System.out.println("Vida inicial p1: " + p1.getLife());
        System.out.println("Vida inicial p2: " + p2.getLife());
        System.out.println("Vida inicial p3: " + p3.getLife());
        System.out.println("State inicial p1: " + p1.getState());
        System.out.println("State inicial p2: " + p2.getState());
        System.out.println("State inicial p3: " + p3.getState());
        System.out.println();


        Escudo1 e1 = new Escudo1(); //Set de escudo do personagem p1
        Escudo2 e2 = new Escudo2();
        Escudo3 e3 = new Escudo3();
        Escudo4 e4 = new Escudo4();
        Escudo5 e5 = new Escudo5();

        //Criando cadeia de 3 escudos
        e1.setSucessor(e2);
        e2.setSucessor(e3);
        e3.setSucessor(e4);
        e4.setSucessor(e5);
        e5.setSucessor(null);

        //atribuindo cadeia de escudo
        //p1.setE(e3);
        //p2.setE(e1);

        Component labMontado = (f1.montaLab());

        Thread t1 = new Thread(new LabGame(labMontado, p1));
        //Thread t2 = new Thread(new game.LabGame(f1.montaLab(), p2));
        /*Thread t3 = new Thread(new game.LabGame(labirinto, p3));*/

        t1.start();
        // t2.start();
        /*t3.start();*/


        /*try{
            t1.join();
            //t2.join();
            *//*t3.join();*//*
        }
        catch(Exception e){}

        if (p1.getLife() > 0){
            System.out.println("entrei if ");

            game.Fase f2 = new game.FaseConcreta2();
            Thread t2 = new Thread(new game.LabGame(f2.montaLab(), p1));
            t2.start();

            try{
                t2.join();
                *//*t3.join();*//*

            }
            catch(Exception e){}
        }

        System.out.println("FIM DO JOGO. TODOS OS PERSONAGENS TERMINARAM.");*/


    }

    public Personagem criarTipoPersonagem(float aux){

        Personagem p = null;

        if(aux <= 0.2){
            p = createPersonagem(1);
        } else if (aux > 0.2 && aux <= 0.4){
            p = createPersonagem(2);
        } else /*if (aux > 0.4 && aux <= 0.6)*/ {
            p = createPersonagem(3);
        }

        return p;
    }


}
