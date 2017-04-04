package trabajofinalestructuras.Estructuras;

public class Adyacente {

    private double rotulo;
    private Vertice verticeAdyacente;
    private Adyacente proximoAdyacente;

    public void setRotulo(double cantidad) {
        rotulo = cantidad;
    }

    public double getRotulo() {
        return rotulo;
    }

    public void setVerticeAdyacente(Vertice vert) {
        verticeAdyacente = vert;
    }

    public Vertice getVerticeAdyacente() {
        return verticeAdyacente;
    }

    public void setProximoAdyacente(Adyacente proximo) {
        proximoAdyacente = proximo;
    }

    public Adyacente getProximoAdyacente() {
        return proximoAdyacente;
    }
}
