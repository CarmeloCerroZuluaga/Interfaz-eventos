package modelo;

public class Nodo {
    public int dato;
    public Nodo izquierdo;
    public Nodo derecho;

    public Nodo(int dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}

