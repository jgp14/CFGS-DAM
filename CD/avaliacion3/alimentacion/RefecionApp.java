package alimentacion;

//import java.awt.List;
//import java.util.ArrayList;
import java.util.Scanner;

public class RefecionApp {
	
	/*Scanner scanner =  new Scanner(System.in);
	int opcion = scanner.nextInt();
	
	private static List<Ingrediente> ingredientes = 
	new ArrayList<Ingrediente>();
	
	private static void verListaIngredientes(String mensaxe){
		System.out.println(mensaxe);
		for (Ingrediente ingrediente: ingredientes)
			System.out.println(ingrediente.toString());
	}
	
	//aplicamos principio de polimorfismo
	//un metodo con diferentes sinaturas
	//a variacion a respeito do anterior consiste
	// en que este non ten argumentos, antes tiña un String
	
	private static void verListIngredientes(){
		
	}
	
	
	private static List<Ingrediente> crearListaIngredientes()	{
		Alimento a1 = new Alimento("Pan", 100, 10, 5, 85);
		Alimento a2 = new Alimento("Patacas", 120, 30, 25, 45);
		Alimento a3 = new Alimento("Sardina", 200, 30, 40, 30);
		Alimento a4 = new Alimento("Maza", 30, 5, 4, 90);
		
		Ingrediente i1 = new Ingrediente(a1, 80);
		Ingrediente i2 = new Ingrediente(a2, 40);
		Ingrediente i3 = new Ingrediente(a3, 250);
		Ingrediente i4 = new Ingrediente(a4, 100);
		
		ingredientes.add(i1);
		ingredientes.add(i2);
		ingredientes.add(i3);
		ingredientes.add(i4);	
	}
	
	private static int solicitarOpcion(){
		System.out.println("Selecciona unha opcion");
		Scanner scanner = new Scanner(System.in);
		int opcion = scanner.nextInt();
		return opcion;
	}
	
	private static void verListadeIngredientes(){
		for(Ingrediente ingrediente: ingredientes)
			System.out.println(ingrediente.getAlimento();
		}
	}
		
	private static int calculaPesoIngredientes(){
		int peso=0;
		for(Ingrediente ingrediente: ingredientes)
			peso += ingrediente.getCantidade();
		return peso;
	}
	
	private static void calcularPorcentaxeIngredientes(){
		double total = calculaPesoIngredientes();
		for(Ingrediente ingrediente : ingredientes){
			double porcentaxe = ingrediente.getCantidade() * 100 / total;
			System.out.println(ingrediente.getAlimento().getNome()+ "->");
		}
	}
	
	private static void calcularCaloriasIngredientes(){
		for(Ingrediente ingrediente : ingredientes){
		
			double caloriasPeso = ingrediente.getAlimento().getCalorias() *
			ingrediente.getCantidade()/100;
			
			System.out.println(ingrediente.getAlimento().getNome() +"-> "
			+"caloriasPeso");
		}
	}

	public static void main(String[] args) {
		ingredientes = crearListaIngredientes();
		int opcion = solicitarOpcion();
		
		switch(opcion){
			case 0:
				System.out.println("Lista de ingredientes";
				verListadeIngredientes();
				break;
			case 1: 
				System.out.println("Peso dos ingredientes da dieta);
				// Completa o seguinte metodo
				int peso = calcularPesoIngredientes();
				System.out.println("Peso total : "+peso +" gramos");
				break;
				
		 	case 2:
		 		// Completa o seguinte metodo
		 		System.out.println("Porcentaxes da composicion")
		 		calcularPorcentaxeIngredientes(); 
		 		break;
		 	case 3: 
		 		System.out.println("Calorias totais da dieta especificada");
		 		
		 		break;
		 	default:
		 		break;
		}
	}*/

	private static final String  OPC = 
			"\nOpcion\r\n\t0. Lista\r\n\t1. "
			+ "Peso\r\n\t2. Porcentaxes\r\n\t3. "
			+ "Calorias\r\n\t4. Sair";
	private static final String  PES = 
			"Peso dos ingredientes da dieta";
	private static final String  POR = 
			"Porcentaxes da composicion";
	private static final String  CAL = 
			"Calorias totais da dieta especificada";
	private static final String FIN = "Fin do aplicativo";
	private static final String ERR = 
			"Opcion erronea, dame outra";
	
	public static void main(String[] args) {
		
		Alimento a1 = new Alimento("Pan", 100, 10, 5, 85);
		Alimento a2 = new Alimento("Patacas", 120, 30, 25, 45);
		Alimento a3 = new Alimento("Sardina", 200, 30, 40, 30);
		Alimento a4 = new Alimento("Maza", 30, 5, 4, 90);
		
		Ingrediente i1 = new Ingrediente(a1, 80);
		Ingrediente i2 = new Ingrediente(a2, 40);
		Ingrediente i3 = new Ingrediente(a3, 250);
		Ingrediente i4 = new Ingrediente(a4, 100);
		Ingrediente[] ingredientes = 
				new Ingrediente[] {i1,i2,i3,i4};
		
		Refecion refecion = new Refecion(ingredientes);
		Scanner scanner = new Scanner(System.in);
		int opcion;
		do {
			System.out.println(OPC);
			opcion = scanner.nextInt();
			switch (opcion) {
			case 0:
				refecion.lista();
				break;
			case 1:
				System.out.println(PES);
				System.out.println(refecion.peso());
				break;
			case 2:
				System.out.println(POR);
				System.out.println(refecion.porcentaxes());
				break;
			case 3:
				System.out.println(CAL);
				System.out.println(refecion.calorias());
				break;
			case 4:
				System.out.println(FIN);
				break;
			default:
				System.out.println(ERR);
				break;
			}
		} while(opcion != 4);
		scanner.close();
	}

}
