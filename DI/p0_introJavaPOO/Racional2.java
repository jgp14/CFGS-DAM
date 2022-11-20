package p0_introJavaPOO;

public class Racional2 {
    private int numerador;
    private int denominador;
    
    //Constructor sin parametro
    public Racional2() { 
        this.numerador = 1;
        this.denominador = 1;
    }

    //Constructor con parametros
    public Racional2(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
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

    //Getters
    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    //Metodo sumar 2 racionales
    public Racional2 sumarRacionales(Racional2 nR1, Racional2 nR2){
        int numeSuma = nR1.getNumerador()*nR2.getDenominador();
        numeSuma = numeSuma + nR1.getDenominador()*nR2.getNumerador();
        int denoSuma = nR1.getDenominador()*nR2.getDenominador();
        Racional2 suma = new Racional2(numeSuma, denoSuma);
        return suma;
    }

    //Metodo restar 2 racionales
    public Racional2 restarRacionales(Racional2 nR1, Racional2 nR2){
        int numeResta = nR1.getNumerador()*nR2.getDenominador();
        numeResta = numeResta - nR1.getDenominador()*nR2.getNumerador();
        int denoResta = nR1.getDenominador()*nR2.getDenominador();
        Racional2 resta = new Racional2(numeResta, denoResta);
        return resta;
    }

    //Metodo multiplicar 2 racionales
    public Racional2 multiplicarRacionales
    (Racional2 nR1, Racional2 nR2){
        int numeMulti = nR1.getNumerador()*nR2.getNumerador();
        int denoMulti = nR1.getDenominador()*nR2.getDenominador();
        Racional2 multi = new Racional2(numeMulti, denoMulti);
        return multi;
    }

    //Metodo dividir 2 racionales
    public Racional2 dividirRacionales
    (Racional2 nR1, Racional2 nR2){
        int numeDivi = nR1.getNumerador()*nR2.getDenominador();
        int denoDivi = nR1.getDenominador()*nR2.getNumerador();
        Racional2 divi = new Racional2(numeDivi, denoDivi);
        return divi;
    }

    //setters y toString opcionales
    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    @Override
    public String toString() {
        return "Racional [denominador=" + denominador + 
        ", numerador=" + numerador + "]";
    }

}
