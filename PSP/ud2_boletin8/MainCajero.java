package ud2_boletin8;

class Cajero{
	int localidades = 0;
	String nombre;
	
	public Cajero(String nombre) {
		
	}
	
	public int sumarLocalidades() {
		return localidades++;
	}
	
	public int mostrarLocalidades() {
		return localidades;
	}
}

class Terminal extends Thread{
	String nombre;
	Cajero obj;
	int loc = 0; //Localidades por Terminal
	
	public Terminal(String nombre, Cajero c) {
		this.nombre= nombre;
		obj=c;
	}
	
	public void run() {
		synchronized(obj) {
			for(int i = 0; i<20000; i++) {
				obj.sumarLocalidades(); //Suma en el total
				loc++; //Suma en el parcial
			}
			System.out.println("Terminal :"+this.nombre+" vendió "+ loc);
		}
	}	
	
}

public class MainCajero {

	public static void main(String[] args) {
		int Total;
		Cajero compartido = new Cajero("Cajero Alameda");
		System.out.println("Cajero Alameda");
		//Creo los 3 hilos que usaran el objeto compartido anterior
		Terminal dibujo1 = new Terminal("terminal 1", compartido);
		Terminal dibujo2 = new Terminal("terminal 2", compartido);
		Terminal dibujo3 = new Terminal("terminal 3", compartido);

		//Lanzo los hilos
		dibujo1.start();
		dibujo2.start();
		dibujo3.start();
		
		try {
			dibujo1.join();
			dibujo2.join();
			dibujo3.join();			
		}catch (InterruptedException e) {
			System.out.println("Interruption");			
		}
		
		Total = compartido.mostrarLocalidades();
		System.out.println("En total se vendieron "+Total+" localidades");
		System.out.println("Fin del programa");
	}

}
