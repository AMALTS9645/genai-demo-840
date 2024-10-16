 // code-start
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;
import javax.validation.ConstraintViolationException;

@SpringBootApplication
public class LoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }
}

@RestController
@RequestMapping("/api/login")
@Validated
public class LoginController {

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> login(@RequestParam("username") @Size(min = 1, max = 50) String username,
                                       @RequestParam("password") @Size(min = 1, max = 50) String password) {
        // Validate user credentials
        boolean isValidUser = UserService.validateUserCredentials(username, password);

        if (isValidUser) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    }
}

@Service
public class UserService {

    public boolean validateUserCredentials(String username, String password) {
        // Implement user validation logic here
        // Use parameterized queries or ORM to prevent SQL injection
        // Avoid hardcoding sensitive information
        return true; // Placeholder for actual implementation
    }
}
// code-end