package compilador209_211;

import misClases.avaliacion2.CArrayCadenas;

public class compi211 {

	public static void main(String[] args) {
		CArrayCadenas cadenas = new CArrayCadenas();
		int num;		
		do {
			num = cadenas.dameOpcion();
			switch(num) {
				case 1:
					cadenas.inicializa();
					System.out.println("Array INICIALIZADO");
					break;
				case 2:
					cadenas.amosa();
					break;
				case 3:
					cadenas.ordearAscendente();
					cadenas.amosa();
					break;
				case 4:
					cadenas.ordearDescendente();
					cadenas.amosa();
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
