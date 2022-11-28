/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploserializacion;

/**
 *
 * @author marco
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Almacen almacen = new Almacen();
//        almacen.guardarAlumnos();
        almacen.leerAlumnos();
//        almacen.guardarModulos();
        almacen.leerModulos();
    }
    
}
