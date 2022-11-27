package inmobiliaria;

import java.util.Date;

public class Aluguer {

    private Cliente cliente;
    private Propiedade propiedade;
    private Propietario propietario;
    private double importe;
    private Date data;

    public Aluguer(Cliente cliente, Propiedade propiedade, Propietario propietario, double importe, Date data) {
        this.cliente = cliente;
        this.propiedade = propiedade;
        this.propietario = propietario;
        this.importe = importe;
        this.data = data;
    }

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Propiedade getPropiedade() {
		return propiedade;
	}

	public void setPropiedade(Propiedade propiedade) {
		this.propiedade = propiedade;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

    
}
