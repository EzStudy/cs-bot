package com.csbot.user.csbot.global.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardResponseDto {
    private String description;
    private List<BaseResponseDto> buttons;
}
