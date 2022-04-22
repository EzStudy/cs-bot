package com.csbot.user.csbot.domain.quiz.service;

import com.csbot.user.csbot.global.dto.BaseResponseDto;
import com.csbot.user.csbot.global.dto.CardResponseDto;
import com.csbot.user.csbot.global.dto.ContentResponseDto;
import com.csbot.user.csbot.global.dto.DataResponseDto;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    public Map<String, List<ContentResponseDto>> makeQuizBlock(){

        //버튼 생성
        List<BaseResponseDto> buttons = makeButton();
        //카드 생성
        List<CardResponseDto> cards = makeCard(buttons);

        //content 생성
        ContentResponseDto content = new ContentResponseDto();
        content.setType("card.text");
        content.setCards(cards);

        Map<String, List<ContentResponseDto>> contents = new HashMap<>();
        contents.put("contents",Arrays.asList(content));

        return contents;
    }

    private List<CardResponseDto> makeCard(List<BaseResponseDto> buttons) {
        CardResponseDto card = new CardResponseDto();
        card.setDescription("문제내용");
        card.setButtons(buttons);
        return Arrays.asList(card);
    }

    private List<BaseResponseDto> makeButton() {
        //make button 4
        BaseResponseDto button1 = BaseResponseDto.builder()
            .type("block")
            .label("1. jvm")
            .action("block")
            .data(new DataResponseDto()).build();
        BaseResponseDto button2 = BaseResponseDto.builder()
            .type("block")
            .label("2. linux")
            .action("block")
            .data(new DataResponseDto()).build();
        BaseResponseDto button3 = BaseResponseDto.builder()
            .type("block")
            .label("3. unix")
            .action("block")
            .data(new DataResponseDto()).build();
        BaseResponseDto button4 = BaseResponseDto.builder()
            .type("block")
            .label("4. cpu")
            .action("block")
            .data(new DataResponseDto()).build();
        List<BaseResponseDto> buttons = Arrays.asList(button1, button2, button3, button4);
        return buttons;
    }
}
