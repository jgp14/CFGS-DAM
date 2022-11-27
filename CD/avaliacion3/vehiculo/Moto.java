package vehiculo;

public class Moto extends Vehiculo{

	private int cubicaxe;
	
	public Moto(String tipomotor, int numerorodas, int cubicaxe) {
		super(tipomotor, numerorodas);
		setNumerorodas(2);
		this.cubicaxe = cubicaxe;
	}

	public int getCubicaxe() {
		return cubicaxe;
	}

	public void setCubicaxe(int cubicaxe) {
		this.cubicaxe = cubicaxe;
	}

	@Override
	public String toString() {
		return super.toString()+"\n"+"Moto [cubicaxe=" + cubicaxe + "]";
	}

}
