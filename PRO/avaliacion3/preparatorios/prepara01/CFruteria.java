package preparatorios.prepara01;

import java.util.ArrayList;
import java.util.Iterator;

public class CFruteria {
	private ArrayList<CFruta> fruteria;

	public CFruteria() {
		fruteria = new ArrayList<CFruta>();
	}

	public void llenar() {
		fruteria.removeAll(fruteria);
		fruteria.add(new CFruta("F01", "Aguacates", 52, 3.25F));
		fruteria.add(new CFruta("F02", "Zanahorias", 34, 5.45F));
		fruteria.add(new CFruta("F03", "Platanos", 57, 4.75F));
		fruteria.add(new CFruta("F04", "Manzanas", 41, 2.85F));
		fruteria.add(new CFruta("F05", "Mandarinas", 61, 3.55F));
	}

	public void vaciar() {
		fruteria.removeAll(fruteria);
	}

	private CFruta dameFruta(String cod) {
		Iterator<CFruta> iterator = fruteria.iterator();
		CFruta fruta;

		while (iterator.hasNext()) {
			fruta = iterator.next();
			if (cod.equals(fruta.getCodigo()))
				return fruta;
		}
		return null;
	}

	public void eliminarFruta(String codigo) {
		CFruta fruta;

		fruta = dameFruta(codigo);
		if (fruta == null)
			System.out.println("fruta no ENCONTRADA");
		else {
			fruteria.remove(fruta);
			System.out.println("fruta ELIMINADA");

		}
	}

	public void mostrarFruta(String cod) {
		CFruta fruta;

		fruta = dameFruta(cod);
		if (fruta == null)
			System.out.println("fruta no ENCONTRADA");
		else {
			mostrarCabecera();
			fruta.mostrar();
		}
	}

	private void mostrarDato(Iterator<CFruta> iterator) {
		CFruta fruta;
		if (iterator.hasNext()) {
			fruta = iterator.next();
			mostrarDato(iterator);
			fruta.mostrar();
		}

	}

	public void mostrar() {
		Iterator<CFruta> iterator = fruteria.iterator();

		if (fruteria.isEmpty())
			System.out.println("fruteria VACIA");
		else {
			mostrarCabecera();
			mostrarDato(iterator);
//			while (iterator.hasNext())
//				iterator.next().mostrar();
		}
	}

	private void mostrarCabecera() {
		System.out.println
		("CODIGO" + "\tNOMBRE  " + "\tCANTIDAD" + "\tPRECIO");
		System.out.println
		("======" + "\t======  " + "\t========" + "\t======");
	}

	private void menu() {
		System.out.println("\n  M E N U - 1");
		System.out.println("  ===========");
		System.out.println("1.- LLENAR fruteria");
		System.out.println("2.- VACIAR fruteria");
		System.out.println("3.- MOSTRAR fruteria");
		System.out.println("4.- MOSTRAR fruta");
		System.out.println("5.- ELIMINAR fruta");
		System.out.println("6.- FINAL");
		System.out.print("Pulsa opcion: ");
	}

	public int dameOpcion() {
		int opcion;

		menu();
		opcion = Leer.datoInt();
		System.out.println();
		return opcion;
	}
}
