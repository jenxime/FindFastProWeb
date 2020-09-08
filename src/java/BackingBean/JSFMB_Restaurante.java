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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Xime
 */
@ManagedBean(name = "JSFMB_Restaurante")
@SessionScoped
public class JSFMB_Restaurante implements Serializable {
    //las variables 

    @EJB
    private RestauranteFacadeLocal manejadorRestaurante;
    @EJB
    private PlatoFacadeLocal manejadorPlato;
    //
    private List<Restaurante> ListaRestaurante;
    private List<Plato> ListaPlato;
    //
    private Plato plato;
    private Restaurante restaurante;
    //varianle de restaurante
    private BigDecimal ruc;
    private String nombre;
    private String horarioatencion;
    private String direccion;
    private String telefono;
    private String correo;
    private String descripcion;
    private String imagen;
    private Collection<Plato> platoCollection;

    public JSFMB_Restaurante() {
    }

    //CODIGO PARA AGREGAR A UN RESTAURANTE
    public void grabarRestaurante() {
        manejadorRestaurante.create(restaurante);
        this.ListaRestaurante();
        //this.recuperarCliente();
    }
    //CODIGO PARA LISTAR LOS RESTAURANTE

    public void ListaRestaurante() {
        setListaRestaurante(manejadorRestaurante.findAll());
    }
    //PARA MOSTRAR EL MENU

    public void menuRestaurante(Restaurante restaurante) {
        System.out.println("escojio el restaurante" + restaurante.getNombre());
        
    }

    @PostConstruct
    private void inicio() {
        restaurante = new Restaurante();
        ListaRestaurante();

    }

    //plato
    public List<Plato> getListaPlato() {
        return ListaPlato;
    }

    public void setListaPlato(List<Plato> ListaPlato) {
        this.ListaPlato = ListaPlato;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    //restaurante
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
