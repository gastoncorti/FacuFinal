package trabajofinalestructuras.Estructuras;

public class ColaString {

    private NodoString frenteCola;
    private NodoString finalCola;

    public ColaString() {
        frenteCola = null;
        finalCola = null;
    }

    public boolean esVacia() {
        return (frenteCola == null);
    }

    public boolean poner(String elem) {
        NodoString nuevo = new NodoString(elem);
        if (esVacia()) {
            frenteCola = nuevo;
            finalCola = frenteCola;
        } else {
            finalCola.setEnlace(nuevo);
        }
        finalCola = nuevo;
        return true;
    }

    public boolean sacar() {
        boolean sacado;
        if (esVacia()) {
            sacado = false;
        } else {
            frenteCola = frenteCola.getEnlace();
            sacado = true;
        }
        if (frenteCola == null) {
            finalCola = null;
        }
        return sacado;
    }

    public String obtenerFrente() {
        return (frenteCola == null) ? " " : frenteCola.getElem();
    }

    public void vaciar() {
        frenteCola = finalCola = null;
    }

    public ColaString clonar() {
        ColaString nuevaCola = new ColaString();
        NodoString aux, aux2;
        if (frenteCola != null) {
            nuevaCola.frenteCola = frenteCola;
            nuevaCola.finalCola = finalCola;
            aux = frenteCola;
            aux2 = nuevaCola.frenteCola;
            while (aux != null) {
                aux2.setEnlace(aux.getEnlace());
                aux = aux.getEnlace();
                aux2 = aux2.getEnlace();
            }
        }
        return nuevaCola;
    }

    @Override
    public String toString() {
        String cadena = "";
        NodoString aux = frenteCola;
        while (aux != null) {
            cadena = cadena + aux.getElem() + " ";
            aux = aux.getEnlace();
        }
        return "[ " + cadena + "]";
    }
}
