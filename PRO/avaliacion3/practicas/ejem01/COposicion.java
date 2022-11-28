package practicas.ejem01;

import java.util.ArrayList;
import java.util.Iterator;

public class COposicion {

	private ArrayList<CAspirante> oposicion;

    public COposicion() {
        oposicion = new ArrayList<CAspirante>();
    }

    public void llenar() {
        oposicion.removeAll(oposicion);
        oposicion.add(new CAspirante(100, "Marta Martinez", 35.95F));
        oposicion.add(new CAspirante(200, "Marcos Arias", 45.75F));
        oposicion.add(new CAspirante(300, "Uxia Novoa", 38.25F));
        oposicion.add(new CAspirante(400, "Joan Barcel", 29.85F));
        oposicion.add(new CAspirante(500, "Petra Rainha", 26.15F));
    }

    public void vaciar() {
        oposicion.removeAll(oposicion);
    }

    private CAspirante dameAspirante(int cla) {
        Iterator<CAspirante> iterator = oposicion.iterator();
        CAspirante aspirante;

        while (iterator.hasNext()) {
            aspirante = iterator.next();
            if (aspirante.getClave() == cla)
                return aspirante;
        }
        return null;
    }

    public void eliminarAspirante(int cla) {
        CAspirante aspirante;

        aspirante = dameAspirante(cla);
        if (aspirante == null)
            System.out.println("Aspirante no ENCONTRADO");
        else {
            oposicion.remove(aspirante);
            System.out.println("Aspirante ELIMINADO");
        }
    }

    public void mostrarAspirante(int cla) {
        CAspirante aspirante;

        aspirante = dameAspirante(cla);
        if (aspirante == null)
            System.out.println("Aspirante no ENCONTRADO");
        else {
            mostrarCabecera();
            aspirante.mostrar();
        }
    }


    public void mostrar() {
        Iterator<CAspirante> iterator = oposicion.iterator();

        if (oposicion.isEmpty())
            System.out.println("Oposicion VACIA");
        else {
            mostrarCabecera();
            while (iterator.hasNext())
                iterator.next().mostrar();
        }
    }

    private void mostrarCabecera() {
        System.out.println("CLAVE" + "\tNOMBRE  " + "\tTASAS");
        System.out.println("=====" + "\t======  " + "\t=====");
    }

    private void menu() {
        System.out.println("\n  M E N U - 1");
        System.out.println("  ===========");
        System.out.println("1.- LLENAR Oposicion");
        System.out.println("2.- VACIAR Oposicion");
        System.out.println("3.- MOSTRAR Oposicion");
        System.out.println("4.- MOSTRAR Aspirante");
        System.out.println("5.- ELIMINAR Aspirante");
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
