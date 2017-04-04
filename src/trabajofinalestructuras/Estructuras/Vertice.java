package trabajofinalestructuras.Estructuras;

public class Vertice {

    private String elemento;
    private Vertice siguiente;
    private Adyacente primerAdyacente;

    public void setElemento(String elem) {
        elemento = elem;
    }

    public String getElemento() {
        return elemento;
    }

    public void setSiguienteVertice(Vertice siguienteVertice) {
        siguiente = siguienteVertice;
    }

    public Vertice getSiguienteVertice() {
        return siguiente;
    }

    public void setPrimerAdyacente(Adyacente adyacentePrimero) {
        primerAdyacente = adyacentePrimero;
    }

    public Adyacente getPrimerAdyacente() {
        return primerAdyacente;
    }
}
