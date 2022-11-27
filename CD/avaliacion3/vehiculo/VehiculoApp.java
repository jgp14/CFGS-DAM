package vehiculo;

public class VehiculoApp {

	public static void main(String[] args) {
		
		Vehiculo vehiculo = new Vehiculo("noespecificado", 2);
		System.out.println(vehiculo.toString());
		
		Bicicleta bicicleta = new Bicicleta("manual", 2);
		System.out.println(bicicleta.toString());
		
		Moto moto = new Moto("gasolina dos tiempos", 2, 100);
		System.out.println(moto.toString());
		
		Coche coche = new Coche("diesel cuatro tiempos", 4, 300);
		System.out.println(coche.toString());

	}

}
