package cadastros;
import java.util.Iterator;
import java.util.LinkedList;


import app.Turma;
import exceptions.CampoEmBrancoException;
import exceptions.DisciplinaNaoAtribuidaException;
import exceptions.ProfessorNaoAtribuidoException;

public class CadastroTurma {
    private LinkedList<Turma> turmas;

    public CadastroTurma(){
        turmas = new LinkedList<>();
    }

    public int cadastrarTurma(Turma t) throws CampoEmBrancoException, DisciplinaNaoAtribuidaException, ProfessorNaoAtribuidoException{
        if(t.getCodigo() == null || t.getCodigo().isBlank() || t.getCodigo().isEmpty()){
            throw new CampoEmBrancoException("Código da turma está vazio.");
        }
        if(t.getDisciplina() == null || t.getDisciplina().isBlank() | t.getDisciplina().isEmpty()){
            throw new DisciplinaNaoAtribuidaException("Campo Disciplina está vazio.");
        }
        if(t.getProfessor() == null || t.getProfessor().isBlank() || t.getProfessor().isEmpty()){
            throw new ProfessorNaoAtribuidoException("Campo Professor está vazio.");
        }
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