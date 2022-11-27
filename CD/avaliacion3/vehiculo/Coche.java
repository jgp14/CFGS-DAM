package vehiculo;

public class Coche extends Vehiculo{
	
	private int cubicaxe;
	
	public Coche(String tipomotor, int numerorodas, int cubicaxe) {
		super(tipomotor, numerorodas);
		setNumerorodas(4);
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
		return super.toString()+"\n"+"Coche [cubicaxe=" + cubicaxe + "]";
	}

}
