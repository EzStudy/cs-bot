package com.csbot.user.csbot.domain.quiz.controller;

import com.csbot.user.csbot.domain.quiz.service.QuizService;
import com.csbot.user.csbot.global.dto.ContentResponseDto;
import com.csbot.user.csbot.global.dto.SimpleTextResponseDto;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {

    @Autowired
    QuizService quizService;
    @PostMapping("/CallQuiz")
    public Map<String, List<ContentResponseDto>> callQuiz(@RequestBody Map<String, Object> body, HttpServletResponse response){
        Map<String, Object> body2 = (Map<String, Object>) body.get("userRequest");
        String utterance = body2.get("utterance").toString();

        System.out.println("Utterance : " + utterance);

        System.out.println("Called callQuiz");

        return quizService.makeQuizBlock();
    }

    @PostMapping("/checkAnswer")
    public SimpleTextResponseDto checkAnswer(@RequestBody Map<String, Object> body){
        Map<String, Object> body2 = (Map<String, Object>) body.get("userRequest");
        String utterance = body2.get("utterance").toString();

        SimpleTextResponseDto result = new SimpleTextResponseDto();
        if("1. jvm".equals(utterance)) {
            result.setSimpleText("정답입니다.!!");
            return result;
        }else{
            result.setSimpleText("오답입니다.!!");
            return result;
        }
    }
}

//{block={id=623ea0893639626c92ed7c68, name=문제 풀기 블록 스킬 서버}, user={id=2674bbc5576b7cea3564cf8c6d3fdc4aeb26d4612a0afc0e4c009a0754ebc61b63, type=botUserKey, properties={botUserKey=2674bbc5576b7cea3564cf8c6d3fdc4aeb26d4612a0afc0e4c009a0754ebc61b63, isFriend=true, plusfriendUserKey=C0OUcNEy1kA0, bot_user_key=2674bbc5576b7cea3564cf8c6d3fdc4aeb26d4612a0afc0e4c009a0754ebc61b63, plusfriend_user_key=C0OUcNEy1kA0}}, utterance=문제 풀기 스킬 서버, params={surface=Kakaotalk.plusfriend}, lang=ko, timezone=Asia/Seoul}
