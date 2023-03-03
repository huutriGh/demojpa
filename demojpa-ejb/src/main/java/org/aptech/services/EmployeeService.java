package org.aptech.services;

import org.aptech.entites.Employee;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface EmployeeService {
    public List<Employee> getAllEmployee();

    public Employee getEmployeeById(long id);

    public boolean addEmployee(Employee employee);

    public boolean updateEmployee(Employee employee);

    public boolean deleteEmployee(long id);

}
