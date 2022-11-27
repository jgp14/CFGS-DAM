package alimentacion;

public class Refecion {

	Ingrediente[] ingredientes;
	private static String  LIS = 
			"Lista de ingredientes da dieta";
	
	public Refecion(Ingrediente[] ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public void lista() {
		System.out.println(LIS);
		for (Ingrediente ingrediente : ingredientes)
			System.out.println(ingrediente.toString());
	}

	public int peso() {
		int masa = 0, peso = 0, cantidade = 0;
		for (Ingrediente ingrediente : ingredientes) {
			cantidade = ingrediente.getCantidade();
			masa = 100 * cantidade;
			peso += masa;
		} return peso;
	}
	
	public String porcentaxes(){
		String porcentaxes = "";
		double total = peso();
		for(Ingrediente ingrediente : ingredientes){
			double porcentaxe = 
					ingrediente.getCantidade() * 100 / total;
			porcentaxes += ingrediente.getAlimento().
					getNome()+ "->"+(int)(porcentaxe*100)+"\n";
		}return porcentaxes;
	}
	
	// Devolve porcentaxe nuticional que non pedia
	/*public String porcentaxes0() {
		float proteinas = 0, proteinasT = 0, 
				lipidos = 0, lipidosT = 0, 
				carbohidratos = 0, carbohidratosT = 0, peso = 0;  
		for (Ingrediente ingrediente : ingredientes) {
			proteinas = ingrediente.getAlimento().getProteinas();
			proteinas = proteinas * ingrediente.getCantidade();
			proteinasT += proteinas;
			lipidos = ingrediente.getAlimento().getLipidos();
			lipidos = lipidos * ingrediente.getCantidade();
			lipidosT += lipidos;
			carbohidratos = 
					ingrediente.getAlimento().getCarbohidratos();
			carbohidratos = 
					carbohidratos * ingrediente.getCantidade();
			carbohidratosT += carbohidratos;
		}
		peso = peso();
		proteinasT = 100*proteinasT/peso;
		lipidosT = 100*lipidosT/peso;
		carbohidratosT = 100*carbohidratosT/peso;
		return (int)proteinasT+" proteinas\n"+
		(int)lipidosT+" lipidos\n"+
		(int)carbohidratosT+" carbohidratos\n";
	}*/
	
	public int calorias() {
		int calorias = 0, caloriasTotal = 0;
		for (Ingrediente ingrediente : ingredientes) {
			calorias = ingrediente.getAlimento().getCalorias();
			calorias = calorias * ingrediente.getCantidade();
			caloriasTotal += calorias;
		} return caloriasTotal;
	}
	
}
