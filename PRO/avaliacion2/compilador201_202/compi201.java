package compilador201_202;

import misClases.avaliacion2.CDameDato;

public class compi201 {

	public static void main(String[] args) {
		CDameDato dato = new CDameDato(); 
		System.out.println("CON CODIGO JAVA22");
		int num;
		num = 1;
		while(num != 4) {
			num = dato.dameOpcion();
			switch(num) {
				case 1:
					dato.recollerDatoInt();
					dato.amosarDatoInt();
					break;
				case 2:
					dato.recollerDatoFloat();
					dato.amosarDatoFloat();
					break;
				case 3:
					dato.recollerDatoString();
					dato.amosarDatoString();
					break;
				case 4:
					System.out.println("FINAL");
					break;
				default: 
					System.out.println("OPCION Erronea");
			}
		}
	}
}
