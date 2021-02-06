package br.com.filipe.teste.filipe_teste.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-status")
public class StatusController {


    @GetMapping("/status")
    public String check(){
        return "Online";
    }

}
