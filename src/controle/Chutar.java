package controle;//A camada de controle faz referencia (importa/depende) do modelo, mas e' independente da visao

import modelo.*;

public class Chutar implements Command
{
    Inimigo b;
    Personagem j;

    public Chutar(Inimigo b, Personagem j){
       this.b = b;
       this.j = j;
    }    
    public void execute(){
      j.chuta(b);

    }    
}
