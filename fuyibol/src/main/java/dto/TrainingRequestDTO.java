package dto;


import java.util.List;

public class TrainingRequestDTO {

    private int numeroEntrenamiento;

    private List<PlayerDTO> jugadores;

    public TrainingRequestDTO() {
    }

    public TrainingRequestDTO(int numeroEntrenamiento,
                              List<PlayerDTO> jugadores) {

        this.numeroEntrenamiento = numeroEntrenamiento;
        this.jugadores = jugadores;
    }

    public int getNumeroEntrenamiento() {
        return numeroEntrenamiento;
    }

    public void setNumeroEntrenamiento(int numeroEntrenamiento) {
        this.numeroEntrenamiento = numeroEntrenamiento;
    }

    public List<PlayerDTO> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<PlayerDTO> jugadores) {
        this.jugadores = jugadores;
    }
}
