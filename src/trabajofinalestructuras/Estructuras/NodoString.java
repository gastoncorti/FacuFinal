package trabajofinalestructuras.Estructuras;

public class NodoString {

    private String elem;
    private NodoString enlace;

    public NodoString(String elem, NodoString enlace) {
        this.elem = elem;
        this.enlace = enlace;
    }

    public NodoString(String elemN) {
        this.elem = elemN;
    }

    public String getElem() {
        return elem;
    }

    public void setElem(String elem) {
        this.elem = elem;
    }

    public NodoString getEnlace() {
        return enlace;
    }

    public void setEnlace(NodoString enlaceN) {
        this.enlace = enlaceN;
    }

}
