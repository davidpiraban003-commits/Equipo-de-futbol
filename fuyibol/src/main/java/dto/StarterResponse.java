package dto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StarterResponse {

    private String jugador;
    private double promedio;
    private List<StarterResponse> titulares;

    public StarterResponse() {
    }

    public StarterResponse(List<StarterResponse> titulares) {
        this.titulares = titulares;
    }

    public StarterResponse(String jugador,
                           double promedio) {
        this.jugador = jugador;
        this.promedio = promedio;
    }

    public List<StarterResponse> getTitulares() {
        return titulares;
    }

    public void setTitulares(List<StarterResponse> titulares) {
        this.titulares = titulares;
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
