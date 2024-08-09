package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import app.Aluno;
import app.Professor;
import app.Turma;
import app.Disciplina;
import cadastros.CadastroTurma;
import cadastros.CadastroProfessor;
import cadastros.CadastroAluno;

public class MenuTurma {

	public static Turma dadosNovaTurma() {
		String codigo = lerCodigo();
        Professor professor = lerProfessor();
        Disciplina disciplina = lerDisciplina();
        List<Aluno> alunos = lerAluno();
		return new Turma(codigo, alunos, professor, disciplina);
	}

	private static String lerCodigo() {
		return JOptionPane.showInputDialog("Informe o codigo da Turma: ");
	}
    private static Disciplina lerDisciplina(){
        return new Disciplina(JOptionPane.showInputDialog("Informe a disciplina associada: "));
    }
    private static Professor lerProfessor(CadastroProfessor cadProf){
        String nome = JOptionPane.showInputDialog("Digite o nome do professor: ");
        String matricula = JOptionPane.showInputDialog("Digite a matricula do professor: ");
        
        Professor professor = cadProf.buscarProfessor(nome, matricula);
        if(professor != null){
            JOptionPane.showMessageDialog(null, "Professor assinalado à turma.");
            return professor;
        }
        else{
            JOptionPane.showMessageDialog(null, "O professor não foi encontrado.");
            return null;
        }
    }
    
    private static List<Aluno> lerAluno(CadastroAluno cadAlun){
        List<Aluno> alunos= new ArrayList<>();
        int continuar = JOptionPane.YES_OPTION;
        while(continuar == JOptionPane.YES_OPTION){
            String nome = JOptionPane.showInputDialog("Digite o nome do aluno: ");
            String matricula = JOptionPane.showInputDialog("Digite a matricula do aluno: ");
            
            Aluno aluno = cadAlun.buscarAluno(nome, matricula);
            if(aluno != null){
                JOptionPane.showMessageDialog(null, "Aluno adicionado à turma.");
            }
            
    }
        
    }

	public static void menuTurma(CadastroTurma cadTurma) {
		String txt = "Informe a opção desejada \n"
				+ "1 - Cadastrar turma\n"
				+ "2 - Pesquisar turma\n"
				+ "3 - Atualizar turma\n"
				+ "4 - Remover turma\n"
                + "5 - Imprimir lista de chamada de uma turma\n"
				+ "0 - Voltar para menu anterior";
		
		int opcao=-1;
		do {
			String strOpcao = JOptionPane.showInputDialog(txt);
			opcao = Integer.parseInt(strOpcao);

			switch (opcao) {
			case 1:
				Disciplina novaDisciplina = dadosNovaDisciplina();
				cadDisciplina.cadastrarDisciplina(novaDisciplina);
				JOptionPane.showMessageDialog(null,"Disciplina cadastrado com sucesso!");
				break;
				
			case 2: 
				String nome = lerNome();
				Disciplina d = cadDisciplina.pesquisarDisciplina(nome);
				if (d != null)
					JOptionPane.showMessageDialog(null, d.toString());
				break;
				
			case 3: 
				nome = lerNome();
				Disciplina novoCadastro = dadosNovaDisciplina();
				boolean atualizado = cadDisciplina.atualizarDisciplina(nome, novoCadastro);
				if (atualizado) {
					JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
				}
				break;
				
			case 4: 
				nome = lerNome();
				Disciplina remover = cadDisciplina.pesquisarDisciplina(nome);
				boolean removido = cadDisciplina.removerDisciplina(remover);
				if (removido) {
					JOptionPane.showMessageDialog(null, "Disciplina removida do cadastro");
					System.gc();
				}

			default:
				break;
			}
		} while (opcao != 0);
		return;
	}


}
