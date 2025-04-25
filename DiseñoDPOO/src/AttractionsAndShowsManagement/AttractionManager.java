package AttractionsAndShowsManagement;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class AttractionManager {
    private final List<Attraction> atracciones;
    private int nextId = 1;

    public AttractionManager() {
        this.atracciones = new ArrayList<>();
    }

    public void agregarAtraccion(Attraction atraccion) {
        Objects.requireNonNull(atraccion, "La atracción no puede ser nula");
        atraccion.setId(nextId++);
        atracciones.add(atraccion);
    }

    public Optional<Attraction> buscarPorId(int id) {
        return atracciones.stream()
                .filter(a -> a.getId() == id)
                .findFirst();
    }

    public List<Attraction> listarTodas() {
        return Collections.unmodifiableList(atracciones);
    }

    public List<Attraction> listarActivas() {
        return atracciones.stream()
                .filter(Attraction::isActiva)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<AtraccionMecanica> listarMecanicas() {
        return atracciones.stream()
                .filter(a -> a instanceof AtraccionMecanica)
                .map(a -> (AtraccionMecanica) a)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<AtraccionCultural> listarCulturales() {
        return atracciones.stream()
                .filter(a -> a instanceof AtraccionCultural)
                .map(a -> (AtraccionCultural) a)
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean actualizarAtraccion(int id, String nuevoNombre, String nuevaUbicacion) {
        Optional<Attraction> atraccionOpt = buscarPorId(id);
        if (atraccionOpt.isPresent()) {
            Attraction a = atraccionOpt.get();
            a.setNombre(nuevoNombre);
            a.setUbicacion(nuevaUbicacion);
            return true;
        }
        return false;
    }

    public boolean eliminarAtraccion(int id) {
        return atracciones.removeIf(a -> a.getId() == id);
    }

    public List<Attraction> buscarPorNombre(String nombre) {
        return atracciones.stream()
                .filter(a -> a.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Attraction> buscarPorUbicacion(String ubicacion) {
        return atracciones.stream()
                .filter(a -> a.getUbicacion().equalsIgnoreCase(ubicacion))
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean activarAtraccion(int id) {
        Optional<Attraction> atraccionOpt = buscarPorId(id);
        if (atraccionOpt.isPresent()) {
            Attraction a = atraccionOpt.get();
            a.activar();
            return true;
        }
        return false;
    }

    public boolean desactivarAtraccion(int id) {
        Optional<Attraction> atraccionOpt = buscarPorId(id);
        if (atraccionOpt.isPresent()) {
            Attraction a = atraccionOpt.get();
            a.desactivar();
            return true;
        }
        return false;
    }

    public String generarReporteAtracciones() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("Reporte de Atracciones\n");
        reporte.append("======================\n");
        
        reporte.append("\nAtracciones Mecánicas:\n");
        listarMecanicas().forEach(a -> 
            reporte.append(String.format("- %s (ID: %d, Estado: %s)\n", 
                a.getNombre(), a.getId(), a.isActiva() ? "Activa" : "Inactiva")));
        
        reporte.append("\nAtracciones Culturales:\n");
        listarCulturales().forEach(a -> 
            reporte.append(String.format("- %s (ID: %d, Estado: %s)\n", 
                a.getNombre(), a.getId(), a.isActiva() ? "Activa" : "Inactiva")));
        
        reporte.append(String.format("\nTotal: %d atracciones (%d activas)\n", 
            atracciones.size(), listarActivas().size()));
        
        return reporte.toString();
    }
}
