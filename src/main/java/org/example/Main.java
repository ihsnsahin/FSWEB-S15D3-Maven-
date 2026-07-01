package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));
    }
    public static List<Employee> findDuplicates(List<Employee> list) {
        List<Employee> repeatedEmployees = new LinkedList<>();
        Map <Integer, Employee> uniqueEmployees = new HashMap<>();

        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            Employee employee = (Employee) iterator.next();
            if (employee == null) continue;
            if(uniqueEmployees.containsKey(employee.getId()))  {
                repeatedEmployees.add(employee);
            } else {
                uniqueEmployees.put(employee.getId(), employee);
            }
        }

        return repeatedEmployees;
    }
    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> uniquesEmployee = new HashMap<>();
        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            Employee employee = (Employee) iterator.next();
            if (employee == null) continue;
            uniquesEmployee.put(employee.getId(), employee);
        }
        return uniquesEmployee;
    }
    public static List<Employee> removeDuplicates(List<Employee> employees) {
        /*List<Employee> removedEmployees = new LinkedList<>();
        Map <Integer, Employee> uniqueEmployees = new HashMap<>();

        Iterator iterator = employees.iterator();
        while(iterator.hasNext()) {
            Employee employee = (Employee) iterator.next();
            if (employee == null) continue;
            if(uniqueEmployees.containsKey(employee.getId()))  {
                if(!removedEmployees.contains(employee)) {
                    removedEmployees.add(employee);
                }
            } else {
                uniqueEmployees.put(employee.getId(), employee);
            }
        }
        employees.removeAll(removedEmployees);
        employees.remove(null);
        return employees;*/

        List<Employee> duplicatedEmployees = findDuplicates(employees);
        Map <Integer, Employee> uniqueEmployees = findUniques(employees);
        List<Employee> uniqueEmployeesList = new ArrayList<>(uniqueEmployees.values());
        uniqueEmployeesList.removeAll(duplicatedEmployees);
        return uniqueEmployeesList;

    }
}