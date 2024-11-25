package com.example.bakery.controller.functionalities;

import com.example.bakery.dtos.functionalitiesdtos.ConsultaEstoqueIngredienteDTO;
import com.example.bakery.repositories.entities.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("padaria")
public class CustomIngredienteProximoExpirarController {

    @Autowired
    IngredienteRepository ingredienteRepository;

    @GetMapping("ingrediente-proximo-expirar-custom")
    public List<ConsultaEstoqueIngredienteDTO> getIngredienteProximoExpirar(@RequestParam String format, @RequestParam Integer number){
        LocalDate currentDate = LocalDate.now();
        Date date = Date.valueOf(currentDate);
        //Default give us inside 1 week
        LocalDate paramFuture = switch (format) {
            case "days" -> currentDate.plusDays(number);
            case "weeks" -> currentDate.plusWeeks(number);
            case "months" -> currentDate.plusMonths(number);
            default -> currentDate.plusDays(7);
        };
        Date futureDate = Date.valueOf(paramFuture);
        return ingredienteRepository.getCustomIngredienteProximoExpirar(date, futureDate);
    }

}
