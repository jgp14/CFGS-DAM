package bancocliente;

import java.util.Scanner;

public class ClienteApp {

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
