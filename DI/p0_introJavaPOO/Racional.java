package p0_introJavaPOO;

public class Racional {
    private int numerador;
    private int denominador;
    
    //Constructor sin parametro
    public Racional() { 
        this.numerador = 1;
        this.denominador = 1;
    }

    //Metodo asignarDatos del numerador y denominador
    public void asignarDatos(int numerador, int denominador){
        this.numerador = numerador;
        this.denominador = denominador;
    }

    //Medodo visualizar datos del numero racional como String
    public String visualizarRacional(){
        String racional = numerador + "/" + denominador;
        return racional;
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    @Override
    public String toString() {
        return "Racional{" + "numerador=" + numerador 
                + ", denominador=" + denominador + '}';
    }
    
    

}
