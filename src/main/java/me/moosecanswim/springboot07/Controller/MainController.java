package me.moosecanswim.springboot07.Controller;

import me.moosecanswim.springboot07.TvShow;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainController {

    @GetMapping("/tvform")
    public String loadTVForm(Model model){
        model.addAttribute("tvshow", new TvShow());
        return "tvform";
    }
    @PostMapping("/tvform")
    public String porcessTVForm(@Valid @ModelAttribute("tvshow") TvShow tvshow, BindingResult result){
        System.out.println("the tv shows name is: " + tvshow.getName());
        if(result.hasErrors()){
           // System.out.println("***your issue*** " + result.toString());
            return"tvform";
        }return"confirmshow";
    }
}
