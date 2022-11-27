package misClases.teoria;

import java.io.Serializable;

import misClases.utilidades.CDatos;

public class CPersona implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre; 
	private String direccion;
	private long telefono;
	
	public CPersona() {}
	public CPersona(String nom, String dir, long tel) {
		nombre = nom;
		direccion = dir;
		telefono = tel;
	}
	
	public void asignarNombre(String nom) {
		nombre = nom; 
	}
	
	public String obtenerNombre() {
		return nombre;
	}
	
	public void asignarDireccion(String dir) {
		direccion = dir;
	}
	
	public String obtenerDireccion() {
		return direccion;
	}
	
	public void asignarTelefono(long tel) {
		telefono = tel;
	}
	
	public long obtenerTelefono() {
		return telefono;
	}
	
	public int tamanho() {
		// Longitud en bytes de los atributos 
		// (un Long = 8 bytes) 
		return nombre.length()*2 + direccion.length()*2 + 8;
	}
	
	public void mostrar() {
		System.out.println(nombre);
		System.out.println(direccion);
		System.out.println(telefono);
		System.out.println();		
	}
	
	public void asignarDatos() {
		nombre = CDatos.obtenerNombreCompleto();
		direccion = CDatos.obtenerDireccion();
		telefono = CDatos.obtenerTelefono();
	}

}
