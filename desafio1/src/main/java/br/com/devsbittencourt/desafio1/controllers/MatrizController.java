package br.com.devsbittencourt.desafio1.controllers;

import java.util.Random;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatrizController {

    @RequestMapping(path = "/matriz/{value1}/{value2}", method = RequestMethod.GET)
    @ResponseBody
    public void matriz(@PathVariable int value1, @PathVariable int value2){
        int[][] matriz = new int[value1][value2]; 
        Random rnd = new Random(); //Alimenta a matriz com valores aleatórios 
        for (int i = 0; i<value1; i++) { 
            for (int j = 0; j<value2; j++) { 
                matriz[i][j] = rnd.nextInt(100);
            } 
        } //Imprime os valores da matriz 
        for (int i = 0; i<value1; i++) { 
            for (int j = 0; j<value2; j++) { 
                System.out.println(matriz[i][j]);
            }
        }   
    }
}
