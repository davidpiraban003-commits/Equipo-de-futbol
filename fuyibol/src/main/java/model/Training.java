package model;



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

    // getters y setters
}
