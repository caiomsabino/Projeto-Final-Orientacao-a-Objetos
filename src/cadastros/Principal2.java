import app.Aluno;
import app.Professor;
import cadastros.Cadastro;

public class Principal2 {
    static Cadastro<Professor> cadProf;
    static Cadastro<Aluno> cadAluno;

    public static void main(String[] args) {
        cadProf = new Cadastro<Professor>();
        cadAluno = new Cadastro<Aluno>();
        

        Aluno a1 = new Aluno("Caio", "0312", "caiomsabino", "2310", "Engenharia");
        cadAluno.cadastrar(a1);
        System.out.println(cadAluno.imprimir());
    }
}
