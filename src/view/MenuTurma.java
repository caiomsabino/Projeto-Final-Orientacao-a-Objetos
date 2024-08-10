package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import app.Aluno;
import app.Professor;
import app.Turma;
import app.Disciplina;
import cadastros.CadastroTurma;
import exceptions.CampoEmBrancoException;
import cadastros.CadastroProfessor;
import cadastros.CadastroAluno;

public class MenuTurma {

    public static Turma dadosNovaTurma(CadastroProfessor cadProf, CadastroAluno cadAluno) {
        String codigo = lerCodigo();
        Professor professor = lerProfessor(cadProf);
        if (professor == null) {
            JOptionPane.showMessageDialog(null, "Professor não encontrado. Cadastro da turma cancelado.");
            return null;
        }

        Disciplina disciplina = lerDisciplina();
        List<Aluno> alunos = lerAluno(cadAluno);
        if (alunos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado. Cadastro da turma cancelado.");
            return null;
        }

        return new Turma(codigo, alunos, professor, disciplina);
    }

    private static String lerCodigo() {
        return JOptionPane.showInputDialog("Informe o código da Turma: ");
    }

    private static Disciplina lerDisciplina() {
        return new Disciplina(JOptionPane.showInputDialog("Informe a disciplina associada: "));
    }

    private static Professor lerProfessor(CadastroProfessor cadProf) {
        String nome = JOptionPane.showInputDialog("Digite o nome do professor: ");
        String matricula = JOptionPane.showInputDialog("Digite a matrícula do professor: ");
        
        Professor professor = cadProf.buscarProfessor(nome, matricula);
        if (professor != null) {
            JOptionPane.showMessageDialog(null, "Professor associado à turma.");
            return professor;
        } else {
            JOptionPane.showMessageDialog(null, "O professor não foi encontrado.");
            return null;
        }
    }

    private static List<Aluno> lerAluno(CadastroAluno cadAluno) {
        List<Aluno> alunos = new ArrayList<>();
        int continuar = JOptionPane.YES_OPTION;
        while (continuar == JOptionPane.YES_OPTION) {
            String nome = JOptionPane.showInputDialog("Digite o nome do aluno: ");
            String matricula = JOptionPane.showInputDialog("Digite a matrícula do aluno: ");
            
            Aluno aluno = cadAluno.buscarAluno(nome, matricula);
            if (aluno != null) {
                JOptionPane.showMessageDialog(null, "Aluno adicionado à turma.");
                alunos.add(aluno);
            } else {
                JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
            }

            continuar = JOptionPane.showConfirmDialog(null, "Deseja adicionar outro aluno?");
        }
        return alunos;
    }

    public static void menuTurma(CadastroTurma cadTurma, CadastroProfessor cadProfessor, CadastroAluno cadAluno) throws CampoEmBrancoException{
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar turma\n"
                + "2 - Pesquisar turma\n"
                + "3 - Atualizar turma\n"
                + "4 - Remover turma\n"
                + "5 - Imprimir lista de chamada de uma turma\n"
                + "0 - Voltar para menu anterior";
        
        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    Turma novaTurma = dadosNovaTurma(cadProfessor, cadAluno);
                    if (novaTurma != null) {
                        cadTurma.cadastrarTurma(novaTurma);
                        JOptionPane.showMessageDialog(null, "Turma cadastrada com sucesso!");
                    }
                    break;

                case 2: 
                    String codigo = lerCodigo();
                    Turma t = cadTurma.pesquisarTurma(codigo);
                    if (t != null)
                        JOptionPane.showMessageDialog(null, t.toString());
                    break;

                case 3: 
                    codigo = lerCodigo();
                    Turma novaTurmaCadastro = dadosNovaTurma(cadProfessor, cadAluno);
                    boolean atualizado = cadTurma.atualizarTurma(codigo, novaTurmaCadastro);
                    if (atualizado) {
                        JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                    }
                    break;

                case 4: 
                    codigo = lerCodigo();
                    Turma remover = cadTurma.pesquisarTurma(codigo);
                    boolean removido = cadTurma.removerTurma(remover);
                    if (removido) {
                        JOptionPane.showMessageDialog(null, "Turma removida do cadastro.");
                        System.gc();
                    }
                    break;

                case 5:
                    codigo = lerCodigo();
                    Turma turma = cadTurma.pesquisarTurma(codigo);
                    if (turma != null) {
                        JOptionPane.showMessageDialog(null, turma.toStringComAlunos());
                    }
                    break;

                default:
                    break;
            }
        } while (opcao != 0);
    }
}
