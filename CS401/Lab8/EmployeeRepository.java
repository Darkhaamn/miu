import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    // Gets all employees.
    public  List<Employee> findAll()  {
        List<Employee> emps = new ArrayList<>();

        Connection conn = null;
        try {
            conn = ConnectManager.getConnection();
            PreparedStatement stat = conn.prepareStatement("SELECT * FROM employee");
            ResultSet rs = stat.executeQuery();
            System.out.println(stat.toString());
            while(rs.next()) {
                int emp_id = rs.getInt("emp_id");
                String name = rs.getString("name").trim();
                double salary = rs.getDouble("salary");
                emps.add(new Employee(emp_id, name, salary));
            }
        } catch(SQLException e) {
            System.out.println(e);
        }
        return emps;
    }

    // Gets an employee.
    public Employee findById(int empId)  {
        Connection conn = null;
        try {
            conn = ConnectManager.getConnection();
            PreparedStatement stat = conn.prepareStatement("SELECT * FROM employee where emp_id = ?");
            stat.setInt(1, empId);

            ResultSet rs = stat.executeQuery();
            System.out.println(stat.toString());

            while(rs.next()) {
                int emp_id = rs.getInt("emp_id");
                String name = rs.getString("name").trim();
                double salary = rs.getDouble("salary");
                return new Employee(emp_id, name, salary);
            }
        } catch(SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    // Inserts a new employee.
    public void create(Employee employee) {
        Connection conn = null;
        try {
            conn = ConnectManager.getConnection();
            PreparedStatement stat = conn.prepareStatement("INSERT INTO employee (emp_id, name, salary) VALUES (?, ?, ?)");
            stat.setInt(1, employee.getEmp_id());
            stat.setString(2, employee.getName());
            stat.setDouble(3, employee.getSalary());

            stat.executeUpdate();
            System.out.println("Succesfully inserted");
        } catch(SQLException e) {
            System.out.println(e);
        }
    }

    // Updates an employee
    public void update(Employee employee) {
        Connection conn = null;
        try {
            conn = ConnectManager.getConnection();
            PreparedStatement stat = conn.prepareStatement(
                    "UPDATE employee SET name = ?, salary = ? WHERE emp_id = ?"
            );

            stat.setString(1, employee.getName());
            stat.setDouble(2, employee.getSalary());
            stat.setInt(3, employee.getEmp_id());

            int rows = stat.executeUpdate();
            if (rows > 0) {
                System.out.println("Successfully updated");
            } else {
                System.out.println("No employee found with that ID");
            }

        } catch(SQLException e) {
            System.out.println(e);
        }
    }


    public void delete(int empId) {
        Connection conn = null;
        try {
            conn = ConnectManager.getConnection();
            PreparedStatement stat = conn.prepareStatement(
                    "DELETE FROM employee WHERE emp_id = ?"
            );

            stat.setInt(1, empId);
            int rows = stat.executeUpdate();
            if (rows > 0) {
                System.out.println("Successfully deleted");
            } else {
                System.out.println("No employee found with that ID");
            }

        } catch(SQLException e) {
            System.out.println(e);
        }
    }
}
