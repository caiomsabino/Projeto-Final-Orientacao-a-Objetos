package Excecoes;

import java.util.LinkedList;
import java.util.List;
import app.Disciplina;

public class DisciplinaException {
    List<Disciplina> disciplinas;

    public DisciplinaException(){
        disciplinas = new LinkedList<Disciplina>();
    }

    public boolean cadastrarDisciplina(Disciplina d) throws DescricaoEmBrancoException, NomeNaoAtribuidoException
    {
                                                        
        if (d.getNome() == null || d.getNome().isBlank() || d.getNome().isEmpty()) {  //nome está vazio
            throw new DescricaoEmBrancoException("Campo nome está vazio.");
        }
        
        boolean resposta = disciplinas.add(d);
        return resposta;
    }

    public String imprimirCadastro() {
        String resposta = "";
        for(Disciplina d : disciplinas) {
            resposta = d + "\n";
        }
        return resposta;
    }
}
