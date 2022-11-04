package cliente;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Cliente{
    private String dni;
    private String nome;
    private String apelidos;
    private List<Enderezo> enderezos;

    public Cliente(){}
    
    public Cliente(String dni, String nome, String apelidos) {
        this.dni = dni;
        this.nome = nome;
        this.apelidos = apelidos;
        this.enderezos = new ArrayList<>();
    }

    public String getDni() {
        return dni;
    }

    public String getNome() {
        return nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public List<Enderezo> getEnderezos() {
        return enderezos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public void setEnderezos(List<Enderezo> enderezos) {
        this.enderezos = enderezos;
    }

    @Override
    public String toString() {
        return "Cliente{" + "dni=" + dni + ", nome=" + nome + 
                ", apelidos=" + apelidos + 
                ", enderezos=" + enderezos + '}';
    }
        
}
