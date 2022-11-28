package teoria.capitulo12;

import java.io.Serializable;

public class CPersona implements Serializable{

	// Atributos
	private String nombre; 
	private String direccion;
	private long telefono;
	
	// Metodos
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
	
	public void mostrarPersona() {
		System.out.println(obtenerNombre());
		System.out.println(obtenerDireccion());
		System.out.println(obtenerTelefono());
		System.out.println();		
	}
	
	public int tamano() {
		// Longitud en bytes de los atributos 
		// (un Long = 8 bytes) 
		return nombre.length()*2 + direccion.length()*2 + 8;
	}
}
