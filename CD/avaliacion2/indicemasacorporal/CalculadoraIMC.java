package indicemasacorporal;

public class CalculadoraIMC {

	private double indiceMasaCorporal;
	private Persoa persoa;
	private double peso;
	private static final double MIN_IMC= 20.0;
	private static final double MAX_IMC= 25.0;
	private static final String SOBREPESO = 
			"EXISTE SOBREPESO";
	private static final String PESO_NORMAL = 
			"O PESO ESTÁ DENTRO DOS LÍMITES";
	

	public CalculadoraIMC(Persoa persoa, double peso) {
		super();
		this.persoa = persoa;
		this.peso = peso;
		this.persoa.setPeso(this.peso);
		this.indiceMasaCorporal = 
				this.getIndiceMasaCorporal();
	}

	public double getIndiceMasaCorporal() {
		//cacula o índice de masa corporal 
		//para a persoa que se pasa no construtor
		double altura = persoa.getEstatura();
		this.indiceMasaCorporal = 
				persoa.getPeso() /(altura*altura);
		return this.indiceMasaCorporal;
	}

	public int valorarImc() {
		//se o cociente peso/altura² está dentro 
		//de (20, 25) non hai sobrepeso
		//retorna 0
		//retorna -1 en caso contrario (fora do intervalo)

		//Verifica que o valor de masa corporal está 
		//dentro no rango indicado
		if (getIndiceMasaCorporal() >= MIN_IMC && 
				getIndiceMasaCorporal() <= MAX_IMC )
			return 0;
		else
			return -1;	
	}
	
	public String imprimirAviso() { //private
		if (this.valorarImc()==0)
			return PESO_NORMAL;
		else return SOBREPESO;
	}

	public static void main(String[] args) {
		double peso = 80.0;
		Persoa persoa = new Persoa("Castro", "Carballo", 
				"Antonio", "1234567P", 1.60);
		// Completa o método main para realizar 
		//unha proba simples da clase
		CalculadoraIMC calculadora = 
				new CalculadoraIMC(persoa, peso);
		System.out.println(calculadora.getIndiceMasaCorporal());
		calculadora.valorarImc();
		System.out.println(calculadora.imprimirAviso());
	}
}
