package cadastros;
import java.util.Iterator;
import java.util.LinkedList;

import app.Turma;

public class CadastroTurma {
    private LinkedList<Turma> turmas;

    public int cadastrarTurma(Turma t){
        boolean cadastrou = turmas.add(t);
        if(cadastrou){
            return turmas.size();
        }
        return 0;
    }
    public Turma pesquisarTurma(String codigo){
        Iterator<Turma> it = turmas.iterator();
        while(it.hasNext()){
            Turma t = it.next();
            if(t.getCodigo().equalsIgnoreCase(codigo))
                return t;
        }
        return null;
    }
    public boolean removerTurma(Turma t){
        boolean resposta = false;
        if(turmas.contains(t))
            resposta = turmas.remove(t);
        return resposta;
    }
    public boolean atualizarTurma(String codigo, Turma t){
        Turma remover = pesquisarTurma(codigo);
        turmas.remove(remover);
        turmas.add(t);
        return true;
    }
}