package app;

import java.util.List;

public class Turma {
    private String codigo;
    private Professor professor;
    private List<Aluno> alunos; 
    private Disciplina disciplina;

    public Turma(String codigo, Professor professor, List<Aluno> alunos, Disciplina disciplina) {
        this.codigo = codigo;
        this.professor = professor;
        this.alunos = alunos;
        this.disciplina = disciplina;
    }

    public final String getCodigo() {
        return codigo;
    }

    public final Professor getProfessor() {
        return professor;
    }

    public final List<Aluno> getAlunos() {
        return alunos;
    }

    public final Disciplina getDisciplina() {
        return disciplina;
    }

    protected void finalize() throws Throwable {
        System.out.println("Destruindo objeto: " + this);
    }

    @Override
    public String toString() {
        String resposta = "PROFESSOR: " + professor.getNome() + '\n'; 
        resposta += "DISCIPLINA: " + disciplina.getNome() + '\n'; 
        resposta += "CÓDIGO: " + codigo + '\n';
        return resposta;
    }

    public String toStringComAlunos() {
        String resposta = toString();
        resposta += "ALUNOS:\n";
        for (Aluno aluno : alunos) {
            resposta += aluno.getNome() + ": " + aluno.getMatricula() +'\n';
        }
        return resposta;
    }
}