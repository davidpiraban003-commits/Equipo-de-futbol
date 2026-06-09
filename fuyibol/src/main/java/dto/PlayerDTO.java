package dto;

public class PlayerDTO {

    private String nombre;
    private double potenciaTiro;
    private double velocidad;
    private int pases;

    public PlayerDTO() {
    }

    public PlayerDTO(String nombre,
                     double potenciaTiro,
                     double velocidad,
                     int pases) {

        this.nombre = nombre;
        this.potenciaTiro = potenciaTiro;
        this.velocidad = velocidad;
        this.pases = pases;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPotenciaTiro() {
        return potenciaTiro;
    }

    public void setPotenciaTiro(double potenciaTiro) {
        this.potenciaTiro = potenciaTiro;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public int getPases() {
        return pases;
    }

    public void setPases(int pases) {
        this.pases = pases;
    }
}