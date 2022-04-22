package com.csbot.user.csbot.global.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContentResponseDto {
    private String type;
    private List<CardResponseDto> cards;
}
