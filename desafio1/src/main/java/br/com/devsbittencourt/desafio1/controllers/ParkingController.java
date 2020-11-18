package br.com.devsbittencourt.desafio1.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devsbittencourt.desafio1.models.Car;
import br.com.devsbittencourt.desafio1.models.Moto;

@RestController
public class ParkingController {
    private ArrayList parkingSpace = new ArrayList<>();
    private int vacancyAvaliable = 50;

    Car car = new Car();
    Moto moto = new Moto();

    @RequestMapping(path = "/parking", method = RequestMethod.GET)
    public String parking(@RequestParam(value = "veiculo", defaultValue = "Veiculo") String veiculo,
            HttpSession session) {
        session.setAttribute("parkingSpace", parkingSpace);
        session.setAttribute("vacancyAvaliable", vacancyAvaliable);

        if (parkingSpace.size() < 50 && vacancyAvaliable > 0) {
            if (veiculo.equalsIgnoreCase("moto")) {
                moto.setVehicleType("moto");
                parkingSpace.add("moto");
                parkingSpace.add("moto");
                vacancyAvaliable -= parkingSpace.size();
            }
            if (veiculo.equalsIgnoreCase("carro")) {
                car.setVehicleType("carro");
                parkingSpace.add("carro");
                parkingSpace.add("carro");
                parkingSpace.add("carro");
                parkingSpace.add("carro");
                vacancyAvaliable -= parkingSpace.size();
                // parkingSpace.add(car.getVehicleType());
                // parkingSpace.add(car.getVehicleType());
                // parkingSpace.add(car.getVehicleType());
                // parkingSpace.add(car.getVehicleType());
            }

        } else {
            return "Estacionamento cheio";
        }
        vacancyAvaliable -= parkingSpace.size();
        System.out.print(parkingSpace);
        System.out.print(parkingSpace.size());
        System.out.println(vacancyAvaliable);
        return "Veículo adicionado do tipo " + veiculo.toUpperCase() + " foi adicionado ";
    }

    @RequestMapping(path = "/vacancies", method = RequestMethod.GET)
    @ResponseBody
    public String vacancies(HttpServletRequest request) {
        ArrayList attributePark = (ArrayList) request.getSession().getAttribute("parkingSpace");
        ArrayList sessionPark = attributePark;
        int attributeVacancy = (int) request.getSession().getAttribute("vacancyAvaliable");
        int sessionVacancy = attributeVacancy;

        if (sessionVacancy < 0) {
            sessionVacancy = 0;
        }

        return "Vagas disponíveis = " + vacancyAvaliable + " | Vagas ocupadas = " + parkingSpace.size();
    }

    @RequestMapping(path = "/remove-vacancy", method = RequestMethod.GET)
    @ResponseBody
    public String removeVacancy(@RequestParam(value = "remove", defaultValue = "Veiculo") int veiculo,
            HttpServletRequest request) {
        ArrayList sessionPark = (ArrayList) request.getSession().getAttribute("parkingSpace");
        Object index = sessionPark.get(veiculo);

        for (int i = 0; i < sessionPark.size(); i++) {
            System.out.println(sessionPark.get(i));

        }

        if (sessionPark.isEmpty()) {
            return "Sem veículos";
        }

        // try {
        // if (sessionPark.contains(index)) {

        // } else {
        // return "Vaga disponível.";
        // }
        // } catch (Exception e) {
        // return e.getMessage();
        // }
        return "Veículos: " + sessionPark;

    }
}