package p2_interfaceTemp;

public class Temperatura {
    
    //Atributos de decimales float
    private float celsius;
    private float farenheit;
    
    //Constructores sin y con parametros
    public Temperatura(){
        this.celsius = 0.0f;
        this.farenheit = 32.0f;
    }

    public Temperatura(float celsius, float farenheit) {
        this.celsius = celsius;
        this.farenheit = farenheit;
    }

    //Getters y Setters
    public float getCelsius() {
        return truncate(celsius);
    }

    public void setCelsius(float celsius) {
        this.celsius = celsius;
    }

    public float getFarenheit() {
        return truncate(farenheit);
    }

    public void setFarenheit(float farenheit) {
        this.farenheit = farenheit;
    }

    //toString
    @Override
    public String toString() {
        return "Temperatura [celsius=" + celsius + 
        ", farenheit=" + farenheit + "]";
    }

    //Metodo para pasar a numero con solo dos decimales
    private float truncate(float f){
        float ex = (float)Math.pow(10, 2);
        float decimal = ((float)(int) (f * ex))/ex;;
        return decimal;
    }

    //Metodo calculador de grados farenheit realista
    public float calcFarenheitFromCelsius(float celsius){  
        setCelsius(celsius);
        setFarenheit(1.8f*getCelsius()+32);
        return truncate(getFarenheit());
    }

    //Metodo calculador de grados celsius realista
    public float calcCelsiusFromFarentheit(float farenheit){
        setFarenheit(farenheit);
        setCelsius((farenheit - 32)/1.8f);
        return truncate(getCelsius());
    }

}
