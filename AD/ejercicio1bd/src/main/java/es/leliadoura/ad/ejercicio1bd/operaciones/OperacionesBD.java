package es.leliadoura.ad.ejercicio1bd.operaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam205
 */
public class OperacionesBD {
    private Connection conexion = null;
    
    public OperacionesBD(){}
    
    public void abrirConexion() throws OperacionBDException {   
        String url = "jdbc:mysql://192.168.56.101:3306/bdexercicios";
        try {
            if(conexion == null || conexion.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection(url, "aduser", "abc123.");
            }else
                throw new OperacionBDException
                (ErrorBD.ERROR_CLOSE_DESC, ErrorBD.ERROR_CLOSE_CODE);
        } catch (SQLException ex) {
            Integer code = ex.getErrorCode();
            if (ErrorBD.ERROR_DATABASE_CODE.equals(code))                
                throw new OperacionBDException(ErrorBD.ERROR_DATABASE_DESC, code);
            else if (ErrorBD.ERROR_USER_CODE.equals(code))
                throw new OperacionBDException(ErrorBD.ERROR_USER_DESC, code);
            else if (ErrorBD.ERROR_PASSW_CODE.equals(code))
                throw new OperacionBDException(ErrorBD.ERROR_PASSW_DESC, code);
            else             
                throw new OperacionBDException
                (ErrorBD.ERROR_SQL_DESC, ex.getErrorCode());
        } catch (ClassNotFoundException ex) {
            throw new OperacionBDException
            (ErrorBD.ERROR_CLASS_DESC, ErrorBD.ERROR_CLASS_CODE);
        }
    }
    
    public void cerrarConexion() throws OperacionBDException{                   
        try {
            if(conexion != null && !conexion.isClosed())
                conexion.close();
            else
                throw new OperacionBDException
                (ErrorBD.ERROR_CONNECT_DESC, ErrorBD.ERROR_CONNECT_CODE); 
        } catch (SQLException ex) {
            throw new OperacionBDException
            (ErrorBD.ERROR_SQL_DESC, ex.getErrorCode());
        }   
   }
    
    public Integer agregaAlumno(Alumno alumno) throws OperacionBDException{
        Integer resultado = 0; 
        String sql = "INSERT INTO alumno "
                    + "VALUES (?, ?, ?, ?);";
        try {
            if(conexion != null && !conexion.isClosed()){
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setString(1, alumno.getDni());
                ps.setString(2, alumno.getNombre());
                ps.setString(3, alumno.getApellidos());
                ps.setInt(4, alumno.getEdad());            
                resultado = ps.executeUpdate(); 
            }else
                throw new OperacionBDException
                (ErrorBD.ERROR_CONNECT_DESC, ErrorBD.ERROR_CONNECT_CODE);                           
        } catch (SQLException ex) {
            Integer code = ex.getErrorCode();
            if(ErrorBD.ERROR_DUPLICATE_CODE.equals(code))
                throw new OperacionBDException
                (ErrorBD.ERROR_DUPLICATE_DESC, ErrorBD.ERROR_DUPLICATE_CODE);
            else 
                throw new OperacionBDException
                (ErrorBD.ERROR_SQL_DESC, code);
        }
        return resultado;
    }
    
    public Alumno consultaAlumno(String dni) throws OperacionBDException{
        Alumno alumno = new Alumno();
        String sql = "SELECT * FROM alumno WHERE dni LIKE '"+dni+"';";
        List<Alumno> alumnos = getAlumnos(sql);
        if(!alumnos.isEmpty())
            alumno = alumnos.get(0);
        return alumno;
    }
    
    private List<Alumno> getAlumnos(String sql) throws OperacionBDException{
        List<Alumno> listado = new ArrayList<>();
        try {
            if(conexion != null && !conexion.isClosed()){
                Statement stmnt = conexion.createStatement();
                ResultSet rs = stmnt.executeQuery(sql);
                
                while(rs.next()) {
                    Alumno alumno = new Alumno();
                    alumno.setDni(rs.getString("dni"));
                    alumno.setNombre(rs.getString("nome"));
                    alumno.setApellidos(rs.getString("apelidos"));
                    alumno.setEdad(rs.getInt("idade"));
                    listado.add(alumno);
                }
            }else
                throw new OperacionBDException
                (ErrorBD.ERROR_CONNECT_DESC, ErrorBD.ERROR_CONNECT_CODE);            
        } catch (SQLException ex) {
            throw new OperacionBDException
            (ErrorBD.ERROR_SQL_DESC, ex.getErrorCode());
        }
        return listado;
    }
    
    public Integer borraAlumno(String dni) throws OperacionBDException{
        Integer resultado = 0;
        String sql = "DELETE FROM alumno WHERE dni LIKE '"+dni+"';";
        try {
            if(conexion != null && !conexion.isClosed()){
                Statement stmnt = conexion.createStatement();            
                resultado = stmnt.executeUpdate(sql); 
            }else 
                throw new OperacionBDException
                (ErrorBD.ERROR_CONNECT_DESC, ErrorBD.ERROR_CONNECT_CODE);                      
        } catch (SQLException ex) {
            throw new OperacionBDException
            (ErrorBD.ERROR_SQL_DESC, ex.getErrorCode());
        }
        return resultado;
    }
    
    public Integer modificaAlumno(Alumno alumno) throws OperacionBDException{
        Integer resultado = 0; 
        String sql = "UPDATE alumno "
                + "SET nome='"+alumno.getNombre()
                +"', apelidos='"+alumno.getApellidos()
                +"', idade="+alumno.getEdad()
                +" WHERE dni='"+alumno.getDni()+"';";
        try {
            if(conexion != null && !conexion.isClosed()){
                Statement stmnt = conexion.createStatement();
                resultado = stmnt.executeUpdate(sql); 
            }else 
                throw new OperacionBDException
                (ErrorBD.ERROR_CONNECT_DESC, ErrorBD.ERROR_CONNECT_CODE);                    
        } catch (SQLException ex) {
            Integer code = ex.getErrorCode();
            if(ErrorBD.ERROR_SINTAX_CODE.equals(code))
                throw new OperacionBDException
                (ErrorBD.ERROR_SINTAX_DESC, code);
            else
                throw new OperacionBDException
                (ErrorBD.ERROR_SQL_DESC, code);
        }
        return resultado;
    }
    
    public List<Alumno> listadoAlumnos() throws OperacionBDException{
        String sql = "SELECT * FROM alumno";
        List<Alumno> listado = getAlumnos(sql);
        return listado;
    }
    
    public List<Alumno> listadoAlumnos(Alumno alumno) throws OperacionBDException{
        Boolean and = false;
        String sql = "SELECT * FROM alumno WHERE";          
        if(alumno.getNombre()!= null && !alumno.getNombre().isBlank()){                                                             
            sql = sql + " nome LIKE '"+alumno.getNombre()+"'";                  
            and = true;
        }
        if(alumno.getApellidos()!= null && !alumno.getApellidos().isBlank()){
            if(and)
                sql = sql + " AND";
            sql = sql + " apelidos LIKE '"+alumno.getApellidos()+"'";
            and = true;
        }                
        if(alumno.getEdad()!= null && 
                (alumno.getEdad()>0 && alumno.getEdad()<110)){
            if(and)
                sql = sql + " AND";
            sql = sql + " idade="+alumno.getEdad()+"";
        }                
        sql = sql + ";";
        List<Alumno> listado = getAlumnos(sql);
        return listado;
    }
    
}
