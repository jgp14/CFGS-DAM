package persoahacienda;

import java.util.Date;

public class Fisica extends Persoa{

	private String sexo;
	private String ocupacion;
	private int ingresos;
	
	public Fisica(String nomeCompleto, Date dataNacimiento, String enderezo, String cPostal, String localidade,
			String provincia, String sexo, String ocupacion, int ingresos) {
		super(nomeCompleto, dataNacimiento, enderezo, cPostal, localidade, provincia);
		this.sexo = sexo;
		this.ocupacion = ocupacion;
		this.ingresos = ingresos;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public int getIngresos() {
		return ingresos;
	}

	public void setIngresos(int ingresos) {
		this.ingresos = ingresos;
	}
	
	
}
