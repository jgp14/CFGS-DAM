package vehiculo;

public class Vehiculo {

	private String tipomotor;
	private int numerorodas;
	
	public Vehiculo(String tipomotor, int numerorodas) {
		super();
		this.tipomotor = tipomotor;
		this.numerorodas = numerorodas;
	}

	public String getTipomotor() {
		return tipomotor;
	}

	public void setTipomotor(String tipomotor) {
		this.tipomotor = tipomotor;
	}

	public int getNumerorodas() {
		return numerorodas;
	}

	public void setNumerorodas(int numerorodas) {
		this.numerorodas = numerorodas;
	}

	@Override
	public String toString() {
		return "Vehiculo [tipomotor=" + tipomotor + 
				", numerorodas=" + numerorodas + "]";
	} 
	
	
	
}
