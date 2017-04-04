package trabajofinalestructuras.Estructuras;

import trabajofinalestructuras.Utiles.Ciudad;

public class Nodo {

    private String clave;
    private Ciudad ciudad;
    private int altura;
    private Nodo hijoIzquierdo;
    private Nodo hijoDerecho;

    public Nodo(String nClave, Ciudad nCiudad) {
        clave = nClave;
        ciudad = nCiudad;
        hijoIzquierdo = null;
        hijoDerecho = null;
        altura = 0;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Nodo getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(Nodo hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public Nodo getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(Nodo hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
}
