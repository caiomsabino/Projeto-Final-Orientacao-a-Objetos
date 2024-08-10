package Excecoes;

import java.util.LinkedList;
import java.util.List;
import app.Aluno;

public class AlunoException {
    List<Aluno> alunos;

    public AlunoException(){
        alunos = new LinkedList<Aluno>();
    }

    public boolean cadastrarAluno(Aluno a) throws DescricaoEmBrancoException, NomeNaoAtribuidoException, CpfNaoAtribuidoException,
                                                    EmailNaoAtribuidoException, MatriculaNaoAtribuidoException, CursoNaoAtribuidoException{
                                                        
        if (a.getNome() == null || a.getNome().isBlank() || a.getNome().isEmpty()) {  //nome está vazio
            throw new DescricaoEmBrancoException("Campo nome está vazio.");
        }
        
        if (a.getCpf() == null || a.getCpf().isBlank() || a.getCpf().isEmpty()) {  //CPF está vazio
            throw new DescricaoEmBrancoException("Campo CPF está vazio.");
        }
        
        if (a.getEmail() == null || a.getEmail().isBlank() || a.getEmail().isEmpty()) {  //Email está vazio
            throw new DescricaoEmBrancoException("Campo email está vazio.");
        }
        
        if (a.getMatricula() == null || a.getMatricula().isBlank() || a.getMatricula().isEmpty()) {   //Matricula vazia
            throw new DescricaoEmBrancoException("Campo matricula está vazio.");
        }

        if(a.getCurso() == null || a.getCurso().isBlank() || a.getCurso().isEmpty()) {             //Curso Vazio
            throw new CursoNaoAtribuidoException("Curso não atribuído.");
        }
        boolean resposta = alunos.add(a);
        return resposta;
    }

    public String imprimirCadastro() {
        String resposta = "";
        for(Aluno a : alunos) {
            resposta = a + "\n";
        }
        return resposta;
    }
}
