package controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class TestController {
    @RequestMapping("/test")
    @ResponseBody
    public String test(HttpServletRequest httpRequest){
        System.out.println(httpRequest);
        return "test ok";
    }

    static int counter=0;
    @RequestMapping("/eventSource")
    public void eventSource(HttpServletResponse response){
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println("data:counter started");
        out.println("event:load");
        out.println("id:140312");
        out.println();//一定要多打一个空行不然不起作用
        out.flush();
        while (true) {
            out.println("data:counter-->" + counter++);
            out.println("event:message");
            out.println("id:140312");
            out.println();
            out.flush();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
