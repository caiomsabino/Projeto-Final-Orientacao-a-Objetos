package Excecoes;

import java.util.LinkedList;
import java.util.List;
import app.PessoaFisica;

public class PessoafExeption {
    List<PessoaFisica> pessoaFisicas;

    public PessoafExeption(){
        pessoaFisicas = new LinkedList<PessoaFisica>();
    }

    public boolean cadastrarPessoaFisica(PessoaFisica p) throws DescricaoEmBrancoException, NomeNaoAtribuidoException, CpfNaoAtribuidoException,
                                                    EmailNaoAtribuidoException{
                                                        
        if (p.getNome() == null || p.getNome().isBlank() || p.getNome().isEmpty()) {  //nome está vazio
            throw new DescricaoEmBrancoException("Campo nome está vazio.");
        }
        
        if (p.getCpf() == null || p.getCpf().isBlank() || p.getCpf().isEmpty()) {  //CPF está vazio
            throw new DescricaoEmBrancoException("Campo CPF está vazio.");
        }
        
        if (p.getEmail() == null || p.getEmail().isBlank() || p.getEmail().isEmpty()) {  //Email está vazio
            throw new DescricaoEmBrancoException("Campo email está vazio.");
        }
        boolean resposta = pessoaFisicas.add(p);
        return resposta;
    }

    public String imprimirCadastro() {
        String resposta = "";
        for(PessoaFisica p : pessoaFisicas) {
            resposta = p + "\n";
        }
        return resposta;
    }
}
