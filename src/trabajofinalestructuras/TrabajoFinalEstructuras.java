package trabajofinalestructuras;

import trabajofinalestructuras.Utiles.ServicioViajero;
import trabajofinalestructuras.Utiles.Ciudad;
import trabajofinalestructuras.Utiles.TecladoIn;

public class TrabajoFinalEstructuras {

    public static void main(String[] args) {
        boolean mostrarMenu = true;
        byte opcion;
        ServicioViajero sv = cargaInicial();

        while (mostrarMenu) {
            menu();
            System.out.print("Ingrese Opción: ");
            opcion = TecladoIn.readLineByte();
            System.out.println("");
            switch (opcion) {
                case 1:
                    System.out.println(sv.insertarCiudad());
                    break;
                case 2:
                    System.out.println(sv.eliminarCiudad());
                    break;
                case 3:
                    System.out.println(sv.insertarArco());
                    break;
                case 4:
                    System.out.println(sv.eliminarArco());
                    break;
                case 5:
                    System.out.println(sv.datosCiudad());
                    break;
                case 6:
                    System.out.println(sv.listarRango());
                    break;
                case 7:
                    System.out.println(sv.caminoMasCorto());
                    break;
                case 8:
                    System.out.println(sv.menorKilometros());
                    break;
                case 9:
                    System.out.println(sv.menorCantidadCiudades());
                    break;
                case 10:
                    System.out.println(sv.soloAlojamiento());
                    break;
                case 11:
                    sv.ordenAlfabetico();
                    break;
                case 12:
                    sv.mostrarDiccionario();
                    break;
                case 13:
                    sv.mostrarGrafo();
                    break;
                case 0:
                    mostrarMenu = false;
                    break;
                case 15:
                    sv.probando();
                default:
                    System.out.println("ERROR: Esta opción no es correcta.");
            }
        }
    }

    public static ServicioViajero cargaInicial() {

        // CORDOBA, ROSARIO, RESISTENCIA, PARANA, CIPOLLETI, VIEDMA, TRELEW, RAWSON, CONCEPCION, POSADAS
        //AZUL, RECONQUISTA, NEUQUEN, ROSARIO, USHUAIA
        ServicioViajero sv = new ServicioViajero();

        sv.insertarCiudad("CORDOBA", new Ciudad("CORDOBA", "CORDOBA", 157010, false));
        sv.insertarCiudad("ROSARIO", new Ciudad("ROSARIO", "SANTA FE", 748312, false));
        sv.insertarCiudad("RESISTENCIA", new Ciudad("RESISTENCIA", "CHACO", 290723, false));
        sv.insertarCiudad("PARANA", new Ciudad("PARANA", "ENTRE RIOS", 247863, false));
        sv.insertarCiudad("NEUQUEN", new Ciudad("NEUQUEN", "NEUQUEN", 201868, true));
        sv.insertarCiudad("CIPOLLETI", new Ciudad("CIPOLLETI", "RIO NEGRO", 66472, true));
        sv.insertarCiudad("VIEDMA", new Ciudad("VIEDMA", "RIO NEGRO", 46767, true));
        sv.insertarCiudad("TRELEW", new Ciudad("TRELEW", "CHUBUT", 103656, true));
        sv.insertarCiudad("RAWSON", new Ciudad("RAWSON", "CHUBUT", 31787, false));
        sv.insertarCiudad("CONCEPCION", new Ciudad("CONCEPCION", "TUCUMAN", 46194, false));
        sv.insertarCiudad("POSADAS", new Ciudad("POSADAS", "MISIONES", 354719, false));
        sv.insertarCiudad("AZUL", new Ciudad("AZUL", "BUENOS AIRES", 53054, false));
        sv.insertarCiudad("RECONQUISTA", new Ciudad("RECONQUISTA", "SANTA FE", 66187, false));
        sv.insertarCiudad("ROSARIO", new Ciudad("ROSARIO", "SANTA FE", 748312, false));
        sv.insertarCiudad("USHUAIA", new Ciudad("USHUAIA", "TIERRA DEL FUEGO", 56825, false));

        sv.insertarArco("VIEDMA", "TRELEW", 363);
        sv.insertarArco("CONCEPCION", "VIEDMA", 552);
        sv.insertarArco("CONCEPCION", "AZUL", 709);
        sv.insertarArco("RECONQUISTA", "USHUAIA", 279);
        sv.insertarArco("AZUL", "ROSARIO", 9.8);
        sv.insertarArco("AZUL", "CIPOLLETI", 689);
        sv.insertarArco("CORDOBA", "ROSARIO", 404.6);
        sv.insertarArco("CORDOBA", "AZUL", 531);
        sv.insertarArco("POSADAS", "RESISTENCIA", 626);
        sv.insertarArco("RESISTENCIA", "PARANA", 465);
        sv.insertarArco("RESISTENCIA", "CIPOLLETI", 1265);
        sv.insertarArco("NEUQUEN", "villa maria", 268);
        sv.insertarArco("NEUQUEN", "RESISTENCIA", 954);
        sv.insertarArco("NEUQUEN", "POSADAS", 408);
        sv.insertarArco("TRELEW", "POSADAS", 128);
        sv.insertarArco("TRELEW", "NEUQUEN", 375);
        sv.insertarArco("TRELEW", "RAWSON", 1068);
        sv.insertarArco("ROSARIO", "NEUQUEN", 428);
        sv.insertarArco("ROSARIO", "RESISTENCIA", 1604);
        sv.insertarArco("RAWSON", "ROSARIO", 724);
        sv.insertarArco("RAWSON", "AZUL", 403);
        sv.insertarArco("PARANA", "CONCEPCION", 323);
        sv.insertarArco("PARANA", "NEUQUEN", 453);
        sv.insertarArco("USHUAIA", "AZUL", 527);
        sv.insertarArco("USHUAIA", "NEUQUEN", 184);

        /* sv.insertarCiudad("rio gallegos", new Ciudad("rio gallegos", "santa cruz", 95796, false));
        sv.insertarCiudad("puerto madryn", new Ciudad("puerto madryn", "chubut", 93995, false));
        sv.insertarCiudad("bariloche", new Ciudad("bariloche", "rio negro", 112887, false));
        sv.insertarCiudad("viedma", new Ciudad("viedma", "rio negro", 52789, false));
        sv.insertarCiudad("neuquen", new Ciudad("neuquen", "neuquen", 231780, true));
        sv.insertarCiudad("cipolletti", new Ciudad("cipolletti", "rio negro", 77717, true));
        sv.insertarCiudad("bahia blanca", new Ciudad("bahia blanca", "buenos aires", 291327, true));
        sv.insertarCiudad("necochea", new Ciudad("necochea", "buenos aires", 84784, true));
        sv.insertarCiudad("zapala", new Ciudad("zapala", "neuquen", 32097, false));
        sv.insertarCiudad("laboulaye", new Ciudad("laboulaye", "cordoba", 20534, false));
        sv.insertarCiudad("mar del plata", new Ciudad("mar del plata", "buenos aires", 618989, false));
        sv.insertarCiudad("san rafaela", new Ciudad("san rafaela", "mendoza", 118009, false));
        sv.insertarCiudad("san juan", new Ciudad("san juan", "san juan", 109123, false));
        sv.insertarCiudad("villa maria", new Ciudad("villa maria", "cordoba", 79351, false));
        sv.insertarCiudad("santa rosa", new Ciudad("santa rosa", "la pampa", 124101, false));
        
        sv.insertarArco("rio gallegos", "puerto madryn", 1224);
        sv.insertarArco("rio gallegos", "bariloche", 1604);
        sv.insertarArco("puerto madryn", "viedma", 465);
        sv.insertarArco("puerto madryn", "cipolletti", 689);
        sv.insertarArco("bariloche", "neuquen", 453);
        sv.insertarArco("bariloche", "zapala", 363);
        sv.insertarArco("viedma", "cipolletti", 552);
        sv.insertarArco("viedma", "bahia blanca", 279);
        sv.insertarArco("neuquen", "cipolletti", 9.8);
        sv.insertarArco("neuquen", "zapala", 184);
        sv.insertarArco("neuquen", "san juan", 954);
        sv.insertarArco("cipolletti", "bahia blanca", 531);
        sv.insertarArco("cipolletti", "santa rosa", 527);
        sv.insertarArco("cipolletti", "villa maria", 1068);
        sv.insertarArco("bahia blanca", "necochea", 323);
        sv.insertarArco("bahia blanca", "santa rosa", 408);
        sv.insertarArco("necochea", "mar del plata", 128);
        sv.insertarArco("necochea", "santa rosa", 626);
        sv.insertarArco("zapala", "san rafaela", 709);
        sv.insertarArco("zapala", "villa maria", 1265);
        sv.insertarArco("laboulaye", "villa maria", 268);
        sv.insertarArco("laboulaye", "santa rosa", 375);
        sv.insertarArco("laboulaye", "santa rosa", 428);
        sv.insertarArco("mar del plata", "santa rosa", 724);
        sv.insertarArco("san rafaela", "san juan", 403);*/
        return sv;
    }

    public static void menu() {
        final String MENU = "-SERVICIOS DEL VIAJERO- v1.0\n"
                + " 1 - Alta Ciudad.\n"
                + " 2 - Baja Ciudad.\n"
                + " 3 - Alta Arco.\n"
                + " 4 - Baja Arco.\n"
                + " 5 - Información Ciudad.\n"
                + " 6 - Listar rango de ciudades.\n"
                + " 7 - Camino más corto.\n"
                + " 8 - Camino más corto que x kilometros.\n"
                + " 9 - Camino que pasa por la menor cantidad de ciudades.\n"
                + " 10 - Camino a traves de ciudades con alojamiento.\n"
                + " 11 - Listar ciudades por orden alfabetico.\n"
                + " 12 - Mostrar diccionario.\n"
                + " 13 - Mostrar grafo.\n"
                + "\n"
                + " 0 - SALIR.\n";
        System.out.println(MENU);
    }
}
