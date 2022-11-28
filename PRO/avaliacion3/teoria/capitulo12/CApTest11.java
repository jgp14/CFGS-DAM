package teoria.capitulo12;

import java.io.IOException;
import java.io.RandomAccessFile;

public class CApTest11 {

	public static void main(String[] args) {
		String nombre, direccion;
		long telefono;
		int tamanhoReg = 75; 
		
		try {
			RandomAccessFile fes = new RandomAccessFile("datosRA.dat", "rw");
			
			fes.seek(0 * tamanhoReg);
			fes.writeUTF("Pilar Martinez Pereira");
			fes.writeUTF("Pilar Martinez Pereira");
			fes.writeUTF("Pilar Martinez Pereira");
			
			fes.seek(1*tamanhoReg);
			nombre = fes.readUTF();
			
			fes.seek(1 * tamanhoReg);
			nombre = fes.readUTF();
			direccion = fes.readUTF();
			telefono = fes.readLong();
			
			System.out.println("Escritos registros");
			
			System.out.println("\11111111111111*************");
			System.out.println(nombre);
			System.out.println(direccion);
			System.out.println(telefono);
			
			System.out.println("\n2222222222222*************");
			System.out.println(nombre);
			System.out.println(direccion);
			System.out.println(telefono);
			
			System.out.println("\33333333333333*************");
			System.out.println(nombre);
			System.out.println(direccion);
			System.out.println(telefono);
			
			System.out.println("Leidos registros");
			
			// Modificar datos (3)
			
			fes.seek(1 * tamanhoReg); // situar el puntero de L/E
			// Leer el nombre la direccion y el telefono del fichero
			nombre = fes.readUTF();
			direccion = fes.readUTF();
			telefono = fes.readLong();
			
			System.out.println("\n2222222222222*************");
			System.out.println(nombre);
			System.out.println(direccion);
			System.out.println(telefono);
			
			fes.seek(1 * tamanhoReg); // situar el puntero de L/E
			// Leer el nombre la direccion y el telefono del fichero
			fes.writeUTF("Aurelio Gonzalez Arias");
			fes.writeUTF("C/ Severina Martinez, 33, atico BB");
			fes.writeLong(642734854);
			
			fes.seek(1 * tamanhoReg);
			nombre = fes.readUTF();
			direccion = fes.readUTF();
			telefono = fes.readLong();
			
			System.out.println("\n2222222222222*************");
			System.out.println(nombre);
			System.out.println(direccion);
			System.out.println(telefono);
			
			System.out.println("Modificado registro");
			
			fes.close();
			
		} catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}

}
