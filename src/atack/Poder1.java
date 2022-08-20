package atack;

public class Poder1 extends AtaqueDecorador{

    public Poder1(Ataque ataqueDecorado) {
        super(ataqueDecorado);
        setDano(1);
    }

    @Override
    public void atacar() {
        System.out.println("Ataque decorado, poder 1");
    }
}
