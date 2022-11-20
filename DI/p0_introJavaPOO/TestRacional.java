package p0_introJavaPOO;

public class TestRacional {
    public static void main(String[] args){
        Racional racional = new Racional();
        System.out.print("Numero racional creado: ");
        System.out.println(racional.visualizarRacional());
        int numerador = 12; 
        int denominador = 4;
        System.out.print("Numero racional asignandole los valores "
        +numerador+" y "+denominador+": ");
        racional.asignarDatos(numerador, denominador);
        System.out.println(racional.visualizarRacional());
    }
}
