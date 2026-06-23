class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}

public class EmployeeManagementSystem {

    static Employee[] employees = new Employee[10];
    static int count = 0;

    public static void addEmployee(Employee e) {
        if (count < employees.length) {
            employees[count] = e;
            count++;
            System.out.println("Employee Added");
        }
    }

    public static void searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Employee Found");
                System.out.println(
                        employees[i].employeeId + " "
                        + employees[i].name + " "
                        + employees[i].position + " "
                        + employees[i].salary
                );
                return;
            }
        }
        System.out.println("Employee Not Found");
    }

    public static void displayEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(
                    employees[i].employeeId + " "
                    + employees[i].name + " "
                    + employees[i].position + " "
                    + employees[i].salary
            );
        }
    }

    public static void deleteEmployee(int id) {

        int index = -1;

        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee Not Found");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }

        count--;

        System.out.println("Employee Deleted");
    }

    public static void main(String[] args) {

        addEmployee(new Employee(101, "Rahul", "Developer", 50000));
        addEmployee(new Employee(102, "Aman", "Tester", 40000));
        addEmployee(new Employee(103, "Priya", "Manager", 70000));

        System.out.println("All Employees:");
        displayEmployees();

        System.out.println("\nSearch Employee:");
        searchEmployee(102);

        System.out.println("\nDelete Employee:");
        deleteEmployee(102);

        System.out.println("\nEmployees After Deletion:");
        displayEmployees();
    }
}