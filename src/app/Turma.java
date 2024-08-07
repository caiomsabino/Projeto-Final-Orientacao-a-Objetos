package app;

public class Turma {
    private String codigo;
    private Professor professor;
    private Aluno alunos;
    private Disciplina disciplina;

    public Turma(String codigo, Professor professor, Aluno alunos, Disciplina disciplina){
        this.codigo = codigo;
        this.professor = professor;
        this.alunos = alunos;
        this.disciplina = disciplina;
    }

    public final String getCodigo(){
        return codigo;
    }

   public final Professor getProfessor(){
        return professor;
    }

   public final Aluno getAlunos(){
        return alunos;
    }
    public final Disciplina getDisciplina(){
        return disciplina;
    }
    protected void finalize() throws Throwable {
		System.out.println("Destruindo objeto: " + this);
	}
    public String toString() {
		String resposta = super.toString();
		resposta += "PROFESSOR: " + /* */ + '\n';
		resposta += "DISCIPLINA: " + /* */ + '\n';
        resposta += "CÓDIGO: " + /* */ + '\n';
		resposta += "ALUNOS: " + /* */ + '\n';
		return resposta;
	}
}
