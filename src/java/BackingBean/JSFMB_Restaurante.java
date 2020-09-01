/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Entidades.Restaurante;
import Sesiones.RestauranteFacadeLocal;
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
@ManagedBean(name = "JSFMB_Restaurante")
@SessionScoped
public class JSFMB_Restaurante implements Serializable{
    //las variables 
    @EJB
    private RestauranteFacadeLocal manejadorRestaurante;
    private List<Restaurante> ListaRestaurante;
    private Restaurante restaurante;
    
    public JSFMB_Restaurante() {
    }
    
    //CODIGO PARA AGREGAR A UN RESTAURANTE
    public void grabarRestaurante() {
        manejadorRestaurante.create(restaurante);
        this.ListaRestaurante();
        //this.recuperarCliente();
    }

    public void ListaRestaurante() {
        setListaRestaurante(manejadorRestaurante.findAll());
    }
    
    @PostConstruct
    private void inicio() {
        restaurante = new Restaurante();
        ListaRestaurante();
        
    }

    public RestauranteFacadeLocal getManejadorRestaurante() {
        return manejadorRestaurante;
    }

    public void setManejadorRestaurante(RestauranteFacadeLocal manejadorRestaurante) {
        this.manejadorRestaurante = manejadorRestaurante;
    }

    public List<Restaurante> getListaRestaurante() {
        return ListaRestaurante;
    }

    public void setListaRestaurante(List<Restaurante> ListaRestaurante) {
        this.ListaRestaurante = ListaRestaurante;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
    
}
