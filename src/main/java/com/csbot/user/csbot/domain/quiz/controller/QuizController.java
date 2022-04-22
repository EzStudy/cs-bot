package com.csbot.user.csbot.domain.quiz.controller;

import com.csbot.user.csbot.domain.quiz.service.QuizService;
import com.csbot.user.csbot.global.dto.ContentResponseDto;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {

    @Autowired
    QuizService quizService;
    @PostMapping("/CallQuiz")
    public Map<String, List<ContentResponseDto>> callQuiz(){
        System.out.println("Called callQuiz");
        return quizService.makeQuizBlock();
    }
}
