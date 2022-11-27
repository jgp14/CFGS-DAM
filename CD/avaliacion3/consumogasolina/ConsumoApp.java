package consumogasolina;

import java.util.Scanner;

public class ConsumoApp {

	public static void main(String[] args) {
		
		int distancia = Consumos.calcularPercorrido
				("Percorrido total");
		System.out.println(distancia);

		int consumoTotal = Consumos.calcularConsumoTotal
				("Combustíbel consumido, litros");
		System.out.println(consumoTotal);

		// Completa o código seguinte para obtermos 
		// os valores indicados en cada opción
		System.out.println
		("Indica unha opción\n\t1. Consumo medio\n\t2. "
				+ "Consumo porcentual\n\t3. Consumo estimado\n");
		@SuppressWarnings("resource")
		int opcion = new Scanner(System.in).nextInt();

		switch (opcion) {
		case 1:
			System.out.println("Consumo medio");
			System.out.println(Consumos.calcularConsumoMedio());
			break;

		case 2:
			System.out.println("Consumo porcentual " 
				+ Consumos.calcularConsumo100Km());
			break;

		case 3:
			System.out.println
			("Consumo estimado, dixite a distancia");
			Scanner scanner = new Scanner(System.in);
			int d = scanner.nextInt();
			System.out.println("Litros = " 
			+ Consumos.consumoEstimado(d));
			break;

		default:
			break;
		}

	}
	
	
	/*private static final String MED = "Consumo medio";
	private static final String POR = "Consumo porcentual";
	private static final String EST = 
		"Consumo estimado, dixite a distancia\nLitros = ";
	private static final String FIN = "Fin do aplicativo";
	private static final String ERR = 
			"Opcion erronea, dame outra";

	
	public static void main(String[] args) {
		Consumo[] consumo = new Consumo[] 
				{new Consumo(100, 7), new Consumo(200, 11), 
				new Consumo(100, 8), new Consumo(60, 4) };
		Consumos consumos = new Consumos(consumo);
		Scanner scanner = new Scanner(System.in);
		int opcion;
		do {
			consumos.menu();
			opcion = scanner.nextInt();
			opcion = consumos.opcion(opcion);
			switch (opcion) {
				case 1:
					System.out.println(MED); 
					System.out.println
					(consumos.consumoMedio());
					break;
				case 2:
					System.out.println(POR);
					System.out.println
					(consumos.consumoPorcentual());
					break;
				case 3:
					System.out.println(EST);
					int d = scanner.nextInt();
					System.out.println
					(consumos.consumoEstimado(d));
					break;	
				case 4: 
					System.out.println(FIN);
					break;	
				default: 
					System.out.println(ERR);
					break;
			}
		}while(opcion != 4);
		scanner.close();
	}*/
}
