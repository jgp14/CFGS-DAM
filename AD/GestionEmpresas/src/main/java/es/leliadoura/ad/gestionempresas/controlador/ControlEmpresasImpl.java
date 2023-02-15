/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.leliadoura.ad.gestionempresas.controlador;

import es.leliadoura.ad.gestionempresas.errores.ControlEmpresasException;
import es.leliadoura.ad.gestionempresas.modelo.PersistenciaDatosImpl;
import es.leliadoura.ad.gestionempresas.modelo.entity.Contrato;
import es.leliadoura.ad.gestionempresas.modelo.entity.Empresa;
import es.leliadoura.ad.gestionempresas.modelo.entity.Trabajador;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dam205
 */
public class ControlEmpresasImpl implements ControlEmpresas {

    @Override
    public void guardaEmpresa(Empresa empresa) throws ControlEmpresasException {
        PersistenciaDatosImpl pd = new PersistenciaDatosImpl();
        Empresa empresaConsultada;
        if(empresa != null && !empresa.isEmpty()){
            empresaConsultada = pd.consultaEmpresa(empresa.getNIF());
            if(empresaConsultada == null)
                pd.guardaEmpresa(empresa);
            else
                throw new ControlEmpresasException
                    ("Error: La empresa ya existe en la BBDD");
        }else
            throw new ControlEmpresasException("La empresa es nula");    
    }

    @Override
    public void guardaActualizaEmpresa(Empresa empresa) {
        PersistenciaDatosImpl pd = new PersistenciaDatosImpl();
        Empresa empresaConsultada;
        if(empresa != null && !empresa.isEmpty()){
            empresaConsultada = pd.consultaEmpresa(empresa.getNIF());
            if(empresaConsultada == null)
                pd.guardaEmpresa(empresa);
            else
                pd.modificarEmpresa(empresa);
        }      
    }

    @Override
    public void crearContrato(String NIF, String DNI, Date fecInicial, 
            BigDecimal salario, Integer horas) throws ControlEmpresasException { 
        PersistenciaDatosImpl pd = new PersistenciaDatosImpl();        
        if(NIF != null && !NIF.isEmpty() && !NIF.isBlank() 
                && DNI != null && !DNI.isEmpty() && !DNI.isBlank()
                && fecInicial != null && salario != null && horas != null){
            Empresa empresa = pd.consultaEmpresa(NIF);
            Trabajador trabajador = pd.consultaTrabajador(DNI);                    
            Contrato contratoConsultado = pd.recuperaContrato(DNI, NIF, fecInicial);
            if(contratoConsultado != null){
                Contrato contrato = new Contrato(trabajador, empresa, 
                        fecInicial, null, salario.doubleValue(), horas);
                pd.guardarContrato(contrato);
            }else
                throw new ControlEmpresasException
                ("Error: El contrato ya existe en BD");            
        } else
            throw new ControlEmpresasException
            ("Error aglun ddato de atributo es nulo.");            
    }

    @Override
    public Contrato consultaContratoActual(String DNI, String NIF) {
        Contrato contrato = new Contrato();       
        if(DNI != null && !DNI.isEmpty() && !DNI.isBlank() 
            && NIF != null && !NIF.isEmpty() && !NIF.isBlank()){  
            PersistenciaDatosImpl pd = new PersistenciaDatosImpl();
            List<Contrato> contratos = pd.consultaContratosActualesEmpresa(NIF);
            for(Contrato c: contratos)
                if(DNI.equals(c.getTrabajador().getDNI())){
                    contrato = c;
                    break;
                }
        } 
        return contrato; 
    }

    @Override
    public boolean existeEmpresa(String NIF) {
        boolean existe = false; 
        PersistenciaDatosImpl pd = new PersistenciaDatosImpl();
        Empresa empresa = null;
        if(NIF != null && !NIF.isEmpty() && !NIF.isBlank())
            empresa = pd.consultaEmpresa(NIF);        
        if(empresa != null && !empresa.isEmpty())
            existe = true;
        return existe;
    }
    
}
