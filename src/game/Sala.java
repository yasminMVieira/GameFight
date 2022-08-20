package game;

import modelo.Inimigo;

public abstract class Sala implements Component{

    private Component caminho1;
    private Component caminho2;
    private String nome;
    private Inimigo inimigo;
    
    public Sala(Component c1, Component c2, String nome, Inimigo ini){
        this.caminho1 = c1;
        this.caminho2 = c2;
        this.nome = nome;
        this.inimigo = ini;
    }

    public Component getCaminho1() {
        return caminho1;
    }

    public Component getCaminho2() {
        return caminho2;
    }

    public String getNome() {
        return nome;
    }

    public Inimigo getInimigo() {
        return inimigo;
    }



}
