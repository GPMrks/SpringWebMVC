package dio.innovationone.SpringWebMVC.controller;

import dio.innovationone.SpringWebMVC.model.Jedi;
import dio.innovationone.SpringWebMVC.service.JediService;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JediController {

    private JediService jediService;

    @GetMapping("/jedi")
    public ModelAndView jedi() {
        return jediService.getAllJedi();
    }

    @GetMapping("/new-jedi")
    public String newJediView(Model model) {
        return jediService.newJediView(model);
    }

    @GetMapping("/jedi/{id}/delete")
    public String deleteJedi(@PathVariable("id") final Long id, RedirectAttributes redirectAttributes) {

        final Optional<Jedi> jedi = Optional.ofNullable(jediService.getById(id));
        jediService.deleteJedi(id);

        redirectAttributes.addFlashAttribute("message", "Jedi removido com sucesso.");
        return "redirect:/jedi" ;
    }

    @PostMapping("/jedi")
    public String createJedi(@Valid @ModelAttribute Jedi jedi, @NotNull BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        return jediService.createJedi(jedi, bindingResult, redirectAttributes);
    }

}
