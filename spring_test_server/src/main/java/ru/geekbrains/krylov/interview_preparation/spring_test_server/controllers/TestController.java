package ru.geekbrains.krylov.interview_preparation.spring_test_server.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class TestController {

    @GetMapping
    public String getHello(@RequestParam(name = "name", required = false, defaultValue = "USER") String name) {
        return "Hello " + name + " from GET_MAPPER";
    }

    @PostMapping
    public String postHello(@RequestParam(name = "name", required = false, defaultValue = "USER") String name) {
        return "Hello " + name + " from POST_MAPPER";
    }
}
