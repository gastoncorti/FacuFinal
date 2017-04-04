package trabajofinalestructuras.Estructuras;

public class ListaString {

    private NodoString cabecera;

    public ListaString() {
        this.cabecera = null;
    }

    public boolean esVacia() {
        return this.cabecera == null;
    }

    public int longitud() {
        NodoString aux = this.cabecera;
        int i = 0;
        while (aux != null) {
            i++;
            aux = aux.getEnlace();
        }
        return i;
    }

    public boolean insertar(String elem, int pos) {
        boolean exito = true;
        if (pos < 1 || pos > longitud() + 1) {
            exito = false;
        } else {
            NodoString insertar = new NodoString(elem);
            if (pos == 1) {
                insertar.setEnlace(cabecera);
                this.cabecera = insertar;
            } else {
                NodoString aux = this.cabecera;
                int i = 1;
                while (i < (pos - 1)) {
                    i++;
                    aux = aux.getEnlace();
                }
                insertar.setEnlace(aux.getEnlace());
                aux.setEnlace(insertar);
            }
        }
        return exito;
    }

    public boolean eliminar(int pos) {
        boolean exito = true;
        if (pos < 1 || pos > longitud()) {
            exito = false;
        } else {
            if (pos == 1) {
                this.cabecera = cabecera.getEnlace();
            } else {
                NodoString aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
        }
        return exito;
    }

    public String recuperarElemento(int pos) {
        NodoString aux = this.cabecera;
        int i = 1;
        boolean encontrado = false;
        while (!encontrado) {
            if (i == pos) {
                encontrado = true;
            } else {
                i++;
                aux = aux.getEnlace();
            }
        }
        return aux.getElem();
    }

    public int localizar(String elem) {
        int pos = -1, i = 1;
        NodoString aux = this.cabecera;
        boolean encontrado = false;
        while (i <= longitud() && !encontrado) {
            if (elem.equalsIgnoreCase(aux.getElem())) {
                pos = i;
                encontrado = true;
            } else {
                aux = aux.getEnlace();
                i++;
            }
        }
        return pos;
    }

    public boolean pertenece(String palabra) {
        boolean res = false;
        int i = 1;
        NodoString aux = cabecera;
        while (!res && aux != null) {
            if (aux.getElem().equals(palabra)) {
                res = true;
            }
            aux = aux.getEnlace();
        }
        return res;
    }

    public void vaciar() {
        this.cabecera = null;
    }

    public ListaString clonar() {
        ListaString salida = new ListaString();
        NodoString aux = this.cabecera;
        salida.cabecera = new NodoString(aux.getElem(), aux.getEnlace());
        NodoString auxSalida = salida.cabecera;
        aux = aux.getEnlace();
        while (aux != null) {
            auxSalida.setEnlace(new NodoString(aux.getElem(), aux.getEnlace()));
            auxSalida = auxSalida.getEnlace();
            aux = aux.getEnlace();
        }
        return salida;
    }

    public void copiar(ListaString lista) {
        if (!lista.esVacia()) {
            this.vaciar();
            NodoString aux = lista.cabecera;
            this.cabecera = new NodoString(aux.getElem(), aux.getEnlace());
            NodoString auxThis = this.cabecera;
            aux = aux.getEnlace();
            while (aux != null) {
                auxThis.setEnlace(new NodoString(aux.getElem(), aux.getEnlace()));
                auxThis = auxThis.getEnlace();
                aux = aux.getEnlace();
            }
        } else {
            this.vaciar();
        }
    }

    @Override
    public String toString() {
        String s = "";
        if (this.cabecera == null) {
            s += "Es vacia";
        } else {
            NodoString aux = this.cabecera;
            s = "[";
            do {
                s += aux.getElem();
                aux = aux.getEnlace();
                if (aux != null) {
                    s += ", ";
                }
            } while (aux != null);
            s += "]";
        }
        return s;
    }
}
