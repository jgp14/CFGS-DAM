package ud2_boletin7;

public class sincronizada1 extends Thread { 
	objetoComun1 comparti;
	String nom;
	
	//Constructor
	sincronizada1 (String nombre, objetoComun1 compartido) { 
		comparti=compartido;
		nom=nombre;
	}
	
	public void run() {
		comparti.Mostrar(nom);
	}
}
