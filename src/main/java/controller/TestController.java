package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
@Controller
public class TestController {
    @RequestMapping("/test")
    @ResponseBody
    public String test(HttpServletRequest httpRequest){
        System.out.println(httpRequest);
        return "test ok";
    }


}
