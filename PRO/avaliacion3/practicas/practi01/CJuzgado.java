package practicas.practi01;

import java.util.ArrayList;
import java.util.Iterator;

public class CJuzgado {

	private ArrayList<CProceso> juzgado;

    public CJuzgado() {
        juzgado = new ArrayList<CProceso>();
    }

    public void llenar() {
    	juzgado.removeAll(juzgado);
    	juzgado.add(new CProceso("P101", "Empresa ARA", 1230.5F));
    	juzgado.add(new CProceso("P102", "Punto limpio", 2245.75F));
    	juzgado.add(new CProceso("P103", "Divorcio Pedro", 538.25F));
    	juzgado.add(new CProceso("P104", "Concesionario", 3429.5F));
    	juzgado.add(new CProceso("P105", "Alquiler piso", 826.25F));
    }

    public void vaciar() {
    	juzgado.removeAll(juzgado);
    }

    private CProceso dameProceso(String ide) {
        Iterator<CProceso> iterator = juzgado.iterator();
        
        while (iterator.hasNext()) {
        	CProceso proceso = iterator.next();
            if (ide.equals(proceso.getIdentificador()))
                return proceso;
        }
        return null;
    }
    
    private CProceso dameProcesoCambiado(CProceso pro) {
    	mostrarCabecera();
    	pro.mostrar();
    	System.out.println("NUEVO identificador: ");
    	pro.setIdentificador(Leer.datoString());
    	System.out.println("NUEVO titulo: ");
    	pro.setTitulo(Leer.datoString());
    	System.out.println("NUEVO arancel: ");
    	pro.setArancel(Leer.datoFloat());
    	return pro;
    }
    
    public void modificarProceso(String ide) {
    	CProceso proceso = dameProceso(ide);
    	int posicion;
    	if(proceso == null) {
    		System.out.println("Proceso no ENCONTRADO");
    	} else {
    		posicion = juzgado.indexOf(proceso);
    		proceso = dameProcesoCambiado(proceso);
    		juzgado.set(posicion, proceso);
    	}
    }
    
    public void insertarProceso() {
    	System.out.print("Identificador: ");
        String identificador = Leer.datoString();
        System.out.print("Titulo: ");
        String titulo = Leer.datoString();
        System.out.print("Arancel: ");
        float arancel = Leer.datoFloat();
    	juzgado.add(new CProceso(identificador, titulo, arancel));
    }

    public void eliminarProceso(String ide) {
        CProceso proceso;

        proceso = dameProceso(ide);
        if (proceso == null)
            System.out.println("Proceso no ENCONTRADO");
        else {
        	juzgado.remove(proceso);
            System.out.println("Proceso ELIMINADO");
        }
    }

    public void mostrar() {
        Iterator<CProceso> iterator = juzgado.iterator();

        if (juzgado.isEmpty())
            System.out.println("Juzgado VACIO");
        else {
            mostrarCabecera();
            while (iterator.hasNext())
                iterator.next().mostrar();
        }
    }

    private void mostrarCabecera() {
        System.out.println("IDENTIFICADOR"+"\tTITULO"+"  \tARANCEL");
        System.out.println("============="+"\t======"+"  \t=======");
    }

    private void menu() {
        System.out.println("\n  M E N U - Practica 1");
        System.out.println("  ======================");
        System.out.println("1.- LLENAR Juzgado");
        System.out.println("2.- VACIAR Juzgado");
        System.out.println("3.- MOSTRAR Juzgado");
        System.out.println("4.- INSERTAR Proceso");
        System.out.println("5.- MODIFICAR Proceso");
        System.out.println("6.- ELIMINAR Proceso");
        System.out.println("7.- FINAL");
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
