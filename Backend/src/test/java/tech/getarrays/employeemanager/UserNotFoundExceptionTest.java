package tech.getarrays.employeemanager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import tech.getarrays.employeemanager.exception.UserNotFoundException;

@SpringBootTest
public class UserNotFoundExceptionTest {

    @Test
    public void testUserNotFoundException() {
        String message = "User not found";
        UserNotFoundException exception = new UserNotFoundException(message);
        assertEquals(message, exception.getMessage());
        assertThrows(UserNotFoundException.class, () -> {
            throw exception;
        });
    }
}

