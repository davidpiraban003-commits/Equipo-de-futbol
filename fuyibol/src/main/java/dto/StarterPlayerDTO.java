package dto;

public class StarterPlayerDTO {

    private String jugador;
    private double promedio;

    public StarterPlayerDTO() {
    }

    public StarterPlayerDTO(String jugador, double promedio) {
        this.jugador = jugador;
        this.promedio = promedio;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
}