package atack;

public class Poder2 extends AtaqueDecorador {

    public Poder2(Ataque ataqueDecorado) {
        super(ataqueDecorado);
        setDano(2);
    }

    @Override
    public void atacar() {
        System.out.println("Ataque decorado, poder 2");
    }

}
