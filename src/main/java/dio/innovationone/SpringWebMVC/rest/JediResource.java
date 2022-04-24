package dio.innovationone.SpringWebMVC.rest;

import dio.innovationone.SpringWebMVC.model.Jedi;
import dio.innovationone.SpringWebMVC.service.JediService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name = "Cadastro de Jedi", description = "CRUD Jedi")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JediResource {

    private JediService jediService;

    @GetMapping("/api/jedi")
    public List<Jedi> getAllJedi() {
        return jediService.findAllList();
    }

    @GetMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> getJedi(@PathVariable("id") Long id) {
        final Jedi jedi = jediService.getById(id);
        return ResponseEntity.ok(jedi);
    }

    @PostMapping("/api/jedi")
    @ResponseStatus(HttpStatus.CREATED)
    public Jedi createJedi(@Valid @RequestBody Jedi jedi) {
        return jediService.createJedi(jedi);
    }

    @PutMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> updateJedi(@Valid @RequestBody Jedi jediDTO, @PathVariable("id") Long id) {
        final Jedi jedi = jediService.updateJedi(jediDTO, id);
        return ResponseEntity.ok(jedi);
    }

    @DeleteMapping("/api/jedi/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJedi(@PathVariable("id") Long id) {
        jediService.deleteJedi(id);
    }

}
