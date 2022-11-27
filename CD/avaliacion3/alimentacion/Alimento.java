package alimentacion;

public class Alimento {
	private String nome;
	private int calorias;
	
	private int proteinas;
	private int lipidos;
	private int carbohidratos;

	public Alimento(String nome, int calorias, 
		int proteinas, int lipidos, int carbohidratos) {
		super();
		this.nome = nome;
		this.calorias = calorias;
		this.proteinas = proteinas;
		this.lipidos = lipidos;
		this.carbohidratos = carbohidratos;
	
	}

	public String getNome() {
		return nome;
	}

	public int getCalorias() {
		return calorias;
	}

	public int getProteinas() {
		return proteinas;
	}

	public int getLipidos() {
		return lipidos;
	}

	public int getCarbohidratos() {
		return carbohidratos;
	}


	@Override
	public String toString() {
		return "Alimento \t" + nome + " \tcalorias=" 
				+ calorias + ", proteinas=" + proteinas 
				+ ", lipidos=" + lipidos
				+ ", carbohidratos=" + carbohidratos;
	}

}