package ud2_boletin6;

public class Carrera extends Thread{

	String nombre; 
	int conta = 0;	
	private boolean parar;
	
	public Carrera(String nombre, int conta) {
		this.nombre = nombre;
		this.conta = conta;
		this.parar = false;	
	}
	
	public void run() {
		while(parar == false) 
			conta++;		
	}
	
	public void parar() {
		parar = true;
	}
}
