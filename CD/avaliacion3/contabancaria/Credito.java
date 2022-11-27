package contabancaria;

public class Credito extends Conta{

	private float xuro;
	private float credito;
	
	public Credito(int numero, int saldo, int xuro) {
		super(numero, saldo);
		this.xuro = xuro;
	}
	
	public float getXuro() {
		return xuro;
	}

	public void setXuro(int xuro) {
		this.xuro = xuro;
	}

	public float emprestar(int presta) {
		setSaldo(getSaldo() + presta);
		credito = presta * (1+getXuro()/100);
		return credito;
	}

	public float getCredito() {
		return credito;
	}

	public void setCredito(float credito) {
		this.credito = credito;
	}

	public void setXuro(float xuro) {
		this.xuro = xuro;
	}

	
	@Override
	public String toString() {
		return super.toString()+"\n"+"Credito [xuro=" + xuro + 
				", credito=" + credito + "]";
	}
	
	
}
