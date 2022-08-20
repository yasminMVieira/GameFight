package estados;

import modelo.Personagem;

public abstract class PersonagemState {
    private Personagem persona;
    private int lifeMax;
    private int lifeMin;

    public PersonagemState(Personagem persona){
        this.persona = persona;
        setLifes();
    }

    protected abstract void setLifes();

    public Personagem getPersona() {
        return persona;
    }

    public void setPersona(Personagem persona) {
        this.persona = persona;
    }

    public int getLifeMax() {
        return lifeMax;
    }

    public void setLifeMax(int lifeMax) {
        this.lifeMax = lifeMax;
    }

    public int getLifeMin() {
        return lifeMin;
    }

    public void setLifeMin(int lifeMin) {
        this.lifeMin = lifeMin;
    }

    public void sofrerDano(int dano){
        this.persona.setLife(this.persona.getLife() - dano);
        this.verificarAlteracaoState();
    }

    public void pegarRecompensa(int recompensa) {
        this.persona.setLife(this.persona.getLife() + recompensa);
        this.verificarAlteracaoState();
    }
    protected abstract void verificarAlteracaoState();

}
