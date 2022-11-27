package alimentacion;

public class Ingrediente {
	
	private int cantidade;
	private Alimento alimento;
	@SuppressWarnings("unused")
	private int calorias;
	
	public Ingrediente
		(Alimento alimento, int cantidade) {
		super();
		this.alimento = alimento;
		this.cantidade = cantidade;
	}
	public Alimento getAlimento() {
		return alimento;
	}
	public int getCantidade() {
		return cantidade;
	}
	@Override
	public String toString() {
		return alimento.toString() 
			+ "\t\t cantidade= " + cantidade;
	}
	
}
