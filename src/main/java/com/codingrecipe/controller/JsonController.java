package com.codingrecipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/json")
public class JsonController {

    @PostMapping("/date")
    public List<Map<String, String>> date(@RequestBody Map<String, String> map){


        System.out.println(map.get("startDate"));
        List<Map<String, String>> list = new ArrayList<>();
        list.add(map);
        list.add(map);
        list.add(map);
        list.add(map);


        return list;
    }


}
