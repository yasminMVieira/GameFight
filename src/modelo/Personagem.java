package modelo;

import estados.PersonagemState;
import atack.Ataque;
import escudos.*;
import estados.*;
import jump.Pulo;
import run.Corrida;

import java.util.Observable;

public abstract class Personagem extends Observable {
    private PersonagemState state;
    private Ataque a;
    private Pulo p;
    private Corrida c;
    private int Life;
    private Escudo e;
    private String nome;

    private int x;

    private int y;


    public Personagem(int life, String nome, int x, int y) {
        this.state = new StateNormal(this);
        Life = life;
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

    public PersonagemState getState() {
        return state;
    }

    public void setState(PersonagemState state) {
        this.state = state;
    }

    public int getLife() {
        return Life;
    }

    public void setLife(int life) {
        Life = life;
    }

    public Escudo getE() {
        return e;
    }

    public void setE(Escudo e) {
        this.e = e;
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

    public void setPosP(int x, int y){
        this.x = x;
        this.y = y;
        System.out.println("Posicao do personagem: ("+this.x+","+this.y+")");
    }

    //-----------------------------------------
    // METODOS
    public void moverEsq() {
        setX(getX() - 10);
    }

    public void moverDir() {
        setX(getX() + 10);
    }

    public void moverCima() {
        setY(getY() - 10);
    }

    public void moverBaixo() {
        setY(getY() + 10);
    }

    public void pular() {
        p.pular();
    }

    public void correr() {
        c.correr();
    }

    public void atacar(Inimigo defensor) {
        this.a.atacar();
        defensor.sofrerDano(this.getA().getDano());
    }

    public void sofrerDano(int dano) {
        state.sofrerDano(dano);
        System.out.println("Sofreu " + dano + " de dano");
    }

    public void pegarRecompensa(int recompensa) {
        state.pegarRecompensa(recompensa);
        System.out.println("Pegou " + recompensa + " recompensa");
    }

    public void chuta(Inimigo bola){ // vai ser o atacar

        //se estiver em distancia de chute
        if ( ( (this.getX() - bola.getX()) <2) && ((this.getY() - bola.getY()) <2) ){
            atacar(bola);
            System.out.println("Personagem: "+this.getNome()+", ataca inimigo " + bola.getNome() );
            if (Math.random() < 0.5){
                bola.setPos(bola.getX()+(int)(100*Math.random()), bola.getY()-(int)(100*Math.random()));
            }
            else {
                bola.setPos(bola.getX()-(int)(100*Math.random()), bola.getY()+(int)(100*Math.random()));
            }
        }

    }

    public void show() {
        setChanged();
        notifyObservers();
    }
}



