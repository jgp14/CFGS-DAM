package bancocliente;

public class ClienteCorrectoApp {

	public static void main (String [] args) {
		
		boolean queroVisa = true;
		ClienteCorrecto cliente = new ClienteCorrecto("Maria", 500, queroVisa);
		System.out.println(cliente.toString());
	}
}
