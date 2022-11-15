package xestionclientes;

import java.io.Serializable;

/**
 *
 * @author dam205
 */
public class Enderezo implements Serializable{
    private String localidade;
    private String rua;
    private int numero;

    public Enderezo(String localidade, String rua, int numero) {
        this.localidade = localidade;
        this.rua = rua;
        this.numero = numero;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Enderezo{" + "localidade=" + localidade 
                + ", rua=" + rua + ", numero=" + numero + '}';
    }
    
}
