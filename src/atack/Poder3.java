package atack;

public class Poder3 extends AtaqueDecorador {

    public Poder3(Ataque ataqueDecorado) {
        super(ataqueDecorado);
        setDano(3);
    }

    @Override
    public void atacar() {

    }
}
