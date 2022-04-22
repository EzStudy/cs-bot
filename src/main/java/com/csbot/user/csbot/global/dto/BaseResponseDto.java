package com.csbot.user.csbot.global.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponseDto {
    private String type;
    private String label;
    private String action;
    private DataResponseDto data;
}
