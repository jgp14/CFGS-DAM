package compilador206_208;

import misClases.avaliacion2.CVectorAleatorio;

public class compi207 {

	public static void main(String[] args) {
		CVectorAleatorio vectoraleatorio = new CVectorAleatorio();
		int num;		
		do {
			num = vectoraleatorio.dameOpcion();
			switch(num) {
				case 1:
					vectoraleatorio.inicializa();
					System.out.println("Vector INICIALIZADO");
					break;
				case 2:
					vectoraleatorio.amosa();
					break;
				case 3:
					vectoraleatorio.ordearAscendente();
					vectoraleatorio.amosa();
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
