package controle;
import modelo.*;
//A camada de controle faz referencia (importa/depende) do modelo, mas e' independente da visao

public class MoverDir implements Command
{
    private Personagem j;
    public MoverDir(Personagem j){
        this.j = j;
    }    
    
    public void execute(){
        j.moverDir();           
    }    
    
}
