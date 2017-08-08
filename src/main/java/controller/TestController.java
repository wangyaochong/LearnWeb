package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequestMapping("/testParam")
    @ResponseBody
    public String testParam(@RequestParam("integer") Integer integerParam){
        return "integer value: "+Integer.toString(integerParam);
    }
    @RequestMapping("/testPathParam/{integer}")
    @ResponseBody
    public String testPathParam(@PathVariable("integer") Integer integerParam){
        return "integer value: "+Integer.toString(integerParam);
    }
}
