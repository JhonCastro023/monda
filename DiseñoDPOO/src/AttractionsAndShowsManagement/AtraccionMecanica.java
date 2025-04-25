package AttractionsAndShowsManagement;


import java.util.List;
import java.util.Objects;

public class AtraccionMecanica extends Attraction {
    public enum NivelRiesgo { MEDIO, ALTO}

    private double alturaMinima;
    private double alturaMaxima;
    private double pesoMinimo;
    private double pesoMaximo;
    private NivelRiesgo nivelRiesgo;
    private List<String> restriccionesMedicas;
    private boolean requiereMantenimiento;

    public AtraccionMecanica(int id, String nombre, String ubicacion, 
                           int cupoMaximo, String nivelExclusividad,
                           int minEmpleados, double alturaMinima, 
                           double alturaMaxima, double pesoMinimo,
                           double pesoMaximo, NivelRiesgo nivelRiesgo,
                           List<String> restriccionesMedicas) {
        super(id, nombre, ubicacion, cupoMaximo, nivelExclusividad, minEmpleados);
        this.alturaMinima = validarAltura(alturaMinima);
        this.alturaMaxima = validarAltura(alturaMaxima);
        this.pesoMinimo = validarPeso(pesoMinimo);
        this.pesoMaximo = validarPeso(pesoMaximo);
        this.nivelRiesgo = Objects.requireNonNull(nivelRiesgo);
        this.restriccionesMedicas = List.copyOf(restriccionesMedicas);
        this.requiereMantenimiento = false;
    }

    private double validarAltura(double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("La altura debe ser positiva");
        }
        return altura;
    }

    private double validarPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser positivo");
        }
        return peso;
    }

    @Override
    public String obtenerDescripcion() {
        return String.format(
            "%s - Mecánica [Nivel: %s, Altura: %.2f-%.2f m, Peso: %.2f-%.2f kg]",
            nombre, nivelRiesgo, alturaMinima, alturaMaxima, pesoMinimo, pesoMaximo
        );
    }

    public void realizarMantenimiento() {
        this.requiereMantenimiento = false;
        System.out.println("Mantenimiento completado en " + nombre);
    }

    public void reportarFalla() {
        this.requiereMantenimiento = true;
        this.desactivar();
    }

    public double getAlturaMinima() {
        return alturaMinima;
    }

    public void setAlturaMinima(double alturaMinima) {
        this.alturaMinima = validarAltura(alturaMinima);
    }

    public double getAlturaMaxima() {
        return alturaMaxima;
    }

    public void setAlturaMaxima(double alturaMaxima) {
        this.alturaMaxima = validarAltura(alturaMaxima);
    }

    public double getPesoMinimo() {
        return pesoMinimo;
    }

    public void setPesoMinimo(double pesoMinimo) {
        this.pesoMinimo = validarPeso(pesoMinimo);
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(double pesoMaximo) {
        this.pesoMaximo = validarPeso(pesoMaximo);
    }

    public NivelRiesgo getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(NivelRiesgo nivelRiesgo) {
        this.nivelRiesgo = Objects.requireNonNull(nivelRiesgo);
    }

    public List<String> getRestriccionesMedicas() {
        return List.copyOf(restriccionesMedicas);
    }

    public boolean requiereMantenimiento() {
        return requiereMantenimiento;
    }

    @Override
    public String toString() {
        return String.format(
            "AtraccionMecanica{id=%d, nombre='%s', riesgo=%s, activa=%s}",
            id, nombre, nivelRiesgo, activa
        );
    }

	@Override
	protected void setId(int i) {
		// TODO Auto-generated method stub
		
	}
}
