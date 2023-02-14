import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Main {
    static Employee[] employees = new Employee[10];

    /*
    Print a list of all employees
     */
    public static void printEmployeesList() {
        System.out.println("Список всех сотрудников со всеми данными:");
        Arrays.stream(employees)
                .filter(Objects::nonNull)
                .forEach(System.out::println);
    }

    /*
    Calculate the sum of all salaries
     */
    public static double calcTotalSalaries() {
        return Arrays.stream(employees)
                .filter(Objects::nonNull)
                .map(Employee::getSalary)
                .reduce((aDouble, aDouble2) -> aDouble += aDouble2).orElse(0d);
    }

    /*
    Calculate the average salary of all employees
     */
    public static double calcAverageSalary() {
        return calcTotalSalaries() / Employee.getCount();
    }

    /*
    Find an employee with a minimum wage.
     */
    public static Employee findEmployeeWithMinSalary() {
        return Arrays.stream(employees)
                .filter(Objects::nonNull)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .get();
    }

    /*
    Find an employee with a maximum wage.
     */
    public static Employee findEmployeeWithMaxSalary() {
        return Arrays.stream(employees)
                .filter(Objects::nonNull)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .get();
    }

    /*
    Print the full name of all employees.
     */
    public static void printEmployeesFullName() {
        System.out.println("Список ФИО всех сотрудников:");
        Arrays.stream(employees)
                .filter(Objects::nonNull)
                .forEach(employee -> System.out.println(employee.getFullName()));
    }

    public static void main(String[] args) {
        employees[0] = new Employee("Голубев Касьян Михайлович", 1, 10_023);
        employees[1] = new Employee("Гурьев Федор Леонидович", 1, 15_023);
        employees[2] = new Employee("Аксёнов Аввакум Егорович", 1, 3_0132);
        employees[3] = new Employee("Стрелков Юлий Андреевич", 3, 21_125);
        employees[4] = new Employee("Гришин Савелий Валерьевич", 2, 21_500);
        printEmployeesList();
        System.out.println("Сумма всех заработных плат: " + calcTotalSalaries());
        System.out.println("Среднее значение зарплат: " + calcAverageSalary());
        System.out.println("Минимальная зарплата - " + findEmployeeWithMinSalary());
        System.out.println("Максимальная зарплата - " + findEmployeeWithMaxSalary());
        printEmployeesFullName();
    }
}