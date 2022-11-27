package misClases.teoria;

public class EValorNoValido extends Exception{
	private static final long serialVersionUID = 1L;

	public EValorNoValido() {}
	
	public EValorNoValido(String mensaje) {
		super(mensaje);
	}
}
