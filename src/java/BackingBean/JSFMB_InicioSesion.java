/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Entidades.Cliente;
import Entidades.Empleado;
import Sesiones.ValidarAccesoLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author andre
 */
@ManagedBean (name="JSFMB_InicioSesion")
@RequestScoped
public class JSFMB_InicioSesion implements Serializable{

    private String usuario, clave;
    
    @EJB
    public ValidarAccesoLocal manejadorValidarAcceso;
    
    public String iniciarSesion() {
        
        Cliente cli;
        Empleado emp;
        String redireccion = null;
        System.out.println("Ingreso");

        try {
            cli = manejadorValidarAcceso.ValidarCliente(this.getUsuario(), this.getClave());
            emp = manejadorValidarAcceso.ValidarEmpleado(this.getUsuario(), this.getClave());
            if (cli != null) {
                System.out.println("Ingreso cliente");
                redireccion = "/index.xhtml";
            } else if (emp != null){
                System.out.println("Ingreso empleado");
                redireccion = "/RegistrarRestaurante.xhtml";
            }else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrectas"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "ERROR"));
        }
        return redireccion;
    }

    
    public JSFMB_InicioSesion() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
    
}
