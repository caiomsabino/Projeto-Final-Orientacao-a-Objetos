package cadastros;
//classe paramétrica
public class Cadastro <T> {

    T cadastros[];
    int numElementos;

    public Cadastro(){
        cadastros = (T[]) new Object[0];
        numElementos = 0;
    }
    public boolean cadastrar(T t){
        T temp[] = (T[]) new Object[cadastros.length + 1];
        for(int i = 0; i< cadastros.length; i++){
            temp[i] = cadastros[i];
        }
        temp[temp.length-1] = t;
        numElementos++;
        cadastros = temp;
        return true;
    }

    public boolean remover (T t){
        if(t != null)
            return false;
        T[] temp = (T[]) new Object[cadastros.length - 1];
        int j = 0;
        for (int i = 0; i < numElementos; i++) {
            if(cadastros[i] != t){
                temp[j] = cadastros[i];
                j++;
            }
            else{
                cadastros[i] = null;
            }
        }
        cadastros = temp;
        numElementos--;
        return true;
    }
    public String imprimir(){
        String resposta = "";
        for(T t: cadastros){
            resposta += t;
            resposta += "-------\n";
        }
        return resposta;
    }
}
