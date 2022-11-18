package cliente;

/**
 *
 * @author user
 */
public class Enderezo {
    private String rua;
    private int numero;
    private int codigoPostal;

    public Enderezo(){}
    
    public Enderezo(String rua, int numero, int codigoPostal) {
        this.rua = rua;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        return "Enderezo{" + "rua=" + rua + 
                ", numero=" + numero + 
                ", codigoPostal=" + codigoPostal + '}';
    }
        
}
