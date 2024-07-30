package view;

import javax.swing.JOptionPane;

import app.Professor;
import cadastros.CadastroProfessor;

public class MenuProfessor {
    public static Professor dadosNovoProfessor(){
        String nome = lerNome();
        String cpf = lerCpf();
        String email = lerEmail();
        String areaformacao = lerAreaFormacao();
        String matriculaFub = lerMatriculaFub();
        return new Professor(nome, cpf, email, areaformacao, matriculaFub);
    }
    private static String lerNome(){
        return JOptionPane.showInputDialog("Digite o nome do professor: ");
    }
    private static String lerCpf(){
        return JOptionPane.showInputDialog("Digite o CPF do professor: ");
    }
    private static String lerEmail(){
        return JOptionPane.showInputDialog("Digite o email do professor: ");
    }
    private static String lerAreaFormacao(){
        return JOptionPane.showInputDialog("Digite a area de formação do professor: ");
    }
    private static String lerMatriculaFub(){
        return JOptionPane.showInputDialog("Digite a matricula fub do professor: ");
    }
    public static void menuProfessor(CadastroProfessor cadProfessor){
        String txt = "Informe a opção desejada: \n"+
                        "1. Cadastrar professor. \n"+
                        "2. Pesquisar professor\n"+
                        "3. Atualizar professor\n"+
                        "4. Remover professor\n"+
                        "0. Voltar para o menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            // try {
                opcao = Integer.parseInt(strOpcao);
            // } catch (NumberFormatException e) {
            //     JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
            //     continue;
            // }
            switch (opcao) {
                case 1:
                    Professor professor = dadosNovoProfessor();
                    cadProfessor.cadastrarProfessor(professor);
                    break;
                case 2:
                    String matricula = lerMatriculaFub();
                    Professor p = cadProfessor.pesquisaProfessor(matricula);
                    if(p!=null){
                        JOptionPane.showMessageDialog(null, p.toString());
                    }
                    break;
                case 3:
                    matricula = lerMatriculaFub();
                    Professor novo = dadosNovoProfessor();
                    boolean atualizado = cadProfessor.atualizarProfessor(matricula, novo);
                    if(atualizado){
                        JOptionPane.showMessageDialog(null, "Professor atualizado.");
                    }
                    break;
                case 4:
                    matricula = lerMatriculaFub();
                    Professor m = cadProfessor.pesquisaProfessor(matricula);
                    boolean removido = cadProfessor.removerProfessor(m);
                    if(removido){
                        JOptionPane.showMessageDialog(null, "Professor removido.");
                        System.gc();
                    }
                
                default:
                    break;
            }
        } while (opcao != 0);
        return;
    }
    
}
