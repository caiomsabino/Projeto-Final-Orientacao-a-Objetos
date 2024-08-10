package app;

import java.util.List;

public class Turma {
    private String codigo;
    private Professor professor;
    private List<Aluno> alunos; 
    private Disciplina disciplina;

    public Turma(String codigo, List<Aluno> alunos, Professor professor, Disciplina disciplina) {
        this.codigo = codigo;
        this.professor = professor;
        this.alunos = alunos;
        this.disciplina = disciplina;
    }

    public final String getCodigo() {
        return codigo;
    }

    public final String getProfessor() {
        return professor.getNome();
    }

    public final List<Aluno> getAlunos() {
        return alunos;
    }

    public final String getDisciplina() {
        return disciplina.getNome();
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