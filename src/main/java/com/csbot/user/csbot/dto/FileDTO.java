package com.csbot.user.csbot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileDTO {
    private String fileName;
    private String contentType;
    public FileDTO(String originalFilename, String contentType) {
        this.fileName = originalFilename;
        this.contentType = contentType;
    }
}
