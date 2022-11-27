package misClases.teoria;

public class ESaldoInsuficiente extends Exception {
	
	private static final long serialVersionUID = 1L;
	private CCuenta cuenta;
	private double cantidad;
	
	public ESaldoInsuficiente(CCuenta cuen, double can) {
		cuenta = cuen;
		cantidad = can;
	}
	
	public String mensaje() {
		String mensaje;
		mensaje = " ERROR: La cuenta " + cuenta.obtenerNombre() + 
				" solicito " + cantidad;
		mensaje = mensaje + " y el saldo disponible es " + 
				cuenta.estado() + "\n";
		return mensaje;
	  }
}
