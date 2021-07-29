package uk.co._4loop.redis.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.co._4loop.redis.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {
}

