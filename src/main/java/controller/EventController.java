package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by【王耀冲】on 【2017/4/14】 at 【12:39】.
 */
@Controller
public class EventController {
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
