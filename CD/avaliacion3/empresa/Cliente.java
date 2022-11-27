package empresa;

public class Cliente {

	private String cif_cliente; 
	private String nomeComercial;
	private String dataAlta;
	private int bonus;
	private int antiguedade;
	
	public Cliente(String cif_cliente, String nomeComercial, 
			String dataAlta, int bonus, int antiguedade) {
		super();
		this.cif_cliente = cif_cliente;
		this.nomeComercial = nomeComercial;
		this.dataAlta = dataAlta;
		this.bonus = bonus;
		this.antiguedade = antiguedade;
	}

	public String getCif_cliente() {
		return cif_cliente;
	}

	public void setCif_cliente(String cif_cliente) {
		this.cif_cliente = cif_cliente;
	}

	public String getNomeComercial() {
		return nomeComercial;
	}

	public void setNomeComercial(String nomeComercial) {
		this.nomeComercial = nomeComercial;
	}
	
	public String getDataAlta() {
		return dataAlta;
	}

	public void setDataAlta(String dataAlta) {
		this.dataAlta = dataAlta;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getAntiguedade() {
		return antiguedade;
	}

	public void setAntiguedade(int antiguedade) {
		this.antiguedade = antiguedade;
	}

	@Override
	public String toString() {
		return "Cliente [cif=" + cif_cliente + ", nomeComercial=" 
	+ nomeComercial + ", dataAlta=" + dataAlta + ", bonus="
				+ bonus + ", antiguedade=" + antiguedade + "]";
	}
	
}
