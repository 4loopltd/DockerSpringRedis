package uk.co._4loop.redis.service;

import org.springframework.stereotype.Service;
import uk.co._4loop.redis.model.Employee;
import uk.co._4loop.redis.repo.EmployeeRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        return StreamSupport.stream(employeeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployees(String id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.isEmpty() ? Collections.emptyList() : List.of(employee.get());
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

}
