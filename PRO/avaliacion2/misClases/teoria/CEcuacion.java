package misClases.teoria;

public class CEcuacion {

	private double a, b, c, d;
	
	public void recogeDatos() {
		System.out.print("Coeficiente a: ");
		this.a = Leer.datoDouble();
		System.out.print("Coeficiente b: ");
		this.b = Leer.datoDouble();
		System.out.print("Coeficiente c: ");
		this.c = Leer.datoDouble();
	}
	
	public boolean raicesComplejas() {
		boolean complejas = false;
		this.d = (this.b*this.b - 4.0D*this.a*this.c);
		if(this.d < 0.0D)
			complejas = true;
		return complejas;
	}
	
	public void muestraResultado() {
		System.out.print("Las raices ");
		if(raicesComplejas()) 
			System.out.print("son complejas");
		else {
			System.out.print("reales son: ");
			double raiz = Math.sqrt(this.d);
			double x1 = (-this.b + raiz)/(2.0D*this.a);
			double x2 = (-this.b - raiz)/(2.0D*this.a);
			System.out.println("x1 = "+x1+", x2 = "+x2);
		}
	}
}
