package uk.co._4loop.redis.service;

import uk.co._4loop.redis.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();

    List<Employee> getEmployees(String id);

    void saveEmployee(Employee employee);

    void deleteEmployee(String id);
}
