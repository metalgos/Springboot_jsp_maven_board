package com.codingrecipe.controller;

import com.codingrecipe.dto.FoodDTO;
import com.codingrecipe.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final ApiService apiService;

    @PostMapping("/foodserch")
    public String foodserch(String food, Model model){

    List<FoodDTO> foodDTO = apiService.foodserch(food);
    model.addAttribute("food",foodDTO);

    return "foodlist";

    }

}
