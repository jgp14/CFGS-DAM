package es.leliadoura.ad.ejercicio1bd.operaciones;

/**
 *
 * @author dam205
 */
public class ErrorBD {    
    //Excepciones al abrir y cerrar la conexion
    public static final Integer ERROR_CONNECT_CODE = 1;
    public static final String ERROR_CONNECT_DESC = 
            "Conexion no esta abierta o es nula. Creala y abrela.";
    public static final Integer ERROR_CLOSE_CODE = 2;
    public static final String ERROR_CLOSE_DESC = 
            "Conexion esta abierta, no esta cerrada. Revisa y cierrala.";
    public static final Integer ERROR_CLASS_CODE = 3;
    public static final String ERROR_CLASS_DESC = 
            "ClassNotFoundException. Revisa y escribe bien el Driver."; 
    //Excepciones generadas por SQLExcaption
    public static final Integer ERROR_SQL_CODE = 4;
    public static final String ERROR_SQL_DESC = 
            "SQLException al intentar realizar operacion. Revisa y reintentalo";
    public static final Integer ERROR_PASSW_CODE = 1045;
    public static final String ERROR_PASSW_DESC = 
            "Contraseña incorrecta. Introducela correctamente";
    public static final Integer ERROR_DATABASE_CODE = 1049;
    public static final String ERROR_DATABASE_DESC = 
            "Base de datos no encontrada. Creala o pon una existente.";
    public static final Integer ERROR_DUPLICATE_CODE = 1062;
    public static final String ERROR_DUPLICATE_DESC = 
            "Entrada y clave duplicada. Pon otra clave primaria.";
    public static final Integer ERROR_SINTAX_CODE = 1064;
    public static final String ERROR_SINTAX_DESC = 
            "Sintaxis no entendible. Revisa la sentencia";            
    public static final Integer ERROR_USER_CODE = 1698;
    public static final String ERROR_USER_DESC = 
            "Usuario incorrecto. Introducelo correctamente.";
}
