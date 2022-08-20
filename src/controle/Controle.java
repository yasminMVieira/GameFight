package controle;

import java.util.*;

//INVOKER -- Nao depende de nenhuma outra camada, apenas da interface controle.Command, sendo completamente independente dos concrete commands, que torna a extensao da aplicacao (criacao de novos concrete commands) extremamente simples e sem impacto no restante da aplicacao.

public class Controle
{
    private Command[] c = new Command[6];
    private ArrayList<Command> log = new ArrayList<Command>();
    
    public void setCommand(Command c, int i){
        this.c[i] = c;
    }
    
    public void pressionar(int i){
        this.c[i].execute();
        log.add(c[i]);
    }
    
    public void executa(Command c){
        c.execute();
        log.add(c);
        
    }    
    
    public void showLog(){
        for (Command c : log)
            System.out.println(c.toString());
    }    
    
    public void replay(){
        for (Command c : log)
            c.execute();
    }    
    
    
}
