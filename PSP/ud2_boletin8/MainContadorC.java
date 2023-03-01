package ud2_boletin8;

class ContadorC{
	int cont=0;
	
	public int getCont() {
		return cont;
	}
	
	public void setCont(int c) {
		cont = c;
	}
}

class ContadorHiloc extends Thread{
	String nombre;
	ContadorC obj;
	
	public ContadorHiloc(String nombre, ContadorC c) {
		this.nombre= nombre;
		obj= c;
	}
	
	public void run() {
		int valor;
		long tiempo;
		synchronized(obj) {
			for(int i=0;i<3;i++) {
				valor = obj.getCont();
				obj.setCont(++valor);
				try {
					tiempo = (int)(Math.random()*1000);
					Thread.sleep(tiempo);
				}catch (InterruptedException e) {
					System.out.println("Interrupcion");
					// TODO: handle exception
				}
				System.out.println
				(nombre+" Valor del recurso compartido: "+ obj.getCont());
			}
		}
		System.out.println("FIN..."+nombre);
	}
}

public class MainContadorC {

	public static void main(String[] args) {
		ContadorC compartido = new ContadorC();
		
		ContadorHiloc dibujo1 = new ContadorHiloc("hilo1", compartido);
		ContadorHiloc dibujo2 = new ContadorHiloc("hilo2", compartido);
		ContadorHiloc dibujo3 = new ContadorHiloc("hilo3", compartido);
		ContadorHiloc dibujo4 = new ContadorHiloc("hilo4", compartido);
		
		dibujo1.start();
		dibujo2.start();
		dibujo3.start();
		dibujo4.start();
		
		try {
			dibujo1.join();
			dibujo2.join();
			dibujo3.join();
			dibujo4.join();
		}catch (InterruptedException e) {
			System.out.println("Interruption");
		}
	}

}
