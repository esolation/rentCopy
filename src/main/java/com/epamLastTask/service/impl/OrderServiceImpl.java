package com.epamLastTask.service.impl;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.User;
import com.epamLastTask.repositories.OrderRepo;
import com.epamLastTask.repositories.UserRepo;
import com.epamLastTask.service.OrderService;
import com.epamLastTask.service.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    UserRepo userRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public void removeOrder(User user, Order order) {
        User usr = userRepo.findUserById(user.getId());
        order.getUser().remove(usr);

        orderRepo.save(order);

    }

    @Override
    public void createOrder(MultipartFile[] file, Order order) throws IOException {
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
    }

    @Override
    public void addOrderToCard(Order order, User user) {
        if(order.isActive()){
            order.getUser().add(user);
            orderRepo.save(order);
        }
    }

    @Override
    public boolean currentUserHaveThisOrder(User user, Order order) {
        user = userRepo.findUserById(user.getId());

        return order.getUser().contains(user);
    }
}
