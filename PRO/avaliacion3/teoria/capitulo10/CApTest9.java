package teoria.capitulo10;

public class CApTest9 {

	public static void main(String[] args) {
		
		CCuenta[] cliente = new CCuenta[10];
		
		cliente[0] = new CCuentaAhorro
				("Cliente00Ah", "3000123450", 10000, 1.5,30);
		System.out.println("------------------------------");
		
		cliente[1] = new CCuentaCorriente
			("Cliente01CC", "600123450", 20000, 2.5, 1.0, 6);
		System.out.println("------------------------------");
		cliente[2] = new CCuentaCorrienteConIn
		("Cliente02CConIn", "4000123450", 3000, 3.5, 1.0, 6);
		
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		for(int i = 0; cliente[i] != null; i++) {
			System.out.println();
			System.out.println("   "+cliente[i].obtenerNombre());
			System.out.println("   "+cliente[i].intereses());
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		}

	}
	

}
