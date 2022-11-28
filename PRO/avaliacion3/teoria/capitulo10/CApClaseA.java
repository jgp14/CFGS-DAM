package teoria.capitulo10;

public class CApClaseA {

	public static void main(String[] args) {
		ClaseB objClaseB = new ClaseB();
		objClaseB = null;
		
		/*System.out.println(objClaseB.atributo_x);
		System.out.println(objClaseB.metodo_y());
		System.out.println(objClaseB.metodo_x());*/
		
		// Ejecutar el recolector de basura
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();
		runtime.runFinalization();
	}
}
