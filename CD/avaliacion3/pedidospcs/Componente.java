package pedidospcs;

public class Componente {

	private String nomeComp;
	private int prezoComp;
	private String marca;
	
	public Componente(String nomeComp, int prezoComp, String marca) {
		super();
		this.nomeComp = nomeComp;
		this.prezoComp = prezoComp;
		this.marca = marca;
	}

	public String getNomeComp() {
		return nomeComp;
	}

	public void setNomeComp(String nomeComp) {
		this.nomeComp = nomeComp;
	}

	public int getPrezoComp() {
		return prezoComp;
	}

	public void setPrezoComp(int prezoComp) {
		this.prezoComp = prezoComp;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
}
