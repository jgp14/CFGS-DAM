package tendaroupa;

public class Prenda {

	private double prezo;
	@SuppressWarnings("unused")
	private String codigo;
	private int cantidade;
	@SuppressWarnings("unused")
	private String nome;
	
	public Prenda(double prezo, String codigo, 
			int cantidade, String nome) {
		super();
		this.prezo = prezo;
		this.codigo = codigo;
		this.cantidade = cantidade;
		this.nome = nome;
	}

	public double getPrezo() {
		return prezo;
	}

	public int getCantidade() {
		return cantidade;
	}
}
