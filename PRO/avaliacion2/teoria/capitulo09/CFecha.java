package teoria.capitulo09;

public class CFecha {
	
	// Atributos
	private int dia, mes, anho;
	
	// Metodos
	protected boolean bisiesto() {
		// cuerpo del metodo
		return ((anho % 4 == 0) && (anho % 100 != 0) || (anho % 400 == 0));
	}
	
	public void asignarFecha(int dd, int mm, int aaaa) {
		dia = dd; mes = mm; anho = aaaa;
	}
	
	/*public CFecha (int dd, int mm, int aaaa) { // constructor
		dia = dd; mes = mm; anho = aaaa;
		if(!fechaCorrecta()) {
			System.out.println("Fecha incorrecta. Se asigna la actual.");
			asignarFecha();
		}
	}*/
	
	/*public CFecha (int dd, int mm) {
		 constructor con dos argunmentos
		this(dd); 
		mes = mm;
		if(!fechaCorrecta()) {
			System.out.println
			("Fecha incorrecta. Se asigna la actual");
		}
	}*/
	
	public void obtenerFecha(int[] fecha) {
		fecha[0] = dia;
		fecha[1] = mes;
		fecha[2] = anho;
	}
	
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anhoCorrecto;
		// ¿año correcto?
		anhoCorrecto = (anho >= 1582);
		// ¿mes correcto?
		mesCorrecto = (mes >= 1) && (mes <= 12);
		switch (mes){
		// ¿dia correcto?
		case 2:
			if(bisiesto() == true)
				diaCorrecto = (dia >= 1 && dia <= 29);
			else
				diaCorrecto = (dia >= 1 && dia <= 28);
			break;
		case 4: case 6: case 11:
			diaCorrecto = (dia >= 1 && dia <= 30);
			break;
		default: 
			diaCorrecto = (dia >= 1 && dia <= 31);
		}
		return diaCorrecto && mesCorrecto && anhoCorrecto;
	}
}
