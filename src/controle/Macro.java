package controle;

import java.util.*;

//A camada de controle faz referencia (importa/depende) do modelo, mas e' independente da visao

public class Macro implements Command
{
    
    private ArrayList<Command> macro= new ArrayList<Command>(); 
    
    public void add(Command c){macro.add(c);}
    
    public void execute(){
        for (Command c : macro){
            c.execute();
        }     
    }    
    
}
