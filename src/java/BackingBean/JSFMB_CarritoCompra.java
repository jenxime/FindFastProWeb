/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Clases.Pedido;
import Entidades.Plato;
import Sesiones.PlatoFacadeLocal;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Xime
 */
@ManagedBean(name = "JSFMB_CarritoCompra")
@SessionScoped
public class JSFMB_CarritoCompra {
    
    //
    private  ArrayList<Pedido> listaPedido;
    
    
            
    //
    @EJB
    private PlatoFacadeLocal manejadorPlato;
    //
    public JSFMB_CarritoCompra() {
        listaPedido = new ArrayList<>();
    }

    public ArrayList<Pedido> getListaPedido() {
        return listaPedido;
    }
      
    
    //agregar a la orden
    public void agregar(Plato plato){
         
        
        
    }
    
    
    
    
}
