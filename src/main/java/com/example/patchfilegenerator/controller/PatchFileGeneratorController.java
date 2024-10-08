package com.example.patchfilegenerator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatchFileGeneratorController {

    @GetMapping("/")
    public String returnMe(){
        return "index";
    }

}
