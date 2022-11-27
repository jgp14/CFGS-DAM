package misClases.teoria;

 /*
  * Esta clase implementa uina cuenta bancaria que 
  * simula el comportamiento básico de una cuenta 
  * abierta en una entidad bancaria cualquiera.
  */

public class CCuenta {

	  private double tipoDeInteres;
	  private double saldo; 
	  
	  
	  public void EstablecerTipoDeInteres(double ti) {
		  if ( ti < 0) {
			  System.out.println("El tipo de interés no puede ser negativo");
			  return; // retornar
		  }
		  tipoDeInteres = ti; 
	  }
	  
	  public double SaldoActual() {
		  return saldo;
	  }
	  
	  public void IngresarDinero (double ingreso) {
		  saldo += ingreso;
	  }
	  
	  public void RetirarDinero (double cantidad) {
		  if(saldo - cantidad < 0) {
			System.out.println("No tiene saldo suficiente");
			return; 
		  }
		  // Hay saldo suficiente. Retirar la cantidad. 
		  saldo -= cantidad; 
	  }
	  
	  public void AbonarIntereses() {
		  saldo += saldo * tipoDeInteres /100;
	  }
}
