package compilador203_205;

import misClases.avaliacion2.CVector;

public class compi203 {

	public static void main(String[] args) {
		CVector vector = new CVector();
		int num;		
		do {
			num = vector.dameOpcion();
			switch(num) {
				case 1:
					vector.inicializa();
					System.out.println("\nVector INICIALIZADO");
					break;
				case 2:
					vector.amosa();
					break;
				case 3:
					System.out.println("Opcion NO Implementada");
					break;
				case 4:
					System.out.println("Opcion NO Implementada");
					break;
				case 5:
					System.out.println("FINAL");
					break;
				default: 
					System.out.println("OPCION Erronea");
			}			
		} while(num != 5);		
	}
}
