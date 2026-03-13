package controller;

import modelo.Nodo;
import java.util.ArrayList;

public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    // Insertar un nodo
    public void insertar(int dato) {
        raiz = insertarRec(raiz, dato);
    }

    private Nodo insertarRec(Nodo raiz, int dato) {
        if (raiz == null) {
            raiz = new Nodo(dato);
            return raiz;
        }
        if (dato < raiz.dato) {
            raiz.izquierdo = insertarRec(raiz.izquierdo, dato);
        } else if (dato > raiz.dato) {
            raiz.derecho = insertarRec(raiz.derecho, dato);
        }
        return raiz;
    }

    // Recorridos
    public void inorden(Nodo nodo, ArrayList<Integer> lista) {
        if (nodo != null) {
            inorden(nodo.izquierdo, lista);
            lista.add(nodo.dato);
            inorden(nodo.derecho, lista);
        }
    }

    public void preorden(Nodo nodo, ArrayList<Integer> lista) {
        if (nodo != null) {
            lista.add(nodo.dato);
            preorden(nodo.izquierdo, lista);
            preorden(nodo.derecho, lista);
        }
    }

    public void posorden(Nodo nodo, ArrayList<Integer> lista) {
        if (nodo != null) {
            posorden(nodo.izquierdo, lista);
            posorden(nodo.derecho, lista);
            lista.add(nodo.dato);
        }
    }

    public Nodo getRaiz() {
        return raiz;
    }

    // Contar nodos
    public int size() {
        return sizeRec(raiz);
    }

    private int sizeRec(Nodo nodo) {
        if (nodo == null) return 0;
        return 1 + sizeRec(nodo.izquierdo) + sizeRec(nodo.derecho);
    }

    // Imprimir hojas
    public ArrayList<Integer> hojas() {
        ArrayList<Integer> lista = new ArrayList<>();
        hojasRec(raiz, lista);
        return lista;
    }

    private void hojasRec(Nodo nodo, ArrayList<Integer> lista) {
        if (nodo != null) {
            if (nodo.izquierdo == null && nodo.derecho == null) {
                lista.add(nodo.dato);
            }
            hojasRec(nodo.izquierdo, lista);
            hojasRec(nodo.derecho, lista);
        }
    }

    // Nodos interiores
    public ArrayList<Integer> interiores() {
        ArrayList<Integer> lista = new ArrayList<>();
        interioresRec(raiz, lista);
        return lista;
    }

    private void interioresRec(Nodo nodo, ArrayList<Integer> lista) {
        if (nodo != null) {
            if (nodo.izquierdo != null || nodo.derecho != null) {
                lista.add(nodo.dato);
            }
            interioresRec(nodo.izquierdo, lista);
            interioresRec(nodo.derecho, lista);
        }
    }

    // Promedio
    public double promedio() {
        int suma = sumaDatos(raiz);
        int total = size();
        return total == 0 ? 0 : (double) suma / total;
    }

    private int sumaDatos(Nodo nodo) {
        if (nodo == null) return 0;
        return nodo.dato + sumaDatos(nodo.izquierdo) + sumaDatos(nodo.derecho);
    }

    // Buscar dato
    public boolean buscar(int dato) {
        return buscarRec(raiz, dato);
    }

    private boolean buscarRec(Nodo nodo, int dato) {
        if (nodo == null) return false;
        if (nodo.dato == dato) return true;
        return dato < nodo.dato ? buscarRec(nodo.izquierdo, dato) : buscarRec(nodo.derecho, dato);
    }

    // Altura del árbol
    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(Nodo nodo) {
        if (nodo == null) return -1;
        int izq = alturaRec(nodo.izquierdo);
        int der = alturaRec(nodo.derecho);
        return 1 + Math.max(izq, der);
    }
}

