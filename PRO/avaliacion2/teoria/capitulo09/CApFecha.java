package teoria.capitulo09;

public class CApFecha {

	public static void main(String[] args) {
		CFecha fecha = new CFecha(); // objeto de tipo CFecha
		CFecha fecha1 = new CFecha(); 
		CFecha fecha2 = new CFecha();
		
		System.out.println("fecha: "+fecha);
		fecha.asignarFecha(10, 1, 2021);
		System.out.println("fecha: "+fecha);
		fecha.asignarFecha(10, 1, 2022);
		System.out.println("fecha: "+fecha1);
		fecha.asignarFecha(10, 1, 2023);
		System.out.println("fecha: "+fecha2);
		//visualizarFecha(fecha);
		//visualizarFecha(fecha1);
		//visualizarFecha(fecha2);

	}
}
