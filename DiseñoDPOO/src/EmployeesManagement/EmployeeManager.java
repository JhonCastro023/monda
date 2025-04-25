package EmployeesManagement;

import java.util.*;

public class EmployeeManager {

    private Map<String, Employee> employees = new HashMap<>();

    public void createEmployee(String id, String name, List<String> capacitaciones, int age) {
        Employee nuevo = new Employee(id, name, age, capacitaciones, false, false) {
            @Override
            public List<Attraction> consultCatalog() {
                return new ArrayList<>();
            }
        };
        employees.put(id, nuevo);
    }

    public void editEmployee(String employeeId, List<String> nuevasCapacitaciones) {
        Employee e = employees.get(employeeId);
        if (e != null) {
            e.getCapacitaciones().clear();
            e.getCapacitaciones().addAll(nuevasCapacitaciones);
        }
    }

    public void deleteEmployee(String employeeId) {
        employees.remove(employeeId);
    }

    public Employee getEmployee(String employeeId) {
        return employees.get(employeeId);
    }

    public List<Employee> listAllEmployee() {
        return new ArrayList<>(employees.values());
    }
}
