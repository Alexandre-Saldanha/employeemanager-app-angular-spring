package tech.getarrays.employeemanager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repo.EmployeeRepo;
import tech.getarrays.employeemanager.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

    @MockBean
    private EmployeeRepo employeeRepo;

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testAddEmployee() {
        
        Employee employee = new Employee(1L, "João", "joao@gmail.com", "Desenvolvedor", "9999-9999", "joao.jpg", null);    
        Mockito.when(employeeRepo.save(employee)).thenReturn(new Employee(1L, "João", "joao@gmail.com", "Desenvolvedor", "9999-9999", "joao.jpg", "EMP001"));
        Employee added = employeeService.addEmployee(employee);
        assertNotNull(added);
        assertNotNull(added.getEmployeeCode());
    }

    @Test
    public void testFindAllEmployees() {
        List<Employee> employees = Arrays.asList(
                new Employee(1L, "João", "joao@gmail.com", "Desenvolvedor", "9999-9999", "joao.jpg", "EMP001"),
                new Employee(2L, "Maria", "maria@gmail.com", "Analista", "8888-8888", "maria.jpg", "EMP002")
        );

        Mockito.when(employeeRepo.findAll()).thenReturn(employees);
        List<Employee> found = employeeService.findAllEmployees();
        assertNotNull(found);
        assertEquals(employees.size(), found.size());
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = new Employee(1L, "João", "joao@gmail.com", "Desenvolvedor", "9999-9999", "joao.jpg", "EMP001");
        Mockito.when(employeeRepo.save(employee)).thenReturn(employee);
        Employee updated = employeeService.updateEmployee(employee);
        assertNotNull(updated);
        assertEquals(employee, updated);
    }

    @Test
    public void testFindEmployeeById() {
        Employee employee = new Employee(1L, "João", "joao@gmail.com", "Desenvolvedor", "9999-9999", "joao.jpg", "EMP001");
        Mockito.when(employeeRepo.findEmployeeById(1L)).thenReturn(Optional.of(employee));
        Employee found = employeeService.findEmployeeById(1L);
        assertNotNull(found);
        assertEquals(employee, found);
    }

    @Test
    public void testFindEmployeeByIdNotFound() {
        Mockito.when(employeeRepo.findEmployeeById(1L)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> employeeService.findEmployeeById(1L));
    }

    @Test
    public void testDeleteEmployee() {
        Mockito.doNothing().when(employeeRepo).deleteEmployeeById(1L);
        employeeService.deleteEmployee(1L);
        Mockito.verify(employeeRepo, Mockito.times(1)).deleteEmployeeById(1L);
    }
}
