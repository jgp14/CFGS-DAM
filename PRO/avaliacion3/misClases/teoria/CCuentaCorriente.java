package misClases.teoria;

public class CCuentaCorriente extends CCuenta implements IFecha{

	// Atributos
	private int transacciones;
	private double importePorTrans;
	private int transExentas;
	
	//Metodos
	public CCuentaCorriente() {  // constructor sin parametros 
		System.out.println("--->Constructor CCuentaCorriente "
				+ "SIN parametros de "+ obtenerNombre());
	}
	
	public CCuentaCorriente(String nom, String cue, double sal, 
			double tipo, double imptrans, int transex) {
		super(nom, cue, sal, tipo);
		// invoca al constructor CCuenta
		transacciones = 0;
		asignarImportePorTrans(imptrans);
		asignarTransExentas(transex);
	}
	
	public void mostrar() {
		super.mostrar();
		System.out.print("Importe por transaccion: ");
		System.out.println(importePorTrans);
		System.out.print("Transacciones exentas..: ");
		System.out.print(transExentas);
	}
		 
	public void decrementarTransacciones() {
		transacciones--;
	}
	
	public void asignarImportePorTrans(double imptrans) {
		if(imptrans < 0)
			System.out.println("Error: cantidad negativa");
		importePorTrans = imptrans;
	}
		
	public double obtenerImportePorTrans() {
		return importePorTrans;
	}
	
	public void asignarTransExentas(int transex) {
		if(transex < 0)
			System.out.println("Error: cantidad negativa");
		transExentas = transex;
	}
	
	public int obtenerTransExentas() {
		return transExentas;
	}
	
	public void ingreso(double cantidad) {
		super.ingreso(cantidad);
		transacciones++;
	}
	
	public void reintegro(double cantidad) 
			throws ESaldoInsuficiente{ 
		super.reintegro(cantidad);
		transacciones++;
	}
	
	public void comisiones() throws ESaldoInsuficiente { 
		// Se aplican mensualmente por el 
		// mantenimiento de la cuenta
		if(dia() == 1) {
			int n = transacciones - transExentas;
			if(n > 0) 
				reintegro(n * importePorTrans);
			transacciones = 0;
		}
	}
	
	public double intereses() {
		if(dia() != 1) 
			return 0.0;
		// Acumular los intereses por mes solo 
		// los dias 1 de cada mes
		double interesesProducidos = 0.0;
		//Hasta 3000 euros al 0.5%. 
		// El resto al interes establecido.
		if(estado() <= 3000)
			interesesProducidos = estado() * 0.5 / 1200.0;
		else {
			interesesProducidos = 3000 * 0.5 /1200.0 + 
			(estado() - 3000) * obtenerTipoDeInteres() / 1200.0;
		}
		ingreso(interesesProducidos);
		// Este ingreso no debe incrementar las transacciones
		decrementarTransacciones();

		return interesesProducidos;
	}
	
}
