package atack;

public abstract class AtaqueDecorador extends Ataque {
    private Ataque ataqueDecorado;

    public AtaqueDecorador(Ataque ataqueDecorado) {
        this.ataqueDecorado = ataqueDecorado;
    }
    @Override
    public int getDano() {
        System.out.println("O dano do decorado é: " + (super.getDano() + ataqueDecorado.getDano()));
        return ataqueDecorado.getDano() + super.getDano();
    }
}
