package practica3_Eventos;

import java.util.Arrays;

public class Multiplicacion {
    //Creacion de los atributos de clase
    private int nMulti, nSuma1, nSuma2;

    //Constructores sin parametros
    public Multiplicacion(){
        this.nMulti = 0;
        this.nSuma1 = 0;
        this.nSuma2 = 0;
    }

    //Constructores con parametros
    public Multiplicacion(int nMulti, int nSuma1, int nSuma2){
        this.nMulti = nMulti;
        this.nSuma1 = nSuma1;
        this.nSuma2 = nSuma2;
    }

    //Generados getters y setters
    public int getnMulti() {
        return nMulti;
    }

    public void setnMulti(int nMulti) {
        this.nMulti = nMulti;
    }

    public int getnSuma1() {
        return nSuma1;
    }

    public void setnSuma1(int nSuma1) {
        this.nSuma1 = nSuma1;
    }

    public int getnSuma2() {
        return nSuma2;
    }

    public void setnSuma2(int nSuma2) {
        this.nSuma2 = nSuma2;
    }        

    @Override
    public String toString() {
        return "Multiplicacion [nMulti=" + nMulti + 
        ", nSuma1=" + nSuma1 + ", nSuma2=" + nSuma2 + "]";
    }

    //Metodo que devuelve el resultado de multiplicar 
    public int multi(int numero){
        int nResultM = 0;
        nResultM = numero * nMulti;
        return nResultM;
    }

    //Metodo que devuelve resultado de sumar
    public int sumar(){
        int nResultS = 0;
        nResultS = nSuma1 + nSuma2;
        return nResultS;
    }
}