package instituto;

import java.util.Date;

public class Cualificacion {
    private Date data;
    private int avaliacion;
    private int valor;

    private Modulo modulo;

    public Cualificacion(Date data, int avaliacion, int valor, Modulo modulo) {
        this.data = data;
        this.avaliacion = avaliacion;
        this.valor = valor;
        this.modulo = modulo;
    }

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getAvaliacion() {
		return avaliacion;
	}

	public void setAvaliacion(int avaliacion) {
		this.avaliacion = avaliacion;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
    
    

}
