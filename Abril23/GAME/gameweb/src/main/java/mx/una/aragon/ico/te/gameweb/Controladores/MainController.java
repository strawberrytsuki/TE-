package mx.una.aragon.ico.te.gameweb.Controladores;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/portal")
public class MainController {

    @GetMapping("/")
    public String index(){
        LoggerFactory.getLogger(MainController.class).info("Estamos en index");
        return "index";
    }
}
