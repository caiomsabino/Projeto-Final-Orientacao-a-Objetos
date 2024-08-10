package cadastros;
import java.util.List;


import java.util.LinkedList;
import java.util.Iterator;
import app.Professor;
import exceptions.CampoEmBrancoException;

public class CadastroProfessor {
    private List<Professor> professores;

    public CadastroProfessor(){
        professores = new LinkedList<Professor>();
    }
    public int cadastrarProfessor(Professor p) throws CampoEmBrancoException{
        if(p.getNome() == null || p.getNome().isBlank() || p.getNome().isEmpty()){ //nome está vazio
            throw new CampoEmBrancoException("Nome está vazio.");
        }
        if(p.getCpf() == null || p.getCpf().isBlank() || p.getCpf().isEmpty()){
            throw new CampoEmBrancoException("CPF está vazio");
        }
        if(p.getEmail() == null || p.getEmail().isBlank() || p.getEmail().isEmpty()){
            throw new CampoEmBrancoException("Email está vazio");
        }
        if(p.getMatriculaFUB() == null || p.getMatriculaFUB().isBlank() || p.getMatriculaFUB().isEmpty()){
            throw new CampoEmBrancoException("Matrícula FUB está vazio");
        }
        if(p.getAreaFormacao() == null || p.getAreaFormacao().isBlank() || p.getAreaFormacao().isEmpty()){
            throw new CampoEmBrancoException("Área de formação está vazio");
        }
        boolean cadastrou = professores.add(p);
        if(cadastrou){
            return professores.size();
        }
        return 0;
    }
    public Professor pesquisarProfessor(String matriculaFUBProfessor){
        Iterator<Professor> it = professores.iterator();
        while(it.hasNext()){
            Professor p = it.next();
            if(p.getMatriculaFUB().equalsIgnoreCase(matriculaFUBProfessor))
                return p;
        }
        return null;
    }
    public boolean removerProfessor(Professor p){
        boolean resposta = false;
        if(professores.contains(p))
            resposta = professores.remove(p);
        return resposta;
    }
    public boolean atualizarProfessor(String nome, Professor p){
        Professor remover = pesquisarProfessor(nome);
        professores.remove(remover);
        professores.add(p);
        return true;
    }
    public Professor buscarProfessor(String nome, String matriculaFUB){
        for(Professor professor : professores){
            if(professor.getNome().equals(nome) && professor.getMatriculaFUB().equals(matriculaFUB))
                return professor;
        }
        return null;
    }
}
