package EmployeesManagement;
import java.util.List;

public class Cajero extends Employee {

    public Cajero(String id, String name, int age, List<String> capacitaciones, boolean turnoApertura, boolean turnoCierre) {
        super(id, name, age, capacitaciones, turnoApertura, turnoCierre);
    }
}
