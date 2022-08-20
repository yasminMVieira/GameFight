package controle;
import modelo.*;
//A camada de controle faz referencia (importa/depende) do modelo, mas e' independente da visao

public class MoverBaixo implements Command
{
    private Personagem j;
    public MoverBaixo(Personagem j){
        this.j = j;
    }    
    
    public void execute(){
        j.moverBaixo();           
    }    
    
}
