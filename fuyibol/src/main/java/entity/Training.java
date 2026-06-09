package entity;



import java.util.List;

public class Training {

    private int numeroEntrenamiento;

    private List<Player> jugadores;

    public Training() {
    }

    public Training(int numeroEntrenamiento,
                    List<Player> jugadores) {

        this.numeroEntrenamiento = numeroEntrenamiento;
        this.jugadores = jugadores;
    }

    public int getNumeroEntrenamiento() {
        return numeroEntrenamiento;
    }

    public void setNumeroEntrenamiento(int numeroEntrenamiento) {
        this.numeroEntrenamiento = numeroEntrenamiento;
    }

    public List<Player> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Player> jugadores) {
        this.jugadores = jugadores;
    }

    public double calcularPromedio() {

        return jugadores.stream()
                .mapToDouble(Player::calcularResultado)
                .average()
                .orElse(0);
    }

    
}
