package uk.co._4loop.redis.controller;

import org.springframework.web.bind.annotation.*;
import uk.co._4loop.redis.model.Employee;
import uk.co._4loop.redis.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping("ping")
    public String ping() {
        return "Hello";
    }

    @GetMapping("employees")
    public List<Employee> allEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("employee/{id}")
    public List<Employee> allEmployeeByID(@PathVariable("id") String id) {
        return employeeService.getEmployees(id);
    }

    @PostMapping("create")
    public void saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
    }

    @PostMapping("update/{id}")
    public void updateEmployee(@PathVariable("id") String id, @RequestBody Employee employee) {
        employee.setId(id);
        employeeService.saveEmployee(employee);
    }

    @DeleteMapping("delete/{id}")
    public void deleteEmployee(@PathVariable("id") String id) {
        employeeService.deleteEmployee(id);
    }

}
