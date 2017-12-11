import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        //Map<String,List<Integer>> x = new TreeMap<> ();
        List<String> myList = new ArrayList<String>();
        myList.add("one");
        myList.add("two");
        myList.add("three");

        List<Employee> empList = new ArrayList<Employee>();
        Employee e1= new Employee(1,"Hasan","Pune",12.5);
        Employee e2= new Employee(2,"Amir","Hyd",10.5);
        Employee e3= new Employee(3,"Bhushan","Bang",13.5);
        Employee e4= new Employee(12,"Amir","UP",11.7);
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);
        empList.add(e4);

        empList.forEach(System.out::print);//first feature

        // lsfmcC codeword

        int  sumOfId = empList.stream().filter(s->s.getEmpName().equals("Amir")).mapToInt(s->s.getId()).sum();

        int  x = empList.stream().mapToInt(s->s.getId()).max().getAsInt();

        String cocat = empList.stream().map(Employee::getAddress)
                .collect(Collectors.joining(", "));

        String listConcat = empList.stream().map(s->s.getEmpName())
                .collect(Collectors.joining(", "));

        String myListConcat = myList.stream().map(Object::toString)
                .collect(Collectors.joining(", "));

        Set<String> set = empList.stream().map(s->s.getEmpName()).collect(Collectors.toCollection(TreeSet::new));

        Double total = empList.stream().collect(Collectors.summingDouble(Employee::getSalary));

        Map<Boolean, List<Employee>> passingFailing =empList.stream().collect(Collectors.partitioningBy(s -> s.getId() >= 12));
        // Compute sum of salaries by department

        // Group employees by department
        /*Map<Department, List<Employee>> byDept
                = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));*/

        /*Map<Department, Integer> totalByDept
                = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingInt(Employee::getSalary)));
        */

    }
}
