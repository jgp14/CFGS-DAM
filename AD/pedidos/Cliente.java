package pedidos;

import java.io.Serializable;

/**
 *
 * @author dam205
 */
public class Cliente implements Serializable{
    private String DNI;
    private String nome;
    private String apelidos;

    public Cliente(String DNI, 
            String nome, String apelidos) {
        this.DNI = DNI;
        this.nome = nome;
        this.apelidos = apelidos;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNome() {
        return nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    @Override
    public String toString() {
        return "Cliente{" + "DNI=" + DNI + ", nome=" + 
                nome + ", apelidos=" + apelidos + '}';
    }
        
}
