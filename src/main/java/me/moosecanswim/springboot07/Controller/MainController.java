package me.moosecanswim.springboot07.Controller;

import me.moosecanswim.springboot07.TvShow;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String porcessTVForm(@Valid TvShow tvshow, BindingResult result){
        if(result.hasErrors()){
            return"tvform";
        }return"showconfirm";
    }
}
