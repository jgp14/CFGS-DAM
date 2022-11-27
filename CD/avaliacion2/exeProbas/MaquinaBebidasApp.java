package exeProbas;

import java.io.PrintStream;

public class MaquinaBebidasApp {

	public static void main(String[] args) {
		String[] producto = new String[] {"Agua", "Bollo", "Refresco", "Snack"};
		int[] stock = new int[] {10,10,10,10};
		double[] importe = new double[] {2.0, 2.0, 2.0, 2.0};
		double cambio; 
		double importesCobrados = 0.0;
		PrintStream flujoS = System.out;
		MaquinaBebidas m = new MaquinaBebidas(producto, stock, importe, 0);
		//m.introducirDatos();
	    do {
			m.menu();
			m.setCodigo();	
			m.mostraAviso();
			m.restoExistencias();
			importesCobrados = importesCobrados + m.getPrezo();
			stock[m.getCodigo()]--;
		} while (m.continuarCompra());
	    flujoS.println
		("\nImportes combrados totales en las compras: "+importesCobrados+"€.");
		m.setPago(); 
		cambio = m.getPago() - importesCobrados;
		flujoS.println("Cambio devolto: "+cambio+"€.");
		flujoS.println("Stock total restante:");
		flujoS.println("=====================");
		for(int i = 0; i < stock.length; i++) {
			flujoS.print(producto[i]+": ");
			if(stock[i] > 0) System.out.print(stock[i]+" unidades\n");
			else flujoS.print(0+" unidades\n");
		}
	}
}
