package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Employee {

    String name;
    int salary;
    public enum Gender{
        MALE,FEMALE
    }
    Gender gender;

    public Employee(String name, int salary, Gender gender) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

class EmployeeTest{
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("David", 3000, Employee.Gender.MALE),
                new Employee("Marry", 2500, Employee.Gender.FEMALE),
                new Employee("Clark", 3500, Employee.Gender.MALE),
                new Employee("Andy", 4500, Employee.Gender.MALE),
                new Employee("Sara", 2000, Employee.Gender.FEMALE)
        );

        Optional<Employee> highestSalary = employees.stream().reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2);
        highestSalary.ifPresent(e -> System.out.println("Name "+e.getName()+" Salary "+e.getSalary()));

        Integer totalSalaries = employees.stream().map(Employee::getSalary).reduce(0, Integer::sum);
        System.out.println("totalSalaries "+totalSalaries);

        String allEmployees = employees.stream().map(Employee::getName).reduce("", (name1, name2) -> name1 + " " + name2);
        System.out.println("allEmployees "+allEmployees.trim());
    }
}
