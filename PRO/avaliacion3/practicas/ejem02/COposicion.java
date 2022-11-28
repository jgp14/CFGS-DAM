package practicas.ejem02;

public class COposicion {
	
	private CAspirante[] oposicion = new CAspirante[5];
	private int total = 0;

    public void llenar() {
    	oposicion[0] = new CAspirante(100, "Marta Martinez", 35.95F);
    	oposicion[1] = new CAspirante(200, "Marcos Arias", 45.75F);
    	oposicion[2] = new CAspirante(300, "UxNovoa", 38.25F);
    	oposicion[3] = new CAspirante(400, "Joan Barcel", 29.85F);
    	oposicion[4] = new CAspirante(500, "Petra Rai", 26.15F);
    	total = 5;
    }

    public void vaciar() {
    	total = 0;
    }
    
    private int dameIndice(int cla) {
    	for(int i = 0; i < total; i++)
    		if(oposicion[i].getClave() == cla)
    			return i;
    	return -1;
    }
    
    private void elimina(int i) {
    	for(; i < total-1; i++)
    		oposicion[i] = oposicion[i + 1];
    	total--;
    }
    
    public void eliminarAspirante(int cla) {
    	int indice = dameIndice(cla);
    	if(indice == -1)
    		System.out.println("Aspirante no ENCONTRADO");
    	else {
    		elimina(indice);
    		System.out.println("Aspirante ELIMINADO");
    	}
    }

    public void mostrar() {
    	if (total == 0)
    		System.out.println("Oposicion VACIA");
    	else {
    		mostrarCabecera();
    		for (int i = 0; i < total; i++)
    			this.oposicion[i].mostrar(); 
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
