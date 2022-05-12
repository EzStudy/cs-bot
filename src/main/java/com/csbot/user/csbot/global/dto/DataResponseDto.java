package com.csbot.user.csbot.global.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataResponseDto {
    private String blockId;
    private ExtraResponseDto extra;
}
