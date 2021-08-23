package GoogleProblems;

import java.util.HashMap;
import java.util.List;



public class LC0690EmployeeImportance {
	
	//min space
    public int importance;
    public List<Employee> employees;
    
    //min time
    public HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
    
    //This solution uses minimal space
    public int getImportanceMinSpaceComplexity(List<Employee> employees, int id) {
        this.importance = 0;
        this.employees = employees; 
        
        Employee boss = findEmployee(id);
        helperMinSpace(boss.subordinates, boss);
        
        return importance;
        
    }
    
    
    public void helperMinSpace(List<Integer> subordinates, Employee emp) {
        this.importance = importance + emp.importance;
        if (!subordinates.isEmpty()) {
            for (int i = 0; i < emp.subordinates.size(); i++) {
                Employee sub = findEmployee(subordinates.get(i));
                helperMinSpace(sub.subordinates, sub);
            }
        }

    }
    
    
    //This solution uses minimal time
    public int getImportance(List<Employee> employees, int id) {
        
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }
        
        return helperMinTime(map.get(id).subordinates, map.get(id), 0);
           
    }
    
    
    public int helperMinTime(List<Integer> subordinates, Employee emp, int importance) {
        int newImportance = importance + emp.importance;
        if (!subordinates.isEmpty()) {
            for (Integer id : subordinates) {
               newImportance += helperMinTime(map.get(id).subordinates, map.get(id), importance);
            }
        }
        return newImportance;
        
        

    }
    
    
    public Employee findEmployee(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).id == id) {
                return employees.get(i);
            }
        }
        
        return null;
    }
    
    
    
    public class Employee {
    	int id;
    	int importance;
    	List<Integer> subordinates;
    }
    
    public static void main(String[] args) {
    	
    	
    	
    }
    

}
