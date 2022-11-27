package tenda;

public class Artigo {
	
	private int codigoArtigo;
	private String nome;
	private float prezo;
	
	public Artigo
	(int codigoArtigo, String nome, float prezo) {
		super();
		this.codigoArtigo = codigoArtigo;
		this.nome = nome;
		this.prezo = prezo;
	}
	
	public int getCodigoArtigo() {
		return codigoArtigo;
	}

	public void setCodigoArtigo(int codigoArtigo) {
		this.codigoArtigo = codigoArtigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPrezo() {
		return prezo;
	}

	public void setPrezo(float prezo) {
		this.prezo = prezo;
	}

	@Override
	public String toString() {
		return "Artigo [codigoArtigo=" + codigoArtigo + 
				", nome=" + nome + ", prezo=" + prezo + "]";
	}

	
	
}
