package dio.innovationone.SpringWebMVC.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class JediNotFoundException extends RuntimeException{
    public JediNotFoundException(Long id){
        super("Jedi not found with ID " + id);
    }
}
