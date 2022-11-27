package restaurante;

import java.util.Date;

public class Empregado extends Persoa{

	private String nss;
	private String dni;
	private double salario;
	private Date dataContra;
	private int bonificacion;
	
	public Empregado(String nome, String enderezo, String nss, String dni, double salario, Date dataContra,
			int bonificacion) {
		super(nome, enderezo);
		this.nss = nss;
		this.dni = dni;
		this.salario = salario;
		this.dataContra = dataContra;
		this.bonificacion = bonificacion;
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Date getDataContra() {
		return dataContra;
	}

	public void setDataContra(Date dataContra) {
		this.dataContra = dataContra;
	}

	public int getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(int bonificacion) {
		this.bonificacion = bonificacion;
	}
	
	
}
