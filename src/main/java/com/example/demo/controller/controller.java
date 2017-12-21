package com.example.demo.controller;

import com.example.demo.model.user;
import com.example.demo.service.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class controller {
    @Autowired
    serviceImpl service ;


    @RequestMapping(value="view/{name}",method= RequestMethod.GET)
    @ResponseBody
    public String firstRest(@PathVariable String name){
        return service.findUser(name).getLastName();
    }

    @RequestMapping(value="add/{firstName}/{lastName}",method= RequestMethod.GET)
    @ResponseBody
    public String secondRest(@PathVariable String firstName,@PathVariable String lastName){
        user tempUser = new user();
        tempUser.setFirstName(firstName);
        tempUser.setLastName(lastName);
        service.addUser(tempUser);
        return "success";
    }

    @RequestMapping(value="/viewall",method= RequestMethod.GET)
    @ResponseBody
    public String thirdRest(){
        List<user> list = service.getAllUsers();
        String str="";
        for(int i=0;i<list.size();i++){
            str+=list.get(i).getFirstName();
            str+=list.get(i).getLastName();
        }
        return str;
    }


}
