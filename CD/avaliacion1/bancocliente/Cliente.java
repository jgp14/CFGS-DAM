package bancocliente;

import java.util.Scanner;

public class Cliente {

	private String nome;
	private String apelidos;
	private String DataNacemento;
	private String localidade; 
	private double SaldoConta;
	private boolean CartonCredito;
	private double CustoCarton;
	private int bonificacion;
	
	
	public Cliente(String nome, String apelidos, String dataNacemento, String localidade, int saldoConta,
			boolean cartonCredito, int custoCarton) {
		super();
		this.nome = nome;
		this.apelidos = apelidos;
		DataNacemento = dataNacemento;
		this.localidade = localidade;
		SaldoConta = saldoConta;
		CartonCredito = cartonCredito;
		CustoCarton = custoCarton;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelidos() {
		return apelidos;
	}

	public void setApelidos(String apelidos) {
		this.apelidos = apelidos;
	}

	public String getDataNacemento() {
		return DataNacemento;
	}

	public void setDataNacemento(String dataNacemento) {
		DataNacemento = dataNacemento;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public double getSaldoConta() {
		return SaldoConta;
	}

	public void setSaldoConta(double saldoConta) {
		SaldoConta = saldoConta;
	}

	public boolean isCartonCredito() {
		return CartonCredito;
	}

	public void setCartonCredito(boolean cartonCredito) {
		CartonCredito = cartonCredito;
	}

	public double getCustoCarton() {
		return CustoCarton;
	}

	public void setCustoCarton(double custoCarton) {
		CustoCarton = custoCarton;
	}
	
	public int getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(int bonificacion) {
		this.bonificacion = bonificacion;
	}

	
	private double gastosCarton() {
		if(isCartonCredito() == true) {
			if(getSaldoConta() >= 20000) {
				setCustoCarton(0);
			}
			else if(getSaldoConta() < 20000) {
				setCustoCarton(20);
			}
		}
		
		if(getCustoCarton() == 20) {
			setSaldoConta(getSaldoConta() - getCustoCarton());
		}
		
		return CustoCarton;
	}
	
	private double gastosConta() {
		if(getSaldoConta() >= 40000) {
			setBonificacion(50);
		}
		
		if(getBonificacion() == 50) {
			setSaldoConta(getSaldoConta() + getBonificacion());
		}
		
		return bonificacion;
	}
	
	public double calcularSaldo() {
		
		gastosCarton();
		
		gastosConta();

		return SaldoConta;
		
	}
	
	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", apelidos=" + apelidos + ", DataNacemento=" + DataNacemento + ", localidade="
				+ localidade + ", SaldoConta=" + SaldoConta + ", CartonCredito=" + CartonCredito + ", CustoCarton="
				+ CustoCarton + ", bonificacion=" + bonificacion + "]";
	}
	
	
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("", "", "", "", 0, false, 0);		
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduza o nome: ");
		cliente.setNome(teclado.next());
		
		System.out.print("Introduza os apelidos: ");
		cliente.setApelidos(teclado.next());
		
		System.out.print("Introduza a data de nacemento: ");
		cliente.setDataNacemento(teclado.next());
		
		System.out.print("Introduza a localidade: ");
		cliente.setLocalidade(teclado.next());
		
		System.out.print("Introduza o saldo da conta: ");
		cliente.setSaldoConta(teclado.nextDouble());
		
		System.out.print("Indique cun false se non tes carton e cun true se o tes: ");
		cliente.setCartonCredito(teclado.nextBoolean());
		
		cliente.calcularSaldo();
		
		System.out.println(cliente.toString());

		teclado.close();
	}
}
