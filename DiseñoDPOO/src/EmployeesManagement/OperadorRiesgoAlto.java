import java.util.List;

public class OperadorRiesgoAlto extends Operador {
    public OperadorRiesgoAlto(String id, String name, int age, List<String> capacitaciones, boolean turnoApertura, boolean turnoCierre) {
        super(id, name, age, capacitaciones, turnoApertura, turnoCierre);
    }

    @Override
    public boolean verificarTicket() {
        return super.verificarTicket();
    }

    @Override
    public boolean verificarCondiciones() {
        return true;
}
