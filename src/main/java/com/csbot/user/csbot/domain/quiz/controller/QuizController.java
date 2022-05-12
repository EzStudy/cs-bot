package com.csbot.user.csbot.domain.quiz.controller;

import com.csbot.user.csbot.domain.quiz.service.QuizService;
import com.csbot.user.csbot.global.dto.ContentResponseDto;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {

    @Autowired
    QuizService quizService;
    @PostMapping("/CallQuiz")
    public Map<String, List<ContentResponseDto>> callQuiz(HttpServletRequest request, HttpServletResponse response){
        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        body = stringBuilder.toString();
        System.out.println(body);

        System.out.println("Called callQuiz");

        Map<String, List<ContentResponseDto>> result = quizService.makeQuizBlock();
        String jsonToResult = new Gson().toJson(result);
        System.out.println(jsonToResult);
        return result;
    }
}
