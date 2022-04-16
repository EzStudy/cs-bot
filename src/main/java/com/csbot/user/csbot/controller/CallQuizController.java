package com.csbot.user.csbot.controller;

import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallQuizController {

    @PostMapping("/CallQuiz")
    public String callQuiz(@RequestBody Map<String, Object> param ,HttpServletRequest req, HttpServletResponse resp){
        for(Entry<String,Object> p : param.entrySet()){
            System.out.println("key : " +p.getKey());
            System.out.println("value : " + p.getValue());
        }
        System.out.println("Post called");
        return "quiz";
    }
}
