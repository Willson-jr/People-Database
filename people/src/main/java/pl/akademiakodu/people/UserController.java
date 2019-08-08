package pl.akademiakodu.people;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class UserController {

    /*
    Fabryka Springa szuka klasy ktora implementuje interfejs UserRepository i ktora jest Beanem;
    OK Fabryka nie znajduje takiego Beana.
    Zgadza sie?
    Tak? :slightly_smiling_face:
    Ale nie generuje błedu tylko bierze generacje klasy i tworzenie Beana na swoja klate :smile:
    w locie generuje sobie taka klase za nas!
     */

    @Autowired
    private UserRepository userRepository;

    @ResponseBody// zwraa Stringa
    @GetMapping("add")
    public String add(@RequestParam String name, @RequestParam String email){
        User user= new User();
        user.setEmail(email);
        user.setName(name);
        userRepository.save(user);
        return "saved";
    }

    @ResponseBody
    @GetMapping("/all")
    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }







}