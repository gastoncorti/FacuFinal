package trabajofinalestructuras.Utiles;

public class Ciudad {

    private String ciudad, provincia;
    private int cantidadHabitantes;
    private boolean tieneAlojamiento;

    public Ciudad(String ciudad, String provincia, int cantHab, boolean tieneAlojamiento) {
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.cantidadHabitantes = cantHab;
        this.tieneAlojamiento = tieneAlojamiento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getCantidadHabitantes() {
        return cantidadHabitantes;
    }

    public void setCantidadHabitantes(int cantidadHabitantes) {
        this.cantidadHabitantes = cantidadHabitantes;
    }

    public boolean isAlojamiento() {
        return tieneAlojamiento;
    }

    public void setAlojamiento(boolean tieneAlojamiento) {
        this.tieneAlojamiento = tieneAlojamiento;
    }

    @Override
    public String toString() {
        String salida;
        salida = "Provincia: " + provincia + "\n"
                + "Ciudad: " + ciudad + "\n"
                + "Cantidad de Habitantes: " + cantidadHabitantes + "\n"
                + "Dispone de Alojamiento: " + ((tieneAlojamiento) ? "SI": "NO");
        return salida;
    }
}
