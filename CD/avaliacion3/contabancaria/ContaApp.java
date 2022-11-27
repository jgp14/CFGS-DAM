package contabancaria;

public class ContaApp {

	public static void main(String[] args) {
		
		Conta conta = new Conta(123, 6000);
		System.out.println(conta.toString());
		
		Aforro aforro = new Aforro(123, 6000);
		System.out.println(aforro.toString());
		int retiro = 2000;
		aforro.retirar(retiro);
		System.out.println("Aforro "+ aforro.toString());

		Credito credito = new Credito(123, 6000, 15);
		System.out.println("Credito "+credito.toString());
		int presta = 5000;
		credito.emprestar(presta);
		System.out.println("Credito "+credito.toString());
	}

}
