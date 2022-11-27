package contabancaria;

public class Aforro extends Conta{
	
	public Aforro(int numero, int saldo) {
		super(numero, saldo);
	}

	@Override
	public String toString() {
		return "Aforro []";
	}
	
}
