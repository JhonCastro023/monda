package AttractionsAndShowsManagement;

import java.util.Objects;

public abstract class Attraction {
    protected int id;
    protected String nombre;
    private String ubicacion;
    private int cupoMaximo;
    private String nivelExclusividad;
    private int minEmpleados;
    protected boolean activa;

    public Attraction(int id, String nombre, String ubicacion, int cupoMaximo, 
                    String nivelExclusividad, int minEmpleados) {
        this.id = id;
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        this.ubicacion = Objects.requireNonNull(ubicacion, "La ubicación no puede ser nula");
        this.cupoMaximo = validarCupo(cupoMaximo);
        this.nivelExclusividad = Objects.requireNonNull(nivelExclusividad);
        this.minEmpleados = validarEmpleados(minEmpleados);
        this.activa = true;
    }

    private int validarCupo(int cupo) {
        if (cupo <= 0) {
            throw new IllegalArgumentException("El cupo máximo debe ser mayor que cero");
        }
        return cupo;
    }

    private int validarEmpleados(int empleados) {
        if (empleados <= 0) {
            throw new IllegalArgumentException("Se requiere al menos un empleado");
        }
        return empleados;
    }

    public abstract String obtenerDescripcion();

    public void activar() {
        this.activa = true;
    }

    public void desactivar() {
        this.activa = false;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = Objects.requireNonNull(ubicacion);
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = validarCupo(cupoMaximo);
    }

    public String getNivelExclusividad() {
        return nivelExclusividad;
    }

    public void setNivelExclusividad(String nivelExclusividad) {
        this.nivelExclusividad = Objects.requireNonNull(nivelExclusividad);
    }

    public int getMinEmpleados() {
        return minEmpleados;
    }

    public void setMinEmpleados(int minEmpleados) {
        this.minEmpleados = validarEmpleados(minEmpleados);
    }

    public boolean isActiva() {
        return activa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attraction that = (Attraction) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("Attraction{id=%d, nombre='%s', ubicacion='%s', activa=%s}", 
                           id, nombre, ubicacion, activa);
    }

	protected abstract void setId(int i);
}
