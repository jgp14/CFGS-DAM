package pedidospcs;

public class Dispositivo {

	private String nomeDisp;
	private int prezoDisp;
	
	public Dispositivo(String nomeDisp, int prezoDisp) {
		super();
		this.nomeDisp = nomeDisp;
		this.prezoDisp = prezoDisp;
	}

	public String getNomeDisp() {
		return nomeDisp;
	}

	public void setNomeDisp(String nomeDisp) {
		this.nomeDisp = nomeDisp;
	}

	public int getPrezoDisp() {
		return prezoDisp;
	}

	public void setPrezoDisp(int prezoDisp) {
		this.prezoDisp = prezoDisp;
	}
	
}
