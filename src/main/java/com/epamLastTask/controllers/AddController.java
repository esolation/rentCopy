package com.epamLastTask.controllers;

import com.epamLastTask.domains.Order;
import com.epamLastTask.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AddController {
    @Autowired
    private OrderRepo orderRepo;
    @Value("${upload.path}")
    private String uploadPath;
    @PostMapping("/addImage")
    public String addOrder(
            @RequestParam("file") MultipartFile[] file,
            Order order
            ) throws IOException {
        for(MultipartFile fileName:file){
            if( !fileName.getOriginalFilename().isEmpty()){
                File uploadDir = new File(uploadPath);
                if(!uploadDir.exists())
                    uploadDir.mkdir();
                String uuidFile = UUID.randomUUID().toString();
                String resultFileName = uuidFile + "." + fileName.getOriginalFilename();
                fileName.transferTo(new File(uploadPath+"/"+resultFileName));
                order.setPhotos(resultFileName);
                order.setActive(true);
        }
        }
        orderRepo.save(order);
        return "redirect:hello";
    }
    @GetMapping("/addImage")
    public String addImg(){

        return "addImage";
    }
}
