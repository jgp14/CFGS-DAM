package p0_continuaJavaPOO;

public class Frase {

    //Atributo String cadena
    private String cadena;

    //Constructor
    public Frase(String cadena) {
        this.cadena = cadena;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    @Override
    public String toString() {
        return "Frase [cadena=" + cadena + "]";
    }

    public String obtenerFrase() {
        return cadena;
    }

    //Borrar espacios en blanco al principio y fin
    public String eliminaBlancos(String cadena){
        return cadena.trim();
    }

    //Contar las letras
    public Integer contarLetras(String cadena) {
        int nLetras = 0;
        for(int i = 0; i < cadena.length(); i++)
            if(!(cadena.charAt(i) == ' ' || cadena.charAt(i) == ','
            || cadena.charAt(i) == ';' || cadena.charAt(i) == ':'))
                nLetras++;
         return nLetras;
    }

    //Inversion de cadena con StringBuffer
    public StringBuffer invertirFrase(String cadena){
        StringBuffer sb = new StringBuffer();
        sb.append(cadena);
        sb.reverse();
        return sb;
    }

    //Contar palabras con bucle for
    public Integer contarPalabras(String cadena) {
        Integer nPalabras = 0;
        boolean palabra = false;
        for(int i = 0; i < cadena.length(); i++){
            if(Character.isLetter(cadena.charAt(i)))
                palabra = true;
            else if (!Character.isLetter(cadena.charAt(i)) && palabra) {
                nPalabras++;
                palabra = false;            
            } 
        }
        return nPalabras;
    }

    //Separacion de palabras con espacio como separador
    public String[] separarPalabras(String cadena) {
        return cadena.split(" ");
    }

    //Busqueda de primera vocal con un bucle for
    public String primeraVocal(String cadena) {
        Integer primeraVocal = 0;
        cadena = eliminaBlancos(cadena);
        for(int i = 0; i < cadena.length(); i++){
            if((cadena.charAt(i) == 'A') || (cadena.charAt(i) == 'E') 
            || (cadena.charAt(i) == 'I') || (cadena.charAt(i) == 'O') 
            || (cadena.charAt(i) == 'U') 
            || (cadena.charAt(i) == 'a') || (cadena.charAt(i) == 'e') 
            || (cadena.charAt(i) == 'i') || (cadena.charAt(i) == 'o') 
            || (cadena.charAt(i) == 'u')){
                primeraVocal = i; 
                break;
            }
        }
        return primeraVocal.toString();
    }

    //Busqueda de ultima vocal con bucle for
    public String ultimaVocal(String cadena) {
        Integer ultimaVocal = 0;
        for(int i = 0; i < cadena.length(); i++){
            if((cadena.charAt(i) == 'A') || (cadena.charAt(i) == 'E') 
            || (cadena.charAt(i) == 'I') || (cadena.charAt(i) == 'O') 
            || (cadena.charAt(i) == 'U') 
            || (cadena.charAt(i) == 'a') || (cadena.charAt(i) == 'e') 
            || (cadena.charAt(i) == 'i') || (cadena.charAt(i) == 'o') 
            || (cadena.charAt(i) == 'u')){
                ultimaVocal = i; 
            }
        }
        return ultimaVocal.toString();
    }

    //Comprobacion de primera letra mayuscula
    public boolean comprobarMayuscula(String cadena) {
        boolean mayuscula = false;
        cadena = eliminaBlancos(cadena);
        if(Character.isUpperCase(cadena.charAt(0)))
                mayuscula = true;
        return mayuscula;
    }

    //Convertir toda la cadena en mayusculas
    public StringBuffer convertirMayuscula(String cadena) {
        StringBuffer sb = new StringBuffer();
        cadena = cadena.toUpperCase();
        sb.append(cadena);
        return sb;
    }

    //Convertir toda la cadena en minusculas
    public StringBuffer convertirMinuscula(String cadena) {
        StringBuffer sb = new StringBuffer();
        cadena = cadena.toLowerCase();
        sb.append(cadena);
        return sb;
    }

    //Convertir toda la cadena en matriz de caracteres
    public char[] vectorizar(String cadena) {
        return cadena.toCharArray();
    }

}
