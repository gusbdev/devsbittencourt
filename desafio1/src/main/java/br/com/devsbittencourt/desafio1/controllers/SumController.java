package br.com.devsbittencourt.desafio1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumController {

    @RequestMapping(path = "/sum/{value1}/{value2}", method = RequestMethod.GET)
    public int sumController(@PathVariable int value1, @PathVariable int value2){
       return value1 + value2;
    }
}
