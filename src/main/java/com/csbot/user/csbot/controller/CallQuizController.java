package com.csbot.user.csbot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallQuizController {

    @PostMapping("/CallQuiz")
    public String callQuiz(HttpServletRequest req, HttpServletResponse resp){
        System.out.println(req);
        return "quiz";
    }
}
