package Excecoes;

import java.util.LinkedList;
import java.util.List;
import app.Professor;

public class ProfessorException {
    List<Professor> professores;

    public ProfessorException(){
        professores = new LinkedList<Professor>();
    }

    public boolean cadastrarAluno(Professor p) throws DescricaoEmBrancoException, NomeNaoAtribuidoException, CpfNaoAtribuidoException,
                                                    EmailNaoAtribuidoException, MatriculaFUbNaoAtribuidoException, AreaFormacaoNaoAtribuidoException{
                                                        
        if (p.getNome() == null || p.getNome().isBlank() || p.getNome().isEmpty()) {  //nome está vazio
            throw new DescricaoEmBrancoException("Campo nome está vazio.");
        }
        
        if (p.getCpf() == null || p.getCpf().isBlank() || p.getCpf().isEmpty()) {  //CPF está vazio
            throw new DescricaoEmBrancoException("Campo CPF está vazio.");
        }
        
        if (p.getEmail() == null || p.getEmail().isBlank() || p.getEmail().isEmpty()) {  //Email está vazio
            throw new DescricaoEmBrancoException("Campo email está vazio.");
        }

        if(p.getAreaFormacao() == null || p.getAreaFormacao().isBlank() || p.getAreaFormacao().isEmpty()) {             //Curso Vazio
            throw new DescricaoEmBrancoException("Area de formação não atribuída.");
        }

        if (p.getMatriculaFUB() == null || p.getMatriculaFUB().isBlank() || p.getMatriculaFUB().isEmpty()) {   //Matricula vazia
            throw new DescricaoEmBrancoException("Campo matriculaFUB está vazio.");
        }

        boolean resposta = professores.add(p);
        return resposta;
    }

    public String imprimirCadastro() {
        String resposta = "";
        for(Professor p : professores) {
            resposta = p + "\n";
        }
        return resposta;
    }
}