package cadastros;
import java.util.List;



import java.util.LinkedList;
import java.util.Iterator;
import app.Aluno;
import exceptions.CampoEmBrancoException;

public class CadastroAluno {
    private List<Aluno> alunos;

    public CadastroAluno(){
        alunos = new LinkedList<Aluno>();
    }
    public int cadastrarAluno(Aluno a) throws CampoEmBrancoException{
        if(a.getNome() == null || a.getNome().isBlank() || a.getNome().isEmpty()){ //nome está vazio
            throw new CampoEmBrancoException("Nome está vazio.");
        }
        if(a.getCpf() == null || a.getCpf().isBlank() || a.getCpf().isEmpty()){
            throw new CampoEmBrancoException("CPF está vazio");
        }
        if(a.getEmail() == null || a.getEmail().isBlank() || a.getEmail().isEmpty()){
            throw new CampoEmBrancoException("Email está vazio");
        }
        if(a.getMatricula() == null || a.getMatricula().isBlank() || a.getMatricula().isEmpty()){
            throw new CampoEmBrancoException("Matrícula está vazio");
        }
        if(a.getCurso() == null || a.getCurso().isBlank() || a.getCurso().isEmpty()){
            throw new CampoEmBrancoException("Curso está vazio");
        }
        boolean cadastrou = alunos.add(a);
        if(cadastrou){
            return alunos.size();
        }
        return 0;
    }
    public Aluno pesquisarAluno(String matriculaAluno){
        Iterator<Aluno> it = alunos.iterator();
        while(it.hasNext()){
            Aluno a = it.next();
            if(a.getMatricula().equalsIgnoreCase(matriculaAluno))
                return a;
        }
        return null;
    }
    public boolean removerAluno(Aluno a){
        boolean resposta = false;
        if(alunos.contains(a))
            resposta = alunos.remove(a);
        return resposta;
    }
    public boolean atualizarAluno(String nome, Aluno a){
        Aluno remover = pesquisarAluno(nome);
        alunos.remove(remover);
        alunos.add(a);
        return true;
    }
    public Aluno buscarAluno(String nome, String matricula){
        for(Aluno aluno : alunos){
            if(aluno.getNome().equals(nome) && aluno.getMatricula().equals(matricula))
                return aluno;
        }
        return null;
    }
}
