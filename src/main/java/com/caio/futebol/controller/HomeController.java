package com.caio.futebol.controller;

import com.caio.futebol.entity.Time;
import com.caio.futebol.service.TimeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/futclub")
public class HomeController {

    private final TimeService timeService;

    public HomeController(TimeService timeService){
        this.timeService = timeService;
    }

    @GetMapping
    public String home(){
        return "index";
    }



}
