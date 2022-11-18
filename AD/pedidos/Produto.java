package pedidos;

/**
 *
 * @author dam205
 */
public class Produto {
    private int id;
    private String nomeProduto;
    private String descricion;
    private String foto;
    private int prezo; 

    public Produto(int id, String nomeProduto, 
        String descricion, String foto, int prezo) {
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

    public int getPrezo() {
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

    public void setPrezo(int prezo) {
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
