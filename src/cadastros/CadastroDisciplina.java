package cadastros;
import java.util.List;

import java.util.LinkedList;
import java.util.Iterator;
import app.Disciplina;
import exceptions.CampoEmBrancoException;

public class CadastroDisciplina {
    private List<Disciplina> disciplinas;

    public CadastroDisciplina(){
        disciplinas = new LinkedList<Disciplina>();
    }
    public int cadastrarDisciplina(Disciplina d) throws CampoEmBrancoException{
        if(d.getNome()== null|| d.getNome().isBlank()|| d.getNome().isEmpty()){
            throw new CampoEmBrancoException("Nome da disciplina está vazio.");
        }
        boolean cadastrou = disciplinas.add(d);
        if(cadastrou){
            return disciplinas.size();
        }
        return 0;
    }
    public Disciplina pesquisarDisciplina(String nomeDisciplina){
        Iterator<Disciplina> it = disciplinas.iterator();
        while(it.hasNext()){
            Disciplina d = it.next();
            if(d.getNome().equalsIgnoreCase(nomeDisciplina))
                return d;
        }
        return null;
    }
    public boolean removerDisciplina(Disciplina d){
        boolean resposta = false;
        if(disciplinas.contains(d))
            resposta = disciplinas.remove(d);
        return resposta;
    }
    public boolean atualizarDisciplina(String nome, Disciplina d){
        Disciplina remover = pesquisarDisciplina(nome);
        disciplinas.remove(remover);
        disciplinas.add(d);
        return true;
    }
}


