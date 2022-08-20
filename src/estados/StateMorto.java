package estados;

import modelo.Personagem;

public class StateMorto extends PersonagemState {

    public StateMorto(Personagem persona) {
        super(persona);
        System.out.println("MORTE, FIM DE JOGO");

    }

    @Override
    protected void setLifes() {
        this.setLifeMax(0);
        this.setLifeMin(0);
    }

    @Override
    protected void verificarAlteracaoState() {
        if (this.getPersona().getLife() > this.getLifeMin()){
            this.getPersona().setState(new StatePerigo(this.getPersona()));
            this.getPersona().getState().verificarAlteracaoState();
        }
    }
}
