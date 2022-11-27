package empresa;

public class EmpresaApp {

	public static void main(String[] args) {
		
		Empregado[] empregados = {
				new Empregado
				("12345678A","Juan Garcia", 24000, 
						"Direccion"),
				new Empregado
				("22345678B","Jose Fernandez", 14000, 
						"Direccion"),
				new Empregado
				("32345678C","Amancio Ortega", 50000, 
						"Direccion")
		};
		
		Cliente[] clientes = {
				new Cliente
				("12345678AB","Taller S.L.", "2020-01-01", 
						1000, 2),
				new Cliente
				("22345678BC","Conservera S.A.", "2010-01-01", 
						3000, 12),
				new Cliente
				("32345678CD","Transportes S.L.", "2000-01-01", 
						4000, 22)
		};
		
		Director director = new Director
				("32345678C","Amancio Ortega", 50000, 
						"Direccion", "Director", 5000 );
		
		Empresa empresa = new Empresa("12345678A", empregados, 
				clientes, director);
		
		System.out.println(empresa.getEmpregados());
		System.out.println(empresa.getClientes());
		System.out.println("\n"+empresa.getDirector().toString());
		
	}

}
