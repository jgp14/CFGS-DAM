package pedidos;

import java.io.Serializable;

/**
 *
 * @author dam205
 */
public class Produto implements Serializable{
    private int id;
    private String nomeProduto;
    private String descricion;
    private String foto;
    private float prezo; 

    public Produto(){}
    
    public Produto(int id, String nomeProduto, 
        String descricion, String foto, float prezo) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.descricion = descricion;
        this.foto = foto;
        this.prezo = prezo;
    }

    public int getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getDescricion() {
        return descricion;
    }

    public String getFoto() {
        return foto;
    }

    public float getPrezo() {
        return prezo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setPrezo(float prezo) {
        this.prezo = prezo;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + 
                ", nomeProduto=" + nomeProduto + 
                ", descricion=" + descricion + 
                ", foto=" + foto + ", prezo=" + prezo + '}';
    }
    
}
