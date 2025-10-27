package com.caio.futebol.controller;

import com.caio.futebol.dto.CriarTimeRequest;
import com.caio.futebol.dto.EditarTimeRequest;
import com.caio.futebol.service.TimeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/times")
public class TimeController {

    private final TimeService timeService;

    public TimeController(TimeService timeService){
        this.timeService = timeService;
    }

    // aqui é pra mostrar os cards dos times
    @GetMapping
    public ModelAndView index(){
        var mv = new ModelAndView("time/index");
        var listaTimes = timeService.findAll();
        mv.addObject("times", listaTimes);
        return mv;
    }

    //aqui ele mostra o formulario vazio pro usuario preencher
    @GetMapping("/criar")
    public ModelAndView criar(){
        var mv = new ModelAndView("time/criar_time");
        mv.addObject("criarTimeRequest", new CriarTimeRequest(null, null, null, null, null, null, null, null));
        return mv;
    }

    //aqui é quando o usuario preenche
    @PostMapping("/criar")
    public ModelAndView criar(@ModelAttribute CriarTimeRequest request){
        ModelAndView mv;
        try {
            var time = timeService.criar(request);
            return new ModelAndView("redirect:/times");
        } catch (Exception e) {
            mv = new ModelAndView("time/criar_time");
            mv.addObject("criarTimeRequest", request);
            mv.addObject("erro", e.getMessage());
            return mv;
        }
    }

    //aqui pra deletar
    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable("id") Long id){
        timeService.deleteById(id);
        return "redirect:/times";
    }

    //aqui vou fazer para visualizar o time
    @GetMapping("/{id}")
    public ModelAndView visualizar(@PathVariable("id") Long id){
        var optional = timeService.findById(id);
        if(optional.isEmpty()){
            return new ModelAndView("time/sem_times");
        }
        var mv = new ModelAndView("time/visualizar_time");
        mv.addObject("time",optional.get());
        return mv;
    }

    // fazer aqui quando usuario acessa pagina para editar
    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id){
        var opcional = timeService.findById(id);
        if(opcional.isEmpty()){
            return new ModelAndView("time/sem_times");
        }
        var mv = new ModelAndView("editar_time");
        var time = opcional.get();
        var request = new EditarTimeRequest(
                time.getId(),
                time.getNome(),
                time.getCidade(),
                time.getEstado(),
                time.getPais(),
                time.getAnoFundacao(),
                time.getEstadio(),
                time.getLiga(),
                time.getEmblema()
        );
        mv.addObject("editarTimeRequest", request);
        return mv;
    }

    //aqui vou fazer quando o usuario salva a edicao POST
    @PostMapping("/editar")
    public ModelAndView editar(@ModelAttribute EditarTimeRequest request){
        ModelAndView mv;
        try{
            var time = timeService.editar(request);
            return new ModelAndView("redirect: /times/" + time.getId());
        } catch (Exception e) {
            mv = new ModelAndView("time/editar_time");
            mv.addObject("editarTimeRequest", request);
            mv.addObject("erro", e.getMessage());
            return mv;
        }
    }

}
