package entity;



public class Player {

    private String nombre;
    private double potenciaTiro;
    private double velocidad;
    private int pases;

    public Player() {
    }

    public Player(String nombre,
                  double potenciaTiro,
                  double velocidad,
                  int pases) {

        this.nombre = nombre;
        this.potenciaTiro = potenciaTiro;
        this.velocidad = velocidad;
        this.pases = pases;
    }

    public double calcularResultado() {

        return (potenciaTiro * 0.2)
                + (velocidad * 0.3)
                + (pases * 0.5);
    }

    // getters y setters
}
