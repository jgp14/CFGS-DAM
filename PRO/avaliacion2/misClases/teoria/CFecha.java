package misClases.teoria;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CFecha {

	private int dia, mes, anio;

	public CFecha() { // constructor sin argumentos
		asignarFecha();
	} 
	
	public  CFecha(int dd) { // constructor con un argumento
		this(); //invoca al constructor CFecha sin parametros
		dia = dd;
		if(!fechaCorrecta()) {
			System.out.println
			("Fecha incorrecta. Se asigna la actual");
			asignarFecha();
		}
	}
	
	public  CFecha(int dd, int mm) { // constructor con dos argumento
		this();
		dia = dd;
		mes = mm;
		if(!fechaCorrecta()) {
			System.out.println
			("Fecha incorrecta. Se asigna la actual");
			asignarFecha();
		}
	}
	
	public CFecha(int dd, int mm, int aaaa) {
		dia = dd;
		mes = mm;
		anio = aaaa;
		if(!fechaCorrecta()) {
			System.out.println
			("Fecha incorrecta. Se asigna la actual.");
			asignarFecha();
		}
	}
	
	public CFecha(CFecha obj) {
		this.dia = obj.dia;
		this.mes = obj.mes;
		this.anio = obj.anio;	
	}
	
	protected void finalize() throws Throwable { //destructor
		System.out.println("Objeto destruido");
	}
	
	protected boolean bisiesto() {
		// cuerpo del metodo
		return ((anio % 4 == 0) && (anio % 100 != 0) || 
				(anio % 400 == 0));
	}
	
	public void asignarFecha() {
		// Asignar, por omision, la fecha actual.
		GregorianCalendar fechaActual = new GregorianCalendar();
		dia = fechaActual.get(Calendar.DAY_OF_MONTH);
		mes = fechaActual.get(Calendar.MONTH);
		anio = fechaActual.get(Calendar.YEAR);
	}
	
	public void asignarFecha(int dd) {
		asignarFecha();
		dia = dd;
	}
	
	public void asignarFecha(int dd, int mm) {
		asignarFecha();
		dia = dd; mes = mm; 
	}
	
	public void asignarFecha(int dd, int mm, int aaaa) {
		dia = dd; mes = mm; anio = aaaa;
	}
	
	public void obtenerFecha(int[] fecha) {
		fecha[0] = dia;
		fecha[1] = mes;
		fecha[2] = anio;
	}
	
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		// ¿anio correcto?
		anioCorrecto = (anio >= 1582);
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
		case 4: 
		case 6: 
		case 11:
			diaCorrecto = (dia >= 1 && dia <= 30);
			break;
		default: 
			diaCorrecto = (dia >= 1 && dia <= 31);
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}
	
	public CFecha copiar (CFecha obj) { //constuctor copia
		dia = obj.dia;
		mes = obj.mes;
		anio = obj.anio;
		return this;
	}
}
