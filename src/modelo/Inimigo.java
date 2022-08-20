package modelo;

import atack.Ataque;
import atack.MedioA;
import jump.Pulo;
import run.Corrida;


import java.util.Observable;
import java.util.Observer;

public class Inimigo implements Observer {

    private Ataque a;
    private Pulo p;
    private Corrida c;
    private int life;
    private String nome;

    private int x = 0;

    private int y = 0;


    public Inimigo(int life, String nome, int x, int y) {
        this.life = life;
        this.nome = nome;
        this.x = x;
        this.y = y;
    }

    //-----------------------------------------
    // GET AND SETTER
    public Ataque getA() {
        return a;
    }

    public void setA(Ataque a) {
        this.a = a;
    }

    public Pulo getP() {
        return p;
    }

    public void setP(Pulo p) {
        this.p = p;
    }

    public Corrida getC() {
        return c;
    }

    public void setC(Corrida c) {
        this.c = c;
    }


    public int getLife() {
        return this.life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Posicao do inimigo: ("+this.x+","+this.y+")");
    }
    //-----------------------------------------
    // METODOS
    public void pular(){
        p.pular();
    }
    public void correr(){
        c.correr();
    }
    public void atacar( Personagem defensor){
        this.a.atacar();
        if(defensor.getE() != null)
            defensor.getE().processaEscudo(this.getA(), defensor);
        else
            defensor.sofrerDano(this.getA().getDano());
    }
    public void sofrerDano(int dano){
        System.out.println("Vida inimigo inicial: " + this.getLife());
        setLife(getLife() - dano);
        System.out.println("Vida inimigo pós lutar: " + this.getLife());
    }

    @Override
    public void update(Observable subject, Object arg) {
       Personagem p = (Personagem) subject;

        //se estiver em distancia de chute
        if ( ( (this.x - p.getX()) ==0) && ((this.y - p.getY()) ==0) ){
            atacar(p);
            System.out.println("Inimigo: "+this.nome+" ataca personagem " + p.getNome() );
            if (Math.random() < 0.5){
                p.setPosP(p.getX()+(int)(50*Math.random()), p.getY()-(int)(50*Math.random()));
            }
            else {
                p.setPosP(p.getX()-(int)(50*Math.random()), p.getY()+(int)(50*Math.random()));
            }
        }

        //se precisar andar em direcao a p
        else {
            //se precisa andar para frente
            if (p.getX() > this.x)
                this.x = this.x+(int)(5*Math.random());
            else
                this.x = this.x-(int)(5*Math.random());
            //se precisa andar para tras
            if (p.getY() > this.y)
                this.y = this.y+(int)(5*Math.random());
            else
                this.y = this.y-(int)(5*Math.random());
        }

        if (p.getX() < 0) p.setX(100);
        if (p.getY() < 0) p.setY(100);
    }


}
