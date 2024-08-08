package cadastros;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import app.Aluno;

public class CadastroAluno {
    private List<Aluno> alunos;

    public CadastroAluno(){
        alunos = new LinkedList<Aluno>();
    }
    public int cadastrarAluno(Aluno a){
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
}
