package empresa;

public class Empresa {

	private String cif_empresa;
	private Empregado[] empregados;
	private Cliente[] clientes;
	private Director director;
	
	public Empresa(String cif_empresa, Empregado[] empregados, 
			Cliente[] clientes, Director director) {
			super();
			this.cif_empresa = cif_empresa;
			this.empregados = empregados;
			this.clientes = clientes;
			this.director = director;
		}

	public String getEmpregados() {
		String empString = "";
		for(Empregado empregado: empregados)
			empString = empString + "\n" + empregado.toString();
		return empString;
	}

	public String getClientes() {
		String cliString = "";
		for(Cliente cliente: clientes)
			cliString = cliString + "\n" + cliente.toString();
		return cliString;
	}

	public Director getDirector() {
		return director;
	}

	public String getCif_empresa() {
		return cif_empresa;
	}

	public void setCif_empresa(String cif_empresa) {
		this.cif_empresa = cif_empresa;
	}

	public void setEmpregados(Empregado[] empregados) {
		this.empregados = empregados;
	}

	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}

	public void setDirector(Director director) {
		this.director = director;
	}
	

}
