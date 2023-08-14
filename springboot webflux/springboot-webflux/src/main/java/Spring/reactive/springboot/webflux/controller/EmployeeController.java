package Spring.reactive.springboot.webflux.controller;

import Spring.reactive.springboot.webflux.dto.EmployeeDto;
import Spring.reactive.springboot.webflux.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(value=HttpStatus.CREATED)
    public Mono<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
         return employeeService.saveEmployee(employeeDto);  // for reactive request programming return type must be generic Mono class.
    }

    @GetMapping("{id}")
    public Mono<EmployeeDto>getEmployee(@PathVariable("id") String employeeid){ // for returning a employee with a id.
        return employeeService.getEmployee(employeeid);
    }

    @GetMapping
    public Flux<EmployeeDto> getAllEmployees(){  // for returning all the employees.
        return employeeService.getAllEmployees();
    }
    @PutMapping("{id}")
    public Mono<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto,@PathVariable("id") String id){
        return employeeService.updateEmployee(employeeDto,id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public Mono<Void> deleteEmployee(@PathVariable("id") String id){
        return employeeService.deleteEmployee(id);
    }
}
