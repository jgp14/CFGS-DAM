package transferenciabancaria;

public class Transferencia {

	private static final String OK = "TRANSFERENCIA REALIZADA";
	private static final String NOTOK = "TRANSFERENCIA NON REALIZADA";
	private boolean ok = false; 
    private final Clienta orixe;
    private final Clienta destino;


    public Transferencia(Clienta orixe, Clienta destino ) {
        this.orixe = orixe;
        this.destino = destino;

    }
    
    public boolean transferencia(double cantidade) {
 	// Completa este m�todo para que se poda realizar a transferencia
	// tendo en conta que debe haber fondos suficientes na conta do pagador

    	if(orixe.getSaldo() >= cantidade){
    	 	double temporal = this.orixe.getSaldo() - cantidade;
    	 	this.orixe.setSaldo(temporal);
    	 	this.destino.setSaldo(destino.getSaldo() + cantidade);
    	 	this.ok = true;
		} else {
			this.ok = false;
		}
		return ok; 
    	 
    	
        /*if (orixe.getSaldo() >= cantidade) {
        	int saldoOrixe = (int) (orixe.getSaldo() - cantidade);
        	orixe.setSaldo(saldoOrixe);
        	int saldoDestino = (int) (destino.getSaldo() + cantidade);
        	destino.setSaldo(saldoDestino);
            return true;
        } else {
            return false;
        }*/
    }
    
    public String mensaxeOk() {
    	String ok = OK;
    	if(this.ok == false)
    		ok = NOTOK;
		return ok;
    }
    
    /*public String mensaxeNotOk() {
    	String ok = NOTOK;
    	if(this.ok == true)
    		ok = OK; 
    	return ok;
    }*/
    
    /*public void mostrarTransferencia(boolean resultado, int cantidade) {
    	String op = "Operacion de ";
 	    if(transferencia(cantidade) == resultado)
 			System.out.println(op+cantidade+" � realizase");
 	    else System.out.println(op+cantidade+" � non se realiza");
    }*/
}
