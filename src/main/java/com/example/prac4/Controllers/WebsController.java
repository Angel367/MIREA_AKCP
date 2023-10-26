package com.example.prac4.Controllers;

import com.example.prac4.Messages.Message;
import com.example.prac4.Messages.OutputMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/")
public class WebsController {
    private Integer userId = 0;
    @GetMapping("/webs")
    public ModelAndView webs() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("webs");
        return modelAndView;
    }
    @MessageMapping("/webs")
    @SendTo("/topic/webs-topic")
    public OutputMessage send(Message message)  {
        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        this.userId += 1;
        return new OutputMessage("user №" + this.userId, message.getText(), time);
    }
}
