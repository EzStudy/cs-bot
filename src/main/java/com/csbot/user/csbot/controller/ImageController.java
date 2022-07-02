package com.csbot.user.csbot.controller;

import com.csbot.user.csbot.dto.FileDTO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageController {

    @Value("${spring.servlet.multipart.location}")
    private String dir;

    @PostMapping("/upload")
    public List<FileDTO> upload(@RequestParam("uploadfile") MultipartFile[] uploadfile, Model model){
        List<FileDTO> list = new ArrayList<>();

        for(MultipartFile file: uploadfile){
            FileDTO dto = new FileDTO(UUID.randomUUID().toString(), file.getContentType());
            list.add(dto);
            File newFileName = new File(dto.getFileName());

            try{
                file.transferTo(newFileName);
            } catch (Exception e){
                e.printStackTrace();
            }
        }


        return list;
    }

    @GetMapping(value="/image/view", produces= {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
    public @ResponseBody byte[] getImage(@RequestParam("uuid") String uuid) // A
        throws IOException {
        FileInputStream fis = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        String fileDir = dir+"/"+uuid; // 파일경로

        try{
            fis = new FileInputStream(fileDir);
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }

        int readCount = 0;
        byte[] buffer = new byte[1024];
        byte[] fileArray = null;

        try{
            while((readCount = fis.read(buffer)) != -1){
                baos.write(buffer, 0, readCount);
            }
            fileArray = baos.toByteArray();
            fis.close();
            baos.close();
        } catch(IOException e){
            throw new RuntimeException("File Error");
        }
        return fileArray;
    }
}
