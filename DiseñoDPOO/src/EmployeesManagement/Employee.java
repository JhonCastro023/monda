package EmployeesManagement;
import java.util.List;

public abstract class Employee {
    protected String id;
    protected String name;
    protected int age;
    protected List<String> capacitaciones;
    protected boolean turnoApertura;
    protected boolean turnoCierre;
    public Employee(String id, String name, int age, List<String> capacitaciones,
                    boolean turnoApertura, boolean turnoCierre) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.capacitaciones = capacitaciones;
        this.turnoApertura = turnoApertura;
        this.turnoCierre = turnoCierre;
    }
    public String getId() { 
      return id; 
    }
    public String getName() {
      return name;
    }
    public int getAge() {
      return age; 
    }
    public List<String> getCapacitaciones() {
      return capacitaciones; 
    }
    public boolean isTurnoApertura() {
      return turnoApertura; 
    }
    public boolean isTurnoCierre() {
      return turnoCierre; 
    }
    public abstract List<Attraction> consultCatalog();

    public String consultarTurnoApertura() {
        return turnoApertura ? "Tiene turno de apertura" : "No tiene turno de apertura";
    }

    public String consultarTurnoCierre() {
        return turnoCierre ? "Tiene turno de cierre" : "No tiene turno de cierre";
    }
}
