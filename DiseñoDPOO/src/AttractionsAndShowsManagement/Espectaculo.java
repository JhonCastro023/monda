package AttractionsAndShowsManagement;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;


public class Espectaculo {
    private int id;
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaHora;
    private Duration duracion;
    private String ubicacion;
    private int capacidadMaxima;
    private Temporada temporada;
    private boolean activo;

    public Espectaculo(int id, String titulo, String descripcion, 
                      LocalDateTime fechaHora, Duration duracion,
                      String ubicacion, int capacidadMaxima, 
                      Temporada temporada) {
        this.id = id;
        this.titulo = Objects.requireNonNull(titulo, "El título no puede ser nulo");
        this.descripcion = Objects.requireNonNull(descripcion);
        this.fechaHora = Objects.requireNonNull(fechaHora);
        this.duracion = Objects.requireNonNull(duracion);
        this.ubicacion = Objects.requireNonNull(ubicacion);
        this.capacidadMaxima = validarCapacidad(capacidadMaxima);
        this.temporada = Objects.requireNonNull(temporada);
        this.activo = true;
    }

    private int validarCapacidad(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que cero");
        }
        return capacidad;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHora.plus(duracion);
    }

    public boolean esHoy() {
        return fechaHora.toLocalDate().equals(LocalDateTime.now().toLocalDate());
    }

    public boolean estaEnCurso() {
        LocalDateTime ahora = LocalDateTime.now();
        return ahora.isAfter(fechaHora) && ahora.isBefore(getFechaHoraFin());
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = Objects.requireNonNull(titulo);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = Objects.requireNonNull(fechaHora);
    }

    public Duration getDuracion() {
        return duracion;
    }

    public void setDuracion(Duration duracion) {
        this.duracion = Objects.requireNonNull(duracion);
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = Objects.requireNonNull(ubicacion);
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = validarCapacidad(capacidadMaxima);
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = Objects.requireNonNull(temporada);
    }

    public boolean isActivo() {
        return activo;
    }

    public void activar() {
        this.activo = true;
    }

    public void desactivar() {
        this.activo = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Espectaculo that = (Espectaculo) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("Espectaculo{id=%d, titulo='%s', fecha=%s, ubicacion='%s'}", 
                           id, titulo, fechaHora, ubicacion);
    }
}
