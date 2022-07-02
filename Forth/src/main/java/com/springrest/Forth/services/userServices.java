package com.springrest.Forth.services;

import com.springrest.Forth.VO.ResponseTemplateVO;
import com.springrest.Forth.entity.User;
import com.springrest.Forth.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServices {
    @Autowired
    private userRepository userRepo;

    public User saveUser(User u) {
        return userRepo.save(u);
    }

    public ResponseTemplateVO getById(int uid) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User u = userRepo.getById(uid);
        return vo;
    }
}
