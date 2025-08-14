package streamAPI;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ReduceOperationWithCollect {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("David", "Clark", "Marry", "Sera", "Andy", "Marry");
        List<String> collectedNamesList = names.stream()
                .filter(name -> name.length() > 4)
                .collect(Collectors.toList());
        System.out.println("collectedNamesList " + collectedNamesList);

        Set<String> collectedNamesSet = names.stream()
                .filter(name -> name.length() > 4)
                .collect(Collectors.toSet());
        System.out.println("collectedNamesSet " + collectedNamesSet);

        String joinedNames = names.stream().collect(Collectors.joining(","));
        System.out.println("joinedNames " + joinedNames);//David,Clark,Marry,Sera,Andy,Marry

        String joinedNames2 = names.stream().collect(Collectors.joining(",", "{", "}"));
        System.out.println("joinedNames2 " + joinedNames2);//{David,Clark,Marry,Sera,Andy,Marry}

        //on cree une map avec en clé la longueur des noms et en valeur les nom qui ont pour longueur celle de la clé
        Map<Integer, List<String>> groupingByLength = names.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("groupingByLength " + groupingByLength);

        //on coupe la liste en deux : ceux qui respecte la condition et ceux qui ne la respecte pas
        Map<Boolean, List<String>> partitioningByLength = names.stream().collect(Collectors.partitioningBy(name -> name.length() > 4));
        System.out.println("partitioningByLength " + partitioningByLength);

        LinkedList<String> linkedListNames = names.stream().filter(name -> name.length() > 4).collect(Collectors.toCollection(LinkedList::new));
        System.out.println("linkedListNames " + linkedListNames);

        List<Employee> employees = Arrays.asList(
                new Employee("David", 3000, Employee.Gender.MALE),
                new Employee("Marry", 2500, Employee.Gender.FEMALE),
                new Employee("Clark", 3500, Employee.Gender.MALE),
                new Employee("Andy", 4500, Employee.Gender.MALE),
                new Employee("Sara", 2000, Employee.Gender.FEMALE)
        );

        //on peut mettre plusieurs aggregats dans un groupingBy
        Map<Employee.Gender, Integer> totalSalaryByGender = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.summingInt(Employee::getSalary)));
        System.out.println("totalSalaryByGender : " + totalSalaryByGender);

        SalaryCollector salaryCollector = employees.stream()
                .map(Employee::getSalary)
                .collect(SalaryCollector::new,
                        SalaryCollector::accept,
                        SalaryCollector::combine);

        System.out.println("total salary : " + salaryCollector.getTotal());

        Map<Employee.Gender, SalaryCollector> totalSalaryByGenderWithCustomController = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getGender,
                                Collectors.mapping(
                                        Employee::getSalary,
                                        Collector.of(
                                                SalaryCollector::new,
                                                SalaryCollector::accept,
                                                (s1, s2) -> {
                                                    s1.combine(s2);
                                                    return s1;
                                                }
                                        )
                                )
                        )
                );
        totalSalaryByGenderWithCustomController.forEach((g,s) -> System.out.println("Gender : "+g+" Salary : "+s.getTotal()));
    }
}
