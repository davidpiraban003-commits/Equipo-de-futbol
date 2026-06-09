package dto;



public class MessageResponseDTO {

    private String mensaje;

    public MessageResponseDTO() {
    }

    public MessageResponseDTO(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
