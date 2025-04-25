package TicketsManagement;


public class TicketType {
    private String nombreTipo;     
    private double precio;         
    private int disponibilidad;    

    public TicketType(String nombreTipo, double precio, int disponibilidad) {
        this.nombreTipo = nombreTipo;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public double getPrecio() {
        return precio;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
