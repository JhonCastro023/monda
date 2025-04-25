package AttractionsAndShowsManagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


public class Temporada {
    private final int id;
    private final String nombre;
    private final LocalDate fechaInicio;
    private final LocalDate fechaFin;
    private final String descripcion;

    public Temporada(int id, String nombre, LocalDate fechaInicio, 
                   LocalDate fechaFin, String descripcion) {
        if (fechaInicio.isAfter(fechaFin)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin");
        }
        
        this.id = id;
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        this.fechaInicio = Objects.requireNonNull(fechaInicio);
        this.fechaFin = Objects.requireNonNull(fechaFin);
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean estaActiva() {
        LocalDate hoy = LocalDate.now();
        return !hoy.isBefore(fechaInicio) && !hoy.isAfter(fechaFin);
    }

    public String getPeriodoFormateado() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%s - %s", 
                           fechaInicio.format(formatter), 
                           fechaFin.format(formatter));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temporada temporada = (Temporada) o;
        return id == temporada.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("Temporada{id=%d, nombre='%s', periodo=%s}", 
                           id, nombre, getPeriodoFormateado());
    }
}
