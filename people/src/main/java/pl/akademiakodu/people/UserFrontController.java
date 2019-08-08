package pl.akademiakodu.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserFrontController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String all(ModelMap map){
        map.put("users",userRepository.findAll());
        return "all";
    }

    @GetMapping("/users/{id}")
    public String show(@PathVariable Integer id, ModelMap map){
        map.put("user",userRepository.findById(id).get());
        return "show";
    }

//    @GetMapping("/form")
//    public String submit(){
//        return "form";
//    }

    /*
    User user = new User();
    user.setEmail(params[:email])
    user.setName(params[:name])
     */

    @PostMapping("/users")
    public String create(@ModelAttribute User user){
        userRepository.save(user);
        return "redirect:/users";
    }

   @GetMapping("/users/{id}/edit")
    public String edit(@PathVariable Integer id,ModelMap map){
        map.put("user",userRepository.findById(id));

        return "form";
   }
    @GetMapping("/")
    public String add(ModelMap map){
        map.put("user", new User());
        return "form";
    }

    @GetMapping("/users/{id}/destroy")
    public String destroy(@PathVariable Integer  id,ModelMap map) {
        userRepository.deleteById(id);
        return "redirect:/users";
    }


}
