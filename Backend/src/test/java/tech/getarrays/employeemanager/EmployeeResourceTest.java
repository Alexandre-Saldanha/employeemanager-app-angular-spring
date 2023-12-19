package tech.getarrays.employeemanager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.resource.EmployeeResource;
import tech.getarrays.employeemanager.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class EmployeeResourceTest {

    @InjectMocks
    private EmployeeResource employeeResource;
    
    @Mock
    private EmployeeService employeeService;
    private Employee employee1;
    private Employee employee2;
    private List<Employee> employeeList;

    @BeforeEach
    public void setUp() {
        employee1 = new Employee(1L, "Alex", "alex@gmail.com", "Developer", "123456789", "https://example.com/alex.jpg", "EMP001");
        employee2 = new Employee(2L, "Bob", "bob@yahoo.com", "Manager", "987654321", "https://example.com/bob.jpg", "EMP002");
        employeeList = Arrays.asList(employee1, employee2);
    }

    @Test
    public void getAllEmployeesTest() {
        when(employeeService.findAllEmployees()).thenReturn(employeeList);
        ResponseEntity<List<Employee>> response = employeeResource.getAllEmployees();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employeeList, response.getBody());
    }

    @Test
    public void getEmployeeByIdTest() {
        when(employeeService.findEmployeeById(1L)).thenReturn(employee1);
        ResponseEntity<Employee> response = employeeResource.getEmployeeById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employee1, response.getBody());
    }
    
    @Test
    public void addEmployeeTest() {
        when(employeeService.addEmployee(employee1)).thenReturn(employee1);
        ResponseEntity<Employee> response = employeeResource.addEmployee(employee1);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(employee1, response.getBody());
    }

    @Test
    public void updateEmployeeTest() {
        when(employeeService.updateEmployee(employee1)).thenReturn(employee1);
        ResponseEntity<Employee> response = employeeResource.updateEmployee(employee1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employee1, response.getBody());
    }
    
    @Test
    public void deleteEmployeeTest() {
        Mockito.doThrow(new RuntimeException("Delete failed")).when(employeeService).deleteEmployee(1L);
        assertThrows(RuntimeException.class, () -> employeeResource.deleteEmployee(1L));
    }

}

