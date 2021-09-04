package pl.coderslab.Spring01Hibernate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "to zyje";
    }
}
