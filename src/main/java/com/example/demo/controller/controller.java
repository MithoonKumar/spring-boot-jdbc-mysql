package com.example.demo.controller;

import com.example.demo.model.user;
import com.example.demo.service.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class controller {
    @Autowired
    serviceImpl service ;


    @RequestMapping(value="/{name}",method= RequestMethod.GET)
    @ResponseBody
    public String firstRest(@PathVariable String name){
        return service.findUser(name).getLastName();
    }


}
