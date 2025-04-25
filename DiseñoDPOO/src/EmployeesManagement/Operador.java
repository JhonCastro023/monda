import java.util.List;

public class Operador extends Employee {
    public Operador(String id, String name, int age, List<String> capacitaciones, boolean turnoApertura, boolean turnoCierre) {
        super(id, name, age, capacitaciones, turnoApertura, turnoCierre);
    }

    @Override
    public List<Attraction> consultCatalog() {
        return List.of();
    }
    public boolean verificarTicket() {
        return true;
    }
    public boolean verificarCondiciones() {
        return true;
    }
}
