package consumogasolina;

public class Consumos {
	
	@SuppressWarnings("static-access")
	public Consumos(Consumo[] consumos) {
		super();
		this.consumos = consumos;
	}
	
	private static Consumo[] consumos = new Consumo[] { 
			new Consumo(100, 7), new Consumo(200, 11), 
			new Consumo(100, 8), new Consumo(60, 4), 
			new Consumo(400, 8)};
	
	public static int calcularPercorrido(String mensaxe) {

		int distancia = 0;
		System.out.println(mensaxe);
		for (Consumo consumo : consumos) {
			distancia += consumo.getDistancia();
		}
		return distancia;

	}

	public static int calcularConsumoTotal(String mensaxe) {

		int consumoTotal = 0;
		System.out.println(mensaxe);
		for (Consumo consumo : consumos) {
			consumoTotal += consumo.getConsumoLitros();
		}
		return consumoTotal;
	}

	public static double calcularConsumoMedio() {

		double consumoMedio = 0.0;
		for (Consumo consumo : consumos) {
			consumoMedio += consumo.getConsumoLitros();
		}
		return (double) consumoMedio / consumos.length;
	}

	public static double calcularConsumo100Km() {
		double consumoTotal = 0.0;
		int percorridoTotal = 0;
		for (Consumo consumo : consumos) {
			consumoTotal += consumo.getConsumoLitros();
			percorridoTotal += consumo.getDistancia();
		}
		return (double) (consumoTotal * 100.0 / percorridoTotal);

	}
	
	public static double consumoEstimado(int distancia) {
		return (double) distancia * calcularConsumo100Km() / 100.0;
	}
	
	/*private Consumo[] consumos;
	private static final String DIS = "Distancia percorrida: ";
	private static final String LIT = 
			"Combustibel consumido, litros";
	private static final String MENU = 
			"\nIndica unha opcion\n\t1. Consumo medio\n\t2. "
			+ "Consumo porcentual\n\t3. Consumo estimado\n"
			+ "\t4. Sair do aplicativo";
	
	public Consumos(Consumo[] consumos) {
		super();
		this.consumos = consumos;
	}
	
	private int distancia() {
		int distancia = 0; 
		for (Consumo consumo: consumos)
			distancia += consumo.getDistancia();
		System.out.println(DIS+distancia);
		return distancia;
	}

	private int consumoLitros() {
		int consumoTotal= 0; 
		System.out.println(LIT);
		for (Consumo consumo: consumos)
			consumoTotal += consumo.getConsumoLitros();
		return consumoTotal;
	}

	public float consumoMedio() {
		float medio=(float)consumoLitros()/consumos.length;
		return medio;
	}
	
	public float consumoPorcentual() {
		float porcentual = 100*consumoMedio()/distancia();
		return porcentual;
	}
	
	public float consumoEstimado(int d) {
		float estimado = d*consumoMedio()/100;
		return estimado;
	}
	
	public void menu() {
		System.out.println(MENU); 
	}
	
	public int opcion(int op) {
		int opcion = op;
		return opcion;
	}*/
	
}
