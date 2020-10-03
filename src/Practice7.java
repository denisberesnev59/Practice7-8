import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Practice7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count_of_managers;
        int count_of_TopManagers;
        int count_of_operators;

        Company company = new Company();

        System.out.println("Сколько менеджеров нанять: ");
        count_of_managers = in.nextInt();
        company.hireAll("Manager", count_of_managers);

        System.out.println("Сколько топ менеджеров нанять: ");
        count_of_TopManagers = in.nextInt();
        company.hireAll("TopManager", count_of_TopManagers);

        System.out.println("Сколько операторов нанять: ");
        count_of_operators = in.nextInt();
        company.hireAll("Operator", count_of_operators);

        company.sorting(count_of_managers, count_of_TopManagers, count_of_operators);
    }
}

class Employee{

    Random r = new Random();

    String first_name;
    String second_name;
    String position;
    double baseSalary;
    double salary;

    String manager_getJobTitle(){
        Manager manager_getJobTitle = new Manager();
        return manager_getJobTitle.getJobTitle();
    }
    double manager_calcSalary(){
        baseSalary = r.nextInt(20001)+30000;

        Manager manager_calcSalary =new Manager();
        return manager_calcSalary.calcSalary(baseSalary);
    }


    String top_manager_getJobTitle(){
        Operator top_manager_getJobTitle = new Operator();
        return top_manager_getJobTitle.getJobTitle();
    }
    double top_manager_calcSalary(){
        baseSalary = r.nextInt(40001)+100000;
        Operator top_manager_calcSalary = new Operator();

        return top_manager_calcSalary.calcSalary(baseSalary);
    }


    String operator_getJobTitle(){
        Operator operator_getJobTitle = new Operator();
        return operator_getJobTitle.getJobTitle();
    }
    double operator_calcSalary(){
        baseSalary = r.nextInt(10001)+20000;
        Operator operator_calcSalary = new Operator();

        return operator_calcSalary.calcSalary(baseSalary);
    }




    List<Employee> getTopSalaryStaff(int count){
        List<Employee> getTopSalary_List = new ArrayList<>(count);
        return getTopSalary_List;

    }

    List<Employee> getLowestSalaryStaff(int count){
        List<Employee> getLowestSalary_List = new ArrayList<>(count);
        return getLowestSalary_List;
    }

}

interface EmployeePosition{
    Random r = new Random();

    String getJobTitle();
    double calcSalary(double baseSalary);
}

class Manager implements EmployeePosition{

    @Override
    public String getJobTitle() {
        return "manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        double salary;
        salary = baseSalary + 0.05*(r.nextInt(25000)+115000);

        return salary;
    }
}

class TopManager implements EmployeePosition{

    @Override
    public String getJobTitle() {
        return "top manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        double salary;
        Company income = new Company();
        if(income.getIncome()>10000000){
            salary = baseSalary + 1.5*baseSalary;
        }else salary = baseSalary;

        return salary;
    }
}

class Operator implements EmployeePosition{

    @Override
    public String getJobTitle() {
        return "operator";
    }

    @Override
    public double calcSalary(double baseSalary) {
        double salary;
        salary = baseSalary;

        return salary;
    }
}

class Company{

    Random r = new Random();

    void hire(){

    }

    void hireAll(String EmployeePosition, int count){

        String[] first_names = new String[] {"Wilfrid", "Michael", "Jason", "Francis", "Reynard"};
        String[] second_names = new String[] {"Griffin", "Beasley", "Sanders", "Flowers", "Kelly"};

        switch (EmployeePosition){
            case ("Manager"):
                Employee[] manager = new Employee[count];
                for(int i=0; i<count; i++){
                    manager[i].first_name = first_names[r.nextInt(5)];
                    manager[i].second_name = second_names[r.nextInt(5)];
                    manager[i].position = manager[i].manager_getJobTitle();
                    manager[i].salary = manager[i].manager_calcSalary();
                }
                //break;
            case ("TopManager"):
                Employee[] top_managers = new Employee[count];
                for(int i=0; i<count; i++){
                    top_managers[i].first_name = first_names[r.nextInt(5)];
                    top_managers[i].second_name = second_names[r.nextInt(5)];
                    top_managers[i].position = top_managers[i].top_manager_getJobTitle();
                    top_managers[i].salary = top_managers[i].top_manager_calcSalary();
                }
                //break;
            case ("Operator"):
                Employee[] operators = new Employee[count];
                for(int i=0; i<count; i++){
                    operators[i].first_name = first_names[r.nextInt(5)];
                    operators[i].second_name = second_names[r.nextInt(5)];
                    operators[i].position = operators[i].operator_getJobTitle();
                    operators[i].salary = operators[i].operator_calcSalary();
                }
                //break;
        }


    }

    void fire(){

    }

    double getIncome(){
        double income;
        income = r.nextInt(4000000)+8000000;

        return income;
    }

    void sorting(int a, int b, int c){
        int count_of_employees;
        count_of_employees = a+b+c;

        Employee TopSorting = new Employee();
        Employee LowestSorting = new Employee();

        System.out.println(TopSorting.getTopSalaryStaff(count_of_employees));
        System.out.println(LowestSorting.getLowestSalaryStaff(count_of_employees));

    }
}