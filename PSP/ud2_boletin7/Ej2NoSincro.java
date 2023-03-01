package ud2_boletin7;

public class Ej2NoSincro extends Thread{
	Listado salida;

	//constructor 
	Ej2NoSincro(Listado sali) {
		salida=sali;
	}

	public void run() { 
		synchronized (salida) {
			salida.Mostrar();
		}		
	}
	
}
