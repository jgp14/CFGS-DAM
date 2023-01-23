package es.leliadoura.ad.ejercicio1bd.operaciones;

/**
 *
 * @author dam205
 */
public class OperacionBDException extends Exception{

    private Integer errorCode;

    public OperacionBDException(){}
    
    public OperacionBDException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
        
    public Integer getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return "OperacionBDException{" + "errorCode=" + errorCode 
                + ", message=" + super.getMessage() + '}';
    }

}
