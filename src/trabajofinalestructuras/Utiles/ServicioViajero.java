package trabajofinalestructuras.Utiles;

import trabajofinalestructuras.Estructuras.Grafo;
import trabajofinalestructuras.Estructuras.Diccionario;
import trabajofinalestructuras.Estructuras.ListaString;

public class ServicioViajero {

    @SuppressWarnings("FieldMayBeFinal")
    private Diccionario diccionario;
    @SuppressWarnings("FieldMayBeFinal")
    private Grafo grafo;

    public ServicioViajero() {
        diccionario = new Diccionario();
        grafo = new Grafo();
    }

    public void probando() {
        System.out.println(grafo.listarProfundidad());
    }

    //punto 1 carga
    public boolean insertarCiudad() {
        String clave;
        Ciudad ciudad;
        boolean exito = false;
        boolean dic, graf;
        System.out.println("Ingrese el nombre de la ciudad: ");
        clave = TecladoIn.readLine().toUpperCase();
        ciudad = creaCiudad();
        dic = diccionario.insertar(clave, ciudad);
        graf = grafo.insertarVertice(clave);
        if (dic && graf) {
            exito = true;
        }
        return exito;
    }

    private Ciudad creaCiudad() {
        Ciudad nueva;
        String nombre, provincia;
        boolean alojamiento;
        int cantHab;

        System.out.println("Ingrese el nombre de la ciudad");
        nombre = TecladoIn.readLine().toUpperCase();
        System.out.println("Ingrese la provincia de dicha ciudad");
        provincia = TecladoIn.readLine().toUpperCase();
        System.out.println("La ciudad cuenta con alojamiento? (introduzaca S/N)");
        alojamiento = (TecladoIn.readLine().toUpperCase().equals("S"));
        System.out.println("Cual es el numero de habitantes?");
        cantHab = TecladoIn.readLineInt();
        nueva = new Ciudad(nombre, provincia, cantHab, alojamiento);
        return nueva;
    }

    //punto 1 baja
    public boolean eliminarCiudad() {
        String clave;
        boolean exito = false;
        boolean dic, graf;
        System.out.println("Ingrese el nombre de la ciudad a eliminar");
        clave = TecladoIn.readLine().toUpperCase();
        dic = diccionario.eliminar(clave);
        graf = grafo.eliminarVertice(clave);
        if (dic && graf) {
            exito = true;
        }
        return exito;
    }

    //punto 2 alta
    public boolean insertarArco() {
        String inicio, fin;
        double dist;
        System.out.println("Ingrese la ciudad de origen");
        inicio = TecladoIn.readLine().toUpperCase();
        System.out.println("Ingrese la ciudad de destino");
        fin = TecladoIn.readLine().toUpperCase();
        System.out.println("Ingrese la distancia en km");
        dist = TecladoIn.readLineDouble();
        return grafo.insertarArco(inicio, fin, dist);
    }

    //punto 2 baja
    public boolean eliminarArco() {
        String inicio, fin;
        System.out.println("Ingrese la ciudad de origen");
        inicio = TecladoIn.readLine().toUpperCase();
        System.out.println("Ingrese la ciudad de destino");
        fin = TecladoIn.readLine().toUpperCase();
        return grafo.eliminarArco(inicio, fin);
    }

    //punto 3
    public String datosCiudad() {
        String bCiudad;
        Ciudad dato;
        System.out.println("Ingrese el nombre de la ciudad");
        bCiudad = TecladoIn.readLine().toUpperCase();
        dato = diccionario.obtenerCiudad(bCiudad);
        return dato.toString();
    }

    //punto 4
    public ListaString listarRango() {
        String ciudad1, ciudad2;
        System.out.println("Ingrese la primer ciudad");
        ciudad1 = TecladoIn.readLine().toUpperCase();
        System.out.println("Ingrese la segunda ciudad");
        ciudad2 = TecladoIn.readLine().toUpperCase();
        ListaString salida = diccionario.listarClavesRango(ciudad1, ciudad2);
        return salida;
    }

    //punto 5
    public double caminoMasCorto() {
        String ciudad1, ciudad2;
        System.out.println("Ingrese la ciudad de origen");
        ciudad1 = TecladoIn.readLine().toUpperCase();
        System.out.println("Ingrese la ciudad de destino");
        ciudad2 = TecladoIn.readLine().toUpperCase();
        return grafo.menorKilometraje(ciudad1, ciudad2);
    }

    //punto 6
    public boolean menorKilometros() {
        String ciudad1, ciudad2;
        double dist;
        System.out.println("Ingrese la ciudad de origen");
        ciudad1 = TecladoIn.readLine().toUpperCase();
        System.out.println("Ingrese la ciudad de destino");
        ciudad2 = TecladoIn.readLine().toUpperCase();
        System.out.println("Ingrese la distancia en km");
        dist = TecladoIn.readLineDouble();
        return (grafo.menorKilometraje(ciudad1, ciudad2) < dist);
    }

    //punto 7
    public ListaString menorCantidadCiudades() {
        String ciudad1, ciudad2;
        System.out.println("Ingrese la ciudad de origen");
        ciudad1 = TecladoIn.readLine().toUpperCase();
        System.out.println("Ingrese la ciudad de destino");
        ciudad2 = TecladoIn.readLine().toUpperCase();
        ListaString lista = grafo.caminoMasCorto(ciudad1, ciudad2);
        return lista;
    }

    //punto 8
    public ListaString soloAlojamiento() {
        String ciudad1, ciudad2;
        System.out.println("Ingrese la ciudad de origen");
        ciudad1 = TecladoIn.readLine().toUpperCase();
        System.out.println("Ingrese la ciudad de destino");
        ciudad2 = TecladoIn.readLine().toUpperCase();
        ListaString lista = grafo.existeCaminoAlojamiento(ciudad1, ciudad2, diccionario);
        return lista;
    }

    //punto 9
    public void ordenAlfabetico() {
        System.out.println(diccionario.listarInOrden().toString());
    }

    //Debug diccionarioAVL
    public void mostrarDiccionario() {
        diccionario.mostrarArbol();
    }

    //debug grafo
    public void mostrarGrafo() {
        grafo.toString();
    }

    //SOBRECARGA DE METODOS PARA LA EJECUCION DE SCRIP DE GARGA!!
    //punto 1 carga
    public boolean insertarCiudad(String clave, Ciudad ciudad) {
        boolean exito = false;
        boolean dic, graf;
        dic = diccionario.insertar(clave, ciudad);
        graf = grafo.insertarVertice(clave);
        if (dic && graf) {
            exito = true;
        }
        return exito;
    }

    //punto 1 baja
    public boolean eliminarCiudad(String clave) {
        boolean exito = false;
        boolean dic, graf;
        dic = diccionario.eliminar(clave);
        graf = grafo.eliminarVertice(clave);
        if (dic && graf) {
            exito = true;
        }
        return exito;
    }

    //punto 2 alta
    public boolean insertarArco(String inicio, String fin, double dist) {
        return grafo.insertarArco(inicio, fin, dist);
    }

    //punto 2 baja
    public boolean eliminarArco(String inicio, String fin) {
        return grafo.eliminarArco(inicio, fin);
    }
}
