// package ExcecoesTurma;

// import java.util.LinkedList;
// import java.util.List;

// import Excecoes.DescricaoEmBrancoException;
// import app.Disciplina;
// import app.Professor;
// import app.Turma;

// public class TurmaExeption {
//     List<TurmaExeption> turmas;

//     public TurmaExeption(){
//         turmas = new LinkedList<TurmaExeption>();
//     }

//     public boolean cadastrarTurma(TurmaExeption t) throws DescricaoEmBrancoException, ProfessorNaoAtribuidoException, DisciplinaNaoAtribuidoException
//     {
                                                        
//         if (t.getProfessor() == null || t.getProfessor().isBlank() || t.getProfessor().isEmpty()) {  //nome está vazio
//             throw new DescricaoEmBrancoException("Campo professor está vazio.");
//         }
        
//         if (t.getDisciplina() == null || t.getDisciplina().isBlank() || t.getDisciplina().isEmpty()) {  //CPF está vazio
//             throw new DescricaoEmBrancoException("Campo Disciplina está vazio.");
//         }
//         boolean resposta = turmas.add(t);
//         return resposta;
//     }

//     public String imprimirCadastro() {
//         String resposta = "";
//         for(TurmaExeption t : turmas) {
//             resposta = t + "\n";
//         }
//         return resposta;
//     }
// }