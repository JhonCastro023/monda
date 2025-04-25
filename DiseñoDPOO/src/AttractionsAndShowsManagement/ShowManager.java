package AttractionsAndShowsManagement;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class ShowManager {
    private final List<Espectaculo> espectaculos;
    private final List<Temporada> temporadas;
    private int nextEspectaculoId = 1;
    private int nextTemporadaId = 1;

    public ShowManager() {
        this.espectaculos = new ArrayList<>();
        this.temporadas = new ArrayList<>();
    }

    // Gestión de Temporadas

    public Temporada crearTemporada(String nombre, LocalDate fechaInicio, 
                                  LocalDate fechaFin, String descripcion) {
        Temporada temporada = new Temporada(nextTemporadaId++, nombre, 
                                          fechaInicio, fechaFin, descripcion);
        temporadas.add(temporada);
        return temporada;
    }

    public List<Temporada> listarTemporadas() {
        return Collections.unmodifiableList(temporadas);
    }

    public Optional<Temporada> buscarTemporadaPorId(int id) {
        return temporadas.stream()
                .filter(t -> t.getId() == id)
                .findFirst();
    }

    public List<Temporada> listarTemporadasActivas() {
        return temporadas.stream()
                .filter(Temporada::estaActiva)
                .collect(Collectors.toUnmodifiableList());
    }

    // Gestión de Espectáculos

    public Espectaculo programarEspectaculo(String titulo, String descripcion,
                                          LocalDateTime fechaHora, Duration duracion,
                                          String ubicacion, int capacidadMaxima,
                                          Temporada temporada) {
        validarDisponibilidad(fechaHora, duracion, ubicacion);
        
        Espectaculo espectaculo = new Espectaculo(nextEspectaculoId++, titulo, descripcion,
                                                fechaHora, duracion, ubicacion,
                                                capacidadMaxima, temporada);
        espectaculos.add(espectaculo);
        return espectaculo;
    }

    private void validarDisponibilidad(LocalDateTime fechaHora, Duration duracion, String ubicacion) {
        LocalDateTime fin = fechaHora.plus(duracion);
        
        boolean conflicto = espectaculos.stream()
                .anyMatch(e -> {
                    LocalDateTime inicioExistente = e.getFechaHora();
                    LocalDateTime finExistente = e.getFechaHoraFin();
                    return e.getUbicacion().equals(ubicacion) &&
                            fechaHora.isBefore(finExistente) &&
                            fin.isAfter(inicioExistente);
                });
        
        if (conflicto) {
            throw new IllegalStateException("Conflicto de horario y ubicación para el espectáculo");
        }
    }
}
    
