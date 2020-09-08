/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Entidades.Plato;
import Entidades.Restaurante;
import Sesiones.PlatoFacadeLocal;
import Sesiones.RestauranteFacadeLocal;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Xime
 */
@ManagedBean(name = "JSFMB_Plato")
@SessionScoped
public class JSFMB_Plato implements Serializable {

    @EJB
    private RestauranteFacadeLocal manejadorRestaurante;
    @EJB
    private PlatoFacadeLocal manejadorPlato;
    //Seinstancian las entidades que van a estar incluidas en el menu
    private Collection<Plato> listaPlato;
    private List<Restaurante> ListaRestaurante;
    //
    private Plato plato;
    private Restaurante restaurante;
    //variables de la clase plato
    

    public JSFMB_Plato() {
       
    }

    //CODIGO PARA AGREGAR A UN PLATO
    public void grabarPlato() {
        manejadorPlato.create(plato);
        this.ListaPlato();
    }
    
    //Codigo para cargar el menu de acuerdo al restaurante
    public void cargarMenu(Restaurante restaurante) {
        System.out.println(restaurante.getNombre());
        listaPlato = restaurante.getPlatoCollection();
        this.restaurante = restaurante;

    }
  

    @PostConstruct
    private void inicio() {
        ListaRestaurante = manejadorRestaurante.findAll();
        ListaPlato();
    }

    public void ListarRestaurante() {
        this.setListaRestaurante(manejadorRestaurante.ListaRestaurante());
    }

    public void ListaPlato() {
        setListaPlato(manejadorPlato.findAll());
    }
    
    public void setManejadorPlato(PlatoFacadeLocal manejadorPlato) {
        this.manejadorPlato = manejadorPlato;
    }

    public Collection<Plato> getListaPlato() {
        return listaPlato;
    }

    public void setListaPlato(List<Plato> ListaPlato) {
        this.listaPlato = ListaPlato;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
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
    //se creara para registrar pero se quiere guardar 

//    public void registrar() {
//        try {
//            this.restaurante.setRuc(BigDecimal.ONE);
//            this.plato.setRestauranteruc(restaurante);
//            manejadorPlato.edit(plato);
//            manejadorRestaurante.edit(restaurante);
//
//            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO", "Registro guardado"));
//        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null,
//                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "AVISO", "Error"));
//        }
//    }
//
//    public void leer(Restaurante restaurantSeleccion) {
//        restaurante = restaurantSeleccion;
//    }
}

