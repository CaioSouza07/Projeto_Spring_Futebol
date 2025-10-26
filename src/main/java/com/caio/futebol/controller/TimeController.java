package com.caio.futebol.controller;

import com.caio.futebol.service.TimeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/times")
public class TimeController {

    private final TimeService timeService;

    public TimeController(TimeService timeService){
        this.timeService = timeService;
    }

    @GetMapping
    public ModelAndView index(){
        var mv = new ModelAndView("time/index");
        var listaTimes = timeService.findAll();
        mv.addObject("times", listaTimes);
        return mv;
    }

}
