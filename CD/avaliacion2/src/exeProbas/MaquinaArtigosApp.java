package exeProbas;

public class MaquinaArtigosApp {

	public static void main(String[] args) {
		String[] nome = new String[] {"bollo", "dulce", "refresco", "snack"};
		double[] prezo = new double[] {1.0, 1.0, 1.0, 1.0};
		int[] stock = new int[] {10,10,10,10};
		double importe; 
		double totalCompras = 0.0;
		MaquinaArtigos m = new MaquinaArtigos(nome, prezo, stock, 2);
		//m.introducirDatos();
		do {
			m.setCodigo(); 
			m.mostraAviso();
			m.setCantidad();
			System.out.println();
			m.mostraCantidad();
			importe = m.getImporte();
			m.restoExistencias();
			totalCompras = totalCompras + importe;
			stock[m.getCodigo()] = stock[m.getCodigo()] - m.getCantidad();
		} while (m.continuarCompra());
		System.out.println("Precio total de compras: "+totalCompras+" EUR.");
	}
}
