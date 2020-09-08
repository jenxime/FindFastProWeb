/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Entidades.Plato;

/**
 *
 * @author Xime
 */
public class Pedido {
    private Plato plato;
    private int cantidad;

    public Pedido(Plato plato, int cantidad) {
        this.plato = plato;
        this.cantidad = cantidad;
    }


    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}

