import java.util.List;

public class Driver {
    void main() {
        EmployeeRepository ep = new EmployeeRepository();

        List<Employee> emps = ep.findAll();
        for (Employee emp: emps) {
            System.out.println(emp);
        }

        System.out.println(ep.findById(111));
        Employee newEmployee = new Employee(120, "Darkhaa", 300000);

        ep.create(newEmployee);

        ep.update(new Employee(120, "Darkhaa_UPDATED", 311111));
        System.out.println(ep.findById(120));

        ep.delete(newEmployee.getEmp_id());

        List<Employee> lastEmps = ep.findAll();
        for (Employee emp: lastEmps) {
            System.out.println(emp);
        }
    }
}
