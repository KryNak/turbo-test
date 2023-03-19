package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Persistence {

    @Bean(name = "viewOneTodos")
    public List<Todo> viewOneTodos() {
        return new ArrayList<>();
    }

}
