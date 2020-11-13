package br.com.devsbittencourt.desafio1.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactorialController {

    @RequestMapping(path = "/factorial/{num}", method = RequestMethod.GET)
    public String factorialController(@PathVariable int num){
        int fat = 1;
        for(int i = 1; i <= num; i++){
            fat *= i;
        }
        
        return "O fatorial de " + num + " é " + fat;
    }
}
