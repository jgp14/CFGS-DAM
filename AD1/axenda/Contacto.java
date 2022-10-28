package axenda;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Contacto {
    private int id;
    private String nome;
    private String telefono;
    private String rua;
    private int numero;

    public Contacto
    (int id, String nome, String telefono, String rua, int numero) {
        this.id = id;
        this.nome = nome;
        this.telefono = telefono;
        this.rua = rua;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }    
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Contacto{" + "id=" + id + ", nome=" + 
                nome + ", telefono=" + telefono + ", rua=" + 
                rua + ", numero=" + numero + '}';
    }     
    
}
