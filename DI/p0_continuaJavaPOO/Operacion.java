package p0_continuaJavaPOO;

public class Operacion extends NumeroEntero{
    
    //Constructores de clase Operaciones
    public Operacion() {
    }

    public Operacion(int valor) {
        super(valor);
    }
    
    //Metodo sumar 2 enteros
    public int sumarEnteros
    (NumeroEntero nEntero1, NumeroEntero nEntero2){
        int suma = nEntero1.getValor() + nEntero2.getValor();
        return suma;
    }

    //Metodo restar 2 enteros
    public int restarEnteros
    (NumeroEntero nEntero1, NumeroEntero nEntero2){
        int resta = nEntero1.getValor() - nEntero2.getValor();
        return resta;
    }

    //Metodo comparar 2 enteros
    public int compararEnteros
    (NumeroEntero nEntero1, NumeroEntero nEntero2){
        int resutado = -1;
        if((nEntero1.getValor()) == (nEntero2.getValor()))
            resutado = 0;
        else if((nEntero1.getValor()) >= (nEntero2.getValor()))
            resutado = 1;
        return resutado;
    }
    
}
