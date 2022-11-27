package contabancaria;

public class Conta {

	private int numero;
	private int saldo;
	
	public Conta(int numero, int saldo) {
		super();
		this.numero = numero;
		this.saldo = saldo;
	}
	
	public int ingresar(int ingreso) {
		setSaldo(getSaldo() + ingreso); 
		return saldo; 
	}
	
	public int retirar(int retiro) {
		setSaldo(getSaldo() - retiro);
		return getSaldo();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return 
		"Conta [numero=" + numero + ", saldo=" + saldo + "]";
	}
	
	
}
