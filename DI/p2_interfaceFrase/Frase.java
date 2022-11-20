package p2_interfaceFrase;

public class Frase {

    //Atributos 
    private String cadena;
    private StringBuffer sb;

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

    //Borrar espacios en blanco al principio y fin
    public String eliminaBlancos(){
        return this.cadena.trim();
    }

    //Contar las letras
    public Integer contarLetras() {
        int nLetras = 0;
        for(int i = 0; i < cadena.length(); i++)
            if(!(cadena.charAt(i) == ' ' || cadena.charAt(i) == ','
            || cadena.charAt(i) == ';' || cadena.charAt(i) == ':'))
                nLetras++;
         return nLetras;
    }

    //Inversion de cadena con StringBuffer
    public StringBuffer invertirFrase(){
        sb = new StringBuffer();
        sb.append(cadena);
        sb.reverse();
        return sb;
    }

    //Contar palabras con bucle for
    public Integer contarPalabras() {
        Integer nPalabras = 1;
        boolean palabra = false;
        for(int i = 0; i < cadena.length(); i++){
            if(Character.isLetter(cadena.charAt(i)))
                palabra = true;
            else if (!Character.isLetter(cadena.charAt(i)) && palabra) {
                nPalabras++;
                palabra = false;            
            } 
        }
        if(cadena.equals("") || palabra == false)
            nPalabras--;
        return nPalabras;
    }

    /*public int contaPalabras() {
        int nPalabras = 0;
        StringTokenizer stk = new StringTokenizer(frase);
        while(stk.hasMoreTokens()) {
            if(stk.nextToken() != " ")
                numPalabras++;
        }
        return numPalabras;
    }*/

    //Separacion de palabras con espacio como separador
    public String[] separarPalabras() {
        return cadena.split(" ");
    }

    /*public void separarPalabras() {
        String[] fraseChar = new String[contarPalabras()];
        StringTokenizer stk = new StringTokenizer(cadena);
        int i = 0;
        while(stk.hasMoreTokens()) {
            if(stk.nextToken() != " ") {
                fraseChar[i] = stk.nextToken();
                i++;
            }
        }
        System.out.print("\nPalabras[");
        for(int j = 0; j < fraseChar.length; j++)
            System.out.print(fraseChar[j]);
        System.out.print("]");
    }*/

    //Busqueda de primera vocal con un bucle for
    public String primeraVocal() {
        Integer primeraVocal = 0;
        cadena = eliminaBlancos();
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
    public String ultimaVocal() {
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
    public boolean comprobarMayuscula() {
        boolean mayuscula = false;
        cadena = eliminaBlancos();
        if(Character.isUpperCase(cadena.charAt(0)))
                mayuscula = true;
        return mayuscula;
    }

    //Convertir toda la cadena en mayusculas
    public StringBuffer convertirMayuscula() {
        sb = new StringBuffer();   
        return sb.append(cadena.toUpperCase());
    }

    //Convertir toda la cadena en minusculas
    public StringBuffer convertirMinuscula() {
        sb = new StringBuffer();
        return sb.append(cadena.toLowerCase());
    }

    //Convertir toda la cadena en matriz de caracteres
    public char[] vectorizar() {
        return cadena.toCharArray();
    }

}
