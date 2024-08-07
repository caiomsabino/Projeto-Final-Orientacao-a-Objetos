package app;

public class Disciplina {
    private String nome;

    public final String getNome(){
        return nome;
    }

    public String toString() {
		String resposta = super.toString();
		resposta += "DISCIPLINA: " + nome + '\n';
		return resposta;
	}
}
