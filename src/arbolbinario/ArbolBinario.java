/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

import java.util.Stack;

/**
 *
 * @author WILY
 * @param <T>
 */
public class ArbolBinario<T extends Comparable<T>> {

    //T dato;
    public ArbolBinario() {
        raiz = null;

    }

    NodoBinario<T> raiz = null;

    public NodoBinario<T> getNodoRaiz() {
        return raiz;
    }

    public void setNodoRaiz(NodoBinario<T> raiz) {
        this.raiz = raiz;

    }

    public void Preorden(NodoBinario<T> raiz) {
        if (raiz != null) {
            System.out.print(raiz.getDato());
            Preorden(raiz.getIzquierda());
            Preorden(raiz.getDerecha());

        }

    }

    public void Inorden(NodoBinario<T> raiz) {
        if (raiz != null) {
            Inorden(raiz.getIzquierda());
            System.out.print(raiz.getDato());
            Inorden(raiz.getDerecha());

        }

    }

    public void Posorden(NodoBinario<T> raiz) {
        if (raiz != null) {
            Posorden(raiz.getIzquierda());
            Posorden(raiz.getDerecha());
            System.out.print(raiz.getDato());

        }

    }

    public void Buscar(NodoBinario<T> raiz, T dato) {

        if (raiz != null) {
            if (dato.compareTo(raiz.getDato()) < 0) {
                Buscar(raiz.getIzquierda(), dato);

            } else if (dato.compareTo(raiz.getDato()) > 0) {
                Buscar(raiz.getDerecha(), dato);

            } else {
                System.out.println(" el objeto no se encontro en el arbol");
            }

        } else {
            System.out.println("  el objeto no existe");
        }
    }

    public int altura(NodoBinario<T> raiz, int altura) {
        altura = altura + 1;
        int izquierda, derecha;
        if (raiz != null) {
            System.out.println("El nivel del nodo: " + raiz.getDato() + " es: " + altura);
            izquierda = altura(raiz.getIzquierda(), altura);
            derecha = altura(raiz.getDerecha(), altura);
        } else {
            return -1;
        }
        if (izquierda > derecha) {
            return izquierda + 1;
        } else {
            return derecha + 1;
        }
    }

    //ver el arbol desde arriba
    public void Ver_altura(NodoBinario<T> rex) {

        Stack<NodoBinario<T>> s = new Stack<NodoBinario<T>>();
        NodoBinario act = rex;
        while (act != null) {
            s.push(act);
            act = act.getIzquierda();

        }
        while (s.peek() != rex) {

            System.out.print(s.pop().dato + " ");
        }
        act = rex;
        while (act != null) {
            System.out.print(act.dato + "");
            act = act.getDerecha();

        }

    }

    public void PreordeTransve(NodoBinario<T> raiz) {
        Stack<NodoBinario<T>> pila = new Stack<NodoBinario<T>>();
        pila.push(raiz);

        while (!pila.isEmpty()) {
            NodoBinario<T> actual = pila.pop();
            if (actual.getDerecha() != null) {
                pila.push(actual.getDerecha());

            }
            if (actual.getIzquierda() != null) {

                pila.push(actual.getIzquierda());

            }
            System.out.print(actual.dato + "");

        }

    }

    public void PostOrdeXtrans(NodoBinario<T> nodo) {
        if (nodo == null) {
            return;

        }
        PostOrdeXtrans(nodo.getIzquierda());
        PostOrdeXtrans(nodo.getDerecha());
        System.out.print(nodo.dato + "");

    }

    public void inorderXtrans(NodoBinario<T> nodo) {
        if (nodo == null) {

            return;
        }
        inorderXtrans(nodo.getIzquierda());
        System.out.print(nodo.dato + "");
        inorderXtrans(nodo.getDerecha());

    }

    public int Altura(NodoBinario<T> raiz) {

        int alturaIzq = 0;
        int alturaDer = 0;

        if (raiz != null) {

            if (raiz.getIzquierda() != null) {
                alturaIzq = Altura(raiz.getIzquierda());

            }
            if (raiz.getDerecha() != null) {
                alturaDer = Altura(raiz.getDerecha());
            }
        }
        return alturaIzq > alturaDer ? alturaIzq + 1 : alturaDer + 1;
    }
    
    
    public boolean esBST(NodoBinario<Integer> raiz, int minimo, int maximo) {
        if (raiz != null) {
            if (raiz.dato >= maximo || raiz.dato <= minimo) {
                return false;

            } else {
                return esBST(raiz.getIzquierda(), minimo, raiz.dato) & esBST(raiz.getDerecha(), raiz.dato, maximo);

            }

        } else {

            return true;
        }

    }
    

    

    //imprime el arbol de forma transversal en orden
    public void imprimeTr(NodoBinario<T> actual) {

        if (actual != null) {

            if (actual.getIzquierda() != null && actual.getDerecha() != null) {
                System.out.print(actual.dato + " ");
                System.out.print(actual.getIzquierda().dato + "");
                System.out.println(actual.getDerecha().dato + "");
                imprimeTr(actual.getIzquierda());
                imprimeTr(actual.getDerecha());

            } else if (actual.getDerecha() == null && actual.getIzquierda() == null) {

            } else if (actual.getDerecha() == null) {
                System.out.print(actual.getIzquierda().dato + "");

            } else {
                System.out.print(actual.getDerecha().dato + " ");
            }

        }
    }
    

    

    boolean veresBST(NodoBinario<Integer> raiz) {
        return esBST(raiz, 0, Integer.MAX_VALUE);
    }
   
   
  
    
    //exmen unidad 4 Arbol binario, ejercicio: verificar que sea un arbol binnario de busqueda
    
    
    public static void main(String[] args) {

        ArbolBinario<Integer> arbolito = new ArbolBinario<Integer>();

        arbolito.setNodoRaiz(new NodoBinario(50));
        arbolito.getNodoRaiz().setDerecha(new NodoBinario(60));
        arbolito.getNodoRaiz().setIzquierda(new NodoBinario(20));
        // arbolito.getNodoRaiz().setDato(new NodoBinario("+"));
       /*
        
         arbolito.Inorden(arbolito.getNodoRaiz());
         System.out.println("");
         arbolito.Posorden(arbolito.getNodoRaiz());
         System.out.println("");
         arbolito.Preorden(arbolito.getNodoRaiz());
         arbolito.altura(arbolito.getNodoRaiz(), 0);
         */
        //arbolito.Ver_altura(arbolito.getNodoRaiz());
        arbolito.imprimeTr(arbolito.getNodoRaiz());
        arbolito.Ver_altura(arbolito.getNodoRaiz());
         System.out.println();
        System.out.println(arbolito.veresBST(arbolito.getNodoRaiz()));

    }

}
