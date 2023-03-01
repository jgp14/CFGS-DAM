package ud2_boletin7;

public class sincronizada2 extends Thread { 
	objetoComun1 comparti;
	String nom;
	
	//Constructor
	sincronizada2 (String nombre, objetoComun1 compartido) { 
		comparti=compartido;
		nom=nombre;
	}
	
	public void run() {
		synchronized (comparti) {
			comparti.Mostrar(nom);
		}		
	}
}
