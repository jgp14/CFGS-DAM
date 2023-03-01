package ud2_boletin8;

class ContadorM2 {
	int cont=0;
	
	public int getCont() {
		return cont;
	}
	
	public void setCont(int c) {
		cont = c;
	}
	
	public synchronized void suma() {
		cont = getCont();
		cont++;
		System.out.println(Thread.currentThread());
	}
	
//	public void run() {
//		int valor;
//		long tiempo;
//		synchronized(obj) {
//			for(int i=0;i<3;i++) {
//				valor = obj.getCont();
//				obj.setCont(++valor);
//				try {
//					tiempo = (int)(Math.random()*1000);
//					Thread.sleep(tiempo);
//				}catch (InterruptedException e) {
//					System.out.println("Interrupcion");
//					// TODO: handle exception
//				}
//				System.out.println
//				(nombre+" Valor del recurso compartido: "+ obj.getCont());
//			}
//		}
//		System.out.println("FIN..."+nombre);
//	}
}

class ContadorHiloM2 extends Thread{
	String nombre;
	ContadorM2 obj;
	
	public ContadorHiloM2(String nombre, ContadorM2 c) {
		this.nombre= nombre;
		obj= c;
	}
	
	public void run() {
		int valor;
		long tiempo; 
		synchronized(obj) {
			for(int i = 0; i<3; i++){
				valor = obj.getCont();
			}
		}
		System.out.println("FIN..."+nombre);
	}
}

public class MainContadorM2 {

	public static void main(String[] args) {
		ContadorM2 compartido = new ContadorM2();
		
		ContadorHiloM2  dibujo1 = new ContadorHiloM2("hilo1", compartido);
		ContadorHiloM2  dibujo2 = new ContadorHiloM2("hilo2", compartido);
		ContadorHiloM2  dibujo3 = new ContadorHiloM2("hilo3", compartido);
		ContadorHiloM2  dibujo4 = new ContadorHiloM2("hilo4", compartido);
		
		//Lanzo los hilos
		dibujo1.start();
		dibujo2.start();
		dibujo3.start();
		dibujo4.start();
		
		 try {
			 Thread.sleep(1000);
		 }catch(InterruptedException ex) {
			 System.out.println("Interruption");
		 }
		
	}

}
