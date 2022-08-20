package estados;

import atack.Forte;
import jump.Alto;
import modelo.Personagem;
import run.Rapido;

public class StateForte extends PersonagemState {

    public StateForte(Personagem persona) {
        super(persona);
        persona.setA(new Forte());
        persona.setC(new Rapido());
        persona.setP(new Alto());
    }

    @Override
    protected void setLifes() {
        this.setLifeMax(100);
        this.setLifeMin(70);
    }

    @Override
    protected void verificarAlteracaoState() {
        if (this.getPersona().getLife() < this.getLifeMin()){
            this.getPersona().setState(new StateNormal(this.getPersona()));
            this.getPersona().getState().verificarAlteracaoState();
        }
    }
}
