/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

/**
 *
 * @author WILY
 */
public class NodoBinario<T> {

    T dato;
    NodoBinario<T> izquierda;
    NodoBinario<T> derecha;

    public NodoBinario(){
     
       
    }

    public NodoBinario(T dato) {
        this.dato = dato;
        this.izquierda = izquierda;
        this.derecha = derecha;;

    }


    public void setDato(T dato) {
        this.dato = dato;

    }

    public T getDato() {
        return dato;
    }

    public void setIzquierda(NodoBinario<T> izquierda) {
        this.izquierda = izquierda;
    }

    public NodoBinario<T> getIzquierda() {
        return izquierda;
    }

    public void setDerecha(NodoBinario<T> derecha) {
        this.derecha = derecha;

    }

    public NodoBinario<T> getDerecha() {
        return derecha;

    }

    public String toString() {
        return dato.toString() + "--->";
    }

}
