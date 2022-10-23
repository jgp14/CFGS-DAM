package serializaproducto;

import java.io.Serializable;

/**
 *
 * @author dam205
 */
public class Produto implements Serializable {
    private Integer idProduto;
    private String descricion;
    private Float prezo;

    public Produto(){}
    
    public Produto
    (Integer idProduto, String descricion, Float prezo) {
        this.idProduto = idProduto;
        this.descricion = descricion;
        this.prezo = prezo;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public String getDescricion() {
        return descricion;
    }

    public Float getPrezo() {
        return prezo;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    public void setPrezo(float prezo) {
        this.prezo = prezo;
    }

    @Override
    public String toString() {
        return "Produto{" + "idProduto=" + idProduto + 
                ", descricion=" + descricion + ", prezo=" + prezo + '}';
    }
    
}
