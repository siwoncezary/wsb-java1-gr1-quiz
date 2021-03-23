package pl.wsb.quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.wsb.quiz.entity.Quiz;
import pl.wsb.quiz.entity.User;
import pl.wsb.quiz.repository.QuizRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Controller
public class HomeController {
    final QuizRepository repository;
    @Autowired
    public HomeController(QuizRepository repository, EntityManager entityManager) {
        this.repository = repository;
    }


    @GetMapping("/")
    public String hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        System.out.println("INDEX");
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam int a, @RequestParam int b){
        return "Wynik " + (a+b);
    }
}
