class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public void display() {
        System.out.println(
            "ID: " + employeeId +
            ", Name: " + name +
            ", Position: " + position +
            ", Salary: " + salary
        );
    }
}

public class EmployeeManagement {
    private Employee[] employees;
    private int count;

    public EmployeeManagement(int size) {
        employees = new Employee[size];
        count = 0;
    }

    // Add Employee
    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count] = employee;
            count++;
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Array is full.");
        }
    }

    // Search Employee by ID
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse Employees
    public void traverseEmployees() {
        if (count == 0) {
            System.out.println("No employees found.");
            return;
        }

        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    // Delete Employee by ID
    public void deleteEmployee(int employeeId) {
        int index = -1;

        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[count - 1] = null;
        count--;

        System.out.println("Employee deleted successfully.");
    }

    public static void main(String[] args) {
        EmployeeManagement manager = new EmployeeManagement(10);

        manager.addEmployee(new Employee(101, "Alice", "Manager", 75000));
        manager.addEmployee(new Employee(102, "Bob", "Developer", 60000));
        manager.addEmployee(new Employee(103, "Charlie", "Tester", 50000));

        System.out.println("\nAll Employees:");
        manager.traverseEmployees();

        System.out.println("\nSearching Employee ID 102:");
        Employee emp = manager.searchEmployee(102);

        if (emp != null) {
            emp.display();
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDeleting Employee ID 102:");
        manager.deleteEmployee(102);

        System.out.println("\nEmployees After Deletion:");
        manager.traverseEmployees();
    }
}
