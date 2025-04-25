package AttractionsAndShowsManagement;

import java.util.Objects;

public class AtraccionCultural extends Attraction {
    private String restriccionesEdad;
    private String restriccionesClima;
    private String restriccionesSalud;
    private String tematica;
    private int duracionMinutos;

    public AtraccionCultural(int id, String nombre, String ubicacion,
                           int cupoMaximo, String nivelExclusividad,
                           int minEmpleados, String restriccionesEdad,
                           String restriccionesClima, String restriccionesSalud,
                           String tematica, int duracionMinutos) {
        super(id, nombre, ubicacion, cupoMaximo, nivelExclusividad, minEmpleados);
        this.restriccionesEdad = Objects.requireNonNull(restriccionesEdad);
        this.restriccionesClima = Objects.requireNonNull(restriccionesClima);
        this.restriccionesSalud = Objects.requireNonNull(restriccionesSalud);
        this.tematica = Objects.requireNonNull(tematica);
        this.duracionMinutos = validarDuracion(duracionMinutos);
    }

    private int validarDuracion(int duracion) {
        if (duracion <= 0) {
            throw new IllegalArgumentException("La duración debe ser positiva");
        }
        return duracion;
    }

    @Override
    public String obtenerDescripcion() {
        return String.format(
            "%s - Cultural [Temática: %s, Duración: %d min, Edad: %s]",
            nombre, tematica, duracionMinutos, restriccionesEdad
        );
    }

    public String getHorarioRecomendado() {
        if (restriccionesClima.toLowerCase().contains("interior")) {
            return "Disponible todo el día";
        } else {
            return "Recomendado por la mañana o tarde";
        }
    }

    // Getters y setters específicos
    public String getRestriccionesEdad() {
        return restriccionesEdad;
    }

    public void setRestriccionesEdad(String restriccionesEdad) {
        this.restriccionesEdad = Objects.requireNonNull(restriccionesEdad);
    }

    public String getRestriccionesClima() {
        return restriccionesClima;
    }

    public void setRestriccionesClima(String restriccionesClima) {
        this.restriccionesClima = Objects.requireNonNull(restriccionesClima);
    }

    public String getRestriccionesSalud() {
        return restriccionesSalud;
    }

    public void setRestriccionesSalud(String restriccionesSalud) {
        this.restriccionesSalud = Objects.requireNonNull(restriccionesSalud);
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = Objects.requireNonNull(tematica);
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = validarDuracion(duracionMinutos);
    }

    @Override
    public String toString() {
        return String.format(
            "AtraccionCultural{id=%d, nombre='%s', tematica='%s', activa=%s}",
            id, nombre, tematica, activa
        );
    }

	@Override
	protected void setId(int i) {
		// TODO Auto-generated method stub
		
	}
}
