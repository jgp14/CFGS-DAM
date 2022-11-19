package libros;

import java.io.Serializable;

/**
 *
 * @author dam205
 */
public class Persoa implements Serializable{
    private String nome; 
    private String dni;

    public Persoa(String nome, String dni) {
        this.nome = nome;
        this.dni = dni;
    }

    public String getNome() {
        return nome;
    }

    public String getDni() {
        return dni;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Persoa{" + "nome=" + nome + 
                ", dni=" + dni + '}';
    }
        
}
