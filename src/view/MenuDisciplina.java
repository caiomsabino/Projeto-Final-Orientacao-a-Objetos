package view;

import javax.swing.JOptionPane;

import app.Disciplina;
import cadastros.CadastroDisciplina;

public class MenuDisciplina {

	public static Disciplina dadosNovaDisciplina() {
		String nome = lerNome();
		return new Disciplina(nome);
	}

	private static String lerNome() {
		return JOptionPane.showInputDialog("Informe o nome da Disciplina: ");
	}

	public static void menuDisciplina(CadastroDisciplina cadDisciplina) {
		String txt = "Informe a opção desejada \n"
				+ "1 - Cadastrar disciplina\n"
				+ "2 - Pesquisar disciplina\n"
				+ "3 - Atualizar disciplina\n"
				+ "4 - Remover disciplina\n"
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
