package misClases.avaliacion3;

import misClases.utilidades.Leer;

public class CTiendaFruta {

	private CFruta[] tiendaFruta = new CFruta[5];
	private int nElementos = 0;
	
	public void llenar() {
		tiendaFruta[0] = 
				new CFruta("F01", "Aguacates", 52, 3.25F);
		tiendaFruta[1] = 
				new CFruta("F02", "Zanahorias", 34, 5.45F);
		tiendaFruta[2] = 
				new CFruta("F03", "Platanos",57,  4.75F);
		tiendaFruta[3] = 
				new CFruta("F04", "Manzanas", 41, 2.85F);
		tiendaFruta[4] = 
				new CFruta("F05", "Mandarinas", 61, 3.55F);
		nElementos = 5;
	}
	
	public void vaciar() {
		tiendaFruta[0] = null;
		tiendaFruta[1] = null;
		tiendaFruta[2] = null;
		tiendaFruta[3] = null;
		tiendaFruta[4] = null;
	}
	
	private int damePosicion(String ide) {
		for(int i = 0; i < nElementos; i++)
			if (ide.equals(tiendaFruta[i].getCodigo()))
				return i; 
		return -1;
	}
	
	
	public void mostrarFruta(String ide) {
		int posicion = damePosicion(ide);
		if(posicion == -1)
			System.out.println("Fruta no ENCONTRADA");
		else {
			mostrarCabecera();
			tiendaFruta[posicion].mostrar();
		}
	}
	
	public void mostrarTienda() {
		if(tiendaFruta[0] == null) {
			mostrarCabecera();
			for(int i = 0; i < nElementos; i++)
				System.out.println(tiendaFruta[i]);
		} else {
			mostrarCabecera();
			for(int i = 0; i < nElementos; i++)
				tiendaFruta[i].mostrar();
		}
	}
	
	private void mostrarCabecera() {
        System.out.println
        ("CODIGO"+"\t\tNOMBRE"+"  \tCANTIDAD"+"\tPRECIO");
        System.out.println
        ("======"+"\t\t======"+"  \t========"+"\t======");
    }
	
	private void menu() {
        System.out.println("\n  M E N U");
        System.out.println("  =======");
        System.out.println("1.- LLENAR tienda");
        System.out.println("2.- VACIAR tienda");
        System.out.println("3.- MOSTRAR tienda");
        System.out.println("4.- MOSTRAR fruta");
        System.out.println("5.- FINAL");
        System.out.print("Pulsa opci�n: ");
    }

    public int dameOpcion() {
        menu();
        int opcion = Leer.datoInt();
        System.out.println();
        return opcion;
    }
	
}
