package dio.innovationone.SpringWebMVC.service;

import dio.innovationone.SpringWebMVC.model.Jedi;
import dio.innovationone.SpringWebMVC.repository.JediRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JediService {

    private JediRepository jediRepository;

    public ModelAndView getAllJedi() {

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");

        modelAndView.addObject("allJedi", jediRepository.getAllJedi());

        return modelAndView;

    }

    public String newJediView(Model model) {
        model.addAttribute("jedi", new Jedi());
        return "new-jedi";
    }

    public void add(Jedi jedi) {
        jediRepository.add(jedi);
    }

    public String createJedi(Jedi jedi, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "new-jedi";
        }

        jediRepository.add(jedi);
        redirectAttributes.addFlashAttribute("message", "Jedi successfully created!");

        return "redirect:/jedi";

    }

}
