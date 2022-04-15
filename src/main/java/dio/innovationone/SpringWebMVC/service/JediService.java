package dio.innovationone.SpringWebMVC.service;

import dio.innovationone.SpringWebMVC.exception.JediNotFoundException;
import dio.innovationone.SpringWebMVC.model.Jedi;
import dio.innovationone.SpringWebMVC.repository.JediRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JediService {

    private JediRepository jediRepository;

    public List<Jedi> findAllList() {
        return jediRepository.findAll();
    }

    public ModelAndView getAllJedi() {

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");

        modelAndView.addObject("allJedi", jediRepository.findAll());

        return modelAndView;

    }


    public String newJediView(Model model) {
        model.addAttribute("jedi", new Jedi());
        return "new-jedi";
    }

    public Jedi add(Jedi jedi) {
        return jediRepository.save(jedi);
    }

    public String createJedi(Jedi jedi, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "new-jedi";
        }

        jediRepository.save(jedi);
        redirectAttributes.addFlashAttribute("message", "Jedi successfully created!");

        return "redirect:/jedi";

    }

    public Jedi createJedi(final Jedi jedi) {
        return jediRepository.save(jedi);
    }

    public Jedi getById(Long id) {

        final Optional<Jedi> jedi = jediRepository.findById(id);

        if (jedi.isPresent()) {
            return jedi.get();
        } else {
            throw new JediNotFoundException(id);
        }
    }

    public Jedi updateJedi(final Jedi jediDTO, final Long id){

        final Optional<Jedi> jediOptional = jediRepository.findById(id);
        final Jedi jedi;

        if(jediOptional.isPresent()){
            jedi = jediOptional.get();
        }
        else{
            throw new JediNotFoundException(id);
        }

        jedi.setName(jediDTO.getName());
        jedi.setLastName(jediDTO.getLastName());

        return jediRepository.save(jedi);
    }

    public void deleteJedi(Long id){
        final Jedi jedi = getById(id);
        jediRepository.delete(jedi);
    }
}
