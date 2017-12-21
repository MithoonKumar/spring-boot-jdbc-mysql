package com.example.demo.service;

import com.example.demo.model.user;
import com.example.demo.repo.repoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviceImpl implements serviceInt{

    @Autowired
    repoImpl repo;
    public user findUser(String name){
        return repo.getUserById(name);
    }
}

