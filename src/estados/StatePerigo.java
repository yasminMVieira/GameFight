package estados;

import atack.Fraco;
import jump.Baixo;
import modelo.Personagem;
import run.Devagar;

public class StatePerigo extends PersonagemState {

    public StatePerigo(Personagem persona) {
        super(persona);
        persona.setA(new Fraco());
        persona.setC(new Devagar());
        persona.setP(new Baixo());
    }

    @Override
    protected void setLifes() {
        this.setLifeMax(30);
        this.setLifeMin(1);
    }

    @Override
    protected void verificarAlteracaoState() {
        if (this.getPersona().getLife() < this.getLifeMin()){
            this.getPersona().setState(new StateMorto(this.getPersona()));
        }
        else if (this.getPersona().getLife() > this.getLifeMax()){
            this.getPersona().setState(new StateNormal(this.getPersona()));
            this.getPersona().getState().verificarAlteracaoState();
        }
    }

}
