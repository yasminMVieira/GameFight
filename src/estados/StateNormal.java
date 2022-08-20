package estados;

import atack.MedioA;
import jump.Medio;
import modelo.Personagem;
import run.MedioC;

public class StateNormal extends PersonagemState {

    public StateNormal(Personagem persona) {
        super(persona);
        persona.setA(new MedioA());
        persona.setC(new MedioC());
        persona.setP(new Medio());
    }

    @Override
    protected void setLifes() {
        this.setLifeMax(70);
        this.setLifeMin(30);
    }

    @Override
    protected void verificarAlteracaoState() {
        if (this.getPersona().getLife() < this.getLifeMin()){
            this.getPersona().setState(new StatePerigo(this.getPersona()));
            this.getPersona().getState().verificarAlteracaoState();
        }
        else if (this.getPersona().getLife() > this.getLifeMax()){
            this.getPersona().setState(new StateForte(this.getPersona()));
        }
    }
}
