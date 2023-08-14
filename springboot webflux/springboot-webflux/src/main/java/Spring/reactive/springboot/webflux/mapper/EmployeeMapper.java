package Spring.reactive.springboot.webflux.mapper;

import Spring.reactive.springboot.webflux.dto.EmployeeDto;
import Spring.reactive.springboot.webflux.entity.Employee;

public class EmployeeMapper {

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmail());
        return employee;
    }

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        EmployeeDto employeeDto=new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
        return employeeDto;
    }
}
