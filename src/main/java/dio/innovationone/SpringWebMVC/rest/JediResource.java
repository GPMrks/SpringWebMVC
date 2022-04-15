package dio.innovationone.SpringWebMVC.rest;

import dio.innovationone.SpringWebMVC.model.Jedi;
import dio.innovationone.SpringWebMVC.service.JediService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JediResource {

    private JediService jediService;

    @GetMapping("/api/jedi")
    @ResponseStatus(HttpStatus.OK)
    public List<Jedi> getAllJedi(){
        return jediService.findAllList();
    }

    @GetMapping("/api/jedi/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Jedi getJedi(@PathVariable("id") Long id){
        return jediService.getById(id);
    }

}
