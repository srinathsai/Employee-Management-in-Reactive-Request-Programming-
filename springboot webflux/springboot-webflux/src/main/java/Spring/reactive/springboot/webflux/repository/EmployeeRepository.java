package Spring.reactive.springboot.webflux.repository;

import Spring.reactive.springboot.webflux.entity.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee,String> {

}
// Like Jpa repository we will extend from ReactiveCrudRepository which will extend from reactiveMongorepository .Here all the methods are aschynchronous meaning they will
// return either the type Flux or Mono
