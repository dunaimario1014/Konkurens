package gyak01;
import java.util.*;
abstract class Employee{
    private String name;
    private double salary;

    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public abstract double getSalary();

    public void raiseSalary(double percent){
        this.salary += this.salary * (percent / 100);
    }

}


    class Manager extends Employee{

        public List<Employee> employees = new ArrayList<>();

        public void addEmployee(Employee employee){
                employees.add(employee);
        }

        public void removeEmployee(Employee employee){
            employees.remove(employee);
        }

        @Override
        public double getSalary(){
            double sum  = 0;
            for (Employee e : employees){
                sum += e.salary;
            }
            return this.salary + sum;
        }

    }

    class Subordinate extends Employee{
        public double getSalary(){
            return salary;
        }
    }

    public class Main{
        public static void main(String[] args){

            Employee emp = new Employee("Rudika", 5000.00);

            System.out.println("Jelenleg " + emp.getName() + " nevű munkavállaló " + emp.getSalary() + " forintot keres.");
            System.out.println("Emelés...");
            emp.raiseSalary(10);
            System.out.println("Jelenleg " + emp.getName() + " nevű munkavállaló " + emp.getSalary() + " forintot keres.");
        }
    }

