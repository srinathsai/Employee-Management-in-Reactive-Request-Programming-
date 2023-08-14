package Spring.reactive.springboot.webflux.service.impl;

import Spring.reactive.springboot.webflux.dto.EmployeeDto;
import Spring.reactive.springboot.webflux.entity.Employee;
import Spring.reactive.springboot.webflux.mapper.EmployeeMapper;
import Spring.reactive.springboot.webflux.repository.EmployeeRepository;
import Spring.reactive.springboot.webflux.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Mono<Employee> savedEmployee = employeeRepository.save(employee); // in reactive request programmingwe get mono class from crud repository methods.
        return savedEmployee.map((x)->EmployeeMapper.mapToEmployeeDto(x)); // we use lambda expression to convert every item of employee to employeedto using map function provided by Mono class;


    }

    @Override
    public Mono<EmployeeDto> getEmployee(String employeeId) {
        Mono<Employee> savedEmployee = employeeRepository.findById(employeeId);
        return savedEmployee.map((x)->EmployeeMapper.mapToEmployeeDto(x));
    }

    @Override
    public Flux<EmployeeDto> getAllEmployees() {              // here Flux<T> is a class that can store list of employees.
        Flux<Employee> employees = employeeRepository.findAll();
        return employees.map((x)-> EmployeeMapper.mapToEmployeeDto(x)).switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto, String id) {
        Mono<Employee> employee = employeeRepository.findById(id);
        //used flatmap function to set or update employee.
        Mono<Employee> updatedEmployee = employee.flatMap((x)-> {x.setFirstName(employeeDto.getFirstName());x.setLastName(employeeDto.getLastName());x.setEmail(employeeDto.getEmail()); return employeeRepository.save(x);});

        return updatedEmployee.map((x)->EmployeeMapper.mapToEmployeeDto(x));
    }

    @Override
    public Mono<Void> deleteEmployee(String id) {
        return employeeRepository.deleteById(id);
    }
}
