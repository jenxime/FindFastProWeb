/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Entidades.Cliente;
import Sesiones.ClienteFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Xime
 */
@ManagedBean(name = "JSFMB_FindFastPro")
//@RequestScoped
@SessionScoped
public class JSFMB_FindFastPro implements Serializable{
    //las variables 
    @EJB
    private ClienteFacadeLocal manejadorCliente;
    private List<Cliente> ListaClientes;
    private Cliente cliente;
    
    private String fechaNacimiento;
    
    public JSFMB_FindFastPro() {
    }
    
    //CODIGO PARA AGREGAR A UN CLIENTE
    public void grabarCliente() {
        cliente.setFechanacimiento(fechaNacimiento);
        manejadorCliente.create(cliente);
        this.ListaClientes();
        //this.recuperarCliente();
    }

    public void ListaClientes() {
        setListaClientes(manejadorCliente.findAll());
    }
    
    @PostConstruct
    private void inicio() {
        cliente = new Cliente();
        ListaClientes();
        
    }

    public ClienteFacadeLocal getManejadorCliente() {
        return manejadorCliente;
    }

    public void setManejadorCliente(ClienteFacadeLocal manejadorCliente) {
        this.manejadorCliente = manejadorCliente;
    }

    public List<Cliente> getListaClientes() {
        return ListaClientes;
    }

    public void setListaClientes(List<Cliente> ListaClientes) {
        this.ListaClientes = ListaClientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
        
}
