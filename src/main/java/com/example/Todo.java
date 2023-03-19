package com.example;

import java.util.UUID;

public class Todo {

    final UUID id;
    final String todo;

    public Todo(UUID id, String todo) {
        this.id = id;
        this.todo = todo;
    }

    @Override
    public String toString() {
        return "Todo{" +
               "id=" + id +
               ", name='" + todo + '\'' +
               '}';
    }
}
