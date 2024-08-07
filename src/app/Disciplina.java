package app;

public class Disciplina {
    private String nome;
    public Disciplina(String nome){
        this.nome = nome;
    }
    public final String getNome(){
        return nome;
    }
    protected void finalize() throws Throwable {
		System.out.println("Destruindo objeto: " + this);
	}
    public String toString() {
		String resposta =" ";
		resposta += "DISCIPLINA: " + nome + '\n';
		return resposta;
	}
}
