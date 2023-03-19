package com.example;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(path = "/")
public class TurboViewController {

    private final List<Todo> viewOneTodos;

    public TurboViewController(@Qualifier("viewOneTodos") List<Todo> viewOneTodos) {
        this.viewOneTodos = viewOneTodos;
    }

    @GetMapping(path = "/view1")
    public String index(Model model, HttpServletRequest request) {
        model.addAttribute("url", request.getRequestURI());
        model.addAttribute("name", "Krystian");
        model.addAttribute("todos", viewOneTodos);
        return "index";
    }

    @PostMapping(path = "/view1", produces = "text/vnd.turbo-stream.html")
    public ModelAndView indexAdd(String todo, HttpServletRequest request){
        Todo newTodo = new Todo(UUID.randomUUID(), todo);
        viewOneTodos.add(newTodo);

        ModelAndView modelAndView = new ModelAndView("new-todo");
        modelAndView.addObject("id", newTodo.id);
        modelAndView.addObject("todo", newTodo.todo);
        modelAndView.addObject("url", request.getRequestURI());
        return modelAndView;
    }

    @GetMapping(path = "/view2")
    public String index2(Model model) {
        model.addAttribute("name", "Michal");
        return "index2";
    }

    @DeleteMapping(value = "/view1/{id}")
    public ModelAndView delete(@PathVariable UUID id) {
        viewOneTodos.removeIf(it -> it.id.equals(id));

        ModelAndView render = new ModelAndView("delete-todo");
        render.addObject("id", id);
        return render;
    }

}
