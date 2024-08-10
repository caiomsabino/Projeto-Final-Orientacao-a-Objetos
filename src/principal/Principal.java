package principal;
import javax.swing.JOptionPane;

import cadastros.CadastroAluno;
import cadastros.CadastroProfessor;
import cadastros.CadastroDisciplina;
import cadastros.CadastroTurma;
import exceptions.CampoEmBrancoException;
import exceptions.DisciplinaNaoAtribuidaException;
import exceptions.ProfessorNaoAtribuidoException;
import view.MenuAluno;
import view.MenuPrincipal;
import view.MenuProfessor;
import view.MenuDisciplina;
import view.MenuTurma;

public class Principal {

	//Instância de objetos do tipo Cadastros para utilização a partir de opções escolhidas.

	static CadastroAluno cadAluno;
	static CadastroProfessor cadProfessor;
	static CadastroDisciplina cadDisciplina;
	static CadastroTurma cadTurma;
	public static void main(String[] args) throws CampoEmBrancoException, DisciplinaNaoAtribuidaException, 
	ProfessorNaoAtribuidoException{
		cadAluno = new CadastroAluno();
		cadProfessor = new CadastroProfessor();
		cadDisciplina = new CadastroDisciplina();
		cadTurma = new CadastroTurma();
		
		int opcao = 0; 
		//Opções possíveis de serem escolhidas e exceções que podem ocorrer.
		do {
			opcao = MenuPrincipal.menuOpcoes(); 
			switch (opcao) {
				case 1: 
				try {
					MenuAluno.menuAluno(cadAluno);
				} catch (CampoEmBrancoException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Exceção capturada. Cadastro cancelado, "+
					"tente novamente.");
				}
				break;
				case 2: 
					try {
						MenuProfessor.menuProfessor(cadProfessor);
					} catch (CampoEmBrancoException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Exceção capturada. Cadastro cancelado, "+
						"tente novamente.");
					}
				break;
				case 3: 
					try {
						MenuDisciplina.menuDisciplina(cadDisciplina);
					} catch (CampoEmBrancoException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Exceção capturada. Cadastro cancelado, "+
						"tente novamente.");
					}
				break;
				case 4: 
					try {
						MenuTurma.menuTurma(cadTurma, cadProfessor, cadAluno);
					} catch (CampoEmBrancoException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Exceção capturada. Cadastro cancelado, "+
						"tente novamente.");
					} catch(ProfessorNaoAtribuidoException e){
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Exceção capturada. Cadastro cancelado, "+
						"tente novamente.");
					} catch (DisciplinaNaoAtribuidaException e){
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Exceção capturada. Cadastro cancelado, "+
						"tente novamente.");
					}
				break;
				case 0: 
				break;
				default: 
					JOptionPane.showMessageDialog(null, "Opcao invalida");
					opcao = -1;
				break;
			}
		} while (opcao != 0);
		return;
	}


}
