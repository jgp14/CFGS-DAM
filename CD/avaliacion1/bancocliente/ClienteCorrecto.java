package bancocliente;

public class ClienteCorrecto {

	private String nome;
	private int saldo;
	private boolean tenVisa;
	
	public ClienteCorrecto(String nome, int saldo, boolean tenVisa) {
		super();
		this.nome = nome;
		this.saldo = saldo;
		this.tenVisa = tenVisa;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public boolean isTenVisa() {
		return tenVisa;
	}
	public void setTenVisa(boolean tenVisa) {
		this.tenVisa = tenVisa;
	}
	private int gastoConta() {
		if (this.saldo < 40000) {
			this.saldo = this.saldo - 40;
		}
		return this.saldo;
	}
	
	private int gastoVIsa() {
		if ((this.saldo < 20000) && (this.tenVisa)) {
			this.saldo = this.saldo - 20;
		}
	return this.saldo;
	}
	
	private int calcularGastos() {
		this.saldo = this.gastoConta();
		this.saldo = this.gastoVIsa();
		return this.saldo;
	}
	@Override
	public String toString() {
		return "ClienteCorrecto [nome=" + nome + ", saldo=" + saldo + ", tenVisa=" + tenVisa + "]";
	}
	
}
